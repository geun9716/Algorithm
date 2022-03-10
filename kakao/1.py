#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'cardinalitySort' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY nums as parameter.
#

def cardinalitySort(nums):
    # Write your code here
    print(nums)
    arr = []
    for num in nums:
        cnt = 0
        while num > 0:
            cnt += num%2
            num /= 2
        arr.append((cnt,num))
    return arr
    
    
if __name__ == '__main__':
    nums_count = int(input().strip())

    nums = []

    for _ in range(nums_count):
        nums_item = int(input().strip())
        nums.append(nums_item)

    result = cardinalitySort(nums)