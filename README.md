# Backend-Naver-Project-1
## 1.InitData

[Database](https://github.com/TieuLang/Backend-Naver-Project-1/blob/master/src/main/java/com/example/demo/config/Config.java)

## 2.API

### Get Product By Condition 
- Request: `GET /cart/getProductWithCondition`
  ```
  {
    "price": 12000,
    "condition":"LESS_THAN"
  }
  ```
- Response:
  ```
  [
    {
        "productId": 1,
        "nameProduct": "San pham 0",
        "type": "a",
        "price": 10000
    },
    {
        "productId": 2,
        "nameProduct": "San pham 1",
        "type": "b",
        "price": 11000
    },
    {
        "productId": 11,
        "nameProduct": "Product",
        "type": "a",
        "price": 10000
    },
    {
        "productId": 12,
        "nameProduct": "Product",
        "type": "b",
        "price": 11000
    }
  ]
  ```
### Add Items To Cart
- Request: `/cart/addItems`
  ```
  {
    "customerId":3,
    "productAddedRequests":[
        {
            "productId":11,
            "countProduct":2
        },
        {
            "productId":12,
            "countProduct":2
        },
        {
            "productId":13,
            "countProduct":2
        },
        {
            "productId":14,
            "countProduct":2
        },
        {
            "productId":13,
            "countProduct":2
        }
    ]
  }
  ```
- Response:
  ```
  [
    {
        "id": {
            "cartId": 1,
            "productId": 11
        },
        "quantityWished": 2,
        "date": "12:20:01 02-09-2022",
        "totalAmount": 20000
    },
    {
        "id": {
            "cartId": 1,
            "productId": 12
        },
        "quantityWished": 2,
        "date": "12:20:01 02-09-2022",
        "totalAmount": 22000
    },
    {
        "id": {
            "cartId": 1,
            "productId": 13
        },
        "quantityWished": 2,
        "date": "12:20:01 02-09-2022",
        "totalAmount": 24000
    },
    {
        "id": {
            "cartId": 1,
            "productId": 14
        },
        "quantityWished": 2,
        "date": "12:20:01 02-09-2022",
        "totalAmount": 26000
    },
    {
        "id": {
            "cartId": 1,
            "productId": 13
        },
        "quantityWished": 4,
        "date": "12:20:02 02-09-2022",
        "totalAmount": 48000
    }
  ]
  ```
### Get Item From Cart
- Request: `/cart/getProductWithCondition`
  ```
  {
    "customerId": 3,
    "nameProduct":"Product",
    "limit":3,
    "offset":1
  }
  ```
- Response:
  ```
  [
    {
        "productId": 12,
        "nameProduct": "Product",
        "type": "b",
        "price": 11000
    },
    {
        "productId": 13,
        "nameProduct": "Product",
        "type": "c",
        "price": 12000
    },
    {
        "productId": 14,
        "nameProduct": "Product",
        "type": "d",
        "price": 13000
    }
  ]
  ```
