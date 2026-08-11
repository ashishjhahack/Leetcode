class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        // 🔹 Step 1: Store frequency of t
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        int count = t.length(); // total chars needed

        // 🔹 Step 2: Expand window
        for (int end = 0; end < s.length(); end++) {

            char ch = s.charAt(end);

            // If char is needed
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                // If still needed → reduce count
                if (map.get(ch) >= 0) {
                    count--;
                }
            }

            // Step 3: Shrink when valid
            while (count == 0) {

                // Update minimum window
                int len = end - start + 1;
                if (len < minLen) {
                    minLen = len;
                    startIndex = start;
                }

                char leftChar = s.charAt(start);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    // If this char becomes needed again
                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }

                start++; // shrink window
            }
        }

        return minLen == Integer.MAX_VALUE 
            ? "" 
            : s.substring(startIndex, startIndex + minLen);
    }
}