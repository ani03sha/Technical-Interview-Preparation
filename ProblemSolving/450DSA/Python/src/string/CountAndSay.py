"""
@author Anirudh Sharma

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
which is then converted into a different digit string.

To determine how you "say" a digit string, split it into the minimal number of groups
so that each group is a contiguous section all of the same character.

Then for each group, say the number of characters, then say the character.

To convert the saying into a digit string, replace the counts with a number
and concatenate every saying.

Constraints:
1 <= n <= 30
"""


def countAndSay(n):
    # Base case
    if n <= 0:
        return None
    # Initialize the result
    result = "1"
    # Counter for n
    i = 1
    # Loop until we reach n
    while i < n:
        # Store the intermediate results
        s = ""
        # Variable to count the number of occurrences of
        # the digit
        count = 1
        # Loop through the previous version of the string
        for j in range(1, len(result)):
            # Check if contiguous characters are same
            if result[j] == result[j - 1]:
                count += 1
            else:
                s += str(count)
                s += result[j - 1]
                # Reset the count to 1
                count = 1
        # For the last character
        s += str(count)
        s += result[len(result) - 1]
        result = s
        i += 1
    return result


if __name__ == "__main__":
    print(countAndSay(1))
    print(countAndSay(4))
