package org.devops

def Build(buildType, buildShell){
	def buildTools = ["mvn":"M2","ant":"ANT","gradle":"GRADLE", "npm":"NPM"]

	println("current selected build type is ${buildType}")
	buildHome = tool buildTools[buildType]

	println("buildtool is ${buildHome}")
	sh "${buildHome}/bin/${buildType} ${buildShell}"
}
