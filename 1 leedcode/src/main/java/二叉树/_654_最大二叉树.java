package 二叉树;

/**
 * @author taoning
 * @create 2020/10/21
 */
public class _654_最大二叉树 {
    /**
     * 最简单的题目：直接二叉树的递归构建就可以
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right || left < 0 || right > nums.length) {
            return null;
        }
        int max = nums[left];
        int index = left;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums, left, index - 1);
        root.right = buildTree(nums, index + 1, right);
        return root;
    }
}