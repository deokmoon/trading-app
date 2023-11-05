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

## Naver Search API
= [네이버 뉴스 검색 API 문서](https://developers.naver.com/docs/serviceapi/search/news/news.md)

### 현재 구현 내용
- Upbit Socket 연결 후 ConcurrentHashMap 에 저장
- 

### LOCAL TEST
~~~ json
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
