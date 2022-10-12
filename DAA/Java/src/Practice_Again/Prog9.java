package Practice_Again;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;

public class Prog9 {
    public static void main(String[] args) {
        int v,st;
        int[][] wt;
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        wt=new int[v][v];
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                wt[i][j]=sc.nextInt();
        st=sc.nextInt();
        Dijistra(wt,v,st);
    }

    private static void Dijistra(int[][] wt, int v, int st) {
        int[] dis=new int[v];
        boolean[] vis=new boolean[v];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[st]=0;
        for(int i=0;i<v;i++)
            addNextVertex(wt,v,dis,vis);
        for(int i=0;i<v;i++)
            System.out.println(st+"->"+i+":"+dis[i]);
    }

    private static void addNextVertex(int[][] wt, int v, int[] dis,boolean[] vis) {
        int vi=-1,w=Integer.MAX_VALUE;
        for(int i=0;i<v;i++)
            if(!vis[i]&&w>dis[i]){
                w=dis[i];
                vi=i;
            }
        vis[vi]=true;
        for(int j=0;j<v;j++)
            if(wt[vi][j]!=0)dis[j]=min(dis[j],dis[vi]+wt[vi][j]);
    }
}
