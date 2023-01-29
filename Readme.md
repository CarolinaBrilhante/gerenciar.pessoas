# API Rest com Java, Spring & SpringBoot

![Spring+Framework](https://img.shields.io/badge/Spring_Framework-555555?style=for-the-badge&logo=Spring)
![SpringBoot](https://img.shields.io/badge/SpringBoot-555555?style=for-the-badge&logo=SpringBoot)

Repositório disponibilizado como parte integrante do processo seletivo da empresa **Attornatus Procuradoria Digital**.

## ✅ Requisitos

Para rodar o projeto, precisará ter alguns pacotes instalados em seu computador:

* Java JDK 8 ou superior
* Spring Framework
* SpringBoot
* H2 Database
* Hibernate
* Maven 3.1.1 ou superior
* Git

## 📦 Dependências
Há uma série de dependências de terceiros usadas no projeto. Navegue pelo arquivo pom.xml do Maven para obter detalhes das bibliotecas e versões usadas. As principais estão elencadas no tópico "Requisitos".

##  API Rest - Requisições HTTP

Criar uma pessoa:
```shell
# POST
http://localhost:8080/pessoas
```

Editar uma pessoa:
```shell
# PUT
http://localhost:8080/pessoas/{id}
```

Consultar uma pessoa (Mostrando endereço principal):
```shell
# GET
http://localhost:8080/pessoas/{id}
```

Listar pessoas:
```shell
# GET
http://localhost:8080/pessoas
```

Criar endereço para pessoa:
```shell
# POST
http://localhost:8080/enderecos
```

Listar endereços da pessoa:
```shell
# GET
http://localhost:8080/enderecos/{id}
```


## 🧑🏻‍💻 Authors
This project is mantained by:
* [Carolina Brilhante](http://github.com/CarolinaBrilhante)


## ⚖️ License
MIT License

Copyright (c) 2022 @CarolinaBrilhante

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.