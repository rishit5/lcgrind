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
                return this.parent[x];
            } 
            return this.find(parent[x]);
        }

        public int union(int x, int y) {
            int parentX = this.find(x);
            int parentY = this.find(y);

            if (parentX == parentY) {
                return 0;
            }

            if (rank[parentX] > rank[parentY]) {
                this.parent[parentY] = parentX;
                this.rank[parentX] += 1;
            } else {
                this.parent[parentX] = parentY;
                this.rank[parentY] += 1;
            }

            return 1;
        }
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int result = n;
        for (int i = 0; i < edges.length; i++) {
            result -= uf.union(edges[i][0], edges[i][1]);
        }
        return result;
    }
}