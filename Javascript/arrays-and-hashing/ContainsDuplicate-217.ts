/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function (nums) {
    const uniqueNums = new Map();
    let hasDuplicate = false;

    nums.forEach((num, index) => {
        if (!uniqueNums.has(num)) {
            uniqueNums.set(num, index);
            return true;
        } else {
            hasDuplicate = true;
            return false;
        }
    });

    return hasDuplicate;
};
