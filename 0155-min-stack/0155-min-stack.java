class MinStack {
    Stack<Long> st;
    long minEle;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            minEle = value;
            st.push((long) value);
        }
        else{    // if stack is not empty
            if(value < minEle){   // if get the minEle 
                st.push(2L*value - minEle);  // push the encoded value
                minEle = value;   // then update the minEle
            }
            else st.push((long) value);
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long top = st.pop();
        if(top < minEle){  // if top is encoded value 
            minEle = 2*minEle-top;   // then decode it
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;

        long top = st.peek();
        return st.peek() < minEle ? (int) minEle : (int) top;
    }
    
    public int getMin() {
        return st.isEmpty() ? -1 : (int) minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */