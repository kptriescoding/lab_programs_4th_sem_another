import java.util.*;
class ArrayListOper {
    ArrayList<String> colors;
    public ArrayListOper (){
        this.colors=new ArrayList<>();
    }
    public void add(String color){colors.add(color);
    }
    public String[] toArray(){
        String[] arr=new String[colors.size()];
        colors.toArray(arr);
        return arr;
    }
    public  ArrayList<String> clone(){
        return (ArrayList<String>)colors.clone();
    }
    public ArrayList<String> subList(int fromIndex,int endIndex){
        return new ArrayList<>(colors.subList(fromIndex,endIndex));
    }
    public ArrayList<String> sort(){
        ArrayList<String> arr=new ArrayList<>(colors);
        Collections.sort(arr);
        return arr;
    }
    public ArrayList<String> reverse(){
        ArrayList<String> arr=new ArrayList<>(colors);
        Collections.reverse(arr);
        return arr;
    }
}
public class Prog9
{

    public static void main(String[] args) {
        int n;
        ArrayListOper arr =new ArrayListOper();
        Scanner sc=new Scanner(System.in);
        System.out.println("How many elements in the array");
        n=sc.nextInt();
        sc.nextLine();
        ArrayList<String> temp;
        String [] ch;
        int st,ed;
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)arr.add(sc.nextLine());
        System.out.println("Clone of Array List");
        temp=arr.clone();
        System.out.println(temp);
        System.out.println("Reverse of Array List");
        temp=arr.reverse();
        System.out.println(temp);
        System.out.println("Sorted Array List");
        temp=arr.sort();
        System.out.println(temp);
        System.out.println("Copy ArrayList to Array");
        ch=arr.toArray();
        for (int i=0;i<n;i++)System.out.print(ch[i]+",");
        System.out.println();
        System.out.println("Get SubList of Array List");
        System.out.println("Enter the Start Index and End Index");
        st= sc.nextInt();
        ed= sc.nextInt();
        temp=arr.subList(st,ed);
        System.out.println(temp);
    }
}
