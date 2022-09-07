# 📚 PUT, PATCH,DELETE

## 🔎 PUT

![스크린샷 2022-09-07 오후 4 38 08](https://user-images.githubusercontent.com/101084642/188818177-f541fd9e-cd3b-44d1-a761-a0f1aaca7ffe.png)


#### ▪️ 리소스 대체
- 리소스가 있으면 대체
- 리소스가 없으면 생성
- 쉽게 이야기해서 덮어버림
- 
#### ▪ 클라이언트가 리소스를 식별
- 클라이언트가 리소스 위치를 알고 URI 지정 (POST와 차이점)
- POST는 /members 로만 던지는데 PUT은 정확한 Location까지 식별한다 `/members/100`

![스크린샷 2022-09-07 오후 4 57 21](https://user-images.githubusercontent.com/101084642/188822870-9062f0c7-2727-44c7-aaf2-b1c2943bc6bc.png)

![스크린샷 2022-09-07 오후 4 59 01](https://user-images.githubusercontent.com/101084642/188823264-0fcd533f-94be-427e-a619-e266010cacb0.png)


<br>

## 🔎 PATCH
#### ▪️ 리소스 부분 변경
- HTTP 버전에 따라 PATCH 지원을 하지 않을 경우, POST 를 쓰면된다
- POST는 어디에나 쓸 수 있다!
- 하지만, 다른 매서드를 쓸 수 있는경우 쓰는게 좋다!

![스크린샷 2022-09-07 오후 5 56 04](https://user-images.githubusercontent.com/101084642/188836246-ef478dd0-861b-4432-8921-f6bda29a4931.png)

<br>

## 🔎 DELETE
#### ▪️ 리소스 제거

![스크린샷 2022-09-07 오후 5 59 10](https://user-images.githubusercontent.com/101084642/188836985-93e6a205-85e2-414d-b0a4-6ff4e49ab43d.png)





