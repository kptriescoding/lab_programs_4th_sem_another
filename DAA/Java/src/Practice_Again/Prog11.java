package Practice_Again;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Prog11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        NQueens(n,0,new int[n]);
    }

    private static void NQueens(int n,int k,int[] x) {
        for(int i=0;i<n;i++){
            if(Place(k,i,x)){
                x[k]=i;
                if(k==n-1) {
                    System.out.println(Arrays.toString(x));
                    return;
                }
                NQueens(n,k+1,x);
            }
        }
    }
    static boolean Place(int k, int i, int[] x){
        for(int j=0;j<k;j++)
            if(x[j]==i||abs(k-j)==abs(x[j]-i))
                return false;
        return true;
    }
}