class Solution {
    class UnionFind {
        int[] parents;
        int[] rank;

        public UnionFind(int size) {
            this.parents = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                this.parents[i] = i;
                this.rank[i] = 0;
            }
        }

        public int find(int x) {
            if (this.parents[x] != x) {
                this.parents[x] = this.find(this.parents[x]);
            }
            return this.parents[x];
        }

        public int union(int x, int y) {
            int parentX = this.find(x);
            int parentY = this.find(y);
            if (parentX == parentY) {
                return 1;
            } else {
                if (this.rank[x] > this.rank[y]) {
                    this.parents[parentY] = parentX;
                } else if (this.rank[y] > this.rank[x]) {
                    this.parents[parentX] = parentY;
                } else {
                    this.rank[parentY] += 1;
                    this.parents[parentX] = parentY;
                }
                return 0;
            }
        }

    }
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int extraConnections = 0;
        int components = n;
        for (int i = 0; i < connections.length; i++) {
            int ret = uf.union(connections[i][0], connections[i][1]);
            extraConnections += ret;
            components -= (1 - ret);
        }
        if (extraConnections >= (components - 1)) {
            return components - 1;
        } else {
            return -1;
        }
    }
}