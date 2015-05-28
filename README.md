Account Registration - Java Configuration
=========================================

Requirements
------------
* JDK 1.8+
* Apache Tomcat 8.0+
* Apache Maven 3.3.3+

Building
--------
Run the following command in account-registration directory:  

`mvn package`

Running
-------
1. Rename account-registration-xxx.war to account-registration.war
2. Copy account-registration.war to webapps directory in Tomcat installation
3. Start Tomcat
4. Point your browser to <http://localhost:8080/account-registration/>
