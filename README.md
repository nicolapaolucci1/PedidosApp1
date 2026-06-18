# App de Controle de Pedidos e Clientes

Aplicativo Android desenvolvido em Kotlin utilizando Jetpack Compose, com foco em arquitetura moderna (MVVM) e persistência local com Room Database.

O sistema simula o funcionamento de um pequeno comércio, permitindo gerenciar clientes, produtos e pedidos.

---

## Funcionalidades

### 🔐 Login
- Autenticação de usuário
- Validação de credenciais no banco local
- Usuário padrão: `admin / 1234`

---

### 👤 Clientes
- Cadastro de clientes
- Listagem com LazyColumn
- Exclusão de clientes

Campos:
- Nome
- Telefone
- E-mail
- Cidade

---

### 📦 Produtos
- Cadastro de produtos
- Listagem com LazyColumn
- Exclusão de produtos

Campos:
- Nome
- Descrição
- Valor
- Estoque

---

### 🧾 Pedidos
- Criação de pedidos
- Relacionamento com Cliente e Produto
- Cálculo automático do valor total
- Seleção de data (DatePicker)
- Seleção de hora (TimePicker)
- Listagem de pedidos
- Exclusão com confirmação (AlertDialog)

---

### ⚙️ Configurações
- Persistência com DataStore
- Nome do usuário
- Tema escuro/claro

---

## Tecnologias utilizadas

- Kotlin
- Jetpack Compose
- Material 3
- Room Database
- MVVM (Model-View-ViewModel)
- Navigation Compose
- DataStore Preferences
- Coroutines / Flow

---

## Arquitetura do Projeto
data/
├── dao/
├── database/
├── entity/
├── datastore/
└── repository/

ui/
├── screens/
├── viewmodel/
├──navigation/
---

## Funcionalidades técnicas aplicadas

- Jetpack Compose para interface moderna
- Navigation Compose para navegação entre telas
- Room com relacionamentos entre tabelas
- Flow e StateFlow para atualização reativa de dados
- DataStore para persistência de preferências
- MVVM para separação de responsabilidades

---

## Usuário padrão
Usuário: admin
Senha: 1234


---

## Como executar o projeto

1. Abrir o projeto no Android Studio
2. Sincronizar Gradle
3. Executar em um emulador ou dispositivo físico
4. Fazer login com o usuário padrão

---

## Autor

- Seu nome aqui

---

## Observações
Projeto acadêmico desenvolvido para fins de aprendizado, aplicando conceitos de desenvolvimento Android moderno.
