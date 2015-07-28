package com.selenium.rajesh;

import java.io.IOException;

public class BuildAndDeploy {

	public static void main(String[] args) throws IOException {

		Runtime runtime = Runtime.getRuntime();
		String[] commands = {"F:","cd F:\\Workspace\\HRMS", "echo Building the war", "mvn clean package","echo Built the war","cd F:\\Servers\\jboss7.1\\standalone\\deployments","echo Undeploying the war", "del *.war", "echo Undeployed the war", "del *.*","xcopy F:\\Workspace\\HRMS\\mavenHrmsSpring\\target\\*.war .", "echo War file moved for deploy"};
		for(String command: commands){
			runtime.exec(command);
		}

	}

}
