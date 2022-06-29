# mybatis-issue-demo
change jdbc.properties information to your schema. </br>
run `mvn clean compile` to compile. </br>
`mkdir modules` as module path. </br>
`cp -rf target/classes/ moudles` to copy compiled classes to module path</br>
**copy mysql-connector-java-2.9.1.jar,mybatis-3.5.9.jar to modules** to copy required dependencies to module path </br>
execute `java -p modules -m mybatis.issue.demo/demo.Main` </br>

