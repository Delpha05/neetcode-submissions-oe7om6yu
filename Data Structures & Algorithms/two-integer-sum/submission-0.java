class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                int j = map.get(target-nums[i]);
                return new int[] {Math.min(i,j), Math.max(i,j)};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {0,0};
    }
}
