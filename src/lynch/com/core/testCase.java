package lynch.com.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class testCase {
	
	public static void main(String[] args) throws IOException {
		
		 ArrayList<String> names = new ArrayList<String>();
		 //names.add("Domination");
		 names.add("junit");
//		 names.add("Xholon");
//		 names.add("datacrow");
//		 names.add("freechat");
//		 names.add("freecol");
//		 names.add("ganttproject");
//		 names.add("hibernate");
//		 names.add("jasperreports");
//		 names.add("jEdit");
//		 names.add("jmencode");
//		 names.add("jsch");
//		 names.add("soapui");
//		 names.add("Vuze_5500_source");
//		 names.add("Vuze_5500_source2");
//		 names.add("Vuze_5500_source3");
		for(int k =0; k < names.size();k++ ){
		FuncBodyReadabilityCalculate lyfbrc = new FuncBodyReadabilityCalculate();
		SourceCodeData lyjrd = new SourceCodeData();
	    SourceCodeExcelReader lyjrer = new SourceCodeExcelReader();
	    List<SourceCodeData> rowList = lyjrer.readXls(names.get(k));
	    List<SourceCodeData> pkgClassMethodList = new ArrayList<SourceCodeData>();
	    for(int i = 0; i < rowList.size(); i++){
	        lyjrd = rowList.get(i);
	        pkgClassMethodList.add(new SourceCodeData(lyjrd.getVpackage(),lyjrd.getVclass(),lyjrd.getVmethod()));
	    }

	    HSSFWorkbook wb = new HSSFWorkbook();
        //Create Sheet Name
        HSSFSheet sheet = wb.createSheet("FunctionReadabilitySheet");  
        HSSFRow row = sheet.createRow((int) 0);    
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
  
        HSSFCell cell = row.createCell((short) 0);
        //Create column name
        //cell.setCellValue("Package Name");  
        //cell.setCellStyle(style);  
        //cell = row.createCell((short) 1);  
        //cell.setCellValue("Class Name");  
        //cell.setCellStyle(style);  
        //cell = row.createCell((short) 2);  
        cell.setCellValue("Full Method Name");  
        cell.setCellStyle(style);
        cell = row.createCell((short) 1);  
        cell.setCellValue("Function Readability");  
        cell.setCellStyle(style);
	    for(int i = 0; i < rowList.size(); i++){
	        lyjrd = rowList.get(i);
	        pkgClassMethodList.add(new SourceCodeData(lyjrd.getVpackage(),lyjrd.getVclass(),lyjrd.getVmethod()));
	    }
	    Set<SourceCodeData> uniqueSet = new HashSet<SourceCodeData>(pkgClassMethodList);
	    int rowNum = 0;
	    for (SourceCodeData temp : uniqueSet) {
	    	row = sheet.createRow((int) rowNum + 1);  
            row.createCell((short) 0).setCellValue(temp.getVpackage()+"."+temp.getVclass()+"."+temp.getVmethod());  
            //row.createCell((short) 1).setCellValue(temp.getVclass());  
            //row.createCell((short) 2).setCellValue(temp.getVmethod());
            double readability1 = lyfbrc.CaculateMethodNameReadability(temp.getVmethod());
            double readability2 = lyfbrc.calculateFuncBodyReadability(rowList,temp.getVpackage(), temp.getVclass(), temp.getVmethod());
            
            if(readability2>5){System.out.println(temp.getVpackage()+"."+temp.getVclass()+"."+temp.getVmethod()+": "+readability2);}
            
            row.createCell((short) 1).setCellValue(readability2);
            rowNum = rowNum + 1;
        }  
        try  
        {  
            FileOutputStream fout = new FileOutputStream("output/"+names.get(k)+"_funcBodyReadability.xls");  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }

		}
	
	}
}
