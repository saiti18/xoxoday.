package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getData(String page,String sheet,int row,int coloum){
		String v="";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(page));
			v=wb.getSheet(sheet).getRow(row).getCell(coloum).toString();
		}
		catch(Exception e) {
			
		}
		return v;
	}
		public static int getRowCount(String page,String sheet) {
			int rc=0;
			try {
				Workbook wb=WorkbookFactory.create(new FileInputStream(page));
				rc=wb.getSheet(sheet).getLastRowNum();
			}
			catch(Exception e) {
				
			}
			return rc;
			
		}
		
		public static int getColumnCount(String page,String sheet,int row ) {
			int cc=0;
			try {
				Workbook wb=WorkbookFactory.create(new FileInputStream(page));
				cc=wb.getSheet(sheet).getRow(row).getLastCellNum();
			}
			catch(Exception e) {
				
			}
			return cc;
			
		}
	
	}

