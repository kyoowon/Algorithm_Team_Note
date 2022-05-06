const count2 = (horse, mid) => {
    let cnt = 1, ep = horse[0];
    for (i = 0; i < horse.length; i++){
        if(horse[i] - ep >= mid){
            cnt++;
            ep = horse[i];
        }
    }
    return cnt
}

const DecisionTree2 = (m, horse) => {
    let cages = horse.sort((a, b) => a - b);
    let answer;
    let lt = 1
    let rt = cages[cages.length - 1]
    while (lt <= rt){
        mid = parseInt((lt + rt) / 2);
        if (count2(horse, mid) >= m){
            answer = mid;
            lt = mid + 1;
        } else rt = mid - 1;
    }
    return answer;
}
let arr5 = [1, 2, 8, 4, 9]

body.innerHTML += `
<h1>마구간 정하기 - 결정트리</h1>
${DecisionTree2(3, arr5)}
`