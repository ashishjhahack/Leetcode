class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftBound(nums, target);
        int right = findRightBound(nums, target);
        return new int[]{left, right};
    }

    public int findLeftBound(int[] nums, int target) {
        int n = nums.length;
        int index = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                high = mid - 1;  // ✅ Correct: Move left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    public int findRightBound(int[] nums, int target) {
        int n = nums.length;
        int index = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                low = mid + 1;  // ✅ Correct: Move right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
