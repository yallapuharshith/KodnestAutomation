pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/yallapuharshith/KodnestAutomation.git'
            }
        }

        stage('Build & Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        success {
            echo 'KodnestAutomation tests executed successfully.'
        }
        failure {
            echo 'Test execution failed – check reports'
        }
        always {
            echo 'Pipeline execution completed.'
        }
    }
}
