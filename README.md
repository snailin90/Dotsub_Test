# Dotsub_Test



Pre-requisites : 

    Java 7+
    Maven 3
    


In order to Run the Project you need to do the next steps :


* **mvn spring-boot:run** : This command will lunch the application that will be running in **localhost** on PORT:8080

    The command above have to be ran in a Terminal inside the root folder **Dotsub_Test**

* **mvn clean install -DskipTests** :This command will compile the code and skip any unit testing,  and will generate a **target** folder inside the root project. In the target folder will be a file called **dotsub_coding_test.jar**

    Open an terminal and go to the target folder and run this command : **java -jar dotsub_coding_test.jar**

In order to check if the local server is running , you can hit one of the next endpoints:

    localhost:8080/dotsub/api/server/info
    GET Method

                OR

    localhost:8080/dotsub/api/server/info
     GET Method


**The endpoint related to Upload API is :**

* localhost:8080/dotsub/api/file/upload          
**POST Method**
    
    This service do two things:

    * Create new entry in the database. **(H2 DB)**

    * Store the file in the root directory in a sub-folder **files_upload** where the server is running

    
            In windows OS , the root directory is [Documents] Folder

            Ex: C:\Users\sinoa\Documents\files_upload

    **If you want to know which is the root directory of the server where you are running the APP, use this endpoint** :  
    
    * **localhost:8080/dotsub/api/file/root-directory**
             
        GET Method

    The **root directory** will be different depending in the OS and the configuration. 
    
   




## How database will be loaded

Once you run the project the table (**file_info**) will be created under the **In-memory H2 Database**.

In order to create the table automatically  there is file called **data.sql**  

You can access to the **H2 database console** through the browser using this URL

http://localhost:8080/dotsub/h2-console

* username=sa
* password=


## How to run Unit Testing

There are Unit testing for the next Restful Services :
    
    * Upload File
    * Ping Server

if you want to run the test, use this command

 **mvn test** 

 if you don't want to run the test , you need to skip it using this command :

 mvn clean install **-DskipTests**



 ## How to run the Front-End

 The Front-End is in Angular (**Version 8**).

 The source code is in this path: **Dotsub_Test\dotSub-UI**

 The source code is already compiled (production mode) and will be available once you run the backend.

 **Note:** This is for testing purpose , the best idea is to deploy the UI in a separate container. 


Once you deploy the backend the UI will be available in this URL

**http://localhost:8080/dotsub/**


**If you want to run the front-end source code :**

Pre-requisites : 

    Node
    angular CLI


In order to run angular locally  you first need to do:

     npm install   --> download all the depedencies
     npm start     --> start angular using light server


once the you run **npm start** , you will reach the UI :

http://localhost:4200

**Note:** You can also use **"ng serve"** but since we are using a **"proxy file"** to avoid CORS when we call any service from the backend you need to use **"npm start"**.


 