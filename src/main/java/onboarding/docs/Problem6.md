## Problem6

### 요구 사항 분석

우아한테크코스에서는 교육생(이하 크루) 닉네임들을 사용할때,  크루들의 닉네임 중 **같은 글자가 연속적으로 포함** 될 경우 해당 이메일 목록을 반환해라.


### 구현 기능
1. 주어진 크루들의 배열을 hashMap으로 바꾼다. (이때 key는 email, value는 닉네임)
2. 크루들의 hashMap을 순회하여 닉네임을 2개의 단어로 분할하여,  hashMap의 key로 설정하고 value값으로 new ArrayList<String>를 설정한다.
3. key에 해당하는 (2개의 단어 조합) 닉네임에 value값으로 이메일을 넣는다.
4. value의 크기가 2개 이상인 것만 추출해서 변환한다.

### 구현 역할
> ListMapper

- 주어진 List<List<String>>을 hashmap으로 변환한다.

> NicknameValidator

- 주어진 크루들의 닉네임이 연속으로 중복된다면 이를 반환해준다.
