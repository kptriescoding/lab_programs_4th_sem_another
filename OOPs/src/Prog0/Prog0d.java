package Prog0;

import java.util.Scanner;

public class Prog0d {
    static Scanner scan = new Scanner(System.in);
    static int[] v1,v2;
    static int n;

    public static void main(String[] args) {
        System.out.println("Enter the no of elements");
        n = scan.nextInt();
        v1 = new int[n];
        v2 = new int[n];
        solve();
        System.out.println("The modified array is");
        for (int i = 0; i < n; i++)
            System.out.print(v2[i]+" ");
        System.out.println();
    }

    static void solve() {
        System.out.println("Enter the elements");
        int j = 0;
        for (int i = 0; i < n; i++) v1[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            System.out.print(v1[i] + " ");
        System.out.println();
        for (int i = 0; i < n; i++)
            if (v1[i] % 2 == 1)
                v2[j++] = v1[i];
        for (int i = 0; i < n; i++)
            if (v1[i] % 2 == 0)
                v2[j++] = v1[i];
    }
}
