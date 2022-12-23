package TowardsOffer2_Special.day_10_哈希表.code_030_插入_删除和随机访问都是O1的容器;

import java.util.*;

/**
 * completion time = 2022.10.22
 */
public class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        //这种方法不需要管最后一个元素是否就是要被删除的元素
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        //先将要删的位置的元素设置为最后一个元素
        nums.set(index, last);
        indices.put(last, index);
        //最后删除最后一个元素
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }


    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(3);
        randomizedSet.remove(3);
        randomizedSet.remove(0);
        randomizedSet.insert(3);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(0);
        System.out.println(randomizedSet.getRandom());
    }
}
