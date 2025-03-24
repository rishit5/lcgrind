class BoundedBlockingQueue {

    LinkedList<Integer> list;
    Integer capacity;

    public BoundedBlockingQueue(int capacity) {
        this.list = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public synchronized void enqueue(int element) throws InterruptedException {
        while (this.list.size() == this.capacity) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        this.list.addLast(element);
        notify();
        return;
    }
    
    public synchronized int dequeue() throws InterruptedException {
        while (this.list.size() == 0) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        Integer result = this.list.removeFirst();
        notify();
        return result;
    }
    
    public int size() {
        return this.list.size();
    }
}