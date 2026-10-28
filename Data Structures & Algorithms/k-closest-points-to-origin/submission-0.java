class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1])
        );

        for (int[] pt : points) {
            maxHeap.offer(pt);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll();
            i++;
        }

        return result;
    }
}
