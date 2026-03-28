import numpy as np

# 1. Create an array of 15 random integers between 10 and 50
arr = np.random.randint(10, 51, size=15)
print("Original Array:", arr)

# 2. Extract First 5 elements and Last 5 elements
print("First 5 elements:", arr[:5])
print("Last 5 elements:", arr[-5:])

# 3. Replace all values greater than 30 with 0
arr_modified = np.where(arr > 30, 0, arr)
print("Modified Array (values > 30 replaced with 0):", arr_modified)

# 4. Print elements at even indices
print("Elements at even indices:", arr[::2])
