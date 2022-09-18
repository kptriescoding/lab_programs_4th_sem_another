package Practice;

import java.util.Scanner;

public class Prog4 {
    static int[] order=new int[100];
    static int o_n=0;
    public static void main(String[] args) {
        int v;
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        int[][] a_m = new int[v][v];
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                a_m[i][j]= sc.nextInt();
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++)
            if(!visited[i])
                dfs(visited,i,a_m,v);
        for(int j=o_n-1;j>-1;j--) System.out.print(order[j]+" ");
        System.out.println();
        o_n=0;
        vertexRemoval(a_m,v);
        for(int j=0;j<o_n;j++) System.out.print(order[j]+" ");
        System.out.println();
    }

    private static void vertexRemoval(int[][] a_m, int v) {
        int [] indegree=new int[v];
        for(int i=0;i<v;i++)indegree[i]=0;
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                if(a_m[i][j]==1)indegree[j]++;
        int vis=0;
        while(vis!=v){
            for(int i=0;i<v;i++){
                if(indegree[i]!=0)continue;
                indegree[i]=-1;
                order[o_n++]=i;
                vis++;
                for(int j=0;j<v;j++)
                    if(a_m[i][j]==1)indegree[j]--;
            }
        }

    }

    private static void dfs(boolean[] visited, int cur, int[][] a_m, int v) {
        if(visited[cur])return;
        visited[cur]=true;
        for(int i=0;i<v;i++){
            if(a_m[cur][i]==0||visited[i])continue;
            dfs(visited,i,a_m,v);
        }
        order[o_n++]=cur;
    }
}
