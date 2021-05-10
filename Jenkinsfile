pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('---Test---') {
            steps {
                sh "mvn test"
            }
        }
        stage('---package---') {
            steps {
                sh "mvn package"
            }
        }
    }
    post {
    success {
      mail to: reganshakya@gmail.com, subject: ‘The Pipeline success...‘
    }
  }
}
