package Practice_Again;

import java.util.Arrays;
import java.util.Scanner;

public class Prog3 {
    static int o_n;
    static int[] ans;
    static int v,st;
    static int[][] a_m;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        ans=new int[v];
        a_m=new int[v][v];
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                a_m[i][j]=sc.nextInt();
        st=sc.nextInt();
        boolean[] vis=new boolean[v];
        Arrays.fill(vis,false);
        o_n=0;
        dfs(vis,st);
        for(int j=0;j<o_n;j++) System.out.print(ans[j]+" ");
        System.out.println();
        for(int i=0;i<v;i++)
        {
            if(vis[i])continue;
            o_n=0;
            dfs(vis,i);
            for(int j=0;j<o_n;j++) System.out.print(ans[j]+" ");
            System.out.println();
        }
        Arrays.fill(vis,false);
        o_n=0;
        bfs(vis,st);
        for(int j=0;j<o_n;j++) System.out.print(ans[j]+" ");
        System.out.println();
        for(int i=0;i<v;i++)
        {
            if(vis[i])continue;
            o_n=0;
            bfs(vis,i);
            for(int j=0;j<o_n;j++) System.out.print(ans[j]+" ");
            System.out.println();
        }
    }

    private static void bfs(boolean[] vis, int cur) {
        int f=0,r=0;
        int[] q=new int[1000];
        q[r++]=cur;
        while(r!=f){
            cur=q[f++];
            if(vis[cur])continue;
            vis[cur]=true;
            ans[o_n++]=cur;
            for(int i=0;i<v;i++)
                if(a_m[cur][i]==1)q[r++]=i;
        }
    }

    private static void dfs(boolean[] vis, int cur) {
        if(vis[cur])return;
        vis[cur]=true;
        ans[o_n++]=cur;
        for(int i=0;i<v;i++)
            if(a_m[cur][i]==1)dfs(vis,i);
    }

}
