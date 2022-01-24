# Create Credit Application for User


**URL** : `/api/v1/credit-applications`

**Method** : `POST`

## Request

**Code** : `200 OK`

**Request URL** : `/api/v1/credit-applications`


**Sample Request Body** :

```json
{
  "nationalIdNumber": "53241003625",
  "birthDate": "1975-01-24",
  "name": "Mustafa",
  "surname": "Yılmaz",
  "phone": "5346658899",
  "assurance":50000,
  "monthlyIncome": 8000
}
```

## Success Responses

**Sample Response Body** :

```json
{
  "nationalIdNumber": "53241003625",
  "creditLimitAmount": 30000,
  "applicationDate": "2022-01-24T18:25:56.563063",
  "creditApplicationResult": "APPROVED"
}
```
