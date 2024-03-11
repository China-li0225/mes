package com.mes.web.mes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mes.web.mes.entity.Test;
import com.mes.web.mes.mapper.TestMapper;
import com.mes.web.mes.service.TestService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ClassName: TestServiceImpl <br/>
 * Description: <br/>
 * date: 2024/3/11 下午 1:16<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {
    @Override
    public String test() {
        log.info("接口测试");
        return "接口测试";
    }
}
