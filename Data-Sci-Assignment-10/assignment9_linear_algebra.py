import numpy as np

# 1. Create two 3x3 matrices
mat1 = np.random.randint(1, 10, size=(3, 3))
mat2 = np.random.randint(1, 10, size=(3, 3))

print("Matrix 1:\n", mat1)
print("Matrix 2:\n", mat2)

# 2. Perform Matrix multiplication and Element-wise multiplication
print("Matrix Multiplication (Dot Product):\n", np.dot(mat1, mat2))
print("Element-wise Multiplication:\n", mat1 * mat2)

# 3. Find Inverse and Eigenvalues of a matrix
# (Using mat1, catching the rare exception where a random matrix is singular)
try:
    print("Inverse of Matrix 1:\n", np.linalg.inv(mat1))
except np.linalg.LinAlgError:
    print("Matrix 1 is singular and cannot be inverted.")

eigenvalues, eigenvectors = np.linalg.eig(mat1)
print("Eigenvalues of Matrix 1:", eigenvalues)
