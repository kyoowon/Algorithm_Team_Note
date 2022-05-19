export default function example_5($body) {
    const DP = (m, arr) => {
        let cached = Array.from({length : m + 1}, () => 0);
        for(let i = 0; i < arr.length; i++){
            let ps = arr[i][0]
            let pt = arr[i][1]
            for (let j = m; j >= pt; j--){
                cached[j] = Math.max(cached[j], cached[j - pt] + ps)
            }
        }
        return cached[m]
    }
    $body.innerHTML += `<h1>백에서 시작하는 냅색 알고리즘 - 최대 점수 구하기</h1>
    ${DP(20, [[10, 5], [25, 12], [15, 8], [6, 3], [7, 4]])}
    `
}