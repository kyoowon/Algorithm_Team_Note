
// 배열에 대한 내장함수
function ArrayFunc(arr){
    // 최소값
    let min = Math.min(...arr)
    // 최대값
    let max = Math.max(...arr)
    console.log(min, max)

    // 원소 추출 - 해당 index, 갯수
    const newArray = a.splice(index, 1)

    // 0인 array를 생성하는 방법 - 길이가 len만큼에 설정할 수 있음.
    let answer = Array.from({length : len}, () => 0)
}

function StringFunc(string){
    let str_sub1 = s.substring(mid - 1, mid + 1)
    let str_sub2 = s.substr(mid - 1, 2)
    console.log(str_sub1, str_sub2)
}

// forEach, map, filter, reduce
a = [10, 11, 12, 13, 14, 15]

// forEach - for 문을 돌리는 것으로 이해
// function forEach(predicate, thisArg) {
//     for (let i=0; i<a.length; i++){
//         predicate(a[i], i)
//     }
// }

a.forEach((value, index) => {
    console.log(value, index)
});


// map - 새로운 배열을 생성해서 return (원본 배열의 길이는 동일)
let answer = a.map((value, index) => {
    if (value % 2 === 0) return value;
})

// filter - 새로운 배열을 생성 그러나 이는 조건에 참이 되는 값만 (길이는 달라짐)
let answer = a.filter((value, index) =>{
    return value % 2 === 0
})


// reduce - 값을 return callback함수를 통해 배열을 돌면서 돌면서 결과값을 만들어냄
let answer = a.reduce((acc, value) => {
    return acc + value
}, 0)




// 중복 제거하기 - set을 통해 중복값 제거
function deleteDuplicate(dup) {
    const result = new Set(dup)
    return result
}

// object를 생성
function createObject(id_list) {
    let new_list = id_list.map(value => ({[value]: []}));
    return new_list
}