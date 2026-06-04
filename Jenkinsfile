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
            git 'https://github.com/Dwarkadhish2005/smart-task-manager.git'
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
    // stage('Build Docker Image') {
    //     steps {
    //         sh 'docker build -t $IMAGE_NAME:latest .'
    //     }
    // }
    // stage('Push Docker Image') {
    //     steps {
    //         withCredentials([usernamePassword(
    //             credentialsId: 'dockerhub-creds',
    //             usernameVariable: 'DOCKER_USER',
    //             passwordVariable: 'DOCKER_PASS'
    //         )]) {
    //             sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
    //             sh 'docker push $IMAGE_NAME:latest'
    //         }
    //     }
    // }
}
post {
    success {
        echo 'Pipeline executed successfully!'
    }
    failure {
        echo 'Pipeline failed!'
    }
    always {
        archiveArtifacts artifacts: 'target/*.jar'
    }
}

}
