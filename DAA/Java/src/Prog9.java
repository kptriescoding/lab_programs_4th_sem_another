import java.util.Arrays;
import java.util.Scanner;

public class Prog9 {
    public static int [][] w_matrix;
    public static int v;
    public static void Dijistra(int st){
        int [] dist=new int[100];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[] visited=new boolean[v];
        Arrays.fill(visited,false);
        dist[st]=0;
        for(int i=0;i<v-1;i++)
            addNextVertex(visited,dist);
        System.out.printf("The distance of each point from %d is\n",st);
        for(int i=0;i<v;i++)
            System.out.printf("%d dist:%d\n",i,dist[i]);
    }

    private static void addNextVertex(boolean[] visited,int[] dist) {
        int veri=-1;
                for(int j=0;j<v;j++)
                    if(!visited[j]&&(veri==-1||dist[j]<dist[veri]))
                        veri=j;
        visited[veri]=true;
                for(int j=0;j<v;j++)
                    if(w_matrix[veri][j]!=0)
                        dist[j]=min(dist[j],dist[veri]+w_matrix[veri][j]);
    }
    private static void bruteForce(boolean[] visited,int [] dist){
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                if(w_matrix[i][j]!=0)
                dist[j]=min(dist[j],dist[i]+w_matrix[i][j]);
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
        Dijistra(st);
    }
}