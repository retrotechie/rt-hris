#!/bin/bash

cp ./src/main/resources/application.properties ./src/main/resources/application.properties.bak
sed 's/_database_/$1/g; s/_username_/$2/g; s/_password_/$3/g' ./src/main/resources/application.properties.bak > ./src/main/resources/application.properties