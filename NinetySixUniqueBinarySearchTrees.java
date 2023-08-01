/**
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
*/

class Solution {
    public int numTrees(int n) {
        
        int[] res = new int[n+1];
        
        if (n==1) 
            return 1;
        
        res[0] = 1;
        res[1] = 1;
        
        int rSum = 0;
        
        for (int i=2; i<res.length; i++) {
            for (int j=0; j<i; j++)
                rSum += res[j] * res[i-j-1];
            res[i] = rSum;
            rSum = 0;
        }
        
        
        
        return res[n];
        
    }
}
