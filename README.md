
####The automation framework used following tech stack:
- Automation Tool: Selenium(3.141.59)
- Build Tool: Maven
- Test Framework: TestNG(7.4.0)
- Reports: Extent Report
- Git repository: 

####Setting up Project
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one).
- Open Eclipse/Intellij Idea
- File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip -> Select POM.xml file


####Steps to run test cases via eclipse:
- Right click on testng.xml file
- click on "Run as" -> "Run as Configuration"
- Under Run select "Suite" radio Button
- Click on browser
- Select "testing.xml" file
- Click on Arguments tab
- Enter following arguments: -Demail=pooja123@gmail.com -Dpassword=Pooja@123 -Dbrowser=chrome
- Click on apply
- Click on Run




####Maven command to run test cases : 
- mvn clean test -Demail=pooja123@gmail.com -Dpassword=Pooja@123 -Dbrowser=chrome -DsuiteXmlFile=testng.xml 

######OR
- mvn verify -Demail=pooja123@gmail.com -Dpassword=Pooja@123 -Dbrowser=chrome

**Please note that you need maven configured in machine to run above command.

###Running test on specific browser
Yes you can specify which browser to use by using one of the following switches:
- -Dbrowser=firefox
- -Dbrowser=chrome
- -Dbrowser=ie
- -Dbrowser=edge
