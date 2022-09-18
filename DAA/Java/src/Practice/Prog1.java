package Practice;

import java.util.Random;
import java.util.Scanner;

public class Prog1 {
    private static int count=0;
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        MergeSort(arr,0,n-1);
        System.out.println("The sorted array is");
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        TimeComplexity(n);
    }

    private static void MergeSort(int[] arr, int l, int r) {
        if(l>=r)return;
        int m=(l+r)/2;
        MergeSort(arr,l,m);
        MergeSort(arr,m+1,r);
        Merge(arr,l,r,m);
    }

    private static void Merge(int[] arr, int l, int r, int m) {
        int i=0,j=0,n1=m-l+1,n2=r-m,k=l;
        int[] b_arr=new int[n1],c_arr=new int[n2];
        for(i=0;i<n1;i++)b_arr[i]=arr[k++];
        for(j=0;j<n2;j++)c_arr[j]=arr[k++];
        i=0;j=0;k=l;
        while(i<n1&&j<n2){
            if(b_arr[i]<c_arr[j])arr[k++]=b_arr[i++];
            else arr[k++]=c_arr[j++];
            count++;
        }
        while(i<n1){
            arr[k++]=b_arr[i++];
            count++;
        }
        while(j<n2){
            arr[k++]=c_arr[j++];
            count++;
        }
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
            MergeSort(a_arr,0,i-1);
            c_a=count;
            count=0;
            MergeSort(d_arr,0,i-1);
            c_d=count;
            count=0;
            MergeSort(r_arr,0,i-1);
            c_r=count;
            System.out.printf("%6d%6d%6d%6d%6d%6d%6d\n",i,c_a,n_log_n,c_d,n_log_n,c_r,n_log_n);
            i*=2;
        }
    }
}
