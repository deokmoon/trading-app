#!/usr/bin/env bash
# 스프링 부트를 시작하는 스크립트

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)

REPOSITORY=/home/ec2-user/app

PROJECT_NAME=trading-app

echo "> 새 애플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/$PROJECT_NAME/*.jar | tail -n 1)


echo "> JAR Name: $JAR_NAME"

echo "> $JAR_NAME 에 실행권한 추가"

chmod +x $JAR_NAME


echo "> $JAR_NAME 실행"

nohup java -jar $JAR_NAME > $REPOSITORY/$PROJECT_NAME/nohup.out 2>&1 &
