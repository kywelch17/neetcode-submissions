class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] seen = new boolean[128];
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            while (seen[rightChar]) {
                char leftChar = s.charAt(left);
                seen[leftChar] = false;
                left++;
            }

            seen[rightChar] = true;
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
