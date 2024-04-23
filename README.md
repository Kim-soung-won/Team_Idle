## 📅 프로젝트 일정
프로젝트 기획, 요구사항 추출 (20240215 ~ 20240328)
>
기능 구현(20240328 ~ 20240419)



### 🧑🏻 프로젝트 멤버

<table>
 <tr>
    <td align="center"><a href="https://github.com/Ryuwongeun"><img src="https://avatars.githubusercontent.com/u/156384148?v=4" width="130px;""></a></td>
    <td align="center"><a href="https://github.com/SOOYEON21428"><img src="https://avatars.githubusercontent.com/u/154400842?v=4" width="130px;""></a></td>
    <td align="center"><a href="https://github.com/dl11911"><img src="https://avatars.githubusercontent.com/u/156390295?v=4" width="130px;""></a></td>
    <td align="center"><a href="https://github.com/Kim-soung-won"><img src="https://avatars.githubusercontent.com/u/105148570?s=400&u=907826e3bb99585a1a124720903cc468bde24bbb&v=4" width="130px;""></a></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/Ryuwongeun"><b>원근</b></a></td>
    <td align="center"><a href="https://github.com/gywls20"><b>수연</b></a></td>
    <td align="center"><a href="https://github.com/dl11911"><b>승훈</b></a></td>
    <td align="center"><a href="https://github.com/Kim-soung-won"><b>승원</b></a></td>
  </tr>
</table>

## 프로젝트 담당 업무

**팀장** 
* <a href="https://rlatmddnjs0103.tistory.com/218">데이터베이스 테이블 설계, UML 작성</a>
* <a href="https://rlatmddnjs0103.tistory.com/134">팀원 데이터 베이스 기초 교육</a>
* <a href="https://rlatmddnjs0103.tistory.com/217">API 통신 설계 및 원리 기초 교육</a>
* 개발 업무 분담
* 기술 스택 선택
* 팀원 코드 리뷰

**SpringBoot 메인 기능 구현**
* 관리자 페이지
  * 상품 등록 및 수정 기능
  * 상품/브랜드/주문/문의 검색/정렬 조회 기능
  * 관리자 권한 관리
  * 상품 이미지 등록 및 상품 대표 이미지 선택 기능
  * 고객 문의 응답 Email 전송 기능

    
* 사용자 페이지
  * 좋아요, 장바구니, 결제 시스템, OAuth 및 세션 인증 로그인 기능
  * 회원가입 유효성 검사를 위한 Email 유효성 검사 기능
  * 댓글 및 댓글 이미지 입력 및 관리 기능
  * 개인 결제 내역 열람 및 문의 기능
 
**Django 서브 기능 구현**
* 데이터 분석 및 유저 Log 분석을 통한 추천 상품 목록 출력
  * sklearn, pandas를 활용한 데이터 학습 및 cosine 유사도를 통한 물품 추천
* Dummy 데이터 셋 구성
  * Django Command 명령을 바탕으로한 상품, 결제 기록 등 개발용 데이터 셋 구축
 
**배포 및 유지보수**
* NaverCloudServer, VPC, Subnet 구성
* Docker - Jenkins, ssh 서버 이미지 구성 및 관리
* Jenkins - Github 연동 및 빌드 관리
* ObjectStorage - 이미지, 영상 파일 등 정적 Resource 관리

**개발 외 담당 업무**
* PPT 제작 및 발표
* JQuery를 통한 HTML 코드 재사용성 증진
* 협업 툴 Notion을 통한 산출물 관리


 
## 기획 주제 선정 (20240215~202403)

**프로젝트 주제**: 유저 개인의 성향을 파악해 추천을 해주는 의류 쇼핑몰, 쇼핑몰 관리자 웹 페이지

**팀명**: Idle

**서비스**: 의류 쇼핑몰 서비스, 장바구니, 좋아요, 결제 등의 필수 기능부터,
개인의 활동 기록 데이터를 기반으로 컨텐츠 기반 AI 분석을 통한 개인 맞춤 의류 추천 제공
쇼핑몰 관리자가 브랜드, 유저, 상품별 통계 데이터, 활동 기록 등을 열람하고 관리할 수 있는 관리자용 기능 제공


## Stack & Tool 

### 프론트엔드
- JavaScript

### UI
- Figma
- <a href="https://github.com/tldraw/make-real">make-real(open source 생성형 AI)</a>

### 백엔드
- Spring Boot3 (실시간 API 처리)
- Django (배치 작업 처리) <a href="https://github.com/Kim-soung-won/DjangoWeb">Git Repository</a>
- Maven
- Mybatis

### DBMS
- MySQL8

### 데브옵스
- NCP
- Docker
- Jenkins

### 커뮤니케이션
- Notion
- Figma


## USE FLOW 작성(20240215 ~ 202403)

플랫폼의 전반적인 흐름을 파악하고, 각 기능의 사용자 행동과 시스템의 반응을 이해하기 위해 간략한 USE FLOW를 작성했습니다. 이를 통해 개발 과정에서 사용자 경험을 최적화하고, 팀원들 간의 의사소통을 원활하게 할 수 있었습니다.
<a href="https://www.figma.com/file/1KFbkj4vKSujqFk2TNB6a2/FlowChart-Miniproject?type=whiteboard&node-id=0-1&t=Ikz0ZWOSbVphNdMF-0">Figma링크</a>
![image](https://github.com/Kim-soung-won/Team_Idle/assets/105148570/be17ad42-61e0-4f75-97d9-f52dad003d1a)


## DB 작성(20240215 ~ 202404)

USE FLOW와 요구사항, 목표 기능을 바탕으로 DB 테이블 ERD 작성.
구현 과정에서 발견되는 미흡한 요소, 기능 추가, 제거를 진행하며 부족한 부분 보완 <a href="https://www.figma.com/file/dPHZkuFxpshwaDvvRLMAVH/MiniShoppingMall?type=whiteboard&node-id=0-1&t=BEXR0nZ5QxB3gvvR-0">Figma 링크</a>
![image](https://github.com/Kim-soung-won/Team_Idle/assets/105148570/b5f49ff4-0e8a-4490-93e5-e26ad77ec484)




