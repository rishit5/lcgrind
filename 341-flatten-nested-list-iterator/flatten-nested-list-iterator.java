/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {

    private Deque<List<NestedInteger>> stacklist;
    private Deque<Integer> indexlist;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stacklist = new ArrayDeque<>();
        this.indexlist = new ArrayDeque<>();
        this.stacklist.addFirst(nestedList);
        this.indexlist.addFirst(0);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int top = this.indexlist.pollFirst();
        this.indexlist.addFirst(top + 1);
        return this.stacklist.peekFirst().get(top).getInteger();
    }

    @Override
    public boolean hasNext() {
        makeTopAnInteger();
        return !indexlist.isEmpty();
    }

    private void makeTopAnInteger() {
        while (!indexlist.isEmpty()) {
            if (indexlist.peekFirst() >= stacklist.peekFirst().size()) {
                indexlist.pollFirst();
                stacklist.pollFirst();
                continue;
            }

            if (stacklist.peekFirst().get(indexlist.peekFirst()).isInteger()) {
                break;
            }

            stacklist.addFirst(stacklist.peekFirst().get(indexlist.peekFirst()).getList());
            indexlist.addFirst(indexlist.pollFirst() + 1);
            indexlist.addFirst(0);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */