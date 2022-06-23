# 항해99 7기 4조 airbnb clone project - backend

# 👏 프로젝트 소개

2년 동안 코로나 바이러스로 인해 여행을 못 간 지금!!
<br>
<br>
요즘 코로나 바이러스가 예전에 비해 잠잠해지면서 여행을 떠나는 사람들이 많아지고 있습니다. 
<br>
<br>
여행을 간다면 반드시 필요한 숙소!!!
<br>
<br>
우리 팀은 여행에서 가장 중요한 숙소를 예약할 수 있는 Airbnb 사이트를 클론 코딩하기로 했습니다.

# ****⚙️**** 프로젝트 개요

- 프로젝트명 : Airbnb Clone Project
- 개발 인원 : 프론트(React) 3명, 백엔드(Spring) 4명
- 개발 기간 : 2022.06.17~ 2022.06.23
- 개발 환경 : Springboot 2.6.8, JDK 8, Spring Security, Spring JPA, React, React-Redux
- 배포 환경 : Gradle, AWS S3, AWS EC2
- 웹 서버 : Tomcat 9.0.63
- 데이터베이스 : MySQL 8.0.29 (AWS RDS)
- 협업 도구 : Git, Slack, Notion

>**[Front-End Repository](https://github.com/hh99-airbnb-clone/airbnb/tree/main/airbnb)
><br>
>[시연영상 구경하기 - URL 바꿔야함](https://github.com/insidelamp)
><br>
>[팀 노션](https://smiling-level-1e8.notion.site/4-af2eb66124c34052844374cb4ff6294b)**


# ⭐️ 팀 구성
| 이름     | 깃허브 주소                                                | 포지션     |
|:--------:|:----------------------------------------------------------:|:-----------:|
| 김성영 | [https://github.com/sungyoungk](https://github.com/sungyoungk)                     | Backend     |
| 김재현   | [https://github.com/DubuKim](https://github.com/DubuKim)                     | Backend     |
| 손경이   | [https://github.com/Son-Gyeongi](https://github.com/Son-Gyeongi) | Backend     |
| 조윤상   | [https://github.com/bapunn](https://github.com/bapunn) | Backend     |
| 고백제   | [https://github.com/baeg-jae](https://github.com/baeg-jae)                     | Frontend |
| 김정욱   | [https://github.com/junguk11/TIL](https://github.com/junguk11/TIL)                     | Frontend |
| 장세화   | [saehwa95 (github.com)](saehwa95 (github.com))                     | Frontend |

<br>

# 💛 API 설계

- [[API 설계 팀 노션]](https://smiling-level-1e8.notion.site/4-af2eb66124c34052844374cb4ff6294b)

# ****🗺**** ERD 설계

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9d3d9f0d-897a-48c3-b4ed-5380595d1dd6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220623%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220623T085508Z&X-Amz-Expires=86400&X-Amz-Signature=63ab54f3c8fff3fdb8cd960ba0e944cef09b912ea8ea808e317e0edf60e7b3c0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject" width="650">

# ****🧩 아키텍처****

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/10f20d3a-d7ef-4dde-a162-d71c74406096/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T065347Z&X-Amz-Expires=86400&X-Amz-Signature=763c44611277014ea28cda382f429239df4d4de8f0db7f115a146ab78292b36c&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject" width="900">

# ****💡 Trouble Shooting****
1.사진 데이터 저장 문제
   - 첫 번째 시도에는 사진을 저장하기 위해 ec2 실제  Data는 서버의 특정 폴더에 데이터를 저장하고, DB에 해당 경로를 저장하는 방식으로 구현을 시도 했습니다.
     그리고 outPut에서 byte array를 내려주는 방향으로 진행이 됐으나, byteArray를 다시 이미지로 파싱하는 부분에서 문제가 생겨 
     S3에 저장하고 image url을 받아오는 방식으로 전환했습니다.

   - 두 번째 시도인 S3를 사용하기 위해서 bucket을 만들고, public 접근을 열어주기 위한 policy generator를 하려고 했으나 S3 자체의 버그 때문인지 
     add statement 버튼이 활성화 되지 않았습니다. 이를 해결하기 위해 aws에서 운영하는 re:Post 게시판에 영어로 질문도 해보고, 구글링도 열심히 해봤지만 
     해결이 어려웠습니다. 또한 Json으로 직접 policy를 만들어 주려고 생각을 했는데, 인터넷에 있는 예제들은 ID 값과 statement 값이 생성되는 것을 보고 
     무조건 generator를 거쳐야 하는 줄 알아서 포기했었습니다. 그러던 와중 팀원 분의 지인이 id 값을 굳이 넣어 줄 필요가 없다고 하셔서, 
     json으로 policy 직접 생성 이후 구현에 성공했습니다.
     
2. 에러메시지 : Ambiguous mapping. Cannot map 'accommodationController' method 
    - 구글링으로 찾아보니 controller에서 메서드도 같고 URL도 똑같은 API가 두개 만들어져서 생긴 에러 메시지라고 해서 확인해보니 정말 똑같은 메서드에, URL도 같은 API가 있어서 그 부분을 수정했습니다.
