package com.mes.web.controller.system;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mes.config.WeatherApiConfig;
import com.mes.web.controller.Utils.HttpRequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 天气查询
 * ClassName: SysWeatherController <br/>
 * Description: <br/>
 * date: 2024/3/21 上午 10:54<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/weather")
public class SysWeatherController {
    private final WeatherApiConfig weatherApiConfig;
    @GetMapping
    @SaIgnore
    public JSONObject getWeatherAll(){
        String weatherUrl = weatherApiConfig.weatherurl();
        System.out.println(weatherUrl);
        JSONObject jsonObject = JSONUtil.parseObj(HttpRequestUtils.sendGet(weatherUrl));
        return jsonObject;
    }
}
