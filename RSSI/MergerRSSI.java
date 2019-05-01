import java.util.*;
import java.io.*; 
public class MergerRSSI{
	public static void main(String[] args){
		ArrayList<RSSI> list_A = new ArrayList<RSSI>();
		ArrayList<RSSI> list_B = new ArrayList<RSSI>();
		try {
				String pathname = "D:\\java_learning\\RSSI\\database_file\\4-8.txt"; 
				RSSI.readFromFileNoVar(list_A,pathname);
			}catch (Exception e){
				e.printStackTrace();
			}
		int len = list_A.size();
		System.out.println("size_A:"+len);
		int count = 1;
		for(int i = 0;i < len/30;i++){
			ArrayList<RSSI> list_C = new ArrayList<RSSI>();
			for(int j = 0;j < 30;j++){
				list_C.add(list_A.get(i*30+j));
			}
			RSSI temp = new RSSI(list_A.get(i*30).x,list_A.get(i*30).y);
			temp.merge(list_C);
			list_B.add(temp);
		}
		try {
				String pathname = "D:\\java_learning\\RSSI\\database_file\\4.8_merge.txt"; 
				RSSI.writeToFile(list_B,pathname);
			}catch (Exception e){
				e.printStackTrace();
			}
	}
}