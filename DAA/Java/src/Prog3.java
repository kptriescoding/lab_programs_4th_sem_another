import java.util.*;
public class Prog3 {
    static int ind;
    static int order[];
    static int [][] adj_matrix;
    public static void bfs(boolean [] visited,int cur){
        int front=0,rear=0;
        int [] queue=new int[1000];
        queue[front++]=cur;
        int v=visited.length;
        visited[cur]=true;
        order[ind++]=cur;
        while(rear<front){
            cur=queue[rear++];
            for(int i=0;i<v;i++){
                if(adj_matrix[cur][i]==0)continue;
                if(visited[i])continue;
                visited[i]=true;
                order[ind++]=i;
                queue[front++]=i;
            }
        }
    }
    public static void dfs(boolean[] visited,int cur){
        if(visited[cur])return;
        visited[cur]=true;
        order[ind++]=cur;
        int v=visited.length;
        for(int i=0;i<v;i++)
        {
            if(adj_matrix[cur][i]==0)continue;
            dfs(visited,i);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v,i,st;
        System.out.println("Enter the number of vertices");
        v= sc.nextInt();
        adj_matrix=new int[v][v];
        System.out.println("Enter the adjacency matrix\n");
        for(i=0;i<v;i++)
            for(int j=0;j<v;j++)
                adj_matrix[i][j]= sc.nextInt();
        System.out.println("Enter the starting vertex");
        st=sc.nextInt();
        order=new int[100];
        ind=0;
        int comp=0;
        boolean [] visited=new boolean[v];
        Arrays.fill(visited,false);
        System.out.println("The order of tree traversal with DFS is");
        dfs(visited, st);
        comp++;
        System.out.println("Component "+comp);
        for (int j=0;j<ind;j++)
            System.out.print(order[j]+" ");
        System.out.println();
        for(i=0;i<v;i++) {
            if (visited[i]) continue;
            order=new int[100];
            ind=0;
            dfs(visited, i);
            comp++;
            System.out.println("Component "+comp);
            for (int j=0;j<ind;j++)
                System.out.print(order[j]+" ");
            System.out.println();
        }
        order=new int[100];
        ind=0;
        comp=0;
        Arrays.fill(visited,false);
        System.out.println("The order of tree traversal with BFS is");
        bfs(visited, st);
        comp++;
        System.out.println("Component "+comp);
        for (int j=0;j<ind;j++)
            System.out.print(order[j]+" ");
        System.out.println();
        for(i=0;i<v;i++) {
            if (visited[i]) continue;
            order=new int[100];
            ind=0;
            bfs(visited, i);
            comp++;
            System.out.println("Component "+comp);
            for (int j=0;j<ind;j++)
                System.out.print(order[j]+" ");
            System.out.println();
        }
    }
}
