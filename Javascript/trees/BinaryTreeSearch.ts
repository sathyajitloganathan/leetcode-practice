function Node(data) {
    this.data = data;
    this.left = null;
    this.right = null;
};

function BinarySearchTree() {
    this.insert = function (root, data) {
        if (root === null) {
            this.root = new Node(data);

            return this.root;
        }

        if (data <= root.data) {
            if (root.left) {
                this.insert(root.left, data);
            } else {
                root.left = new Node(data);
            }
        } else {
            if (root.right) {
                this.insert(root.right, data);
            } else {
                root.right = new Node(data);
            }
        }

        return this.root;
    };

    this.isPresent = function (root, val) {
        // Add your code here
        if (root == null) {
            return 0;
        }
        
        if (root.data == val) {
            return 1;
        }

        return this.isPresent(root.left, val) || this.isPresent(root.right, val);
    };

};

// process.stdin.resume();
// process.stdin.setEncoding('ascii');

// var _input = "";

// process.stdin.on('data', function (data) {
//     _input += data;
// });

// process.stdin.on('end', function () {
//     var tree = new BinarySearchTree();
//     var root = null;

//     var values = _input.split('\n').map(Number);

//     var j = 1;

//     for (var i = 0; i < values[0]; i++) {
//         root = tree.insert(root, values[j]);

//         j++;
//     }

//     var k = j + 1;

//     for (var i = 0; i < values[j]; i++) {
//         process.stdout.write(tree.isPresent(root, values[k]) + '\n');

//         k++;
//     }
// });