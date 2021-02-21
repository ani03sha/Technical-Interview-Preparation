/**
 * @author Anirudh Sharma
 * 
 * Given a Binary Tree, print Left view of it.
 * Left view of a Binary Tree is set of nodes visible when tree is visited from Left side.
 */
const leftView = (root) => {
    // Array to store the result
    const result = [];
    // Special case
    if (root === null) {
        return result;
    }
    // Queue to store the nodes of the tree
    const nodes = [];
    // Add root node to the stack
    nodes.push(root);
    // Loop until the queue is empty
    while (nodes.length > 0) {
        // Get the size of the queue
        let size = nodes.length;
        // Loop until the size
        for (let i = 0; i < size; i++) {
            // Get the current node
            let current = nodes.shift();
            // If it is the first node at the current level,
            // add it to the result
            if (i === 0) {
                result.push(current.data);
            }
            // Move to the left child if exists
            if (current.left !== null) {
                nodes.push(current.left);
            }
            // Move to the right child if exists
            if (current.right !== null) {
                nodes.push(current.right);
            }
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
    console.log(leftView(root));

    root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    console.log(leftView(root));

    root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    console.log(leftView(root));
};

main();