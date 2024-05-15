## 📅 프로젝트 일정
프로젝트 기획, 요구사항 추출 (20240301 ~ 20240328)
>
기능 구현(20240328 ~ 20240419)

## <a name="section0" />🚀바로가기
### [1.💼프로젝트 산출물](#section1)
### [2.🧑🏻프로젝트 멤버](#section2)
### [3.👤역할 및 담당 업무](#section3)
### [4.📱기획 주제 선정](#section4)
### [5.🚨트러블 슈팅](#section5)
### [6.⚙️Stack & Tool](#section6)


### <a name="section1" />💼프로젝트 산출물
✔️ **프로젝트 산출물** 

[산출물.pdf](https://drive.google.com/file/d/1l_dddYCnEVWz-oKecsDQmQ9vSde1H-EO/view?usp=sharing)



### <a name="section2" />🧑🏻 프로젝트 멤버 [🔝](#section0)

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

## <a name="section3" />👤 역할 및 담당 업무 [🔝](#section0)

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
  * <a href="https://rlatmddnjs0103.tistory.com/214">상품/브랜드/주문/문의 검색/정렬 조회 기능</a>
  * 페이지 UI 구현 <a href="https://github.com/tldraw/make-real">Open Source AI 활용</a>
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
* <a href="https://rlatmddnjs0103.tistory.com/219">협업 툴 Notion을 통한 산출물 관리</a>


 
## <a name="section4" />📱기획 주제 선정 (20240215~202403) [🔝](#section0)

### 프로젝트 주제: 유저 개인의 성향을 파악해 추천을 해주는 의류 쇼핑몰, 쇼핑몰 관리자 웹 페이지 
**서비스**: 의류 쇼핑몰 서비스, 장바구니, 좋아요, 결제 등의 필수 기능부터,
개인의 활동 기록 데이터를 기반으로 컨텐츠 기반 AI 분석을 통한 개인 맞춤 의류 추천 제공
쇼핑몰 관리자가 브랜드, 유저, 상품별 통계 데이터, 활동 기록 등을 열람하고 관리할 수 있는 관리자용 기능 제공

  
**주제 선정 이유**  
  
쇼핑몰
* 팀장을 제외한 팀원 모두가 처음 경험하는 프로젝트이고 사전 지식이 부족했다.
* 기존 6인의 팀원들의 업무를 잘 분담해 웹 개발의 Basic한 것들을 전원이 충분히 익힐 수 있으면 좋을 것 같다는 생각이 들어 확장이 쉬운 쇼핑몰을 주제로 선정했다.
* 쇼핑몰을 주제로 하면 특히 백엔드 개발자에게 중요한 몇가지를 모두 충분히 수행해 볼 수 있을 것 같았다.
  * 데이터베이스 테이블 작성
  * 쿼리 작성
  * API 설계(예외 처리, 트랜잭션 관리)
  * 프론트, 백 간 응답, 요청 상호작용 이해 및 협업 적응


  
ML 데이터 분석 추천 시스템, 배치 프로그램 <a href="https://github.com/Kim-soung-won/DjangoWeb"></a>
* <a href="https://github.com/Kim-soung-won/Drink-labeling">지난 프로젝트</a>에서 처음 AI를 사용하며 파이썬 프로그램의 필요성을 느꼈고 AI를 파이썬 서버로 적용한 프로젝트를 구현해보고 싶었다.
* AI를 이용한 서비스를 구현해 보는 것은 좋은 경험이 될 것이라고 생각했다.
* 초기 기획은 API 서버로 구상했는데, 개발 과정에서 Python에 요구되는 작업들은 굳이 실시간 처리가 아닌 배치로 수행하고 실시간 처리는 Spring서버로 충분하다는 생각이 들었다.


## <a name="section5" />🚨트러블 슈팅 [🔝](#section0)

---

### 트러블1. [배치 연산 작업 수정을 통한 성능 70% 개선]

<a href="https://rlatmddnjs0103.tistory.com/224">작성한 블로그 링크</a>  

🚨 **문제 배경**

약 4000명의 유저에 대한 기록 추출 → 직렬화 → Cosine유사도 비교 후 추천 상품 출력에 대한
배치 작업의 수행 시간이 총 약 15분, 1명당 0.3초로 긴 작업시간이 소요됨, 작업시간 단축을 위한 배치 프로그램 수정이 요구됐다.

⭐️ **해결 방법**

작업 과정에서 다량의 조회 쿼리가 발견됐고, 데이터 조회 로직을 수정하여 1명당 약 0.08 ~ 0.1초로 작업시간 효율이 70% 정도 상승하였다.

🤩 **해당 경험을 통해 알게된 점**

배치 작업을 구현하고 수정하며 기존에 API를 통한 실시간 처리에서는 변별하기 어려웠던, 백엔드 로직의 중요성에 대해서 더 크게 체감할 수 있었다.

---



## <a name="section6" />⚙️Stack & Tool [🔝](#section0)

### 프론트엔드
- JavaScript

### UI
- Figma
- <a href="https://github.com/tldraw/make-real">make-real(open source 생성형 AI)</a>

### 백엔드  
##### Spring Boot3 (실시간 API 처리)
* 선정 이유
  * 첫 프로젝트에서 기능 구현의 핵심은 온라인에서 얻을 수 있는 Resource라고 생각했고 Spring regacy보다는 SpringBoot3에 대한 글과 자료가 많았다.
  * 초보, 진입자일수록 프레임워크는 간편해야한다고 생각했고, 단순 로직과 웹 구현의 패턴에 익숙해지는 것이 가장 중요하다고 생각했다.  
##### Django (배치 작업 처리) <a href="https://github.com/Kim-soung-won/DjangoWeb">Git Repository</a>
* 선정 이유
  * sklearn, pandas, numpy, pickle 등 데이터 처리에 유용한 라이브러리를 파이썬이 제공했다.
  * 프로젝트 초기에는 실시간 처리를 할 것이라고 기획하여 Flask와 Django 중 더 친절한 프레임워크인 Django를 선택했다.  
##### Mybatis
* 선정 이유
  * native 쿼리를 많이 작성해보는 경험이 중요할 것이라고 생각했다.

### DBMS  
##### MySQL8

### DevOps
- NCP
- Docker
- Jenkins

### 커뮤니케이션
- Notion
- Figma




