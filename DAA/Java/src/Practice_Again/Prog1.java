package Practice_Again;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Prog1 {
    static int count;
    public static void main(String[] args) {
        int []arr;
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        MergeSort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
        TimeComplexity(n);
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
                d[j]=267-j;
                r[j]=ra.nextInt();
            }
            count=0;
            MergeSort(a,0,i-1);
            a_c=count;
            count=0;
            MergeSort(d,0,i-1);
            d_c=count;
            count=0;
            MergeSort(r,0,i-1);
            r_c=count;
            count=0;
            System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n",i,n_l,a_c,n_l,d_c,n_l,r_c);
            i*=2;
        }
    }

    private static void MergeSort(int[] arr, int l, int r) {
        if(l>=r)return;
        int m=(l+r)/2;
        MergeSort(arr,l,m);
        MergeSort(arr,m+1,r);
        Merge(arr,l,r,m);
    }

    private static void Merge(int[] arr, int l, int r, int m) {
        int n1=m-l+1,n2=r-m,k=l;
        int[] b=new int[n1],c=new int[n2];
        for(int i=0;i<n1;i++)b[i]=arr[k++];
        for(int i=0;i<n2;i++)c[i]=arr[k++];
        int i=0,j=0;k=l;
        while(i<n1&&j<n2){
            if(b[i]<c[j])arr[k++]=b[i++];
            else arr[k++]=c[j++];
            count++;
        }
        while(i<n1){
            arr[k++]=b[i++];
            count++;
        }
        while(j<n2){
            arr[k++]=c[j++];
            count++;
        }
    }
}
