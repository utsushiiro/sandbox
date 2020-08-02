package main

import (
	"errors"
	"fmt"
	"net/http"

	"github.com/labstack/echo/v4"
)

func successHandler(c echo.Context) error {
	defer fmt.Println("Handler: defer")
	fmt.Println("Handler: ok")
	return nil
}

func failHandler(c echo.Context) error {
	defer fmt.Println("Handler: defer")
	fmt.Println("Handler: error")
	return errors.New("Error")
}

func customHTTPErrorHandler(err error, c echo.Context) {
	defer fmt.Println("ErrorHandler: defer")
	fmt.Println("ErrorHandler: process")
	c.String(http.StatusNotFound, http.StatusText(http.StatusNotFound))
}

func createMiddleware(name string) echo.MiddlewareFunc {
	return func(next echo.HandlerFunc) echo.HandlerFunc {
		return func(c echo.Context) error {
			defer fmt.Printf("Middleware[%s]: defer\n", name)
			fmt.Printf("Middleware[%s]: before\n", name)
			err := next(c)
			fmt.Printf("Middleware[%s]: after\n", name)
			return err
		}
	}
}

func main() {
	e := echo.New()

	e.HTTPErrorHandler = customHTTPErrorHandler

	e.Pre(createMiddleware("Pre"))
	e.Use(createMiddleware("Use-First"))
	e.Use(createMiddleware("Use-Second"))

	g := e.Group("", createMiddleware("Group"))
	g.GET("/ok", successHandler, createMiddleware("Route"))
	g.GET("/error", failHandler, createMiddleware("Route"))

	e.Logger.Fatal(e.Start(":3000"))
}
