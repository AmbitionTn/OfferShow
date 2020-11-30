package 二叉树;

/**
 * @author taoning
 * @create 2020/10/29
 */
public class _129_求根到叶子节点数字之和 {
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return ans;
    }

    /**
     * 递归计算
     *
     * @param root
     * @param sum
     * @return
     */
    public void sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = cal(sum, root.val);
        if (root.left == null && root.right == null){
            System.out.println(sum);
            ans += sum;
        }
        sumNumbers(root.left, sum);
        sumNumbers(root.right, sum);
    }

    /**
     * 计算节点的值
     *
     * @param sum
     * @param num
     * @return
     */
    private int cal(int sum, int num) {
        sum *= 10;
        sum += num;
        return sum;
    }
}