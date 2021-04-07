/**
 * @author Anirudh Sharma
 * 
 * Given a list of word lists, print all sentences possible taking one word from a list at a time via recursion
 */
const generateSentences = (words) => {
    // List to store the result
    const sentences = Array(words.length);
    // Consider all words for first row as starting
    // point and generate all sentences
    for (let i = 0; i < words[0].length; i++) {
        if (words[0][i] !== "") {
            generateSentencesHelper(words, 0, i, sentences);
        }
    }
};

const generateSentencesHelper = (words, i, j, sentences) => {
    // Add current word to the sentences list
    sentences[i] = words[i][j];
    // If this is the last word of the current output
    // sequence, then print it
    if (i === words.length - 1) {
        const sentence = [];
        for (let k = 0; k < words.length; k++) {
            sentence.push(sentences[k] + " ");
        }
        console.log(sentence.join(''));
        console.log();
        return;
    }
    // Recur for next row
    for (let k = 0; k < words[0].length; k++) {
        if (words[i + 1][k] !== "") {
            generateSentencesHelper(words, i + 1, k, sentences);
        }
    }
};

const main = () => {
    const words = [["you", "we", ""],
    ["have", "are", ""],
    ["sleep", "eat", "drink"]
    ];
    generateSentences(words);
};

main();