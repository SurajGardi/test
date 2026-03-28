import numpy as np

# 1. Generate 100 random numbers between 0 and 1
arr = np.random.rand(100)

# 2. Find Mean, Median, Standard deviation
print("Mean:", np.mean(arr))
print("Median:", np.median(arr))
print("Standard Deviation:", np.std(arr))

# 3. Count how many values are greater than 0.5
count_greater = np.sum(arr > 0.5)
print("Values > 0.5:", count_greater)

# 4. Normalize the data between 0 and 1
# (Using Min-Max normalization formula)
normalized_arr = (arr - np.min(arr)) / (np.max(arr) - np.min(arr))
print("Normalized Data Min/Max:", np.min(normalized_arr), "/", np.max(normalized_arr))
