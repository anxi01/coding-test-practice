function solution(cacheSize, cities) {
    let answer = 0;
    let cache = [];
    
    if (cacheSize === 0) {
        return cities.length * 5;
    }

    for (let i = 0; i < cities.length; i++) {
        const city = cities[i]?.toLowerCase();

        if (city !== undefined) {
            // 캐시 배열에 있는지 찾기
            const cacheIndex = cache.indexOf(city);

            // 있을 경우
            if (cacheIndex !== -1) {
                answer += 1;

                cache.splice(cacheIndex, 1);
                cache.push(city);  
                
            // 없을 경우
            } else {
                answer += 5;

                if (cache.length < cacheSize) {
                    cache.push(city);
                } else {
                    cache.shift();
                    cache.push(city);
                }
            }
        }
    }

    return answer;
}