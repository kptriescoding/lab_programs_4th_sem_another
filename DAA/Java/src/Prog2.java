import java.util.*;

public class Prog2 {
    static int count=0;
    public static int Partition(int[] arr, int l, int r){
        int  pivot= arr[l],i=l+1,j=r;
        while(true){
            while(i<r+1&&pivot>=arr[i]){
                i++;
                count++;
            }
            while(j>l-1&&pivot< arr[j]){
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
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    public static void Quick_Sort(int[] arr, int l, int r){
        if(l>=r)return;
        int pivot=Partition(arr,l,r);
        Quick_Sort(arr,l,pivot-1);
        Quick_Sort(arr,pivot+1,r);
    }
    public static void Time_Complexity(int n){
        Random random= new Random();
        System.out.printf("%-16s,%-16s%-16s%-16s\n","Array Size","Ascending","Descending","Random");
        System.out.printf("%-16s%-8s%-8s%-8s%-8s%-8s%-8s\n","n","Ac","cal","ac","cal","ac","cal");
        int [] sorted_arr=new int[256];
        int [] random_arr=new int[256];
        int [] reverse_sorted_arr=new int[256];
        int i=n;
        int log_n,n_log_n,n_sq;
        int  n_a,n_d,n_r;
        while(i<257){
            log_n= (int) (Math.log(i)/Math.log(2));
            n_log_n = i * log_n;
            n_sq=i*(i+1)/2-1;
            for(int j=0;j<i;j++){
                sorted_arr[j]=j;
                reverse_sorted_arr[j]=j-i;
                random_arr[j]=random.nextInt()%1000;
            }
            count=0;
            Quick_Sort(sorted_arr,0,i-1);
            n_a=count;
            count=0;
            Quick_Sort(random_arr,0,i-1);
            n_r=count;
            count=0;
            Quick_Sort(reverse_sorted_arr,0,i-1);
            n_d=count;
            System.out.printf("%-16s%-8s%-8s%-8s%-8s%-8s%-8s\n",i,n_a,n_sq,n_d,n_sq,n_r,n_log_n);
            i*=2;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,i;
        System.out.println("Enter the size of the array");
        n = scan.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of the array");
        for(i=0;i<n;i++)
            arr[i]=scan.nextInt();
        Quick_Sort(arr,0,n-1);
        System.out.println("Part 1");
        System.out.println("The Sorted Array is");
        for(i=0;i<n;i++)
            System.out.print(arr[i] +" ");
        System.out.println("\n The Time Complexity is "+count);
        System.out.println("Part 2");
        Time_Complexity(n);
    }
}