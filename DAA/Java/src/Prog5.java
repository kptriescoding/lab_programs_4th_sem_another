import java.util.*;

public class Prog5 {
    static int count=0;
    public static void heapify(int [] arr,int i,int n){
        int l=2*i+1,r=2*i+2,max=i;
        if(l<n&&arr[l]>arr[max]){
            max=l;
        }
        if(r<n&&arr[r]>arr[max]){
            max=r;
        }
        if(max!=i){
            swap(arr,i,max);
            count++;
            heapify(arr,max,n);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }


    public static void build_heap(int [] arr,int n){
        for(int i=n/2;i>-1;i--)
            heapify(arr,i,n);
    }
    public static void heap_sort(int [] arr,int n){
        build_heap(arr,n);
        for(int i=n-1;i>0;i--){
            count++;
            swap(arr,i,0);
            heapify(arr,0,i);
        }
    }
    public static void Time_Complexity(int n){
        Random random= new Random();
        System.out.printf("%-16s,%-16s%-16s%-16s\n","Array Size","Ascending","Descending","Random");
        System.out.printf("%-16s%-8s%-8s%-8s%-8s%-8s%-8s\n","n","Ac","cal","ac","cal","ac","cal");
        int [] sorted_arr=new int[256];
        int [] random_arr=new int[256];
        int [] reverse_sorted_arr=new int[256];
        int i=n;
        int log_n,n_log_n;
        int  n_a,n_d,n_r;
        while(i<257){
            log_n= (int) (Math.log(i)/Math.log(2));
            n_log_n = i * log_n;
        for(int j=0;j<i;j++){
            sorted_arr[j]=j;
            reverse_sorted_arr[j]=j-i;
            random_arr[j]=random.nextInt()%1000;
        }
            count=0;
            heap_sort(sorted_arr,i);
            n_a=count;
            count=0;
            heap_sort(random_arr,i);
            n_r=count;
            count=0;
            heap_sort(reverse_sorted_arr,i);
            n_d=count;
            System.out.printf("%-16s%-8s%-8s%-8s%-8s%-8s%-8s\n",i,n_a,n_log_n,n_d,n_log_n,n_r,n_log_n);
            i*=2;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Part1");
        System.out.println("Enter the number of elements");
        n=sc.nextInt();
        System.out.println("Enter the elements");
        int [] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        heap_sort(arr,n);
        System.out.println("The sorted Array is");
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println("\nThe Time Complexity is : "+count);
        System.out.println("\nPart2");
        Time_Complexity(n);

    }
}
