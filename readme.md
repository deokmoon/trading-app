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
- JPA
- H2 Database
- MySql
- JUnit 5

## 사용 라이브러리
- [Lombok](https://projectlombok.org/)
  - 불필요한 코드를 줄이고, 가독성을 높이기 위해 사용했습니다.
- [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
  - Client(주문시스템)에서 서버로 요청하는 부분을 구현하기 위해 적용하였습니다.


## Upbit
- [업비트 api 문서](https://docs.upbit.com/docs/user-request-guide)

### 현재 구현 내용
- 종목 저장 후 RETURN
- 종목 시세 조회 시 UPBIT 조회 후 응답

### LOCAL TEST
~~~ json
# 전체종목 조회
Request method:	GET
Request URI: http://localhost:8080/market-list

# TICKER 조회
Request method:	GET
Request URI:
 - http://localhost:8080/ticker/{market}
 - EX) http://localhost:8080/ticker/KRW-ETH

# 호가 정보 조회
Request method:	GET
Request URI:
 - http://localhost:8080/order-book/{market}
 - EX) http://localhost:8080/order-book/KRW-ETH
~~~

### Todo
- [ ] MySQL read / write 구분
- [ ] @Scheduled 를 통해 write and sync
  - [ ] 전체종목 조회는 app 구동 시 최초 요청 혹은 러프한 시간으로 조회 후 공유
  - [ ] 종목을 조회하고 저장할 때 병렬 thread 처리
- [ ] 외부 요청은 read db를 통해 return
- [ ] BUILDER 디자인 패턴 적용
