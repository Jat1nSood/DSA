class Solution:
    
        
        
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        
        n = len(nums)
        ans = []
        
        left = 0
        right = 0
        
        parent = not nums[0]
        
        count = 0
        while right < n:
            
            if nums[right] != parent:
                count += 1
                parent = nums[right]
                
            else:
                left = right
                ans.append(count)
                count = 1
                parent = nums[right]
            
            right += 1
        
        ans.append(count)
        subArrays = 0
        
        for i in ans:
            
            subArrays += (i * (i + 1)// 2)
            
        return subArrays
            
            
        
        