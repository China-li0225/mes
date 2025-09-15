package com.mes;

import com.mes.common.utils.ip.AddressUtils;
import com.mes.common.utils.os.OSUtils;
import com.mes.common.weixin.AccessTokenUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * 启动程序
 *
 * @author mes
 */

@SpringBootApplication
public class MesApplication {
    public static void main(String[] args) throws Exception{
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication application = new SpringApplication(MesApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        AddressUtils.getExternalIp();
        application.run(args);
        AccessTokenUtils.getAccessToken();//程序启动立即更新微信AccessToken
        System.out.println("(♥◠‿◠)ﾉﾞ  Mes-Vue-Plus启动成功   ლ(´ڡ`ლ)ﾞ");
        OSUtils.getProperties();

        System.out.println("操作系统名称" + OSUtils.getSystemOS().getProperty("os.name"));
        System.out.println("Ip：" + AddressUtils.getLocalhostIp());
        System.out.println("ip检测:" + AddressUtils.getRealAddressByIP(AddressUtils.getLocalhostIp()));
        System.out.println("设备出口ip:" + AddressUtils.out_ip);

    }

}
