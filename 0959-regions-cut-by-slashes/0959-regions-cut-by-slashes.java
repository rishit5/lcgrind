class Solution {
    
    public int result;
    
    private void dfs(char[][] expanded, boolean[][] visited, int i, int j) {
        // System.out.println("Starting dfs from: " + i + " " + j);
        Stack<List<Integer>> stack = new Stack<>();
        
        stack.push(List.of(i, j));
        
        while (!stack.isEmpty()) {
            List<Integer> position = stack.pop();
            int currI = position.get(0);
            int currJ = position.get(1);
            
            visited[currI][currJ] = true;
            
            if (currI - 1 >= 0) {
                if (expanded[currI-1][currJ] == ' ' && visited[currI-1][currJ] == false) {
                    stack.push(List.of(currI-1, currJ));
                }
            }
            if (currJ - 1 >= 0) {
                if (expanded[currI][currJ-1] == ' ' && visited[currI][currJ-1] == false) {
                    stack.push(List.of(currI, currJ-1));
                }
            }
            if (currI + 1 < expanded.length) {
                if (expanded[currI+1][currJ] == ' ' && visited[currI+1][currJ] == false) {
                    stack.push(List.of(currI+1, currJ));
                }
            }
            if (currJ + 1 < expanded.length) {
                if (expanded[currI][currJ+1] == ' ' && visited[currI][currJ+1] == false) {
                    stack.push(List.of(currI, currJ+1));
                }
            }
        }
        this.result++;
        return;
    }
    
    public int regionsBySlashes(String[] grid) {
        
        this.result = 0;
        
        char[][] expanded = new char[grid.length*3][grid[0].length()*3];
        boolean[][] visited = new boolean[grid.length*3][grid[0].length()*3];
        
        for (int i = 0; i < expanded.length; i++) {
            Arrays.fill(expanded[i], ' ');
            Arrays.fill(visited[i], false);
        }
        
        int i = 0;
        int j = 0;
        
        for (String s : grid) {
            j = 0;
            for (int k = 0; k < s.length(); k++) {
                // System.out.println(i + " " + j);
                if (s.charAt(k) == ' ') {
                    j += 3;
                    continue;
                } else if (s.charAt(k) == '\\') {
                    expanded[i][j] = '\\';
                    expanded[i+1][j+1] = '\\';
                    expanded[i+2][j+2] = '\\';
                } else if (s.charAt(k) == '/') {
                    expanded[i][j+2] = '/';
                    expanded[i+1][j+1] = '/';
                    expanded[i+2][j] = '/';
                }
                j += 3;
            }
            i += 3;
        }
        
        for (i = 0; i < expanded.length; i++) {
            for (j = 0; j < expanded[i].length; j++) {
                if (expanded[i][j] == ' ' && visited[i][j] == false) {
                    this.dfs(expanded, visited, i, j);
                }
            }
        }
                           
        return this.result;
    
    }
}