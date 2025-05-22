# Cloud-Vendor-API

  **Cloud Vendor Properties:-**
<img width="233" alt="image" src="https://github.com/user-attachments/assets/12990e64-f5d5-4915-af04-35f03785f2c7" />

  **Services**

<img width="449" alt="image" src="https://github.com/user-attachments/assets/e3761432-15f5-4106-adb4-d940db95491e" />



**Next Version In building this Project-->**
<img width="916" alt="image" src="https://github.com/user-attachments/assets/c03f28d1-5bbe-49f9-9d4d-83174dafa8ca" />

In this next Step we will build Cloud Vendor Information Service which will interact with the database(MySQL) and it will be also be exposing the Rest API (GET, POST, PUT, DELETE). 

**Now the Layer that will go in the Cloud Vendoe API Service.**
<img width="1125" alt="image" src="https://github.com/user-attachments/assets/dff7018a-fb59-4a51-b0d3-035d1bc9d5fd" />
In cloud Vendor Information Service we will be building 3 Layers:-
1) Controller layer
2) Business/Service Layer
3) Database/ Repository Layer
in simple terms this is also called springboot project architecture.

Controller Layer will be interating with the REST Client with all the CRUD(GET, POST, PUT, DELETE) operations. This REST Client will be the Postman or the Browser Window or any user interface application.
Controller layer will also be contacting with the Business/ Service layer and also be listeining to REST client and responding to it. Business Layer wil also be in touch with the controller layer and also with the Database layer to fetch the data. Database layer will be performing all the database related operations and with also be in connection with the DB.

Some part of this Controller layer is already build in the previous version but will be adding some more functionality to it.

