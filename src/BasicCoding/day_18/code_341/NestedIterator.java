package BasicCoding.day_18.code_341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * completion time = 2022.10.11
 */
public class NestedIterator implements Iterator<Integer> {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private LinkedList<Integer> ans;

    public NestedIterator(List<NestedInteger> nestedList) {
        ans = new LinkedList<>();
        DFS(nestedList);
    }

    @Override
    public boolean hasNext() {
        return !ans.isEmpty();
    }

    @Override
    public Integer next() {
        return ans.removeFirst();
    }

    public void DFS(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                ans.addLast(n.getInteger());
            } else {
                DFS(n.getList());
            }
        }
    }
}
