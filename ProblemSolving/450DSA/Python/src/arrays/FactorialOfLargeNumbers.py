"""
@author Anirudh Sharma

Given an integer, the task is to find factorial of the number.
"""


def multiply(value, factorial, digits):
    # Carry
    carry = 0
    # Multiply value with every element of array
    for i in range(digits):
        product = factorial[i] * value + carry
        factorial[i] = product % 10
        carry = product // 10
    # Put carry in factorial and increase digits
    while carry != 0:
        factorial[digits] = carry % 10
        carry //= 10
        digits += 1
    return digits


def findFactorial(n):
    # List to store the digits of a factorial
    factorial = [0] * 2568
    # Initialize the factorial
    factorial[0] = 1
    # Number of digits in the factorial
    digits = 1
    # Loop from 2 to n
    for i in range(2, n + 1):
        digits = multiply(i, factorial, digits)
    factorial = factorial[0:digits]
    factorial.reverse()
    joinedFactorial = [str(int) for int in factorial]
    return "".join(joinedFactorial)


if __name__ == "__main__":
    print(findFactorial(10))
    print(findFactorial(50))
    print(findFactorial(100))
    print(findFactorial(500))
    print(findFactorial(1000))
