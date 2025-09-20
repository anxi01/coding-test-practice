function solution(numbers) {
    let answer = '';

    const numbersToStr = numbers.map(number => number.toString());

    numbersToStr.sort((o1, o2) => {
        const a = Number(o1 + o2);
        const b = Number(o2 + o1);

        return b - a;
    });

    answer = numbersToStr.join(''); // 배열의 모든 요소를 하나의 문자열로 합침

    if (answer.charAt(0) === '0') return '0';

    return answer;
}
