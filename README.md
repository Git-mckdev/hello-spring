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