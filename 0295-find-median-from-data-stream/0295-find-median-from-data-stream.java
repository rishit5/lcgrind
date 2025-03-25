class MedianFinder {

    PriorityQueue<Integer> fH;
    PriorityQueue<Integer> sH;

    public MedianFinder() {
        fH = new PriorityQueue<>((a, b) -> b - a);
        sH = new PriorityQueue<>((a, b) -> a - b);
    }

    private void add(PriorityQueue<Integer> fH, PriorityQueue<Integer> sH, Integer num) {
        if (fH.size() > 0 && sH.size() > 0) {
            int fHLargest  = fH.peek();
            int sHSmallest = sH.peek();
            if (num < fHLargest) {
                fH.add(num);
            } else {
                sH.add(num);
            }
        } else if (fH.size() == 0 && sH.size() != 0) {
            int sHSmallest = sH.peek();
            if (num < sHSmallest) {
                sH.add(num);
            } else {
                fH.add(num);
            }
        } else if (sH.size() == 0 && fH.size() != 0) {
            int fHLargest  = fH.peek();
            if (num > fHLargest) {
                sH.add(num);
            } else {
                fH.add(num);
            }
        } else {
            fH.add(num);
        }
    }

    private void rebalance(PriorityQueue<Integer> fH, PriorityQueue<Integer> sH) {
        if (Math.abs(fH.size() - sH.size()) <= 1) {
            return;
        } else {
            int fHSize = fH.size();
            int sHSize = sH.size();
            if (fHSize > sHSize) {
                while (Math.abs(fH.size() - sH.size()) > 1) {
                    sH.add(fH.poll());
                }
            } else {
                while (Math.abs(fH.size() - sH.size()) > 1) {
                    fH.add(sH.poll());
                }
            }
        }
    }
    
    public void addNum(int num) {
        this.add(fH, sH, num);
        this.rebalance(fH, sH);
    }
    
    public double findMedian() {
        if (fH.size() == sH.size()) {
            return ((double) sH.peek() + fH.peek()) / 2d;
        } else if (fH.size() > sH.size()) {
            return fH.peek();
        } else {
            return sH.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */