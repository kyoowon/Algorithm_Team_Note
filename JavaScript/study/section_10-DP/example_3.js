export default function example_3($body) {
    const LIS = (arr, n) => {
        let answer = 0
        let cached = Array.from({length : n}, () => 0)
        cached[0] = 1;
        for (let i = 1; i < n; i++){
            let max = 0;
            for (let j = i - 1; j >= 0; j--){
                if (arr[j] < arr[i] && cached[j] > max)
                    max = cached[j];
            }
            cached[i] = max + 1
            answer = Math.max(answer, cached[i])
        }
        return answer
    }
    $body.innerHTML += `<h1>최대부분증가수열</h1>
    ${LIS([5, 3, 7, 8, 6, 2, 9, 4], 8)}
    `
}