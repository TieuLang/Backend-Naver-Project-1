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
