class Solution {
    class UnionFind {
        int[] rank;
        int[] parent;

        public UnionFind(int n) {
            this.rank = new int[n];
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int i) {
            if (this.parent[i] != i) {
                this.parent[i] = this.find(parent[i]);
            }
            return this.parent[i];
        }

        public boolean union(int i, int j) {
            int parentI = this.find(i);
            int parentJ = this.find(j);
            if (parentI == parentJ) {
                return false;
            }
            if (this.rank[parentI] > this.rank[parentJ]) {
                this.parent[parentJ] = parentI;
            } else if (this.rank[parentJ] > this.rank[parentI]) {
                this.parent[parentI] = parentJ;
            } else {
                this.parent[parentJ] = parentI;
                this.rank[parentI] += 1;
            }
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> emailMap = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (emailMap.containsKey(accounts.get(i).get(j))) {
                    uf.union(i, emailMap.get(accounts.get(i).get(j)));
                } else {
                    emailMap.put(accounts.get(i).get(j), i);
                }
            }
        }

        // System.out.println(emailMap);

        Map<Integer, PriorityQueue<String>> resultMap = new HashMap<>();
        for (String email : emailMap.keySet()) {
            Integer parent = uf.find(emailMap.get(email));
            resultMap.putIfAbsent(parent, new PriorityQueue<>());
            resultMap.get(parent).add(email);
        }

        List<List<String>> result = new LinkedList<>();

        for (Integer parent : resultMap.keySet()) {
            List<String> currResult = new LinkedList<>();
            currResult.add(accounts.get(parent).get(0));
            PriorityQueue<String> currEmails = resultMap.get(parent);
            while (!currEmails.isEmpty()) {
                currResult.add(currEmails.poll());
            }
            result.add(new LinkedList<>(currResult));
        }

        return result;
    }
}