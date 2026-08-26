class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String components[] = path.split("/"); // components = ["", "home", "", "foo"]
        for(String component: components){
            // if get "" or "." then ignore this
            if(component.equals("") || component.equals(".")) continue;
            // move back to prev directory if get ".."
            else if(component.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            // push current component to stack
            else st.push(component);
        }
        // we add all stack char into ans(string) one by one
        StringBuilder ans = new StringBuilder();
        for(String component: st){
            ans.append("/").append(component);
        }
        if(ans.length() == 0) return "/";
        return ans.toString();
    }
}