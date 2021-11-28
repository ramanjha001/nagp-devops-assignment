pipeline{
     agent { label "docker"}

     tools {
             maven 'M2_HOME'
             jdk 'JAVA_HOME'
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
     }
}