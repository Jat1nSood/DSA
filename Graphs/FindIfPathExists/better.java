class Solution {
    public boolean dfs(int source, int[] vis, ArrayList<ArrayList<Integer>> adj, int destination){

        vis[source] = 1;
        if(source == destination){
            return true;
        }
        for(Integer adjNode : adj.get(source)){
            if(vis[adjNode] == 0){
                if(dfs(adjNode, vis, adj, destination)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        int m = edges.length;
        for(int i = 0; i < m; i++){

                int u = edges[i][0];
                int v = edges[i][1];

                adj.get(u).add(v);
                adj.get(v).add(u);
        }

        int [] vis = new int[n];

        return dfs(source, vis, adj, destination);
        
    }
}