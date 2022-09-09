import java.util.Arrays;
import java.util.Scanner;

public class Prog8 {
    static class Edge{
        int src,dest;
    }
    public static int [][] w_matrix;
    public static int v;
    static int eind;
    public static void Prims(int st){
        eind=0;
        Edge [] edges=new Edge[100];
        int [] key=new int[v];
        Arrays.fill(key,Integer.MAX_VALUE);
        boolean[] visited=new boolean[v];
        Arrays.fill(visited,false);
        visited[st]=true;
        key[st]=0;
        int minSpan=0;
        for(int i=0;i<v-1;i++)
           minSpan=addNextVertex(visited,minSpan,edges);
        System.out.println("The Edges obtained are");
        for(int i=0;i<eind;i++)
            System.out.printf("src:%d dest:%d weight:%d\n",edges[i].src,edges[i].dest,w_matrix[edges[i].src][edges[i].dest]);
        System.out.println("The minimum spanning length is "+ minSpan);
    }

    private static int addNextVertex(boolean[] visited,int minSpan,Edge[] edges) {
        int verj=-1,w=Integer.MAX_VALUE,veri=-1;
        for(int i=0;i<v;i++)
            if(visited[i])
                for(int j=0;j<v;j++)
                    if(!visited[j]&&w>w_matrix[i][j]&&w_matrix[i][j]!=0){
                    veri=i;
                    w=w_matrix[i][j];
                    verj=j;
                }
        Edge edge=new Edge();
        edge.src=veri;
        edge.dest=verj;
        edges[eind++]=edge;
        visited[verj]=true;
        minSpan+=w;
        return minSpan;
    }
    private static int addNextVertex(boolean[] visited,int minSpan,Edge[] edges,int[] key){
        int veri=-1;
        for(int j=0;j<v;j++)
            if(!visited[j]&&(veri==-1||key[j]<key[veri]))
                veri=j;
        visited[veri]=true;
        minSpan+=key[veri];
        for(int j=0;j<v;j++)
            if(w_matrix[veri][j]!=0 && !visited[j])
                key[j]=min(key[j],w_matrix[veri][j]);
        return minSpan;
    }

    private static int min(int a, int b) {
        if(a<b)return a;
        return b;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        v= sc.nextInt();
        System.out.println("Enter the weighted matrix");
        w_matrix=new int[v][v];
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                w_matrix[i][j]= sc.nextInt();
        int st;
        System.out.println("Enter the starting vertex");
        st= sc.nextInt();
        Prims(st);
    }
}
