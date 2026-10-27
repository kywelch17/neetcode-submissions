class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> resultMap = new HashMap<>();

       for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            // resultMap.putIfAbsent(key, new ArrayList<>());
            // resultMap.get(key).add(s);
            if (!resultMap.containsKey(key)) {
                resultMap.put(key, new ArrayList<>());
            }
            resultMap.get(key).add(s);
        }

        return new ArrayList<>(resultMap.values());
    }
}
