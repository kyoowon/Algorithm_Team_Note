# ```플로이드 워샬 알고리즘```


INF = int(1e9)

n = int(input())

path = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j:
            path[i][j] = 0

m = int(input())

for i in range(m):
    a, b, c = map(int, input().split())
    path[a][b] = c


for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            path[i][j] = min(path[i][j], path[i][k] + path[k][j])

