def call() {
    slackSend color: 'good', message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} Back to normal after ${currentBuild.durationString.replace(' and counting', '')} (<${env.BUILD_URL}|Open>)"
}