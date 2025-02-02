class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (Character c : jewels.toCharArray()) {
            jewelSet.add(c);
        }
        int result = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewelSet.contains(stones.charAt(i))) {
                result += 1;
            }
        }
        return result;
    }
}