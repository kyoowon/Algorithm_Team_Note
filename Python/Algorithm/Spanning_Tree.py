# ```신장트리``` 
# - 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프
# - 모든 노드가 포함되어 서로 연결되면서 사이클이 존재하지 않는다는 조건을 만족


# 크루스칼 알고리즘
## 가능한 한 최소한 비용으로 신장크리를 찾아야할 때 활용하는 알고리즘으로 대표적인 쇠소 신장 트리 알고리즘이다.

# 1. 간선 데이터를 비용에 따라 오름차순으로 정렬한다.
# 2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인한다.
    # (1). 사이클이 발생하지 않는 경우 최소 신장 트리에 포함시킨다.
    # (2). 사이클이 발생하는 경우 최소 신장 트리에 포함시키지 않는다.
# 3. 모든 간선에 대하여 2번의 과정을 반복한다.

# 시간 복잡도는 O(ElogE)를 가진다.


## 특정 원소가 속한 집합을 찾기 - 부모노드가 바로 루트 노드로 업데이트
def Short_find_parent(parent, x):
    if parent[x] != x:
        parent[x] = Short_find_parent(parent, parent[x])
    return parent[x]

## 두 원소가 속한 집합을 합치기 - 낮은 번호가 상위 노드
def union_parent(parent, a, b):
    a = Short_find_parent(parent, a)
    b = Short_find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

# 노드의 개수와 간산의 개수를 입력받기
v, e = map(int, input().split())
# 부모 테이블 초기화
parent = [0] * (v + 1)

# 모든 테이블상에서, 부모를 자기 자신으로 초기화
edges = []
result = 0

# 부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
    parent[i] = i

# 모든 간산에 대한 정보를 입력받기
for _ in range(e):
    a, b, cost = map(int, input().split())
    # 비용순으로 정렬하기 위해서 튜플의 첫 번째 원소를 비용으로 설정
    edges.append((cost, a, b))

# 간산을 비용순으로 정렬
edges.sort()

# 간선을 하나씩 확인하며
for edge in edges:
    cost, a, b = edge
    # 사이클이 발생하지 않는 경우에만 집합에 포함
    if Short_find_parent(parent, a) != Short_find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)