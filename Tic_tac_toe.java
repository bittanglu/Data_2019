import java.io.*;
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String args[]) throws Exception{
        Scanner s = new Scanner(System.in);
		//数据输入
        int n = s.nextInt();
		//判断坐标位置
		for (int i = 1;i <= n;i++){
			int x = s.nextInt();
		    int y = s.nextInt();
			if (y == 2 || y == 3){
		    System.out.println("Win");
			System.out.println("4");
		    }else{
		        if (x == 1 || x == 3){
			    System.out.println("Win");
			    System.out.println("6");
		        }else{
		        System.out.println("Equal");
			    System.out.println("0");
		        }
	        }
		}
		
	}
 }