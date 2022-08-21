package PartB;
import java.util.*;

public class Prog3 {
    static int getMax(int[] arr, int n)
    {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
    static void countSort(int[] arr, int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    static void radixsort(int[] arr, int n)
    {
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    public static void main(String[] args)
    {
        int[] arr;
        int n ;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        n=sc.nextInt();
        System.out.println("Enter the elements of the array");
        arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        radixsort(arr, n);
        System.out.println("The sorted array is");
        for (int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
    }
}
