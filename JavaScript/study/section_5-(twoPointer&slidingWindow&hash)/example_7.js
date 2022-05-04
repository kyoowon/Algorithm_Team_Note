const Anagram = (s1, s2) => {
    let ht = new Map()
    for (let c of s1) {
        if (ht.has(c)) ht.set(c, ht.get(c) + 1)
        else ht.set(c, 1)
    }
    for (let x of s2) {
        if (ht.has(x) || ht.get(x) === 0) return "NO"
        ht.set(x, ht.get(x) - 1)
    }
    for (let [key, v] of ht) {
        if (v !== 0) return "NO"
    }
    return "YES"
}



body.innerHTML += `
<h1>아나그램<h1>
<h2>${(Anagram("abaCC", "Caaab"))}</h2>
`