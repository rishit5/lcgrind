class Solution {
    
    private void reverse(long[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            long temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 1;
            j -= 1;
        }
    }

    private long getCount(long[] nums1, long[] nums2, long mid) {
        int i = 0;
        int j = nums2.length - 1;
        long count = 0;
        for (long num : nums1) {
            while (j >= 0) {
                if (num * nums2[j] <= mid) {
                    count += j + 1;
                    break;
                } else {
                    j -= 1;
                }
            }
        } 
        return count;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long[] neg1 = Arrays.stream(nums1).asLongStream().filter(x -> x < 0).toArray();
        long[] pos1 = Arrays.stream(nums1).asLongStream().filter(x -> x >= 0).toArray();
        long[] neg2 = Arrays.stream(nums2).asLongStream().filter(x -> x < 0).toArray();
        long[] pos2 = Arrays.stream(nums2).asLongStream().filter(x -> x >= 0).toArray();

        boolean isPositive = k > (neg1.length * pos2.length) + (neg2.length * pos1.length);

        if (isPositive) {
            k -= (neg1.length * pos2.length) + (neg2.length * pos1.length);
            reverse(neg1);
            reverse(neg2);
        } else {
            reverse(pos1);
            reverse(pos2);
        }

        long low = (long) -1e10;
        long high = (long) 1e10 + 2;

        while (low < high) {
            long mid = low + ((high - low) / 2);

            long count = isPositive ? getCount(pos1, pos2, mid) + getCount(neg1, neg2, mid) :
                                      getCount(neg1, pos2, mid) + getCount(neg2, pos1, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }
}