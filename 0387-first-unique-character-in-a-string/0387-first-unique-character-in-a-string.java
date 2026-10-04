class Solution {
    public int firstUniqChar(String s) {
        int[] letterCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letterCounts[s.charAt(i) - 'a']++; 
        }

        for (int i = 0; i < s.length(); i++) {
            if (letterCounts[s.charAt(i) - 'a'] == 1) {
                return i; 
            }
        }

        return -1;
    }
}