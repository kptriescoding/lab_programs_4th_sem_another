package Practice_Again;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Prog2 {
    static int count;
    public static void main(String[] args) {
        int []arr;
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        QuickSort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
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
            while(i<r+1&&pivot>arr[i]){
                i++;
                count++;
            }
            while(j>l-1&&pivot<arr[j]){
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
        arr[j]=temp;;
    }

    private static void TimeComplexity(int n) {
        int i=n;
        int a_c,d_c,r_c,n_l,n_2;
        Random ra=new Random();
        int[] r=new int[257],a=new int[257],d=new int[257];
        while(i<257){
            n_l= (int) (i* Math.log(i)/Math.log(2));
            n_2=i*(i+1)/2-1;
            for(int j=0;j<i;j++){
                a[j]=j;
                d[j]=267-j;
                r[j]=ra.nextInt();
            }
            count=0;
            QuickSort(a,0,i-1);
            a_c=count;
            count=0;
            QuickSort(d,0,i-1);
            d_c=count;
            count=0;
            QuickSort(r,0,i-1);
            r_c=count;
            count=0;
            System.out.printf("%7s%7s%7s%7s%7s%7s%7s\n",i,n_2,a_c,n_2,d_c,n_l,r_c);
            i*=2;
        }
    }
}
