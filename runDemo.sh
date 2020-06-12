#!/bin/bash
#Demo startup script if needed for docker

mvn clean package

sleep 40

docker-compose up --build