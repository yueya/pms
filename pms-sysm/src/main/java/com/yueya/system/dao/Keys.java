/*
 * This file is generated by jOOQ.
 */
package com.yueya.system.dao;


import com.yueya.system.dao.tables.SysArea;
import com.yueya.system.dao.tables.SysDict;
import com.yueya.system.dao.tables.SysLog;
import com.yueya.system.dao.tables.SysMenu;
import com.yueya.system.dao.tables.SysOrganization;
import com.yueya.system.dao.tables.SysPermission;
import com.yueya.system.dao.tables.SysRole;
import com.yueya.system.dao.tables.SysRoleMenu;
import com.yueya.system.dao.tables.SysRoleOrg;
import com.yueya.system.dao.tables.SysRolePermission;
import com.yueya.system.dao.tables.SysSystem;
import com.yueya.system.dao.tables.SysUser;
import com.yueya.system.dao.tables.SysUserRole;
import com.yueya.system.dao.tables.records.SysAreaRecord;
import com.yueya.system.dao.tables.records.SysDictRecord;
import com.yueya.system.dao.tables.records.SysLogRecord;
import com.yueya.system.dao.tables.records.SysMenuRecord;
import com.yueya.system.dao.tables.records.SysOrganizationRecord;
import com.yueya.system.dao.tables.records.SysPermissionRecord;
import com.yueya.system.dao.tables.records.SysRoleMenuRecord;
import com.yueya.system.dao.tables.records.SysRoleOrgRecord;
import com.yueya.system.dao.tables.records.SysRolePermissionRecord;
import com.yueya.system.dao.tables.records.SysRoleRecord;
import com.yueya.system.dao.tables.records.SysSystemRecord;
import com.yueya.system.dao.tables.records.SysUserRecord;
import com.yueya.system.dao.tables.records.SysUserRoleRecord;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>pms</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<SysAreaRecord, Long> IDENTITY_SYS_AREA = Identities0.IDENTITY_SYS_AREA;
    public static final Identity<SysDictRecord, Long> IDENTITY_SYS_DICT = Identities0.IDENTITY_SYS_DICT;
    public static final Identity<SysLogRecord, Long> IDENTITY_SYS_LOG = Identities0.IDENTITY_SYS_LOG;
    public static final Identity<SysMenuRecord, Long> IDENTITY_SYS_MENU = Identities0.IDENTITY_SYS_MENU;
    public static final Identity<SysOrganizationRecord, Long> IDENTITY_SYS_ORGANIZATION = Identities0.IDENTITY_SYS_ORGANIZATION;
    public static final Identity<SysPermissionRecord, Long> IDENTITY_SYS_PERMISSION = Identities0.IDENTITY_SYS_PERMISSION;
    public static final Identity<SysRoleRecord, Long> IDENTITY_SYS_ROLE = Identities0.IDENTITY_SYS_ROLE;
    public static final Identity<SysRoleMenuRecord, Long> IDENTITY_SYS_ROLE_MENU = Identities0.IDENTITY_SYS_ROLE_MENU;
    public static final Identity<SysRolePermissionRecord, Long> IDENTITY_SYS_ROLE_PERMISSION = Identities0.IDENTITY_SYS_ROLE_PERMISSION;
    public static final Identity<SysSystemRecord, Long> IDENTITY_SYS_SYSTEM = Identities0.IDENTITY_SYS_SYSTEM;
    public static final Identity<SysUserRecord, Long> IDENTITY_SYS_USER = Identities0.IDENTITY_SYS_USER;
    public static final Identity<SysUserRoleRecord, Long> IDENTITY_SYS_USER_ROLE = Identities0.IDENTITY_SYS_USER_ROLE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<SysAreaRecord> KEY_SYS_AREA_PRIMARY = UniqueKeys0.KEY_SYS_AREA_PRIMARY;
    public static final UniqueKey<SysDictRecord> KEY_SYS_DICT_PRIMARY = UniqueKeys0.KEY_SYS_DICT_PRIMARY;
    public static final UniqueKey<SysLogRecord> KEY_SYS_LOG_PRIMARY = UniqueKeys0.KEY_SYS_LOG_PRIMARY;
    public static final UniqueKey<SysMenuRecord> KEY_SYS_MENU_PRIMARY = UniqueKeys0.KEY_SYS_MENU_PRIMARY;
    public static final UniqueKey<SysOrganizationRecord> KEY_SYS_ORGANIZATION_PRIMARY = UniqueKeys0.KEY_SYS_ORGANIZATION_PRIMARY;
    public static final UniqueKey<SysPermissionRecord> KEY_SYS_PERMISSION_PRIMARY = UniqueKeys0.KEY_SYS_PERMISSION_PRIMARY;
    public static final UniqueKey<SysRoleRecord> KEY_SYS_ROLE_PRIMARY = UniqueKeys0.KEY_SYS_ROLE_PRIMARY;
    public static final UniqueKey<SysRoleMenuRecord> KEY_SYS_ROLE_MENU_PRIMARY = UniqueKeys0.KEY_SYS_ROLE_MENU_PRIMARY;
    public static final UniqueKey<SysRoleOrgRecord> KEY_SYS_ROLE_ORG_PRIMARY = UniqueKeys0.KEY_SYS_ROLE_ORG_PRIMARY;
    public static final UniqueKey<SysRolePermissionRecord> KEY_SYS_ROLE_PERMISSION_PRIMARY = UniqueKeys0.KEY_SYS_ROLE_PERMISSION_PRIMARY;
    public static final UniqueKey<SysSystemRecord> KEY_SYS_SYSTEM_PRIMARY = UniqueKeys0.KEY_SYS_SYSTEM_PRIMARY;
    public static final UniqueKey<SysUserRecord> KEY_SYS_USER_PRIMARY = UniqueKeys0.KEY_SYS_USER_PRIMARY;
    public static final UniqueKey<SysUserRoleRecord> KEY_SYS_USER_ROLE_PRIMARY = UniqueKeys0.KEY_SYS_USER_ROLE_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<SysAreaRecord, Long> IDENTITY_SYS_AREA = Internal.createIdentity(SysArea.SYS_AREA, SysArea.SYS_AREA.ID);
        public static Identity<SysDictRecord, Long> IDENTITY_SYS_DICT = Internal.createIdentity(SysDict.SYS_DICT, SysDict.SYS_DICT.ID);
        public static Identity<SysLogRecord, Long> IDENTITY_SYS_LOG = Internal.createIdentity(SysLog.SYS_LOG, SysLog.SYS_LOG.ID);
        public static Identity<SysMenuRecord, Long> IDENTITY_SYS_MENU = Internal.createIdentity(SysMenu.SYS_MENU, SysMenu.SYS_MENU.ID);
        public static Identity<SysOrganizationRecord, Long> IDENTITY_SYS_ORGANIZATION = Internal.createIdentity(SysOrganization.SYS_ORGANIZATION, SysOrganization.SYS_ORGANIZATION.ID);
        public static Identity<SysPermissionRecord, Long> IDENTITY_SYS_PERMISSION = Internal.createIdentity(SysPermission.SYS_PERMISSION, SysPermission.SYS_PERMISSION.ID);
        public static Identity<SysRoleRecord, Long> IDENTITY_SYS_ROLE = Internal.createIdentity(SysRole.SYS_ROLE, SysRole.SYS_ROLE.ID);
        public static Identity<SysRoleMenuRecord, Long> IDENTITY_SYS_ROLE_MENU = Internal.createIdentity(SysRoleMenu.SYS_ROLE_MENU, SysRoleMenu.SYS_ROLE_MENU.ID);
        public static Identity<SysRolePermissionRecord, Long> IDENTITY_SYS_ROLE_PERMISSION = Internal.createIdentity(SysRolePermission.SYS_ROLE_PERMISSION, SysRolePermission.SYS_ROLE_PERMISSION.ID);
        public static Identity<SysSystemRecord, Long> IDENTITY_SYS_SYSTEM = Internal.createIdentity(SysSystem.SYS_SYSTEM, SysSystem.SYS_SYSTEM.ID);
        public static Identity<SysUserRecord, Long> IDENTITY_SYS_USER = Internal.createIdentity(SysUser.SYS_USER, SysUser.SYS_USER.ID);
        public static Identity<SysUserRoleRecord, Long> IDENTITY_SYS_USER_ROLE = Internal.createIdentity(SysUserRole.SYS_USER_ROLE, SysUserRole.SYS_USER_ROLE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<SysAreaRecord> KEY_SYS_AREA_PRIMARY = Internal.createUniqueKey(SysArea.SYS_AREA, "KEY_sys_area_PRIMARY", SysArea.SYS_AREA.ID);
        public static final UniqueKey<SysDictRecord> KEY_SYS_DICT_PRIMARY = Internal.createUniqueKey(SysDict.SYS_DICT, "KEY_sys_dict_PRIMARY", SysDict.SYS_DICT.ID);
        public static final UniqueKey<SysLogRecord> KEY_SYS_LOG_PRIMARY = Internal.createUniqueKey(SysLog.SYS_LOG, "KEY_sys_log_PRIMARY", SysLog.SYS_LOG.ID);
        public static final UniqueKey<SysMenuRecord> KEY_SYS_MENU_PRIMARY = Internal.createUniqueKey(SysMenu.SYS_MENU, "KEY_sys_menu_PRIMARY", SysMenu.SYS_MENU.ID);
        public static final UniqueKey<SysOrganizationRecord> KEY_SYS_ORGANIZATION_PRIMARY = Internal.createUniqueKey(SysOrganization.SYS_ORGANIZATION, "KEY_sys_organization_PRIMARY", SysOrganization.SYS_ORGANIZATION.ID);
        public static final UniqueKey<SysPermissionRecord> KEY_SYS_PERMISSION_PRIMARY = Internal.createUniqueKey(SysPermission.SYS_PERMISSION, "KEY_sys_permission_PRIMARY", SysPermission.SYS_PERMISSION.ID);
        public static final UniqueKey<SysRoleRecord> KEY_SYS_ROLE_PRIMARY = Internal.createUniqueKey(SysRole.SYS_ROLE, "KEY_sys_role_PRIMARY", SysRole.SYS_ROLE.ID);
        public static final UniqueKey<SysRoleMenuRecord> KEY_SYS_ROLE_MENU_PRIMARY = Internal.createUniqueKey(SysRoleMenu.SYS_ROLE_MENU, "KEY_sys_role_menu_PRIMARY", SysRoleMenu.SYS_ROLE_MENU.ID);
        public static final UniqueKey<SysRoleOrgRecord> KEY_SYS_ROLE_ORG_PRIMARY = Internal.createUniqueKey(SysRoleOrg.SYS_ROLE_ORG, "KEY_sys_role_org_PRIMARY", SysRoleOrg.SYS_ROLE_ORG.ROLE_ID, SysRoleOrg.SYS_ROLE_ORG.ORG_ID);
        public static final UniqueKey<SysRolePermissionRecord> KEY_SYS_ROLE_PERMISSION_PRIMARY = Internal.createUniqueKey(SysRolePermission.SYS_ROLE_PERMISSION, "KEY_sys_role_permission_PRIMARY", SysRolePermission.SYS_ROLE_PERMISSION.ID);
        public static final UniqueKey<SysSystemRecord> KEY_SYS_SYSTEM_PRIMARY = Internal.createUniqueKey(SysSystem.SYS_SYSTEM, "KEY_sys_system_PRIMARY", SysSystem.SYS_SYSTEM.ID);
        public static final UniqueKey<SysUserRecord> KEY_SYS_USER_PRIMARY = Internal.createUniqueKey(SysUser.SYS_USER, "KEY_sys_user_PRIMARY", SysUser.SYS_USER.ID);
        public static final UniqueKey<SysUserRoleRecord> KEY_SYS_USER_ROLE_PRIMARY = Internal.createUniqueKey(SysUserRole.SYS_USER_ROLE, "KEY_sys_user_role_PRIMARY", SysUserRole.SYS_USER_ROLE.ID);
    }
}
