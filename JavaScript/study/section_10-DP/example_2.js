export default function example_2($body) {
    const DP = (n) => {
        let cached = Array.from({length : n + 1}, () => 0)
        cached[0] = 1
        cached[1] = 2
        cached[2] = 4
        for (let i = 3; i < n; i++) cached[i] = cached[i - 3] + cached[i - 2] + cached[i - 1]
        return cached[n - 1]
    }
    $body.innerHTML += `<h1>돌다리 건너기</h1>
        ${DP(8)}
    `
}