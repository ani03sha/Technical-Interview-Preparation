/**
 * @author Anirudh Sharma
 * 
 * Given a binary tree of size N, find its reverse level order traversal i.e.,
 * the traversal must begin from the last level.
 * 
 * Constraints:
 * 1 ≤ N ≤ 10^4
 */
const reverseLevelOrderTraversal = (root) => {
    // Array to store result
    const result = [];
    // Special case
    if (root === undefined) {
        return result;
    }
    // Queue to store nodes of the tree
    const nodes = [];
    // Stack to store the nodes for reverse level order traversal
    const reverseLOT = [];
    // Add root to the queue
    nodes.push(root);
    // Loop until the queue is empty
    while (nodes.length > 0) {
        // Get the current node from the head
        let current = nodes.shift();
        // Add current node to the result
        reverseLOT.unshift(current.data);
        // Check if the right child exists
        if (current.right !== null) {
            nodes.push(current.right);
        }
        // Check if the left child exists
        if (current.left !== null) {
            nodes.push(current.left);
        }
    }
    // Pop all the nodes from the stack and
    // add them to the result
    while (reverseLOT.length > 0) {
        result.push(reverseLOT.shift());
    }
    return result;
};

function Node(data, left, right) {
    this.data = (data === undefined ? 0 : data);
    this.left = (left === undefined ? null : left);
    this.right = (right === undefined ? null : right);
}

const main = () => {
    let root = new Node(1);
    root.left = new Node(3);
    root.right = new Node(2);
    console.log(reverseLevelOrderTraversal(root));

    root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    console.log(reverseLevelOrderTraversal(root));
};

main();