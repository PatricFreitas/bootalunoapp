pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MVN_3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/PatricFreitas/bootalunoapp.git'

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        stage('Deploy to tomcat'){
            steps{
                deploy adapters: [tomcat8(credentialsId: 'TOMCAT-DEPLOYER', path: '', url: 'http://localhost:8484')], contextPath: 'bootaluno', war: 'target/*.war'
            }
            
        }
        stage('SIT'){
	        steps{
	            bat 'mvn verify'
	        }
        
    	}
    }
}
