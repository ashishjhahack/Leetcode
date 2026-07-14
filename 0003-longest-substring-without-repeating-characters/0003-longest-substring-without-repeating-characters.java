class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int windowSt = 0;
        int windowEnd = 0;
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        while(windowEnd < n){
            char ch = s.charAt(windowEnd);
            if(set.contains(ch)){
                // Shrinking
                while(windowSt < windowEnd && set.contains(ch)){
                    set.remove(s.charAt(windowSt));
                    windowSt++;
                }
            }
            set.add(ch);
            len = windowEnd-windowSt+1;
            maxLen = Math.max(maxLen, len);
            windowEnd++;
        }
        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
    }
}