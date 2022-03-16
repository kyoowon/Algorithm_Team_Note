
# Circular List

# n - 원형의 사이즈, weak - 약점이 되는 부분
n = 12
weak = [1, 5, 6, 10]

#     원형 탐색을 위한 리스트 확장
for i in range(len(weak)):
    weak.append(weak[i] + n)