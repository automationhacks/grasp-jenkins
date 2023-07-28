/* Requires the Docker Pipeline plugin */
pipeline {
    agent { docker { image 'maven:3.9.3-eclipse-temurin-11' } }
    stages {
        stage('build') {
            steps {
                sh 'echo Woot woot! First Jenkins pipeline!'
                sh '''echo Okay and multi line
                comments work as well
                Dang!
                '''
                sh 'mvn --version'
            }
        }
    }
}
