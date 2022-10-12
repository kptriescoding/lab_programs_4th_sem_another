package Practice_Again;

import java.util.Scanner;

public class Prog6 {
    public static void main(String[] args) {
        char[]P,T;
        Scanner sc=new Scanner(System.in);
        T=sc.nextLine().toCharArray();
        P=sc.nextLine().toCharArray();
        int x=HorsePool(T,P);
        if(x==-1) System.out.println("Not Found");
        else System.out.println(x);
    }

    private static int HorsePool(char[] T, char[] P) {
        int n=T.length,m=P.length,i=m-1,k;
        int[] Tb=ShiftTable(P,m);
        while(i<n){
            k=0;
            while(k<m&&T[i-k]==P[m-1-k])k++;
            if(k==m)return i-m+1;
            i=i+Tb[T[i]];
        }
        return -1;
    }

    private static int[] ShiftTable(char[] P, int m) {
        int [] Tb=new int[256];
        for(int i=0;i<256;i++)
            Tb[i]=m;
        for(int i=0;i<m-1;i++)
            Tb[P[i]]=m-i-1;
        return Tb;
    }
}
