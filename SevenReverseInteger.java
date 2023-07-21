/**
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */

class Solution {
    public int reverse(int x) {
        
        //Handle single digits
        if (x%10 == x)
            return x;
        
        if (x==-2147483648)
            return 0;
        
        boolean negative = x < 0 ? true : false;
        int cur = Math.abs(x);
        
        int sum = 0;
        int mod = 1000000000; 
        int mult = 1;
        
        while (cur % mod == cur) {
            mod/=10;
        }
        
        int t = 0;
        
        //while (mult < Math.abs(x)) {
        while (mod > 0) {
            t = cur/mod;
            cur-=t*mod;
            
            
            //if (sum + (t*mult) > Integer.MAX_VALUE) 
            if ((Integer.MAX_VALUE - sum) < (t*mult))
                return 0;
            if (mult == 1000000000 & t > 2)
                return 0;
            
            //System.out.println("Adding " + t*mult + " in the " + mult + " place.");
            
            sum += t*mult;         
            
            mod/=10;
            mult*=10;
        }
        
        return negative ? sum*(-1) : sum;
        
    }
}
