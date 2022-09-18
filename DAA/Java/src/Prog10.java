import java.util.*;

public class Prog10 {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the numbr of elelments");
        n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            for(int j=0;j<n-i-1;j++)
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
        int sum=0;
        System.out.println("Enter the sum");
        sum=sc.nextInt();
        int[] sub = new int[n];
        for(int i=0;i<n;i++)sub[i]=-1;
        System.out.println("The subsets are");
        sumOfSubset(arr,sub, sum, -1,0);
    }

    private static void sumOfSubset(int[] arr,  int[] sub, int sum, int ind,int in) {
        int n=arr.length;
        if(ind==n)return;
        if(sum==0) {
            for(int i=0;i<in;i++)
                System.out.print(sub[i]+" ");
            System.out.println();
        }
        for(int i=ind+1;i<n;i++){
            if (sum >= arr[i]){
                sub[in]=arr[i];
                sumOfSubset(arr, sub, sum-arr[i], i,in+1);
            }
            else break;
        }

    }

}
