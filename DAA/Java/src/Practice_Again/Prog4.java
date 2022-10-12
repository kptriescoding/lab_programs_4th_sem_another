package Practice_Again;

import java.util.Arrays;
import java.util.Scanner;

public class Prog4 {
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
        boolean[] vis=new boolean[v];
        Arrays.fill(vis,false);
        o_n=0;
        for(int i=0;i<v;i++)
        {
            if(vis[i])continue;
            dfs(vis,i);
        }
        for(int j=o_n-1;j>-1;j--) System.out.print(ans[j]+" ");
        System.out.println();
        VertexDeletetion();
        for(int j=0;j<o_n;j++) System.out.print(ans[j]+" ");
        System.out.println();
    }

    private static void VertexDeletetion() {
        int[] in=new int[v];
        o_n=0;
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                if(a_m[i][j]==1)in[j]++;
        while(o_n!=v){
           for(int i=0;i<v;i++){
               if(in[i]!=0)continue;
               in[i]=-1;
               ans[o_n++]=i;
               for(int j=0;j<v;j++)
                   if(a_m[i][j]==1)in[j]--;
           }
        }
    }


    private static void dfs(boolean[] vis, int cur) {
        if(vis[cur])return;
        vis[cur]=true;
        for(int i=0;i<v;i++)
            if(a_m[cur][i]==1)dfs(vis,i);
        ans[o_n++]=cur;
    }
}
