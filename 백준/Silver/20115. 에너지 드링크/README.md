# [Silver III] 에너지 드링크 - 20115 

[문제 링크](https://www.acmicpc.net/problem/20115) 

### 성능 요약

메모리: 31104 KB, 시간: 512 ms

### 분류

그리디 알고리즘

### 제출 일자

2025년 7월 3일 16:23:53

### 문제 설명

<p>페인은 에너지 드링크를 좋아하는 회사원이다. 에너지 드링크는 카페인, 아르기닌, 타우린, 나이아신 등의 성분이 들어있어 피로 회복에 도움을 주는 에너지 보충 음료수이다.</p>

<p>야근을 마치고 한밤중에 퇴근하니 벌써 새벽 1시. 하지만 주말은 아직 멀었고, 다음 날에도 정시에 출근해야 하는 페인은 오늘도 에너지 드링크를 찾는다.</p>

<p>반복되는 야근에 지친 나머지, 평소보다 더 많은 에너지와 피로 회복이 필요했던 페인은 집에 있던 에너지 드링크들을 한 데 합쳐서, 하나의 에너지 드링크로 만들어 한번에 마시려 한다.</p>

<p>페인이 에너지 드링크들을 합치는 과정은 다음과 같다.</p>

<ol>
	<li>임의의 서로 다른 두 에너지 드링크를 고른다.</li>
	<li>한쪽 에너지 드링크를 다른 쪽 에너지 드링크에 모두 붓는다. 단, 페인은 야근 후유증으로 인해 손이 떨려, 붓는 과정에서 원래 양의 절반을 바닥에 흘리게 된다.</li>
	<li>다 붓고 남은 빈 에너지 드링크는 버린다.</li>
	<li>1~3 과정을 에너지 드링크가 하나만 남을 때까지 반복한다.</li>
</ol>

<p>예를 들어, 두 에너지 드링크 <em>a, b</em>가 있고, 양이 각각 <em>x<sub>a</sub>, x<sub>b</sub></em>라 할 때, 다음 둘 중 하나의 선택을 할 수 있다.</p>

<ul>
	<li><em>a</em>의 양을 <em>x<sub>a</sub></em> + (<em>x<sub>b</sub></em> / 2)로 만들고, <em>b</em>를 버리기</li>
	<li><em>b</em>의 양을 <em>x<sub>b</sub></em> + (<em>x<sub>a</sub></em> / 2)로 만들고, <em>a</em>를 버리기</li>
</ul>

<p>페인은 합쳐진 에너지 드링크의 양을 최대로 하려 한다. 불쌍한 페인을 도와주자!</p>

### 입력 

 <p>첫째 줄에 페인이 가지고 있는 에너지 드링크의 수 <em>N</em>이 주어진다. (2 ≤ <em>N</em> ≤ 10<sup>5</sup>)</p>

<p>둘째 줄에 각 에너지 드링크의 양이 공백으로 구분되어 주어진다. <em>i</em>번째 정수 <em>x<sub>i</sub></em> (1 ≤ <em>x<sub>i</sub></em> ≤ 10<sup>9</sup>)는 에너지 드링크 <em>i</em>의 양이 <em>x<sub>i</sub></em>임을 의미한다.</p>

### 출력 

 <p>첫째 줄에 페인이 최대로 만들 수 있는 에너지 드링크의 양을 출력한다.</p>

<p>절대/상대 오차는 10<sup>-5</sup>까지 허용한다.</p>

