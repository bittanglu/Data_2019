
/**
 * Created by 唐路 on 2018/9/26.
 */
import java.util.*;
import java.io.*;  
import java.util.ArrayList;

public class test{
	public static int min_rssi = -105;
    public static void main(String[] args){
		ArrayList<RSSI> list = new ArrayList<RSSI>();
		ArrayList<RSSI> res = new ArrayList<RSSI>();
		int k = 3;
        try {
            String pathname = "D:\\java_learning\\RSSI\\database_file\\all_database_4_8.txt"; 
            RSSI.readFromFile(list,pathname);
		}catch (Exception e){
            e.printStackTrace();
        }
		
        ArrayList<Double> angle_pdr =new ArrayList<Double>();
		ArrayList<Double> step_list =new ArrayList<Double>();
		try {
            String pathname = "D:\\java_learning\\RSSI\\direction\\pdr_data1.txt"; 
			File filename = new File(pathname);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			while((line = br.readLine())!= null){
				String[] st = line.split(",");
				double angle = Double.parseDouble(st[0]);
				angle_pdr.add(angle);
				step_list.add(Double.parseDouble(st[1]));
				//System.out.println(angle);
			}
		}catch (Exception e){
            e.printStackTrace();
        }
		try{
			double err_sum = 0;
			String pathname = "D:\\java_learning\\RSSI\\direction\\wifi_data5.txt";
			RSSI.readFromFileNoVar(res,pathname);
			int len = res.size();
			pdr_rssi res_cal = new pdr_rssi();
			
 			double x = 0;
			double y = 0;
			double step_length = 0.62;
			int count_step = 10;
			for(int i = 0;i < len; i++){
			    RSSI temp = res.get(i);
				if(i == 0){
					temp.Varity_WKNN(list);
					x = temp.x;
					y = temp.y;
					System.out.println(x+","+y);
					continue;
				}
				ArrayList<Double> p_wifi = new ArrayList<Double>();
				ArrayList<Double> p_fianl = new ArrayList<Double>();
				res_cal.setPonitPdr(x,y);
				res_cal.setAnglePdr(angle_pdr.get(i));
				res_cal.setDistancePdr(step_list.get(i));
				//通过数据库database，计算出相似节点列表res_cal.location_list以及相似度p_wifi
				temp.EWKNN(list,p_wifi,res_cal.location_list);
				//计算角度和距离差
				res_cal.calAngleList();
				res_cal.calDistanceList();
				//计算概率
				res_cal.calProbability(res_cal.angle_list,res_cal.probability_angle);
				res_cal.calProbability(res_cal.distance_error_rssi,res_cal.probability_distance);
				//权重融合
				res_cal.weightNormalization(p_wifi,res_cal.probability_distance,res_cal.probability_angle,p_fianl,0.2);
				
				res_cal.calFinalPoint(p_fianl,res_cal.location_list);
				
				res_cal.clearAll();
				
				x = x+step_list.get(i)*Math.cos(Math.toRadians(angle_pdr.get(i)));
				y = y+step_list.get(i)*Math.sin(Math.toRadians(angle_pdr.get(i)));
				count_step++;
				if(Double.isNaN(res_cal.point_final.getX())){
					res_cal.setPonitFinal(x,y);;
				}else{
					;
				}
				if(count_step % 10 == 0) {
					x = res_cal.point_final.getX();
					y = res_cal.point_final.getY();
				}
				System.out.println(res_cal.point_final.getX()+","+res_cal.point_final.getY());
				//temp.EWKNN(list,new ArrayList<Double>(),new ArrayList<location>());
				//double erorr = Math.sqrt((x - temp.x)*(x - temp.x) + (y - temp.y)*(y - temp.y));
				//err_sum += erorr;
				//System.out.println(erorr);
			}
			//System.out.println("average_error:" + err_sum/len);
		}catch (Exception e){
            e.printStackTrace();
        }
    }  
}  