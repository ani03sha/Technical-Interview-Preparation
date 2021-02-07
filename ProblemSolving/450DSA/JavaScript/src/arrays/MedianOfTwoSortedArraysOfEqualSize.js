/**
 * @author Anirudh Sharma
 * 
 * There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the
 * array obtained after merging the above 2 arrays(i.e. array of length 2n).
 * 
 * The complexity should be O(log(n)).
 */
const findMedian = (a, b, n) => {
    // Special cases
    if (n === 0) {
        return -1;
    }
    if (n === 1) {
        return parseInt((a[0] + b[0]) / 2);
    }
    if (n === 2) {
        return parseInt((Math.max(a[0], b[0]) + Math.min(a[1], b[1])) / 2);
    }
    // Get the medians of the individual arrays
    let ma = n % 2 == 0 ? parseInt((a[parseInt(n / 2)] + a[parseInt(n / 2) - 1]) / 2) : a[parseInt(n / 2)];
    let mb = n % 2 == 0 ? parseInt((b[parseInt(n / 2)] + b[parseInt(n / 2) - 1]) / 2) : b[parseInt(n / 2)];
    // If ma and mb are equal then return either of those
    if (ma === mb) {
        return ma;
    }
    // If ma is less than mb then median must lie in a[...ma] and b[mb...]
    if (ma < mb) {
        return n % 2 === 0
            ? findMedian(a.slice(parseInt(n / 2) - 1), b, n - parseInt(n / 2) + 1)
            : findMedian(a.slice(parseInt(n / 2)), b, n - parseInt(n / 2));
    }
    // If ma is greater than mb then median must lie in a[ma...] and b[...mb]
    return n % 2 === 0
        ? findMedian(b.slice(parseInt(n / 2) - 1), a, n - parseInt(n / 2) + 1)
        : findMedian(b.slice(parseInt(n / 2)), a, n - parseInt(n / 2));
};


let A = [1, 2, 3, 6];
let B = [4, 6, 8, 10];
console.log(findMedian(A, B, 4));

A = [1, 2, 15, 26, 38];
B = [2, 13, 17, 30, 45];
console.log(findMedian(A, B, 5));