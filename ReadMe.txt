==========================================================
=================Inventory Project========================
==========================================================
1. config build path to "Inventory/target/classes"
2. run mvn clean install on "Inventory" project
3. make it as a tomcat project with parameters:
	- context name : /inventory
	- web application root : /target/inventory-1.0-SNAPSHOT
4. make FlexInventory output folder to "{WORKSPACE_PATH}\Inventory\target\inventory-1.0-SNAPSHOT"
5. if you want to debug flex application, create one with URL or Path to launch "{TOMCAT_SERVICE}/inventory"
	- for example : http://localhost:8885/inventory
6. Make sure your your configured SecureRemoteObject in FlexInventory is pointing to the right TOMCAT_SERVICE.