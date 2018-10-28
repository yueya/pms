package com.yueya.codegen.util.custom;

import com.yueya.common.base.BaseDao;
import org.jooq.Configuration;
import org.jooq.Constants;
import org.jooq.Record;
import org.jooq.codegen.GeneratorStrategy;
import org.jooq.codegen.JavaGenerator;
import org.jooq.codegen.JavaWriter;
import org.jooq.meta.*;

import java.util.Arrays;
import java.util.List;

public class CustomGenerator extends JavaGenerator {
    private boolean scala=false;

    @Override
    protected void generateDaoClassFooter(TableDefinition table, JavaWriter out) {
        super.generateDaoClassFooter(table, out);
    }


    @Override
    protected void generateDao(TableDefinition table, JavaWriter out) {
        UniqueKeyDefinition key = table.getPrimaryKey();
        if (key == null) {
            return;
        }

        final String className = getStrategy().getJavaClassName(table, GeneratorStrategy.Mode.DAO);
        final List<String> interfaces = out.ref(getStrategy().getJavaClassImplements(table, GeneratorStrategy.Mode.DAO));
        final String tableRecord = out.ref(getStrategy().getFullJavaClassName(table, GeneratorStrategy.Mode.RECORD));
        final String daoImpl = out.ref(BaseDao.class);
        final String tableIdentifier = ref(getStrategy().getFullJavaIdentifier(table), 2);

        String tType = "Void";
        String pType = out.ref(getStrategy().getFullJavaClassName(table, GeneratorStrategy.Mode.POJO));

        List<ColumnDefinition> keyColumns = key.getKeyColumns();

        if (keyColumns.size() == 1) {
            tType = getJavaType(keyColumns.get(0).getType(resolver()), GeneratorStrategy.Mode.POJO);
        }
        else if (keyColumns.size() <= Constants.MAX_ROW_DEGREE) {
            String generics = "";
            String separator = "";

            for (ColumnDefinition column : keyColumns) {
                generics += separator + out.ref(getJavaType(column.getType(resolver())));
                separator = ", ";
            }

            if (scala)
                tType = Record.class.getName() + keyColumns.size() + "[" + generics + "]";
            else
                tType = Record.class.getName() + keyColumns.size() + "<" + generics + ">";
        }
        else {
            tType = Record.class.getName();
        }

        tType = out.ref(tType);

        printPackage(out, table, GeneratorStrategy.Mode.DAO);
        generateDaoClassJavadoc(table, out);
        printClassAnnotations(out, table.getSchema());

        if (generateSpringAnnotations())
            out.println("@%s", out.ref("org.springframework.stereotype.Repository"));

        if (scala)
            out.println("class %s(configuration : %s) extends %s[%s, %s, %s](%s, classOf[%s], configuration)[[before= with ][separator= with ][%s]] {",
                    className, Configuration.class, daoImpl, tableRecord, pType, tType, tableIdentifier, pType, interfaces);
        else
            out.println("public class %s extends %s<%s, %s, %s>[[before= implements ][%s]] {", className, daoImpl, tableRecord, pType, tType, interfaces);

        // Default constructor
        // -------------------
        out.tab(1).javadoc("Create a new %s without any configuration", className);

        if (scala) {
            out.tab(1).println("def this() = {");
            out.tab(2).println("this(null)");
            out.tab(1).println("}");
        }
        else {
            out.tab(1).println("public %s() {", className);
            out.tab(2).println("super(%s, %s.class);", tableIdentifier, pType);
            out.tab(1).println("}");
        }

        // Initialising constructor
        // ------------------------

        if (scala) {
        }
        else {
            out.tab(1).javadoc("Create a new %s with an attached configuration", className);

            if (generateSpringAnnotations())
                out.tab(1).println("@%s", out.ref("org.springframework.beans.factory.annotation.Autowired"));

            out.tab(1).println("public %s(%s configuration) {", className, Configuration.class);
            out.tab(2).println("super(%s, %s.class, configuration);", tableIdentifier, pType);
            out.tab(1).println("}");
        }

        // Template method implementations
        // -------------------------------
        if (scala) {
            out.println();
            out.tab(1).println("override protected def getId(o : %s) : %s = {", pType, tType);
        }
        else {
            out.tab(1).overrideInherit();
            out.tab(1).println("protected %s getId(%s object) {", tType, pType);
        }

        if (keyColumns.size() == 1) {
            if (scala)
                out.tab(2).println("o.%s", getStrategy().getJavaGetterName(keyColumns.get(0), GeneratorStrategy.Mode.POJO));
            else
                out.tab(2).println("return object.%s();", getStrategy().getJavaGetterName(keyColumns.get(0), GeneratorStrategy.Mode.POJO));
        }

        // [#2574] This should be replaced by a call to a method on the target table's Key type
        else {
            String params = "";
            String separator = "";

            for (ColumnDefinition column : keyColumns) {
                if (scala)
                    params += separator + "o." + getStrategy().getJavaGetterName(column, GeneratorStrategy.Mode.POJO);
                else
                    params += separator + "object." + getStrategy().getJavaGetterName(column, GeneratorStrategy.Mode.POJO) + "()";

                separator = ", ";
            }

            if (scala)
                out.tab(2).println("compositeKeyRecord(%s)", params);
            else
                out.tab(2).println("return compositeKeyRecord(%s);", params);
        }

        out.tab(1).println("}");

        for (ColumnDefinition column : table.getColumns()) {
            final String colName = column.getOutputName();
            final String colClass = getStrategy().getJavaClassName(column);
            final String colTypeFull = getJavaType(column.getType(resolver()));
            final String colType = out.ref(colTypeFull);
            final String colIdentifier = ref(getStrategy().getFullJavaIdentifier(column), colRefSegments(column));

            // fetchBy[Column]([T]...)
            // -----------------------
            if (!printDeprecationIfUnknownType(out, colTypeFull))
                out.tab(1).javadoc("Fetch records that have <code>%s IN (values)</code>", colName);

            if (scala) {
                out.tab(1).println("def fetchBy%s(values : %s*) : %s[%s] = {", colClass, colType, List.class, pType);
                out.tab(2).println("fetch(%s, values:_*)", colIdentifier);
                out.tab(1).println("}");
            }
            else {
                out.tab(1).println("public %s<%s> fetchBy%s(%s... values) {", List.class, pType, colClass, colType);
                out.tab(2).println("return fetch(%s, values);", colIdentifier);
                out.tab(1).println("}");
            }

            // fetchOneBy[Column]([T])
            // -----------------------
            ukLoop:
            for (UniqueKeyDefinition uk : column.getUniqueKeys()) {

                // If column is part of a single-column unique key...
                if (uk.getKeyColumns().size() == 1 && uk.getKeyColumns().get(0).equals(column)) {
                    if (!printDeprecationIfUnknownType(out, colTypeFull))
                        out.tab(1).javadoc("Fetch a unique record that has <code>%s = value</code>", colName);

                    out.tab(1).println("public %s fetchOneBy%s(%s value) {", pType, colClass, colType);
                    out.tab(2).println("return fetchOne(%s, value);", colIdentifier);
                    out.tab(1).println("}");

                    break ukLoop;
                }
            }
        }

        generateDaoClassFooter(table, out);
        out.println("}");
    }
    private boolean printDeprecationIfUnknownType(JavaWriter out, String type) {
        return printDeprecationIfUnknownType(out, type, 1);
    }
    private boolean printDeprecationIfUnknownType(JavaWriter out, String type, int indentation) {
        if (generateDeprecationOnUnknownTypes() && "java.lang.Object".equals(type)) {
            out.tab(indentation).javadoc("@deprecated Unknown data type. "
                    + "Please define an explicit {@link org.jooq.Binding} to specify how this "
                    + "type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> "
                    + "in your code generator configuration.");
            out.tab(indentation).println("@java.lang.Deprecated");
            return true;
        }
        else {
            return false;
        }
    }

    protected String ref(String clazzOrId, int keepSegments){
        if(clazzOrId==null){
            return null;
        }else{
            return Arrays.asList(clazzOrId).get(0);
        }
    }
    private int colRefSegments(TypedElementDefinition<?> column) {
        if (column != null && column.getContainer() instanceof UDTDefinition)
            return 2;

        if (!getStrategy().getInstanceFields())
            return 2;

        return 3;
    }
}
