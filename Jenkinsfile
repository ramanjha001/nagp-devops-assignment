pipeline{
     agent { label "docker"}

     tools {
             maven 'M2_HOME'
             jdk 'JAVA_HOME'
           }

     environment {
         dockerHubCredentials = 'dockerHubCredentials'
     }

     stages{
         stage('Build') {
            steps {
               sh 'mvn clean compile'
            }
         }

         stage('Unit Test') {
             steps {
                sh 'mvn clean test'
             }
         }

         stage('Integration Test') {
            steps {
               sh 'mvn integration-test -DskipUnitTests'
            }
         }

         stage('Package') {
            steps {
               sh 'mvn clean package'
            }
         }

         stage('Build & Publish Docker Image') {
            steps {
               script {
                  dockerImage = docker.build 'ramanjha001/nagp-devops:v1'
                  docker.withRegistry('', dockerHubCredentials) {
                     dockerImage.push("v1")
                  }
               }
            }
         }
}