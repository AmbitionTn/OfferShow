package 贪心;

/**
 * @author taoning
 * @create 2020/11/26
 */
public class _1578_避免重复字母的最小删除成本 {
    public int minCost(String s, int[] cost) {
        // 长度小于0无需计算
        if (s.length() <= 1){
            return 0;
        }
        int ans = 0, i = 0, j = 1;
        while (j < s.length()){
            if (s.charAt(i) != s.charAt(j)){
                i = j;
                j ++;
            }else{
                if (cost[i] <= cost[j]){
                    ans += cost[i];
                    i = j;
                    j ++;
                }else{
                    ans += cost[j];
                    j ++;
                }
            }
        }
        return ans;
    }
}
