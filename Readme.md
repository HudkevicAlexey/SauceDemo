1. 
--- versions-maven-plugin:2.7:display-dependency-updates (default-cli) @ SauceDemo ---
  [INFO] artifact org.testng:testng: checking for updates from central
  [INFO] artifact org.seleniumhq.selenium:selenium-java: checking for updates from central
  [INFO] The following dependencies in Dependencies have newer versions:
  [INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-5
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time:  3.651 s
  [INFO] Finished at: 2020-05-12T18:19:17+03:00
1.1 
--- versions-maven-plugin:2.7:use-latest-versions (default-cli) @ SauceDemo ---
   [INFO] Major version changes allowed
   [INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.0.0-alpha-5
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   [INFO] ------------------------------------------------------------------------
   [INFO] Total time:  0.892 s
   [INFO] Finished at: 2020-05-12T18:20:15+03:00
   [INFO] ------------------------------------------------------------------------


2.Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 40.073 sec
  
  Results :
  
  Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
  
3.1 mvn clean test -Dtest=SauceDemoTest#loginFormTest test
[INFO] Results:
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

3.2 mvn clean test -Dtest=SauceDemoTest#productPageTest
[INFO] Results:
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

3.3 mvn clean test -Dtest=SauceDemoTest#checkoutPageTest
[INFO] Results:
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

3.4 mvn clean test -Dtest=SauceDemoTest#checkoutPageStepTwoTest
[INFO] Results:
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

4.//Запускал pom.xml из herokkuapp
  (1)CD..
  (2)DIR
  (3) mvn -f herokuapp/pom.xml clean test

Tests run: 18, Failures: 4, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  39.981 s
[INFO] Finished at: 2020-05-13T10:23:32+03:00

5.Передача ProductName через терминал
mvn clean test -Dtest=SauceDemoTest#checkoutPageStepTwoTest -DproductName="Sauce Labs Backpack"





