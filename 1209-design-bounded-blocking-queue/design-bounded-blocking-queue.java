class BoundedBlockingQueue {

    Queue<Integer> queue = new LinkedList<>();
    Integer capacity;
    ReentrantLock rl;
    Condition condition;

    public BoundedBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
        this.rl = new ReentrantLock();
        this.condition = this.rl.newCondition();
    }
    
    public void enqueue(int element) throws InterruptedException {
        this.rl.lock();
        while (queue.size() == this.capacity) {
            this.condition.await();
        }
        this.queue.offer(element);
        this.condition.signal();
        this.rl.unlock();
    }
    
    public int dequeue() throws InterruptedException {
        this.rl.lock();
        while (queue.size() == 0) {
            this.condition.await();
        }
        Integer val = this.queue.poll();
        this.condition.signal();
        this.rl.unlock();
        return val;
    }
    
    public int size() {
        return this.queue.size();
    }
}