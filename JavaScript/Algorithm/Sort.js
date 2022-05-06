const selectSort = (arr) => {
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = i; j < arr.length; j++) {
            let index = i
            if (arr[index] > arr[j]) index = j;
        }
        // javaScript - swap!!! 
        [arr[i], arr[index]] = [arr[index], arr[i]];
    }
    return arr;
}

const bubbleSort = (arr) => {
    for (let i = 0; i < arr.length - 1; i++) {
        for (j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1])[arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
        }
    }
    return arr;
}

const insertSort = (arr) => {
    let answer = arr;
    for (let i = 0; i < arr.length; i++) {
        let tmp = arr[i]
        for (let j = i - 1; j >= 0; j--) {
            if (arr[j] > tmp) arr[j + 1] = arr[j];
            else {
                arr[j + 1] = tmp;
                break
            };
        }
    }
    return answer;
}