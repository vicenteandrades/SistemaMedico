# Sistema Médico - API REST

Esta API REST foi desenvolvida utilizando **Spring Boot**, **JPA**, **Hibernate** e **PostgreSQL**. O sistema médico gerencia as entidades **Paciente**, **Médico** e **Consulta**. O objetivo principal é estudar o desenvolvimento de APIs REST com Spring Framework.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **JPA (Java Persistence API)**: API para mapeamento objeto-relacional.
- **Hibernate**: Implementação do JPA.
- **PostgreSQL**: Banco de dados relacional.
- **Maven**: Gerenciador de dependências e build.

## Funcionalidades

### **Serviço do Médico**

A classe `MedicoService` oferece um método de validação de CRM para os médicos. O CRM é um número de registro que cada médico possui, e é usado para identificar a profissão do médico no Brasil. O formato esperado do CRM é composto por um número de 4 a 6 dígitos, seguido por um hífen e duas letras maiúsculas.

- **Método: validarCRM**

  **Descrição**: Valida se o CRM informado está no formato correto.

  **Parâmetros**:
  - `crm`: O CRM do médico a ser validado (String).

  **Retorno**:
  - Retorna `true` se o CRM for válido (no formato `XXXX-XX`), ou `false` caso contrário.


A API oferece os seguintes endpoints para gerenciar o sistema médico:

### **Pacientes**

- **GET /pacientes**: Retorna a lista de todos os pacientes.
- **GET /paciente/{id}**: Retorna os detalhes de um paciente específico pelo ID.
- **POST /paciente/criar**: Cria um novo paciente.
- **PUT /paciente/update/{id}**: Atualiza os dados de um paciente existente, baseado no ID.
- **DELETE /paciente/remover/{id}**: Deleta um paciente pelo ID.

### **Médicos**

- **GET /medicos/{crm}**: Retorna os detalhes de um médico específico pelo CRM.
- **POST /medicos/criar**: Cria um novo médico.
- **PUT /medicos/atualizar/{crm}**: Atualiza os dados de um médico existente, baseado no CRM.
- **DELETE /medicos/remover/{crm}**: Deleta um médico pelo CRM.

### **Consultas**

- **GET /consultas**: Retorna a lista de todas as consultas.
- **GET /consultas/{id}**: Retorna os detalhes de uma consulta específica pelo ID.
- **POST /consultas/agendar**: Agenda uma nova consulta.
- **DELETE /consultas/deletar/{id}**: Deleta uma consulta pelo ID.

## Endpoints de Exemplo

### Criar Paciente
```bash
POST /pacientes/criar
Content-Type: application/json
{
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "data" : "1985-07-01"
}

```

### Criar Médico
```bash
POST /medicos/criar
Content-Type: application/json
{
  "crm": "6771-BA",
  "nome": "Silvio Silveira",
  "especialidade": "Cardiologista"
}

```

### Criar Consulta
```bash
POST /medicos/criar
Content-Type: application/json
{
  "medico": {
    "crm": "6771-BA"
  },
  "paciente": {
    "pacienteId": 3
  }
}

```

