# Update User

Updates a User.

**URL** : `/api/v1/users/{nationalIdNumber}`

**Method** : `PUT`

**Sample Request Body**

```json
{
  "birthDate": "1997-01-24",
  "name": "Ertuğrul",
  "surname": "Yılmaz",
  "phone": "5346632268"
}
```

## Success Response

**Code** : `200`

**Sample Response Body** :

```json
{
  "nationalIdNumber": "13241052428",
  "birthDate": "1997-01-24",
  "name": "Ertuğrul",
  "surname": "Yılmaz",
  "phone": "5346632268",
  "monthlyIncome": 5000
}
```

## Error Responses

**Code** : `404 NOT FOUND`

**Request URL** : `/api/v1/users/1324105454545454`

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