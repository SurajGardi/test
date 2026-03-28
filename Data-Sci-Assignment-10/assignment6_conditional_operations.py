import numpy as np

# 1. Create an array of 20 random integers between 1 and 100
arr = np.random.randint(1, 101, size=20)
print("Original Array:", arr)

# 2. Extract all even numbers
evens = arr[arr % 2 == 0]
print("Even numbers:", evens)

# 3. Replace odd numbers with -1
arr_modified = np.where(arr % 2 != 0, -1, arr)
print("Odd numbers replaced with -1:", arr_modified)

# 4. Count numbers divisible by 5
divisible_by_5 = np.sum(arr % 5 == 0)
print("Count of numbers divisible by 5:", divisible_by_5)
