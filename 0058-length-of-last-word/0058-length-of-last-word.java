class Solution {
    public int lengthOfLastWord(String s) {
        // My Approach :- T.C & S.C :- O(n)
        s = s.trim();
        int n = s.length();
        int count = 0;
        for(int i = n-1; i>=0; i--){
            int ch = s.charAt(i);
            if(ch == ' ') break;
            count++;
        }
        return count;
    }
}