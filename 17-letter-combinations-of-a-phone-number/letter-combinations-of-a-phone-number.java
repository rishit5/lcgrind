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

    private void recursive(String digits, int i, char[] charArray) {
        if (i == digits.length()) {
            results.addLast(new String(charArray));
            return;
        }
        Character currentCharacter = digits.charAt(i);
        char[] chars = charMap.get(currentCharacter);
        for (int j = 0; j < chars.length; j++) {
            charArray[i] = chars[j];
            recursive(digits, i+1, charArray);
        }
    }


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<>();
        }
        results = new LinkedList<>();
        char[] charArray = new char[digits.length()];
        this.recursive(digits, 0, charArray);
        return results;
    }
}