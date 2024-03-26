print("Hello world !")

class sort:
    def __init__(self) -> None:
        pass

    def sort_problem1(self):
        arr = [5,9,1,3,3]
        print(f"printed array: {arr} in sort_problem1")
        n = len(arr)
        for i in range(0, n-1):
            for j in range(i+1, n-1):
                if (arr[i] + arr[j] == 6):
                    return True
        return False

if __name__ == "__main__":
    sort = sort()
    flag = sort.sort_problem1()
    print(f"Return value from function: {flag}")

## Complexity analysis
## S = 1+2+3....+n-1
## S = n-1+n-2+......+3+2+1
## 2S = n+n+......+n=n*n
        
