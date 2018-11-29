cd ./backend/UserService
start "run UserService at port 8081" cmd /c "mvn clean package && mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081"

cd ../SubjectService
start "run SubjectService at port 8082" cmd /c "mvn clean package && mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8082"

cd ../VideoService
start "run VideoService at port 8083" cmd /c "mvn clean package && mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8083"

cd ../MaterialService
start "run MaterialService at port 8084" cmd /c "mvn clean package && mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8084"