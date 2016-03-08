
///////////////////////////////////////////
//
// Test frame for CS2 programming assignments
//   Created 12-10-2014 by Rick Leinecker
//
///////////////////////////////////////////

public class CS2ProgrammingWeek5 
{

	///////////////////////////////////////////
	//
	// Start of assignment code.
	//
	///////////////////////////////////////////
	
	/**
	 * Returns the last name, first name, and PID of the student.
	 * 
	 * This is required in order to get credit for the programming assignment.
	 */
	static String GetNameAndPID()
	{
		return( "Hellkamp,Daniel,d3889318");
	}
	
	//	Problem #1
	//	Given an array of ints, is it possible to choose a group 
	//	of some of the ints, such that the group sums to the given 
	//	target? This is a classic backtracking recursion problem. 
	//	Once you understand the recursive backtracking strategy in 
	//	this problem, you can use the same pattern for many problems to
	//	search a space of choices. Rather than looking at the whole array, 
	//	our convention is to consider the part of the array starting at 
	//	index start and continuing to the end of the array. The caller 
	//	can specify the whole array simply by passing start as 0. No loops 
	//	are needed -- the recursive calls progress down the array. 

	//	groupSumsTarget(0, {2, 4, 8}, 10) → true
	//	groupSumsTarget(0, {2, 4, 8}, 14) → true
	//	groupSumsTarget(0, {2, 4, 8}, 9) → false
	
	/**
	 * 
	 * @param start, nums, target
	 * 		int start tells you where to start in the array nums
	 * 		int[] nums is the given array
	 * 		int target is the value to which the group should sum to
	 * 
	 * @return
	 * 		returns true if there is a group that sums to target
	 * 		returns false if there is no group that sums to target
	 */
	static boolean groupSumsTarget(int start, int[] nums, int target) 
	{
		//declare a boolean to hold the truth value of the statement
		boolean sumPossible = false;
		//base case, check if sum is possible, if it is then taget will equal zero
		if(start>=nums.length)
		{
			return target==0;
		}
		//call the method recursively for each case whether we do subtract the current index value or not
		//T v F -> T
		return groupSumsTarget(start+1, nums, target-nums[start])||(groupSumsTarget(start+1, nums, target));
		
		
		
	}

	//	Problem #2
	//	Given an array of ints, is it possible to choose a group of 
	//	some of the ints, beginning at the start index, such that 
	//	the group sums to the given target? However, with the additional 
	//	constraint that all 6's must be chosen. (No loops needed.)

	//	groupSumsTarget6(0, {5, 6, 2}, 8) → true
	//	groupSumsTarget6(0, {5, 6, 2}, 9) → false
	//	groupSumsTarget6(0, {5, 6, 2}, 7) → false
	
	/**
	 * 
	 * @param start, nums, target
	 * 		int start tells you where to start in the array nums
	 * 		int[] nums is the given array
	 * 		int target is the value to which the group should sum to
	 * 
	 * @return
	 * 		returns true if there is a group that sums to target including all 6's in the group
	 * 		returns false if there is no group that sums to target
	 */
	static boolean groupSumsTarget6(int start, int[] nums, int target) 
	{
		//base case
		if(start>=nums.length)
		{
			return target==0;
		}
		//check to see if index value is 6
		if(nums[start]==6)
		{
			//if it is, must subtract
			return groupSumsTarget6(start+1, nums, target-nums[start]);
		}
		//T v F -> T  : Discrete Math
		return (groupSumsTarget6(start+1, nums, target)||groupSumsTarget6(start+1, nums, target-nums[start]));
	}	

	//	Problem #3
	//	Given an array of ints, is it possible to choose a group of some 
	//	of the ints, such that the group sums to the given target with this 
	//	additional constraint: If a value in the array is chosen to be in 
	//	the group, the value immediately following it in the array 
	//	must not be chosen. (No loops needed.)

	//	groupSumsTargetNoAdj(0, {2, 5, 10, 4}, 12) → true
	//	groupSumsTargetNoAdj(0, {2, 5, 10, 4}, 14) → false
	//	groupSumsTargetNoAdj(0, {2, 5, 10, 4}, 7) → false
	
