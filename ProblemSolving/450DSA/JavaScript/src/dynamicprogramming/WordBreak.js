/**
 * @author Anirudh Sharma
 * 
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented
 * into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
const wordBreak = (s, wordDict) => {
    // Lookup table
    const dp = new Map();
    let max = 0;
    for (let word of wordDict) {
        max = Math.max(max, word.length);
    }
    return wordBreakHelper(s, wordDict, 0, max, dp);
};

const wordBreakHelper = (s, wordDict, start, max, dp) => {
    if (start === s.length) {
        return true;
    }
    if (dp.has(start)) {
        return dp.get(start);
    }
    for (let i = start; i < start + max && i < s.length; i++) {
        let newWord = s.substring(start, i + 1);
        if (!wordDict.includes(newWord)) {
            continue;
        }
        if (wordBreakHelper(s, wordDict, i + 1, max, dp)) {
            dp.set(start, true);
            return true;
        }
    }
    dp.set(start, false);
    return false;
};

const main = () => {
    let s = "leetcode";
    let wordDict = ["leet", "code"];
    console.log(wordBreak(s, wordDict));

    s = "applepenapple";
    wordDict = ["apple", "pen"];
    console.log(wordBreak(s, wordDict));

    s = "catsandog";
    wordDict = ["cats", "dog", "sand", "and", "cat"];
    console.log(wordBreak(s, wordDict));
};

main();