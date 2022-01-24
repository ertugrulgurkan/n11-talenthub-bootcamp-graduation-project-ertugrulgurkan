# Delete User

Delete a User.

**URL** : `/api/v1/users`

**Method** : `DELETE`

**Request URL** : `/api/v1/users/{nationalIdNumber}`


## Success Response

**Code** : `200`

**Sample Response Body** :

```
User deleted National Id Number is : 12345678904
```

## Error Responses

**Code** : `500`

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
