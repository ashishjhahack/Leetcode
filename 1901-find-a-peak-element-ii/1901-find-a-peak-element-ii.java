class Solution {
// For a 2-D array,
// The search will cover the column range from 0 to col-1, where col is the total number of columns.
// We choose a middle column and identify the row with the largest element in that column.
// We apply similar logic as in 1-D: if this element is bigger than both its side neighbors, we’ve found the peak.
// If the left neighbor is bigger, we only search the left part; if the right neighbor is bigger, we search the right part.
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;      // no. of rows
        int n = mat[0].length;   // no. of cols

        int low = 0, high = n-1;  // select a column range
        while(low <= high){
            int mid = low + (high - low)/2;   // column mid
            // find maximum row in that col mid
            int maxRow = 0;
            for(int i = 1; i < m; i++){
                if(mat[i][mid] > mat[maxRow][mid]){
                    maxRow = i;
                }
            }

            // handle the case if mid in outer col 
            int left = (mid == 0) ? -1 : mat[maxRow][mid-1];
            int right = (mid == n-1) ? -1 : mat[maxRow][mid+1];

            if(left < mat[maxRow][mid] && mat[maxRow][mid] > right){
                return new int[] {maxRow, mid};
            }
            else if(left > mat[maxRow][mid]) high = mid-1;
            else low = mid + 1;
        }
        return new int[] {-1, -1};
    }
}