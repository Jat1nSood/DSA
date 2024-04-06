
class Pair implements Comparable<Pair>{
    int first;
    int second;
    Pair(int a,int b){
        first = a;
        second = b;
    }
    public int compareTo(Pair obj){
        return second-obj.second;
    }
}
class Solution
{
    public String exercise(int N, int M, ArrayList<ArrayList<Integer>> a, int src, int dest, int X)
    {
        
        List<List<Pair>> adj = new ArrayList<>();
        
        for (int i = 0; i < N; i++){
            
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            
          
                int u = a.get(i).get(0);
                int v = a.get(i).get(1);
                int wt = a.get(i).get(2);
                
                Pair pair1 = new Pair(v, wt);
                Pair pair2 = new Pair(u, wt);
                
                adj.get(u).add(pair1);
                adj.get(v).add(pair2);
        }
        
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int[] dis = new int[N];
        
        for (int i = 0; i < N; i++){
            dis[i] = (int)1e9;
        }
        dis[src] = 0;
        
        pq.add(new Pair(0, src));
        
        while(!pq.isEmpty()){
            
            Pair top = pq.poll();
            
            int node = top.second;
            int wt = top.first;
            
            for(Pair it : adj.get(node)){
                
                int adjNode = it.first;
                int adjWgt = it.second;
                
                if(adjWgt + wt < dis[adjNode]){
                    
                    dis[adjNode] = adjWgt + wt;
                    Pair pair = new Pair(dis[adjNode], adjNode);
                    pq.add(pair);
                }
            }
            
            
        }
        
        if (dis[dest] > X) {
            
            return "Neeman's Wool Joggers";
        }
        
        return "Neeman's Cotton Classics";
        
    }
}