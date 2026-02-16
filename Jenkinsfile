pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/Mukul-80/Microservices.git'
            }
        }

        stage('Build All Services') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Images') {
            steps {
                sh 'docker-compose build'
            }
        }

        stage('Push Images') {
            steps {
                sh 'docker-compose push'
            }
        }

        stage('Deploy to K8s') {
            steps {
                sh 'kubectl apply -f k8s/'
            }
        }
    }
}