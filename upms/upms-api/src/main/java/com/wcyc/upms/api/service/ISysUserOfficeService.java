package com.wcyc.upms.api.service;

import com.wcyc.base.api.base.vo.DataTable;
import com.wcyc.base.api.service.IBaseService;
import com.wcyc.upms.api.entity.SysUser;
import com.wcyc.upms.api.entity.SysUserOffice;

/**
 *
 * @author chen
 * @date 2017/11/16
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public interface ISysUserOfficeService extends IBaseService<SysUserOffice> {


    /**
     * 移除组织中的人
     * @param officeId
     * @param userIds
     */
    void removeUsers(Long officeId, Long[] userIds);

    /**
     * 向组织中添加用户
     * @param officeId
     * @param userIds
     * @param major
     */
    void addUsers(Long officeId, Long[] userIds, String major);

    /**
     * 获取组织的用户列表
     * @param dt
     * @return
     */
    DataTable<SysUser> userList(DataTable dt);
}
