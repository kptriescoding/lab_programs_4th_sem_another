package Prog0;

import java.util.Scanner;

public class Prog0f {
    static Scanner scan = new Scanner(System.in);
    static int[][] a;
    static int m, n, x;

    public static void main(String[] args) {
        takeInput();
        findEle();
    }
    public static void takeInput(){
        System.out.println("Enter rows and columns");
        m = scan.nextInt();
        n = scan.nextInt();
        System.out.println("Enter the elements");
        a = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = scan.nextInt();
        System.out.println("Enter the element to be found");
        x = scan.nextInt();
    }
    public static void findEle(){
        boolean found=false;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(a[i][j]==x) {
                    found=true;
                    System.out.println("The ele "+x+" has the position i = "+i+" j = "+j);
                }
        if(!found) System.out.println("The ele "+x+" could not be found");
    }
}

