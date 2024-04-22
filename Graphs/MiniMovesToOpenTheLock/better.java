class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if(deadendSet.contains("0000"))
            return -1;
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair("0000", 0));
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while(!queue.isEmpty()){

            Pair<String, Integer> front = queue.poll();
            String currentCombi = front.getKey();
            int moves = front.getValue();

            if(currentCombi.equals(target)){
                return moves;
            }

            for(int i = 0; i < 4; i++){
                
                for(int delta : new int[] {-1, 1}){
                    int newDigit = (currentCombi.charAt(i) - '0' + delta + 10) % 10;
                    String newCombi = currentCombi.substring(0, i) + newDigit + currentCombi.substring(i + 1);

                    if(!visited.contains(newCombi) && !deadendSet.contains(newCombi)){

                        visited.add(newCombi);
                        queue.offer(new Pair(newCombi, moves + 1));
                    }
                }

            }
        }

        return -1;
    }
}