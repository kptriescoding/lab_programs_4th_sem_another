package Practice;

import java.util.Scanner;

public class Prog6 {
    public static void main(String[] args) {
        char [] P,T;
        Scanner sc=new Scanner(System.in);
        T=sc.nextLine().toCharArray();
        P=sc.nextLine().toCharArray();
        System.out.println(HorsePool(P,T));
    }

    private static int HorsePool(char[] P, char[] T) {
        int m=P.length,n=T.length,i=m-1,k;
       int [] Table=ShiftTable(P);
       while(i<n){
           k=0;
           while(k<m&&P[m-1-k]==T[i-k])k++;
           if(k==m)return i-m+1;
           i=i+Table[T[i]];
       }
        return -1;
    }

    private static int[] ShiftTable(char[] P) {
        int m=P.length;
        int[] Table= new int[256];
        for(int i=0;i<256;i++)Table[i]=m;
        for(int i=0;i<m-1;i++)Table[P[i]]=m-i-1;
        return Table;

    }
}
