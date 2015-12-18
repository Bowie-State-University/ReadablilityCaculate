package lynch.com.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testcase2 {
	public static void main(String[] args) throws IOException {
		WordSplit ws = new WordSplit();
		List<String> wordList = new ArrayList<String>();
        //wordList = ws.splitWord("Value3");
        //for(int i= 0; i < wordList.size();i++){
		//System.out.println(wordList.get(i));}
        
        FuncBodyReadabilityCalculate lyfbrc = new FuncBodyReadabilityCalculate();
        System.out.println(lyfbrc.CaculateMethodNameReadability("valueName"));
        System.out.println(lyfbrc.CaculateMethodNameReadability("Name"));
        System.out.println(lyfbrc.CaculateMethodNameReadability("value"));
        //double time = 50.0/(40.0*60.0);
        //double mun = 0.85*Math.pow(100, -0.12);
        		//1.84/(Math.pow(Math.log(60)/Math.log(10.0), 1.25)+1.84);
        //System.out.println(time);
        //System.out.println(mun);
	}
}
