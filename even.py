scores = [10, 3, 20, 50]


def count_even(scores):
    cnt = 0
    for score in scores:
        if score % 2 == 0:
            cnt += 1
    return cnt


print(count_even(scores))