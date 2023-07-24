/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/

class Solution {

    public void traverse(List<String> list, String[] dict, StringBuilder bld, String digits, int cur) {

        if (cur == digits.length()) {
            list.add(bld.toString());
            return;
        }

        System.out.println(cur);
        System.out.println(digits.charAt(cur));

        for (int i = 0; i < dict[digits.charAt(cur)-48].length(); i++) {
            bld.append(dict[digits.charAt(cur)-48].charAt(i));
            traverse(list, dict, bld, digits, cur+1);
            bld.deleteCharAt(bld.length()-1);
        }

    }


    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return new ArrayList<String>();

        List<String> list = new ArrayList<>();
        String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        traverse(list, dict, new StringBuilder(), digits, 0);

        return list;
    }
}
