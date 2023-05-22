package genericlibrareys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelfileutility {
	private FileInputStream fis;
	private Workbook wb;
public void reintilization(String filepathexcel) {
 try {
	fis=new FileInputStream(filepathexcel);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 try {
	 wb=WorkbookFactory.create(fis);
} catch (EncryptedDocumentException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
/**
 * this method is used to get the data from execl file
 * @param sheetname
 * @param rownum
 * @param cellnum
 * @return
 */
 public String readdata(String sheetname, int rownum, int cellnum) {
	return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	 
 }
 public HashMap<String, String> setdata(String sheetname) {
	 HashMap<String, String> map=new HashMap<>();
	Sheet sh= wb.getSheet(sheetname);
	
	for(int i=0;i<=sh.getLastRowNum();i++) {
		String key=sh.getRow(i).getCell(0).getStringCellValue();
		String value=sh.getRow(i).getCell(1).getStringCellValue();
	map.put(key, value);
		
		
	}
	return map;
 }
 /**
  * this method is used to close the workbook method 
  */
 

}

