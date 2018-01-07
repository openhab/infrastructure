def call(String gitForkBaseUrl, String componentName) {
	if(!env.SKIP_SANDBOX_RESET?.toBoolean()) {
		def gitForkUrl = gitForkBaseUrl + "/" + componentName + ".git"
		def gitBaseUrl = componentName == "smarthome" ? "https://github.com/eclipse" : "https://github.com/openhab"
		gitBaseUrl = gitBaseUrl + '/' + componentName

		withCredentials([usernamePassword(credentialsId: env.GIT_CREDENTIALS_ID, passwordVariable: 'gitPassword', usernameVariable: 'gitUser')]) {
			resetGitFork(gitForkUrl, gitBaseUrl, gitUser, gitPassword)
		}
	}
}