class Solution {
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            Arrays.fill(this.rank, 1);
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int x) {
            if (this.parent[x] == x) {
                return x;
            }
            return this.find(parent[x]);
        }

        public int union(int x, int y) {
            int parentX = this.find(x);
            int parentY = this.find(y);

            if (parentX == parentY) {
                return 0;
            }

            if (this.rank[parentX] > this.rank[parentY]) {
                this.parent[parentY] = parentX;
                this.rank[parentX] += this.rank[parentY];
            } else {
                this.parent[parentX] = parentY;
                this.rank[parentY] += this.rank[parentX];
            }

            return 1;
        }
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        UnionFind uf = new UnionFind(n);

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < dislikes.length; i++) {
            adjList.putIfAbsent(dislikes[i][0]-1, new LinkedList<>());
            adjList.putIfAbsent(dislikes[i][1]-1, new LinkedList<>());
            adjList.get(dislikes[i][0]-1).addLast(dislikes[i][1]-1);
            adjList.get(dislikes[i][1]-1).addLast(dislikes[i][0]-1);
        }

        System.out.println(adjList);

        for (int i = 0; i < n; i++) {
            List<Integer> neighBours = adjList.getOrDefault(i, new LinkedList<>());
            for (int j = 0; j < neighBours.size(); j++) {
                if (uf.find(i) == uf.find(neighBours.get(j))) {
                    // System.out.println(" " + i + " " + j);
                    return false;
                }
                int firstNeigh = neighBours.get(0);
                uf.union(firstNeigh, neighBours.get(j));
            }
        }

        return true;
    }
}