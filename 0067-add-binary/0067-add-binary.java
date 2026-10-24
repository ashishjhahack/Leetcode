class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        
        // a = "1011", b = "1101"
        int i = a.length() - 1;    // 3
        int j = b.length() - 1;    // 3
        int carry = 0;
        
        while(i >= 0 || j >= 0 || carry == 1){
            int sum = carry;   // 0
            
            if(i >= 0){
                sum += a.charAt(i) - '0';   // sum = 1
                i--;   // i=2
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';   // sum = 1+1 = 2
                j--;   // j=2
            }
            ans.append(sum % 2);    // 2%2 = 0, then append this 0
            carry = sum/2;     // 2/2 = 1, then carry = 1
        }
        // return ans.reverse().toString();

        // final ans = "00011"

        ans.reverse();
        
        // remove the leading zeroes(GFG)
        int index = 0;
        while(index < ans.length() -1 && ans.charAt(index) == '0'){
            index++;
        }
        
        return ans.substring(index);
    }
}