
# FourStore - Update

This project is an update made by me of the project made in a group on fourcamp 2, it was fixed some bugs in the realization and sales registration part.
FourStore is a clothing store project, developed in Java language, it has methods to manage products (registration, edition, listing, exclusion), manage sales (registration, listing), and they use a SKU as parameter to find the required entries.

## Bugs fixed:

The "registerSale" method was receiving an overwritten list of products (cart), to solve this problem, an auxiliary list was created that creates a copy of the cart list, allowing the lists saved in saleData not to be overwritten

## Updates:

- Foram adicionadas opções de voltar em alguns pontos do menu.

- Foram criado os Regex para as validações das seguintes chaves pix: CNPJ, EMAIL e TELEFONE.

- Foi acrescentado o método que calcula o lucro líquido para se colocar no registro da venda.

- coloquei um contrrrole de acesso

### Alguns exemplos de SKU de produtos

- Blusa vermelha: 11331030609253
- Camiseta verde: 12360930309254
- Camiseta roxa: 13360830309253
- Blusa preta: 14330730609252
- Jaqueta marrom: 15400660909253
- Casaco laranja:  16380560909252
