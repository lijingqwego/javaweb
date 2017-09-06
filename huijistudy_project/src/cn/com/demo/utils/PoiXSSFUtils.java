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
		InputStream is = new FileInputStream("C:/Users/Administrator/Desktop/��Ŀ����.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(is);
		
		List<SubjectInfo> list = new ArrayList<SubjectInfo>();
		// ѭ��������Sheet
		for (int numSheet = 0; numSheet < workBook.getNumberOfSheets(); numSheet++) {
			XSSFSheet hssfSheet = workBook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// ѭ����Row
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
	
	public static String readXls2(String questionsfile) throws IOException {
		FileInputStream in = new FileInputStream(questionsfile);
		XSSFWorkbook workBook = new XSSFWorkbook(in);
		
		StringBuilder builder = new StringBuilder();
		// ѭ��������Sheet
		for (int numSheet = 0; numSheet < workBook.getNumberOfSheets(); numSheet++) {
			XSSFSheet hssfSheet = workBook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// ѭ����Row
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
				}
			}
		}
		in.close();
		System.out.println(builder.toString());
		return builder.toString();
	}

	@SuppressWarnings("static-access")
	private static String getValue(XSSFCell cell) {
		if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			// ���ز������͵�ֵ
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			// ������ֵ���͵�ֵ
			return String.valueOf(cell.getNumericCellValue());
		} else {
			// �����ַ������͵�ֵ
			return String.valueOf(cell.getStringCellValue());
		}
	}
	
	public static void main(String[] args) {

	}
}
