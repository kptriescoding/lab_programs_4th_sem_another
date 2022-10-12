package Practice_Again;

import java.util.Scanner;

public class Prog10 {
    public static void main(String[] args) {
        int []arr;
        int n;
        int sum;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        BubbleSort(arr,n);
        sum= sc.nextInt();
        sumOfSubset(arr,n,sum,new int[n],0,-1);
    }

    private static void sumOfSubset(int[] arr, int n, int sum, int[] ans, int a_i,int ind) {
        if(sum==0){
            for(int i=0;i<a_i;i++) System.out.print(ans[i]+" ");
            System.out.println();
        }
        for(int i=ind+1;i<n;i++)
            if(sum>=arr[i]){
                ans[a_i]=arr[i];
                sumOfSubset(arr,n,sum-arr[i],ans,a_i+1,i);
            }
        else break;
    }

    private static void BubbleSort(int[] arr, int n) {
        int temp;
        for(int i=0;i<n;i++)
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
    }
}
