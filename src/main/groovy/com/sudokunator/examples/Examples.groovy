package com.sudokunator.examples

import java.text.DateFormat
import java.text.SimpleDateFormat

class Examples {

    /*Tipos em Groovy*/

    static void tiposPrimitivosGroovy(){
        println 10.class
        println 100.5.class
        println true.class
        println false.class
    }

    static void verificador(){
        def idade = 20
        avaliarTipo(idade)
        def string = "Hello!"
        avaliarTipo(string)
        def populacao = 100000000L
        avaliarTipo(populacao)
        def orcamento = 200.00d
        avaliarTipo(orcamento)
        def preco = 200.00
        avaliarTipo(preco)
    }

    private static avaliarTipo(variavel){
        switch(variavel.getClass()){
            case Integer:
                println("A variável foi avaliada como Inteiro")
                break
            case BigDecimal:
                println("A variável foi avaliada como BigDecimal")
                break
            case Double:
                println("A variável foi avaliada como Double")
                break
            case String:
                println("A variável foi avaliada como String")
                break
            case Long:
                println("A variável foi avaliada como Long")
                break
            case BigInteger:
                println("A variável foi avaliada como BigInteger")
                break
        }
    }

    static void range() {
        /*Range*/
        println("--INTERVALO1")
        def intervalo1 = 1..15
        println(intervalo1.getClass())
        for (int i = 0; i < intervalo1.size(); i++) {
            print("${intervalo1[i]} ")
        }

        println("\n")
        println("--INTERVALO2")
        Range intervalo2 = 15..<30
        println(intervalo2.getClass())
        for (item in intervalo2) {
            print("${item} ")
        }

        println("\n")
        println("--ALFABETO A - Z")
        Range alfabeto = 'a'..'z'
        println(alfabeto.getClass())
        alfabeto.each {
            letra -> print("${letra} ")
        }

        println("\n")
        println("--ALFABETO Z - A")
        Range alfabeto2 = 'z'..'a'
        alfabeto2.each {
            print("${it} ")
        }

        println("\n")
        println("--SWITCH")
        def idade1 = 11
        definirIdade(idade1)
        def idade2 = 8
        definirIdade(idade2)

        println("\n")
        println("--FUNÇÕES DE RANGE")
        intervalo1 = 'a'..'e'

        /*
        if(intervalo1.contains('d')){
            println('O intervalo contém a letra d')
        }
        */
        println("O intervalo ${intervalo1 ? "" : "não"} contém a letra d")
        println "O intervalo tem ${intervalo1.size()} elementos"
        println "O primeiro elemento é '${intervalo1.from}'"
        println "O último elemento é '${intervalo1.to}'"
    }

    private static void definirIdade(idade){
        switch(idade){
            case 0..10:
                println("Você tem entre 0 e 10 anos.")
                break
            case 11..17:
                println("Você tem entre 11 e 17 anos.")
                break
            case idade >= 18:
                println("Você tem 18 anos ou mais.")
                break
        }
    }

