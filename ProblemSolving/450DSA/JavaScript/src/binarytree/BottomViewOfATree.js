const TreeMap = require("treemap-js");
/**
 * @author Anirudh Sharma
 * <p>
 * Given a binary tree, print the bottom view from left to right.
 * A node is included in bottom view if it can be seen when we look at the tree from bottom.
 * <p>
 * Constraints:
 * 1 <= Number of nodes <= 10^5
 * 1 <= Data of a node <= 10^5
 */
const bottomView = (root) => {
    // Array to store the result
    const result = [];
    // Special case
    if (root === null) {
        return result;
    }
    // Horizontal distance for a node.
    // It will be zero for the root node.
    let horizontalDistance = 0;
    // TreeMap to store the keys in sorted order.
    const treeMap = new TreeMap();
    // Queue for level order traversal.
    const nodes = [];
    // Initialize the values
    root.horizontalDistance = horizontalDistance;
    nodes.push(root);
    // Loop until the queue is empty.
    while (nodes.length > 0) {
        // Get the node from the head
        let current = nodes.shift();
        // Get the current horizontal distance
        horizontalDistance = current.horizontalDistance;
        // Put the dequeued tree node to TreeMap having key
        // as horizontal distance. Every time we find a node
        // having same horizontal distance we need to replace
        // the data in the map.
        treeMap.set(horizontalDistance, current.data);
        // Check for left and right children
        if (current.left != null) {
            current.left.horizontalDistance = horizontalDistance - 1;
            nodes.push(current.left);
        }
        if (current.right != null) {
            current.right.horizontalDistance = horizontalDistance + 1;
            nodes.push(current.right);
        }
    }
    // Populate the result list
    treeMap.each((value, key) => {
        result.push(value);
    });
    return result;
};

function Node(data, horizontalDistance, left, right) {
    this.data = (data === undefined ? 0 : data);
    this.horizontalDistance = (horizontalDistance === undefined ? 0 : horizontalDistance);
    this.left = (left === undefined ? null : left);
    this.right = (right === undefined ? null : right);
}

const main = () => {
    let root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);
    root.left.left = new Node(5);
    root.left.right = new Node(3);
    root.right.left = new Node(4);
    root.right.right = new Node(25);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);
    console.log(bottomView(root));
};

main();