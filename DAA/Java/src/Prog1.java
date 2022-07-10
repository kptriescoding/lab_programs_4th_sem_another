import java.util.*;

public class Prog1 {
    static int count=0;
    public static void Merge(int[] arr,int l,int mid,int r){
        int i,j,k=l,n1=mid-l+1,n2=r-mid;
        int[] b_arr=new int[n1];
        int[] c_arr=new int[n2];
        for(i=0;i<n1;i++)
            b_arr[i]=arr[k++];
        for(j=0;j<n2;j++)
            c_arr[j]=arr[k++];
        k=l;j=0;i=0;
        while(i<n1&&j<n2){
            if(b_arr[i] < c_arr[j]) arr[k++]= b_arr[i++];
            else arr[k++]= c_arr[j++];
            count++;
        }
        while(i<n1){
            arr[k++]= b_arr[i++];
            count++;
        }
        while(j<n2){
            arr[k++]= c_arr[j++];
            count++;
        }
    }
    public static void Merge_Sort(int[] arr, int l,int r){
        if(l>=r)return;
        int mid=(l+r)/2;
        Merge_Sort(arr,l,mid);
        Merge_Sort(arr,mid+1,r);
        Merge(arr,l,mid,r);
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
            Merge_Sort(sorted_arr,0,i-1);
            n_a=count;
            count=0;
            Merge_Sort(random_arr,0,i-1);
            n_r=count;
            count=0;
            Merge_Sort(reverse_sorted_arr,0,i-1);
            n_d=count;
            System.out.printf("%-16s%-8s%-8s%-8s%-8s%-8s%-8s\n",i,n_a,n_log_n,n_d,n_log_n,n_r,n_log_n);
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
        for(i=0;i<n;i++) {
            arr[i]=scan.nextInt();
        }
        System.out.println("Part1");
        Merge_Sort(arr,0,n-1);
        System.out.println("The Sorted Array is");
        for(i=0;i<n;i++)
            System.out.print(arr[i] +" ");
        System.out.println("\n The time complexity is "+ count);
        System.out.println("Part2");
        Time_Complexity(n);
    }
}