#!/bin/bash

sed -i 's/_database_/$1/' src/main/resources/application.properties
sed -i 's/_username_/$2/' src/main/resources/application.properties
sed -i 's/_password_/$3/' src/main/resources/application.properties