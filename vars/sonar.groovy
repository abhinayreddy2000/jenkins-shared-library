def call(version) {
    withSonarQubeEnv('SonarQube') {
        withCredentials([string(credentialsId: 'sonar-token', variable: 'TOKEN')]) {
            sh """
            mvn sonar:sonar \
            -Dsonar.projectKey=simple-customer-app \
            -Dsonar.projectVersion=${version} \
            -Dsonar.login=\$TOKEN
            """
        }
    }
}
