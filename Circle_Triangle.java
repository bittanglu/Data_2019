import java.util.*;  
import java.io.*;  
import java.lang.String;  
import java.util.Arrays;
public class Main  
{  
	public static int T;
	public static int radius;
	public static boolean is_Intersect(int x1,int y1,int x2,int y2,int x0,int y0){
		double d = 0;
		double x,y;
		double a,b,c;
		if (y1 == y2) {
			a = 0;b = 1;c = -y1;
		}else if (x1 == x2){
			a = 1;b = 0;c = -x1;
		}else{
			a = y1 - y2;
			b = x2 - x1;
			c = x1*y2 - y1*x2;
		}
		double dis1 = a*x0 + b*y0 + c;
		dis1 = dis1*dis1;
		double dis2 = (a*a + b*b)*radius*radius;
		if (dis1 > dis2) return false;
		double angle1 = (x0 - x1)*(x2 - x1) + (y0 - y1)*(y2 - y1);
		double angle2 = (x0 - x2)*(x1 - x2) + (y0 - y2)*(y1 - y2);
		if (angle1 > 0 && angle2 > 0)
			return true;
		return false;
	}
	public static double dis(int x1,int y1,int x2,int y2){
		return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
	}
    public static void main(String[] args)  
    {  
	    Scanner cin = new Scanner(System.in);
        T = cin.nextInt();
		for (int i = 1;i <= T;i++){
			int circular_x,circular_y;
			int x1,x2,x3,y1,y2,y3;
			circular_x = cin.nextInt();
			circular_y = cin.nextInt();
			radius = cin.nextInt();
			x1 = cin.nextInt();y1 = cin.nextInt();
			x2 = cin.nextInt();y2 = cin.nextInt();
			x3 = cin.nextInt();y3 = cin.nextInt();
			double dis1 = dis(x1,y1,circular_x,circular_y);
			double dis2 = dis(x2,y2,circular_x,circular_y);
			double dis3 = dis(x3,y3,circular_x,circular_y);
			if (dis1 < radius && dis2 < radius && dis3 < radius ){
				System.out.println("No");
			}else if((dis1 > radius && dis2 > radius && dis3 > radius)){
				if (is_Intersect(x1,y1,x2,y2,circular_x,circular_y) || is_Intersect(x3,y3,x2,y2,circular_x,circular_y) || is_Intersect(x1,y1,x3,y3,circular_x,circular_y))
				    System.out.println("Yes");
			    else System.out.println("No");
			}else {
				System.out.println("Yes");
			}
					
			
		}
    }  
}  