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
 * Complete the 'areAlmostEquivalent' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts following parameters:
 *  1. STRING_ARRAY s
 *  2. STRING_ARRAY t
 */

function areAlmostEquivalent(s, t) {
    // Write your code here
    const result = [];
    for (let i = 0; i < s.length; i++) {
        if (s[i].length != t[i].length) {
            result.push("NO");
        } else {
            const hashMap = new Map();
            
            for (let ch = 0; ch < s[i].length; ch++) {
                if (hashMap.has(s[i][ch])) {
                    hashMap.set(s[i][ch], hashMap.get(s[i][ch]) + 1)
                } else {
                    hashMap.set(s[i][ch], 1)
                }
            }
            
            for (let ch = 0; ch < t[i].length; ch++) {
                if (hashMap.has(t[i][ch])) {
                    hashMap.set(t[i][ch], hashMap.get(t[i][ch]) - 1)
                } else {
                    hashMap.set(t[i][ch], -1)
                }
            }
            
            let isNotClose = false;
            for (let diff of hashMap.values()) {
                if (Math.abs(diff) > 3) {
                    isNotClose = true
                }
            }
            
            if (isNotClose) {
                result.push('NO')
            } else {
                result.push("YES")
            }
        }
    }
    console.log(result);
    return result;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const sCount = parseInt(readLine().trim(), 10);

    let s = [];

    for (let i = 0; i < sCount; i++) {
        const sItem = readLine();
        s.push(sItem);
    }

    const tCount = parseInt(readLine().trim(), 10);

    let t = [];

    for (let i = 0; i < tCount; i++) {
        const tItem = readLine();
        t.push(tItem);
    }

    const result = areAlmostEquivalent(s, t);

    ws.write(result.join('\n') + '\n');

    ws.end();
}
