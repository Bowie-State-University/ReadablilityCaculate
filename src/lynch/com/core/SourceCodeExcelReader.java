package lynch.com.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; 

import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 
 
public class SourceCodeExcelReader {
 


    List<SourceCodeData> readXls(String name) throws IOException {    	
			InputStream is = new FileInputStream("inputs/"+name+".xls");
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
	        SourceCodeData SourceCodeData = null;
	        List<SourceCodeData> list = new ArrayList<SourceCodeData>();
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
	            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
	            if (hssfSheet == null) {
	                continue;
	            }
	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
	                if (hssfRow == null) {
	                    continue;
	                }
	                SourceCodeData = new SourceCodeData();

	                HSSFCell Vpackage = hssfRow.getCell(0);
	                if (Vpackage == null) {
	                    continue;
	                }
	                SourceCodeData.setVpackage(getValue(Vpackage));
	                
	                HSSFCell Vclass = hssfRow.getCell(1);
	                if (Vclass == null) {
	                    continue;
	                }
	                SourceCodeData.setVclass(getValue(Vclass));
	                
	                HSSFCell Vmethod = hssfRow.getCell(2);
	                if (Vmethod == null) {
	                    continue;
	                }
	                SourceCodeData.setVmethod(getValue(Vmethod));
	                
	                HSSFCell Vtype = hssfRow.getCell(3);
	                if (Vtype == null) {
	                    continue;
	                }
	                SourceCodeData.setVtype(getValue(Vtype));
	                
	                HSSFCell Vname = hssfRow.getCell(4);
	                if (Vname == null) {
	                    continue;
	                }
	                SourceCodeData.setVname(getValue(Vname));
	                
	                HSSFCell VlineNum = hssfRow.getCell(5);
	                if (VlineNum == null) {
	                    continue;
	                }
	                SourceCodeData.setVlineNum(getValue(VlineNum));
	                

	                
	                list.add(SourceCodeData);
	            }
	        }
	        
	        return list;
	
	}
 

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
 
}