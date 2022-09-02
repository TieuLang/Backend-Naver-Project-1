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
- Request: 
