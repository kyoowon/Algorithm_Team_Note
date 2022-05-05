const CraneDoll = (board, moves) => {
    let stack = [];
    let answer = 0;
    moves.forEach((move) => {
        for(i = 0; i < board.length; i++){
            if (board[i][move - 1]) {
                if (stack.length > 0 && stack[stack.length - 1] === board[i][move - 1]){
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(board[i][move - 1]);
                }
                board[i][move - 1] = 0;
                break;
            }
        }
    })
    return answer;
}

body.innerHTML += `
<h1>크레인 인형</h1>
${CraneDoll([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4])}
`