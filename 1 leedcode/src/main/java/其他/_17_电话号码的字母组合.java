package 其他;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 17 电话号码的字母组合【中等】
 *
 * @author tning
 * @create 2020/08/25
 */
public class _17_电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        String[] letter_map = {
                " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> res = new LinkedList<String>();
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letters = letter_map[digits.charAt(i) - '0'];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String tmp = res.remove(0);
                for (int k = 0; k < letters.length(); k++) {
                    res.add(tmp + letters.charAt(k));
                }
            }
        }

        return res;
    }
}
