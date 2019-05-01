/**
 * Created by 唐路 on 2018/9/26.
 */

import java.io.File;
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileWriter;
import java.util.ArrayList;

public class cin{
    public static void main(String[] args){  
        try {
            String pathname = "D:java_learning\\RSSI\\indoor-radiomap-eeepc.txt"; 
            File filename = new File(pathname); 
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); 
            BufferedReader br = new BufferedReader(reader); 
            String line = null;
			ArrayList<RSSI> res = new ArrayList<RSSI>();
			line = br.readLine();
			String[] st = line.split(",");
			ArrayList<String> id = new ArrayList<String>();
			for (int i = 2;i < st.length;i++){
				id.add(st[i]);
			}
            while ((line = br.readLine())!=null){
				st = line.split(", ");
				int val = -90;
				double x = Double.parseDouble(st[0]);
				double y = Double.parseDouble(st[1]);
				RSSI temp = new RSSI(x,y);
				for(int i = 2;i < st.length;i++){
					if (!st[i].equals("NaN"))
						val = Integer.valueOf(st[i]);
					temp.addItem(id.get(i-2),val);
				}
				System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  