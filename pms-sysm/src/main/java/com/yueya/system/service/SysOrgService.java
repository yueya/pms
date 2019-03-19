package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.SysOrganization;
import com.yueya.system.dao.tables.daos.SysOrganizationDao;
import com.yueya.system.dao.tables.pojos.SysOrganizationDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrgService extends BaseService<SysOrganizationDO> {

    @Autowired
    private SysOrganizationDao dao;
    @Override
    public List<Condition> getConditions(SysOrganizationDO sysOrganizationDO) {
        return null;
    }

    public void insert(SysOrganizationDO organizationDO) {
        dao.insert(organizationDO);
    }

    public void update(SysOrganizationDO organizationDO) {
        dao.update(organizationDO);
    }

    public void delete(String id) {
        Condition condition = SysOrganization.SYS_ORGANIZATION.ID.eq(Long.valueOf(id))
                .and(SysOrganization.SYS_ORGANIZATION.PARENT_IDS.like("%,"+id+",%"));
        SysOrganizationDO organizationDO = new SysOrganizationDO();
        organizationDO.setDefFlag(DEL_FLAG_DEL);
        dao.updateByCondition(organizationDO,condition);
    }

    public List<SysOrganizationDO> findAll() {
        Condition condition = SysOrganization.SYS_ORGANIZATION.DEF_FLAG.eq(DEL_FLAG_NORMAL);
        return dao.fetchByCondition(condition);
    }

}
