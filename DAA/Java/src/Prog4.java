import java.util.*;
public class Prog4 {
    static int v;
    static int [][]adj_matrix;
    static int[] order;
    static int ind;
    public static void VertexRemovalMethod(int[][] adj_matrix) {
        int [] indegree=new int[v];
        Arrays.fill(indegree,0);
        ind=0;
        int visitedVertices=0;
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                if(adj_matrix[i][j]==1)indegree[j]++;
        while(v!=visitedVertices){
            for(int i=0;i<v;i++){
                if(indegree[i]!=0)continue;
                indegree[i]=-1;
                visitedVertices++;
                order[ind++]=i;
                for (int j=0;j<v;j++)
                    if(adj_matrix[i][j]==1) indegree[j]--;
                break;
            }
        }
    }
    public static void dfs(boolean[] visited,int cur){
        if(visited[cur])return;
        visited[cur]=true;
        int v=visited.length;
        for(int i=0;i<v;i++)
        {
            if(adj_matrix[cur][i]==0)continue;
            dfs(visited,i);
        }
        order[ind++]=cur;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        v= sc.nextInt();
        adj_matrix=new int[v][v];
        System.out.println("Enter the adjacency matrix\n");
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                adj_matrix[i][j]= sc.nextInt();
        order=new int[v];
        VertexRemovalMethod(adj_matrix);
        System.out.println("The topological order using Vertex Deletion Method is");
        for (int i=0;i<v;i++) System.out.print(order[i] + " ");
        order=new int[v];
        ind=0;
        int cur;
        boolean[]visited=new boolean[v];
        Arrays.fill(visited,false);
        for(int i=0;i<v;i++){
            if(visited[i])continue;
            cur=i;
            dfs(visited,cur);
        }
        System.out.println("\nThe topological order using DFS Method is");
        for(int i=v-1;i>-1;i--) System.out.print(order[i] + " ");
    }

}
