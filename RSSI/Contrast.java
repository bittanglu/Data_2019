
/**
 * Created by 唐路 on 2018/9/26.
 */
import java.util.*;
import java.io.*;  
import java.util.ArrayList;

public class Contrast{
	public static int min_rssi = -105;
    public static void main(String[] args){
		ArrayList<RSSI> list = new ArrayList<RSSI>();
		ArrayList<RSSI> res = new ArrayList<RSSI>();
		int k = 3;
        try {
            String pathname = "D:\\java_learning\\RSSI\\database_file\\4.3_data.txt"; 
            RSSI.readFromFileNoVar(list,pathname);
			int x = 5,y =5;
			for(int i = x*30;i < x*30 + 30;i++){
				System.out.println(list.get(i).BSSID.size());
			}
			/*
			for(int i = y*30;i < y*30 + 30;i++){
				System.out.println(list.get(i).BSSID.size());
			}
			*/
		}catch (Exception e){
            e.printStackTrace();
        }		
		try{
			double err_sum = 0;
			//String pathname = "D:\\java_learning\\RSSI\\direction\\12_11.txt";
			//RSSI.readFromFileNoVar(res,pathname);
			//System.out.println("average_error:" + err_sum/len);
		}catch (Exception e){
            e.printStackTrace();
        } 
    }  
}  