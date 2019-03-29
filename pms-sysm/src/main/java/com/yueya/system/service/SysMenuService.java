package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.common.util.DateUtils;
import com.yueya.system.dao.tables.SysMenu;
import com.yueya.system.dao.tables.daos.SysMenuDao;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuService extends BaseService<SysMenuDO> {

    public final static String TYPE_MENU = "menu";
    public final static String TYPE_BUTTON = "button";

    @Autowired
    private SysMenuDao menuDao;
    public void insert(SysMenuDO menuDO){
        if(menuDO.getParentId() != null){
            SysMenuDO parent = menuDao.fetchOneById(Long.valueOf(menuDO.getParentId()));
            String pIds = parent.getParentIds()==null?(","+parent.getId()+",") : (parent.getParentIds()+parent.getId()+",");
            menuDO.setParentIds(pIds);
        }
        menuDO.setDelFlag(DEL_FLAG_NORMAL);
        menuDO.setGmtCreate(DateUtils.getCurTimeStamp());
        menuDao.insert(menuDO);
    }

    public void update(SysMenuDO menuDO){
        menuDO.setGmtModified(DateUtils.getCurTimeStamp());
        menuDao.update(menuDO);
    }

    /**
     * 逻辑删除，设置删除标记
     * @param
     */
    public void delete(String id){
        Condition condition = SysMenu.SYS_MENU.ID.eq(Long.valueOf(id))
                .or(SysMenu.SYS_MENU.PARENT_IDS.like("%,"+id+",%"));
        SysMenuDO menuDO = new SysMenuDO();
        menuDO.setDelFlag(DEL_FLAG_DEL);
        menuDO.setGmtModified(DateUtils.getCurTimeStamp());
        menuDao.updateByCondition(menuDO,condition);
    }

    /**
     * 根据用户角色 获取用户可以看到的菜单,按钮不需要返回
     * @param userId
     * @return
     */
    public List<SysMenuDO> list(String userId){
        return menuDao.fetchMenusByUserId(Long.valueOf(userId))
                .stream().filter(r -> TYPE_MENU.equals(r.getType()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Condition> getConditions(SysMenuDO menuDO) {
        return null;
    }

    public List<SysMenuDO> page(int offset, int limit, SysMenuDO menuDO) {
        return menuDao.page(offset,limit,getConditions(menuDO));
    }

    public List<SysMenuDO> findAll() {
        Condition condition = SysMenu.SYS_MENU.DEL_FLAG.eq(DEL_FLAG_NORMAL);
        return menuDao.fetchByCondition(condition);
    }
}
