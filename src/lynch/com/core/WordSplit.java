package lynch.com.core;

import java.util.ArrayList;
import java.util.List;

public class WordSplit {
	
	private String[] strList;
	ArrayList<String> content = new ArrayList<String>();
	
	public ArrayList<String> splitWord(String word){
		
		
		
		if(word.endsWith("in")&&word.length()>=3)
		{
			   String str = word.substring(0,word.length()-2);
			   String newstr = str+"-";
			   word = word.replaceFirst(str, newstr);
		}
		else if(word.endsWith("out")&&word.length()>=4){
			   String str = word.substring(0,word.length()-3);
			   String newstr = str+"-";
			   word = word.replaceFirst(str, newstr);
		}
		
		
		if(HaveUpperChar(word)){
			
			word = MarkUpperChar(word);
			
		}
		
		if (word.contains("_")){
			word = word.replaceAll("_", "-");
		}
		
		
		
		//else{
		//	content.add(word.toLowerCase());
		//	return content;
		//}
		
		strList = word.split("-");
		for(String str: strList){
			if(IsNumber(str)){
				str = this.ChangeNumberToWord(str);
			}
			content.add(str.toLowerCase());
		}
		return content;
	}

	private boolean IsNumber(String word){
		boolean mark = false;
		if(word.equals("1")||word.equals("2")||word.equals("3")||
				word.equals("4")||word.equals("5")||word.equals("6")||
				word.equals("7")||word.equals("8")||word.equals("9")||word.equals("10"))
		{
			mark = true;
		}
		return mark;
	}
	
	private String ChangeNumberToWord(String number){
		String word ;
		if(number.equals("1"))
		{
			word = "one";
			return word;
		}
		else if(number.equals("2")){
			word = "two";
			return word;
		}
		else if(number.equals("3")){
			word = "three";
			return word;
		}
		else if(number.equals("4")){
			word = "four";
			return word;
		}
		else if(number.equals("5")){
			word = "five";
			return word;
		}
		else if(number.equals("6")){
			word = "six";
			return word;
		}
		else if(number.equals("7")){
			word = "seven";
			return word;
		}
		else if(number.equals("9")){
			word = "nine";
			return word;
		}
		else if(number.equals("8")){
			word = "eight";
			return word;
		}
		else if(number.equals("0")){
			word = "zero";
			return word;
		}
		else if(number.equals("10")){
			word = "ten";
			return word;
		}
		else{
			return number;
		}
		
	}
	
	private boolean HaveUpperChar(String word){
		boolean mark = false;
		for(int i = 1; i < word.length(); i++)
		  {
		   char c = word.charAt(i);
		   if (isSplitMark(c))
		   {
		    mark = true;
		    //System.out.println("true");
		   }
		  }
		
		return mark;
		
	}
	
	
	
	private boolean isSplitMark(char mark){
		boolean isTrue = false;
		if(Character.isUpperCase(mark)||Character.isDigit(mark)){
			isTrue = true;
		}
		
		return isTrue;
		
	}
	private  String MarkUpperChar(String word){
		//String newword = word;
		//System.out.println("Used");
		for(int i = 0; i < word.length()-1; i++)
		  {
		   char char1 = word.charAt(i);
		   char char2 = word.charAt(i+1);
		   if (isSplitMark(char1)&&!isSplitMark(char2)&&i!=0)
		   {
			   String str = String.valueOf(char1);
			   String newstr = "-"+String.valueOf(Character.toLowerCase(char1));
			   word = word.replaceFirst(str, newstr);
			   i++;
			   //System.out.println(word);
		   }
		   else if (isSplitMark(char1)&&isSplitMark(char2)&&i!=0)
		   {
			   int count = 1;
			   while(isSplitMark(word.charAt(i+count))){
				   if(i+count<word.length()-1){
				   count++;
				   }
				   else 
					   {
					   count++;
					   break;
					   }
			   }
			   
			   if(i+count<word.length()-1){
				   count--;
			   }
			   String str = word.substring(i, i+count);
			   String newstr = "-"+str+"-";
			   word = word.replaceFirst(str, newstr);
			   i = i+count+2;	   
			   //System.out.println(word);
		   }
		   else if (isSplitMark(char1)&&isSplitMark(char2)&&i==0)
		   {
			   int count = 1;
			   while(isSplitMark(word.charAt(i+count))&&i+count<word.length()){
				   if(i+count<word.length()-1){
					   count++;
					   }
				   else {
					   count++;
					   break;
					   }
			   }
			   if(i+count<word.length()-1){
				   count--;
			   }
			   String str = word.substring(i, i+count);
			   String newstr = str+"-";
			   
			   //char1 = word.charAt(i+count-1);
			   //String str = String.valueOf(char1);
			   //String newstr = "-"+String.valueOf(Character.toLowerCase(char1));
			   //word = word.replaceFirst(str, newstr);
			   i = i+count+1;
			   
			   
			  // System.out.println(word);
		   }
		   else if (!isSplitMark(char1)&&isSplitMark(char2)&&i==word.length()-2)
		   {
			   
			   String str = word.substring(0,i+1);
			   String newstr = str+"-";
			   word = word.replaceFirst(str, newstr);
			   i++;		   
			   //System.out.println(word);
		   }
		  }
		
		return word;
	}
	
	
}
