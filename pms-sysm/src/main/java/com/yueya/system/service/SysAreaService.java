package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.common.util.DateUtils;
import com.yueya.system.dao.tables.SysArea;
import com.yueya.system.dao.tables.daos.SysAreaDao;
import com.yueya.system.dao.tables.pojos.SysAreaDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SysAreaService extends BaseService<SysAreaDO> {

    @Autowired
    private SysAreaDao areaDao;
    @Override
    public List<Condition> getConditions(SysAreaDO sysAreaDO) {
        Condition condition = SysArea.SYS_AREA.DEL_FLAG.eq(DEL_FLAG_NORMAL);
        return Collections.singletonList(condition);
    }

    public void insert(SysAreaDO sysAreaDO){
        SysAreaDO parent = areaDao.fetchOneById(Long.valueOf(sysAreaDO.getParentId()));
        sysAreaDO.setDelFlag(DEL_FLAG_NORMAL);
        String pIds = parent.getParentIds()==null?(","+parent.getId()+",") : (parent.getParentIds()+parent.getId()+",");
        sysAreaDO.setParentIds(pIds);
        sysAreaDO.setGmtCreate(DateUtils.getCurTimeStamp());
        areaDao.insert(sysAreaDO);
    }

    public void update(SysAreaDO sysAreaDO){
        sysAreaDO.setGmtModified(DateUtils.getCurTimeStamp());
        areaDao.update(sysAreaDO);
    }

    /**
     * 逻辑删除，设置删除标记
     * @param
     */
    public void delete(String id){
        Condition condition = SysArea.SYS_AREA.ID.eq(Long.valueOf(id))
                .or(SysArea.SYS_AREA.PARENT_IDS.like("%,"+id+",%"));
        SysAreaDO areaDO = new SysAreaDO();
        areaDO.setDelFlag(DEL_FLAG_DEL);
        areaDO.setGmtModified(DateUtils.getCurTimeStamp());
        areaDao.updateByCondition(areaDO,condition);
    }

    public List<SysAreaDO> findAll() {
        Condition condition = SysArea.SYS_AREA.DEL_FLAG.eq(DEL_FLAG_NORMAL);
        return areaDao.fetchByCondition(condition);
    }
}
