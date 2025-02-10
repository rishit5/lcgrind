class BoundedBlockingQueue {

    private LinkedList<Integer> queue;
    private Integer size;
    private ReentrantLock rl = new ReentrantLock();
    private Condition full = rl.newCondition();
    private Condition empty = rl.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.size = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        rl.lock();
        while (queue.size() == this.size) {
            this.full.await();
        }
        queue.addLast(element);
        this.empty.signal();
        rl.unlock();
    }
    
    public int dequeue() throws InterruptedException {
        rl.lock();
        if (queue.size() == 0) {
            this.empty.await();
        }
        Integer val = queue.removeFirst();
        this.full.signal();
        rl.unlock();
        return val;
    }
    
    public int size() {
        return queue.size();
    }
}