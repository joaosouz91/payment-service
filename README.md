# payment-service

-------------------------------------------------------

# POST 
# http://localhost:8080/payment-service
{
    "formaPagamento": "CREDITO",
    "numeroCartao": "2546 1545 6544 6546",
    "validadeCartao": "2028-04",
    "bandeiraCartao": "MASTERCARD",
    "valorCompra": 342.24
}

-------------------------------------------------------

# PUT 
# http://localhost:8080/payment-service
{
	"idPayment": 1,
    "formaPagamento": "DEBITO",
    "numeroCartao": "2546 5533 6544 6546",
    "validadeCartao": "2028-09",
    "bandeiraCartao": "VISA",
    "valorCompra": 1664.32
}

-------------------------------------------------------

# GET 
# http://localhost:8080/payment-service/1

-------------------------------------------------------

# DELETE 
# http://localhost:8080/payment-service/1

-------------------------------------------------------

