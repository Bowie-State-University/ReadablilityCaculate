package lynch.com.core;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FuncBodyReadabilityCalculate {
    
	private double methodNameReadability;
	public double calculateFuncBodyReadability(List<SourceCodeData> rowList,String pkgName, String className, String funcName) throws IOException{
	   
		SourceCodeData lyjrd = new SourceCodeData();
	    SourceCodeExcelReader lyjrer = new SourceCodeExcelReader();
	    double funcBodyReadability = 0.0;
	    int totalOfVar = 0;
	    double totalOfVreadability = 0.0;
	    for (int i = 0; i < rowList.size(); i++) {
	    	lyjrd = rowList.get(i);
	    	
	    	if (lyjrd.getVpackage().equals(pkgName) && lyjrd.getVclass().equals(className) && lyjrd.getVmethod().equals(funcName)){
	    		List<Integer> lineNumList = new ArrayList<Integer>();
	    		String strLineNum = lyjrd.getVlineNum();
	    		strLineNum=strLineNum.replace("    [",", ");
	    		strLineNum=strLineNum.replace("]","");
	    		String[] splitLineNum = strLineNum.split(", ");
	    	    for (int j = 0; j < splitLineNum.length; j++) {
	    	    	int a = Integer.valueOf(splitLineNum[j]);
	    	    	lineNumList.add(a);
	    	    }
    	    	int lineOfDeclaration = lineNumList.get(0);
    	    	double sumOfDist = 0;
    	    	double countOfDist = 0;
    	    	
	    	    if (lineNumList.size() > 0){
	    	        for (int k = 1; k < lineNumList.size(); k++){
	    	        	sumOfDist = sumOfDist + Math.abs(lineNumList.get(k) - lineOfDeclaration);
	    	        	countOfDist ++;
	    	        }
	    	        
	    	            WordSplit ws = new WordSplit();
	        	        ConcretenessCalculate lycc = new ConcretenessCalculate();
	        	        List<String> wordList = new ArrayList<String>();
	        	        wordList = ws.splitWord(lyjrd.getVname());
	        	        double avgOfDist = 0;
	        	        if(countOfDist!=0){
	        	        	avgOfDist = sumOfDist/countOfDist;
	        	        	}
	        	        
	        	        double concM = lycc.calculateConc(wordList);
	        	        if(concM>5){System.out.println(lyjrd.getVname()+": "+concM);}
	        	        
	        	        double memoryRemain = 1;
	        	        if(avgOfDist>0){
	        	        memoryRemain = 0.85*Math.pow((avgOfDist/30.0), -0.12);
	        	        //1.84/(Math.pow(Math.log(avgOfDist/30)/Math.log(10.0), 1.25)+1.84);
	        	        }
	        	        
	        	        if(memoryRemain>=1){
	        	        	
	        	        	memoryRemain =1;
	        	        	
	        	        }	        
	        	        double Vreadability = concM*memoryRemain;
	        	        // Forget curve
	        	        
	        	        if(memoryRemain>1){
	        	        	
	        	        	System.out.println("error");
	        	        	
	        	        }
	        	        totalOfVar = totalOfVar + 1;
	        	        totalOfVreadability = totalOfVreadability + Vreadability;
	    	        

	        	    
	    	    }
	    	    else {
	    	    	
	    	    	//funcBodyReadability = 0;
	    	    	
	    	    }
	    	}

	    }
	    funcBodyReadability = totalOfVreadability/totalOfVar;
	    
	   
	    
	    return funcBodyReadability;
	    	
	}
	
	public double CaculateMethodNameReadability(String funcName) throws IOException{
		 	WordSplit ws = new WordSplit();
		    ConcretenessCalculate lycc = new ConcretenessCalculate();
		    List<String> wordList1 = new ArrayList<String>();
	        wordList1 = ws.splitWord(funcName);
	    	methodNameReadability = lycc.calculateConc(wordList1);
	    	
			return methodNameReadability;
	}
}

