pipeline {
    agent any
    environment {
        IMAGE_NAME = "dwarkadhish2005/smart-task-manager"
    }
    tools {
        maven 'Maven'
        jdk 'JDK26'
    }
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Dwarkadhish2005/smart-task-manager.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
        always {
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }
    }
}