import java.util.*;
import java.io.*; 
public class ap{
	public static void main(String[] args){
		
		ArrayList<RSSI> list = new ArrayList<RSSI>();
		try {
            String pathname = "D:\\java_learning\\RSSI\\database_file\\all_database_4_8.txt"; 
            RSSI.readFromFile(list,pathname);
		}catch (Exception e){
            e.printStackTrace();
        }
		for(int i = 0;i < list.size();i++){
			System.out.println(list.get(i).y);
		}
	}
}