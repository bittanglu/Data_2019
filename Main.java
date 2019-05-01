import java.util.*;

public class Main {
    public static int count = 0;
	public static int n = 0,d = 0;
	public static void getCombations(int num,int current){
		if (num == 0){
			
		}
		if (num < 0) return ;
		for(int i = 1;i <= d;i++)
			getCombations(num - i,current+1);
	}
    public static void main(String[] args){
        Scanner in = new Scanner(System.in); 
        int t = in.nextInt();
        while(t > 0){
            t--;
            n = in.nextInt();
            d = in.nextInt();
            count = 0;
			int game = n/2;
			for(int i = 1;i <= d;i++)
				getCombations(game - i,1);
        }
    }
}
