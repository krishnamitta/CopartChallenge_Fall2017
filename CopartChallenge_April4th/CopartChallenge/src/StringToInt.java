import java.util.Scanner;

public class StringToInt {
	
	
	
	public int stringConversion(String str){
		
		int num =0;
		int len =str.length()-1;
		int i = 0;
		while(i<=len){
			char ch = str.charAt(i);
			int n = Character.getNumericValue(ch);
			num = (int) (num + (n * Math.pow(10, len-i)));
			i++;
			}
		
		return num;
	}
	
	public static void main(String[] args){
		
		System.out.println("Enter a string to convert");
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		StringToInt obj = new StringToInt();
		System.out.println(obj.stringConversion(s));
	    
	}
}
