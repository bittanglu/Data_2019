import java.util.*;  
import java.io.*;  
import java.lang.String;  
import java.math.BigDecimal;  
   
public class Main  
{  
    public static void main(String[] args)  
    {  
        String s1,s2;  
        Scanner cin = new Scanner(System.in);          
        s1 = cin.next();  
        s2 = cin.next();  
        BigDecimal b1 = new BigDecimal(s1);  
        BigDecimal b2 = new BigDecimal(s2);  
        System.out.println(b1.multiply(b2));  
        cin.close();  
    }  
}  