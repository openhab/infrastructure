def call(String gitForkUrl, String gitBaseUrl, String gitUser, String gitPassword) {
    def pushUrl = gitForkUrl.replace("://", "://"+ gitUser + ':' + gitPassword + '@')

    dir("resetGitFork-workspace") {
        //Fetch everything from base
        sh 'git clone --bare ' + gitBaseUrl + ' .'
        //Override fork
        sh 'git push --all --force ' + pushUrl
        sh 'git push --tags --force ' + pushUrl
        deleteDir()
    }
}