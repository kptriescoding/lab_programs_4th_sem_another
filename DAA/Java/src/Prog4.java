import java.util.*;
public class Prog4 {
    public static void VertexRemovalMethod(ArrayList<Integer>[] adj_list, int[] indegree, ArrayList<Integer> order, int vertices, int visitedVertices) {
    while(vertices!=visitedVertices){
        for(int i=0;i<100;i++){
            if(indegree[i]!=0)continue;
            indegree[i]=-1;
            visitedVertices++;
            order.add(i);
            ArrayList<Integer>arr=adj_list[i];
            if(arr==null)continue;
            for (Integer integer : arr) {
                indegree[integer]-=1;
            }
            break;
        }
    }
    }
    public static void DFSMethod(ArrayList<Integer>[] adj_list, boolean[] visited, ArrayList<Integer> order,int cur){
        if(visited[cur])return;
        visited[cur]=true;
        ArrayList<Integer>arr=adj_list[cur];
        if(arr!=null){
            for(Integer integer:arr){
                DFSMethod(adj_list,visited,order,integer);
            }
        }
        order.add(cur);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int visitedVertices=0,vertices,edges,ver1,ver2;
       boolean[] visited=new boolean[100];
        ArrayList<Integer>[] adj_list=new ArrayList[100];
        int[] indegree=new int[100];
        for(int i=0;i<100;i++){
            adj_list[i]=new ArrayList<>();
            visited[i]=true;
            indegree[i]=-1;
        }
        System.out.println("Enter the number of vertices");
        vertices=s.nextInt();
        System.out.println("Enter the number of edges");
        edges=s.nextInt();
        System.out.println("Enter the number of connected vertices v1->v2");
        for(int i=0;i<edges;i++) {
            ver1=s.nextInt();
            ver2=s.nextInt();
            if(indegree[ver1]==-1)indegree[ver1]=0;
            if(indegree[ver2]==-1)indegree[ver2]=0;
            indegree[ver2]+=1;
            adj_list[ver1].add(ver2);
            visited[ver1]=false;
            visited[ver2]=false;
        }

        ArrayList<Integer> order=new ArrayList<>();
        VertexRemovalMethod(adj_list,indegree,order,vertices,visitedVertices);
        System.out.println("The topological order using Vertex Deletion Method is");
        for (Integer integer : order) System.out.print(integer + " ");
        order.clear();
        int cur;
        for(int i=0;i<100;i++){
            if(visited[i])continue;
            cur=i;
            DFSMethod(adj_list,visited,order,cur);
        }
        Collections.reverse(order);
        System.out.println("\nThe topological order using DFS Method is");
        for (Integer integer : order) System.out.print(integer + " ");
    }

}
