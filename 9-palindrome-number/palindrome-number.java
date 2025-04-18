class Solution {
    
    private int reverse(int x) {
        int reverseX = 0;
        while (x > 0) {
            reverseX = (reverseX * 10) + (x % 10);
            x = x / 10;
        }
        return reverseX;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverseX = reverse(x);
        return reverseX == x;
    }
}