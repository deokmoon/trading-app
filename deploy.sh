#!/bin/bash
# 직접 배포 시 사용되는 스크립트

echo "> 현재 환경 확인"

ACTIVE_PROFILE=$1

echo "> 현재 환경: ${ACTIVE_PROFILE}"

echo "> 현재 구동 중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -fl trading | grep java | awk '{print $1}')

echo "> 현재 구동 중인 애플리케이션 pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 애플리케이션 배포"

JAR_NAME=$(ls -tr build/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> $JAR_NAME 에 실행권한 추가"

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

#nohup /opt/java/openjdk/bin/java -jar -Dspring.config.location=classpath:/application.yml,classpath:/application-oauth.yml,classpath:/application-real-db.yml,classpath:/application-$IDLE_PROFILE.yml -Dspring.profiles.active=$IDLE_PROFILE $JAR_NAME > nohup.out 2>&1 &
nohup /opt/java/openjdk/bin/java -jar -Dspring.profiles.active=$ACTIVE_PROFILE $JAR_NAME > nohup.out 2>&1 &

echo "> 배포완료"
