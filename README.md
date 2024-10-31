# 로또

## 📝 기능 목록

----

- [x] 로또 구입 금액을 입력 받는다.
    - [ ] 예외1: 1,000원으로 나누어 떨어지지 않는 경우
    - [ ] 예외2: 1,000원 미만인 경우
    - [ ] 예외3: 너무 큰 금액인 경우
    - [ ] 예외4: 아무값도 입력하지 않은 경우


- [x] 구입 금액만큼 로또 번호를 발행한다.
    - 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다. 로또 번호의 숫자 범위는 1~45까지이다
    - [ ] 예외1: 완전히 같은 번호의 로또가 발행되는 경우


- [x] 발행한 로또 수량을 출력한다.

```markdown
8개를 구매했습니다.
```

- [x] 발행한 로또 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```markdown
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
```

- [x] 당첨 번호를 쉼표를 기준으로 입력 받는다. ex) 1,2,3,4,5,6
    - [ ] 예외1: 쉼표가 제일 앞 또는 제일 뒤에 위치하는 경우
    - [ ] 예외2: 아무값도 입력하지 않은 경우
    - [ ] 예외3: 쉼표만 입력한 경우
    - [ ] 예외4: 쉼표가 연속해서 존재하는 경우 ex) 1,,,2,,,3
    - [ ] 예외5: 당첨 번호와 쉼표 사이에 공백이 존재하는 경우 ex) 1 , 2
    - [ ] 예외6: 중복된 번호가 존재하는 경우
    - [ ] 예외7: 1~45 사이의 수가 아닌 경우
    - [ ] 예외8: 문자열을 입력받는 경우
- [x] 보너스 번호를 입력 받는다.
    - [ ] 예외1: 아무 값도 입력하지 않은 경우
    - [ ] 예외2: 1~45 사이의 수가 아닌 경우
    - [ ] 예외3: 문자열을 입력받는 경우


- [x] 당첨 내역을 계산한다.
    - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- [ ] 당첨 내역을 출력한다.

```markdown
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
  ```

- [ ] 수익률을 계산한다. 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```markdown
총 수익률은 62.5%입니다.
```

### 예외 관련

- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
- [ ] "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [ ] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 프로그래밍 요구 사항

- [ ] Java Enum을 적용하여 프로그램을 구현한다.
- [ ] 구현한 기능에 대한 단위 테스트를 작성한다.

## Lotto 클래스

- [ ] 제공된 Lotto 클래스를 사용하여 구현해야 한다.
- [ ] Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- [ ] numbers의 접근 제어자인 private은 변경할 수 없다.
- [ ] Lotto의 패키지를 변경할 수 있다

## ✅ 실행 결과 예시

```markdown
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```