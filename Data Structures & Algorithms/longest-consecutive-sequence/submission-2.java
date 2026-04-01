class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n ==0) return 0;
        int max = 1;
        Set<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num);

        for(int num : set){
            if(!set.contains(num-1)){
                int streak =1;
                int curr = num;

                while(set.contains(curr+1)){
                    curr++;
                    streak++;
                }
                max=Math.max(max, streak);
            }
        }

        return max;
    }
}
