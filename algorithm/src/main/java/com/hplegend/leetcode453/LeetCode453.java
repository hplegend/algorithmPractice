//Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1. 
// n-1个元素都需要+1
//
// Example:
// 
//Input:
//[1,2,3]
//
//Output:
//3
//
//Explanation:
//Only three moves are needed (remember each move increments two elements):
//
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
// [1,2,3] +1  -> [1+1,2+1,3] =>  [2,3,3]
// [2,3,3] +1  -> [2+1,3+1,3] =>  [3,4,3] 
// [3,4,3] +1  -> [3+1,4,3+1] =>  [4,4,4]
// Related Topics Math 

// 将n-1个元素的值加一，其实可以等价于将某个元素减一，所以需要的步数就等于sum(1,n) - minNum * length


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode453 {
	public int minMoves(int[] nums) {

         // o（n）

		if (null == nums) {
			return 0;
		}

		int minNum = nums [0];
		int sum = 0;

		for (int i =0 ;i < nums.length; ++ i) {
			sum  += nums[i];
			if(minimum > nums[i]) {
				minimum = nums[i];
			}

		}

		int ret = sum - minNum * nums.length;
		return ret;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
