'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}



/*
 * Complete the 'arrangements' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER n as parameter.
 */

function arrangements(n) {
    // Write your code here
    const defaultList = Array.from(Array(n)).map((val, index) => { return index + 1 });
    let count = 0;
    const deep = (currentList) => {
        if (currentList.length == 0) {
            count += 1;
            return;
        }
        currentList.forEach((item) => {
            const i = n - currentList.length + 1;
            if ( i%item == 0 || item%i == 0 ) {
                deep(currentList.filter(o => o != item ));
            }
        })
    }
    
    deep(defaultList);
    return count;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine().trim(), 10);

    const result = arrangements(n);

    ws.write(result + '\n');

    ws.end();
}
