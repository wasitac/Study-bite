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


### 기술스택
- IDE
    STS3

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
+---java
|   \---himedia
|       \---project
|           \---studybite
|               +---controller
|               |       CourseController.java
|               |       UserController.java
|               |
|               +---domain
|               |       Content.java
|               |       ContentData.java
|               |       Course.java
|               |       FileBoard.java
|               |       News.java
|               |       Notice.java
|               |       Notification.java
|               |       Qna.java
|               |       User.java
|               |       UserCourse.java
|               |
|               +---dto
|               |       PasswordUpdate.java
|               |       UserLogin.java
|               |
|               +---interceptor
|               |       LoginInterceptor.java
|               |       NotificationInterceptor.java
|               |
|               +---repository
|               |       BoardMapper.java
|               |       contentMapper.java
|               |       courseMapper.java
|               |       NewsMapper.java
|               |       NoticeMapper.java
|               |       NotificationMapper.java
|               |       QnaMapper.java
|               |       UsercourseMapper.java
|               |       UserMapper.java
|               |
|               \---service
|                       CourseService.java
|                       NotificationService.java
|                       UserCourseService.java
|                       UserService.java
|
+---resources
|   |   log4j.xml
|   |
|   \---studybite
|       +---config
|       |       studybite-config.xml
|       |
|       \---mapper
|               news-mapper.xml
|               notice-mapper.xml
|               qna-mapper.xml
|               user-course-mapper.xml
|               user-mapper.xml
|
\---webapp
    +---META-INF
    |   |   MANIFEST.MF
    |   |
    |   \---maven
    |       \---himedia.project
    |           \---studybite
    |                   pom.properties
    |                   pom.xml
    |
    +---resources
    |   +---css
    |   |       bootstrap.min.css
    |   |       color.css
    |   |       courseTitle.css
    |   |       leftbar.css
    |   |       rightbar.css
    |   |       sign-in.css
    |   |
    |   +---files
    |   |
    |   +---img
    |   |   |   back.png
    |   |   |   bellIcon.png
    |   |   |   bluePerson.png
    |   |   |   GYiqyk9.jpeg
    |   |   |   iconOne.png
    |   |   |   logo.png
    |   |   |   logoSmall.png
    |   |   |   react.png
    |   |   |   reactLogo.jpeg
    |   |   |   userIcon.png
    |   |   |   강의개요1.PNG
    |   |   |
    |   |   +---courseIcon
    |   |   |       iattendance.png
    |   |   |       iattendancec.png
    |   |   |       ibell.png
    |   |   |       ibellc.png
    |   |   |       ibook.png
    |   |   |       ibookc.png
    |   |   |       inote.png
    |   |   |       inotec.png
    |   |   |
    |   |   +---courseOutline
    |   |   |       Python프로그래밍.png
    |   |   |       경제학.png
    |   |   |       데이터베이스.png
    |   |   |       자료구조.png
    |   |   |       컴퓨터식 프로그래밍.png
    |   |   |       컴퓨터식문제해결 기법.png
    |   |   |
    |   |   +---favicon
    |   |   |       favicon.ico
    |   |   |
    |   |   +---homeIcon
    |   |   |       ibell.png
    |   |   |       ibellc.png
    |   |   |       ibook.png
    |   |   |       ibookc.png
    |   |   |       ihome.png
    |   |   |       ihomec.png
    |   |   |       imypage.png
    |   |   |       imypagec.png
    |   |   |
    |   |   \---thumbnail
    |   |           computationalThinking.png
    |   |           computerArchitecture.jpg
    |   |           dataBase.png
    |   |           dataStructure.jpg
    |   |           economic.png
    |   |           python.png
    |   |
    |   \---js
    |           basic.js
    |           courseBar.js
    |           notification.js
    |
    \---WEB-INF
        |   web.xml
        |
        +---spring
        |   |   root-context.xml
        |   |
        |   \---appServlet
        |           servlet-context.xml
        |
        \---views
            |   index.jsp
            |
            +---common
            |       alert.jsp
            |       config.jsp
            |       courseBar.jsp
            |       courseTitle.jsp
            |       footer.jsp
            |       leftbar.jsp
            |       pagination.jsp
            |       rightbar.jsp
            |       url.jsp
            |
            +---course
            |       attendance.jsp
            |       content.jsp
            |       contentList.jsp
            |       info.jsp
            |       NewFile.jsp
            |       news.jsp
            |       newsAdd.jsp
            |       newsDesc.jsp
            |       newsForm.jsp
            |       qna.jsp
            |       qnaDesc.jsp
            |       qnaEditForm.jsp
            |       qnaForm.jsp
            |
            \---home
                    course.jsp
                    home.jsp
                    mypage.jsp
                    mypageUpdate.jsp
                    notice.jsp
                    noticeDesc.jsp
```
