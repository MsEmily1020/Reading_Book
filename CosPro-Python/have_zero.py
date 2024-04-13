def make_list(n):
    list_ = []
    for _ in range(n):
        list_.append(0)
    return list_
    # return [0 for i in range(n)]


print(make_list(6))