/**
 * @author Anirudh Sharma
 *
 * Given a binary tree, write an iterative and recursive solution to traverse the tree using preorder traversal.
 */
const postorderTraversalRecursively = (root) => {
    if (root === null) {
        return null;
    }
    postorderTraversalRecursively(root.left);
    postorderTraversalRecursively(root.right);
    console.log(root.data);
};

const postorderTraversalIteratively = (root) => {
    if (root === null) {
        return null;
    }
    // Stack to store the nodes of the tree
    const nodes = [];
    // Add root to the stack
    nodes.push(root);
    // Another stack to store the post order traversal
    const postOrder = [];
    // Loop until the stack is not empty
    while (nodes.length > 0) {
        // Get the current node from the stack
        let current = nodes.pop();
        postOrder.push(current.data);
        // Push left child of the tree to stack if not null
        if (current.left !== null) {
            nodes.push(current.left);
        }
        // Push right child of the tree to stack if not null
        if (current.right !== null) {
            nodes.push(current.right);
        }
    }
    while (postOrder.length > 0) {
        console.log(postOrder.pop());
    }
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
    console.log("Recursively:");
    postorderTraversalRecursively(root);
    console.log("Iteratively:");
    postorderTraversalIteratively(root);
    console.log();

    root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    console.log("Recursively:");
    postorderTraversalRecursively(root);
    console.log("Iteratively:");
    postorderTraversalIteratively(root);
    console.log();

    root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    console.log("Recursively:");
    postorderTraversalRecursively(root);
    console.log("Iteratively:");
    postorderTraversalIteratively(root);
    console.log();
};

main();