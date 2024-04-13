scores = [10, 3, 20, 50]


def min_list(scores):
    min_ = scores[0]
    for score in scores:
        if score < min_:
            min_ = score
    return min_


print(min_list(scores))