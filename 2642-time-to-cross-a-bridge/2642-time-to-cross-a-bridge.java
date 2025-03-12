class Solution {

    class Worker {
        
        int right;
        int pick;
        int left;
        int put;
        int index;
        
        public Worker(int right, int pick, int left, int put, int index) {
            this.right = right;
            this.pick = pick;
            this.left = left;
            this.put = put;
            this.index = index;
        }

    }

    class Event {
        
        int time;
        char nextSide;
        Worker worker;

        public Event(int time, char nextSide, Worker worker) {
            this.time = time;
            this.nextSide = nextSide;
            this.worker = worker;
        }

    }

    public int findCrossingTime(int n, int k, int[][] time) {
        PriorityQueue<Worker> leftBank = new PriorityQueue<>((a, b) -> {
            int aEff = a.right + a.left;
            int bEff = b.right + b.left;
            if (aEff == bEff) {
                return b.index - a.index;
            } else {
                return bEff - aEff;
            }
        });

        PriorityQueue<Worker> rightBank = new PriorityQueue<>((a, b) -> {
            int aEff = a.right + a.left;
            int bEff = b.right + b.left;
            if (aEff == bEff) {
                return b.index - a.index;
            } else {
                return bEff - aEff;
            }
        });

        for (int i = 0; i < time.length; i++) {
            leftBank.add(new Worker(time[i][0], time[i][1], time[i][2], time[i][3], i));
        }

        PriorityQueue<Event> events = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));
        int currentTime = 0;
        int workersOnRight = 0;
        int workersOnLeft  = k;
        int boxesRemaining = n;
        int maxTime = -1;

        while (boxesRemaining > 0) {
            while (!events.isEmpty() && events.peek().time <= currentTime) {
                Event event = events.poll();
                if (event.nextSide == 'L') {
                    leftBank.offer(event.worker);
                } else {
                    rightBank.offer(event.worker);
                }
            }

            boolean isWorkerRight = !rightBank.isEmpty();
            if (isWorkerRight) {
                Worker worker = rightBank.poll();
                workersOnRight -= 1;
                workersOnLeft += 1;
                int crossTime = currentTime + worker.left;
                maxTime = Math.max(crossTime, maxTime);
                events.offer(new Event(crossTime + worker.put, 'L', worker));
                boxesRemaining -= 1;
                currentTime = crossTime;
            } else if (workersOnRight < boxesRemaining && !leftBank.isEmpty()) {
                Worker worker = leftBank.poll();
                workersOnRight += 1;
                workersOnLeft -= 1;
                int crossTime = currentTime + worker.right;
                currentTime = crossTime;
                events.offer(new Event(crossTime + worker.pick, 'R', worker));
            } else {
                if (events.isEmpty()) break;
                Event event = events.poll();
                currentTime = event.time;
                if (event.nextSide == 'L') {
                    leftBank.offer(event.worker);
                } else {
                    rightBank.offer(event.worker);
                }
            }

        }

        return maxTime;
    }
}