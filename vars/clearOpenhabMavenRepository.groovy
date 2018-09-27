def call(String repositoryId) {
    withCredentials([usernamePassword(credentialsId: "openhab-sandbox-deployer", passwordVariable: 'jfrogPassword', usernameVariable: 'jfrogUser')]) {        
        // Workaround: Delete two times because sometimes first delete is not correctly applied
        for (i = 0; i < 2; i++) {
           sh 'curl -u '+ jfrogUser + ':' + jfrogPassword +' -X "DELETE" ' + "https://openhab.jfrog.io/openhab/" + repositoryId + "/"
           sh "sleep 300"
        }
    }
}
