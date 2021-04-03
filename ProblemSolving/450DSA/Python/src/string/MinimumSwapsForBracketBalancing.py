"""
@author Anirudh Sharma

You are given a string S of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets.

A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2
are balanced strings.

We can make an unbalanced string balanced by swapping adjacent characters.

Calculate the minimum number of swaps necessary to make a string balanced.

Note - Strings S1 and S2 can be empty.
"""


def minimumNumberOfSwaps(S):
    # Number of swaps required
    swaps = 0
    # Special case
    if S is None or len(S) == 0:
        return swaps
    # Variable to track open brackets
    openBrackets = 0
    # Loop through the string
    for c in S:
        # If we encounter the left bracket,
        # we will increment the count
        if c == '[':
            openBrackets += 1
        # If we encounter the right bracket,
        # then any of the two conditions can
        # happen
        else:
            # If there are open brackets to the
            # left of the current bracket,
            # close the last encountered open
            # bracket
            if openBrackets != 0:
                openBrackets -= 1
            # If not, we will have to perform
            # swap
            else:
                swaps += 1
                # Reset the count of open brackets
                openBrackets = 1
    # We will need n/2 inversions for extra open brackets
    # to make the string balanced
    return swaps + openBrackets // 2


if __name__ == "__main__":
    S = "[]][]["
    print(minimumNumberOfSwaps(S))

    S = "[[][]]"
    print(minimumNumberOfSwaps(S))

    S = "][][]["
    print(minimumNumberOfSwaps(S))
