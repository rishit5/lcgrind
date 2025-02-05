class Solution {
    private double result(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            if (n % 2 == 0) {
                return result(x * x, n/2);
            } else {
                return x * result(x * x, (n - 1) / 2);
            }
        } else {
            return 1.0 / result(x, -1 * n);
        }
    }
    public double myPow(double x, int n) {
        return this.result(x, (long) n);
    }
}