package Prog10;
import java.util.*;
public class Prog10b {
    public static void main(String[] args){
        String s;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        s=sc.nextLine();
        s=s.replace("python","kpmrlgkmelrm");
        s=s.replace("java","python");
        s=s.replace("kpmrlgkmelrm","java");
        System.out.println("The string after replacing is\n"+s);
    }
    }
