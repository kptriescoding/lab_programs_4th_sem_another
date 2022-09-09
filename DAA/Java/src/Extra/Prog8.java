package Extra;

import java.util.Scanner;

class Edge{
    int src,dest,weight;
}
public class Prog8 {
    public static void main(String[] args) {
        int V,E;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        V=sc.nextInt();
        System.out.println("Enter the number of edges");
        E=sc.nextInt();
        Edge[]  graph=new Edge[E];
        System.out.println("Enter the Edges as src dest weight");
        for (int i=0;i<E;i++){
            Edge edge=new Edge();
            edge.src= sc.nextInt();
            edge.dest=sc.nextInt();
            edge.weight=sc.nextInt();
            graph[i]=edge;
        }
        System.out.println("Enter the starting vertex");
        int st=sc.nextInt();
        Edge[] ET=Prim(V,E,graph,st);
        int minWeight = 0;
        System.out.println("The Edges of spanning tree are");
        System.out.printf("%-4s%-5s%-4s\n","src","dest","wt");
        for (int i = 0; i < ET.length; i++) {
            if(ET[i]==null)continue;
            System.out.printf("%-4d%-5d%-4d\n", ET[i].src, ET[i].dest, ET[i].weight);
            minWeight+=ET[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "+ minWeight);
            
    }
    private static int getMin(Edge[] graph,int [] VT){
        int mini=-1;
            for(int i=0;i<graph.length;i++)
            {
                if(graph[i]==null)continue;
                if (VT[graph[i].src]==1 && VT[graph[i].dest] == 1) continue;
                if (VT[graph[i].src]==-1 && VT[graph[i].dest] == -1) continue;
                if(mini==-1){
                    mini=i;
                    continue;
                }
                if (graph[i].weight < graph[mini].weight) mini = i;
            }
        return mini;
    }
    private static Edge[] Prim(int v, int e, Edge[] graph, int st) {;
        int[] VT=new int [10000];
        for(int i=0;i<10000;i++)VT[i]=-1;
        VT[st]=1;
        Edge [] ET=new Edge[e];
        int j=0;
        for(int i=1;i<v;i++){
            int mini=getMin(graph,VT);
            ET[j++]=graph[mini];
            VT[graph[mini].src]=1;
            VT[graph[mini].dest]=1;
            graph[mini]=null;
        }
        return ET;
    }
}
