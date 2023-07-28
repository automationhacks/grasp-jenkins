/* Requires the Docker Pipeline plugin */
/* Following tut from: https://www.jenkins.io/doc/pipeline/tour/getting-started/ */
pipeline {
    agent { docker { image 'maven:3.9.3-eclipse-temurin-11' } }
    stages {
        stage('build') {
            steps {
                sh 'echo Woot woot! First Jenkins pipeline!'
                sh '''echo Does multiline work?
                ls -lrt
                echo Yeah!
                '''
                sh 'mvn --version'

                sh 'chmod +x ./retry_me.sh'
                retry(2) {
                    sh './retry_me.sh'
                }

                sh 'chmod +x ./should_timeout.sh'
                timeout(time: 10, unit: 'SECONDS') {
                    sh './should_timeout.sh'
                }


            }
        }
    }
}
