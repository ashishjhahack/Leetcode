class Solution {
    int maxLen = 0, st = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i<n; i++){
            // odd length palindrome
            expand(s, i, i);
            // even length palindrome
            expand(s, i, i+1);
        }
        return s.substring(st, st+maxLen);
    }
    public void expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            int len = right - left + 1;
            if(len > maxLen){
                maxLen = len;
                st = left;
            }
            left--;
            right++;
        }
    }
}