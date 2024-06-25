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
    │           ├── crypto
    │           │   ├── DecryptUtil.java
    │           │   └── EncryptUtil.java
    │           │
    │           ├── datatype
    │           │   ├── JsonUtil.java
    │           │   └── StringUtil.java
    │           │
    │           └── enums
    │               ├── CryptoEnum.java
    │               └── HashEnum.java
    └── test
        └── kr
            └── mook
                ├── crypto
                │   ├── DecryptUtilTest.java
                │   └── EncryptUtilTest.java
                │
                ├── datatype
                │   ├── JsonUtilTest.java
                │   └── StringUtilTest.java
                │
                └── dto
                    ├── UserTestDTO.java
                    └── UserTestDTO2.java
```

### 패키지 및 Util 코드 설명
####  crypto
- 숫자, 문자열 및 객체 등 데이터의 값을 암호문으로 변환하거나
- 암호문을 해석(복호화)하여 원래 데이터의 값으로 변환하기 위한 기능 제공
- 구성
    - DecryptUtil : 암호화된 문자열을 원래 데이터의 값으로 변환
        - AES 복호화 기능 제공
    - EncryptUtil : 숫자, 문자열, 객체 등의 데이터를 암호문으로 변환
        - SHA256 해시 암호화 기능 제공
        - AES 암호화 기능 제공
####  datatype
- 문자열, 숫자, 객체 등 데이터의 값을 검증하거나 형변환을 통해 값을 가져오는 등
- 각 타입 별 데이터의 값을 다루기 위한 기능 제공
- 구성
    - JsonUtil : JSON 형식의 문자열을 JSON 객체 또는 JSON 배열로 변환하거나 사용자가 지정한 객체 형태로 변환
    - StringUtil : 문자열의 값이 있는지 확인하거나 전달받은 데이터를 문자열 형태로 형변환
####  enums
- Util 모듈의 동작 시 필요한 데이터를 Enum 형태로 관리