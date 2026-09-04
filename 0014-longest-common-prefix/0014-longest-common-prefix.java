class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        if(strs == null || strs.length == 0) return "";

        // sort the string
        Arrays.sort(strs);

        // First and last string
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        for(int i = 0; i<Math.min(first.length, last.length); i++){
            if(first[i] != last[i]){
                break;
            }
            ans.append(first[i]);
        }
        return ans.toString();
    }
}