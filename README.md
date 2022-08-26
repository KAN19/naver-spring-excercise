# API DESCRIPTION

## Department

### Request
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
