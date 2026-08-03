class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] merge = new int[m+n];
        while(i < m && j < n){
            if(nums1[i] < nums2[j]) merge[k++] = nums1[i++];
            else merge[k++] = nums2[j++];
        }
        while(i<m) merge[k++] = nums1[i++];
        while(j<n) merge[k++] = nums2[j++];

        // for finding median
        int len = merge.length;
        if(len % 2 == 0) return (merge[len/2] + merge[len/2-1])/2.0;
        else return merge[len/2];
    }
}