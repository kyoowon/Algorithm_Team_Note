
# ```최단 경로```

# 최단 경로 한 노드에서 특정 노드까지 혹은 모든 노드에서 모든 노드까지에 대한 경로 탐색


# ```다익스트라 알고리즘```
# 다익스트라 알고리즘은 한 노드에서 특정 노드까지에 대한 최단 경로를 탐색하는데 사용

# 1. 출발 노드를 설정한다.
# 2. 최단 거리 테이블을 초기화한다.
# 3. 방문하지 않는 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
# 4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
# 5. 위 과정에서 3, 4번을 반복한다.

# 시간 복잡도는 O(ElogV)

# 우선순위 큐를 활용해 비용이 가장 적은 것부터 추출
import heapq
INF = int(1e9)

# 노드의 개수, 간선의 개수를 입력받기
n, m = map(int, input().split())

# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
graph = [[] * (n + 1) for _ in range(n + 1)]

# 모든 간선의 정보를 입력
for i in range(m):
    a, b, cost = map(int, input().split())
    graph[a].append((b, cost))

# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

def dijkstra(start):
    q = []
    # 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q: # 큐가 비어있지 않다면
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(int(input()))