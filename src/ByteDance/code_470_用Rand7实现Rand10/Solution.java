package ByteDance.code_470_用Rand7实现Rand10;

import java.util.Random;

class SolBase {
    private Random random = new Random();

    public int rand7() {
        return random.nextInt(7) + 1;
    }
}

/**
 * completion time = 2023.10.29
 */
class Solution extends SolBase {
    public int rand10() {
        // 7 * 7可以生成49个数，我们抛弃后面9个，只取前面40个，那么每个 1 ~ 10出现的概率是相等的
        // 画一个 7 * 7的表格，然后从左往右的顺序遍历数字
        while (true) {
            int row = rand7();
            int col = rand7();
            int num = (row - 1) * 7 + col;
            if (num <= 40) {
                return num % 10 + 1;
            }
        }
    }
}
