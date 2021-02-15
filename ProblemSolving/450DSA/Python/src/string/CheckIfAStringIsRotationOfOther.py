"""
@author Anirudh Sharma
 
Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
(eg given s1 = ABCD and s2 = CDAB, returns true, given s1 = ABCD, and s2 = ACBD , returns false)
"""


def checkIfRotation(s1, s2):
    return len(s1) == len(s2) and (s1 + s1).count(s2) > 0


if __name__ == "__main__":
    s1 = "ABCD"
    s2 = "CDAB"
    print(checkIfRotation(s1, s2))

    s2 = "ACBD"
    print(checkIfRotation(s1, s2))