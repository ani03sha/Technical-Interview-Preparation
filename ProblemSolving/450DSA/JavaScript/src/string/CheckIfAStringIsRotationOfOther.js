/**
 * @author Anirudh Sharma
 * 
 * Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
 * (eg given s1 = ABCD and s2 = CDAB, returns true, given s1 = ABCD, and s2 = ACBD , returns false)
 */
const checkIfRotation = (s1, s2) => {
    return (s1.length === s2.length && (s1 + s1).includes(s2));
};

const main = () => {
    let s1 = "ABCD";
    let s2 = "CDAB";
    console.log(checkIfRotation(s1, s2));

    s2 = "ACBD";
    console.log(checkIfRotation(s1, s2));
};

main();