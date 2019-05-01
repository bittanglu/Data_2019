import java.io.*;
import java.util.*;

public class Main
{
	public static int a[][] = new int[101][101],b[] = new int[101],used[] = new int[101];
	public static int m,n;
	
	public static boolean find_cp(int i){
		for (int j = m+1 ;j <= n ;j++){
			if (a[i][j] == 1 && used[j] == 0) {
				used[j] = 1;
				if (b[j] == 0 || find_cp(b[j])){
					b[j] = i; return true;
				}
			}
		}
		return false;
	}
	
    public static void main(String args[]) throws Exception{
        Scanner s = new Scanner(System.in);
		//数据输入
        m = s.nextInt();
		n = s.nextInt();
		int x,y;
		int number = 0;
		while(true){
			x = s.nextInt();y = s.nextInt();
			if (x == -1 || y == -1){
			    break;
			}
			a[x][y] = 1;
		}
		for (int i=1 ;i <= m ; i++){
			for (int k = m;k <= n;k++) used[k] = 0;
			if (find_cp(i)) number++;
		}
		System.out.println(number);
		
	}
 }