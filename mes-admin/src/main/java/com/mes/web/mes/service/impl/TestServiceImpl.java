package com.mes.web.mes.service.impl;

import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.api.client.util.SecurityUtils;
import com.mes.common.core.domain.model.LoginUser;
import com.mes.common.helper.LoginHelper;
import com.mes.web.mes.entity.Test;
import com.mes.web.mes.mapper.TestMapper;
import com.mes.web.mes.service.TestService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Security;
import java.util.HashMap;
import java.util.Map;

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


    @Override
    @SaIgnore
    @Transactional(rollbackFor = Exception.class)
    public Map testTransactional(String a) throws Exception {
        LoginUser user = new LoginUser();
        user.setUsername("lixing");
        Map<String,String> stringMap = new HashMap<>();
        Test test = new Test();
        test.setB(20);
        stringMap.put("mybatisclass", String.valueOf(baseMapper.insert(test)));
        stringMap.put("mybatissql", String.valueOf(baseMapper.insertTest(test,user)));

        if (a != null){
            throw new Exception("事务回滚测试！");
        }
        return stringMap;
    }
}
