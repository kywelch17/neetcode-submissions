class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] countT = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            countT[c]++;
        }

        // Count how many unique characters are in t
        int need = 0;
        for (int count : countT) {
            if (count > 0) {
                need++;
            }
        }

        int have = 0;
        int minLength = Integer.MAX_VALUE;
        int[] res = { -1, -1 };
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            window[rightChar]++;

            if (countT[rightChar] > 0 && window[rightChar] == countT[rightChar]) {
                have++;
            }

            while (have == need) {
                if ((right - left + 1) < minLength) {
                    minLength = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                if (countT[leftChar] > 0 && window[leftChar] < countT[leftChar]) {
                    have--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
