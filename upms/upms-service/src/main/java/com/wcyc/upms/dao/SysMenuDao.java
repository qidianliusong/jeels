package com.wcyc.upms.dao;


import com.wcyc.base.common.base.dao.TreeDao;
import com.wcyc.upms.api.entity.SysMenu;

import java.util.List;

/**
 * Created by chen on 2017/3/13.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 菜单dao
 */
public interface SysMenuDao extends TreeDao<SysMenu> {
    /**
     * 查询 用户的所有菜单
     *
     * @param userId
     * @return
     */
    List<SysMenu> selectMenusByUserId(Long userId);
}
