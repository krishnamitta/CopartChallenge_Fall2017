import java.util.Scanner;

public class LicenseKeys {

	public String stringFormat(String str, int k){
		
		String result = "";
		int len = str.length()-1;
		int i =0;
		int j =0;
		
		while(i<=len){
			
			char ch = str.charAt(i);
			if(ch!='-'){
				result += ch;
				j=j+1;
			}
			if(j==4){
				if(i!=len){
				result += '-';
				j=0;
				}
			}
			i++;
		}
		
		return result.toUpperCase();
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String");
		String str = scan.next();
		System.out.println("Enter the value of k");
		int k = scan.nextInt();
		LicenseKeys obj = new LicenseKeys();
		
		System.out.println(obj.stringFormat(str,k));
		
	}
}
