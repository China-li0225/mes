package com.mes.common.weixin;

import com.alibaba.fastjson.JSONObject;
import com.mes.common.utils.http.HttpClientUtil;
import com.mes.common.utils.redis.RedisUtils;

import java.time.Duration;

/**
 * ClassName: AccessTokenUtils <br/>
 * Description: <br/>
 * date: 2025/9/1 17:33<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
public class AccessTokenUtils {
    public static String getAccessToken() {
        String corpid = "ww5147be0a677f0898";
        String SECRET = "sT4oGb7FgQYFka6K2mmZF3YPkd-m4zrHIEMcMuFuh94";
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + SECRET;
        String resultString = HttpClientUtil.doGet(url);
        JSONObject payloadJSON = JSONObject.parseObject(resultString);
        String access_token = (String)payloadJSON.get("access_token");
        int expires_in = (int)payloadJSON.get("expires_in") - 100;

        //写入redis保存
        String key = "WXAccessToken";
        Duration duration = Duration.ofSeconds(expires_in);
        RedisUtils.setCacheObject(key, access_token,duration);
        System.out.println("微信AccessToken获取完毕，有效期："+ RedisUtils.getTimeToLive(key)/1000);
        return access_token;
    }
}
