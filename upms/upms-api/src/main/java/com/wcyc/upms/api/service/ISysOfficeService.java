package com.wcyc.upms.api.service;


import com.wcyc.base.api.base.vo.JsTree;
import com.wcyc.base.api.service.IBaseService;
import com.wcyc.upms.api.entity.SysOffice;

import java.util.List;

/**
 *
 * @author chen
 * @date 2017/11/13
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 组织
 */
public interface ISysOfficeService  extends IBaseService<SysOffice> {
    /**
     * 获取组织架构树
     * @return
     */
    List<JsTree> getOfficeTree();

    /**
     * 保存office （添加）
     * @param sysOffice
     */
    void add(SysOffice sysOffice);

    /**
     * 更新组织
     * @param sysOffice
     */
    void update(SysOffice sysOffice);
}
