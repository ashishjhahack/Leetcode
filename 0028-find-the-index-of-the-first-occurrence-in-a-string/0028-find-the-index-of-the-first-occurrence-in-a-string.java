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
    public int strStr(String haystack, String needle) {   // use kmp approach
        if(needle.length() == 0) return 0;

        // step-1:- Build lps array
        int[] lps = buildLPS(needle);

        int i = 0;  // pointer for haystack
        int j = 0;  // pointer for needle

        while(i < haystack.length()){
            // char match
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                // complete pattern found
                if(j == needle.length()){
                    return i-j;   // or i-m(needle.length)
                }
            }
            else{  // mismatch
            // don't move i
                if(j != 0){
                    j = lps[j-1];
                }
                else i++;
            }
        }
        return -1;
    }
}