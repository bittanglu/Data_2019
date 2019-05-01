import java.util.*;  
import java.io.*;  
import java.lang.String;  
import java.util.Arrays;
public class Main  
{  
	public static String st;
	public static int size = 0;
	public static void next_array(char[] num){
		boolean is_find = false;
		int x = size;
		for (int i = 1;i < size ;i++)
			if (num[size - 1 - i] < num [size - i]){
				is_find = true;
				x = size - 1 - i;
				break;
			}
		if (is_find == true){
			for (int i = 1;i < size ;i++)
			if (num[size - i] > num[x]) {
				char ch = num[x];
				num[x] = num[size - i];
				num[size - i] = ch;
				break;
			}
			int j = size - 1;
		    for (int i = x + 1;i < j ;i++){
				char ch = num[i];
				num[i] = num[j];
				num[j] = ch;
				j--;
			}
			System.out.println(num);
			next_array(num);
		}
		
	}
    public static void main(String[] args)  
    {  
		Scanner cin = new Scanner(System.in);
		st = cin.next();
		size = st.length();
		char[] num = st.toCharArray();
		for (int i = 0;i < size - 1;i++)
			for (int j = i + 1;j < size;j++)
				if (num[i] > num[j]) {
					char ch = num[i];
					num[i] = num[j];
					num[j] = ch;
				}
		System.out.println(num);
		next_array(num);
    }  
}  