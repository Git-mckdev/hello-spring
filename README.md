- Build Chapter
1. ./gradlew.bat build 또는 ./gradlew.bat clean build 명령어로 .jar 파일 빌드 가능
2. ./build/libs 경로로 이동하여 java -jar hello-spring-0.0.1-SNAPSHOT.jar 명령어로 빌드된 .jar 파일 실행 가능

- Static, MVC, API Chapter
1. Static의 경우 파일을 그대로 전송
2. MVC의 경우 Model, View, Controller 방식으로 나눠 전송
3. API의 경우 객체를 Json 타입으로 전송

- Test Case Chapter
1. Test Class를 생성하여 테스트 진행 가능
2. Test Class의 모든 메서드는 순서 보장이 되지 않음
3. 2번의 문제를 해결하기 위해 @AfterEach를 사용하여 각 메서드마다 테스트 후 사용된 데이터를 초기화
4. @BeforeEach는 @AfterEach와 반대로 각 메서드마다 테스트 전 동작하는 방식

- Spring Bean Chapter 1 (@Controller + @Service + @Repository)
1. @SpringBootApplication 어노테이션을 기반하여 실행된 클래스가 존재하는 패키지 내에서만 컴포넌트 스캔이 발생
2. @Controller, @Service, @Repository는 각각의 어노테이션 필수 (해당 세가지 어노테이션은 기본적으로 @Component를 내재)
3. 어노테이션을 기반하여 컴포넌트 스캔이 발생하고 @Autowired가 생성자의 매개변수를 자동으로 연결 (가장 권장되는 방식)
4. Spring Bean은 Spring Container에 등록될 때, 기본적으로 객체의 인스턴스를 한개만 등록
5. 4번에 의거하여 같은 Spring Bean일 경우, 모두 같은 인스턴스

- Spring Bean Chapter 2 (@Controller + @Configuration + @Bean)
1. @Configuration, @Bean 어노테이션을 이용해 Java 코드로 Spring Bean 의존성을 직접 주입도 가능
2. @Autowired를 생성자가 아닌 필드 어노테이션으로 선언도 가능 (권장되지 않는 방식)
3. @Autowired를 생성자가 아닌 Setter Injection 방식 어노테이션으로 선언도 가능 (권장되지 않는 방식)
4. @Autowired는 Spring Bean Chapter 1, 2 어노테이션 방식을 이용하여 의존성을 주입하였을 경우에만 동작

- Member Chapter
1. 스프링 MVC는 요청 처리 시 @Controller 매핑을 먼저 찾고, 없으면 정적 자원을 찾음
2. GET 메소드는 정보 조회, POST 메소드는 데이터 생성 및 변경 등에 사용
3. html 요소의 속성 중 name="name" 과 같은 형태는 "" 안에 있는 이름을 컨트롤러에서 객체의 속성으로 인식
4. @Controller는 Model 객체에 "addAttribute" 메소드를 사용하여 View 템플릿에 전달한 데이터를 담음
5. 4번에 의거하여 View 리졸버가 View 템플릿을 찾고 Thymeleaf가 이 데이터를 렌더링

- DB Chapter
1. build.gradle에 의존성을 추가하여 DB 라이브러리 사용
2. application.properties에 DB 연결에 필요한 속성들을 추가
3. DataSource도 Spring을 사용하여 @Configuration에서 @Autowired 방식으로 주입 받을 수 있음

- JDBC, JDBC Template, MyBatis, JPA, Spring Data JPA Chapter
1. JDBC, JDBC Template, MyBatis, JPA, Spring Data JPA 등 다양한 방식이 있음