package com.mes.web.mes.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mes.common.core.domain.R;
import com.mes.system.domain.vo.SysOssVo;
import com.mes.system.mapper.SysOssMapper;
import com.mes.system.service.ISysOssService;
import com.mes.web.mes.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
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
@RequestMapping("/Apitest")
@Validated
@RequiredArgsConstructor
@Slf4j
public class ApitestController {
    private final TestService testService;
    private final ISysOssService iSysOssService;
    private final SysOssMapper ossMapper;

    //测试接口通信
    @GetMapping("/test")
    @SaIgnore
    public String ApiTest(){
        return testService.test();
    }

    //遍历表内容
    @GetMapping("/page")
    @SaIgnore
    public R page(Page page){
        return R.ok(testService.page(page));
    }

    //上传文件
    @PostMapping("/uploadFile")
    @SaIgnore
    public R uploadFile(@RequestBody MultipartFile file) throws IOException {
        return R.ok(iSysOssService.upload(file));
    }

    //根据Ossurl下载文件
    @GetMapping("/downloadFile")
    @SaIgnore
    public void downloadFile(HttpServletResponse response , String fileName,String url) throws IOException {
        iSysOssService.downloadByUrl(url,"minio",fileName,response);
    }

    //spring事务测试
    @GetMapping("/testTransactional")
    @SaIgnore
    public R testTransactional(String a) throws Exception {
        return R.ok(testService.testTransactional(a));
    }



    /**
     *  下载本地文件
     * @param a 本地文件地址
     * @param response
     * @throws Exception
     */
    @GetMapping("/downloadFileLocal")
    @SaIgnore
    public void downloadFileLocal(String a,HttpServletResponse response) throws Exception {
        File file = new File(a);
        FileInputStream fileInputStream = new FileInputStream(file);
        int available = fileInputStream.available();
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE + "; charset=UTF-8");
        response.addHeader("Content-Disposition","inline; filename=" + file.getName());
        IoUtil.copy(fileInputStream,response.getOutputStream(),available);
        response.setContentLength(available);
    }
}
