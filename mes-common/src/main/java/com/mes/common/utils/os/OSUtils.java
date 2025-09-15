package com.mes.common.utils.os;

import java.util.Properties;

/**
 * ClassName: OSUtils <br/>
 * Description: 加载操作系统信息 <br/>
 * date: 2024/9/9 16:39<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
public class OSUtils {
    private static Properties properties;

    public static void getProperties(){
        properties = System.getProperties();
    }
    public static Properties getSystemOS(){
        return properties;
    }
}
