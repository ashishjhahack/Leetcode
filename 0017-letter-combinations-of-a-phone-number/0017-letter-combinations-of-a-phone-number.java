class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        backtrack(0, digits, res, new StringBuilder(""), map);
        return res;
    }
    private void backtrack(int index, String digits, List<String> res, StringBuilder curr, HashMap<Character, String> map){
        // Base case
        if(index == digits.length()){
            res.add(curr.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);   // decode actual letter

        for(int i=0; i<letters.length(); i++){
            curr.append(letters.charAt(i));   // add letter
            backtrack(index+1, digits, res, curr, map);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}