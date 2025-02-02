class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean isPossible = false;
        Map<String, List<String>> myMap = new HashMap<>();
        for (String word : wordList) {
            if (word.equals(endWord)) {
                isPossible = true;
            }
            for (int i = 0; i < word.length(); i++) {
                String res = word.substring(0, i) + "*" + word.substring(i+1, word.length());
                myMap.putIfAbsent(res, new LinkedList<>());
                myMap.get(res).add(word);
            }
        }

        if (!isPossible) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        queue.add("-11111");

        int result = 0;

        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            visited.add(curr);
            // System.out.println(curr);
            if (curr.equals(endWord)) {
                return result + 1;
            }
            if (curr.equals("-11111")) {
                if (!queue.isEmpty()) {
                    queue.add("-11111");
                }
                result += 1;
                continue;
            }
            System.out.println("For curr: " + curr);
            for (int i = 0; i < curr.length(); i++) {
                String res = curr.substring(0, i) + "*" + curr.substring(i+1, curr.length());
                myMap.putIfAbsent(res, new LinkedList<>());
                List<String> nextPossibles = myMap.get(res);
                for (String s : nextPossibles) {
                    if (s.equals(curr) || visited.contains(s)) {
                        continue;
                    }
                    System.out.println(s);
                    queue.add(s);
                }
            }
        }
        return 0;
    }
}