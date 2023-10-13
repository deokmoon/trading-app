#!/usr/bin/env bash
# 서비스 종료하는 스크립트

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)

echo "> 현재 구동 중인 애플리케이션 pid 확인"

IDLE_PID=$(pgrep -fl trading-app | grep java | awk '{print $1}')

if [ -z ${IDLE_PID} ]
then
  echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $IDLE_PID"
  kill -15 ${IDLE_PID}
  sleep 5
fi
