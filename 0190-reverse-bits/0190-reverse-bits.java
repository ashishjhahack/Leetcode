class Solution {
    public int reverseBits(int n) {
        if(n==0) return 0;
        int result = 0; 
        // it is a 32 bit operation
        for(int i=0; i<32; i++){
            result <<= 1;    // left shift the result 
            result |= (n & 1);  // get the LSB and then append it in result using OR operation
            n >>>= 1;    // Right shift n to get new LSB
        }
        return result;
    }
}