class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Approach :- Flattern 2D matrix to 1D
        int n = matrix.length;    // no. of rows
        int m = matrix[0].length; // no. of cols

        int low = 0, high = n*m-1;    // search range
        while(low <= high){
            int mid = low + (high - low)/2;
            // Map 1D index to 2D coordinates
            int row = mid/m;
            int col = mid%m;

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target){ // discard the left
                low = mid + 1;
            }
            else high = mid-1;
        }
        return false;
    }
}