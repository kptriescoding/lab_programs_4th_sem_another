package Practice_Again;

import java.util.Arrays;
import java.util.Scanner;

public class Prog8 {
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
        Prims(wt,v,st);
    }

    private static void Prims(int[][] wt, int v, int st) {
        boolean[] vis=new boolean[v];
        Arrays.fill(vis,false);
        vis[st]=true;
        int ml = 0;
        for(int i=0;i<v-1;i++)
            ml+=addNextVertex(wt,v,vis);
        System.out.println(ml);
    }

    private static int addNextVertex(int[][] wt, int v, boolean[] vis) {
        int vi=-1,vj=-1,w=Integer.MAX_VALUE;
        for(int i=0;i<v;i++)
            if(vis[i])
                for(int j=0;j<v;j++)
                    if(!vis[j]&&w>wt[i][j]&&wt[i][j]!=0){
                        vi=i;
                        vj=j;
                        w=wt[i][j];
                    }
        vis[vj]=true;
        System.out.println(vi+"->"+vj+":"+w);
        return w;
    }
}
