pipeline {
    agent any

    environment {
        IMAGE_NAME = "order-service"
        CONTAINER_NAME = "order-service"
        PORT = "8080"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/for-hygge/order-service.git'
            }
        }

        stage('Build') {
            steps {
                dir('order-service') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('order-service') {
                    sh 'docker build -t $IMAGE_NAME .'
                }
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop $CONTAINER_NAME || true
                docker rm $CONTAINER_NAME || true
                docker run -d -p $PORT:$PORT --name $CONTAINER_NAME $IMAGE_NAME
                '''
            }
        }
    }
}