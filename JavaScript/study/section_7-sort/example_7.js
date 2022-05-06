const binarySearch = (arr, target) => {
    answer = 0
    arr.sort((a, b) => a - b)
    start = 0
    end = arr.length
    while (start <= end){
        mid = Math.floor((start + end) / 2)
        if (arr[mid] === target) return mid + 1
        else if (arr[mid] < target) start = mid + 1
        else end = mid - 1
    }
}
let arr3 = [23, 87, 65, 12, 57, 32, 99, 81];


body.innerHTML += `
<h1>이진탐색</h1>
${binarySearch(arr3, 32)}
`