## Echoのmiddlewareの呼び出し順序について

### 正常系(HTTPErrorHandlerまで到達しない)

```
$ curl -v http://localhost:3000/ok

# Echoのログ
Middleware[Pre]: before
Middleware[Use-First]: before
Middleware[Use-Second]: before
Middleware[Group]: before
Middleware[Route]: before
Handler: ok
Handler: defer
Middleware[Route]: after
Middleware[Route]: defer
Middleware[Group]: after
Middleware[Group]: defer
Middleware[Use-Second]: after
Middleware[Use-Second]: defer
Middleware[Use-First]: after
Middleware[Use-First]: defer
Middleware[Pre]: after
Middleware[Pre]: defer
```

### 異常系(HTTPErrorHandlerまで到達する)

```
$ curl -v http://localhost:3000/error

# Echoのログ
Middleware[Pre]: before
Middleware[Use-First]: before
Middleware[Use-Second]: before
Middleware[Group]: before
Middleware[Route]: before
Handler: error
Handler: defer
Middleware[Route]: after
Middleware[Route]: defer
Middleware[Group]: after
Middleware[Group]: defer
Middleware[Use-Second]: after
Middleware[Use-Second]: defer
Middleware[Use-First]: after
Middleware[Use-First]: defer
Middleware[Pre]: after
Middleware[Pre]: defer
ErrorHandler: process
ErrorHandler: defer
```

### Reference

- [Echo - Middleware](https://echo.labstack.com/middleware)
- [Echo - Error Handling](https://echo.labstack.com/guide/error-handling)
