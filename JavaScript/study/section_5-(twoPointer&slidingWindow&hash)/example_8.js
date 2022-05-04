const allAnagram = (s1, s2) => {
    let answer = 0
    let htable = new Map()
    for (let c of s2) {
        if (htable.has(c)) htable.set(c, htable.get(c) + 1)
        else htable.set(c, 1)
    }
    let htemp = new Map()
    let rt = s2.length - 1
    for (let j = 0; j < rt; j++){
        if(htemp.has(s1[j])) htemp.set(s1[j], htemp.get(s1[j]) + 1)
        else htemp.set(s1[j], 1)
    }
    for (let i = 0; i < s1.length - rt; i++) {
        if(htemp.has(s1[i + rt])) htemp.set(s1[i + rt], htemp.get(s1[i + rt]) + 1)
        else htemp.set(s1[i + rt], 1)
        console.log(htable, htemp)
        let flag = 0
        for (let [key, v] of htable){
            if (!htemp.has(key) || htemp.get(key) !== v){
                flag = 1
                break;
            }
        }
        if (!flag) answer += 1
        if(htemp.get(s1[i]) > 1) htemp.set(s1[i], htemp.get(s1[i]) - 1)
        else htemp.delete(s1[i])
    }
    return answer
}



body.innerHTML += `
<h1>아나그램<h1>
<h2>${(allAnagram("bacaAacba", "abc"))}</h2>
`