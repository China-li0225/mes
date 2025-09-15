package com.mes.web.weixin.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import com.mes.common.core.controller.BaseController;
import com.mes.common.core.domain.PageQuery;
import com.mes.common.core.domain.R;
import com.mes.common.core.page.TableDataInfo;
import com.mes.system.domain.SysConfig;
import com.mes.weixin.service.WXAccessTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: WXAccessTokenController <br/>
 * Description: <br/>
 * date: 2025/9/1 15:25<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/weixin/token")
public class WXAccessTokenController  extends BaseController {
    private final WXAccessTokenService wxAccessTokenService;
    /**
     * 获取微信AccessToken
     */
    @SaCheckPermission("system:config:list")
    @GetMapping("/getAccessToken")
    @SaIgnore
    public R getAccessToken() {
        return R.ok(wxAccessTokenService.getAccessToken());
    }
    /**
     * 微信token有效期验证
     */
    @SaCheckPermission("system:config:list")
    @GetMapping("/getAccessTokenExpires")
    @SaIgnore
    public R getAccessTokenExpires() {
        return R.ok();
    }
}
