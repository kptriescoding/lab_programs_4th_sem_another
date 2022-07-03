import java.util.*;
public class Prog4 {
    public static void VertexRemovalMethod(HashMap<Integer, ArrayList<Integer>> adj_list, HashMap<Integer, Integer> indegree, ArrayList<Integer> order, int vertices, int visitedVertices) {
    while(vertices!=visitedVertices){
        for(Map.Entry<Integer,Integer>it:indegree.entrySet()){
            int ind=it.getKey();
            if(it.getValue()!=0)continue;
            it.setValue(-1);
            visitedVertices++;
            order.add(ind);
            ArrayList<Integer>arr=adj_list.get(ind);
            if(arr==null)continue;
            for (Integer integer : arr) {
                indegree.merge(integer, -1, Integer::sum);
            }
            break;
        }
    }
    }
    public static void DFSMethod(HashMap<Integer, ArrayList<Integer>> adj_list, HashMap<Integer, Boolean> visited, ArrayList<Integer> order,int cur){
        if(visited.get(cur))return;
        visited.put(cur,true);
        ArrayList<Integer>arr=adj_list.get(cur);
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
        HashMap<Integer, Boolean>visited=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>>adj_list=new HashMap<>();
        HashMap<Integer,Integer>indegree=new HashMap<>();
        System.out.println("Enter the number of vertices");
        vertices=s.nextInt();
        System.out.println("Enter the number of edges");
        edges=s.nextInt();
        System.out.println("Enter the number of connected vertices v1->v2");
        for(int i=0;i<edges;i++) {
            ver1=s.nextInt();
            ver2=s.nextInt();
            adj_list.computeIfAbsent(ver1,k->new ArrayList<>());
            indegree.putIfAbsent(ver1, 0);
            indegree.merge(ver2,1,Integer::sum);
            adj_list.get(ver1).add(ver2);
            visited.put(ver1,false);
            visited.put(ver2,false);
        }

        ArrayList<Integer> order=new ArrayList<>();
        VertexRemovalMethod(adj_list,indegree,order,vertices,visitedVertices);
        System.out.println("The topological order using Vertex Deletion Method is");
        for (Integer integer : order) System.out.print(integer + " ");
        order.clear();
        int cur;
        for(Map.Entry<Integer,Boolean>it:visited.entrySet()){
            if(it.getValue())continue;
            cur=it.getKey();
            DFSMethod(adj_list,visited,order,cur);
        }
        Collections.reverse(order);
        System.out.println("\nThe topological order using DFS Method is");
        for (Integer integer : order) System.out.print(integer + " ");
    }

}
