/* 1.7 Binary Search */

// Equals to OR Greater than target X :: left tilt
// if target's duplicates exist, then 1st index of target
int bs(int[] nums, int X) {
	int lo = 0, hi = nums.length - 1;
	while(lo < hi) {
		int mid = lo + (hi - lo) / 2;
		if(nums[mid] < X) {
			lo = mid + 1;
		}else {
			hi = mid;
		}
	}
	return lo;
}

// Equals to OR Less than target X :: right tilt
int bs(int[] nums, int X) {
	int lo = 0, hi = nums.length - 1;
	while(lo < hi) {
		int mid = lo + (hi - lo) / 2 + 1;
		if(nums[mid] > X) {
			hi = mid -1;
		}else {
			lo = mid;
		}
	}
	return hi;
}