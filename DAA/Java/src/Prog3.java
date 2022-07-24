import java.util.*;
public class Prog3 {
    public static void bfs(boolean[] visited,int cur,ArrayList<Integer>[] adj_list,ArrayList<Integer> order) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(cur);
        int n;
        ArrayList<Integer> arr;
        while(!queue.isEmpty()){
            cur=queue.remove();
            if(!visited[cur]){
                order.add(cur);
                visited[cur]=true;
            }
            arr=adj_list[cur];
            n=arr.size();
            for(int i=0;i<n;i++){
                if(visited[arr.get(i)])continue;
                visited[arr.get(i)]=true;
                order.add(arr.get(i));
                queue.add(arr.get(i));
            }
        }
    }
    public static void dfs_stack(boolean[] visited,int cur,ArrayList<Integer>[] adj_list,ArrayList<Integer> order) {
        Stack<Integer> stack=new Stack<>();
        stack.push(cur);
        int n;
        ArrayList<Integer> arr;
        while(!stack.empty()){
            cur=stack.pop();
            if(!visited[cur]) {
                order.add(cur);
                visited[cur]=true;
            }
            arr=adj_list[cur];
            n=arr.size();
            for(int i=0;i<n;i++){
                if(visited[arr.get(i)])continue;
                visited[arr.get(i)]=true;
                order.add(arr.get(i));
                stack.push(cur);
                stack.push(arr.get(i));
                break;
            }
        }
    }
    public static void dfs(boolean[] visited,int cur,ArrayList<Integer>[] adj_list,ArrayList<Integer> order) {
        if(visited[cur])return;
        order.add(cur);
        visited[cur]= true;
        ArrayList<Integer> arr=adj_list[cur];
        for (int x : arr) {
            if (!visited[x])
                dfs(visited, x, adj_list, order);
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int edges,ver1,ver2,i,st;
        ArrayList<Integer>[] adj_list=new ArrayList[100];
        for(i=0;i<100;i++)adj_list[i]=new ArrayList<>();
        boolean[] visited=new boolean[100];
        ArrayList<Integer> order=new ArrayList<>();
        System.out.println("Enter the number of edges");
        edges= scan.nextInt();
        for(i=0;i<100;i++)visited[i]=true;
        System.out.println("Enter the connected vertices as v1 v2");
        for(i=0;i<edges;i++) {
            ver1 = scan.nextInt();
            ver2 = scan.nextInt();
            adj_list[ver1].add(ver2);
            adj_list[ver2].add(ver1);
            visited[ver1]=false;
            visited[ver2]=false;
        }
        System.out.println("Enter the start point");
        st= scan.nextInt();
        int comp=0;
        boolean[] vistited_copy=visited.clone();
        System.out.println("The order of tree traversal with DFS is");
        dfs(visited, st, adj_list, order);
        comp++;
        System.out.println("Component "+comp);
        for (i=0;i<order.size();i++)
            System.out.print(order.get(i)+" ");
        order.clear();
        for(i=0;i<100;i++) {
            if (visited[i]) continue;
            dfs(visited, i, adj_list, order);
            comp++;
            System.out.println("\nComponent "+comp);
            for (i=0;i<order.size();i++)
                System.out.print(order.get(i)+" ");
            order.clear();
        }
        comp=0;
        visited=vistited_copy.clone();
        System.out.println("\n\n\nThe order of tree traversal with BFS is");
        bfs(visited, st, adj_list, order);
        comp++;
        System.out.println("Component "+comp);
        for (i=0;i<order.size();i++)
            System.out.print(order.get(i)+" ");
        order.clear();
        for(i=0;i<100;i++) {
            if (visited[i]) continue;
            bfs(visited, i, adj_list, order);
            comp++;
            System.out.println("\nComponent " + comp);
            for (i = 0; i < order.size(); i++)
                System.out.print(order.get(i) + " ");
            order.clear();
        }
    }
}