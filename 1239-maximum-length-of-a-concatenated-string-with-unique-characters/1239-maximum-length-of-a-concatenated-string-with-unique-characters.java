class Solution {
    public int maxLength(List<String> arr) {
        int maxLen = 0;
        for (int i = 0; i < Math.pow(2, arr.size()); i++) {
            int flag = 0;
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < arr.size(); j++) {
                if ((i >> j & 1) == 1) {
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