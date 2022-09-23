import math;

class Solution:

    def search(self, nums, target) -> int:
        left_idx, right_idx = 0, len(nums)
        while right_idx > left_idx:
            mid_idx = (left_idx + right_idx)//2
        
            if (nums[mid_idx] == target):
                return mid_idx
            elif(target > nums[mid_idx]):
                left_idx = mid_idx + 1
            elif(target < nums[mid_idx]):
                right_idx = mid_idx
        return -1
            

    # def helper(self, start_idx, end_idx, nums, target):
    #     mid_idx = math.floor((start_idx + end_idx)/2)
    #     if (start_idx == end_idx): 
    #         return -1

    #     if (target > nums[mid_idx]):
    #         print("greater than: ", nums)
    #         return self.helper(mid_idx + 1, end_idx, nums, target)
    #     elif (target < nums[mid_idx]):
    #         print("less than: ", nums)
    #         return self.helper(start_idx, mid_idx, nums, target)
    #     else: 
    #         return mid_idx

    # def search(self, nums, target) -> int:
    #     return self.helper(0,len(nums), nums, target)
    
solution = Solution()
print(solution.search([-1,0,3,5,9,12], 9))
