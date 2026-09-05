class Solution {
    static int dp[];
    public int earn(int i, Map<Integer,Integer> map, ArrayList<Integer> list){
    if(i >= list.size()) return 0;
    int take = 0;
    if(dp[i] != -1) return dp[i];
    if(i + 1 < list.size()  && list.get(i)+1 == list.get(i+1)){
        take = list.get(i) * map.get(list.get(i)) + earn(i+2,map,list);
    }else{
        take = list.get(i) * map.get(list.get(i)) + earn(i+1,map,list);
    }
    int notTake = earn(i + 1,map,list);
    return dp[i] = Math.max(take,notTake);
    
    }


    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int element:nums){
            map.put(element,map.getOrDefault(element,0)+1);
        }
           ArrayList<Integer> list = new ArrayList<>();
            Arrays.sort(nums);
            for(int element:nums) {
                if(!list.contains(element)) list.add(element);
            }
            dp = new int[list.size()];
            Arrays.fill(dp, -1);
            return earn(0,map,list);
    }
}
