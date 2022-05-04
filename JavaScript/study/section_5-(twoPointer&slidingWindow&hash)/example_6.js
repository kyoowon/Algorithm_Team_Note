
// const election = (s) => {
//     let answer = Array.from({length : 5}, () => 0)
//     const alph = ['A', 'B', 'C', 'D', 'E']
//     for(c of s) answer[alph.indexOf(c)]++;
//     return alph[answer.indexOf(Math.max(...answer))]
// }

const election = (s) => {
    let hs = new Map()
    for(let c of s) {
        if(hs.has(c)) hs.set(c, hs.get(c) + 1)
        else hs.set(c, 1)
    }
    let max = Number.MIN_SAFE_INTEGER
    let answer
    for (let [key, v] of hs){
        if(v > max){
            max = v;
            answer = key
        }
    }
    return answer
}



body.innerHTML += `
<h1>반장 선거<h1>
<h2>${(election("BACBACCACCBDEDE"))}</h2>
`