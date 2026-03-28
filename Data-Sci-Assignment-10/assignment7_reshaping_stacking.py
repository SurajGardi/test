import numpy as np

# 1. Create a 1D array of size 12
arr = np.arange(12)
print("1D Array:", arr)

# 2. Reshape it into 3x4 and 2x6
arr_3x4 = arr.reshape(3, 4)
arr_2x6 = arr.reshape(2, 6)
print("Reshaped 3x4:\n", arr_3x4)
print("Reshaped 2x6:\n", arr_2x6)

# 3. Stack two arrays vertically and horizontally
# Creating a second 3x4 array for stacking purposes
arr2_3x4 = np.arange(12, 24).reshape(3, 4)
v_stack = np.vstack((arr_3x4, arr2_3x4))
h_stack = np.hstack((arr_3x4, arr2_3x4))

print("Vertically Stacked:\n", v_stack)
print("Horizontally Stacked:\n", h_stack)

# 4. Flatten the final array (flattening the vertically stacked one)
flattened = v_stack.flatten()
print("Flattened Array:", flattened)
