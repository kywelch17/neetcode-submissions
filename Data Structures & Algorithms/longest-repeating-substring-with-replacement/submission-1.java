class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int result = 0;

        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(rightChar));

            while (right - left + 1 - maxFreq > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
