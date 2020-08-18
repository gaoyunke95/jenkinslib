#!groovy

@Library('jenkinslib') _

def tools = new org.devops.tools()
String workspace = "/opt/jenkins/workspace"


pipeline {
    agent { node {  label "master"
                    customWorkspace "${workspace}"
            }
    }
    
    options {
        timestamps()
        skipDefaultCheckout()
        disableConcurrentBuilds()
        timeout(time: 1, unit: 'HOURS')
    }
    
    stages{
        stage("GetCode"){
            when { environment name: 'test', value: 'abcd'}
            steps{
                timeout(time:5, unit:"MINUTES"){
                    script{
                        println("get code")
                        println("${test}")
                        input id: 'test', message: 'continue', ok: 'yes', parameters: []
                    }
                }
            }
        }

        stage("01"){
            failFast true
            parallel {
                stage("build") {
                    steps{
                        timeout(time:20, unit:"MINUTES"){
                            script{
                                println("build and pack")

                            }
                        }
                    }
                }

                stage("CodeScan"){
                    steps{
                        timeout(time:20, unit:"MINUTES"){
                            script{
                                println("code scan")
                                //tools.PrintMes("this is my lib test")
                                tools.PrintMes("this is my lib test", 'green')
                            }
                        }
                    }
                }
            }
        }
    }

    post {
        always{
            script{
                println("this will always run")
            }
        }
        success {
            script{
                currentBuild.description = "\n build success"
            }
        }

        failure {
            script{
                currentBuild.description = "\n build failure"
            }
        }
        aborted {
            script{
                currentBuild.description = "\n job. aborted"
            }
        }
    }
}
