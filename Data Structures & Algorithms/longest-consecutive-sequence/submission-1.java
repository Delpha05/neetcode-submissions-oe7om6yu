class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n ==0) return 0;
        int max = 1, streak = 1;
        Arrays.sort(nums);

        for(int i =1; i<n; i++){
            if(nums[i] == nums[i-1] + 1)
                streak++;
            else if (nums[i] == nums[i-1])
                continue;
            else 
                streak = 1;
            
            max = Math.max(max, streak);
        }
        return max;
    }
}
