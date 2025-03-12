import java.util.*;

class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        // Max-heap for workers available on the left (sorted by efficiency)
        PriorityQueue<Worker> leftBank = new PriorityQueue<>((a, b) -> {
            int aEff = a.right + a.left;
            int bEff = b.right + b.left;
            if (aEff != bEff) return bEff - aEff;
            return b.index - a.index;
        });
        // Max-heap for workers available on the right (sorted by efficiency)
        PriorityQueue<Worker> rightBank = new PriorityQueue<>((a, b) -> {
            int aEff = a.right + a.left;
            int bEff = b.right + b.left;
            if (aEff != bEff) return bEff - aEff;
            return b.index - a.index;
        });
        
        // Initialize all workers in the left bank
        for (int i = 0; i < k; i++) {
            leftBank.offer(new Worker(time[i][0], time[i][1], time[i][2], time[i][3], i));
        }
        
        // Event queue sorted by time, each event is when a worker becomes available on a side
        PriorityQueue<Event> events = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));
        int currentTime = 0;
        int workersOnRight = 0;
        int boxesRemaining = n;
        int maxTime = 0;
        
        while (boxesRemaining > 0) {
            // Process all events that have happened up to currentTime
            while (!events.isEmpty() && events.peek().time <= currentTime) {
                Event e = events.poll();
                if (e.side == 'R') {
                    rightBank.offer(e.worker);
                } else {
                    leftBank.offer(e.worker);
                }
            }
            
            boolean canCrossRight = !rightBank.isEmpty();
            if (canCrossRight) {
                // Worker crosses from right to left
                Worker worker = rightBank.poll();
                int crossTime = currentTime + worker.left;
                maxTime = Math.max(maxTime, crossTime);
                boxesRemaining--;
                workersOnRight--;
                // Schedule when the worker will be available on left after putting the box
                events.offer(new Event(crossTime + worker.put, 'L', worker));
                currentTime = crossTime;
            } else if (boxesRemaining > workersOnRight && !leftBank.isEmpty()) {
                // Worker crosses from left to right
                Worker worker = leftBank.poll();
                int crossTime = currentTime + worker.right;
                workersOnRight++;
                // Schedule when the worker will be available on right after picking the box
                events.offer(new Event(crossTime + worker.pick, 'R', worker));
                currentTime = crossTime;
            } else {
                // No workers can cross now, jump to the next event time
                if (events.isEmpty()) break; // Should not happen as boxesRemaining > 0
                Event nextEvent = events.poll();
                currentTime = nextEvent.time;
                // Add the worker back to their respective bank
                if (nextEvent.side == 'R') {
                    rightBank.offer(nextEvent.worker);
                } else {
                    leftBank.offer(nextEvent.worker);
                }
                // Reprocess the event
                continue;
            }
            
            // // Process all events that have happened up to currentTime after the crossing
            // while (!events.isEmpty() && events.peek().time <= currentTime) {
            //     Event e = events.poll();
            //     if (e.side == 'R') {
            //         rightBank.offer(e.worker);
            //     } else {
            //         leftBank.offer(e.worker);
            //     }
            // }
        }
        
        return maxTime;
    }
    
    class Worker {
        int right, pick, left, put, index;
        Worker(int r, int p, int l, int put, int i) {
            right = r;
            pick = p;
            left = l;
            this.put = put;
            index = i;
        }
    }
    
    class Event {
        int time;
        char side; // 'L' for left, 'R' for right
        Worker worker;
        Event(int t, char s, Worker w) {
            time = t;
            side = s;
            worker = w;
        }
    }
}