package Practice_Again;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Prog5 {
    static int count;
    public static void main(String[] args) {
        int []arr;
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        HeapSort(arr,n);
        System.out.println(Arrays.toString(arr));
        TimeComplexity(n);
    }
    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;;
    }

    private static void HeapSort(int[] arr, int n) {
        buildHeap(arr,n);
        for(int i=n-1;i>0;i--){
            swap(arr,0,i);
            heapify(arr,0,i);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for(int i=n/2;i>-1;i--)heapify(arr,i,n);
    }

    private static void heapify(int[] arr, int i, int n) {
        int l=2*i+1,r=2*i+2,m=i;
        if(l<n&&arr[l]>arr[m])m=l;
        if(r<n&&arr[r]>arr[m])m=r;
        count+=2;
        if(m!=i){
            swap(arr,m,i);
            heapify(arr,m,n);
        }
    }

    private static void TimeComplexity(int n) {
        int i=n;
        int a_c,d_c,r_c,n_l;
        Random ra=new Random();
        int[] r=new int[257],a=new int[257],d=new int[257];
        while(i<257){
            n_l= (int) (i* Math.log(i)/Math.log(2));
            for(int j=0;j<i;j++){
                a[j]=j;
                d[j]=i-j;
                r[j]=ra.nextInt();
            }
            count=0;
            HeapSort(a,i);
            a_c=count;
            count=0;
            HeapSort(d,i);
            d_c=count;
            count=0;
            HeapSort(r,i);
            r_c=count;
            count=0;
            System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n",i,n_l,a_c,n_l,d_c,n_l,r_c);
            i*=2;
        }
    }
}
