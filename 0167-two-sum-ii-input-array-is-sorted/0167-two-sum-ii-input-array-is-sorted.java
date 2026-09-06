class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] ans = new int[2];
        int i = 0, j = n-1;
        while(i < j){
            int sum = numbers[i]+numbers[j];
            if(sum == target){
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;   // returns the ans immediately so loop will stopped
            }
            else if(sum < target){
                i++;
            }
            else j--;
        }
        return ans;
    }
}