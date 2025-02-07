class Solution {
    List<String> results;

    Map<Character, char[]> charMap = new HashMap<>() {{
        put('1', new char[]{});
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};

    private void recursive(String digits, int i, String runString) {
        if (i == digits.length()) {
            if (runString.equals("")) {
                return;
            }
            results.addLast(new String(runString));
            return;
        }
        Character currentCharacter = digits.charAt(i);
        char[] chars = charMap.get(currentCharacter);
        for (int j = 0; j < chars.length; j++) {
            runString += chars[j];
            recursive(digits, i+1, runString);
            runString = runString.substring(0, runString.length() - 1);
        }
    }


    public List<String> letterCombinations(String digits) {
        results = new LinkedList<>();
        this.recursive(digits, 0, "");
        return results;
    }
}