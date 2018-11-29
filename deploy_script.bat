cd ./backend/UserService
start "deploy UserService" cmd /c "mvn clean package && ibmcloud cf push"

cd ../SubjectService
start "deploy SubjectService" cmd /c "mvn clean package && ibmcloud cf push"

cd ../VideoService
start "deploy VideoService" cmd /c "mvn clean package && ibmcloud cf push"

cd ../MaterialService
start "deploy MaterialService" cmd /c "mvn clean package && ibmcloud cf push"
