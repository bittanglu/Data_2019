import java.io.*;
import java.util.*;

class Main
{
	public long x,y;
	public static long gcd(long a,long b){
		if (b == 0)
			return a;
		else return gcd(b,a%b);
	}
	public static long extend_gcd(long a,long b,long x,long y){
		if (b == 0){
			x=1;y=0;
			return a;
		}else{
			long r = extend_gcd(b,a%b,x,y);
			long temp = x;
			x = y;
			y = temp - a/b*y;
			return r;
		}
	}
    public static void main(String args[]) throws Exception{
        Scanner s = new Scanner(System.in);
		//数据输入
        long x=s.nextLong();
		long y=s.nextLong();
		long m=s.nextLong();
		long n=s.nextLong();
		long L=s.nextLong();
		//数据转换
		long a = n - m,c = x - y;
		//判断是否有解
		long r = gcd(a,L);
		if (c % r != 0)  System.out.println("Impossible");
		else{
			a = a/r;c = c/r;L = L/r;
			extend_gcd(a,L,x,y);
			long ans = c * x - c * x /L * L;
			if (ans < 0) ans =ans + L;
			System.out.println(ans);
		}
	}
 }