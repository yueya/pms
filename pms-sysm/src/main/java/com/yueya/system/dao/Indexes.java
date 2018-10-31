/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao;


import com.yueya.system.dao.tables.SysArea;
import com.yueya.system.dao.tables.SysDict;
import com.yueya.system.dao.tables.SysLog;
import com.yueya.system.dao.tables.SysMenu;
import com.yueya.system.dao.tables.SysPermission;
import com.yueya.system.dao.tables.SysRole;
import com.yueya.system.dao.tables.SysRoleMenu;
import com.yueya.system.dao.tables.SysRolePermission;
import com.yueya.system.dao.tables.SysSystem;
import com.yueya.system.dao.tables.SysUser;
import com.yueya.system.dao.tables.SysUserRole;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>pms</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index SYS_AREA_PRIMARY = Indexes0.SYS_AREA_PRIMARY;
    public static final Index SYS_AREA_SYS_AREA_DEL_FLAG = Indexes0.SYS_AREA_SYS_AREA_DEL_FLAG;
    public static final Index SYS_AREA_SYS_AREA_PARENT_ID = Indexes0.SYS_AREA_SYS_AREA_PARENT_ID;
    public static final Index SYS_DICT_PRIMARY = Indexes0.SYS_DICT_PRIMARY;
    public static final Index SYS_LOG_PRIMARY = Indexes0.SYS_LOG_PRIMARY;
    public static final Index SYS_LOG_SYS_LOG_CREATE_BY = Indexes0.SYS_LOG_SYS_LOG_CREATE_BY;
    public static final Index SYS_LOG_SYS_LOG_CREATE_DATE = Indexes0.SYS_LOG_SYS_LOG_CREATE_DATE;
    public static final Index SYS_LOG_SYS_LOG_REQUEST_URI = Indexes0.SYS_LOG_SYS_LOG_REQUEST_URI;
    public static final Index SYS_LOG_SYS_LOG_TYPE = Indexes0.SYS_LOG_SYS_LOG_TYPE;
    public static final Index SYS_MENU_PRIMARY = Indexes0.SYS_MENU_PRIMARY;
    public static final Index SYS_PERMISSION_PRIMARY = Indexes0.SYS_PERMISSION_PRIMARY;
    public static final Index SYS_ROLE_PRIMARY = Indexes0.SYS_ROLE_PRIMARY;
    public static final Index SYS_ROLE_MENU_PRIMARY = Indexes0.SYS_ROLE_MENU_PRIMARY;
    public static final Index SYS_ROLE_PERMISSION_PRIMARY = Indexes0.SYS_ROLE_PERMISSION_PRIMARY;
    public static final Index SYS_SYSTEM_PRIMARY = Indexes0.SYS_SYSTEM_PRIMARY;
    public static final Index SYS_USER_PRIMARY = Indexes0.SYS_USER_PRIMARY;
    public static final Index SYS_USER_SYS_USER_DEL_FLAG = Indexes0.SYS_USER_SYS_USER_DEL_FLAG;
    public static final Index SYS_USER_SYS_USER_DEPARTMENT_ID = Indexes0.SYS_USER_SYS_USER_DEPARTMENT_ID;
    public static final Index SYS_USER_SYS_USER_LOGIN_NAME = Indexes0.SYS_USER_SYS_USER_LOGIN_NAME;
    public static final Index SYS_USER_SYS_USER_ORGANIZATION_ID = Indexes0.SYS_USER_SYS_USER_ORGANIZATION_ID;
    public static final Index SYS_USER_ROLE_PRIMARY = Indexes0.SYS_USER_ROLE_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index SYS_AREA_PRIMARY = Internal.createIndex("PRIMARY", SysArea.SYS_AREA, new OrderField[] { SysArea.SYS_AREA.ID }, true);
        public static Index SYS_AREA_SYS_AREA_DEL_FLAG = Internal.createIndex("sys_area_del_flag", SysArea.SYS_AREA, new OrderField[] { SysArea.SYS_AREA.DEL_FLAG }, false);
        public static Index SYS_AREA_SYS_AREA_PARENT_ID = Internal.createIndex("sys_area_parent_id", SysArea.SYS_AREA, new OrderField[] { SysArea.SYS_AREA.PARENT_ID }, false);
        public static Index SYS_DICT_PRIMARY = Internal.createIndex("PRIMARY", SysDict.SYS_DICT, new OrderField[] { SysDict.SYS_DICT.ID }, true);
        public static Index SYS_LOG_PRIMARY = Internal.createIndex("PRIMARY", SysLog.SYS_LOG, new OrderField[] { SysLog.SYS_LOG.ID }, true);
        public static Index SYS_LOG_SYS_LOG_CREATE_BY = Internal.createIndex("sys_log_create_by", SysLog.SYS_LOG, new OrderField[] { SysLog.SYS_LOG.CREATE_BY }, false);
        public static Index SYS_LOG_SYS_LOG_CREATE_DATE = Internal.createIndex("sys_log_create_date", SysLog.SYS_LOG, new OrderField[] { SysLog.SYS_LOG.CREATE_DATE }, false);
        public static Index SYS_LOG_SYS_LOG_REQUEST_URI = Internal.createIndex("sys_log_request_uri", SysLog.SYS_LOG, new OrderField[] { SysLog.SYS_LOG.REQUEST_URI }, false);
        public static Index SYS_LOG_SYS_LOG_TYPE = Internal.createIndex("sys_log_type", SysLog.SYS_LOG, new OrderField[] { SysLog.SYS_LOG.TYPE }, false);
        public static Index SYS_MENU_PRIMARY = Internal.createIndex("PRIMARY", SysMenu.SYS_MENU, new OrderField[] { SysMenu.SYS_MENU.ID }, true);
        public static Index SYS_PERMISSION_PRIMARY = Internal.createIndex("PRIMARY", SysPermission.SYS_PERMISSION, new OrderField[] { SysPermission.SYS_PERMISSION.ID }, true);
        public static Index SYS_ROLE_PRIMARY = Internal.createIndex("PRIMARY", SysRole.SYS_ROLE, new OrderField[] { SysRole.SYS_ROLE.ID }, true);
        public static Index SYS_ROLE_MENU_PRIMARY = Internal.createIndex("PRIMARY", SysRoleMenu.SYS_ROLE_MENU, new OrderField[] { SysRoleMenu.SYS_ROLE_MENU.ID }, true);
        public static Index SYS_ROLE_PERMISSION_PRIMARY = Internal.createIndex("PRIMARY", SysRolePermission.SYS_ROLE_PERMISSION, new OrderField[] { SysRolePermission.SYS_ROLE_PERMISSION.ID }, true);
        public static Index SYS_SYSTEM_PRIMARY = Internal.createIndex("PRIMARY", SysSystem.SYS_SYSTEM, new OrderField[] { SysSystem.SYS_SYSTEM.ID }, true);
        public static Index SYS_USER_PRIMARY = Internal.createIndex("PRIMARY", SysUser.SYS_USER, new OrderField[] { SysUser.SYS_USER.ID }, true);
        public static Index SYS_USER_SYS_USER_DEL_FLAG = Internal.createIndex("sys_user_del_flag", SysUser.SYS_USER, new OrderField[] { SysUser.SYS_USER.DEL_FLAG }, false);
        public static Index SYS_USER_SYS_USER_DEPARTMENT_ID = Internal.createIndex("sys_user_department_id", SysUser.SYS_USER, new OrderField[] { SysUser.SYS_USER.DEPARTMENT_ID }, false);
        public static Index SYS_USER_SYS_USER_LOGIN_NAME = Internal.createIndex("sys_user_login_name", SysUser.SYS_USER, new OrderField[] { SysUser.SYS_USER.LOGIN_NAME }, false);
        public static Index SYS_USER_SYS_USER_ORGANIZATION_ID = Internal.createIndex("sys_user_organization_id", SysUser.SYS_USER, new OrderField[] { SysUser.SYS_USER.ORGANIZATION_ID }, false);
        public static Index SYS_USER_ROLE_PRIMARY = Internal.createIndex("PRIMARY", SysUserRole.SYS_USER_ROLE, new OrderField[] { SysUserRole.SYS_USER_ROLE.ID }, true);
    }
}
