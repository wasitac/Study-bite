# **Study bite**
### **스프링 프레임워크와 마이바티스를 활용한 MVC Model2 기반 웹 애플리케이션 개발**
### 주제 : LMS(학습관리 시스템)<br>
#### 프로젝트 기간: 2023.12.12 ~ 2024.01.04<br>
#### 배포: http://3.39.21.183:9999/studybite-1.0.0-BUILD-SNAPSHOT/<br>
학생 id: edcqaz19@naver.com/pw: 1111<br>
강사 id: hong@gmail.com / PW : 1111

#### 산출물: https://drive.google.com/drive/folders/1MCcwADfoYAukfyV_YaAiUIOK2xAHi0NO?usp=drive_link

## **개발환경**<br>
|   |    |
----|----|
**OS**|Windows 10|
**IDE**|Spring Tool Suite 3 3.9.18.RELEASE|
**Front-end**|HTML<br>CSS<br>JavaScript<br>JSP<br>XML<br>Bootstrap 5.3|
**Back-end**|Java 11<br>Spring Framework 5.2.25.RELEASE<br>MyBatis 3.5.14<br>MyBatis-spring 2.1.2<br>lombok 1.18.30|
**Web Server**|Tomcat 8.5|
**Database**|MySQL 8.0.22|
<br>

## **팀원별 업무 분담**<br>
|    |**이지홍(팀장)**|**김민혜(팀원)**|**송창민(팀원)**|**신지은(팀원)**|
|----|---|---|---|---|
|**Front**|**페이지**<br>- 로그인<br>- 내 정보<br>- 비밀번호 변경<br>- 강사 대시보드<br>**컴포넌트**<br>- leftbar(학습자)<br>- rightbar(알림)|**페이지**<br>-공지사항<br>- 질의 응답 목록/상세/등록<br>- 질의 응답 답변 등록<br>- 강의 공지 목록<br>**컴포넌트**<br>- courseBar- 페이지네이션|**페이지**<br>- 학습자 대시보드<br>- 수강과목<br>- 출결관리<br>**컴포넌트**<br>- leftbar(강사)<br>- rightbar|**페이지**<br>- 강의 개요<br>- 강의 수강<br>- 강사 공지 작성/수정<br>- 질의 응답 수정/삭제<br>**컴포넌트**<br>- courseTitle|
|**Back**|- 로그인/로그아웃<br>- 로그인 인증<br>- 비밀번호 변경<br>- 알림<br>|- 공지사항<br>- 강의 공지 목록 조회<br>- 질문/답변<br>- 페이지네이션<br>- 검색<br>|- 대시보드<br>- 코스 목록<br>- 수강 여부<br>- 수료한 강의<br>- 게시글 목록 넘버링<br>|- 코스 개요<br>- 콘텐츠 목차<br>- 콘텐츠 수강<br>- 게시글 파일 업로드/다운로드<br>- 게시글 수정/삭제 <br>- 강의 공지 등록<br>|

<br>

## **주요 기능**
### **대시보드**
<img src="https://github.com/wasitac/Study-bite/assets/67859497/0a3a190d-4e0f-4375-a664-60289f235095" width="600" border="1px solid"><br>
### **출결 확인** 
<img src="https://github.com/wasitac/Study-bite/assets/67859497/408fb84f-2c0a-4f83-b885-2272ab602a8a" width="600" border="1px solid"><br>
<img src="https://github.com/wasitac/Study-bite/assets/67859497/f3a1ddb7-69d7-4b81-874a-90352f91ef84" width="600" border="1px solid"><br>
### **비밀번호 수정**
<img src="https://github.com/wasitac/Study-bite/assets/67859497/8a9742ff-8ebb-4f6c-bf25-8908cfc07ab9" width="600" border="1px solid"><br>
### **질의 응답**
<img src="https://github.com/wasitac/Study-bite/assets/67859497/8f5a90cb-772a-4ef3-846d-f3000089e718" width="600" border="1px solid"><br>

## **폴더 구조**<br>
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
