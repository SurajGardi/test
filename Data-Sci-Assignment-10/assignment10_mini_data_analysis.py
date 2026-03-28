import numpy as np

# 1. Generate a dataset of 50 students with marks in 5 subjects (Marks 0-100)
# Rows = Students (50), Columns = Subjects (5)
dataset = np.random.randint(0, 101, size=(50, 5))

# 2. Calculate Total marks and Average marks for each student
total_marks = np.sum(dataset, axis=1)
average_marks = np.mean(dataset, axis=1)

# 3. Find Topper student index and Number of students scoring above 75%
topper_index = np.argmax(total_marks)
students_above_75 = np.sum(average_marks > 75)

print("Topper Student Index (0-49):", topper_index)
print("Topper Total Marks:", total_marks[topper_index])
print("Number of students averaging > 75%:", students_above_75)

# 4. Normalize the dataset (Min-Max Scaling across the whole dataset)
normalized_dataset = (dataset - np.min(dataset)) / (np.max(dataset) - np.min(dataset))
print("Normalized Dataset (First 2 students):\n", np.round(normalized_dataset[:2], 2))
