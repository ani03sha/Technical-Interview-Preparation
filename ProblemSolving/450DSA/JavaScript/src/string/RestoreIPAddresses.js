/**
 * @author Anirudh Sharma
 * 
 * Given a string s containing only digits, return all possible valid IP addresses that
 * can be obtained from s. You can return them in any order.
 * 
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255,
 * separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and
 * "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1"
 * are invalid IP addresses.
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 3000
 * s consists of digits only
 */
const restoreIpAddresses = (s) => {
    // List to store all the IP addresses
    const ipAddresses = [];
    // Array to store four parts of the IP address
    const ipAddressParts = Array(4);
    // Call the helper function to get the IP addresses
    getIPAddresses(s, ipAddresses, 0, ipAddressParts, 0);
    return ipAddresses;
};

const getIPAddresses = (s, ipAddresses, currentIndex, ipAddressParts, segment) => {
    // Base case when the current index is at the end of
    // the string and we have found all four segments
    if (segment === 4 && currentIndex === s.length) {
        ipAddresses.push(ipAddressParts[0] + "." + ipAddressParts[1] + "." + ipAddressParts[2] + "." + ipAddressParts[3]);
        return;
    }
    // If either of the above conditions is met but not both
    else if (segment === 4 || currentIndex === s.length) {
        return;
    }
    // Loop through the string to find the segments
    for (let i = 1; i <= 3 && currentIndex + i <= s.length; i++) {
        // Get the current segment of string
        let value = parseInt(s.substring(currentIndex, currentIndex + i));
        // Check for the validity of value
        if (value > 255 || i >= 2 && s.charAt(currentIndex) === '0') {
            break;
        }
        // If valid, add it to the segment
        ipAddressParts[segment] = value;
        // Recurse for the next part of the string
        getIPAddresses(s, ipAddresses, currentIndex + i, ipAddressParts, segment + 1);
        ipAddressParts[segment] = -1;
    }
};

const main = () => {
    let s = "25525511135";
    console.log(restoreIpAddresses(s));

    s = "0000";
    console.log(restoreIpAddresses(s));

    s = "1111";
    console.log(restoreIpAddresses(s));

    s = "010010";
    console.log(restoreIpAddresses(s));

    s = "101023";
    console.log(restoreIpAddresses(s));
};

main();