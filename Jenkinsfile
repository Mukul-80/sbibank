pipeline {
    agent any
    
    tools{
		maven 'Maven3'
	}

    environment {
        DOCKERHUB_USER = "mukulsharma1212ms"
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
                sh 'docker build -t $DOCKERHUB_USER/service-registry ./MicroserviceServiceRegistry'
                sh 'docker build -t $DOCKERHUB_USER/api-gateway ./MicroserviceAPIGateway'
                sh 'docker build -t $DOCKERHUB_USER/auth-service ./MicroserviceAuthservice'
                sh 'docker build -t $DOCKERHUB_USER/account-service ./MicroserviceAccount'
                sh 'docker build -t $DOCKERHUB_USER/loan-service ./MicroserviceLoan'
                sh 'docker build -t $DOCKERHUB_USER/transaction-service ./Microservicetransaction'
            }
        }

        stage('Push Images') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                sh ''' echo $PASS | docker login -u $USER --password-stdin
                    docker push $DOCKERHUB_USER/service-registry
                    docker push $DOCKERHUB_USER/api-gateway
                    docker push $DOCKERHUB_USER/auth-service
                    docker push $DOCKERHUB_USER/account-service
                    docker push $DOCKERHUB_USER/loan-service
                    docker push $DOCKERHUB_USER/transaction-service
                    '''
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f k8s/'
            }
        }
    }
}