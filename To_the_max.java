import java.io.*;
import java.util.*;

class Main
{
	static int max = -127,N;
	static int myData[][] = new int[101][101];
	static int Dy[][] = new int[101][101];
    public static void main(String args[]) throws Exception{
            Scanner s = new Scanner(System.in);
            N = s.nextInt();
			int i,j;
			for (i=1;i<=N;i++)
				for (j=1;j<=N;j++){
					myData[i][j] = s.nextInt();
					Dy[i][j]=Dy[i][j-1] + myData[i][j];
				}
			int sum=0;
			for (i=1;i<=N;i++){
				for (j=i;j<=N;j++){
					sum = 0;
					for (int k=0;k<=N;k++){
						if(sum<0) sum=0;
						sum+=Dy[k][j]-Dy[k][i-1];
						if(sum>max) max=sum;
					}
				}
			}
			System.out.println(max);
        }
	
 }