#sum

# Python 방식
def sum_list1(scores):
    sum_ = 0
    for score in scores:
        sum_ += score
    return sum_

print(sum_list1([3, 28, 4, 34, 2023]))


# C, Java 방식
def sum_list2(scores):
    sum_ = 0
    for i in range(len(scores)):
        sum_ += scores[i]
    return  sum_

print(sum_list2([3, 28, 4, 34, 2023]))

def sum_list3(scores):
    return sum(scores)

print(sum_list3([3, 28, 4, 34, 2023]))
print(sum([3, 28, 4, 34, 2023]))

#count

# Python 방식
def count_list1(scores):
    count_ = 0
    for score in scores:
        count_ += 1
    return count_

print(count_list1([3, 28, 4, 34, 2023]))


# C, Java 방식
def count_list2(scores):
    count_ = 0
    for i in range(len(scores)):
        count_ += 1
    return  count_

print(count_list2([3, 28, 4, 34, 2023]))

def count_list3(scores):
    return len(scores)

print(count_list3([3, 28, 4, 34, 2023]))
print(len([3, 28, 4, 34, 2023]))


#max

def max_list1(scores):
    max_ = scores[0]
    for score in scores:
        if score > max_ :
            max_ = score
    return max_

print(max_list1([3, 28, 4, 34, 2023]))
print(max([3, 28, 4, 34, 2023]))

#min

def min_list1(scores):
    min_ = scores[0]
    for score in scores:
        if min_ > score :
            min_ = score
    return min_

print(min_list1([3, 28, 4, 34, 2023]))
print(min([3, 28, 4, 34, 2023]))

#make_list

def make_list(n):
    empty_list = []
    for i in range(n):
        empty_list.append(0)
    return empty_list

print(make_list(6))
zero_list = [0 for i in range(6)]
print(zero_list)

def solution(s):
    s_lst = list(s)
    n = len(s)
    for i in range(n):
        if s_lst[i] == 'a':
            s_lst[i] = 'z'
        elif s_lst[i] == 'z':
            s_lst[i] =  'a'
    return "".join(s_lst)           #리스트 -> 문자열로 바꿈

print(solution("abz"))


def solution2(price, money):
    answer = 0
    sum_ = sum(price)

    # 구매 금액보다 지불 금액이 작은 경우에는 -1을 return 해주세요.
    if sum_ > money:
        answer = -1
    else :
        answer = money - sum_
    return answer

print(solution2([2100, 3200, 2100, 800], 10000))


# 2차원 리스트 -> 1차원 리스트
# 정렬 [0]: 제일 작은 수, [맨끝수]: 제일 큰 수
# [인덱스]

def solution3(arr, k):
    answer = 0
    list_ = []
    for line in arr:                # [5, 12, 4, 31]...[24, 13, 11, 2]...
        for n in line:              # 5...12...4...31
            list_.append(n)
    list_.sort()                    # 오름차순 정렬
    return list_[k - 1]

print(solution3([[5,12,4,31],[24,13,11,2],[43,44,19,26],[33,65,20,21]], 4))