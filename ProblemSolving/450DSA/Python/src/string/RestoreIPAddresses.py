"""
@author Anirudh Sharma

Given a string s containing only digits, return all possible valid IP addresses that
can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255,
separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and
"192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1"
are invalid IP addresses.

Constraints:

0 <= s.length <= 3000
s consists of digits only
"""


def getIPAddresses(s, ipAddresses, currentIndex, ipAddressParts, segment):
    # Base case when the current index is at the end of
    # the string and we have found all four segments
    if segment == 4 and currentIndex == len(s):
        ipAddresses.append(str(ipAddressParts[0]) + "." + str(ipAddressParts[1]) +
                        "." + str(ipAddressParts[2]) + "." + str(ipAddressParts[3]))
        return
    # If either of the above conditions is met but not both
    elif segment == 4 or currentIndex == len(s):
        return
    # Loop through the string to find the segments
    for i in range(1, 4):
        # Get the current segment of string
        currentValue = s[currentIndex: currentIndex + i]
        if len(currentValue) != 0:
            currentValue = int(s[currentIndex:currentIndex + i])
            # Check for the validity of value
            if currentValue > 255 or i >= 2 and s[currentIndex] == '0':
                break
            # If valid, add it to the segment
            ipAddressParts[segment] = currentValue
            # Recurse for the next part of the string
            getIPAddresses(s, ipAddresses, currentIndex +
                        i, ipAddressParts, segment + 1)
            ipAddressParts[segment] = -1


def restoreIpAddresses(s):
    # List to store all the IP addresses
    ipAddresses = []
    # List to store four parts of the IP address
    ipAddressParts = [0] * 4
    # Call the helper function to get the IP addresses
    getIPAddresses(s, ipAddresses, 0, ipAddressParts, 0)
    return ipAddresses


if __name__ == "__main__":
    s = "25525511135"
    print(restoreIpAddresses(s))

    s = "0000"
    print(restoreIpAddresses(s))

    s = "1111"
    print(restoreIpAddresses(s))

    s = "010010"
    print(restoreIpAddresses(s))

    s = "101023"
    print(restoreIpAddresses(s))
