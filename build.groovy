pipeline {
    agent any
    stages {
        stage('Pull') {
            steps {
                git 'https://github.com/sharadrathod/studentapp-ui.git'
            }
        }
        stage('Build') {
            steps { 
                 sh '/opt/maven/bin/mvn clean package '
            }
        }
        stage('Test') {
            steps {
                sh '''/opt/maven/bin/mvn sonar:sonar \\
                   -Dsonar.projectKey=jenkins \\
                   -Dsonar.host.url=http://54.226.43.219:9000 \\
                   -Dsonar.login=bc527446180d3ca26b4f4da9457c510d35474cbb'''

            }
        }
        stage('Deploy') {
            steps {
                echo '"Deploy successfully"'
            }
        }
    }
} 