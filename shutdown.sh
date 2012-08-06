export project_name=depreciate
export project_path=/Users/peigen/workspace/peigen/${project_name}
export war_path=${project_path}/${project_name}-assemble/target/ROOT.war
export tomcat_path=$MY_JAVA/apache-tomcat-7.0.22

echo project name is ${project_name}
echo project path is ${project_path}

echo 'Í£Ö¹tomcat·þÎñ'
${tomcat_path}/bin/shutdown.sh;
