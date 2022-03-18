
# Circular List

# n - 원형의 사이즈, data - 약점이 되는 부분
n = 12
data = [1, 5, 6, 10]

## 원형 탐색을 위한 리스트 확장
for i in range(len(data)):
    data.append(data[i] + n)