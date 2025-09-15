package com.mes.weixin.service.impl;

import com.mes.common.weixin.AccessTokenUtils;
import com.mes.weixin.service.WXAccessTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * ClassName: WXAccessTokenServicelmpl <br/>
 * Description: <br/>
 * date: 2025/9/1 15:19<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
@RequiredArgsConstructor
@Service
public class WXAccessTokenServicelmpl implements WXAccessTokenService {
    @Override
    public String getAccessToken() {
        return AccessTokenUtils.getAccessToken();
    }
}
