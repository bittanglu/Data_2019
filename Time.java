import java.io.*;
import java.util.*;
public class Time
{  
	public static int T,h,s,m;
	public static String Time;
	public static int check(int number,int max){
		if (number >= max) return number%10;
		else return number;
	}
	public static void main(String args[]) throws Exception{
        Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int i = 1;i <= T;i++){
			Time = scanner.next();
			String[] Time_time = Time.split("\\:"); 
			h = Integer.parseInt(Time_time[0]);
			m = Integer.parseInt(Time_time[1]);
			s = Integer.parseInt(Time_time[2]);
			h = check(h,24);
			m = check(m,60);
			s = check(s,60);
			System.out.println(String.format("%02d",h) + ":" + String.format("%02d",m)+":" + String.format("%02d",s));
		}
	}
	
}  