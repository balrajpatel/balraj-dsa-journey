import java.util.*;
class BfsDfs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ver = sc.nextInt();
        int edges = sc.nextInt();

        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i=0; i<edges; i++){
            int v = sc.nextInt();
            int u = sc.nextInt();
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
        }
        boolean[] visited = new boolean[ver];

        for(int i=0; i<ver; i++){
            if(!visited[i])
                dfs(adj,i,visited);
        }

    }

    static void dfs(Map<Integer, List<Integer>> adj, int v, boolean[] visited){
            visited[v]=true;
            for(int nb : adj.getOrDefault(v,new ArrayList<>())){
                if(!visited[nb]){
                    dfs(adj,nb,visited);
            }
        
    }

    static void bfs(Map<Integer,List<Integer>> adj, int v, boolean[] visited){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i =0;i<v; i++){
            if(!visited[i]){
                q.offer(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int u = q.poll();
                    for(int nb:adj.getOrDefault(u,new ArrayList<>())){
                        if(!visited[nb]){
                            q.offer(nb);
                            visited[nb] = true;
                        }
                    }
                }

            }
        }
    }

}