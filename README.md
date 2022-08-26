# API DESCRIPTION

## Department

### 3) Get department with Mybatis 
`GET /api/departments/with-num-employees/3`
### Response
 ```json
{
   "status": "success",
    "data": {
        "departmentId": 3,
        "departmentName": "department 3",
        "description": "Hello",
        "numEmployees": 2
    },
    "message": null
}
```
### 4) Get employee with Mybatis 
`GET /api/employees/with-department-ob/2`
### Response
 ```json
{
    "status": "success",
    "data": {
        "employeeId": "2",
        "name": "nguyen kiet updated 22",
        "birthDate": "04-07-2001",
        "gender": "FEMALE",
        "department": {
            "departmentId": 3,
            "departmentName": "department 3",
            "description": "Hello",
            "employees": null
        }
    },
    "message": null
}
```
### 5) Factory method
`GET /factory-method/server`
### Response
 ```json
{
  {
    "status": "success",
    "data": {
        "type": "Server"
    },
    "message": null
}
}
```