	/**
	 * 
	 * @param start, nums, target
	 * 		int start tells you where to start in the array nums
	 * 		int[] nums is the given array
	 * 		int target is the value to which the group should sum to
	 * 
	 * @return
	 * 		returns true if there is a group that sums to target including the specified constraints
	 * 		returns false if there is no group that sums to target
	 */
	static boolean groupSumsTargetNoAdj(int start, int[] nums, int target) 
	{
		//base case
		if(start>=nums.length)
		{
			return target==0;
		}
		//either we choose the number at the index to subtract and increment our start by 2 so no adjacencies OR
		//we don't choose the number and look at the next location
		return groupSumsTargetNoAdj(start+2, nums, target-nums[start])||groupSumsTargetNoAdj(start+1, nums, target);
	}	

	//	Problem #4
	//	Given an array of ints, is it possible to choose a group of some 
	//	of the ints, such that the group sums to the given target with these 
	//	additional constraints: all multiples of 5 in the array must be 
	//	included in the group. If the value immediately following a multiple 
	//	of 5 is 1, it must not be chosen. (No loops needed.) 

	//	groupSumsTarget5(0, {2, 5, 10, 4}, 19) → true
	//	groupSumsTarget5(0, {2, 5, 10, 4}, 17) → true
	//	groupSumsTarget5(0, {2, 5, 10, 4}, 12) → false
	
	/**
	 * 
	 * @param start, nums, target
	 * 		int start tells you where to start in the array nums
	 * 		int[] nums is the given array
	 * 		int target is the value to which the group should sum to
	 * 
	 * @return
	 * 		returns true if there is a group that sums to target including the specified constraints
	 * 		returns false if there is no group that sums to target
	 */
	static boolean groupSumsTarget5(int start, int[] nums, int target) 
	{
		//base case
		if(start>=nums.length)
		{
			return target==0;
		}
		//check to see if it is a multiple of 5
		if(nums[start]%5==0)
		{
			//if it is a multiple of 5, see if nect location is a 1
			if(nums[start+1]==1&&start+2<nums.length)
			{
				//we can't use the 1 if it is immediately following, skip over it
				return groupSumsTarget5(start+2, nums, target);
			}
			else
			{
			return groupSumsTarget5(start+1, nums, target-nums[start]);
			}
		}
		// T v F -> T
		return (groupSumsTarget5(start+1, nums, target)||groupSumsTarget5(start+1, nums, target-nums[start]));
		
	}
	
	//	Problem #5
	//	Given an array of ints, is it possible to choose a group of some of 
	//	the ints, such that the group sums to the given target, with this 
	//	additional constraint: if there are numbers in the array that are adjacent 
	//	and the identical value, they must either all be chosen, or none of 
	//	them chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all 
	//	three 2's in the middle must be chosen or not, all as a group. (one loop 
	//	can be used to find the extent of the identical values). 

	//	groupSumsTargetClump(0, {2, 4, 8}, 10) → true
	//	groupSumsTargetClump(0, {1, 2, 4, 8, 1}, 14) → true
	//	groupSumsTargetClump(0, {2, 4, 4, 8}, 14) → false	
	
	/**
	 * 
	 * @param start, nums, target
	 * 		int start tells you where to start in the array nums
	 * 		int[] nums is the given array
	 * 		int target is the value to which the group should sum to
	 * 
	 * @return
	 * 		returns true if there is a group that sums to target including the specified constraints
	 * 		returns false if there is no group that sums to target
	 */
	static boolean groupSumsTargetClump(int start, int[] nums, int target) 
	{
		//incrementer for number of specific number in a row
		int numNums=1;
		if(start>=nums.length)
		{
			return target==0;
		}

		while(start+numNums<nums.length&&nums[start+numNums]==nums[start])
		{
			//get number of number in a row
			numNums++;
		}
		return (groupSumsTargetClump(start+numNums, nums, target-numNums*nums[start])||groupSumsTargetClump(start+numNums, nums, target));
	
		
	}
	
