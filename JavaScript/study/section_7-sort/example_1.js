const specialSort = (arr) => {
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = 0; j < arr.length - i; j++) {
            if (arr[j] > 0 && arr[j + 1] < 0) [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]]
        }
    }
    return arr
}

let body = document.querySelector("body");
body.innerHTML += `
<h1>Special Sort</h1>
${specialSort([1, 2, 3, -3, -2, 5, 6, -6])}
`