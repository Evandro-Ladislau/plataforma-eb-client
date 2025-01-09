# Cadastro de Clientes

Este serviço é responsável por gerenciar o cadastro de clientes. Ele oferece as seguintes funcionalidades:

## Funcionalidades

- **Cadastrar um cliente**
- **Alterar um cliente previamente cadastrado**
- **Inativar um cliente** (delete lógico)
- **Listar todos os clientes**

---

## Modelo de Cliente

Abaixo está o modelo de dados utilizado para os clientes:

| Nome        | Tipo       | Descrição                            |
|-------------|------------|--------------------------------------|
| `id`        | STRING     | Identificador único do cliente       |
| `name`      | STRING     | Nome do cliente                      |
| `surname`   | STRING     | Sobrenome do cliente                 |
| `email`     | STRING     | Email de contato do cliente          |
| `birthdate` | DATE       | Data de nascimento do cliente        |
| `created_at`| TIMESTAMP  | Data de criação do registro          |
| `updated_at`| TIMESTAMP  | Data da última atualização do registro |

---

## Como utilizar este serviço

1. **Cadastrar um cliente**  
   Enviar os dados do cliente via API para o endpoint de cadastro.

2. **Alterar um cliente**  
   Atualizar as informações de um cliente já cadastrado utilizando seu identificador único (`id`).

3. **Inativar um cliente**  
   Marcar um cliente como inativo para garantir que os dados sejam mantidos, mas não utilizados ativamente.

4. **Listar clientes**  
   Retornar todos os clientes cadastrados, incluindo os inativos, dependendo da configuração.

---

Sinta-se à vontade para contribuir ou abrir issues relacionadas a melhorias ou dúvidas sobre este serviço.
