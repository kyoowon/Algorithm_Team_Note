# 서로소 집합 - 공통 원소가 없는 두 집합. ( Union - find )
# - 서로소 부분 집합들로 나누어진 원소들의 데이터를 처리하기 위한 자료구조
# - 트리의 구조를 활용해서 구현 ( 부모 리스트를 만들어서 재귀적으로 올라가 확인 )

# 1. union 연산을 확인하여, 서로 연결된 두 노드 A, B를 확인한다.
    # (1). A와 B의 루트노드 A', B'를 각각 찾는다.
    # (2). A'를 B'의 부모 노드로 설정한다.
# 2. 모든 union(합집합) 연산을 처리할 때까지 1번 과정을 반복한다.

## 특정 원소가 속한 집합을 찾기 - O(V)로 비효율
def find_parent(parent, x):
    # 루트노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

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

# 부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
    parent[i] = i


# /*****************************/
# 트리 구조를 활용한 서로소 판별

# union 연사을 각각 수행
for i in range(e):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

# 각 원소가 속한 집합 출력
print('각 원소가 속한 집합 : ', end='')
for i in range(1, v + 1):
    print(Short_find_parent(parent, i), end=' ')

print()

# 부모 테이블 내용 출력
print('부모 테이블 : ', end=' ')
for i in range(1, v + 1):
    print(parent[i], end=' ')

# /*****************************/
# 사이클 판별 - 간선에 방향성이 없는 무향 그래프에서만 적용이 가능하다.

# 사이클 발생 여부
cycle = False

for i in range(e):
    a, b = map(int, input().split())
    # 사이클이 발생한 경우 종료
    if Short_find_parent(parent, a) == Short_find_parent(parent, b):
        cycle = True
        break
    # 사이클이 발생하지 않는다면 합집합 수행  
    else:
        union_parent(parent, a, b)