/**
You are given a 0-indexed string word, consisting of lowercase English letters. You need to select one index and remove the letter at that index from word so that the frequency of every letter present in word is equal.

Return true if it is possible to remove one letter so that the frequency of all letters in word are equal, and false otherwise.

Note:

The frequency of a letter x is the number of times it occurs in the string.
You must remove exactly one letter and cannot chose to do nothing.
*/
class Solution {
    public boolean equalFrequency(String word) {
        
        int[] freq = new int[26];
        Arrays.fill(freq, 0);

        for (int i = 0; i < word.length(); i++) {
            freq[ (int) word.charAt(i) - 97] ++;
        }

        Arrays.sort(freq);

        


        boolean ascTrue = true, descTrue = true;

        if (freq[25] == (freq[24] + 1)) {

            int equalFreqVal = freq[24];
            int i = 23;

            while (i >= 0 && freq[i] != 0) {
                if (freq[i] != equalFreqVal) 
                    descTrue = false;
                i--;
            }

            if (descTrue) 
                return true;
        }


        int startIndex = 0;
        while (freq[startIndex] == 0)
            startIndex++;
        
        if (startIndex == 25) {
            return true;
        }


        if (freq[startIndex] == 1) {
            int equalFreqVal = freq[startIndex+1];
            int i = startIndex+2;

            while (i < 26) {
                if (freq[i] != equalFreqVal)
                    return false;
                i++;
            }
            return true;
        }

        return false;
    }
}
