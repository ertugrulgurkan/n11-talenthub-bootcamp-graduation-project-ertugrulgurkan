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
  "nationalIdNumber": "13241052421",
  "birthDate": "1997-08-19",
  "name": "ERTUĞRUL AYVAZ",
  "surname": "Gürkan",
  "phone": "2126132008"
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