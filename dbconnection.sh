#!/bin/bash

database=$1
username=$2
password=$3

cp ./src/main/resources/application.properties ./src/main/resources/application.properties.bak
sed "s/_database_/$database/g;s/_username_/$username/g;s/_password_/$password/g" ./src/main/resources/application.properties.bak > ./src/main/resources/application.properties