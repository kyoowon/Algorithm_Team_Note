# ''' bisect '''

# binary Search library
from bisect import bisect_left, bisect_right

# 값이 범위 [left_value, right_value]사이에 해당하는 데이터의 개수를 반환하는 함수
def countByRange(a, left_value, right_value):
    right_index = bisect_right(a, right_value)
    left_index = bisect_left(a, left_value)
    return right_index - left_index