/**
 * @author Anirudh Sharma
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the
 * order of characters.
 * 
 * No two characters may map to the same character, but a character may map to itself.
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */
const isIsomorphic = (s, t) => {
    // Lengths of the strings
    const m = s.length;
    const n = t.length;
    // If lengths are not equal, return false
    if (m !== n) {
        return false;
    }
    // Mapping of characters of s and t.
    const stMapping = new Map();
    // Boolean array to store characters which are
    // already mapped
    const visited = Array(256).fill(false);
    // Loop through the strings
    for (let i = 0; i < m; i++) {
        // Current characters of both strings
        let a = s.charAt(i);
        let b = t.charAt(i);
        // If we have already seen a
        if (stMapping.has(a)) {
            // Return false if a is mapped to different
            // character
            if (stMapping.get(a) !== b) {
                return false;
            }
        }
        // If we are seeing a for the first time
        else {
            // Return false if b is already mapped
            if (visited[b]) {
                return false;
            }
            // Otherwise do the mapping
            stMapping.set(a, b);
            visited[b] = true;
        }
    }
    return true;
};

const main = () => {
    let s = "egg";
    let t = "add";
    console.log(isIsomorphic(s, t));

    s = "foo";
    t = "bar";
    console.log(isIsomorphic(s, t));

    s = "paper";
    t = "title";
    console.log(isIsomorphic(s, t));
};

main();