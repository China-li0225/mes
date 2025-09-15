package com.mes.web.controller.common;

import cn.dev33.satoken.annotation.SaIgnore;
import com.mes.common.core.domain.R;
import com.mes.common.utils.fine.Finereport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * 验证码操作处理
 *
 * @author Lion Li
 */
@SaIgnore
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/finereport")
public class FinereportController {

    /**
     * fine 后台单点登录
     * @param username 用户名
     * @return 返回指定用户的单点登录接口（用户名加密）
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/fineLogin")
    public String getLoginUrl(@RequestParam("username") String username) throws UnsupportedEncodingException {
        if (username == null ){
            throw new UnsupportedEncodingException("请输入用户名");
        }
        return Finereport.ssoLogin(username);
    }

    /**
     * fine 前台单点登录
     * @return 返回指定用户的单点登录接口（用户名加密）
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/fineAuthToken")
    @SaIgnore
    public R getfineAuthToken() throws UnsupportedEncodingException {
        return R.ok(Finereport.fineAuthToken());
    }


}
