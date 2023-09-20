
 | Simple test project with DB access |
---------------------------------
        |   Maven       |   2.22.0
        |   Java        |   jdk 1.8.0_231
        |   TestNg      |   5.4.0
        |   Allure      |   2.13
        |   ojdbc8      |   19.3.0.0
        |   aspectj     |   1.9.5
---------------------------------

Extension
++++++++++
Add owner. property reader
add lombok annotation
add restAssured base
check aspectJ 
add Jenkins integration with parameters
add faker random data creation
add DDT @DataProvider 
add log4j logging file.properties
Add cucumber feature.file
Add reportPortal / Zephyr integration

Jenkins attributes with option:
    testSuite. (dataBaseSet / smokeSet / module1Set / module2Set / module3Set)  => connect with TraceabilityMatrix
    stage.  ( dev/int/prod )  => url switch
    dataBase. (MarinaDB / PostgresDB)   => ojdbc driver switch
    