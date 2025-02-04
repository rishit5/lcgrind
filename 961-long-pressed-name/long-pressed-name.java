class Solution {
    public boolean isLongPressedName(String name, String typed) {
        List<Pair<Character, Integer>> list = new LinkedList<>();
        Character currChar = name.charAt(0);
        int count = 1;
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) != name.charAt(i-1)) {
                list.addLast(new Pair(currChar, count));
                currChar = name.charAt(i);
                count = 1;
            } else {
                count += 1;
            }
        }
        list.addLast(new Pair(currChar, count));
        List<Pair<Character, Integer>> listType = new LinkedList<>();
        currChar = typed.charAt(0);
        count = 1;
        for (int i = 1; i < typed.length(); i++) {
            if (typed.charAt(i) != typed.charAt(i-1)) {
                listType.addLast(new Pair(currChar, count));
                currChar = typed.charAt(i);
                count = 1;
            } else {
                count += 1;
            }
        }
        listType.addLast(new Pair(currChar, count));
        if (list.size() != listType.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey() != listType.get(i).getKey()) {
                return false;
            } 
            if (list.get(i).getValue() > listType.get(i).getValue()) {
                return false;
            }
        }
        return true;
    }
}