# Show Users

Returns a list of Users.

**URL** : `/api/v1/users`

**Method** : `GET`

## Success Responses

**Code** : `200 OK`

**Request URL** : `/api/v1/users`

**Sample Response Body** :

```
[
  {
    "nationalIdNumber": "13546052424",
    "birthDate": "1997-08-19",
    "name": "Ertuğrul Ayvaz",
    "surname": "Gürkan",
    "phone": "5346875548"
  },
  {
    "nationalIdNumber": "83241003625",
    "birthDate": "1980-01-24",
    "name": "Ozan",
    "surname": "Çetin",
    "phone": "5348854475"
  },
  {
    "nationalIdNumber": "53241003625",
    "birthDate": "1975-01-24",
    "name": "Mustafa",
    "surname": "Yılmaz",
    "phone": "5346658899"
  }
]
```