new product:

POST http://localhost:8080/api/products

example:
{
  "name": "Test Product",
  "description": "Sample description",
  "price": 9.99,
  "quantity": 5
}


delete product:

DELETE http://localhost:8080/api/products/{id}

example:
DELETE http://localhost:8080/api/products/1
