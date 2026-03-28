import numpy as np

# 1. Create two arrays of size 10
arr1 = np.random.randint(1, 10, size=10)
arr2 = np.random.randint(1, 10, size=10)

print("Array 1:", arr1)
print("Array 2:", arr2)

# 2. Perform Addition, Subtraction, Multiplication, Division
print("Addition:", arr1 + arr2)
print("Subtraction:", arr1 - arr2)
print("Multiplication:", arr1 * arr2)
print("Division:", np.round(arr1 / arr2, 2))

# 3. Find Square root, Square, Exponential of elements (using arr1)
print("Square root (arr1):", np.round(np.sqrt(arr1), 2))
print("Square (arr1):", np.square(arr1))
print("Exponential (arr1):", np.round(np.exp(arr1), 2))
