class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();

        int maxLength = 0;
        int left = 0;       // Left pointer of a sliding window

        for(int right = 0; right<s.length(); right++){
            while(st.contains(s.charAt(right))){
                st.remove(s.charAt(left));
                left++;
            }
            st.add(s.charAt(right));

            maxLength = Math.max(maxLength, right-left+1);

        }
        return maxLength;
    }
}