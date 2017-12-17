def call(String repositoryId) {
    withCredentials([usernamePassword(credentialsId: "openhab-sandbox-deployer", passwordVariable: 'jfrogPassword', usernameVariable: 'jfrogUser')]) {
        sh 'curl -u '+ jfrogUser + ':' + jfrogPassword +' -X "DELETE" ' + "https://openhab.jfrog.io/openhab/" + repositoryId + "/"
    }
}