class Solution {
    private double calcPow(double x, long n) {
        // System.out.println(n);
        if (n == 0) {
            return 1;
        }
        // x^n -> n is even -> (x^2)^n/2
        if (n % 2 == 0) {
            return calcPow(x * x, n / 2);
        } else {
            return x * calcPow(x*x, (n - 1)/2);
        }
    }

    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (n < 0) {
            long res = -1 * (long) n;
            // System.out.println(res);
            // return 0.0;
            return 1 / calcPow(x, res);
        } else {
            return calcPow(x, (long) n);
        }
    }
}