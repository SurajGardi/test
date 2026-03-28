import numpy as np

# 1. Create a NumPy array of integers from 1 to 20
arr = np.arange(1, 21)
print("Array:", arr)

# 2. Find the shape, size, and data type of the array
print("Shape:", arr.shape)
print("Size:", arr.size)
print("Data Type:", arr.dtype)

# 3. Convert the array into float type
arr_float = arr.astype(float)
print("Float Array:", arr_float)

# 4. Find the sum and mean of the array
print("Sum:", np.sum(arr))
print("Mean:", np.mean(arr))
