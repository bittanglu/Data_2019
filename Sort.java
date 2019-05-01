import java.util.*;
public class Sort {
	//插入排序
	public static void insertion_sort(int[] a){
		int i,j,v,n = a.length;
		for (i = 1;i < n;i++){
			v = a[i];j = i - 1;
			while(j >= 0 && a[j] > v)
			{
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = v;
		}
	}
	//选择排序
	public static void selection_sort(int[] a){
		int i,j,pos,tmp,n = a.length;
		for (i = 0;i < n-1;i++){
			pos = i;tmp = a[i];
			for (j = i+1;j < n;j++)
				if (a[j] < tmp){
					tmp = a[j];
					pos = j;
				}
				if (pos != i){
					a[pos] = a[i];
					a[i] = tmp;
				}
		}
		
	}
	//冒泡排序
	public static void bubble_sort(int[] a){
		int i,j,n = a.length;
		for(i = 0;i < n-1;i++)
			for (j = n - 1;j>i;j--)
				if(a[j] < a[j-1])
				{
					int tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
		
	}
	//归并排序
	public static void MergeArray(int[] a,int low,int mid,int high){
		int n = a.length;
		int i = low,j = mid+1,index = 0;
		int[] b = new int[high-low+1];
		while(i <= mid && j <= high){
			if (a[i] < a[j]) b[index++] = a[i++];
			else b[index++] = a[j++];
		}
		while(i <= mid) b[index++] = a[i++];
		while(j <= high) b[index++] = a[j++];
		for (i = low;i <= high;i++)
			a[i] = b[i-low];
	}
	public static void MergeSort(int[] a,int p,int q){
		if (p < q){
			int mid = (p+q)/2;
			MergeSort(a,p,mid);
			MergeSort(a,mid+1,q);
			MergeArray(a,p,mid,q);
		}
	}
	//快排
	public static void QuickSort(int[] a,int p,int q){
		if(p >= q) return ;
		int i = p,j = q;
		int index = a[i];
		while(i < j){
			while(i<j && a[j] >= index) j--;
			if (i < j) a[i++] = a[j];
			while(i < j && a[i] < index) i++;
			if (i < j) a[j--] = a[i];
		}
		a[i] = index;
		QuickSort(a,p,i);
		QuickSort(a,i+1,q);
	}
	//希尔排序
	public static void shellSort(int[] a){
		int len = a.length;
		int i,j,h;
		int temp;
		for (h = len/2;h>0;h=h/2){
			for (i = h;i < len;i++){
				temp = a[i];
				for (j = i - h;j >= 0;j = j-h)
					if (a[j] > temp)
						a[j+h] = a[j];
					else
						break;
				a[j+h] = temp;
			}
		}
	}
	//myMinHeapSort
	public static void adjustMinHeap(int[] a,int pos,int len){
		int temp,child;
		for(temp = a[pos];2 * pos + 1 <= len ;pos = child){
			child = 2 * pos + 1;
			if (child < len && a[child] > a[child+1])
				child++;
			if (a[child] < temp)
				a[pos] = a[child];
			else 
				break;
		}
		a[pos] = temp;
	}
	public static void myMinHeapSort(int[] a){
		int i;
		int len = a.length;
		for(i = len/2 - 1;i >= 0;i--)
			adjustMinHeap(a,i,len-1);
		for(i = len - 1;i >= 0;i--){
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			adjustMinHeap(a,0,i-1);
		}
	}
    public static void main(String[] args){
        int[] a = {1,5,3,2,6,7,9,10,5,4,2,0};
		myMinHeapSort(a);
		System.out.println("myMinHeapSort:");
		Print(a);
    }
	public static void Print(int[] a){
		for (int i = 0;i < a.length;i++){
			System.out.print(a[i]);
			System.out.print(" ");
        }
	}
}
