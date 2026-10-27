class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCounter = new int[256];

        for (char c : s.toCharArray()) {
            charCounter[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCounter[c - 'a']--;
        }

        for (int n : charCounter) {
            if (n != 0) return false;
        }

        return true;
    }
}
