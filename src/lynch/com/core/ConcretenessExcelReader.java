package lynch.com.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 
 
public class ConcretenessExcelReader {
 


    List<ConcretenessData> readXls() throws IOException {
        InputStream is = new FileInputStream("inputs/Concreteness_ratings_Brysbaert_et_al_BRM.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        ConcretenessData concretenessData = null;
        List<ConcretenessData> list = new ArrayList<ConcretenessData>();
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
                concretenessData = new ConcretenessData();

                HSSFCell word = hssfRow.getCell(0);
                if (word == null) {
                    continue;
                }
                concretenessData.setWord(getValue(word));
                
                HSSFCell bigram = hssfRow.getCell(1);
                if (bigram == null) {
                    continue;
                }
                concretenessData.setBigram(Double.parseDouble(getValue(bigram)));
                
                HSSFCell concretenessM = hssfRow.getCell(2);
                if (concretenessM == null) {
                    continue;
                }
                concretenessData.setConcretenessM(Double.parseDouble(getValue(concretenessM)));
                
                HSSFCell concretenessSD = hssfRow.getCell(3);
                if (concretenessSD == null) {
                    continue;
                }
                concretenessData.setConcretenessSD(Double.parseDouble(getValue(concretenessSD)));
                
                HSSFCell unknown = hssfRow.getCell(4);
                if (unknown == null) {
                    continue;
                }
                concretenessData.setUnknown(Double.parseDouble(getValue(unknown)));
                
                HSSFCell total = hssfRow.getCell(5);
                if (total == null) {
                    continue;
                }
                concretenessData.setTotal(Double.parseDouble(getValue(total)));
                
                HSSFCell percentage = hssfRow.getCell(6);
                if (percentage == null) {
                    continue;
                }
                concretenessData.setPercentage(Float.parseFloat(getValue(percentage)));
                
                list.add(concretenessData);
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