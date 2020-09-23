package 字符串;

/**
 * @author taoning
 * @create 2020/9/22
 */
public class KMP {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (haystack.length() != 0 || needle.length() != 0){
            return -1;
        }
        int M = needle.length();
        int N = haystack.length();
        int dp[][] = new int[M][256];
        kmp(needle, dp, M);
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[i][haystack.charAt(i)];
            if (j == M) return i - M + 1;
        }
        return -1;
    }

    /**
     * 字符串匹配算法 KMP
     *
     * @param needle
     * @param dp
     */
    public void kmp(String needle, int dp[][], int M) {
        // 0号状态遇到第一个字符会进入到1号状态
        dp[0][needle.charAt(0)] = 1;
        // 定义重启状态
        int x = 0;
        for (int i = 1; i < M; i++) {
            for (int c = 0; c < 256; c++) {
                if (c == needle.charAt(i)) {
                    dp[i][c] = i + 1;
                } else {
                    dp[i][c] = dp[x][c];
                }
            }
            x = dp[x][needle.charAt(i)];
        }
    }
}
