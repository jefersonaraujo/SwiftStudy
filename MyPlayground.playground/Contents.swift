//: Playground - noun: a place where people can play

import UIKit
import Foundation
var str = "Hello, playground"

var poder = 9000

if poder > 8000 {
    print("E mais de oito mil");
}else{
    print("e menor ou igual");
}
var esferasAchadas = 0
for esfera in 1...8 {
    print(esfera)

    
    switch esferasAchadas {
    case 0:
        print("so faltam 7")
    case 1,2,3:
        print("Continue procurando")
    case 4...6:
        print("falta pouco")
    case 7:
        print("Qual o seu desejo")
    default:
        print("Mais de 7")
    }
    esferasAchadas=esferasAchadas+1
}

let trecho1 = "Qual o significado da vida,"
let trecho2 = "do universo e tudo mais ?"
let resposta=42
let fraseResposta = "A resposta e " + String(resposta)
let fraseResposta2 = "A resposta e \(resposta)"
fraseResposta.uppercased()
fraseResposta2.lowercased()

if trecho1 > trecho2{
    print(trecho1)
}else{
    print(trecho2)
}

//
//for var esfera=7; esfera<=7; esfera++ {
//    print(esfera)
//}

let lista = "ratos,golfinhos,humanos"
var array = lista.components(separatedBy:",")
print (array[1])

var arrayDeStrings = ["Neo", "Trinity","Morpheus"]
var arrayDeInteiros : [Int] = [1,2,3,4,5]
var arrayDeDecimais : [Double] = []

arrayDeStrings[1]
arrayDeStrings.count

arrayDeStrings.append("Smit")
arrayDeInteiros.append(10)

arrayDeStrings[0] = "Mr Anderson"
arrayDeInteiros.remove(at: 0)
arrayDeInteiros







