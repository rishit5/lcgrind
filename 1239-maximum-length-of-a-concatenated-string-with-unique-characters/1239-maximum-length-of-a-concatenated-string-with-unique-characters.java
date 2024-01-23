class Solution {
    public int maxLength(List<String> arr) {
        // ["a", "b", "c", "a"]
        // [ 1 ,  1 ,  1 ,  0] => 3 
        // [ 1 ,  1 ,  1 ,  1] => Binary equivalent of 2
        // [ 0 ,  0 ,  1 ,  1] => Binary equivalent of 0
        int maxLen = 0;
        for (int i = 0; i < Math.pow(2, arr.size()); i++) { // 0, 1, 2, 3, ... 15 
            int flag = 0;
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < arr.size(); j++) {  // j = 0, 1, 2, 3
                if ((i >> j & 1) == 1) {            // i = 00000000000011 & 0000000000001 => 1
                    for (char c : arr.get(j).toCharArray()) {
                        if (set.contains(c)) {
                            flag = 1;
                            break;
                        } else {
                            set.add(c);
                        }
                    }
                }
            }
            if (flag == 0) {
                maxLen = Math.max(set.size(), maxLen);
            }
        }
        return maxLen;
    }
}

