# HTML Analyzer

## Descrição

O **HTML Analyzer** é um programa Java que analisa o conteúdo HTML de uma página da web a partir de uma URL fornecida. Ele identifica e retorna o trecho de texto contido no nível mais profundo da estrutura HTML. Caso o HTML seja malformado, o programa retorna uma mensagem indicando o erro.

## Requisitos Funcionais

O objetivo é obter o trecho de texto no nível mais profundo da estrutura HTML. Considerando as seguintes premissas:

1. O código HTML está dividido em linhas.
2. Cada linha pode ser:
   - Tag de abertura (ex: `<div>`)
   - Tag de fechamento (ex: `</div>`)
   - Trecho de texto (ex: `Este é o corpo.`)
3. Uma linha não pode conter dois tipos de conteúdo.
4. Apenas elementos HTML com pares de tags de abertura e fechamento são utilizados (ex: `<div>` e `</div>`, mas não `<br/>`).
5. Tags de abertura não possuem atributos.

As linhas podem ter espaços iniciais para indentação, que devem ser ignorados, assim como linhas em branco.

Se dois ou mais trechos estiverem no nível máximo de profundidade, o primeiro deve ser retornado.

### Exemplo

Para o HTML abaixo:

```html
<html>
<head>
<title>
Este é o título.
</title>
</head>
<body>
Este é o corpo.
</body>
</html>
