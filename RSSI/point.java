import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class point {
    double x,y;
    point(){
        x = 0.0;
        y = 0.0;
    }
    point(double x,double y){
        this.x = x;
        this.y = y;
    }
    public void setCoordinate(double x,double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }

    public String toString() {
        String st = "";
        st += this.getX() + "," + this.getY();
        st += "\r\n";
        return st;
    }
    public static void writeToFile(ArrayList<point> list, String filename){
        int len = list.size();
        try {
            FileWriter writer = new FileWriter(filename,false);
            for (int i = 0;i < len ;i++) {
                writer.write(list.get(i).toString());
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
