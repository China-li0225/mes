package com.mes.common.utils.ip;

import com.mes.common.utils.StringUtils;
import com.mes.common.utils.http.HttpClientUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Enumeration;

/**
 * 获取地址类
 *
 * @author Lion Li
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressUtils {

    // 未知地址
    public static final String UNKNOWN = "XX XX";
    public static String out_ip = "XX XX";

    /**
     * 处理ip地址
     * @param ip
     * @return
     */
    public static String getRealAddressByIP(String ip) {
        if (StringUtils.isBlank(ip)) {
            return UNKNOWN;
        }
//        // 内网不查询(如果要做成可设置项，使用读取配置文件方法)
//        ip = StringUtils.contains(ip, "0:0:0:0:0:0:0:1") ? "127.0.0.1" : HtmlUtil.cleanHtmlTag(ip);
//        if (NetUtil.isInnerIP(ip)) {
//            return "内网IP";
//        }
        return RegionUtils.getCityInfo(ip);
    }

    /**
     * 获取本地ip地址
     * @return 本地ip地址
     */
    public static String getLocalhostIp() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        return "";
    }
    /**
     * 获取当前设备出口ip
     */
    public static void getExternalIp() {
        try {
//            String apiUrl = "https://myip.ipip.net/";
//            URL url = new URL(apiUrl);
//            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            ip = reader.readLine();
//            reader.close();
            String url = "https://myip.ipip.net";
            String resultString = HttpClientUtil.doGet(url);
            int start = resultString.indexOf("：");
            int end = resultString.indexOf("来自于");
            out_ip = resultString.substring(start+1,end-2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
