/*package com.hotyum.stars.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.hotyum.stars.utils.DateUtil;

public class ExcelUtils {

	*//**
	 * 点击直接下载excel文件
	 * 
	 * @param request
	 * @param response
	 * @param list
	 * @param fieldNames
	 * @param fieldRealNames
	 * @param downLoadFileName
	 * @param sheetName
	 * @param <T>
	 * @throws Exception
	 *//*
	public static <T> void writeExcel2OutputStream(HttpServletRequest request, HttpServletResponse response,
			List<T> list, String[] fieldNames, String[] fieldRealNames, String downLoadFileName, String sheetName)
			throws Exception {
		// 防止重复
		downLoadFileName = downLoadFileName + "-" + DateUtil.getSerial() + ".xls";

		response.setHeader("Content-Disposition",
				"attachment;   filename=" + ExcelUtils.processFileName(request, downLoadFileName));
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/vnd.ms-excel");
		List<String> fieldNamesList = Arrays.asList(fieldNames);
		List<String> fieldCnNamesList = Arrays.asList(fieldRealNames);
		HSSFWorkbook wb = writeExcel(list, fieldNamesList, fieldCnNamesList, sheetName);

		// 先在服务器本地生成文件
		String tmpRoad = request.getServletContext().getRealPath("/tempdown/download/");
		// String tmpRoad = "/tempdown/download/";
		File file = new File(tmpRoad + downLoadFileName);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		// System.out.println("服务器生成文件的路径:" + file.getAbsolutePath());
		FileOutputStream local = new FileOutputStream(file);
		wb.write(local);
		local.close();

		// 返回到用户页面下载
		OutputStream out = response.getOutputStream();
		FileInputStream input = new FileInputStream(file);
		byte[] b = new byte[1024];
		int i = 0;
		while ((i = input.read(b)) > 0) {
			out.write(b, 0, i);
		}
		input.close();
		out.flush();
		wb.close();
		deteTmpDocument(file);
	}

	// 删除文件
	private static void deteTmpDocument(File file) {
		if (file.isFile() && file.exists()) {// 路径为文件且不为空则进行删除
			file.delete();// 文件删除
		}
	}

	public static <T> HSSFWorkbook writeExcel(List<T> list, List<String> fieldNames, List<String> fieldRealNames,
			String sheetName) throws Exception {
		// 创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);
		// 在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 创建单元格，并设置值表头 设置表头居中
		CellRender<?> header = new HeaderCellRenderDefault();
		CellRender<T> body = new BodyCellRenderDefault<T>();
		if (fieldRealNames != null && fieldRealNames.size() > 0) {
			for (int z = 0; z < fieldRealNames.size(); z++) {
				String fieldRealName = fieldRealNames.get(z);
				HSSFCell cell = row.createCell(z);
				cell.setCellValue(fieldRealName);
				header.updateHeaderStyle(wb, sheet, cell, z);
				// sheet.setColumnWidth(z, 512 * 10);
				sheet.autoSizeColumn(z);
			}
		}
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow((int) i + 1);
				T obj = list.get(i);
				// 创建单元格，并设置值
				for (int k = 0; k < fieldNames.size(); k++) {
					String fieldName = fieldNames.get(k);
					// 只操作指定的字段名
					HSSFCell t_cell = row.createCell(k);
					if (t_cell != null) {
						body.updateBodyStyle(wb, sheet, t_cell, obj, fieldName, k);
					}
				}
				// 设置自适应宽度
				sheet.autoSizeColumn(i);
			}
		}
		return wb;
	}

	*//**
	 * 
	 * @Title: processFileName
	 * 
	 * @Description: ie,chrom,firfox下处理文件名显示乱码
	 *//*
	public static String processFileName(HttpServletRequest request, String fileNames) {
		String codedfilename = null;
		try {
			String agent = request.getHeader("USER-AGENT");
			if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
				String name = java.net.URLEncoder.encode(fileNames, "UTF8");
				codedfilename = name;
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
				codedfilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codedfilename;
	}

	*//**
	 * 对cell进行处理
	 * 
	 * @param c
	 * @return
	 *//*
	public static String getCellValue(Cell c) {
		String o = null;
		if (c == null)
			return null;
		switch (c.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			o = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			o = String.valueOf(c.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			o = String.valueOf(c.getCellFormula());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			o = String.valueOf(c.getDateCellValue());
			break;
		case Cell.CELL_TYPE_STRING:
			o = c.getStringCellValue();
			break;
		default:
			o = null;
			break;
		}
		return o;
	}

}
*/