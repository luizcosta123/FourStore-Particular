
# FourStore - Particular 🟢

This project is an update made by me of the project made in a group on fourcamp 2, it was fixed some bugs in the realization and sales registration part.
FourStore is a clothing store project, developed in Java language, it has methods to manage products (registration, edition, listing, exclusion), manage sales (registration, listing), and they use a SKU as parameter to find the required entries.

## Bugs fixed 🛠

The "registerSale" method was receiving an overwritten list of products (cart), to solve this problem, an auxiliary list was created that creates a copy of the cart list, allowing the lists saved in saleData not to be overwritten

## Updates 💿

- Added back options to some menu points.

- Regex were created for the validations of the following pix keys: CNPJ, EMAIL and PHONE.

- The method that calculates net profit was created to be used in the sales record.

- Access control is being created! ⭕

## Coming soon 📀

Este projeto será refeito utilizando Spring Boot!

### SKU examples

- Red shirt: 11331030609253
- Green T-shirt: 12360930309254
- Purple T-shirt: 13360830309253
- Black shirt: 14330730609252
- Brown jacket: 15400660909253
- Orange coat: 16380560909252
