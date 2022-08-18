package Prog10;
import java.util.*;
public class Prog10a{
    public static void main(String[] args){
        String s;
        String[] s_arr;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        s=sc.nextLine();
        s_arr=s.split(" ");
        System.out.println("The penultimate word is "+s_arr[s_arr.length-2]);
    }
}


