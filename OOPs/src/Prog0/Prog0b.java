package Prog0;

import java.util.Scanner;

public class Prog0b {
    static int n,s=0;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter n");
        n = scan.nextInt();
        for (int i = 0; i < 10; i++)
            findValue(3, i);
        System.out.println("The possible combinations are " + s);

    }

    public static void findValue(int x, int sum) {
        if (x == 0) {
            if (sum == n) s++;
            return;
        }
        for (int i = 0; i < n; i++)
            if(sum+i<=n)findValue(x - 1, sum + i);
    }
}
