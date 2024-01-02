# Study bite

**스프링 프레임워크와 마이바티스를 활용한 MVC Model2 기반 웹 애플리케이션 개발**

주제 : LMS(학습관리 시스템)

팀장 :  이지홍

팀원 : 김민혜, 송창민, 신지은


## 개발환경
OS        : Windows 10
IDE       : Spring Tool Suite 3 3.9.18.RELEASE
Front-end : HTML, CSS, JavaScript, JSP, XML
            Bootstrap 5.3
Back-end  : Java 11
            Spring Framework 5.2.25.RELEASE
            MyBatis 3.5.14
            MyBatis-spring 2.1.2
            lombok 1.18.30
Web Server: Tomcat v8.5
Database  : MySQL 8.0.22


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
|               +---dto
|               |       Content.java
|               |       ContentData.java
|               |       Course.java
|               |       FileBoard.java
|               |       News.java
|               |       Notice.java
|               |       Notification.java
|               |       PasswordUpdate.java
|               |       Qna.java
|               |       User.java
|               |       UserCourse.java
|               |       UserLogin.java
|               |
|               +---interceptor
|               |       LoginInterceptor.java
|               |       NotificationInterceptor.java
|               |
|               +---mapper
|               |       BoardMapper.java
|               |       ContentMapper.java
|               |       CourseMapper.java
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
|               notification-mapper.xml
|               qna-mapper.xml
|               user-course-mapper.xml
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
    |   |       blog.css
    |   |       bootstrap.min.css
    |   |       color.css
    |   |       courseTitle.css
    |   |       footer.css
    |   |       leftbar.css
    |   |       prevNext.css
    |   |       rightbar.css
    |   |       sign-in.css
    |   |
    |   +---img
    |   |   |   back.png
    |   |   |   bellIcon.png
    |   |   |   bluePerson.png
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
    |   |           computerArchitecture.png
    |   |           dataBase.png
    |   |           dataStructure.png
    |   |           economic.png
    |   |           python.png
    |   |
    |   \---js
    |           active.js
    |           course.js
    |           courseBar.js
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
            |       editForm.jsp
            |       info.jsp
            |       instructor.jsp
            |       news.jsp
            |       newsDesc.jsp
            |       newsForm.jsp
            |       qna.jsp
            |       qnaDesc.jsp
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
