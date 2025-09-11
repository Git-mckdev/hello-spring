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

- Spring Bean Chapter
1. @SpringBootApplication 어노테이션을 기반하여 실행된 클래스가 존재하는 패키지 내에서만 컴포넌트 스캔이 발생
2. @Controller, @Service, @Repository는 각각의 어노테이션 필수 (해당 세가지 어노테이션은 기본적으로 @Component를 내재)
3. 어노테이션을 기반하여 컴포넌트 스캔이 발생하고 @Autowired가 생성자의 매개변수를 자동으로 연결
4. Spring Bean은 Spring Container에 등록될 때, 기본적으로 객체의 인스턴스를 한개만 등록
5. 4번에 의거, 같은 Spring Bean일 경우, 모두 같은 인스턴스