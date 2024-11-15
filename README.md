# -Componente-2-LP-group10
 Componente 2 LP group10
porque não podemos fazer um repositório para a superclasse em vez de estarmos a fazer um para cada subclasse?
-> Podemos mas já vamos ver isso
-> Neste caso só teríamos uma class "unified" que depois tinha de especificar por parâmetro que tipo está a procura.
-> Despois era apenas um service e um controller para a unified class

-> Divided way -> Cada class tem de ter o service, o controller e repository
-> Unified way -> Apenas a class pai tem de ter o service, o controller (JSON) -> Mas temos de dizer ao Springboot
que esta superclasse tem atributos que permitem dizer qual é o tipo de recurso (@JsonSubTypes).

-> Mesmo com a abordagem umnfied todas as classes mapeadas precisam de um ClassRepository.

Para o nosso projeto é melhor utilizar uma abordagem unified para os recursos e o resto divided?

Não consegui encontrar o ficheiro de setup da bookstore, o que preciso de mudar no pom.xml para o springboot iniciar normalmente?
