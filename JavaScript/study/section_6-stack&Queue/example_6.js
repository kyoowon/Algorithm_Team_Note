const princess = (n, m) => {
    prins = Array.from({length : n}, (v, index) => index + 1)
    while(prins.length){
        for(let i = 1; i < m; i++) prins.push(prins.shift());
        prins.shift();
        if (prins.length === 1) answer = prins.shift();
    }
    return answer
}


body.innerHTML += `
<h1>쇠막대기</h1>
${princess(8, 3)}
`