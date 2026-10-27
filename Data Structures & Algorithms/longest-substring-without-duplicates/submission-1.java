class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            while (!seen.add(rightChar)) {
                char leftChar = s.charAt(left);
                seen.remove(leftChar);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
