def call(String gitUrl, String tag, String gitUser, String gitPassword) {
    def pushUrl = gitUrl.replace("://", "://"+ gitUser + ':' + gitPassword + '@')

    dir("deleteGitTag-workspace") {
        deleteDir()
        //Fetch everything from base
        sh 'git clone --bare ' + gitUrl + ' .'
        sh 'git push --delete ' + pushUrl + ' ' + tag + ' || true'
        deleteDir()
    }
}