import java.util.Scanner;

import static java.lang.Math.abs;

public class Prog11{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Emter the value of n");
        n=sc.nextInt();
        int []x=new int[n];
        System.out.println("The combinations are");
        Nqueens(0,n,x);
    }

    private static void Nqueens(int k, int n,int[] x) {
        for(int i=0;i<n;i++) {
            if(Place(k,i,x)) {
                x[k] = i;
                if (k == n-1) {
                    for (int ind : x)
                        System.out.print(ind + " ");
                    System.out.println();
                }
                Nqueens(k+1,n,x);
            }
        }
    }

    private static boolean Place(int k, int ind, int[] x) {
        for (int i = 0; i < k; i++)
            if (x[i] == ind || abs(x[i] - ind) == abs(i - k)) return false;
        return true;
    }
}
