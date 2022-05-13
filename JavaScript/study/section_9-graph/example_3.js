
const example_3 = (maze) => {
    let answer = 0;
    let dx = [0, 0, -1, 1];
    let dy = [1, -1, 0, 0];
    function dfs(x, y){
        if (x === 6 && y === 6){
            answer += 1;
        }else{
            for (let i = 0; i < 4; i++){
                let nx = x + dx[i];
                let ny = y + dy[i];
                if (0 <= nx && nx <= 6 && 0 <= ny && ny <= 6){
                    if (maze[nx][ny] === 0){
                        maze[nx][ny] = 1;
                        dfs(nx, ny);
                        maze[nx][ny] = 0;
                    }
                }
            }
        }
    }
    maze[0][0] = 1
    dfs(0, 0)
    return answer;
}


let arr3 = [
    [0, 0, 0, 0, 0, 0, 0],
    [0, 1, 1, 1, 1, 1, 0],
    [0, 0, 0, 1, 0, 0, 0],
    [1, 1, 0, 1, 0, 1, 1],
    [1, 1, 0, 0, 0, 0, 1],
    [1, 1, 0, 1, 1, 0, 0],
    [1, 0, 0, 0, 0, 0, 0]
];

body.innerHTML += `
<h1>미로 탈출</h1>
${example_3(arr3)}
`