package Prog0;

import java.util.Scanner;

public class Prog0a {
    static int given_sec,sec, min, hours;;
   static Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Enter the time in seconds");
        given_sec = scan.nextInt();
        secToTime();
        System.out.println(" when converted is " + hours + ":" + min + ":" + sec);
    }

    public static void secToTime() {
        hours = given_sec / 3600;
        given_sec = given_sec % 3600;
        min = given_sec / 60;
        given_sec = given_sec % 60;
        sec = given_sec;
    }
}
