export project_name=depreciate
export project_path=/home/peigen/soft/Jiangjia.la
export war_path=${project_path}/${project_name}-assemble/target/ROOT.war
export tomcat_path=$MY_JAVA/apache-tomcat-7.0.29

echo project name is ${project_name}
echo project path is ${project_path}

echo '停止tomcat服务'
${tomcat_path}/bin/shutdown.sh;

echo '开始删除';
rm -rf /tmp/${project_name}.log

#tomcat
rm -rf ${tomcat_path}/logs/* ;
rm -rf ${tomcat_path}/webapps/${project_name}/ ;
rm -rf ${tomcat_path}/webapps/ROOT.war ;
rm -rf ${tomcat_path}/webapps/ROOT/ ;
rm -rf ${tomcat_path}/work/ ;


echo '开始打包';
cd ${project_path};
mvn install -Dmaven.test.skip=true;
#mvninstall_without_test;

echo '开始复制完毕';
cp -r ${war_path} ${tomcat_path}/webapps/

echo '开启tomcat debug模式'
export JPDA_ADDRESS=9999
${tomcat_path}/bin/catalina.sh jpda start;

#echo '启动tomcat服务'
#${tomcat_path}/bin/startup.sh;
