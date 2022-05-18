const example_6 = (maps) => {
    let answer = 0;
    let n = maps.length;
    let dx = [-1, -1, -1, 0, 0, 1, 1, 1]
    let dy = [-1, 0, 1, -1, 1, -1, 0, 1]
    const dfs = (x, y) => {
        maps[x][y] = 0;
        for (let k = 0; k < 8; k++){
            let nx = x + dx[k];
            let ny = y + dy[k];
            if (nx >=0 && nx < n && ny >= 0 && ny < n && maps[nx][ny] === 1){
                dfs(nx, ny);
            }
        }
    }
    const bfs = (x, y) => {
        maps[x][y] = 0;
        let queue = []
        queue.push([x, y]);
        while (queue.length){
            let [x, y] = queue.shift();
            for (let k = 0; k < 8; k++){
                let nx = x + dx[k];
                let ny = y + dy[k];
                if( nx >= 0 && nx < n && ny >= 0 && ny < n && maps[nx][ny] === 1){
                    maps[nx][ny] = 0;
                    queue.push([nx, ny])
                }
            }
        }
        
    }


    for (let i = 0; i < n; i++){
        for (let j = 0; j < n; j++){
            if (maps[i][j] === 1){
                answer++;
                // dfs(i, j);
                bfs(i, j);
            }
        }
    }
    return answer;
}

let maps = [
    [1, 1, 0, 0, 0, 1, 0],
    [0, 1, 1, 0, 1, 1, 0],
    [0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 0, 1, 1],
    [1, 1, 0, 1, 1, 0, 0],
    [1, 0, 0, 0, 1, 0, 0],
    [1, 0, 1, 0, 1, 0, 0]
];

body.innerHTML += `
<h1>섬나라 아일랜드</h1>
${example_6(maps)}
`