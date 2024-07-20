pipeline {
    agent any
    
    tools {
        maven 'maven'
        jdk 'java'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'dev', credentialsId: 'git-credentials', url: 'https://github.com/el-moudni-hicham/ci-cd-jenkins.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Cleanup') {
            steps {
                script {
                    // Stop and remove any existing container named 'myapp'
                    sh '''
                        if [ $(docker ps -q -f name=myapp) ]; then
                            docker stop myapp
                        fi
                        if [ $(docker ps -a -q -f name=myapp) ]; then
                            docker rm -f myapp
                        fi
                    '''
                    
                    // Remove any existing Docker image named 'myapp'
                    sh '''
                        if [ $(docker images -q myapp) ]; then
                            docker rmi myapp
                        fi
                    '''
                }
            }
        }

        stage('Deploy') {
            steps { 
                script {
                
                    sh 'docker build -t myapp .'
                    sh 'docker run -d --name myapp -p 8090:8090 myapp'
                }
            }
        }
    }
}
