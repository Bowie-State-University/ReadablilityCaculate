package lynch.com.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcretenessCalculate {
	private double averageConM;
	private int rowNum;
    List<String> allWordList = new ArrayList<String>();
    List<Double> allConMList = new ArrayList<Double>();
    

    ConcretenessCalculate() throws IOException{
    	ConcretenessExcelReader ConcretenessExcelReader = new ConcretenessExcelReader();
    	List<ConcretenessData> list = ConcretenessExcelReader.readXls();
     	ConcretenessData xls = new ConcretenessData();
 	    for (int i = 0; i < list.size(); i++) {
 	        xls = (ConcretenessData) list.get(i);
 	        allWordList.add(xls.getWord());
 	        allConMList.add(xls.getConcretenessM());
 	    }
    }
     

	public double calculateConc(List<String> wordList) {
		double sum = 0.0;
	    int count = 0;
		for (int i = 0; i < wordList.size(); i++){
			if(!wordList.get(i).isEmpty()){
				count++;
			}
			if (allWordList.contains(wordList.get(i)) == true){
				rowNum = allWordList.indexOf(wordList.get(i));
			    sum = sum + allConMList.get(rowNum);
			}
			else{
				sum = sum + 0;
				//System.out.println("no result");
			}
		}
		averageConM = sum / count;
		
		return averageConM;
		
	}

}
