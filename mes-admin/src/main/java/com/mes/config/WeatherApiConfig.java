package com.mes.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * ClassName: WeatherApiConfig <br/>
 * Description: <br/>
 * date: 2024/3/21 上午 10:32<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
@Configuration
@ConfigurationProperties(prefix = "weather")
@Data
public class WeatherApiConfig {
    private String url;
    private String city;
    private String extensions;
    private String output;
    private String key;

    @Bean
    public String weatherurl(){
        return url + "?city=" + city + "&extensions=" + extensions + "&output=" + output + "&key=" + key;
    }
}
