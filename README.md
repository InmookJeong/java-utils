# Java 프로그래밍에 필요한 Utils 개발
### 개발 목표
- JAVA를 활용한 애플리케이션 개발 시 공통적으로 사용할 수 있는 소스코드를 개발
- 라이브러리(lib) 형식으로 제공하여 개발 편의성 제공

### 소스코드 구성
```bash

└── src
    ├── main
    │   └── kr
    │       └── mook
    │           └── datatype
                    └── StringUtil.java
    └── test
        └── kr
            └── mook
                └── datatype
                    └── StringUtilTest.java
```

### 패키지 및 Util 코드 설명
####  datatype
- 문자열, 숫자, 객체 등 데이터의 값을 검증하거나 형변환을 통해 값을 가져오는 등
- 각 타입 별 데이터의 값을 다루기 위한 기능 제공
- 구성
    - StringUtil : 문자열의 값이 있는지 확인하거나 전달받은 데이터를 문자열 형태로 형변환