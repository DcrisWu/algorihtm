package 灵茶2022年周赛总结.下半年.模拟.code_2349_设计数字容器系统;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * completion time = 2023.5.14
 */
class NumberContainers {

    private Map<Integer, Integer> idxNum;
    private Map<Integer, TreeSet<Integer>> numIdxSet;

    public NumberContainers() {
        this.idxNum = new HashMap<>();
        this.numIdxSet = new HashMap<>();
    }

    public void change(int index, int number) {
        if (idxNum.containsKey(index)) {
            int preNum = idxNum.get(index);
            // 不可以用PriorityQueue，因为PriorityQueue的删除操作是O(n), 而TreeSet的删除操作是O(1)
            numIdxSet.get(preNum).remove(index);
        }
        idxNum.put(index, number);
        numIdxSet.putIfAbsent(number, new TreeSet<>());
        numIdxSet.get(number).add(index);
    }

    public int find(int number) {
        if (!numIdxSet.containsKey(number) || numIdxSet.get(number).isEmpty()){
            return -1;
        }
        return numIdxSet.get(number).first();
    }
}
