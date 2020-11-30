package 笔试题;

import java.util.HashSet;

/**
 * @author taoning
 * @create 2020/11/30
 */
public class Main {
    public static int GetLengthStr(String str) {
        int reslen = 0;
        int strlen = str.length();
        for (int i = 0; i < strlen; i++) {
            for (int j = i + 1; j < strlen; j++) {
                HashSet<String> hashSet = new HashSet<String>();
                boolean isExists = false;
                for (int z = i; z < j; z++) {
                    String strChild = str.substring(z, 1);
                    if (hashSet.contains(strChild)) {
                        isExists = true;
                        break;
                    } else {
                        hashSet.add(strChild);
                    }
                }
                if (!isExists) {
                    reslen = Math.max(reslen, j - i);
                }

            }
        }
        return reslen;
    }

    public static void main(String[] args) {
        System.out.println(GetLengthStr("abcabc"));
        System.out.println(GetLengthStr("xxxxx"));
        System.out.println(GetLengthStr("sllenl"));
    }
}
