pipeline {
    agent any
    
    tools{
		maven 'Maven3'
	}

    environment {
        DOCKERHUB_USER = "mukul-80"
    }

    stages {
		
		stage('Test Stage') {
            steps {
                echo 'Pipeline is running correctly'
            }
        }

        stage('Build All Services') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Build Docker Images') {
            steps {
                sh 'docker build -t $DOCKERHUB_USER/service-registry ./service-registry'
                sh 'docker build -t $DOCKERHUB_USER/api-gateway ./api-gateway'
                sh 'docker build -t $DOCKERHUB_USER/auth-service ./auth-service'
                sh 'docker build -t $DOCKERHUB_USER/account-service ./account-service'
                sh 'docker build -t $DOCKERHUB_USER/loan-service ./loan-service'
                sh 'docker build -t $DOCKERHUB_USER/transaction-service ./transaction-service'
            }
        }

        stage('Push Images') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                }

                sh 'docker push $DOCKERHUB_USER/service-registry'
                sh 'docker push $DOCKERHUB_USER/api-gateway'
                sh 'docker push $DOCKERHUB_USER/auth-service'
                sh 'docker push $DOCKERHUB_USER/account-service'
                sh 'docker push $DOCKERHUB_USER/loan-service'
                sh 'docker push $DOCKERHUB_USER/transaction-service'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f k8s/'
            }
        }
    }
}