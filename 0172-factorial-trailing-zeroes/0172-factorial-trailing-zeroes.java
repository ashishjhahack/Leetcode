class Solution {
    public int trailingZeroes(int n) {
        // whenever n is 5 we have our zero
        int count = 0;
        while(n >= 5){
            n = n/5;
            count += n;   
        }
        return count;
    }
}