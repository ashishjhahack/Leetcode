class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i=n-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            // else last digit is 9
            digits[i] = 0;
        }
        // worst-caseof S.C: if all digits are 9
        int[] res = new int[n+1];
        res[0] = 1;

        return res;
    }
}