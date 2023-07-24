/**
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length()][text2.length()];

        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }

        for (int r = 1; r < text1.length(); r++) {
            if (text1.charAt(r) == text2.charAt(0))
                dp[r][0] = 1;
            else 
                dp[r][0] = dp[r-1][0];
        }

        for (int c = 1; c < text2.length(); c++) {
            if (text1.charAt(0) == text2.charAt(c))
                dp[0][c] = 1;
            else 
                dp[0][c] = dp[0][c-1];
        }

        for (int r = 1; r < text1.length(); r++) {
            for (int c = 1; c < text2.length(); c++) {

                if (text1.charAt(r) == text2.charAt(c)) {
                    dp[r][c] = 1 + dp[r-1][c-1];
                } else {
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }

        return dp[text1.length()-1][text2.length()-1];

    }
}
