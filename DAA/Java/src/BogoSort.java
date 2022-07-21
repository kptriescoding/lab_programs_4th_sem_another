
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class BogoSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,i;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        System.out.println("Enter the size of the array");
        n = scan.nextInt();
        System.out.println("Enter the elements of the array");
        for(i=0;i<n;i++) {
            arr.add(scan.nextInt());
        }
        Bogo_Sort(arr);
        System.out.println("The Sorted Array is");
        for(i=0;i<n;i++)
            System.out.print(arr.get(i) +" ");

    }
    public static boolean isCollectionSorted(ArrayList list) {
        ArrayList copy = new ArrayList(list);
        Collections.sort(copy);
        return copy.equals(list);
    }
    private static void Bogo_Sort(ArrayList<Integer> arr) {
        while(!isCollectionSorted(arr))
            Collections.shuffle(arr);
    }
}
