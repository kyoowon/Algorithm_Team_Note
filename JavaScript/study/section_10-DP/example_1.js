export default function example_1($body) {
    const DP = (n) => {
        let cached = Array.from({length : n + 1}, () => 0);
        cached[0] = 1;
        cached[1] = 2;
        for (let i = 2; i < n; i++){
            cached[i] = cached[i - 2] + cached[i - 1]
        }
        return cached[n - 1]
    }
    console.log($body)
    $body.innerHTML = `<h1>계단 오르기</h1>
        ${DP(7)}
    `
}
