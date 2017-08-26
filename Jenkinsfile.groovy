pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo "Starting Build"
                sh 'make' 
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                echo "Build Complete"
            }
        }
    }
}