/**
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.
*/

class Solution {
    
    
    class CountHelper {
        
        private int thousands;
        private int hundreds;
        private int tens;
        private int ones;
        
        public CountHelper() {
            this.thousands = 0;
            this.hundreds = 0;
            this.tens = 0;
            this.ones = 0;
        }
        
        public increment() {
            ones++;
            
            if (ones == 10) {
                ones = 1;
                tens++;
                if (tens == 10) {
                    tens = 0;
                    hundreds++;
                    if (hundreds == 10) {
                        hundreds = 0;
                        thousands++;
                    }
                }
            }
        }
        
        
        
    }
    
    
    public int compress(char[] chars) {
        
        if (chars.length == 1) 
            return 1;
        
        int count = 1;
        int j = -1;
        char cur = chars[0];
        
        int thousands = 0;
        int hundreds = 0;
        int tens = 0;
        
        for (int i = 1; i < chars.length; i++) {
            
            if (chars[i] == cur) {
                count++;
                
                if (count == 10) {
                    count = 1;
                    tens++;
                    if (tens == 10) {
                        tens = 0;
                        hundreds++;
                        if (hundreds == 10) {
                            hundreds = 0;
                            thousands++;
                        }
                    }
                }
            }
                
            else {
                chars[++j] = cur;
                if (count > 1) {
                    
                    if (thousands > 0) {
                        
                    }
                        chars[++j] = (char)(thousands+48);
                    if (hundreds > 0) {
                        
                    }
                        chars[++j] = (char)(hundreds+48);
                    if (tens > 0) {
                        
                    }
                        chars[++j] = (char)(tens+48);
                    chars[++j] = (char)(count+48);
                    
                    thousands = 0;
                    hundreds = 0;
                    tens = 0;                   
                    
                    /**
                    char[] digits = String.valueOf(count).toCharArray();
                    
                    for (int z = 0; z < digits.length; z++)
                        chars[++j] = digits[z]; 
                    */
                }
                count = 1;
                cur = chars[i];          
            }
        }
        
        chars[++j] = cur;
        
        if (count > 1) {
            
            if (thousands > 0)
                    chars[++j] = (char)(thousands+48);
                if (hundreds > 0)
                    chars[++j] = (char)(hundreds+48);
                    if (tens > 0) 
                        chars[++j] = (char)(tens+48);
            chars[++j] = (char)(count+48);
      
            /**
            char[] digits = String.valueOf(count).toCharArray();
                    
            for (int z = 0; z < digits.length; z++)
                chars[++j] = digits[z];
            */
        }

        return j+1;        
    }
}
