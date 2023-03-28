scores = [10, 3, 20, 50]


def avg_list(scores):
    len_ = 0
    sum_ = 0
    for score in scores:
        sum_ += score
        len_ += 1
    return sum_ / len_


print(avg_list(scores))