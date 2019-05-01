public class RssiDetector{
	static point point_pro = new point();
	static point point_current = new point();
	public static boolean isChange(){
		double dis = (point_pro.x - point_current.x)*(point_pro.x - point_current.x)+(point_pro.y - point_current.y)*(point_pro.y - point_current.y);
		//System.out.println("dis:" + dis);
		if (dis >= 0.1) return true;
		else return false;
	}
	public void setProPoint(double x,double y){
		point_pro.x = x;
		point_pro.y = y;
	}
	public void setCurrentPoint(double x,double y){
		point_current.x = x;
		point_current.y = y;
	}
}