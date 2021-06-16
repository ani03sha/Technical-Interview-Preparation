"""
@author Anirudh Sharma

Given a string s and a dictionary of strings wordDict, return true if s can be segmented
into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
"""


def wordBreakHelper(s, wordDict, start, maxLength, dp):
    if start == len(s):
        return True
    if start in dp.keys():
        return dp[start]
    i = start
    while i < (start + maxLength) and i < len(s):
        newWord = s[start:i+1]
        if newWord in wordDict and wordBreakHelper(s, wordDict, i + 1, maxLength, dp):
            dp[start] = True
            return True
        i += 1
    dp[start] = False
    return False


def wordBreak(s, wordDict):
    dp = {}
    maxLength = 0
    for word in wordDict:
        maxLength = max(maxLength, len(word))
    return wordBreakHelper(s, wordDict, 0, maxLength, dp)


if __name__ == "__main__":
    s = "leetcode"
    wordDict = ["leet", "code"]
    print(wordBreak(s, wordDict))

    s = "applepenapple"
    wordDict = ["apple", "pen"]
    print(wordBreak(s, wordDict))

    s = "catsandog"
    wordDict = ["cats", "dog", "sand", "and", "cat"]
    print(wordBreak(s, wordDict))
