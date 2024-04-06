class Solution {

    public boolean isHighAccess(List<Integer> times){
        int n = times.size();
        for(int i = 2; i < n; i++){
            
            if(times.get(i) - times.get(i - 2) <= 99){
                return true;
            }
        }

        return false;
    }
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {

        List<String> ans = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        for(List<String> access : access_times){

            String emp = access.get(0);
            String time = access.get(1);

            if(!map.containsKey(emp)){

                map.put(emp, new ArrayList<>());
            }

            int t = Integer.parseInt(time);
            map.get(emp).add(t);

        }

        for(String emp : map.keySet()){

            List<Integer> times =  map.get(emp);
            Collections.sort(times);

            if(isHighAccess(times)){
                ans.add(emp);
            }

        }

        return ans;
        
    }
}