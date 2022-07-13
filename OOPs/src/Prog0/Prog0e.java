package Prog0;

import java.util.Scanner;

public class Prog0e {
    static Scanner scan = new Scanner(System.in);
    static int a, b, c;

    public static void main(String[] args) {
        System.out.println("Enter the 3 numbers");
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        if (a % 10 == b % 10 || b % 10 == c % 10 || c % 10 == a % 10) System.out.println("True");
        else System.out.println("False");
    }
}
