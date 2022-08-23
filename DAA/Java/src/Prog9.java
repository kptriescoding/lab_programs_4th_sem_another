import java.util.*;
public class Prog9 {
    public static void djikstra(int V, int [][]graph, int src) {
        int[] dist =new int[9999999];
        for(int i=0;i<9999999;i++)dist[i]=99999999;
        dist[src] = 0;
        boolean[] fin =new boolean[99999999];
        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            for (int i = 0; i < V; i++)
                if (!fin[i] && (u == -1 || dist[i] < dist[u]))
                    u = i;
            fin[u] = true;
            for (int v = 0; v < V; v++)

                if (graph[u][v] != 0 && !fin[v])
                    dist[v] = min(dist[v], dist[u] + graph[u][v]);
        }
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from " + src + " to " + i + " is " +dist[i]);
        }
    }

    private static int min(int i, int i1) {
        if(i>i1)return i1;
        return i;
    }

    public static void main(String[] args) {
        int V, src;
        Scanner sc=new Scanner(System.in);
        System.out.println( "Enter no of vertices of graph" );
        V= sc.nextInt();
        int[][] graph=new int[V][V];
        System.out.println("Enter weight adjacency matrix");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j]= sc.nextInt();
            }
        }
        System.out.println("Enter source vertex");
        src=sc.nextInt();
        djikstra(V, graph, src);
    }
}