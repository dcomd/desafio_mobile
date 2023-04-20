# Aplicativo Teste de Login

## Introdução
 - Tela de login usando (email e senha);
 - Tela home com mapa renderizando um ponto na localização atual do device;
 - Realizar o login utilizando Firebase Auth;
 - Armazenar na base de dados local (preferência por WatermelonDB, mas pode usar outro banco de dados) o usuário logado e sua última posição no mapa;
 - Testar fluxo de login (unit e e2e);
 - Testar fluxo da home (unit e e2e).

## Configuração do projeto
Ele pode ser baixado conforme abaixo:
```sh
$ git clone  https://github.com/dcomd/desafio_mobile.git
```
Abra-o no seu Android Studio
<img width="796" alt="Captura de Tela 2022-08-18 às 16 49 30" src="https://user-images.githubusercontent.com/26841238/185482115-adb2f78d-4b36-4cac-a6b7-d2806b0b7bc5.png">

Execute o projeto no seguinte icone.
<img width="24" alt="Captura de Tela 2022-08-18 às 16 50 33" src="https://user-images.githubusercontent.com/26841238/185482305-56a82404-d54c-4590-a658-b855461eb1d2.png">

## Visão geral da arquitetura
 - Este projeto foi construido com a linguagem Kotlin
 - DDD - Domain drive design
 - Clean Arch - Repository , useCase
 - MVVM
 
 ## Testes unitários
 - Foram testados as camadas de ViewModel , UseCase , Repository
 - Foi usado Junit para executar os testes e Mockito para efetuar os mocks de valores ficticios.

## Fluxo de trabalho de Controle de Versão
Usamos vagamente a abordagem "Git flow": master é a versão
branch - deve ser sempre liberável e apenas mesclado em
quando testamos e verificamos que tudo funciona e está
bom para ir.

O desenvolvimento diário é feito no ramo de desenvolvimento. Características,
correções de bugs e outras tarefas são feitas como ramificações do desenvolvimento,
em seguida, mesclado de volta ao desenvolvimento diretamente ou por meio de solicitações pull.

Mantenha os commits atômicos e autoexplicativos, use o rebase para limpar
até ramificações confusas antes de se fundir novamente no desenvolvimento.

## Ambiente de teste
```
Android Studio Chipmunk | 2021.2.1 Patch 1
dispositivo de teste: Android O (Google Pixel 2)
Certifique-se de que seu dispositivo tenha a versão Android >= 21.
```

## Tela A
![.](readme/android.gif)
## Tela B

