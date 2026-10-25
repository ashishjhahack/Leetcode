class Solution {
    public int reverseBits(int n) {
        if(n==0) return 0;
        int result = 0; 
        // it is a 32 bit operation
        for(int i=0; i<32; i++){
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }
}