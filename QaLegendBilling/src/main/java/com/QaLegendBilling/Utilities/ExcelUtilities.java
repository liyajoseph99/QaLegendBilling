package com.QaLegendBilling.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet sh;
	
	public static String getCellStringData(int RowNum, int ColNum,String sheetNum) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\excelreader" + "\\Book1.xlsx");
		w= new XSSFWorkbook(f);
		sh=w.getSheet(sheetNum);
		Row r=sh.getRow(RowNum);
		Cell c=r.getCell(ColNum);
		return c.getStringCellValue();
		
	}
	
	public static int getCellNumericData(int RowNum, int ColNum,String sheetNum) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\excelreader" + "\\Book1.xlsx");
		w= new XSSFWorkbook(f);
		sh=w.getSheet(sheetNum);
		return (int) sh.getRow(RowNum).getCell(ColNum).getNumericCellValue();
		
	}
}
