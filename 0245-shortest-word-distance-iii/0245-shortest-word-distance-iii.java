class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                list1.add(i);
            }
            if (wordsDict[i].equals(word2)) {
                list2.add(i);
            }
        }
        int result = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 0; i < list1.size() - 1; i++) {
                result = Math.min(result, list1.get(i+1) - list1.get(i));
            }
        } else {
            int list1I = 0;
            int list2I = 0;
            while (list1I < list1.size() && list2I < list2.size()) {
                if (list1I == list1.size()) {
                    list2I++;
                    continue;
                }
                if (list2I == list2.size()) {
                    list1I++;
                    continue;
                }
                if (list1.get(list1I) >= list2.get(list2I)) {
                    result = Math.min(result, list1.get(list1I) - list2.get(list2I));
                    list2I++;
                } else {
                    result = Math.min(result, list2.get(list2I) - list1.get(list1I));
                    list1I++;
                }
            }
        }
        return result;
    }
}