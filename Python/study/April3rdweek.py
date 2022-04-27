<<<<<<< HEAD
# # def solution(price, money, count):
# #     cost = ((1 * price) + (count * price)) * (count // 2)
# #     # count 홀수인 경우
# #     if count % 2 != 0:
# #         cost += ((count // 2) + 1) * price
# #     answer = 0    
# #     if cost > money:
# #         answer = cost - money
# #     return answer

# # # 놀이기구의 이용료는 price - 놀이기구를 n번째 이용한다면 이용료의 N배를 받기로
# # # 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마나 모자른지를 return
# # # 시간 복잡도를 N(1)로 만들기 위해서 위와 같은 로직을 작성


# # def solution(sizes):
# #     row, col = 0, 0
# # #     명함의 가로, 세로 중 큰 값을 가로로 작은 값을 세로로 두어 가로 중에 큰 값, 세로 중에 큰 값으로 계산
# #     for size in sizes:
# #         a, b = size
# #         if a < b:
# #             row = max(b, row)
# #             col = max(a, col)
# #         else:
# #             row = max(a, row)
# #             col = max(b, col)
# #     answer = row * col
# #     return answer

# # # 가로 세로 명함들의 사이즈 중에 가장 큰 명함에 맞춰서 지갑을 제작
# # # 가로 세로의 길이를 서로 바꿀 수 있도록 함

# # # 결과를 저장하는 변수
# # result = 0
# # # dfs
# # def dfs(k, dungeons, visited, count):
# #     global result
# # #    dungeons에서 탐색하지 않는 부분을 탐색
# #     for i in range(len(dungeons)):
# #         if not visited[i] and k >= dungeons[i][0]:
# #             visited[i] = True
# #             dfs(k - dungeons[i][1], dungeons, visited, count + 1)
# #             visited[i] = False
# #     print(visited)
# #     result = max(result, count)

# # def solution(k, dungeons):
# #     global result
# #     visited = [False] * len(dungeons)
# #     count = 0
# #     dfs(k, dungeons, visited, count)
# #     return result

# # # 던전을 탐험하기 필요한 최소 필요 피로도와 던전 탐험을 마쳤을 때 소모되는 소모 피로도
# # # 던전을 최대한 많이 탐험하려고 한다.

# INF = int(1e15)

# def solution(line):
#     answer = []
# #     좌표값을 저장하는 리스트
#     spots = []
# #     별찍기를 위한 가로, 세로 길이
#     min_x, max_x, min_y, max_y = INF, -INF, INF, -INF
#     for i in range(len(line)):
#         a, b, e = line[i]
#         for j in range(i + 1, len(line)):
#             c, d, f = line[j]
#             if ( a * d ) - ( b * c ) != 0:
#                 x = (( b * f ) - ( e * d )) / (( a * d ) - ( b * c ))
#                 y = (( e * c ) - ( a * f )) / (( a * d ) - ( b * c ))
#                 if x - int(x) == 0 and y - int(y) == 0:
#                     min_x = min(min_x, int(x))
#                     max_x = max(max_x, int(x))
#                     min_y = min(min_y, int(y))
#                     max_y = max(max_y, int(y))
#                     spots.append((int(x), (int(y))))
# #   별찍기 - O(r * c)
#     for j in range(max_y, min_y - 1, -1):
#         temp = ""
#         for i in range(min_x, max_x + 1):
#             if (i, j) in spots:
#                 temp += '*'
#             else:
#                 temp += '.'
#         answer.append(temp)
#     return answer

# # line으로 주어진 선들을 그려서 선들이 곂쳐지는 점들을 표현
# # 교점에 대한 계산을 각각으로 실행

from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# 블록을 발견 했을 때, 해당 블록을 떼내는 함수 - bfs로 탐색하며
def findTable(table, a, b):
    q = deque()
    q.append((a, b))
    temp = []
    while q:
        x, y = q.popleft()
        temp.append((x, y))
        table[x][y] = 2
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < len(table) and 0 <= ny < len(table[0]):
                if table[nx][ny] == 1:
                    q.append((nx, ny))
                    
