
# 🔗 Gerador de QR Code com AWS S3

🚀 **Tecnologias: Java | Spring Boot | AWS S3 | Google ZXing | Docker | Maven**

Aplicação desenvolvida com Spring Boot capaz de gerar QR Codes e armazená-los diretamente em um bucket da AWS S3.

---

## 🔧 Requisitos Necessários

- Java JDK 21
- Maven
- Conta na AWS com acesso ao serviço S3 e AWS CLI configurado
- Docker (opcional para deploy em container)

---

## 🔐 Configuração de Ambiente

Crie um arquivo `.env` na raiz do projeto contendo as variáveis abaixo:

```
AWS_ACCESS_KEY_ID=sua_chave_de_acesso
AWS_SECRET_ACCESS_KEY=sua_chave_secreta
AWS_REGION=sua_regiao
AWS_BUCKET_NAME=nome_do_seu_bucket
```

---

## 🚀 Como Executar

### 💻 Executando Localmente

1. Configure o arquivo `.env` conforme acima.
2. Compile o projeto com o comando:

```
mvn clean package
```

3. Inicie a aplicação executando:

```
mvn spring-boot:run
```

---

### 🐳 Executando com Docker

1. Gere a imagem Docker:

```
docker build -t qrcode-generator:X.X .
```

(Substitua `X.X` pelo nome ou versão desejada.)

2. Execute o container:

```
docker run --env-file .env -p 8080:8080 qrcode-generator:X.X
```

(Se necessário, ajuste o caminho do arquivo `.env`.)

---

## ☁️ Configurando o AWS S3

- Crie um bucket no S3 da sua conta AWS.
- Atualize a variável `AWS_BUCKET_NAME` no seu arquivo `.env`.
- As credenciais AWS precisam de permissões para:
  - `PutObject` (enviar arquivos)
  - `GetObject` (acessar arquivos)
  - `ListBucket` (listar arquivos, se necessário)

---

## 🔗 Documentação da API

### `POST /qrcode`

Endpoint responsável por gerar um QR Code a partir do texto fornecido e armazená-lo no AWS S3.

#### 🔸 Parâmetros da Requisição

| Nome | Obrigatório | Tipo   | Descrição                                 |
|------|--------------|--------|--------------------------------------------|
| text | ✔️           | string | Texto que será convertido em QR Code.     |

#### 🔸 Exemplo de Resposta (Sucesso)

```
{
  "url": "https://seu-bucket.s3.sua-regiao.amazonaws.com/uuid-aleatorio"
}
```

#### 🔸 Resposta de Erro

- Código: `500 Internal Server Error`
- Motivo: Falha na geração do QR Code ou erro no envio para o S3.

#### 🔸 Exemplo de Consumo

```
curl -X POST http://localhost:8080/qrcode      -H "Content-Type: application/json"      -d '{"text": "https://example.com"}'
```
