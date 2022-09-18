package Practice;

import java.util.Random;
import java.util.Scanner;

public class Prog5 {
    private static int count=0;
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        HeapSort(arr,n);
        System.out.println("The sorted array is");
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        TimeComplexity(n);
    }

    private static void HeapSort(int[] arr, int n) {
        buildHeap(arr,n);
        for(int i=n-1;i>0;i--){
            swap(arr,0,i);
            heapify(arr,0,i-1);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for(int i=n/2;i>-1;i--)
            heapify(arr,i,n);
    }

    private static void heapify(int[] arr, int i, int n) {
        int l=2*i+1,r=2*i+2,m=i;
        if(l<n&&arr[l]>arr[m])m=l;
        if(r<n&&arr[r]>arr[m])m=r;
        count+=2;
        if(m!=i){
            swap(arr,i,m);
            heapify(arr,m,n);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void TimeComplexity(int n){
        int c_a,c_d,c_r,log_n,n_log_n,i=n;
        Random r=new Random();
        int [] a_arr=new int[257],d_arr=new int[257],r_arr=new int[257];
        while(i<257){
            log_n= (int) (Math.log(i)/Math.log(2));
            n_log_n=i*log_n;
            for(int j=0;j<257;j++){
                a_arr[j]=j;
                d_arr[j]=257-j;
                r_arr[j]=r.nextInt(1000);
            }
            count=0;
            HeapSort(a_arr,i);
            c_a=count;
            count=0;
            HeapSort(d_arr,i);
            c_d=count;
            count=0;
            HeapSort(r_arr,i);
            c_r=count;
            System.out.printf("%6d%6d%6d%6d%6d%6d%6d\n",i,c_a,n_log_n,c_d,n_log_n,c_r,n_log_n);
            i*=2;
        }
    }
}
