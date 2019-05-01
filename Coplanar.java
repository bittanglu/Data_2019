import java.util.*;  
import java.io.*;  
import java.lang.String;  
import java.util.Arrays;
public class Coplanar  
{  
	public static class Mypoint{
	    public int x,y,z;
		public Mypoint() {
			x = 0;y = 0;z = 0;
		}
		public Mypoint(int x,int y,int z) {
			this.x = x;this.y = y;this.z = z;
		}
	}
	public static int is_coplanar(Mypoint a,Mypoint b,Mypoint c){
		return a.x*b.y*c.z + a.y*b.z*c.x + b.x*c.y*a.z - a.z*b.y*c.x - a.y*b.x*c.z - a.x*b.z*c.y ;
	}
    public static void main(String[] args){
	     int N ;
		 Scanner cin = new Scanner(System.in);
		 N = cin.nextInt();
		 for (int i = 1;i <= N;i++){
			 Mypoint a,b,c,d,ab,ac,bc,ad;
			 a = new Mypoint(cin.nextInt(),cin.nextInt(),cin.nextInt());
			 b = new Mypoint(cin.nextInt(),cin.nextInt(),cin.nextInt());
			 c = new Mypoint(cin.nextInt(),cin.nextInt(),cin.nextInt());
			 d = new Mypoint(cin.nextInt(),cin.nextInt(),cin.nextInt());
			 ab = new Mypoint(a.x - b.x,a.y - b.y,a.z - b.z);
			 ac = new Mypoint(a.x - c.x,a.y - c.y,a.z - c.z);
			 ad = new Mypoint(a.x - d.x,a.y - d.y,a.z - d.z);
			 if (is_coplanar(ab,ac,ad) == 0) System.out.println("Yes");
			 else System.out.println("No");
		 }
    } 
}  