package com.mes.web.mes.controller;


import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import com.mes.common.filter.RepeatedlyRequestWrapper;
import com.mes.common.utils.JsonUtils;
import com.mes.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * ClassName: ApitestController <br/>
 * Description: <br/>
 * date: 2024/3/11 下午 12:38<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
@RestController
@Validated
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/jdy")
public class JdyController {
    private final static String SECRET = "";
    @PostMapping
    public void handle(HttpServletRequest request, HttpServletResponse response, @RequestParam String nonce, String timestamp) throws IOException {
        // 打印请求参数
        String payload = "";
        if (isJsonRequest(request)) {
            if (request instanceof RepeatedlyRequestWrapper) {
                BufferedReader reader = request.getReader();
                payload = IoUtil.read(reader);
            }
        } else {
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (MapUtil.isNotEmpty(parameterMap)) {
                payload  = JsonUtils.toJsonString(parameterMap);
            } else {
                log.debug("[PLUS]开始请求 => URL[{}],无参数", payload);
            }
        }

        System.out.println("jdyTest");

        String jdy = request.getHeader("x-jdy-signature");
        String signature = getSignature(nonce, payload, SECRET, timestamp);
        OutputStream out = response.getOutputStream();
        if (!signature.equals(jdy)) {
            response.setStatus(401);
            out.write("fail".getBytes());
            out.close();
        }
        response.setStatus(200);
        out.write("success".getBytes());
        out.close();
        // 处理数据 - 入库出库等处理
        System.out.println(payload);
    }

    private static String getSignature(String nonce, String payload, String secret, String timestamp) {
        return DigestUtils.sha1Hex(nonce + ":" + payload + ":" + secret + ":" + timestamp);
    }

    /**
     * 判断本次请求的数据类型是否为json
     *
     * @param request request
     * @return boolean
     */
    private boolean isJsonRequest(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType != null) {
            return StringUtils.startsWithIgnoreCase(contentType, MediaType.APPLICATION_JSON_VALUE);
        }
        return false;
    }
}
