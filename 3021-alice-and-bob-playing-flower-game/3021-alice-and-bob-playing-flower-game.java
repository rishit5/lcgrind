class Solution {
    public long flowerGame(int n, int m) {
        long n_odd  = n / 2 + (n % 2 == 0 ? 0 : 1);
        long m_even = m / 2;
        
        long n_even = n / 2;
        long m_odd  = m / 2 + (m % 2 == 0 ? 0 : 1);
        
        return n_odd * m_even + n_even * m_odd;
    }
}