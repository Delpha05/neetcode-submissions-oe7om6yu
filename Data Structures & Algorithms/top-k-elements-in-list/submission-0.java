class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];

        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a,b) -> map.get(a) - map.get(b)
        );

        for(int n : map.keySet()){
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }

        for(int i = 0; i<k;i++){
            res[i] = heap.poll();
        }

        return res;
    }
}
