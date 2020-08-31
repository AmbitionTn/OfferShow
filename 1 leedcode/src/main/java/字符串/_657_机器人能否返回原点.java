package 字符串;

/**
 * 657 机器人能否返回原点
 *
 * @author tning
 * @URL：https://leetcode-cn.com/problems/robot-return-to-origin/
 * @create 2020/08/28
 */
public class _657_机器人能否返回原点 {
    /**
     * 解析：使用level记录水平移动位置，deap记录竖直方向移动位置
     *
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int level = 0;
        int deap = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R':
                    level--;
                    break;
                case 'L':
                    level++;
                    break;
                case 'U':
                    deap++;
                    break;
                case 'D':
                    deap--;
                    break;
            }
        }
        return level == 0 && deap == 0;
    }
}
