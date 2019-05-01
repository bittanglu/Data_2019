import java.util.*;
import java.io.*;  
import java.util.ArrayList;

public class zifu{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Queue<String> priorityQueue =  new PriorityQueue<String>(1,
                new Comparator<String>(){
                    public int compare(String st1, String st2) {
                        int len1 = st1.length(),len2 = st2.length();
                        for (int i = 0;i < len1 && i < len2;i++){
                            if (st1.charAt(i) != st2.charAt(i))
                                return st2.charAt(i) - st1.charAt(i);
                        }
                        return len2 - len1;
                    }
                }
            );
        while(s.hasNext()){
            int n = Integer.valueOf(s.nextLine());
            String[] numbers = s.nextLine().split(" ");
            for(String temp:numbers)
                priorityQueue.add(temp);
            for(String temp:priorityQueue)
                System.out.print(temp + " ");
            System.out.println();
        }
    }
}