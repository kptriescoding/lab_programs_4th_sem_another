package Prog0;

import java.util.Scanner;

public class Prog0c {
    static int n,n1,x=0;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter no of coins");
        n = scan.nextInt();
        findAns();
        for (int i = 1; i < x; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < n1; i++)
            System.out.print("*");
        System.out.println();
    }

    public static void findAns() {
        n1 = n;
        while (n1 >= x) n1 -= x++;
    }
}
