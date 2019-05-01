import java.util.*;  
import java.io.*;  
import java.lang.String;  
import java.util.Arrays;
public class Line_up_water
{  
    public static int N,sum;
	public static int a[] = new int[1001];
    public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		for (int i = 0;i < N;i++){
			a[i] = s.nextInt();
		}
		for (int i = 0;i < N-1;i++){
			for (int j = i+1;j < N;j++){
				if(a[i] > a[j]){
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		
		for (int i = 0;i < N;i++){
			sum = sum + a[i]*(N - i);
		}
		System.out.println(sum);
	
	
    }
	
}  