class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;     // no. of rows
        int m = matrix[0].length;  // no. of cols

        int row = 0, col = m-1;
        // traverse while within the matrix bound
        while(row <  n && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}