class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums){
            // step-1: put every element inside minHeap
            minHeap.offer(num);  

            // step-2: if size become greater than k then remove min element from it
            if(minHeap.size() > k){
                minHeap.poll();  
            } 
        }
        return minHeap.peek();
    }
}