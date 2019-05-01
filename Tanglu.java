import java.util.*;
public class Tanglu {
	public static int getScore(String st1,String st2){
		String tab1 = "qwertasdfgzxcv";
		String tab2 = "yuiophjklbnm";
		if (st1 == null || st1.length() < 1) return st2.length()*3;
		int n = st1.length(),m = st2.length();
		String s1 = st1,s2 = st2;
		int socre = 0;
		int count = Math.abs(n-m);
		if (n > m) {
			s1 = st2;
			s2 = st1;
		}
		int i = 0,j = 0;
		while(i < n && j < m){
			String ch1 = String.valueOf(s1.charAt(i)),ch2 = String.valueOf(s2.charAt(j));
			if (ch1.equals(ch2)){
				i++;j++;
			}else if ((tab1.contains(ch1) && tab1.contains(ch2)) || (tab2.contains(ch1) && tab2.contains(ch2))){
				if (count > 0){
					socre += Math.min(getScore(s1.substring(i+1,s1.length()),s2.substring(j+1,s2.length()))+1,getScore(s1.substring(i,s1.length()),s2.substring(j+1,s2.length()))+3);
					return socre;
				}else{
					socre += 1;
					i++;
					j++;
				}
			}else {
				if (count > 0) {
					socre += Math.min(getScore(s1.substring(i+1,s1.length()),s2.substring(j+1,s2.length()))+2,getScore(s1.substring(i,s1.length()),s2.substring(j+1,s2.length()))+3);
					return socre;
				}else{
					socre += 2;
					i++;j++;
				}
			}
		}
		socre += (m-j)*3;
		return socre;
	}
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
		String[] words = in.nextLine().split(" ");
        if (words == null || words.length <= 1) {
            return ;
        }
		int[] a = new int[words.length];
		int[] b = new int[words.length];
		int i;
		for (i = 1;i < words.length;i++){
			a[i] = i;
		}
		for (i = 1;i < words.length;i++){
			b[i] = getScore(words[0],words[i]);
		}
		bubble_sort(b,a);
		for (i = 1;i < 3 && i < words.length - 1;i++){
			System.out.print(words[a[i]]);
			System.out.print(" ");
		}
		if (3 < words.length) System.out.println(words[a[3]]);
        else System.out.println(words[a[words.length-1]]);
    }
	//冒泡排序
	public static void bubble_sort(int[] a,int[] b){
		int i,j,n = b.length;
		for(i = 1;i < n - 1;i++)
			for (j = n - 1;j > i;j--)
				if(a[j] < a[j-1])
				{
					int tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
					
					tmp = b[j];
					b[j] = b[j-1];
					b[j-1] = tmp;
				}
		
	}
}
