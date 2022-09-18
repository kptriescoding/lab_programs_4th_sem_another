package Practice;

import java.util.Scanner;

public class Prog7 {
    public static void main(String[] args) {
        int n,w;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] val=new int[n],wt=new int[n];
        for(int i=0;i<n;i++)val[i]= sc.nextInt();
        for(int i=0;i<n;i++)wt[i]= sc.nextInt();
        w=sc.nextInt();
        System.out.println(KnapSack(n,w,val,wt));
    }

    private static int KnapSack(int n, int w, int[] val, int[] wt) {
        int[][] K=new int[n+1][w+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=w;j++){
                if(i==0||j==0)K[i][j]=0;
                else if(j>=wt[i-1])K[i][j]=max(K[i-1][j],K[i-1][j-wt[i-1]]+val[i-1]);
                else K[i][j]=K[i-1][j];
            }
        printSolution(K,wt,n,w,val);
        return K[n][w];
    }

    private static void printSolution(int[][] K, int[] wt, int n, int w, int[] val) {
        int i=n,j=w;
        while(i>0&&j>0){
            if(K[i][j]!=K[i-1][j]){
                System.out.print(val[i-1]+" ");
                j-=wt[i-1];
            }
            i--;
        }
        System.out.println();
    }

    private static int max(int a, int b) {
        if(a>b)return a;
        return b;
    }
}
