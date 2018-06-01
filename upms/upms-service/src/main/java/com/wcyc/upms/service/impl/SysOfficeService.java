package com.wcyc.upms.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.wcyc.base.api.base.constant.Global;
import com.wcyc.base.api.base.vo.JsTree;
import com.wcyc.base.common.base.service.impl.BaseService;
import com.wcyc.upms.api.entity.SysOffice;
import com.wcyc.upms.api.service.ISysOfficeService;
import com.wcyc.upms.dao.SysOfficeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chen
 * @date 2017/11/13
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 组织
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        interfaceClass = ISysOfficeService.class
)
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysOfficeService extends BaseService<SysOfficeDao, SysOffice> implements ISysOfficeService {

    /**
     * 获取组织架构树
     *
     * @return
     */
    @Override
    public List<JsTree> getOfficeTree() {
        List<SysOffice> sysOffices = selectList(Condition.create().orderBy("sort", true));
        return makeTree(sysOffices);

    }

    /**
     * 保存 office
     * @param sysOffice
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void add(SysOffice sysOffice) {

        insert(sysOffice);
        if (Global.TOP_TREE_NODE.equals(sysOffice.getParentId())) {
            sysOffice.setPath(sysOffice.getId() + ".");
        } else {
            sysOffice.setPath(sysOffice.getPath() + sysOffice.getId() + ".");
        }
        updateById(sysOffice);

    }


    /**
     * 更新菜单
     *
     * @param sysOffice
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void update(SysOffice sysOffice) {
        updateById(sysOffice);
    }

}


