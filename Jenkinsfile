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

                // Will retry below script 2 times if not successful
                sh 'chmod +x ./retry_me.sh'
                retry(2) {
                    sh './retry_me.sh'
                }

                // Below script runs for 11 seconds and would always get timed out
                sh 'chmod +x ./should_timeout.sh'
                timeout(time: 10, unit: 'SECONDS') {
                    sh './should_timeout.sh'
                }
            }
        }
    }
    // Clean up steps after a build is executedl
    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'Your build was successful'
        }
        failure {
            echo 'Oops, the build failed!'
        }
        unstable {
            echo 'Will run if build is marked unstable'
        }
        changed {
            echo 'Will run if state of pipeline has changed'
            echo 'E.g. a build that was previously failing starts to pass'
        }
    }
}
