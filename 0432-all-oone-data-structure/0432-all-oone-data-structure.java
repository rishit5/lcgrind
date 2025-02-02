class AllOne {

    class Node {
        int freq;
        Set<String> stringSet = new HashSet<>();
        Node prev = null;
        Node next = null;
    }

    private Node head;
    private Node tail;

    private Map<String, Integer> countMap;
    private Map<Integer, Node> freqMap;

    public AllOne() {
        this.head = new Node();
        this.tail = new Node();
        this.head.freq = Integer.MIN_VALUE;
        this.tail.freq = Integer.MAX_VALUE;
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.countMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    private void removeFreq(String key, int freq) {
        if (freq == 0) {
            return;
        }
        Node node = this.freqMap.get(freq);
        node.stringSet.remove(key);
        if (node.stringSet.isEmpty()) {
            this.freqMap.remove(freq);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private void addFreq(String key, int freq) {
        if (freq == 0) {
            return;
        }
        if (this.freqMap.containsKey(freq)) {
            this.freqMap.get(freq).stringSet.add(key);
        } else {
            Node n = new Node();
            n.freq = freq;
            n.stringSet.add(key);
            Node headCopy = head;
            while (!(headCopy.freq < freq && headCopy.next.freq > freq)) {
                headCopy = headCopy.next;
            }
            Node next = headCopy.next;
            headCopy.next = n;
            n.prev = headCopy;
            next.prev = n;
            n.next = next;
            this.freqMap.put(freq, n);
        }
    }
    
    public void inc(String key) {
        this.countMap.putIfAbsent(key, 0);
        this.removeFreq(key, this.countMap.get(key));
        this.countMap.put(key, this.countMap.get(key) + 1);
        this.addFreq(key, this.countMap.get(key));
    }
    
    public void dec(String key) {
        this.countMap.put(key, this.countMap.get(key) - 1);
        this.removeFreq(key, this.countMap.get(key) + 1);
        this.addFreq(key, this.countMap.get(key));
    }
    
    public String getMaxKey() {
        if (this.tail.prev == this.head) {
            return "";
        } else {
            return this.tail.prev.stringSet.iterator().next();
        }
    }
    
    public String getMinKey() {
        if (this.head.next == this.tail) {
            return "";
        } else {
            return this.head.next.stringSet.iterator().next();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */