class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(arr[mid] - x) < min) {
                min = Math.abs(arr[mid] - x);
                index = mid;
            }
            if (min == 0) {
                right = mid - 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        List<Integer> result = new LinkedList<>();
        result.addLast(arr[index]);
        k -= 1;
        int l = index - 1;
        int r = index + 1;
        while (k > 0) {
            if (l >= 0 && r < arr.length) {
                if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                    result.addFirst(arr[l]);
                    l -= 1;
                } else {
                    result.addLast(arr[r]);
                    r += 1; 
                }
            } else if (l >= 0) {
                result.addFirst(arr[l]);
                l -= 1;
            } else {
                result.addLast(arr[r]);
                r += 1;
            }
            k -= 1;
        }

        return result;
    }
}