
# Circular List

# n - 원형의 사이즈, data - 약점이 되는 부분
n = 12
data = [1, 5, 6, 10]

## 원형 탐색을 위한 리스트 확장
for i in range(len(data)):
    data.append(data[i] + n)



# matrix

# 2차원 리스트를 90도 회전하는 메서드

def rotate_a_matrix_by_90_degree(a):
    row_length = len(a)
    column_length = len(a[0])

    res = [[0] * row_length for _ in range(column_length)]
    for r in range(row_length):
        for c in range(column_length):
            res[c][row_length - 1 - r] = a[r][c]

    return res