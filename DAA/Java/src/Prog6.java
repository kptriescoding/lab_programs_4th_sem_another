import java.util.Scanner;

public class Prog6 {
    public static int[] ShiftTable(char[] P){
        int m=P.length;
        int[] Table=new int[256];
        for(int i=0;i<256;i++)
            Table[i]=m;
        for(int i=0;i<m-1;i++)
            Table[P[i]]=m-1-i;
        return Table;
    }
    public static int HorsePool(char[] P,char[] T){
        int m=P.length,n=T.length,i=m-1,k;
        int [] Table=ShiftTable(P);
        while(i<n){
            k=0;
            while(k<m&&P[m-1-k]==T[i-k])k++;
            if(k==m)return i-m+1;
            else i=i+Table[T[i]];
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        char[] P,T;
        System.out.println("Enter The Text");
        T=sc.nextLine().toCharArray();
        System.out.println("Enter the Pattern");
        P=sc.nextLine().toCharArray();
        int ans=HorsePool(P,T);
        if(ans==-1) System.out.println("No Pattern Found");
        else System.out.println("The pattern is found in "+ans+" ");
    }
}
