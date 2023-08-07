/**
This one is full code spaghetti - I did it a long time ago and there are almost 1100 test cases to pass, thus the very low acceptance rate.
I think I will redo it at some point for fun, to see how much cleaner I can make it.

Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
*/

class Solution {
    
    public int myAtoi(String s) {
        
        if (s.equals(""))
            return 0;
        
        int sum = 0;
        boolean negative = false;;
        
        int cur = 0;
        
        //before integer
        for (int i = 0; i < s.length(); i++) {
            
            cur = (int)s.charAt(i);
            
            //whitespace
            if (cur == 32)
                continue;
            
            //negative and start of integer
            if (cur == 45) {
                
                //handle just "-" or "    -"
                if (i == s.length()-1)
                    return 0;
                
                negative = true;
                s = s.substring(i+1);
                break;
            }
            
            //positive and start of integer
            if (cur == 43) {
                
                //handle just "+" or "    +"
                if (i == s.length()-1)
                    return 0;
                
                s = s.substring(i+1);
                break;
            }
                
            
            //start of integer
            if (cur > 47 && cur < 58) {
                
                s = s.substring(i);
                break;
            }
            
            return 0;
                
        }
        
        //pass over leading zeros
        int j = 0;
        cur = (int)s.charAt(j);
        while (cur == 48 && j < s.length()) {
            cur = (int)s.charAt(j);
            if (cur !=48)
                break;
            j++;
        }
        s = s.substring(j);
        
        
        //finding end of integer
        for (int i = 0; i < s.length(); i++) {
            
            cur = (int)s.charAt(i);
            
            if (cur > 47 && cur < 58)
                continue;
            else
                s = s.substring(0, i);
        }
        
        //Handle numbers too large for mult to resolve correctly
        if (s.length() == 10 && (int)s.charAt(0) > 50)
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        //s now is just the integer
        int mult = (int) Math.pow(10, s.length()-1);
        int digit;
        
        for (int i = 0; i < s.length(); i++) {
            
            digit = (int)s.charAt(i) - 48;
                       
            //positive
            if (!negative) {
                if (Integer.MAX_VALUE - sum < mult*digit)
                    return Integer.MAX_VALUE;
                
            //negative
            } else {
                if ((Integer.MIN_VALUE + sum) > (-1)*mult*digit)
                    return Integer.MIN_VALUE;
            }
            
            
            sum += mult * digit ;
            mult /= 10;

        }
        
        return negative ? sum*(-1) : sum;
    }
    
}


