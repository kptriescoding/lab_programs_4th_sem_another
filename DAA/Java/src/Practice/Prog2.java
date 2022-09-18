package Practice;

import java.util.Random;
import java.util.Scanner;

public class Prog2 {
    private static int count=0;
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        QuickSort(arr,0,n-1);
        System.out.println("The sorted array is");
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        TimeComplexity(n);
    }

    private static void QuickSort(int[] arr, int l, int r) {
        if(l>=r)return;
        int p=Partition(arr,l,r);
        QuickSort(arr,l,p-1);
        QuickSort(arr,p+1,r);
    }

    private static int Partition(int[] arr, int l, int r) {
        int i=l+1,j=r,pivot=arr[l];
       while(true){
           while(i<r+1&&arr[i]<=pivot){
               i++;
               count++;
           }
           while(j>l-1&&arr[j]>pivot){
               j--;
               count++;
           }
           count++;
           if(i<j)swap(arr,i,j);
           else {
               swap(arr,l,j);
               return j;
           }
       }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void TimeComplexity(int n){
        int c_a,c_d,c_r,log_n,n_log_n,i=n,n_2;
        Random r=new Random();
        int [] a_arr=new int[257],d_arr=new int[257],r_arr=new int[257];
        while(i<257){
            log_n= (int) (Math.log(i)/Math.log(2));
            n_log_n=i*log_n;
            n_2=i*(i+1)/2-1;
            for(int j=0;j<257;j++){
                a_arr[j]=j;
                d_arr[j]=257-j;
                r_arr[j]=r.nextInt(1000);
            }
            count=0;
            QuickSort(a_arr,0,i-1);
            c_a=count;
            count=0;
            QuickSort(d_arr,0,i-1);
            c_d=count;
            count=0;
            QuickSort(r_arr,0,i-1);
            c_r=count;
            System.out.printf("%6d%6d%6d%6d%6d%6d%6d\n",i,c_a,n_2,c_d,n_2,c_r,n_log_n);
            i*=2;
        }
    }
}
