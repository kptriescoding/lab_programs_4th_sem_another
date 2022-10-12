package Practice;
import java.util.Arrays;
import java.util.Scanner;

public class Prog10 {
    public static void main(String[] args) {
        int n,sum;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        sum=sc.nextInt();
        for(int i=0;i<n;i++)
            for(int j=0;j<n-i-1;j++)
                if(arr[j]>arr[j+1])swap(arr,i,j);
        sumOfSubset(arr,n,-1,new int[n],0,sum);
    }
    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void sumOfSubset(int[] arr, int n, int ind, int[] ans, int a_n, int sum) {
        if(sum==0){
            for(int i=0;i<a_n;i++) System.out.print(ans[i]+" ");
            System.out.println();
            return;
        }
        for(int i=ind+1;i<n;i++){
            if(sum>=arr[i]){
                ans[a_n]=arr[i];
                sumOfSubset(arr,n,i,ans,a_n+1,sum-arr[i]);
            }
        }
    }
}
