/**
 * Created by 唐路 on 2018/9/26.
 */
import java.util.*;
import java.io.*;  
import java.util.ArrayList;

public class cin{
	public static int min_rssi = -105;
	public static void Save_bp_data(ArrayList<ArrayList<Double>> dis_list,ArrayList<Integer> k_list){
		String Filename = "java_learning\\RSSI\\bp_data.txt";
		int len = k_list.size();
		try{
			FileWriter writer = new FileWriter(Filename,false);
			for(int i = 0;i < len;i++){
				ArrayList<Double> temp = dis_list.get(i);
				for(int j = 0;j < temp.size();j++){
					writer.write(Double.toString(temp.get(j)) + "  ");
				}
				writer.write(Integer.toString(k_list.get(i)) + "\n");
			}
			writer.flush();
	        writer.close();
		}catch (Exception e){
            e.printStackTrace();  
        } 
	}
	public static void print_list(ArrayList<Double> error_list){
		String Filename = "java_learning\\RSSI\\EWKNN.txt";
		int len = error_list.size();
		try{
			FileWriter writer = new FileWriter(Filename,false);
			for(int i = 0;i < len;i++){
				 writer.write(Double.toString(error_list.get(i)) + "  ");
			}
			writer.flush();
	        writer.close();
		}catch (Exception e){
            e.printStackTrace();  
        }
	}
    public static void main(String[] args){
		ArrayList<RSSI> list = new ArrayList<RSSI>();
		ArrayList<RSSI> res = new ArrayList<RSSI>();
		ArrayList<Double> error_list = new ArrayList<Double>();
        try { 
            String pathname = "D:java_learning\\RSSI\\indoor-radiomap-eeepc.txt"; 
            File filename = new File(pathname); 
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); 
            BufferedReader br  = new BufferedReader(reader); 
            String line = null;
			line = br.readLine();
			String[] st = line.split(",");
			ArrayList<String> id = new ArrayList<String>();
			for (int i = 2;i < st.length;i++){
				id.add(st[i]);
			}
			int count = 0;
			int val = min_rssi;
            while ((line = br.readLine())!=null){
				st = line.split(", ");
				double x = Double.parseDouble(st[0]);
				double y = Double.parseDouble(st[1]);
				RSSI temp = new RSSI(x,y);
				for(int i = 2;i < st.length;i++){
					if (!st[i].equals("NaN"))
						val = Integer.valueOf(st[i]);
					else
						val = min_rssi;
					temp.addItem(id.get(i-2),val);
				}
				list.add(temp);
				count++;
				if (count == 20){
					count = 0;
					RSSI data = new RSSI(x,y);
					data.merge(list);
					list.clear();
					res.add(data);
				}
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
		try{
			double err_sum = 0;
			int count = 0;
			String pathname = "D:java_learning\\RSSI\\indoor-test-eeepc.txt"; 
            File filename = new File(pathname); 
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); 
            BufferedReader br = new BufferedReader(reader); 
            String line = null;
			line = br.readLine();  
			String[] st = line.split(",");
			ArrayList<String> id = new ArrayList<String>();
			for (int i = 2;i < st.length;i++){
				id.add(st[i]);
			}
			int val = min_rssi;
			ArrayList<Integer> output_k = new ArrayList<Integer>();
			ArrayList<ArrayList<Double>> dis_list = new ArrayList<ArrayList<Double>>();
			while ((line = br.readLine())!=null){
				st = line.split(", ");
				double x = Double.parseDouble(st[0]);
				double y = Double.parseDouble(st[1]);
				RSSI temp = new RSSI();
				for(int i = 2;i < st.length;i++){
					if (!st[i].equals("NaN"))
						val = Integer.valueOf(st[i]);
					else
						val = min_rssi;
					temp.addItem(id.get(i-2),val);
				}
				//bp-net data
				
				double error_min = Double.MAX_VALUE;
				int optimization_k = 0;
				ArrayList<Double> dis_temp = null;
				/*
				for(int k = 1;k <= 10;k++){
					ArrayList<Double> dis_current = new ArrayList<Double>();
					temp.WKNN(res,k,dis_current);
					double error = Math.sqrt((x - temp.x)*(x - temp.x) + (y - temp.y)*(y - temp.y));
					if(error < error_min) {
						optimization_k = k;
						error_min = error;
						dis_temp = dis_current;
					}
				}
				output_k.add(optimization_k);
				dis_list.add(dis_temp);
				*/
				temp.EWKNN(res);
				double error = Math.sqrt((x - temp.x)*(x - temp.x) + (y - temp.y)*(y - temp.y));
				error_list.add(error); 
				err_sum += error;
				
				count ++;
				//System.out.println(error);
			}
			//Save_bp_data(dis_list,output_k);
			print_list(error_list);
			//System.out.println("average_erorr");
			System.out.println(err_sum/count);
		}catch (Exception e){
            e.printStackTrace();
        }
    }  
}  