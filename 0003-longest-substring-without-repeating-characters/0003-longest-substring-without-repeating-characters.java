import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in the map and its index is inside our current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                // Move the left pointer past the previous occurrence of the character
                left = charIndexMap.get(currentChar) + 1;
            }
            
            // Update the character's latest index and calculate the max length
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}