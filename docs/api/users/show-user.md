# Show User

Returns a User with National Id Param.

**URL** : `/api/v1/users/13241052421`

**Method** : `GET`

## Success Responses

**Code** : `200 OK`

**Request URL** : `/api/v1/users/13241052421`

**Sample Response Body** :

```json
{
  "nationalIdNumber": "13241052428",
  "birthDate": "1997-08-19",
  "name": "Ertuğrul Ayvaz",
  "surname": "Gürkan",
  "phone": "05375043264",
  "monthlyIncome": 5000.0
}
```

## Error Responses

**Code** : `404 NOT FOUND`

**Request URL** : `/api/v1/users/1324109894`

**Sample Response Body** :

```json
{
  "status": "NOT_FOUND",
  "message": "User not found!",
  "errors": [
    "User not found!"
  ]
}
```