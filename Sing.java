import java.util.Scanner;

public class Sing {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int A = sc.nextInt(),X = sc.nextInt();
        int B = sc.nextInt(),Y = sc.nextInt();
        for (int i = 0;i <X;i++){
            if (i * A > K) break;
            for (int j = 0;j < Y;j++){
                if (i * A + j * B == K){
                    count = count + Cfun(X,i)*Cfun(Y,j);
                    if (count > 1000000007) count = count % 1000000007; 
                }else if (i * A + j * B > K) 
                    break;
            }
        }
        System.out.println(count);
    }
	public static int Cfun(int n,int m){
		return getJecheng(n)/(getJecheng(m)*getJecheng(n-m));
	}
    public static int getJecheng(int num){
        int res = 1;
        if (num == 0) return res;
        else {
            for (int i = 2;i <= num;i++)
                res = res * i;
            return res;
        }
    }
}