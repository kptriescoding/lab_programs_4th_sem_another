import java.util.*;
public class Prog8 {
    @FunctionalInterface
    interface performOperation{
        boolean operation(int num);
    }
    static performOperation isOdd=(int num)->{
        return num%2==1;
    };
    static performOperation checkPrime=(int num)->{
        for(int i=2;i<=Math.sqrt(num);i++)
            if(num%i==0)return false;
        return true;
    };
    static performOperation isPalindrome=(int num)->{
        StringBuilder s1= new StringBuilder(String.valueOf(num));
        StringBuilder s2= new StringBuilder(new String(s1));
        s2.reverse();
        return s1.compareTo(s2)==0;
    };
    public static void main(String[] args) {
        int num;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Integer");
        num=sc.nextInt();
        System.out.print("Even Or Odd\nThe number "+num+" is ");
        if(isOdd.operation(num)) System.out.println("Odd");
        else System.out.println("Even");
        System.out.print("Check Prime\nThe number "+num+" is ");
        if(checkPrime.operation(num)) System.out.println("Prime");
        else System.out.println("not Prime");
        System.out.print("Check Palindome\nThe number "+num+" is ");
        if(isPalindrome.operation(num)) System.out.println("a Palindrome");
        else System.out.println("not a Palindrome");

    }
}
