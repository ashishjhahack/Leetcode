class Solution {
    public int evalRPN(String[] tokens) {
        // RPN :-  eg ["10", "2", "+"]  => 10+2 = 12
        // Basic Approach: 
        // 1. if find operand then push it into stack
        // 2. else find operator then perform the operation and then push the result into stack
        Stack<Integer> st = new Stack<>();
        for(String token: tokens){
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){    // if number(operand) then push it into stack
                st.push(Integer.parseInt(token));
            }
            else{   // if find operator
                int b = st.pop();   // first pop the right operand
                int a = st.pop();   // then right
                int res = 0;
                if(token.equals("+")) res = a+b;
                else if(token.equals("-")) res = a-b;
                else if(token.equals("*")) res = a*b;
                else if(token.equals("/")) res = a/b;

                // push the res back into stack
                st.push(res);
            }
        }
        return st.pop();
    }
}