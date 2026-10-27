class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }     

        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> 
            Integer.compare(countMap.get(a), countMap.get(b)));
        
        for (int key : countMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }
}