#     따로 블록을 형성 - 좌표로 된 값을 그래프 형태로 - 회전에 용이
    k = sorted(temp, key = lambda x:x[0])
    l = sorted(temp, key = lambda x:x[1])
    length = max(k[-1][0] - k[0][0], l[-1][1] - l[0][1]) + 1
    block = [[0] * length for _ in range(length)]
#   y 축으로 정렬된 값을 통해 각각에 매칭 되는 값으로 그래프 생성
    start = 0
    if l[0] != k[0]:
        start = k[0][0] - l[0][0]
    for x, y in k:
        block[x - a][y - b - start] = 1
    return block

#   블록을 회전하는 함수
def rotate_a_matrix_by_90_degree(a):
    row_length = len(a)
    column_length = len(a[0])
    res = [[0] * row_length for _ in range(column_length)]
    for r in range(row_length):
        for c in range(column_length):
            res[c][row_length - 1 - r] = a[r][c]
    a.clear()
    return res

#  만약 board에 빈공간을 찾았을 때 이를 매칭
def isMatching(board, block, board_x, board_y):
    block_x = 0
    block_y = 0
    if block[0][0] == 0:
        for i in range(len(block)):
            for j in range(len(block[0])):
                if block[i][j] != 0:
                    block_x = i
                    block_y = j
                    break
            if block_x != 0 or block_y != 0:
                break
    result = []
    # bfs 탐색
    q = deque()
    q.append((board_x, board_y, block_x, block_y))
    print()
    print(q)
    while q:
        board_a, board_b, block_a, block_b = q.popleft()
        result.append((board_a, board_b))
        for i in range(4):
            nx = dx[i] + board_a
            ny = dy[i] + board_b
            nblock_x = dx[i] + block_a
            nblock_y = dy[i] + block_b
            if 0 <= nx < len(board) and 0 <= ny < len(board[0]):
                if board[nx][ny] == 0:
                    if 0 <= nblock_x < len(block) and 0 <= nblock_y < len(block[0]):
                        print(nx, ny, nblock_x, nblock_y)
                        if board[nx][ny] == 0 and block[nblock_x][nblock_y] == 1 and (nx, ny) not in result:
                            q.append((nx, ny, nblock_x, nblock_y))
                        elif board[nx][ny] == 1 and block[nblock_x][nblock_y] == 0:
                            continue
                        return 0
                    else:
                        return 0
    count = 0
    for c, d in result:
        board[c][d] = 1
        count += 1
    print("board")
    for i in range(len(board)):
        print(board[i])
    print("block")
    for i in range(len(block)):
        print(block[i])
    print()
    return count
    
# 퍼즐에 매칭을 할 건데 이때 board에서 0인 부분을 찾기
def matchingPuzzle(board, block):
    count = 0
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 0:
                count += isMatching(board, block, i, j)
    return count
    

def solution(game_board, table):
    # 블록들을 담을 공간
    blocks = []
    answer = 0
    # 블록을 탐색
    for i in range(len(table)):
        for j in range(len(table[0])):
            # 만약 1인 블록이 있는 경우 - 탐색
            if table[i][j] == 1:
                blocks.append(findTable(table, i, j))
    # 모든 블록을 가지고 맞춰보기 - 하나씩
    for block in blocks[:1]:
        # 하나의 블록으로 총 4가지 방향으로 탐색
        for _ in range(4):
            block = rotate_a_matrix_by_90_degree(block)
            answer += matchingPuzzle(game_board, block)
    
    return answer


solution([[0,0,0],[1,1,0],[1,1,1]], [[1,1,1],[1,0,0],[0,0,0]])


# 조각은 한 번에 하나씩 채워 넣는다.
# 조각을 회전할 수 있다.
# 채워넣었을 때 퍼즐 조각과 인접한 칸이 비어있으면 안된다.
# 완전히 맞는 공간에 채워야 한다.
# 최대로 넣었을 때 채워지는 칸의 수를 return

#  1. table에서 블록을 발견
#  2. 블록은 떼서 담아둔다.
#  3. 이를 game_board에서 찾기
#     - (1). 만약 game_board에서 해당 블록을 찾을 수 없는 경우
#     - (2). 블록을 회전
#     - (3). 만약 찾는 경우 해당 board 공간에 block으로 채운다.
#     - (4). 이를 총 4번 반복
