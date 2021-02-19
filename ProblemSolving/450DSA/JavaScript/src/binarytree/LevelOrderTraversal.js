/**
 * @author Anirudh Sharma
 * 
 * Given a binary tree, find its level order traversal.
 * Level order traversal of a tree is breadth-first traversal for the tree.
 * 
 * Constraints:
 * 1 <= Number of nodes<= 10^4
 * 1 <= Data of a node <= 10^4
 */
const levelOrderTraversal = (root) => {
    // Special case
    if (root === undefined) {
        return undefined;
    }
    // Array to store result
    const result = [];
    // Queue to store nodes of the tree
    const nodes = [];
    // Add root to the queue
    nodes.push(root);
    // Loop until the queue is empty
    while (nodes.length > 0) {
        // Get the current node from the head
        let current = nodes.shift();
        // Add current node to the result
        result.push(current.data);
        // Check if the left child exists
        if (current.left !== null) {
            nodes.push(current.left);
        }
        // Check if the right child exists
        if (current.right !== null) {
            nodes.push(current.right);
        }
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
    console.log(levelOrderTraversal(root));

    root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    console.log(levelOrderTraversal(root));
};

main();