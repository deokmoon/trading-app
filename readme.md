# Trading-App

## 빌드 및 실행 방법(todo)
```shell
$ git clone https://github.com/deokmoon/trading-app.git
$ cd trading-app
$ (mac) ./gradlew clean build (windows) gradlew clean build
$ java -jar build/libs/trading-app-0.0.1-SNAPSHOT.jar
```

## 개발환경
- Java 17
- Spring Boot 3.x
- Gradle
- JUnit 5

## 사용 라이브러리
- [Lombok](https://projectlombok.org/)
  - 불필요한 코드를 줄이고, 가독성을 높이기 위해 사용
- [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
  - Client 에서 서버로 요청하는 부분을 구현하기 위해 적용
- [MapStruct](https://mapstruct.org/)
  - DTO, Entity 간의 변환을 위해 사용

## Upbit
- [업비트 api 문서](https://docs.upbit.com/docs/user-request-guide)

## 뉴스 검색 api
- [네이버 뉴스 검색 API 문서](https://developers.naver.com/docs/serviceapi/search/news/news.md)
### Naver 뉴스 검색 요청 응답
- URL: http://localhost:8080/blogs
- Method: GET
- Parameter
- 예) http://localhost:8080/news?query=bitcoin&start=2&display=2&sort=RECENCY

| Parameter | Type    | Description                | Required | Default  |
|-----------|---------|----------------------------|----------|----------|
| query     | String  | 검색어                        | Y        | -        |
| display   | Integer | 검색 결과 수 (1 - 50)           | N        | 10       |
| start     | Integer | 페이지 (1 - 50)               | N        | 1        |
| sort      | String  | 정렬 순서 (ACCURACY / RECENCY) | N        | accuracy |

- 응답
~~~http request
{
    "news": [
        {
            "title": "MMSS 토큰, 글로벌 거래소 '비트마트' 상장",
            "contents": "BRC-20(<b>Bitcoin</b> Request for Comment)은 오디널스 프로토콜(Ordinals Protocol)을 활용해 데이터를 비트코인의 최소 단위인 사토시(Satoshi)에 기록하고, 비트코인 블록체인 기반의 토큰을 배포하고 전송할 수 있도록... ",
            "platformLink": "https://www.tokenpost.kr/article-155485",
            "originLink": "https://www.tokenpost.kr/article-155485",
            "createTime": "2023-12-08T00:00:00"
        },
        {
            "title": "[이번주 놓친 세계 코인 이슈] 美 공군 소령, 군사 이점 위한 비트코인 통합 ...",
            "contents": "또, 브라질에서는 현지 최대 은행 기관의 비트코인(<b>Bitcoin</b>, BTC), 이더리움(Ethereum, ETH) 출범 소식이, 스위스... 비트코인(<b>Bitcoin</b>, BTC)과 테더(Tether, USDT)를 지역사회 세금 및 공과금 납부 수단으로 허용한다고 5일(현지 시각)... ",
            "platformLink": "http://coinreaders.com/90545",
            "originLink": "http://coinreaders.com/90545",
            "createTime": "2023-12-08T00:00:00"
        }
    ],
    "currentPage": 2,
    "size": 2,
    "total": 17815
}

~~~

 

### LOCAL TEST
~~~ http request
# 전체종목 조회
Request method:	GET
Request URI: http://localhost:8080/market-list

# TICKER 조회 - socket 기반
Request method:	GET
Request URI:
 - http://localhost:8080/ticker/?markets=""
 - EX) http://localhost:8080/ticker?markets=KRW-BTC,KRW-ETH

# 호가 정보 조회 - socket 아님
Request method:	GET
Request URI:
 - http://localhost:8080/order-book/{market}
 - EX) http://localhost:8080/order-book/KRW-ETH
~~~

### Todo
- [ ] Naver 뉴스 API 개발
- [X] 파람이 아니라 쿼리 쿼리 활용
- [X] Upbit용 Socket 통신 Bean을 등록
- [x] 구동 시 해당 Bean을 호출하도록 수행 -> 해당 Bean은 소켓 통신으로 시세 업데이트를 함
  - [X] 소켓으로 받은 ticker의 code를 파싱하여 Concurrent 에 종목별 시세 적용  
- [X] BUILDER 디자인 패턴 적용
- [X] MapStruct 적용
- [ ] @Scheduled 를 통해 write and sync
  - [ ] 전체종목 조회는 app 구동 시 최초 요청 혹은 러프한 시간으로 조회 후 공유
  - [ ] 종목을 조회하고 저장할 때 병렬 thread 처리
- 추후  고려
- [ ] MySQL read / write 구분
- [ ] 외부 요청은 read db를 통해 return
