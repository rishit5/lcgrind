class Solution {
    
    private int[] mergeSort(int[] nums, int i, int j) {
        if (i == j) {
            return new int[] {nums[i]};
        }
        int mid = i + (j - i) / 2;
        int[] result_1 = mergeSort(nums, i, mid);
        int[] result_2 = mergeSort(nums, mid+1, j);
        int[] final_result = new int[result_1.length + result_2.length];
        
        int l = 0;
        int m = 0;
        int n = 0;
        
        while (l < result_1.length || m < result_2.length) {
            if (l == result_1.length) {
                final_result[n] = result_2[m];
                n++;
                m++;
                continue;
            }
            if (m == result_2.length) {
                final_result[n] = result_1[l];
                n++;
                l++;
                continue;
            }
            if (result_1[l] < result_2[m]) {
                final_result[n] = result_1[l];
                n++;
                l++;
            } else {
                final_result[n] = result_2[m];
                n++;
                m++;
            }
        }
        return final_result;
    }
    
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}