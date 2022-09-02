# Backend-Naver-Project-1
## 1.InitData

[Database](https://github.com/TieuLang/Backend-Naver-Project-1/blob/master/src/main/java/com/example/demo/config/Config.java)

## 2.API

### Get Product By Condition 
- Endpoint: `GET /cart/getProductWithCondition
#### Example
- Request: 'GET /cart/getProductWithCondition
  ```
  {
    "price": 15000,
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
          "productId": 3,
          "nameProduct": "San pham 2",
          "type": "c",
          "price": 12000
      },
      {
          "productId": 4,
          "nameProduct": "San pham 3",
          "type": "d",
          "price": 13000
      },
      {
          "productId": 5,
          "nameProduct": "San pham 4",
          "type": "e",
          "price": 14000
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
      },
      {
          "productId": 15,
          "nameProduct": "Product",
          "type": "e",
          "price": 14000
      }
  ]
  ```
