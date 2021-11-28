pipeline{
     agent any

     tools {
             maven 'M2_HOME'
             jdk 'JAVA_HOME'
           }

     stages{
         stage('Build') {
            steps {
               bat 'mvn clean compile'
            }
         }

         stage('Unit Test') {
             steps {
                bat 'mvn clean test'
             }
         }

         stage('Integration Test') {
            steps {
               bat 'mvn integration-test -DskipUnitTests'
            }
         }

         stage('Package') {
            steps {
               bat 'mvn clean package'
            }
         }
     }
}