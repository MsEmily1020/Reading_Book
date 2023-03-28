scores = [10, 3, 20, 50]


def sum_list(scores):
    sum_ = 0
    for score in scores:  # scores에 있는거 하나씩 꺼내서 score에 대입
        sum_ += score  # sum_ = sum_ + score
    return sum_


def sum_list2(scores):
    sum_ = 0
    for i in range(len(scores)):    #0, 1, 2 ... scores길이 - 1
        sum_ += scores[i]
    return sum_


def sum_list3(scores):
    return sum(scores)


print(sum_list(scores))
print(sum_list3(scores))

print(list(range(10)))          # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
print(list(range(5, 10)))       # [5, 6, 7, 8, 9]
print(list(range(5, 10, 2)))    # [5, 7, 9]


# 두자리 숫자 홀수 내림차순 구하자
print(list(range(99, 10, -2)))  # [99, 97 ... 13, 11]

# 세자리 숫자 중 짝수 오름차순
print(list(range(100, 1000, 2)))    # [100, 102 ... 996, 998]