# 프로젝트 적용 중점 
1. 기존 프로젝트에서 사용되던 dbcp(database connection pool)와 ssl의 적용을 시도하였음, 데이터와 연결시 username, password, url을 PBEWITHMD5ANDDES를 사용 암호화 하였음
2. ssl의 경우 ca(certificate authority)적용하지 못한 상태, 단순히 jdk의 .keyTool을 이용하여 https 서버로 등록한거뿐

# 아쉬웠던 점
1. JNDI와 Spring Profile을 사용하지 않아 서버와 어플리케이션 간의 최적화를 고려하지 못함
2. src/main/webapp 이하에 설정파일을 등록함으로 src/main/resource, src/main/webapp에 설정파일이 분리되는 현상 발생 
   설정파일만 잘 정리할 수 있도록 src/main/resource에서 처리하는 것이 좋아보임
