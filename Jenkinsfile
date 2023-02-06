// Declarative //
pipeline {
    agent any
    tools {
        gradle 'Gradle_7.6'     // Gradle_7.6 is set manually in Jenkins Global Tool Configuration
    }
    stages {
        stage("Build Backend") {
            steps {
                echo '|------------------> Build Backend <------------------|'

                echo "...Update Database Credentials"

                // Update DB Credentials 1 - Credentials values are stored in dbconnection
                /* 
                sh "chmod +x ./dbconnection.sh"
                sh "./dbconnection.sh"
                */

                // Update DB Credentials 2 - Get user inputs for credentials values
                timeout(time: 2, unit: 'MINUTES') {
                    script {
                        env.DB_NAME = input message: 'Enter DB Name',
                                            parameters: [ string(defaultValue: '',
                                                        description: '',
                                                        name: 'DB Name') ]
                        env.DB_USER_NAME = input message: 'Enter DB User Name',
                                            parameters: [ string(defaultValue: '',
                                                        description: '',
                                                        name: 'DB User Name') ]
                        env.DB_USER_PASSWORD = input message: 'Enter DB User Password: ',
                                            parameters: [ password(defaultValue: '',
                                                        description: '',
                                                        name: 'DB User Password') ]
                    }   
                }             
                sh "./dbconnection.sh ${env.DB_NAME} ${env.DB_USER_NAME} ${env.DB_USER_PASSWORD}"

                echo "...Build Gradle project"
                sh "./gradlew clean build"      // use wrapper to build Gradle project
            }
        }
    }
}