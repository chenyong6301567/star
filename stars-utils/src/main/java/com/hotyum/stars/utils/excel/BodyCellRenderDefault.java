package com.hotyum.stars.utils.excel;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.hotyum.stars.utils.DateUtil;

public class BodyCellRenderDefault<T> implements CellRender<T> {
	public void updateHeaderStyle(HSSFWorkbook wb, HSSFSheet sheet, HSSFCell cell, int index) {
	}

	public void updateBodyStyle(HSSFWorkbook wb, HSSFSheet sheet, HSSFCell cell, T data, String fieldName, int index) {
		if (cell == null) {
			return;
		}
		Object value = null;

		try {
			value = Reflections.getFieldValueByMethod(data, fieldName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (value == null) {
			return;
		}
		if (value instanceof Date) {// 判断是否日期类型
			String dateTemp = DateUtil.date2Str((Date) value, DateUtil.DEFAULT_FORMAT);
			cell.setCellValue(dateTemp);
			// HSSFCellStyle dateCellStyle=wb.createCellStyle();
			// short df=wb.createDataFormat().getFormat("yyyy-mm-dd hh:mm:ss");
			// dateCellStyle.setDataFormat(df);
			// cell.setCellStyle(dateCellStyle);
			// cell.setCellValue((Date) value);
		} else if (value instanceof BigDecimal) {
			cell.setCellValue(new java.text.DecimalFormat("#,##0.##").format((BigDecimal) value));
			// cell.setCellValue(((BigDecimal) ((BigDecimal) value).setScale(4,
			// BigDecimal.ROUND_HALF_UP)).toString());
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue(value.toString());
		}
	}
}
