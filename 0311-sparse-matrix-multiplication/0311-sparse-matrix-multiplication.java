class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat2[0].length];

        Map<Integer, Map<Integer, Integer>> mapMat1 = new HashMap<>();
        for (int i = 0; i < mat1.length; i++) {
            mapMat1.putIfAbsent(i, new HashMap<>());
            for (int j = 0; j < mat1[i].length; j++) {
                if (mat1[i][j] == 0) {
                    continue;
                } else {
                    mapMat1.get(i).put(j, mat1[i][j]);
                }
            }
        }
        
        Map<Integer, Map<Integer, Integer>> mapMat2 = new HashMap<>();
        for (int i = 0; i < mat2.length; i++) {
            int j = 0;
            for (j = 0; j < mat2[i].length; j++) {
                mapMat2.putIfAbsent(j, new HashMap<>());
                if (mat2[i][j] == 0) {
                    continue;
                } else {
                    mapMat2.get(j).put(i, mat2[i][j]);
                }
            }
        }

        System.out.println(mapMat1);
        System.out.println(mapMat2);

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                Map<Integer, Integer> currRow = mapMat1.get(i);
                Map<Integer, Integer> currCol = mapMat2.get(j);
                for (Integer col : currRow.keySet()) {
                    if (currCol.containsKey(col)) {
                        result[i][j] += currRow.get(col) * currCol.get(col);
                    }
                }
            }
        }

        return result;
    }
}