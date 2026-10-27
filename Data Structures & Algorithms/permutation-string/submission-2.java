class Solution {
        public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        int left = 0;

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        for (int right = 0; right < s2.length(); right++) {
            char rightChar = s2.charAt(right);
            windowCount[rightChar - 'a']++;

            if (right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);
                windowCount[leftChar - 'a']--;
                left++;
            }

            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }
}
