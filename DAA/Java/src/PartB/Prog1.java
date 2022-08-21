package PartB;

import java.util.Scanner;

public class Prog1 {
    public static int longestCommonSubstring(char[] s1,char[] s2,int m,int n){
        int[][] lcs=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    lcs[i][j]=0;
                else if(s1[i-1]==s2[j-1])
                    lcs[i][j]=lcs[i-1][j-1]+1;
                else
                    lcs[i][j]=max(lcs[i][j-1],lcs[i-1][j]);

            }
        return lcs[m][n];
    }
    private static int max(int a, int b) {
        if(a>b)return a;
        return b;
    }
    public static void main(String[] args) {
        char []s1,s2;
        int m,n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first string");
        s1=sc.nextLine().toCharArray();
        System.out.println("Enter the second string");
        s2=sc.nextLine().toCharArray();
        m= s1.length;
        n=s2.length;
        System.out.println("The Longest Common Substring is "+longestCommonSubstring(s1,s2,m,n));
    }
}
