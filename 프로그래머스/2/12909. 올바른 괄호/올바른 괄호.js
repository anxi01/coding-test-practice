function solution(s) {
    let count = 0;

    for (const c of s) {
        if (c == '(') {
            count++;
        } else {
            count--;
        }

        if (count < 0) return false;
    }

    return count === 0;
}
