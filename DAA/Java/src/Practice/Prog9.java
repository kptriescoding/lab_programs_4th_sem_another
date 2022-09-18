package Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Prog9 {
    public static void main(String[] args) {
        int v,st;
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        int[][] w_m = new int[v][v];
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                w_m[i][j]= sc.nextInt();
        st= sc.nextInt();
        System.out.println(Dijistra(w_m,v,st));
    }

    private static int Dijistra(int[][] w_m, int v, int st) {
        int []dist=new int[v];
        boolean[] visited=new boolean[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[st]=0;
        int minDist=0;
        for(int i=0;i<v;i++)
            addNextVertex(dist,w_m,v,visited);
        for(int i=0;i<v;i++) {
            System.out.println(st + "->" + i + ":" + dist[i]);
            minDist+=dist[i];
        }
        return minDist;
    }

    private static void addNextVertex(int[]dist, int[][] w_m, int v,boolean[] visited) {
        int vi=-1,w=Integer.MAX_VALUE;
        for(int i=0;i<v;i++)
            if(!visited[i]&&w>dist[i]){
                w=dist[i];
                vi=i;
            }
        visited[vi]=true;
        for(int j=0;j<v;j++)
            if(w_m[vi][j]!=0)dist[j]=min(dist[j],dist[vi]+w_m[vi][j]);

    }

    private static int min(int a, int b) {
        if(a<b)return a;
        return b;
    }
}
