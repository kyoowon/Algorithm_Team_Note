# 어두운 길


# 입력
# 7 11
# 0 1 7
# 0 3 5
# 1 2 8
# 1 3 9
# 1 4 7
# 2 4 5
# 3 4 15
# 3 5 6
# 4 5 8
# 4 6 9
# 5 6 11

# n, m = map(int, input().split())

# paths = []

# def find_parent(parent, a):
# 	if parent[a] != a:
# 		parent[a] = find_parent(parent, parent[a])
# 	return parent[a]

# def union_parent(parent, a, b):
# 	a = find_parent(parent, a)
# 	b = find_parent(parent, b)

# 	if a < b:
# 		parent[b] = a
# 	else:
# 		parent[a] = b

# total = 0

# for _ in range(m):
# 	x, y, cost = map(int, input().split())
# 	paths.append((cost, x, y))
# 	total += cost

# paths.sort()

# result = 0

# parent = [0] * (n + 1)

# for i in range(1, n + 1):
# 	parent[i] = i

# for path in paths:
# 	cost, a, b = path
# 	if find_parent(parent, a) != find_parent(parent, b):
# 		union_parent(parent, a, b)
# 		result += cost

# print(total - result)


# 행성 터널

n = int(input())

x = []
y = []
z = []

for i in range(1, n + 1):
	data = list(map(int, input().split()))
	x.append((data[0], i))
	y.append((data[1], i))
	z.append((data[2], i))


x.sort()
y.sort()
z.sort()

print(x)
print(y)
print(z)

paths = []

for i in range(n - 1):
	paths.append((x[i + 1][0] - x[i][0], x[i][1], x[i + 1][1]))
	paths.append((y[i + 1][0] - y[i][0], y[i][1], y[i + 1][1]))
	paths.append((z[i + 1][0] - z[i][0], z[i][1], z[i + 1][1]))

paths.sort()

def find_parent(parent, a):
	if parent[a] != a:
		parent[a] = find_parent(parent, parent[a])
	return parent[a]

def union_parent(parent, a, b):
	a = find_parent(parent, a)
	b = find_parent(parent, b)
	if a < b:
		parent[b] = a
	else:
		parent[a] = b


parent = [0] * (n + 1)

for i in range(1, n + 1):
	parent[i] = i

result = 0

print(paths)

for path in paths:
	cost, a, b = path
	if find_parent(parent, a) != find_parent(parent, b):
		union_parent(parent, a, b)
		result += cost

print(result)
		