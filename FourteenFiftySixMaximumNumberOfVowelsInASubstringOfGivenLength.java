/**
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
*/

class Solution {
    public int maxVowels(String s, int k) {

        Set<Character> charSet = Set.of('a', 'e', 'i', 'o', 'u');
        
        int startIndex = 0;
        int endIndex = k;

        int maxCount = 0;
        int curCount = 0;

        for (int j = 0;j < k; j++) {
            if (charSet.contains(s.charAt(j))) {
                curCount++;
            }
        }

        maxCount = curCount;
        
        int i = 0;
        while (i+k < s.length()) {
            if (charSet.contains(s.charAt(i))) {
                curCount--;
            }

            if (charSet.contains(s.charAt(i+k))) {
                curCount++;
            }
            i++;

            maxCount = Math.max(maxCount, curCount);
        }

        return maxCount;   
    }
}
