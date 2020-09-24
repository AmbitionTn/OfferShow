package 剑指Offer;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 *
 * @author taoning
 * @create 2020/09/23
 */
public class _剑指Offer17打印从1到最大的n位数 {

    private StringBuilder res;
    int n;
    char []num, loop = {'0','1','2','3','4','5','6','7','8','9'};
    /**
     * 使用dfs解全排列问题
     *
     * @param n
     * @return
     */
    public String printNumbers(int n) {
        n = this.n;
        res = new StringBuilder();
        num = new char[n];
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();

    }

    private void dfs(int x){

    }
}
