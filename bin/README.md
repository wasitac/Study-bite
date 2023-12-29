# Study bite

**스프링 프레임워크와 마이바티스를 활용한 MVC Model2 기반 웹 애플리케이션 개발**

주제 : LMS(학습관리 시스템)

팀장 :  이지홍

팀원 : 김민혜, 송창민, 신지은



## 개발 환경

### 프로젝트 관리

notion, google drive

### 버전관리

github

STS3

### 기술스택

- 프론트엔드
    
    HTML, CSS, JS, Bootstrap, XML
    
- 백엔드
    
    Java, Spring Framework, mybatis, Tomcat
    
- DB
    
    mysql
    

### IDE

STS3

- 버전
    
    java11
    
    springframework5.2.25.RELEASE
    
    Tomcat v8.5
    
    mybatis 3.5.14
    
    mybatis-spring 2.1.2
    
    mysql 8.0.22

## 폴더 구조
### backend
```
─himedia
    └─project
        └─studybite
            ├─controller
            │      CourseController.java
            │      UserController.java
            │
            ├─domain
            │      Content.java
            │      Course.java
            │      News.java
            │      Notice.java
            │      Qna.java
            │      User.java
            │      UserCourse.java
            │
            ├─repository
            │      contentMapper.java
            │      courseMapper.java
            │      NewsMapper.java
            │      NoticeMapper.java
            │      QnaMapper.java
            │      UsercourseMapper.java
            │      UserMapper.java
            │
            └─service
                    CourseService.java
                    UserCourseService.java
                    UserService.java
```
