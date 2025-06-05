# Kelari

**Kelari** é um projeto modular em Java para representar e trabalhar com a [OpenAPI Specification (OAS)](https://spec.openapis.org/). Ele fornece uma base extensível para análise, geração e visualização de documentos OpenAPI, com suporte a diferentes frameworks.

## ✨ Visão Geral

O objetivo do **Kelari** é oferecer:

- Um modelo de dados Java completo e fiel à especificação OpenAPI.
- Anotações para facilitar a geração automática de especificações diretamente do código-fonte.
- Ferramentas para construção, análise e validação de documentos OAS.
- Plugins e integrações para automatizar a geração da documentação em diferentes estágios do build.
- Interfaces web interativas baseadas em OpenAPI para diversos frameworks (Spring, Quarkus, Helidon).
- Suporte modular para uso em diferentes tipos de aplicações (REST síncronas ou reativas).

## 📦 Módulos

O projeto está dividido nos seguintes módulos Maven:

| Módulo                            | Descrição                                                                                  |  
|-----------------------------------|--------------------------------------------------------------------------------------------|
| `kelari-core`                     | Funcionalidades centrais para análise, construção e validação de specs OAS.                |
| `kelari-annotation`               | Conjunto de anotações Java para ajudar na geração de documentação OpenAPI.                 |
| `kelari-model`                    | Representações em Java dos componentes da OpenAPI Specification.                           |
| `kelari-maven-plugin`             | Plugin Maven para geração e validação automática de documentos OpenAPI a partir do código. |
| `kelari-helidon-web-ui`           | Integração com Helidon para exibir uma interface web interativa baseada em OpenAPI.        |
| `kelari-spring-stater-web-ui`     | Starter para aplicações Spring MVC com suporte à interface web baseada em OpenAPI.         |
| `kelari-spring-stater-webflux-ui` | Starter para aplicações Spring WebFlux com suporte à interface web baseada em OpenAPI.     |
| `kelari-quarkus-web-ui`           | Integração com Quarkus para exibir uma interface web interativa baseada em OpenAPI.        |

## 🚀 Como Usar

### Pré-requisitos

- Java 8 ou superior
- Maven 3.8 ou superior
