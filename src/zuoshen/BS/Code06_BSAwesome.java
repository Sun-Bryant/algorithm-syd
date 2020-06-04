package zuoshen.BS;

public class Code06_BSAwesome {

	/**
	 * 求随意一个局部最小值并返回。
	 *
	 * 局部最小值定义:
	 * 		1) [0]<[1],0是局部最小。
	 * 		2) [N-1]<[N-2],N-1是局部最小。
	 * 		3) [i-1]>[i]<[i+1],i是局部最小。
	 *
	 * 无序数组，相邻的都不相等，返回一个局部最小值的位置。----可以采用二分法
	 * 通过这道题，说明了二分法不一定非得有序。
	 *
	 * @param arr
	 * @return
	 */
	public static int getLessIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;
	}

}
