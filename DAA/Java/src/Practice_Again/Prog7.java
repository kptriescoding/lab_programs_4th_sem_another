package Practice_Again;

import java.util.Scanner;

import static java.lang.Math.max;

public class Prog7 {
    public static void main(String[] args) {
        int m,w;
        int [] wt,val;
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        wt=new int[m];
        val=new int[m];
        for(int i=0;i<m;i++)val[i]=sc.nextInt();
        for(int i=0;i<m;i++)wt[i]=sc.nextInt();
        w=sc.nextInt();
        KnapSack(w,m,wt,val);
    }

    private static void KnapSack(int w, int m, int[] wt, int[] val) {
        int[][] K=new int[m+1][w+1];
        for(int i=0;i<=m;i++)
            for(int j=0;j<=w;j++){
                if(i==0||j==0)K[i][j]=0;
                else if(j>=wt[i-1])K[i][j]=max(K[i-1][j-1],K[i-1][j-wt[i-1]]+val[i-1]);
                else K[i][j]=K[i-1][j-1];
            }
        printSolution(K,wt,val,m,w);
        System.out.println(K[m][w]);
    }

    private static void printSolution(int[][] K, int[] wt, int[] val, int m,int w) {
       int i=m,j=w;
       while(i>0&&j>0){
           if(K[i][j]!=K[i-1][j]){
               System.out.println(val[i-1]+" "+wt[i-1]);
               j=j-wt[i-1];
           }
            i--;
       }
    }
}
