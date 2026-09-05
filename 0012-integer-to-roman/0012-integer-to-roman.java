class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder ans = new StringBuilder();
        
        for(int i=0; i<values.length; i++){
            // use this b/c there will multiple "MMM"
            while(num >= values[i]){ // Eg. num = 3749. So, 3000 > 1000
                num -= values[i];   // num = 2749
                ans.append(symbol[i]);   // append "M (1000)"
            }   // 2749 > 1000 then again add
        }
        return ans.toString();
    }
}