	//	Problem #6
	//	Given an array of ints, is it possible to divide the ints into two 
	//	groups, so that the sums of the two groups are the same. Every int must 
	//	be in one group or the other. Write a recursive helper method that takes 
	//	whatever arguments you like, and make the initial call to your recursive 
	//	helper from splitArray(). (No loops needed.)    

	//	divideArray({2, 2}) → true
	//	divideArray({2, 3}) → false
	//	divideArray({5, 2, 3}) → true
	
	/**
	 * 
	 * @param nums
	 * 		int[] nums is the given array
	 * 
	 * @return 
	 * 		returns true if the array can be divided so that the constraints are met
	 * 		returns false if the array cannot be divided so that the constraints are met
	 */
	static boolean divideArray(int[] nums) 
	{
		//call helper method
		return divideHelp(0, nums, 0, 0);
		
	}
	
	static boolean divideHelp(int start, int[] nums, int sum1, int sum2)
	{
		//base case
		if(start>=nums.length)
		{
			//return truth value
			return sum1==sum2;
		}
		//T v F -> T
		return divideHelp(start+1, nums, nums[start]+sum1, sum2)||divideHelp(start+1, nums, sum1, nums[start]+2);
	}
	
	//	Problem #7
	//	Given an array of ints, is it possible to divide the ints into two groups, 
	//	so that the sum of one group is a multiple of 10, and the sum of the 
	//	other group is odd. Every int must be in one group or the other. Write 
	//	a recursive helper method that takes whatever arguments you like, and 
	//	make the initial call to your recursive helper from 
	//	splitOdd10(). (No loops needed.)  

	//	oddDivide10({5, 5, 5}) → true
	//	oddDivide10({5, 5, 6}) → false
	//	oddDivide10({5, 5, 6, 1}) → true
	
	/**
	 * 
	 * @param nums
	 * 		int[] nums is the given array
	 * 
	 * @return 
	 * 		returns true if the array can be divided so that the constraints are met
	 * 		returns false if the array cannot be divided so that the constraints are met 
	 */
	static boolean oddDivide10(int[] nums) 
	{
		//call helper method
		return splitter(0, nums, 0, 0);
	}
	
	static boolean splitter(int start, int[]nums, int sum1, int sum2)
	{
		//base case
			if(start>=nums.length)
			{
				return((sum1%10==0&&sum2%2==1)||(sum2%10==0&&sum1%2==1));
			}
			return splitter(start+1, nums, nums[start]+sum1, sum2)||splitter(start+1, nums, sum1, nums[start]+2);
	}
	
	//	Problem #8
	//	Given an array of ints, is it possible to divide the ints into 
	//	two groups, so that the sum of the two groups is the same, with 
	//	these constraints: all the values that are multiple of 5 must 
	//	be in one group, and all the values that are a multiple of 3 
	//	(and not a multiple of 5) must be in the other. (No loops needed.)  

	//	divide53({1,1}) → true
	//	divide53({1, 1, 1}) → false
	//	divide53({2, 4, 2}) → true
	
	/**
	 * 
	 * @param nums
	 * 		int[] nums is the given array
	 * 
	 * @return 
	 * 		returns true if the array can be divided so that the constraints are met
	 * 		returns false if the array cannot be divided so that the constraints are met
	 */
	static boolean divide53(int[] nums) 
	{
		//call helper method
		return divider(0, nums, 0, 0);
	}
	
	static boolean divider(int start, int[]nums, int sum1, int sum2)
	{
		//base case
		if(start>=nums.length)
		{
			return sum1==sum2;
		}
		//if mutiple of 5, include with sum1
		if(nums[start]%5==0)
		{
			return divider(start+1, nums, sum1+nums[start], sum2);
		}
		//if multiple of 3, include with sum2
		if(nums[start]%3==0)
		{
			return divider(start+1, nums, sum1, sum2+nums[start]);
		}
		//return one or the other. of either is true, then method will return true
		return divider(start+1, nums, sum1+nums[start], sum2)||divider(start+1, nums, sum1, sum2+nums[start]);
	}

	///////////////////////////////////////////
	//
	// End of assignment code.
	//
	///////////////////////////////////////////
	
	public static void main(String[] args)
	{
	
	}
	
}