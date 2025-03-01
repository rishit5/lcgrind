class MovingAverage {

    private double runningSum;
    private int size;
    private LinkedList<Integer> list;


    public MovingAverage(int size) {
        this.size = size;
        this.list = new LinkedList<>();
    }
    
    public double next(int val) {
        this.list.addLast(val);
        this.runningSum += val;
        if (this.list.size() <= this.size) {
            return this.runningSum / this.list.size();
        } else {
            this.runningSum -= this.list.get(this.list.size() - this.size - 1);
            return this.runningSum / this.size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */