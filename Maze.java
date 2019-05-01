import java.util.*;  
import java.io.*;  
import java.lang.String;  
import java.util.Arrays;
public class Main  
{  
	public static int pic[][] = new int[501][501];    
	public static int dis[] = new int[501];          
	public static int val[] = new int[501];           
	public static int ans[] = new int[501];           
	public static boolean vis[] = new boolean[501];   
	public static int  m,n,start,end;
	public static void find(){
		for (int i = 0;i < n;i++)
			dis[i] = pic[start][i];
		dis[start] = 0;
		ans[start] = val[start];
		for (int i = 0;i < n;i++){
			int min = 1000;
			int u = start;
			for (int j = 0;j < n;j++ )
				if (!vis[j] && dis[j] < min){
					u = j;
					min = dis[j];
				}
				vis[u] = true;
				for (int j = 0;j < n;j++){
					if (dis[j] > dis[u] + pic[u][j]){
						dis[j] = dis[u] + pic[u][j];
						ans[j] = ans[u] + val[j];
					}else if(dis[j] == dis[u] + pic[u][j]){
						ans[j] = Math.max(ans[j],ans[u] + val[j]);
					}
				}
		}
	}
    public static void main(String[] args)  
    {  
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		start = cin.nextInt();
		end = cin.nextInt();
		for (int i = 0;i < n;i++)
			for (int j = 0; j < n;j++)
				pic[i][j] = 65536;
		for (int i = 0;i < n;i++)
			val[i] = cin.nextInt();
		for (int i = 0;i < m;i++){
			int x,y;
			x = cin.nextInt();
			y = cin.nextInt();
			pic[x][y] = pic[y][x] =  cin.nextInt();
		}
		find();
		System.out.print(dis[end]);
		System.out.print(' ');
		System.out.println(ans[end]);
    }  
}  