export default function example_4($body) {
    const DP = (coins, m) => {
        let cached = Array.from({length : m + 1}, () => 1000);
        cached[0] = 0;
        for (let i = 0; i < coins.length; i++){
            for(let j = coins[i]; j <= m; j++){
                cached[j] = Math.min(cached[j], cached[j - coins[i]] + 1)
            }
        }
        return cached[m]
    }
    $body.innerHTML += `<h1>냅색 알고리즘 - 동전 교환</h1>
    ${DP([1, 2, 5], 15)}
    `
}