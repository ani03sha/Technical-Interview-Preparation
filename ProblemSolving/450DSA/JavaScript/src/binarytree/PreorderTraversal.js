/**
 * @author Anirudh Sharma
 *
 * Given a binary tree, write an iterative and recursive solution to traverse the tree using preorder traversal.
 */
const preorderTraversalRecursively = (root) => {
    if (root === null) {
        return null;
    }
    console.log(root.data);
    preorderTraversalRecursively(root.left);
    preorderTraversalRecursively(root.right);
};

const preorderTraversalIteratively = (root) => {
    if (root === null) {
        return null;
    }
    // Stack to store the nodes of the tree
    const nodes = [];
    // Add root to the stack
    nodes.push(root);
    // Loop until the stack is not empty
    while (nodes.length > 0) {
        // Get the current node from the stack
        let current = nodes.pop();
        console.log(current.data);
        // Push right child of the tree to stack if not null
        if (current.right !== null) {
            nodes.push(current.right);
        }
        // Push left child of the tree to stack if not null
        if (current.left !== null) {
            nodes.push(current.left);
        }
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
    preorderTraversalRecursively(root);
    console.log("Iteratively:");
    preorderTraversalIteratively(root);
    console.log();

    root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    console.log("Recursively:");
    preorderTraversalRecursively(root);
    console.log("Iteratively:");
    preorderTraversalIteratively(root);
    console.log();

    root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    console.log("Recursively:");
    preorderTraversalRecursively(root);
    console.log("Iteratively:");
    preorderTraversalIteratively(root);
    console.log();
};

main();