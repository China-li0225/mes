package com.mes.web.controller.system;

import cn.dev33.satoken.annotation.SaIgnore;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.mes.common.core.controller.BaseController;
import com.mes.common.core.domain.R;
import com.mes.common.utils.poi.ExcelUtil;
import com.mes.web.controller.Utils.PoiUtils;
import com.mes.web.mes.entity.vo.PurchaseM;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xdgf.util.Util;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 测试类
 *
 * @author Lion Li
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/test")
public class SysTestController extends BaseController {
    /**
     * 解析excel
     */
    @PostMapping
    @SaIgnore
    public void readExcel(@RequestBody MultipartFile file, HttpServletResponse response) throws Exception {
        ExcelUtil.exportExcel(PoiUtils.readExcel(file),"原材料易耗品价格",PurchaseM.class,response);
    }
}
