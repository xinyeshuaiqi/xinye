### 排序 + 双指针
本题的难点在于如何去除重复解。

### 算法流程：

 1. 特判，对于数组长度 *n*，如果数组为 *null* 或者数组长度小于 *3*，返回 *[]*。
 2. 对数组进行排序。
 3. 遍历排序后数组：
    - 若 *nums[i]>0*：因为已经排序好，所以后面不可能有三个数加和等于 *0*，直接返回结果。
    - 对于重复元素：跳过，避免出现重复解
    - 令左指针 *L=i+1*，右指针 *R=n-1*，当 *L<R* 时，执行循环：
      * 当 *nums[i]+nums[L]+nums[R]==0*，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 *L,R* 移到下一位置，寻找新的解
      * 若和大于 *0*，说明 *nums[R]* 太大，*R* 左移
      * 若和小于 *0*，说明 *nums[L]* 太小，*L* 右移
### 复杂度分析

 - 时间复杂度：![O\left(n^{2}\right) ](./p__Oleft_n^{2}right__.png) ，数组排序 ![O(N\logN) ](./p__O_N_log_N__.png) ，遍历数组 ![O\left(n\right) ](./p__Oleft_nright__.png) ，双指针遍历 ![O\left(n\right) ](./p__Oleft_nright__.png) ，总体 ![O(N\logN)+O\left(n\right)*O\left(n\right) ](./p__O_N_log_N_+Oleft_nright_*Oleft_nright__.png) ，![O\left(n^{2}\right) ](./p__Oleft_n^{2}right__.png) 
 - 空间复杂度：*O(1)*

```python [-Python3]
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        n=len(nums)
        res=[]
        if(not nums or n<3):
            return []
        nums.sort()
        res=[]
        for i in range(n):
            if(nums[i]>0):
                return res
            if(i>0 and nums[i]==nums[i-1]):
                continue
            L=i+1
            R=n-1
            while(L<R):
                if(nums[i]+nums[L]+nums[R]==0):
                    res.append([nums[i],nums[L],nums[R]])
                    while(L<R and nums[L]==nums[L+1]):
                        L=L+1
                    while(L<R and nums[R]==nums[R-1]):
                        R=R-1
                    L=L+1
                    R=R-1
                elif(nums[i]+nums[L]+nums[R]>0):
                    R=R-1
                else:
                    L=L+1
        return res
```