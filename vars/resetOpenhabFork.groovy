def call(String gitForkBaseUrl, String componentName, String removeTagIfExists = "") {
	withCredentials([usernamePassword(credentialsId: env.GIT_CREDENTIALS_ID, passwordVariable: 'gitPassword', usernameVariable: 'gitUser')]) {
		def gitForkUrl = gitForkBaseUrl + "/" + componentName + ".git"
		def gitBaseUrl = (componentName == "smarthome" ? "https://github.com/eclipse" : "https://github.com/openhab") + '/' + componentName
		if(!env.SKIP_SANDBOX_RESET?.toBoolean()) {			
			resetGitFork(gitForkUrl, gitBaseUrl, gitUser, gitPassword)			
		}
		if(removeTagIfExists != "") {
			deleteGitTag(gitForkUrl, removeTagIfExists, gitUser, gitPassword)
		}
	}
}