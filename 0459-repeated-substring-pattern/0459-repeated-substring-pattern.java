class Solution {
    public int[] buildLPS(String pattern){
        int n = pattern.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;  // b/c for single string prefix and suffix is 0
        while(i < n){
            if(pattern.charAt(i) == pattern.charAt(len)){   // matches
                // if matches then increase both i and len
                len++;
                lps[i] = len;
                i++;
            }
            else{   // mismatch
                if(len != 0) len = lps[len-1];  // go for a smaller prefix
                else{
                    lps[i] = 0;// means no prefix and suffix for that particular substring
                    i++;   // but we don't stop i from moving
                }
            }
        }
        return lps;
    }
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // Step-1: Bulid lps array
        int[] lps = buildLPS(s);
        // Step-2: find pattern length
        int patternLen = n - lps[n-1];
        // Step-3: now check true
        return lps[n-1] > 0 && n % patternLen == 0;
    }
}