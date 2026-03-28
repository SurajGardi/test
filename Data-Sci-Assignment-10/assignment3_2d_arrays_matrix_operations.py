import numpy as np

# 1. Create a 3x3 matrix with values from 1 to 9
matrix = np.arange(1, 10).reshape(3, 3)
print("3x3 Matrix:\n", matrix)

# 2. Find the transpose of the matrix
print("Transpose:\n", matrix.T)

# 3. Calculate Row-wise sum and Column-wise sum
print("Row-wise sum:", np.sum(matrix, axis=1))
print("Column-wise sum:", np.sum(matrix, axis=0))

# 4. Find the determinant of the matrix
# Note: The determinant of this specific sequential matrix is 0.
det = np.linalg.det(matrix)
print("Determinant:", round(det, 2))
