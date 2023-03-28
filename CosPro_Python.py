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