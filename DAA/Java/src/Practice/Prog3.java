package Practice;

import java.util.Scanner;

public class Prog3 {
    static int[] order=new int[100];
    static int o_n;
    public static void main(String[] args) {
        int v,st;
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        int[][] a_m = new int[v][v];
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                a_m[i][j]= sc.nextInt();
        st= sc.nextInt();
        boolean[] visited=new boolean[v];
        dfs(visited,st,a_m,v);
        for(int i=0;i<o_n;i++) System.out.print(order[i]+" ");
        System.out.println();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                o_n=0;
                dfs(visited,i,a_m,v);
                for(int j=0;j<o_n;j++) System.out.print(order[j]+" ");
                System.out.println();
            }
        }
        o_n=0;
        visited=new boolean[v];
        bfs(visited,st,a_m,v);
        for(int i=0;i<o_n;i++) System.out.print(order[i]+" ");
        System.out.println();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                o_n=0;
                bfs(visited,i,a_m,v);
                for(int j=0;j<o_n;j++) System.out.print(order[j]+" ");
                System.out.println();
            }
        }
    }

    private static void bfs(boolean[] visited, int cur, int[][] a_m, int v) {
        int f=0,r=0;
        int[] q=new int[100];
        q[f++]=cur;
        while(r!=f){
            cur=q[r++];
            if(visited[cur])continue;
            visited[cur]=true;
            order[o_n++]=cur;
            for(int i=0;i<v;i++){
                if(a_m[cur][i]==0||visited[i])continue;
                q[f++]=i;
            }
        }
    }

    private static void dfs(boolean[] visited, int cur, int[][] a_m, int v) {
        if(visited[cur])return;
        visited[cur]=true;
        order[o_n++]=cur;
        for(int i=0;i<v;i++){
            if(a_m[cur][i]==0||visited[i])continue;
            dfs(visited,i,a_m,v);
        }
    }
}