    /*Lisas*/
    static void listas(){
        println "\n--Tipo de lista padrão no Groovy"
        def nomes = ["jose", "joao", "silva", "souza"]
        println nomes.class

        println "\n--Criar lista a partir de um Range"
        Range range = 1..10
        print "Antes ${range.class} - "
        List lista = range.toList()
        print "Depois ${lista.class}"

        println("\n--Juntando listas addAll()")
        def nomes1 = ['souza','silva','carlos','joao']
        println nomes1.size() //4
        def nomes2 = ['camilo','machado','mateus','paulo']
        nomes1.addAll(nomes2)
        println nomes1.size() //8

        println("\n--Juntando listas com +=")
        def nomes3 = ['souza','silva','carlos','joao']
        println nomes3.size() //4
        def nomes4 = ['camilo','machado','mateus','paulo']
        nomes3 + nomes4
        println nomes3.size() //8

        println("\n--Acessar item da lista")
        def precos1 = [10, 20, 30.0, 40]
        println "Elemento da posição 0: ${precos1[0]}"
        println "Elemento da posição 3: ${precos1.get(3)}"

        println("\n--Acessar item da lista com Range")
        def clientes = ['joao', 'silva', 'oliveira', 'neto', 'pereira', 'manoel']
        def intervalo = 2..5
        println clientes[intervalo]

        println("\n--Remover itens da lista com Range")
        clientes = ['joao', 'silva', 'oliveira', 'neto', 'pereira', 'manoel', 'carlos']
        println "antes $clientes"
        clientes[0..2] = []
        println "Depois $clientes"

        println("\n--Adicionar e remover itens de listas")
        clientes = []
        println clientes
        clientes += 'jose'
        println clientes
        clientes += ['elton', 'maria', 'lucena']
        println clientes
        clientes << 'carvalho'
        println clientes
        clientes -= 'jose'
        println clientes

        println("\n--Interando na lista")
        [1, 2, 3].each {
            println "Item: $it" // `it` is an implicit parameter corresponding to the current element
        }
        ['a', 'b', 'c'].eachWithIndex { it, i -> // `it` is the current element, while `i` is the index
            println "$i: $it"
        }

        println("\n--Lista vazia isEmpty()")
        def listaVazia = []
        println !listaVazia ? "Lista Vazia" : "Lista Não Vazia"
        listaVazia << [1,2,3]
        println !listaVazia ? "Lista Vazia" : "Lista Não Vazia"

        println("\n--Multiplicando itens da lista")
        def listaMult1 = [1, 2, 3]
        println "1Antes $listaMult1"
        println "1Depois ${listaMult1.collect { it * 2 }}"

        // shortcut syntax instead of collect
        def listaMulti2 = [1, 2, 3]
        println "2Antes $listaMulti2"
        println "2Depois ${listaMulti2*.multiply(2)}"

        def listaMulti3 = [1, 2, 3]
        println "3Antes $listaMulti3"
        println "3Depois ${listaMulti3.collect { it.multiply(2) }}"

        println("\n--Any() em listas")
        def lst = [1,2,3,4];
        def value;
        println("Lista $lst")
        // Is there any value above 2
        value = lst.any{element -> element > 2}
        println("Há > 2 na lista? $value");
        // Is there any value above 4
        value = lst.any{element -> element > 4}
        println("Há > 4 na lista? $value");

        println("\n--Every() em listas")
        def lst2 = [1,2,3,4];
        def value2;
        println("Lista 1: $lst2")
        // Are all value above 2
        value2 = lst2.every{element -> element > 2}
        println("Estão todos os valores acima de 2? $value2");
        // Are all value above 4
        value2 = lst2.every{element -> element > 4}
        println("Estão todos os valores acima de 4? $value2");
        def largelst2 = [4,5,6];
        // Are all value above 2
        value2 = largelst2.every{element -> element > 2}
        println("Lista 2: $largelst2")
        println("Estão todos os valores acima de 2? $value2");

        println("\n--Vários")
        // returns true if an element belongs to the list
        if('a' in ['a','b','c']) println("a in ['a','b','c']")
        // equivalent to the `contains` method in Java
        if(['a','b','c'].contains('a')) println("a contains ['a','b','c']")
        // `containsAll` will check that all elements are found
        if([1,3,4].containsAll([1,4])) println("[1,4] in [1,3,4]")
        // count the number of elements which have some value
        if ([1,2,3,3,3,3,4,5].count(3) == 4) println("há 4 repetições de '3' na lista [1,2,3,3,3,3,4,5]")
        // count the number of elements which match the predicate
        def result = [1,2,3,3,3,3,4,5].count {
            it%2==0
        } == 2
        if(result) println"há 2 elementos com resto zero para divisão por 2 na lista [1,2,3,3,3,3,4,5]"
        //Retorna uma lista com os os dados que bateram entre as listas
        println ("dados da intercção entre [1,2,4,6,8,10,12] e [1,3,6,9,12]" + [1,2,4,6,8,10,12].intersect([1,3,6,9,12]))
        //Retorna true se nenhum item das listas bater
        println("Listas [1,2,3] e [4,6,9] coincidem? " + [1,2,3].disjoint( [4,6,9] ))
        //Se um item da listas bater, retorna false
        println("Listas [1,2,3] e [2,4,6] coincidem? " + [1,2,3].disjoint( [2,4,6] ))

        println("\n--Duplicar elementos de lista")
        println("Original: " + [1, 2, 3] + " - Depois de Lista * 3: "[1, 2, 3] * 3)
        //Multiplica o numero de vezes que será repetida a cópia da lista
        println("[1, 2, 3].multiply(2) " + [1, 2, 3].multiply(2))
        //Multiplica o conteúdo da lista
        println("[1, 2, 3]*.multiply(2) " + [1, 2, 3]*.multiply(2))
        println("Collections.nCopies(3, 'b') " + Collections.nCopies(3, 'b'))

        // nCopies from the JDK has different semantics than multiply for lists
        println( Collections.nCopies(2, [1, 2])) //not [1,2,1,2]


        println("\n--Matriz ou multidimensional")
        lista = [[1,2,3,4],[4,5,6],[7,8,9]]
        println lista
        println lista.size()
        println lista.get(0)
        println lista.get(0).size()


    }

    /*Outros exemplos*/
    void naoEstatico(){
        println("Teve que fazer a instanciação")
    }

}
