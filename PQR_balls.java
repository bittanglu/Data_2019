import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
		int[] a = new int[3];
		for (int i =0;i < 3;i++)
			a[i] = in.nextInt();
		bubble_sort(a);
		int np = a[0],nq = a[1],nr = a[2];
		if (np > nq + nr + 1) {
			System.out.println(0);
			return ;
		}else if (np == nq + nr + 1){
			System.out.println(getCombations(np-1,nr+nq)*getCombations(nq+1,nr));
			return ;
		}
		int count = 0,j;
		j = np - 1 - nq;
		count += getCombations(np-1,nq)*getCombations(2*nq + 2,nr - j);
		if (nq > 1){
			j = np - nq;
			count += 2*getCombations(np-1,nq-1)*getCombations(2*nq,nr - j);
			j = np - nq + 1;
			if (nr >= j)count += getCombations(np-1,nq-2)*getCombations(2*nq - 2,nr - j);
		}else{
			j = np - nq;
			count += 2*getCombations(np-1,nq-1)*getCombations(2*nq,nr - j);
		}
		System.out.println(count);
	}
	//计算组合
	public static int getCombations(int n,int m){
		if(m == 0) return 1;
		int fenmu = 1,fenzi = 1;
		int i,j;
		for (i = n,j = m;j > 0 && i > 0;j--,i--)
			fenzi *= i;
		for (i = 1,j = m;j > 0;j--,i++)
			fenmu *= i;
		return fenzi/fenmu;
	}
	//冒泡排序
	public static void bubble_sort(int[] a){
		int i,j,n = a.length;
		for(i = 0;i < n-1;i++)
			for (j = n - 1;j>i;j--)
				if(a[j] > a[j-1])
				{
					int tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
		
	}	
}
