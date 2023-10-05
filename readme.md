# Trading-App

## Upbit
- [업비트 api 문서](https://docs.upbit.com/docs/user-request-guide)

### Todo
- [ ] MySQL read / write 구분
- [ ] @Scheduled 를 통해 write and sync
  - [ ] 전체종목 조회는 app 구동 시 최초 요청 혹은 러프한 시간으로 조회 후 공유
  - [ ] 종목을 조회하고 저장할 때 병렬 thread 처리
- [ ] 외부 요청은 read db를 통해 return
