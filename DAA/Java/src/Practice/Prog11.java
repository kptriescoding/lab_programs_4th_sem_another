package Practice;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Prog11 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        nQueens(n,new int[n],0);
    }

    private static void nQueens(int n, int[] x, int k) {
        for(int i=0;i<n;i++)
            if(Place(i,k,x)){
                x[k]=i;
                if(k==n-1) {
                    for(int j=0;j<n;j++) System.out.print(x[j]+" ");
                    System.out.println();
                    return;
                }
                nQueens(n,x,k+1);
            }
    }

    private static boolean Place(int i, int k, int[] x) {
        for(int j=0;j<k;j++)
            if(x[j]==i||abs(x[j]-i)==abs(k-j))return false;
        return true;
    }
}
