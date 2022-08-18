package Prog10;
import java.util.*;
public class Prog10c {
    public static void main(String[] args){
        String s,delimiter;
        String[] s_arr;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        s=sc.nextLine();
        System.out.println("Enter the delimiter");
        delimiter=sc.nextLine();
        s_arr=s.split(delimiter);
        System.out.println("The substrings after splitting are");
        for(int i=0;i<s_arr.length;i++)System.out.println(s_arr[i]);
    }
}
