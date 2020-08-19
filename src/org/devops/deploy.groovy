package org.devops

//saltstack
def SaltDeploy(hosts, func){
	sh "salt \"${hosts}\" ${func}"
}

/* in ci.jenkinsfile
String deployHosts = "host1,host2"
stage("Deploy"){
	steps{
		script{
			hosts = deployHosts.split(",").toList()
			for (host in hosts){
				sh "salt ${host} cmd.run ls"
			}
		}
	}
}
*/


//ansible

def Ansible(hosts,func){
	sh "ansible ${func} ${hosts}"
}
