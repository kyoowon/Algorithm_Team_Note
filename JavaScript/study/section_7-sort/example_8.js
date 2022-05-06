const count = (songs, capacity) => {
    let cnt = 1,
        sum = 0;
    for (let x of songs) {
        if (sum + x > capacity) {
            cnt += 1;
            sum = x;
        } else sum += x;
    }
    return cnt
}
const DecisionTree = (m, songs) => {
    let answer;
    let lt = Math.max(...songs);
    let rt = songs.reduce((acc, v) => acc + v, 0)
    while (lt <= rt) {
        let mid = parseInt((lt + rt) / 2);
        if (count(songs, mid) <= m) {
            answer = mid;
            rt = mid - 1;
        } else lt = mid + 1;
    }
    return answer
}
let arr4 = Array.from({
    length: 9
}, (v, i) => i + 1);

body.innerHTML += `
<h1>뮤직 비디오 - 결정트리</h1>
${DecisionTree(3, arr4)}
`