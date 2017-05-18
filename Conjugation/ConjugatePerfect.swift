//
//  ConjugatePerfect.swift
//  Conjugation
//
//  Created by Wasim Sandhu on 4/16/16.
//  Copyright © 2016 Wasim Sandhu. All rights reserved.
//

import Foundation

class ConjugatePerfect {
    
    var perfectViewController: PerfectTensesVC?

    var infinitive: String!
    var pastParticiple: String!
    
    var conjugationYo: String!
    var conjugationTu: String!
    var conjugationEl: String!
    var conjugationNos: String!
    var conjugationVos: String!
    var conjugationEllos: String!
    
    var isEndingAr = false
    var isEndingEr = false
    var isEndingIr = false
    
    var isIrregularPastParticiple = false
    var isNotGoingToWork = false
    
    let irregularPastParticiples = ["abrir", "decir", "cubrir", "descubrir", "poner", "freír",
    "hacer", "imprimir", "ir", "morir", "escribir", "resolver", "romper", "ver", "volver", "querer"]
    
    let verbsVoidToAlgorithms = ["arreglar", "ejercer", "merecer", "perder", "permanecer", "pertenecer",
    "agarrar", "aguardar", "alarmar", "apartar", "argumentar", "armar", "arrancar", "arreglar", "arrestar",
    "caracterizar", "cargar", "cariar", "cariciar", "clarificar", "comparar", "contrariar", "charlar",
    "declarar", "descarriar", "disparar", "embarazar", "encarcelar", "encargar", "garantizar", "martillar",
    "paralizar", "parar", "participar", "preparar", "reparar", "variar", "dirigir", "circunvenir", "adquirir", "marcar",
    "articular", "arriar", "arrojar", "arrastrar", "aclarar"]
    
    func prepareForConjugate() {
        
        // gets verb from text field
        infinitive = self.perfectViewController!.input!
        
        // checks verb ending and sets value to booleans
        if (infinitive.hasSuffix("ar")) {
            isEndingAr = true
            isEndingEr = false
            isEndingIr = false
        } else if (infinitive.hasSuffix("er")) {
            isEndingEr = true
            isEndingAr = false
            isEndingIr = false
        } else if (infinitive.hasSuffix("ir")) {
            isEndingIr = true
            isEndingEr = false
            isEndingAr = false
        } else if (infinitive.hasSuffix("ír")) {
            isEndingIr = true
            isEndingEr = false
            isEndingAr = false
        }
        
        if (verbsVoidToAlgorithms.contains(infinitive)) {
            isNotGoingToWork = true
        } else {
            isNotGoingToWork = false
        }
        
        conjugate()
    }
    
    func makePastParticiple() {
        
        if (irregularPastParticiples.contains(infinitive)) {
            isIrregularPastParticiple = true
        } else {
            isIrregularPastParticiple = false
        }
        
        if (isIrregularPastParticiple) {
            if (infinitive == "abrir") {
                pastParticiple = "abierto"
            } else if (infinitive == "decir") {
                pastParticiple = "dicho"
            } else if (infinitive == "poner") {
                pastParticiple = "puesto"
            } else if (infinitive == "freír") {
                pastParticiple = "frito"
            } else if (infinitive == "hacer") {
                pastParticiple = "hecho"
            } else if (infinitive == "imprimir") {
                pastParticiple = "impreso"
            } else if (infinitive == "ir") {
                pastParticiple = "ido"
            } else if (infinitive == "morir") {
                pastParticiple = "muerto"
            } else if (infinitive == "escribir") {
                pastParticiple = "escrito"
            } else if (infinitive == "romper") {
                pastParticiple = "roto"
            } else if (infinitive == "ver") {
                pastParticiple = "visto"
            } else if (infinitive == "volver") {
                pastParticiple = "vuelto"
            } else if (infinitive == "resolver") {
                pastParticiple = "resuelto"
            } else if (infinitive == "cubrir") {
                pastParticiple = "cubierto"
            } else if (infinitive == "descubrir") {
                pastParticiple = "descubierto"
            } else if (infinitive == "querer") {
                pastParticiple = "querido"
            }
        }
        
        if (isEndingAr && !isIrregularPastParticiple) {
            // -ar endings
            pastParticiple = infinitive.replacingOccurrences(of: "ar", with: "ado")
        } else if (isEndingEr && !isIrregularPastParticiple) {
            // -er endings
            pastParticiple = infinitive.replacingOccurrences(of: "er", with: "ido")
            if (infinitive.hasSuffix("aer")) {
                pastParticiple = infinitive.replacingOccurrences(of: "aer", with: "aído")
            } else if (infinitive.hasSuffix("eer")) {
                pastParticiple = infinitive.replacingOccurrences(of: "eer", with: "eído")
            }
        } else if (isEndingIr && !isIrregularPastParticiple) {
            // -ir endings
            pastParticiple = infinitive.replacingOccurrences(of: "ir", with: "ido")
            if (infinitive.hasSuffix("ír")) {
                pastParticiple = infinitive.replacingOccurrences(of: "ír", with: "ído")
            }
        }
    }
    
