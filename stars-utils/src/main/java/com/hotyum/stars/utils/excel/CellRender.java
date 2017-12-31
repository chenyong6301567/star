package com.hotyum.stars.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface CellRender<T> {
	void updateHeaderStyle(HSSFWorkbook wb, HSSFSheet sheet, HSSFCell cell, int index);

	void updateBodyStyle(HSSFWorkbook wb, HSSFSheet sheet, HSSFCell cell, T data, String fieldName, int index);
}
