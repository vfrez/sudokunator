package com.sudokunator.main

static void main(String[] args) {

    List<List> completo
    List quadrado1 = [1,2,3,4,5,6,7,8,9]
    List quadrado2 = [1,2,3,4,5,6,7,8,9]
    List quadrado3 = [1,2,3,4,5,6,7,8,9]
    List quadrado4 = [1,2,3,4,5,6,7,8,9]
    List quadrado5 = [1,2,3,4,5,6,7,8,9]
    List quadrado6 = [1,2,3,4,5,6,7,8,9]
    List quadrado7 = [1,2,3,4,5,6,7,8,9]
    List quadrado8 = [1,2,3,4,5,6,7,8,9]
    List quadrado9 = [1,2,3,4,5,6,7,8,9]

    completo = [quadrado1,
                quadrado2,
                quadrado3,
                quadrado4,
                quadrado5,
                quadrado6,
                quadrado7,
                quadrado8,
                quadrado9]

    println(quadrado1)

    def count = 1
/*    quadrado1.each {
        print("$it ")
        if (count == 3) {
            println()
            count = 0
        }
        count ++
    }*/
    def count1 = 1
    def count2 = 1

    println("________________________")
    completo[0..2].each {
        it[0..2].each {
            print("$it ")
        }
        print("| ")
    }
    println("\n________________________")
    completo[3..5].each {
        it[0..2].each {
            print("$it ")
        }
        print("| ")
    }
    println("\n________________________")
    completo[6..8].each {
        it[0..2].each {
            print("$it ")
        }
        print("| ")
    }
    println("\n________________________")

//    quadrado1[0..2].each {
//        print(it)
//    }
//    print("\n")
//    quadrado1[3..5].each {
//        print(it)
//    }
//    print("\n")
//    quadrado1[6..8].each {
//        print(it)
//    }
    /*
    completo.each {
            it.each {
                print{"$it "}
                count2++
            }
            count1++


        print("$it ")
            if (count == 3) {
                println()
                count = 0
            }
            count ++
        }
*/
}