    func conjugate() {
        
        if isNotGoingToWork {
            replaceWithMoreThanOneEnding()
        } else {
            makePastParticiple()
        }
        
        if (infinitive != nil) {
            if (perfectViewController!.currentPerfectTense == "Present Perfect Tense") {
                conjugationYo = "he " + pastParticiple
                conjugationTu = "has " + pastParticiple
                conjugationEl = "ha " + pastParticiple
                conjugationNos = "hemos " + pastParticiple
                conjugationVos = "habéis " + pastParticiple
                conjugationEllos = "han " + pastParticiple
            } else if (perfectViewController!.currentPerfectTense == "Past Perfect Tense") {
                conjugationYo = "había " + pastParticiple
                conjugationTu = "habías " + pastParticiple
                conjugationEl = "había " + pastParticiple
                conjugationNos = "habíamos " + pastParticiple
                conjugationVos = "habíais " + pastParticiple
                conjugationEllos = "habían " + pastParticiple
            } else if (perfectViewController!.currentPerfectTense == "Future Perfect Tense") {
                conjugationYo = "habré " + pastParticiple
                conjugationTu = "habrás " + pastParticiple
                conjugationEl = "habrá " + pastParticiple
                conjugationNos = "habremos " + pastParticiple
                conjugationVos = "habréis " + pastParticiple
                conjugationEllos = "habrán " + pastParticiple
            } else if (perfectViewController!.currentPerfectTense == "Present Perfect Subjunctive") {
                conjugationYo = "haya " + pastParticiple
                conjugationTu = "hayas " + pastParticiple
                conjugationEl = "haya " + pastParticiple
                conjugationNos = "hayamos " + pastParticiple
                conjugationVos = "hayáis " + pastParticiple
                conjugationEllos = "hayan " + pastParticiple
            } else if (perfectViewController!.currentPerfectTense == "Past Perfect Subjunctive") {
                conjugationYo = "hubiera " + pastParticiple
                conjugationTu = "hubieras " + pastParticiple
                conjugationEl = "hubiera " + pastParticiple
                conjugationNos = "hubiéramos " + pastParticiple
                conjugationVos = "hubierais " + pastParticiple
                conjugationEllos = "hubieran " + pastParticiple
            } else if (perfectViewController!.currentPerfectTense == "Conditional Perfect Tense") {
                conjugationYo = "habría " + pastParticiple
                conjugationTu = "habrías " + pastParticiple
                conjugationEl = "habría " + pastParticiple
                conjugationNos = "habríamos " + pastParticiple
                conjugationVos = "habríais " + pastParticiple
                conjugationEllos = "habrían " + pastParticiple
            }
        } else {
            conjugationYo = "he " + pastParticiple
            conjugationTu = "has " + pastParticiple
            conjugationEl = "ha " + pastParticiple
            conjugationNos = "hemos " + pastParticiple
            conjugationVos = "habéis " + pastParticiple
            conjugationEllos = "han " + pastParticiple
        }
        
        self.perfectViewController!.perfectTable.reloadData()
    }
    
    func replaceWithMoreThanOneEnding() {
        
        if (isEndingAr) {
            // change ending to something else
            if let range = infinitive.range(of: "ar", options: NSString.CompareOptions.backwards) {
                infinitive.replaceSubrange(range, with: "bby")
            }
            
            pastParticiple = infinitive.replacingOccurrences(of: "bby", with: "ado")
        } else if (isEndingEr) {
            // change ending to something else
            if let range = infinitive.range(of: "er", options: NSString.CompareOptions.backwards) {
                infinitive.replaceSubrange(range, with: "bby")
            }
            
            pastParticiple = infinitive.replacingOccurrences(of: "bby", with: "ido")
        } else if (isEndingIr) {
            // change ending to something else
            if let range = infinitive.range(of: "ir", options: NSString.CompareOptions.backwards) {
                infinitive.replaceSubrange(range, with: "bby")
            }
            
            pastParticiple = infinitive.replacingOccurrences(of: "bby", with: "ido")
        }
    }
}
