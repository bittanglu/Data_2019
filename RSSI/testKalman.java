/**
 * Created by 唐路 on 2018/9/26.
 */
import java.util.*;
import java.io.*; 

public class testKalman{
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
            String pathname = "D:\\java_learning\\RSSI\\direction\\pdr_data7.txt"; 
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
			String pathname = "D:\\java_learning\\RSSI\\direction\\wifi_data7.txt";
			RSSI.readFromFileNoVar(res,pathname);
			int len = angle_pdr.size();
			pdr_rssi res_cal = new pdr_rssi();
			RSSI temp = res.get(0);
 			double x = -1.7;
			double y = 17;
			double step_length = 0.62;
			System.out.println("len:" + len);
			int rssi_index = 0;
			RssiDetector rssidetector = new RssiDetector();
			rssidetector.setProPoint(x,y);
			System.out.println(x+","+y);
			ArrayList<point> path = new ArrayList<point>();
			path.add(new point(x,y));
			Kalman kal = new Kalman(1);
			int count_step = 0;
			for(int i = 0;i < len; i++){
				step_length = step_list.get(i);
				count_step ++;
				x = x + step_length*Math.cos(Math.toRadians(angle_pdr.get(i)));
				y = y + step_length*Math.sin(Math.toRadians(angle_pdr.get(i)));
				path.add(new point(x,y));
				/*
				if((i+1) % 3 == 0){
					temp = res.get(rssi_index);
					rssi_index++;
					temp.Varity_WKNN(list);
					rssidetector.setCurrentPoint(temp.x,temp.y);
					if(rssidetector.isChange()){
						double min = Double.MAX_VALUE;
						int min_index = 0;
						point p1;
						for(int j = 0;j < path.size();j++){
							p1 = path.get(j);
							double dis = (p1.x - temp.x)*(p1.x - temp.x) + (p1.y - temp.y)*(p1.y - temp.y);
							if(dis < min){
								min = dis ;
								min_index = j;
							}
						}
						System.out.println("path:"+path.size());
						p1 = path.get(min_index);
						double dx = x - p1.x;
						double dy = y - p1.y;
						kal.calGain();
						point p = kal.calOptimal(new point(temp.x,temp.y),new point(p1.x,p1.y));
						kal.updateVariance();
						double x1 = p.x + dx;
						double y1 = p.y + dy;
						//dx = Math.min(x1 - x,0.5);
						//dy = Math.min(y1 - y,0.5);
						//x = x + dx;
						//y = y + dy;
						x = x1;y=y1;
						path.clear();
						rssidetector.setProPoint(temp.x,temp.y);
					}
				}
				System.out.println(x+","+y);
				*/
				//if((i+1) % 1 == 0){
					temp = res.get(i);
					rssi_index++;
					temp.Varity_WKNN(list);
					kal.calGain(i%5);
					point p = kal.calOptimal(new point(temp.x,temp.y),new point(x,y));
					kal.updateVariance(i%10);
					//System.out.println(temp.x+","+temp.y);
					x = p.x;
					y = p.y;
					if(count_step % 7 == 0) {
						x = p.x;
						y = p.y;
					}
					System.out.println(p.x+","+p.y);
				//}
			}
			//System.out.println("average_error:" + err_sum/len);
		}catch (Exception e){
            e.printStackTrace();
        }
    }  
}  