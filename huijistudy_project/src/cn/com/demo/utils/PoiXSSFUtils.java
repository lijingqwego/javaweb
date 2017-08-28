package cn.com.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.com.demo.po.SubjectInfo;

public class PoiXSSFUtils {

	public static List<SubjectInfo> readXls() throws IOException {
		InputStream is = new FileInputStream("C:/Users/Administrator/Desktop/项目案例/慧极教学平台管理系统v1.1/慧极教学平台管理系统v1.1/科目数据.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(is);
		
		List<SubjectInfo> list = new ArrayList<SubjectInfo>();
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < workBook.getNumberOfSheets(); numSheet++) {
			XSSFSheet hssfSheet = workBook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow row = hssfSheet.getRow(rowNum);
				if (row != null) {
					XSSFCell s_no = row.getCell(0);
					XSSFCell s_code = row.getCell(1);
					XSSFCell s_name = row.getCell(2);
					XSSFCell s_father_no = row.getCell(3);
					
					SubjectInfo s = new SubjectInfo();
					s.setSubject_no(Long.valueOf(getValue(s_no)));
					s.setSubject_code(getValue(s_code));
					s.setSubject_name(getValue(s_name));
					s.setFather_subject(Long.valueOf(getValue(s_father_no)));
					
					list.add(s);
				}
			}
		}
		
		return list;
	}
	
	public static String readXls2() throws IOException {
		InputStream is = new FileInputStream("C:/Users/Administrator/Desktop/题目信息.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(is);
		
		StringBuilder builder = new StringBuilder();
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < workBook.getNumberOfSheets(); numSheet++) {
			XSSFSheet hssfSheet = workBook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow row = hssfSheet.getRow(rowNum);
				if (row != null) {
					XSSFCell q_no = row.getCell(0);
					XSSFCell q_type = row.getCell(1);
					
					XSSFCell q_key = row.getCell(2);
					
					XSSFCell q_a = row.getCell(3);

					XSSFCell q_b = row.getCell(4);
					if(getValue(q_type).equals("3")){
						builder.append(getValue(q_no)+"@|@").append(getValue(q_type)+"@|@").append(getValue(q_key)+"@|@")
						.append(getValue(q_a)+"@|@").append(getValue(q_b)+"@||@");
					}else{
						XSSFCell q_c = row.getCell(5);
						XSSFCell q_d = row.getCell(6);
						builder.append(getValue(q_no)+"@|@").append(getValue(q_type)+"@|@").append(getValue(q_key)+"@|@")
						.append(getValue(q_a)+"@|@").append(getValue(q_b)+"@|@").append(getValue(q_c)+"@|@").append(getValue(q_d)+"@||@");
					}
					
					/*getValue(q_no);
					getValue(q_type);
					getValue(q_key);
					
					getValue(q_a);
					getValue(q_b);
					getValue(q_c);
					getValue(q_d);*/
					
					
				}
			}
		}
		System.out.println(builder.toString());
		return builder.toString();
	}

	@SuppressWarnings("static-access")
	private static String getValue(XSSFCell cell) {
		if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			return String.valueOf(cell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(cell.getStringCellValue());
		}
	}
	
	public static void main(String[] args) {
		try {
			readXls2();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
