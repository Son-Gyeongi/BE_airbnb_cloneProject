# ν­ν΄99 7κΈ° 4μ‘° airbnb clone project - backend

# π νλ‘μ νΈ μκ°

2λ λμ μ½λ‘λ λ°μ΄λ¬μ€λ‘ μΈν΄ μ¬νμ λͺ» κ° μ§κΈ!!
<br>
<br>
μμ¦ μ½λ‘λ λ°μ΄λ¬μ€κ° μμ μ λΉν΄ μ μ ν΄μ§λ©΄μ μ¬νμ λ λλ μ¬λλ€μ΄ λ§μμ§κ³  μμ΅λλ€. 
<br>
<br>
μ¬νμ κ°λ€λ©΄ λ°λμ νμν μμ!!!
<br>
<br>
μ°λ¦¬ νμ μ¬νμμ κ°μ₯ μ€μν μμλ₯Ό μμ½ν  μ μλ Airbnb μ¬μ΄νΈλ₯Ό ν΄λ‘  μ½λ©νκΈ°λ‘ νμ΅λλ€.

# ****βοΈ**** νλ‘μ νΈ κ°μ

- νλ‘μ νΈλͺ : Airbnb Clone Project
- κ°λ° μΈμ : νλ‘ νΈ(React) 3λͺ, λ°±μλ(Spring) 4λͺ
- κ°λ° κΈ°κ° : 2022.06.17~ 2022.06.23
- κ°λ° νκ²½ : Springboot 2.6.8, JDK 8, Spring Security, Spring JPA, React, React-Redux
- λ°°ν¬ νκ²½ : Gradle, AWS S3, AWS EC2
- μΉ μλ² : Tomcat 9.0.63
- λ°μ΄ν°λ² μ΄μ€ : MySQL 8.0.29 (AWS RDS)
- νμ λκ΅¬ : Git, Slack, Notion

>**[Front-End Repository](https://github.com/hh99-airbnb-clone/airbnb/tree/main/airbnb)
><br>
>[μμ°μμ κ΅¬κ²½νκΈ° - URL λ°κΏμΌν¨](https://github.com/insidelamp)
><br>
>[ν λΈμ](https://smiling-level-1e8.notion.site/4-af2eb66124c34052844374cb4ff6294b)**


# β­οΈ ν κ΅¬μ±
| μ΄λ¦     | κΉνλΈ μ£Όμ                                                | ν¬μ§μ     |
|:--------:|:----------------------------------------------------------:|:-----------:|
| κΉμ±μ | [https://github.com/sungyoungk](https://github.com/sungyoungk)                     | Backend     |
| κΉμ¬ν   | [https://github.com/DubuKim](https://github.com/DubuKim)                     | Backend     |
| μκ²½μ΄   | [https://github.com/Son-Gyeongi](https://github.com/Son-Gyeongi) | Backend     |
| μ‘°μ€μ   | [https://github.com/bapunn](https://github.com/bapunn) | Backend     |
| κ³ λ°±μ    | [https://github.com/baeg-jae](https://github.com/baeg-jae)                     | Frontend |
| κΉμ μ±   | [https://github.com/junguk11/TIL](https://github.com/junguk11/TIL)                     | Frontend |
| μ₯μΈν   | [saehwa95 (github.com)](saehwa95 (github.com))                     | Frontend |

<br>

# π API μ€κ³

- [[API μ€κ³ ν λΈμ]](https://smiling-level-1e8.notion.site/4-af2eb66124c34052844374cb4ff6294b)

# ****πΊ**** ERD μ€κ³

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9d3d9f0d-897a-48c3-b4ed-5380595d1dd6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220623%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220623T085508Z&X-Amz-Expires=86400&X-Amz-Signature=63ab54f3c8fff3fdb8cd960ba0e944cef09b912ea8ea808e317e0edf60e7b3c0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject" width="650">

# ****π§© μν€νμ²****

<img src="https://user-images.githubusercontent.com/78200199/175262501-606f615b-da33-443c-958f-929d263d2339.png" width="900">

# ****π‘ Trouble Shooting****
1.μ¬μ§ λ°μ΄ν° μ μ₯ λ¬Έμ 
   - μ²« λ²μ§Έ μλμλ μ¬μ§μ μ μ₯νκΈ° μν΄ ec2 μ€μ   Dataλ μλ²μ νΉμ  ν΄λμ λ°μ΄ν°λ₯Ό μ μ₯νκ³ , DBμ ν΄λΉ κ²½λ‘λ₯Ό μ μ₯νλ λ°©μμΌλ‘ κ΅¬νμ μλ νμ΅λλ€.
     κ·Έλ¦¬κ³  outPutμμ byte arrayλ₯Ό λ΄λ €μ£Όλ λ°©ν₯μΌλ‘ μ§νμ΄ λμΌλ, byteArrayλ₯Ό λ€μ μ΄λ―Έμ§λ‘ νμ±νλ λΆλΆμμ λ¬Έμ κ° μκ²¨ 
     S3μ μ μ₯νκ³  image urlμ λ°μμ€λ λ°©μμΌλ‘ μ ννμ΅λλ€.

   - λ λ²μ§Έ μλμΈ S3λ₯Ό μ¬μ©νκΈ° μν΄μ bucketμ λ§λ€κ³ , public μ κ·Όμ μ΄μ΄μ£ΌκΈ° μν policy generatorλ₯Ό νλ €κ³  νμΌλ S3 μμ²΄μ λ²κ·Έ λλ¬ΈμΈμ§ 
     add statement λ²νΌμ΄ νμ±ν λμ§ μμμ΅λλ€. μ΄λ₯Ό ν΄κ²°νκΈ° μν΄ awsμμ μ΄μνλ re:Post κ²μνμ μμ΄λ‘ μ§λ¬Έλ ν΄λ³΄κ³ , κ΅¬κΈλ§λ μ΄μ¬ν ν΄λ΄€μ§λ§ 
     ν΄κ²°μ΄ μ΄λ €μ μ΅λλ€. λν JsonμΌλ‘ μ§μ  policyλ₯Ό λ§λ€μ΄ μ£Όλ €κ³  μκ°μ νλλ°, μΈν°λ·μ μλ μμ λ€μ ID κ°κ³Ό statement κ°μ΄ μμ±λλ κ²μ λ³΄κ³  
     λ¬΄μ‘°κ±΄ generatorλ₯Ό κ±°μ³μΌ νλ μ€ μμμ ν¬κΈ°νμμ΅λλ€. κ·Έλ¬λ μμ€ νμ λΆμ μ§μΈμ΄ id κ°μ κ΅³μ΄ λ£μ΄ μ€ νμκ° μλ€κ³  νμμ, 
     jsonμΌλ‘ policy μ§μ  μμ± μ΄ν κ΅¬νμ μ±κ³΅νμ΅λλ€.
     
2. μλ¬λ©μμ§ : Ambiguous mapping. Cannot map 'accommodationController' method 
    - κ΅¬κΈλ§μΌλ‘ μ°Ύμλ³΄λ controllerμμ λ©μλλ κ°κ³  URLλ λκ°μ APIκ° λκ° λ§λ€μ΄μ Έμ μκΈ΄ μλ¬ λ©μμ§λΌκ³  ν΄μ νμΈν΄λ³΄λ μ λ§ λκ°μ λ©μλμ, URLλ κ°μ APIκ° μμ΄μ κ·Έ λΆλΆμ μμ νμ΅λλ€.
