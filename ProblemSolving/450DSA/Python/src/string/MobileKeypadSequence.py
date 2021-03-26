"""
@author Anirudh Sharma

Given a sentence in the form of a string, convert it into its equivalent mobile
numeric keypad sequence.
"""


def convert(input):
    # Array to store all the possible combinations
    inputMap = [
        "2", "22", "222",
        "3", "33", "333",
        "4", "44", "444",
        "5", "55", "555",
        "6", "66", "666",
        "7", "77", "777", "7777",
        "8", "88", "888",
        "9", "99", "999", "9999"
    ]
    # String to store output
    output = ""
    # Loop through the input string
    for i in range(len(input)):
        if input[i] == ' ':
            output += "0"
        else:
            output += inputMap[ord(input[i]) - ord('A')]
    return output


if __name__ == "__main__":
    input = "ANIRUDH"
    print(convert(input))

    input = "RED QUARK"
    print(convert(input))
