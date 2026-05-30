package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	public static Iterator<User> readExcelFile(String fileName) {
		//XLSX file
		File xlsxFile = new File(System.getProperty("user.dir") + "\\testData\\" +fileName);
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet;
		List<User> userList=null;
		Iterator<Row> rowIterator;
		Row row;
		String emailAddress;
		String passwordCell;
		User user;
		DataFormatter formatter;
		
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			userList = new ArrayList<User>();
			xssfSheet = xssfWorkbook.getSheet("Login Test Data");
			rowIterator = xssfSheet.iterator();
			formatter = new DataFormatter();
			
			rowIterator.next();
			while(rowIterator.hasNext())
			{
				row = rowIterator.next();
				emailAddress = formatter.formatCellValue(row.getCell(0));
				passwordCell = formatter.formatCellValue(row.getCell(1));
				user = new User(emailAddress.toString(), passwordCell.toString());
				userList.add(user);
				
			}
			xssfWorkbook.close();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
