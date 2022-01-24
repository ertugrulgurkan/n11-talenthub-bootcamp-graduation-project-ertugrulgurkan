# Find Credit Applications For User With NationalIDNumber and Birthdate

Finds Credit Request For User Information

## Success Responses

**Code** : `200 OK`

**Request URL** : `/api/v1/credit-applications/?birthdate=1997-01-22&id=13241052424`

**Sample Response Body** :

```json
{
  "nationalIdNumber": "13241052424",
  "creditLimitAmount": 20000.0,
  "applicationDate": "2022-01-23T12:53:28.351603",
  "creditApplicationResult": "APPROVED"
}
```

