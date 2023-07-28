/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
/*

class Solution {  
    public void generate(List<String> list, StringBuilder sb, int open, int closed, Integer n) {
        
        if (open + closed == n.intValue()) {
            if (open == closed) 
                list.add(sb.toString());
            return;
        }
        
        if (closed > open) 
            return;
        
        sb.append('(');
        generate(list, sb, open+1, closed, n);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        generate(list, sb, open, closed+1, n);
        sb.deleteCharAt(sb.length()-1);
        return;
    }
    
    
    public List<String> generateParenthesis(int n) {
        
        List<String> list = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        sb.append('(');
        
        generate(list, sb, 1, 0, new Integer(n*2));
        
        return list;
    }
}
