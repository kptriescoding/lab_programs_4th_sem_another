package Practice;

import java.util.Scanner;

public class Prog8 {
    public static void main(String[] args) {
        int v,st;
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        int[][] w_m = new int[v][v];
        for(int i=0;i<v;i++)
            for(int j=0;j<v;j++)
                w_m[i][j]= sc.nextInt();
        st= sc.nextInt();
        System.out.println(Prims(w_m,v,st));
    }

    private static int Prims(int[][] w_m, int v, int st) {
        boolean[] visited=new boolean[v];
        int minSpan=0;
        visited[st]=true;
        for(int i=0;i<v-1;i++)
            minSpan+=addNextVertex(visited,w_m,v);
        return minSpan;
    }

    private static int addNextVertex(boolean[] visited, int[][] w_m, int v) {
        int vi=-1,vj=-1,w=Integer.MAX_VALUE;
        for(int i=0;i<v;i++)
            if(visited[i])
                for(int j=0;j<v;j++)
                    if(!visited[j]&&w_m[i][j]<w&&w_m[i][j]!=0){
                        vi=i;
                        vj=j;
                        w=w_m[i][j];
                    }
        System.out.println(vi+"->"+vj+":"+w);
        visited[vj]=true;
        return w;
    }
}
