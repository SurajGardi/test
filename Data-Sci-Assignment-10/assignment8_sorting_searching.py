import numpy as np

# 1. Create an array of 10 random integers
arr = np.random.randint(1, 100, size=10)
print("Original Array:", arr)

# 2. Sort the array in Ascending and Descending order
asc_sort = np.sort(arr)
desc_sort = np.sort(arr)[::-1]
print("Ascending:", asc_sort)
print("Descending:", desc_sort)

# 3. Find the maximum and minimum values
print("Maximum Value:", np.max(arr))
print("Minimum Value:", np.min(arr))

# 4. Find the index of the maximum value
print("Index of Maximum Value:", np.argmax(arr))
