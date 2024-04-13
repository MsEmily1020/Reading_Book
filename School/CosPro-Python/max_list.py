scores = [10, 3, 20, 50]


def max_list(scores):
    max_ = scores[0]
    for score in scores:
        if score > max_:
            max_ = score
    return max_


print(max_list(scores))