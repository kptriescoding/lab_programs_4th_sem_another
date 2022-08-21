package PartB;
import java.util.*;
class HuffmanNode implements Comparable<HuffmanNode>{
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
    public int compareTo(HuffmanNode o) {
        return this.data-o.data;
    }
}
public class Prog4 {
    public static void printCode(HuffmanNode root, String s)
    {
        if (root.left== null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of characters");
        int n = sc.nextInt();
        char[] charArray = new char[n];
        int [] charfreq=new int[n];
        System.out.println("Enter the characters");
        for(int i=0;i<n;i++)
            charArray[i]=sc.next().charAt(0);
        System.out.println("Enter the character Frequencies");
        for(int i=0;i<n;i++)
            charfreq[i]=sc.nextInt();
        ArrayList<HuffmanNode> huffmanNodes=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charfreq[i];
            hn.left = null;
            hn.right = null;
            huffmanNodes.add( hn);
        }
        HuffmanNode root = null;
        while (huffmanNodes.size() > 1) {
            Collections.sort(huffmanNodes);
            HuffmanNode x = huffmanNodes.get(0);
            huffmanNodes.remove(0);
            HuffmanNode y = huffmanNodes.get(0);
            huffmanNodes.remove(0);
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            huffmanNodes.add(f);
        }
        printCode(root, "");
    }
}