package cn.lhqs.middle.serviceImpl;

import cn.lhqs.middle.entity.DataTimeSelect;
import cn.lhqs.middle.entity.OperateLogRes;
import cn.lhqs.middle.service.ExportService;
import cn.lhqs.middle.service.LoggerService;
import cn.lhqs.middle.utils.TimeTools;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-05 17:37
 * description : ExportServiceImpl.class
 * version : 1.0
 */
@Service
public class ExportServiceImpl implements ExportService{

    @Resource
    LoggerService loggerService;

    @Override
    public OutputStream exportExcelForLog(String startTime, String endTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("用户日志");

        String[] headTables = {"序列","用户名","IP","IP位置","点击页面","查询内容","操作时间","操作设备"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }
        List<OperateLogRes> logListByTime = loggerService.getLogListByTime(startTime, endTime);

        for(int rowIndex = 1; rowIndex < logListByTime.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(logListByTime.get(rowIndex-1).getUsername());
            subrow.createCell(2).setCellValue(logListByTime.get(rowIndex-1).getIp());
            subrow.createCell(3).setCellValue(logListByTime.get(rowIndex-1).getIpAddr());
            subrow.createCell(4).setCellValue(logListByTime.get(rowIndex-1).getClickPage());
            subrow.createCell(5).setCellValue(logListByTime.get(rowIndex-1).getOperateContent());
            subrow.createCell(6).setCellValue(TimeTools.dateFormat(logListByTime.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
            subrow.createCell(7).setCellValue(logListByTime.get(rowIndex-1).getOrigin());
        }
        workbook.write(outputStream);
        outputStream.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForLog(DataTimeSelect dataTimeSelect, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("用户日志");

        String[] headTables = {"序列","用户名","IP","IP位置","点击页面","查询内容","操作时间","操作设备"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }
        List<OperateLogRes> logListByTime = loggerService.getLogListByTime(dataTimeSelect);

        for(int rowIndex = 1; rowIndex < logListByTime.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(logListByTime.get(rowIndex-1).getUsername());
            subrow.createCell(2).setCellValue(logListByTime.get(rowIndex-1).getIp());
            subrow.createCell(3).setCellValue(logListByTime.get(rowIndex-1).getIpAddr());
            subrow.createCell(4).setCellValue(logListByTime.get(rowIndex-1).getClickPage());
            subrow.createCell(5).setCellValue(logListByTime.get(rowIndex-1).getOperateContent());
            subrow.createCell(6).setCellValue(TimeTools.dateFormat(logListByTime.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
            subrow.createCell(7).setCellValue(logListByTime.get(rowIndex-1).getOrigin());
        }
        workbook.write(outputStream);
        outputStream.close();
        return outputStream;
    }
}
