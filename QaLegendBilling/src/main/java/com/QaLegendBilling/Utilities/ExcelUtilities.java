package com.QaLegendBilling.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.QaLegendBilling.Constants.Constants;

public class ExcelUtilities {

	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet sh;
	
	public static String getCellStringData(int RowNum, int ColNum,String sheetNum)  {
		
		try {
			f=new FileInputStream(System.getProperty("user.dir")+ Constants.EXCELREADERPATH);
		} 
		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		try {
			w= new XSSFWorkbook(f);
		} 
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		sh=w.getSheet(sheetNum);
		Row r=sh.getRow(RowNum);
		Cell c=r.getCell(ColNum);
		return c.getStringCellValue();
		
	}
	
	public static int getCellNumericData(int RowNum, int ColNum,String sheetNum) {
		try {
			f=new FileInputStream(System.getProperty("user.dir")+ Constants.EXCELREADERPATH);
		} 
		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
			w= new XSSFWorkbook(f);
		} 
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		sh=w.getSheet(sheetNum);
		return (int) sh.getRow(RowNum).getCell(ColNum).getNumericCellValue();
		
	}
}
