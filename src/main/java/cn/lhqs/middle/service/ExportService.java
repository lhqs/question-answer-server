package cn.lhqs.middle.service;

import cn.lhqs.middle.entity.DataTimeSelect;

import java.io.IOException;
import java.io.OutputStream;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-05 17:36
 * description : ExportService.class
 * version : 1.0
 */
public interface ExportService {

    OutputStream exportExcelForLog(DataTimeSelect dataTimeSelect, OutputStream outputStream) throws IOException;
    OutputStream exportExcelForLog(String startTime, String endTime, OutputStream outputStream) throws IOException;

    public OutputStream exportCsvForLog(DataTimeSelect dataTimeSelect, OutputStream outputStream);
}
