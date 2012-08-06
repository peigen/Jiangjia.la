export project_name=depreciate
export project_path=/home/peigen/${project_name}
export war_path=${project_path}/${project_name}-assemble/target/ROOT.war
export webcontainer_path=$MY_JAVA/jetty-hightide-8.0.4.v20111024

echo project name is ${project_name}
echo project path is ${project_path}

echo '更新代码'
svn up;

echo '停止服务'
${webcontainer_path}/bin/jetty.sh stop;

echo '开始删除';
rm -rf /tmp/${project_name}.log

#tomcat
rm -rf ${webcontainer_path}/logs/* ;
rm -rf ${webcontainer_path}/webapps/${project_name}/ ;
rm -rf ${webcontainer_path}/webapps/root.war ;
rm -rf ${webcontainer_path}/webapps/ROOT/ ;


echo '开始打包';
cd ${project_path};
#mvn install -Dmaven.test.skip=true;
mvninstall_without_test;

echo '开始复制完毕';
cp -r ${war_path} ${webcontainer_path}/webapps/


#echo '启动tomcat服务'
${webcontainer_path}/bin/jetty.sh start;
