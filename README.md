# mybatis-issue-demo
change jdbc.properties information to your schema
run `mvn clean compile` to comile .java
`mkdir modules` as module path
`copy -rf target/classes/ moudles`
copy mysql-connector-java-2.9.1.jar,org.mybatis.mybatis-3.5.9.jar to modules
execute `java -p modules -m mybatis.issue.demo/demo.Main`

