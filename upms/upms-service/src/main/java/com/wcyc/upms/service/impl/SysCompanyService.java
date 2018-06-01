package com.wcyc.upms.service.impl;

import com.wcyc.base.common.base.service.impl.BaseService;
import com.wcyc.upms.api.entity.SysCompany;
import com.wcyc.upms.api.service.ISysCompanyService;
import com.wcyc.upms.dao.SysCompanyDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chen
 * @date 2017/7/31
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 公司 service
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "1.0",
        interfaceClass = ISysCompanyService.class
)
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class SysCompanyService extends BaseService<SysCompanyDao, SysCompany> implements ISysCompanyService {

}
