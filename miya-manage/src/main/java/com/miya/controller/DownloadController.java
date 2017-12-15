package com.miya.controller;

import com.alibaba.fastjson.JSONObject;
import com.miya.common.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.List;

/**
 *
 * 下载文件为Excel文件
 * @author 赵金鑫
 * @date 2017年11月09日
 */
@Slf4j
@Controller
@RequestMapping("/download")
public class DownloadController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public void download(HttpServletResponse response,  HttpSession session) {

        JSONObject downloadJSONObject =(JSONObject) session.getAttribute("Data1");
        log.info("test1获得Session属性对象：{}" ,downloadJSONObject);
        HSSFWorkbook wb = new HSSFWorkbook();
        try {
            if (downloadJSONObject != null) {
                //if (category.equals("taobao")) {
                String fileName = "测试1.xls";
                fileName = URLEncoder.encode(fileName, "UTF-8");
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
                // 解决中文文件名乱码关键行
                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"; filename*=utf-8''" + fileName);
                //Util.SaveJsonArraySheet_v1(wb, "表2", rows);
                Util.SaveAsExcelSheet(wb,fileName,(List<String>)downloadJSONObject.get("columns"),(List<String>)downloadJSONObject.get("rows"),(List<List<String>>) downloadJSONObject.get("data"),"数据平台");
                log.info("保存为Excel文件");
                wb.write(response.getOutputStream());
                log.info("发送成功");
            } else {
                response.getOutputStream().write(new String("had no data").getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/test2", method={RequestMethod.GET, RequestMethod.POST})
    public void testToExcel(HttpServletResponse response,
                            HttpSession session)  {

        JSONObject downloadJSONObject =(JSONObject) session.getAttribute("Data2");
        log.info("test2获得Session属性对象：{}" ,downloadJSONObject);
        HSSFWorkbook wb = new HSSFWorkbook();
        try {
            if (downloadJSONObject != null) {
                String fileName = "测试2.xls";
                String fileNameUtf8 = URLEncoder.encode(fileName, "UTF-8");
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
                // 解决中文文件名乱码关键行
                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameUtf8 + "\"; filename*=utf-8''" + fileNameUtf8);
                Util.SaveAsExcelSheet(wb,fileName,(List<String>)downloadJSONObject.get("columns"),(List<String>)downloadJSONObject.get("rows"),(List<List<String>>) downloadJSONObject.get("data"),"数据平台");
                log.info("保存为Excel文件");
                wb.write(response.getOutputStream());
                log.info("发送成功");
            } else {
                response.getOutputStream().write(new String("had no data").getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
