# Show Users

Returns a list of Users.

**URL** : `/api/v1/users`

**Method** : `GET`

## Success Responses

**Code** : `200 OK`

**Request URL** : `/api/v1/users`

**Sample Response Body** :

```
  {
    "nationalIdNumber": "13245268547",
    "birthDate": "1997-08-19",
    "name": "Eray",
    "surname": "Çavdar",
    "phone": "5345587754",
    "monthlyIncome": 5000.0,
  },
  {
    "nationalIdNumber": "10527545450",
    "birthDate": "1997-08-19",
    "name": "Ozan",
    "surname": "Yılmaz",
    "phone": "5747548547",
    "monthlyIncome": 12000.0,
  }
```