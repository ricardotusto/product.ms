# Product-ms

## Endpoints
- BaseURL: /products
- POST: create()
- GET: getAll()
- GET /{id}: getById()
- PUT /{id}: update()
- DELETE /{id}: delete()

## Model
```json
{
  "id": 1,
  "name": "Iphone 13 Pro max",
  "description": "Ultima geracao",
  "price": 999.00,
  "isAvailable": true
}
```

## Business Rules
- Só é possivel a criação de produtos com preço positivo;
- Não é possivel procurar produtos que não estão disponiveis;
- A descrição tem de ter no minimo 50 caracteres.
