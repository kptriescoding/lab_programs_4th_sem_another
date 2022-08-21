package PartB;
import java.util.*;
class Edge implements Comparable<Edge>
{
    int src, dest, weight;
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
};
public class Prog2 {

    static boolean find(int [] v, int ver)
    {
        for (int j : v) {
            if (j == ver) return true;
        }
        return false;
    }
    static void add(int [] v,int ver){
        int i=0;
        while(v[i]!=-1)i++;
        v[i]=ver;
    }
    static void KruskalMST(int V, int E, Edge[] edge)
    {
        int [] vertex=new int[V];
        int i = 0;
        for( i=0;i<V;i++)
            vertex[i]=-1;
        int minimunPath=0;
        Edge[] result =new Edge[E];
        for(i=0;i<E;i++)result[i]=new Edge();
        int e = 0;
        Arrays.sort(edge);
        i = 0;
        while (i < E)
        {
            Edge next_edge = edge[i++];
            boolean x = find(vertex, next_edge.src);
            boolean y = find(vertex, next_edge.dest);
            if (!x||!y) {
                result[e++] = next_edge;
                if(!x)add(vertex,next_edge.src);
                if(!y)add(vertex,next_edge.dest);
                minimunPath+=next_edge.weight;
            }
        }

        System.out.println("Following are the edges in "+ "the constructed MST");
        System.out.printf("%-4s%-5s%-4s\n","src","dest","wt");
        for (i = 0; i < e; ++i)
            System.out.printf("%-4d%-5d%-4d\n",result[i].src,result[i].dest , result[i].weight);
        System.out.println("Minimum Cost Spanning Tree "+ minimunPath);
    }

    // Driver Code
    public static void  main(String[] args)
    {
        int V, E ;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        V=sc.nextInt();
        System.out.println("Enter the number of edges");
        E=sc.nextInt();
        Edge[] edge= new Edge[E];
        System.out.println("Enter the values as src dest weight");
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
            edge[i].src= sc.nextInt();
            edge[i].dest=sc.nextInt();
            edge[i].weight=sc.nextInt();
        }
        KruskalMST(V,E,edge);
    }
}

//0 1 10
//        0 2 6
//        0 3 5
//        1 3 15
//        2 3 4