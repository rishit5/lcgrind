class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                right = mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else if (arr[mid] == x) {
                right = mid;
            }
        }
        List<Integer> result = new LinkedList<>();
        int l = left - 1;
        int r = left;
        // System.out.println(left);
        while (k-- > 0) {
            if (l >= 0 && r < arr.length) {
                if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                    result.addFirst(arr[l]);
                    l -= 1;
                } else {
                    result.addLast(arr[r]);
                    r += 1;
                }
            } else if (l >= 0) {
                result.addFirst(arr[l]);
                l -= 1;
            } else if (r < arr.length) {
                result.addLast(arr[r]);
                r += 1;
            }
        }
        return result;
    }
}