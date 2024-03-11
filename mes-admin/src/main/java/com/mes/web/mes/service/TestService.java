package com.mes.web.mes.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mes.web.mes.entity.Test;
import com.mes.web.mes.mapper.TestMapper;
import org.ehcache.spi.service.Service;

/**
 * ClassName: TestService <br/>
 * Description: <br/>
 * date: 2024/3/11 下午 1:16<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
public interface TestService extends IService<Test> {
    String test();
}
