package com.mes.web.controller.Utils;

import com.mes.web.mes.entity.vo.PurchaseM;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: PoiUtils <br/>
 * Description: <br/>
 * date: 2024/9/4 16:52<br/>
 *
 * @author lixing<br />
 * @since JDK
 */
public class PoiUtils {
    public static List<PurchaseM> readExcel(MultipartFile file) throws Exception {
        List<PurchaseM> purchaseMS = new ArrayList<>();
        if (file.isEmpty()) {
            throw new Exception("指定的Excel文件不存在！");
        }
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        Workbook workbook = null;
        try {
            System.out.println(file.getOriginalFilename());
            if (fileType.equalsIgnoreCase("xls")) {
                workbook = new HSSFWorkbook(file.getInputStream()); //生成.xls的excel
            } else if (fileType.equalsIgnoreCase("xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream()); //生成.xlsx的excel
            } else if (fileType.equalsIgnoreCase("csv")) {
                workbook = WorkbookFactory.create(file.getInputStream()); //生成.xlsx的excel
            } else {
                throw new Exception("文件格式不对");
            }
            purchaseMS = parseExcel(workbook);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return purchaseMS;
    }

    private static List<PurchaseM> parseExcel(Workbook workbook) throws Exception {
        List<PurchaseM> purchaseMS = new ArrayList<>();
        //解析excel内容
        Sheet sheet = workbook.getSheetAt(0); // 获取表格
        // 校验sheet是否合法
        if (sheet == null) {
            throw new Exception("sheet不合法，请检查数据");
        }

        for (int RowNum = sheet.getFirstRowNum(); RowNum < sheet.getLastRowNum(); RowNum++) {
            Row row = sheet.getRow(RowNum);
            if (row == null) {
                continue;
            }
            Cell cell = row.getCell(0);//第一列
            if (convertCellValueToString(cell) == null) {
                continue;
            }
            PurchaseM purchaseM = new PurchaseM();
            //44490,5750,5750,2023-12-30 00:00:00.000,普通采购,普通采购,0108066,13,韩丽丽,NULL,010165,517.33,3601.7699148,1863303.63,242229.47,2105533.10,2023121025436,23122000000029872310
            String[] strings = convertCellValueToString(cell).split(",");
            purchaseM.setId(strings[0]);
            purchaseM.setPsvid(strings[1]);
            purchaseM.setCSVCode(strings[2]);
            purchaseM.setDSVDate(strings[3]);
            purchaseM.setCBusType(strings[4]);
            purchaseM.setCVenCode(strings[5]);
            purchaseM.setITaxRate(strings[6]);
            purchaseM.setCMaker(strings[7]);
            purchaseM.setCWhCode(strings[8]);
            purchaseM.setCInvCode(strings[9]);
            purchaseM.setISVQuantity(strings[10]);
            purchaseM.setISVCost(strings[11]);
            purchaseM.setISVPrice(strings[12]);
            purchaseM.setITax(strings[13]);
            purchaseM.setISum(strings[14]);
            purchaseM.setCPIVCode(strings[15]);
            purchaseM.setCBillCode(strings[16]);
            purchaseMS.add(purchaseM);
        }

        return purchaseMS;
    }

    private static String convertCellValueToString(Cell cell) {
        if (cell == null) {
            return null;
        }
        String content = null;
        try {
            switch (cell.getCellType()) {
                case NUMERIC:   //数字或者时间
                    Double doubleValue = cell.getNumericCellValue();
                    // 格式化科学计数法，取一位整数
                    DecimalFormat df = new DecimalFormat("0");
                    content = df.format(doubleValue);
                    break;
                case STRING:    //字符串
                    content = cell.getStringCellValue();
                    break;
                case BOOLEAN:   //布尔
                    Boolean booleanValue = cell.getBooleanCellValue();
                    content = booleanValue.toString();
                    break;
                case BLANK:     // 空值
                    break;
                case FORMULA:   // 公式
                    content = cell.getCellFormula();
                    break;
                case ERROR:     // 故障
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
