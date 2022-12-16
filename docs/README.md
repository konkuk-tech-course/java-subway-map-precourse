# 기능 목록
## 역 관련 기능
### domain
- [x] Station 클래스 구현
    - [x] 길이 유효성 검증
- [x] StationRepository 구현
    - [x] 유효성 검증
        - [x] 중복 검사
        - [x] 에러메세지 추가
    - [x] 조회 기능

### service
- [x] Station 등록
- [x] Station 삭제
- [x] Station 조회

### view
- [x] 옵션 입력
    - [x] 입력 문구 생성
    - [x] 유효성 검증
    - [x] 메뉴 출력 기능
- [x] Station 생성
    - [x] 이름 입력받기
    - [x] 비어있지 않은 값 검증
- [x] Station 조회

### controller
- [x] StationController
    - [x] 역 등록
    - [x] 역 삭제
    - [x] 역 조회

## 노선 관련 기능
### domain
- [x] Line 클래스 구현
    - [x] Line에 존재하는 역 조회 기능
    - [x] 역 추가 기능
- [x] LineRepository 구현

### service
- [x] Line 등록
- [x] Line 삭제
- [x] Line 조회

### view
- [x] 옵션 입력
- [x] 노선 이름 입력
- [x] 상행 종점 역 이름 입력
- [x] 하행 종점 역 이름 입력
- [x] 삭제할 노선 이름 입력

### controller
- [x] LineController

## 구간 추가 기능
### service
- [x] 구간 등록
- [x] 구간 삭제

### view
- [x] 옵션 입력
- [x] 순서 입력

### controller
- [ ] SectionController

## util
- [x] Reader 클래스