# TrabalhoAlgoritimosIII-01



Sejam arquivos texto que descrevem matrizes utilizando o seguinte formato:

   linhas colunas
   dados da linha 0
   dados da linha 1
   ...
   dados da linha (colunas - 1)

onde,

    linhas, representa o número de linhas da matriz;
    colunas, representa o número de linhas da coluna;
    dados, represantam os dados de cada célula de uma linha da coluna, podendo ter o valor 0 (zero) ou 1 (um)

como por exemplo, o arquivo

    6 5
    000000
    011000
    011010
    000010
    000010

que contém uma matriz de 6 linhas por 5 colunas, que pode ser armazenada na forma:

     | 0 | 0 | 0 | 0 | 0 | 0 |
     | 0 | 1 | 1 | 0 | 0 | 0 |
     | 0 | 1 | 1 | 0 | 1 | 0 |
     | 0 | 0 | 0 | 0 | 1 | 0 |
     | 0 | 0 | 0 | 0 | 1 | 0 |

Crie dois programas onde, dado um desses arquivos representando matrizes, sejam capazes de:

    a) Contar o número de "ilhas" formadas por grupos de 1 conectados na horizontal ou vertical;
    b) Criar uma estrutura que permita localizar as ilhas na matriz.

Os grupos de 1 que formam ilhas devem estar conectados apenas na horizonta ou vertical, e não na diagonal. Por exemplo a seguinte matriz possui apenas uma ilha:

   0000
   0110
   0110
   0000

Já o exemplo a seguir mostra duas ilhas:

   0000
   0100
   0010
   0000

A avaliação do trabalho será realizada executando o programa para uma série de arquivos, e comparando a saída do programa com uma saída esperada. Esta avaliação automatizada está disponível apenas para o item "a".

Por exemplo, dada o arquivo:

   4 4
   1100
   1100
   0010
   0000

O resultado esperado é:

   2

O trabalho deve entregue até a 10a. aula do semestre (Prova 1), e a apresentação será realizada na 11a. aula.

O trabalho pode ser realizado em grupos de 2 até 3 alunos.

Apenas um dos alunos deve entregar o trabalho. O código deve, obrigatoriamente, estar disponível em um repositório do Github, o qual deve ser indicado na entrega do trabalho.

Serão avaliados a correção das tarefas, a qualidade do algoritmo (consumo de memória e tempo de execução), a qualidade do código, e a utilazação correta do controle de versão (git).

São disponibilizados alguns arquivos para testes de desenvolvimento, contendo um exemplo de matriz e o resultado esperado para aquela matriz. Na avaliação do trabalho, serão utilizados arquivos diferentes, portanto crie seu algoritmo para que funcione independente dos dados de entrada, respeitado o formato de arquivo.
