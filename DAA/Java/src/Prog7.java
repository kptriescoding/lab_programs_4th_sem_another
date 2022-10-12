import java.util.Scanner;
public class Prog7 {
    public static int knapsack(int W, int[] wt, int[] val, int n){
        int i,w;
        int[][] K=new int[n+1][W+1];
        for( i=0;i<=n;i++)
            for(w=0;w<=W;w++ ) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (w>=wt[i-1])
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        System.out.println("The items selected in the knapsack are");
        printSolution(W,n, K,val,wt);
        return K[n][W];
    }

    private static void printSolution(int W, int n, int[][] K, int[] val, int[] wt) {
        int i=n,j=W;
        while(i!=0&&j!=0){
            if(K[i][j]!=K[i-1][j]){
                System.out.print(val[i-1] + " ");
                j=j-wt[i-1];
            }
            i--;
        }
        System.out.println();
    }

    private static int max(int a, int b) {
    if(a>b)return a;
    return b;
    }
    public static void main(String[] args){
        int W,n;
        int[] wt,val;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of weights");
        n=sc.nextInt();
        wt=new int [n];
        val=new int [n];
        System.out.println("Enter the values of the items");
        for(int i=0;i<n;i++)
            val[i]=sc.nextInt();
        System.out.println("Enter the weights of the items");
        for(int i=0;i<n;i++)
            wt[i]=sc.nextInt();
        System.out.println("Enter the value of knapsack");
        W= sc.nextInt();
        System.out.println("Maximum total in the knapsack is "+ knapsack(W,wt,val,n));
    }
}
