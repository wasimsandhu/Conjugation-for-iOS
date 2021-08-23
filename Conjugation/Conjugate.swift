//
//  Conjugate.swift
//  Conjugation
//
//  Created by Wasim Sandhu on 4/3/16.
//  Copyright © 2016 Wasim Sandhu. All rights reserved.
//

import Foundation

class Conjugate {
    
    var mainViewController: MainViewController?
    
    var infinitive: String!
    var stemChangedVerb: String!
    
    var conjugationYo: String!
    var conjugationTu: String!
    var conjugationEl: String!
    var conjugationNos: String!
    var conjugationVos: String!
    var conjugationEllos: String!
    
    var isEndingAr = false
    var isEndingEr = false
    var isEndingIr = false
    
    var hasSpellingChange = false
    var isIrregularVerb = false
    var isIrregularYoVerb = false
    var isIrregularInPreterite = false
    var isNotGoingToWork = false
    
    var hasStemChange = false
    var E2IE = false
    var O2UE = false
    var E2I = false
    var U2UE = false
    var O2HUE = false
    var IEStemChange = false
    
    var nextIndexIE = false
    var nextIndexI = false
    
    let irregularVerbs = ["ir", "ser", "estar", "dar", "saber", "conocer", "hacer", "traer", "poner", "ver", "salir", "conducir", "haber", "poder", "querer", "venir", "decir", "tener", "oír", "freír", "reír", "caer", "sonreír", "servir" ]
    
    let irregularYoVerbs = ["tener", "venir", "salir", "poner", "caer", "traer", "oír", "hacer", "decir", "conducir", "conocer"]
    
    let stemChangingVerbsIE = ["cerrar", "comenzar", "despertar", "divertir", "empezar", "empecar", "encender", "entender", "sentir", "mentir", "negar", "nevar", "pensar", "preferir", "recomendar", "sentar", "querer", "helar", "confesar", "calentar", "encerrar", "fregar", "defender", "sugerir", "gobernar", "encerrar", "tropezar"]
    
    let otherStemChangingVerbsIE = ["despertar", "empezar", "empecar", "encender", "entender", "preferir"]
    
    let stemChangingVerbsUE = ["acostar", "acordar", "almorzar", "aprobar", "contar", "costar", "doler", "dormir", "encontrar", "llover", "morir", "poder", "probar", "recordar", "soñar", "volar", "promover", "mostrar", "disolver", "devolver", "demostrar", "colgar", "cocer", "absolver", "remover", "revolver", "rogar", "soler", "sonar" ,"torcer", "tronar", "demoler", "morder", "envolver", "volver", "poblar"]
    
    let stemChangingVerbsI = ["conseguir", "corregir", "seguir", "vestir", "pedir", "perseguir", "persegir", "elejir", "elegir", "repetir", "impedir", "medir"]
    
    let otherStemChangingVerbsI = ["perseguir", "persegir", "elejir", "elegir", "repetir" ]
    
    let verbsIrregularInPreterite = ["leer", "construir", "creer"]
    
    let verbsIrregularInPreteriteWithStem = ["competir", "repetir", "divertir", "sentir", "mentir", "vestir", "preferir", "sugerir"]
    
    let verbsVoidToAlgorithms = ["acarrear", "arreglar", "aclarar", "ejercer", "merecer", "perder", "permanecer", "pertenecer", "agarrar", "aguardar", "alarmar", "apartar", "argumentar", "armar", "arrancar", "arreglar", "arrestar", "caracterizar", "cargar", "cariar", "caricƒiar", "clarificar", "comparar", "contrariar", "charlar", "declarar", "descarriar", "disparar", "embarazar", "encarcelar", "encargar", "garantizar", "martillar", "paralizar", "parar", "participar", "preparar", "reparar", "variar", "dirigir", "circunvenir", "adquirir", "marcar", "articular", "arriar", "arrojar", "arrastrar"]
    
    func conjugate() {
        
        // gets verb from text field
        infinitive = self.mainViewController!.input!
        
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
        }
        
        // booleans to handle irregular verbs
        if (irregularVerbs.contains(infinitive)) {
            isIrregularVerb = true
        } else {
            isIrregularVerb = false
        }
        
        if (irregularYoVerbs.contains(infinitive)) {
            isIrregularYoVerb = true
        } else {
            isIrregularYoVerb = false
        }
        
        if (verbsVoidToAlgorithms.contains(infinitive)) {
            isNotGoingToWork = true
        } else {
            isNotGoingToWork = false
        }
        
        // booleans to handle stem-changing verbs
        if (stemChangingVerbsIE.contains(infinitive)) {
            E2IE = true
            E2I = false
            O2UE = false
            U2UE = false
            O2HUE = false
        } else if (stemChangingVerbsI.contains(infinitive)) {
            E2I = true
            E2IE = false
            O2UE = false
            U2UE = false
            O2HUE = false
        } else if (stemChangingVerbsUE.contains(infinitive)) {
            O2UE = true
            E2I = false
            E2IE = false
            U2UE = false
            O2HUE = false
        } else if (infinitive == "jugar") {
            U2UE = true
            E2I = false
            O2UE = false
            E2IE = false
            O2HUE = false
        } else if (infinitive == "oler") {
            O2HUE = true
            E2I = false
            O2UE = false
            U2UE = false
            E2IE = false
        }
        
        if (verbsIrregularInPreteriteWithStem.contains(infinitive)) {
            IEStemChange = true
        }
        
        if (E2IE) { hasStemChange = true }
        if (O2UE) { hasStemChange = true }
        if (E2I) { hasStemChange = true }
        if (U2UE) { hasStemChange = true }
        if (O2HUE) { hasStemChange = true }
        if (IEStemChange) { hasStemChange = true }
        
        // boolean for checking for -car, -gar, -zar spelling changes for some tenses
        if (infinitive.hasSuffix("car")) { hasSpellingChange = true }
        if (infinitive.hasSuffix("gar")) { hasSpellingChange = true }
        if (infinitive.hasSuffix("zar")) { hasSpellingChange = true }
        
        if (!isIrregularVerb && !isNotGoingToWork) {
            // checks selected tense in picker and performs appropriate conjugations
            if (mainViewController!.currentTense == "Present Tense") {
                if (hasStemChange) { doStemChange() }
                doPresentTense()
            } else if (mainViewController!.currentTense == "Preterite Tense") {
                doPreteriteTense()
            } else if (mainViewController!.currentTense == "Imperfect Tense") {
                doImperfectTense()
            } else if (mainViewController!.currentTense == "Future Tense") {
                doFutureTense()
            } else if (mainViewController!.currentTense == "Imperative Tense") {
                if (hasStemChange) { doStemChange() }
                doAffirmativeCommand()
            } else if (mainViewController!.currentTense == "Negative Imperative Tense") {
                if (hasStemChange) { doStemChange() }
                doNegativeCommand()
            } else if (mainViewController!.currentTense == "Present Subjunctive Tense") {
                doPresentSubjunctiveTense()
            } else if (mainViewController!.currentTense == "Imperfect Subjunctive Tense") {
                doImperfectSubjunctiveTense()
            } else if (mainViewController!.currentTense == "Conditional Tense") {
                doConditionalTense()
            }
        } else if (isIrregularVerb && !isNotGoingToWork) {
            if (mainViewController!.currentTense == "Present Tense") {
                
                if (isIrregularYoVerb) {
                    conjugateIrregularYoVerb()
                }
                
                if (infinitive == "ir") {
                    conjugationYo = "voy"
                    conjugationTu = "vas"
                    conjugationEl = "va"
                    conjugationNos = "vamos"
                    conjugationVos = "vais"
                    conjugationEllos = "van"
                    
                } else if (infinitive == "ser") {
                    conjugationYo = "soy"
                    conjugationTu = "eres"
                    conjugationEl = "es"
                    conjugationNos = "somos"
                    conjugationVos = "sois"
                    conjugationEllos = "son"
                    
                } else if (infinitive == "estar") {
                    conjugationYo = "estoy"
                    conjugationTu = "estás"
                    conjugationEl = "está"
                    conjugationNos = "estamos"
                    conjugationVos = "estáis"
                    conjugationEllos = "están"
                    
                } else if (infinitive == "dar") {
                    conjugationYo = "doy"
                    conjugationTu = "das"
                    conjugationEl = "da"
                    conjugationNos = "damos"
                    conjugationVos = "dais"
                    conjugationEllos = "dan"
                    
                } else if (infinitive == "saber") {
                    conjugationYo = "sé"
                    conjugationTu = "sabes"
                    conjugationEl = "sabe"
                    conjugationNos = "sabemos"
                    conjugationVos = "sabéis"
                    conjugationEllos = "saben"
                    
                } else if (infinitive == "conocer") {
                    
                    conjugationTu = "conoces"
                    conjugationEl = "conoce"
                    conjugationNos = "conocemos"
                    conjugationVos = "conocéis"
                    conjugationEllos = "conocen"
                    
                } else if (infinitive == "hacer") {
                    
                    conjugationTu = "haces"
                    conjugationEl = "hace"
                    conjugationNos = "hacemos"
                    conjugationVos = "hacéis"
                    conjugationEllos = "hacen"
                    
                } else if (infinitive == "traer") {
                    
                    conjugationTu = "traes"
                    conjugationEl = "trae"
                    conjugationNos = "traemos"
                    conjugationVos = "traéis"
                    conjugationEllos = "traen"
                    
                } else if (infinitive == "poner") {
                    
                    conjugationTu = "pones"
                    conjugationEl = "pone"
                    conjugationNos = "ponemos"
                    conjugationVos = "ponéis"
                    conjugationEllos = "ponen"
                    
                } else if (infinitive == "ver") {
                    conjugationYo = "veo"
                    conjugationTu = "ves"
                    conjugationEl = "ve"
                    conjugationNos = "vemos"
                    conjugationVos = "véis"
                    conjugationEllos = "ven"
                    
                } else if (infinitive == "salir") {
                    
                    conjugationTu = "sales"
                    conjugationEl = "sale"
                    conjugationNos = "salemos"
                    conjugationVos = "salís"
                    conjugationEllos = "salen"
                    
                } else if (infinitive == "conducir") {
                    
                    conjugationTu = "conduces"
                    conjugationEl = "conduce"
                    conjugationNos = "conducimos"
                    conjugationVos = "conducís"
                    conjugationEllos = "conducen"
                    
                } else if (infinitive == "poder") {
                    conjugationYo = "puedo"
                    conjugationTu = "puedes"
                    conjugationEl = "puede"
                    conjugationNos = "podemos"
                    conjugationVos = "podéis"
                    conjugationEllos = "pueden"
                    
                } else if (infinitive == "querer") {
                    conjugationYo = "quiero"
                    conjugationTu = "quieres"
                    conjugationEl = "quiere"
                    conjugationNos = "queremos"
                    conjugationVos = "queréis"
                    conjugationEllos = "quieren"
                    
                } else if (infinitive == "tener") {
                    
                    conjugationTu = "tienes"
                    conjugationEl = "tiene"
                    conjugationNos = "tenemos"
                    conjugationVos = "tenéis"
                    conjugationEllos = "tienen"
                    
                } else if (infinitive == "decir") {
                    
                    conjugationTu = "dices"
                    conjugationEl = "dice"
                    conjugationNos = "decimos"
                    conjugationVos = "decís"
                    conjugationEllos = "dicen"
                    
                } else if (infinitive == "venir") {
                    
                    conjugationTu = "vienes"
                    conjugationEl = "viene"
                    conjugationNos = "venimos"
                    conjugationVos = "venís"
                    conjugationEllos = "vienen"
                    
                } else if (infinitive == "haber") {
                    conjugationYo = "he"
                    conjugationTu = "has"
                    conjugationEl = "ha"
                    conjugationNos = "hemos"
                    conjugationVos = "habéis"
                    conjugationEllos = "han"
                    
                } else if (infinitive == "oír") {
                    
                    conjugationTu = "oyes"
                    conjugationEl = "oye"
                    conjugationNos = "oímos"
                    conjugationVos = "oís"
                    conjugationEllos = "oyen"
                    
                } else if (infinitive == "freír") {
                    conjugationYo = "frío"
                    conjugationTu = "fríes"
                    conjugationEl = "fríe"
                    conjugationNos = "freímos"
                    conjugationVos = "freís"
                    conjugationEllos = "fríen"
                    
                } else if (infinitive == "reír") {
                    conjugationYo = "río"
                    conjugationTu = "ríes"
                    conjugationEl = "ríe"
                    conjugationNos = "reímos"
                    conjugationVos = "reís"
                    conjugationEllos = "ríen"
                    
                } else if (infinitive == "sonreír") {
                    conjugationYo = "sonrío"
                    conjugationTu = "sonríes"
                    conjugationEl = "sonríe"
                    conjugationNos = "sonreímos"
                    conjugationVos = "sonreís"
                    conjugationEllos = "sonríen"
                    
                } else if (infinitive == "caer") {
                    
                    conjugationTu = "caes"
                    conjugationEl = "cae"
                    conjugationNos = "caemos"
                    conjugationVos = "caéis"
                    conjugationEllos = "caen"
                    
                } else if (infinitive == "servir") {
                    conjugationYo = "sirvo"
                    conjugationTu = "sirves"
                    conjugationEl = "sirve"
                    conjugationNos = "servimos"
                    conjugationVos = "servís"
                    conjugationEllos = "sirven"
                    
                }
            } else if (mainViewController!.currentTense == "Preterite Tense") {
                if (infinitive == "ir") {
                    conjugationYo = "fui"
                    conjugationTu = "fuiste"
                    conjugationEl = "fue"
                    conjugationNos = "fuimos"
                    conjugationVos = "fuisteis"
                    conjugationEllos = "fueron"
                    
                } else if (infinitive == "ser") {
                    conjugationYo = "fui"
                    conjugationTu = "fuiste"
                    conjugationEl = "fue"
                    conjugationNos = "fuimos"
                    conjugationVos = "fuisteis"
                    conjugationEllos = "fueron"
                    
                } else if (infinitive == "estar") {
                    conjugationYo = "estuve"
                    conjugationTu = "estuviste"
                    conjugationEl = "estuvo"
                    conjugationNos = "estuvimos"
                    conjugationVos = "estuvisteis"
                    conjugationEllos = "estuvieron"
                    
                } else if (infinitive == "dar") {
                    conjugationYo = "di"
                    conjugationTu = "diste"
                    conjugationEl = "dio"
                    conjugationNos = "dimos"
                    conjugationVos = "disteis"
                    conjugationEllos = "dieron"
                    
                } else if (infinitive == "saber") {
                    conjugationYo = "supe"
                    conjugationTu = "supiste"
                    conjugationEl = "supo"
                    conjugationNos = "supimos"
                    conjugationVos = "supisteis"
                    conjugationEllos = "supieron"
                    
                } else if (infinitive == "conocer") {
                    conjugationYo = "conocí"
                    conjugationTu = "conociste"
                    conjugationEl = "conoció"
                    conjugationNos = "conocimos"
                    conjugationVos = "conocisteis"
                    conjugationEllos = "conocieron"
                    
                } else if (infinitive == "hacer") {
                    conjugationYo = "hice"
                    conjugationTu = "hiciste"
                    conjugationEl = "hizo"
                    conjugationNos = "hicimos"
                    conjugationVos = "hicisteis"
                    conjugationEllos = "hicieron"
                    
                } else if (infinitive == "traer") {
                    conjugationYo = "traje"
                    conjugationTu = "trajiste"
                    conjugationEl = "trajo"
                    conjugationNos = "trajimos"
                    conjugationVos = "trajisteis"
                    conjugationEllos = "trajeron"
                    
                } else if (infinitive == "poner") {
                    conjugationYo = "puse"
                    conjugationTu = "pusiste"
                    conjugationEl = "puso"
                    conjugationNos = "pusimos"
                    conjugationVos = "pusisteis"
                    conjugationEllos = "pusieron"
                    
                } else if (infinitive == "ver") {
                    conjugationYo = "ví"
                    conjugationTu = "viste"
                    conjugationEl = "vió"
                    conjugationNos = "vimos"
                    conjugationVos = "visteis"
                    conjugationEllos = "vieron"
                    
                } else if (infinitive == "salir") {
                    conjugationYo = "salí"
                    conjugationTu = "saliste"
                    conjugationEl = "salió"
                    conjugationNos = "salimos"
                    conjugationVos = "salisteis"
                    conjugationEllos = "salieron"
                    
                } else if (infinitive == "conducir") {
                    conjugationYo = "conduje"
                    conjugationTu = "condujiste"
                    conjugationEl = "condujo"
                    conjugationNos = "condujimos"
                    conjugationVos = "condujisteis"
                    conjugationEllos = "condujeron"
                    
                } else if (infinitive == "haber") {
                    conjugationYo = "hube"
                    conjugationTu = "hubiste"
                    conjugationEl = "hubo"
                    conjugationNos = "hubimos"
                    conjugationVos = "hubisteis"
                    conjugationEllos = "hubieron"
                    
                } else if (infinitive == "poder") {
                    conjugationYo = "pude"
                    conjugationTu = "pudiste"
                    conjugationEl = "pudo"
                    conjugationNos = "pudimos"
                    conjugationVos = "pudisteis"
                    conjugationEllos = "pudieron"
                    
                } else if (infinitive == "querer") {
                    conjugationYo = "quise"
                    conjugationTu = "quisiste"
                    conjugationEl = "quiso"
                    conjugationNos = "quisimos"
                    conjugationVos = "quisisteis"
                    conjugationEllos = "quisieron"
                    
                } else if (infinitive == "tener") {
                    conjugationYo = "tuve"
                    conjugationTu = "tuviste"
                    conjugationEl = "tuvo"
                    conjugationNos = "tuvimos"
                    conjugationVos = "tuvisteis"
                    conjugationEllos = "tuvieron"
                    
                } else if (infinitive == "venir") {
                    conjugationYo = "vine"
                    conjugationTu = "viniste"
                    conjugationEl = "vino"
                    conjugationNos = "vinimos"
                    conjugationVos = "visteis"
                    conjugationEllos = "vinieron"
                    
                } else if (infinitive == "decir") {
                    conjugationYo = "dije"
                    conjugationTu = "dijiste"
                    conjugationEl = "dijo"
                    conjugationNos = "dijimos"
                    conjugationVos = "dijisteis"
                    conjugationEllos = "dijeron"
                    
                } else if (infinitive == "oír") {
                    conjugationYo = "oí"
                    conjugationTu = "oíste"
                    conjugationEl = "oyó"
                    conjugationNos = "oímos"
                    conjugationVos = "oísteis"
                    conjugationEllos = "oyeron"
                    
                } else if (infinitive == "freír") {
                    conjugationYo = "freí"
                    conjugationTu = "freíste"
                    conjugationEl = "frió"
                    conjugationNos = "freímos"
                    conjugationVos = "freísteis"
                    conjugationEllos = "frieron"
                    
                } else if (infinitive == "reír") {
                    conjugationYo = "reí"
                    conjugationTu = "reíste"
                    conjugationEl = "rió"
                    conjugationNos = "reímos"
                    conjugationVos = "reísteis"
                    conjugationEllos = "rieron"
                    
                } else if (infinitive == "sonreír") {
                    conjugationYo = "sonreí"
                    conjugationTu = "sonreíste"
                    conjugationEl = "sonrió"
                    conjugationNos = "sonreímos"
                    conjugationVos = "sonreísteis"
                    conjugationEllos = "sonrieron"
                    
                } else if (infinitive == "caer") {
                    conjugationYo = "caí"
                    conjugationTu = "caíste"
                    conjugationEl = "cayó"
                    conjugationNos = "caímos"
                    conjugationVos = "caísteis"
                    conjugationEllos = "cayeron"
                    
                } else if (infinitive == "servir") {
                    conjugationYo = "serví"
                    conjugationTu = "serviste"
                    conjugationEl = "sirvió"
                    conjugationNos = "servimos"
                    conjugationVos = "servisteis"
                    conjugationEllos = "sirvieron"
                    
                }
            } else if (mainViewController!.currentTense == "Imperfect Tense") {
                if (infinitive == "ir") {
                    conjugationYo = "iba"
                    conjugationTu = "ibas"
                    conjugationEl = "iba"
                    conjugationNos = "íbamos"
                    conjugationVos = "ibais"
                    conjugationEllos = "iban"
                    
                } else if (infinitive == "ser") {
                    conjugationYo = "era"
                    conjugationTu = "eras"
                    conjugationEl = "era"
                    conjugationNos = "éramos"
                    conjugationVos = "erais"
                    conjugationEllos = "eran"
                    
                } else if (infinitive == "ver") {
                    conjugationYo = "veía"
                    conjugationTu = "veías"
                    conjugationEl = "veía"
                    conjugationNos = "veíamos"
                    conjugationVos = "veíais"
                    conjugationEllos = "veían"
                    
                } else if (infinitive == "oír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    conjugationYo = infinitive.replacingOccurrences(of: "ir", with: "ía")
                    conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "ías")
                    conjugationEl = infinitive.replacingOccurrences(of: "ir", with: "ía")
                    conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "íamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "íais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "ían")
                    
                }  else if (infinitive == "freír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    conjugationYo = infinitive.replacingOccurrences(of: "ir", with: "ía")
                    conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "ías")
                    conjugationEl = infinitive.replacingOccurrences(of: "ir", with: "ía")
                    conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "íamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "íais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "ían")
                    
                } else if (infinitive == "reír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    conjugationYo = infinitive.replacingOccurrences(of: "ir", with: "ía")
                    conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "ías")
                    conjugationEl = infinitive.replacingOccurrences(of: "ir", with: "ía")
                    conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "íamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "íais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "ían")
                    
                } else if (infinitive == "sonreír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    conjugationYo = infinitive.replacingOccurrences(of: "ir", with: "ía")
                    conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "ías")
                    conjugationEl = infinitive.replacingOccurrences(of: "ir", with: "ía")
                    conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "íamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "íais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "ían")
                    
                } else if (infinitive == "querer") {
                    conjugationYo = infinitive.replacingOccurrences(of: "querer", with: "quería")
                    conjugationTu = infinitive.replacingOccurrences(of: "querer", with: "querías")
                    conjugationEl = infinitive.replacingOccurrences(of: "querer", with: "quería")
                    conjugationNos = infinitive.replacingOccurrences(of: "querer", with: "queríamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "querer", with: "queríais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "querer", with: "querían")
                    
                } else if (infinitive == "servir") {
                    conjugationYo = "servía"
                    conjugationTu = "servías"
                    conjugationEl = "servía"
                    conjugationNos = "servíamos"
                    conjugationVos = "servíais"
                    conjugationEllos = "servían"
                    
                } else {
                    if (isEndingAr) {
                        doImperfectTense()
                    } else {
                        doImperfectTense()
                    }
                }
            } else if (mainViewController!.currentTense == "Future Tense") {
                if (infinitive == "haber") {
                    infinitive = "habr"
                    doFutureTense()
                } else if (infinitive == "poder") {
                    infinitive = "podr"
                    doFutureTense()
                } else if (infinitive == "querer") {
                    infinitive = "querr"
                    doFutureTense()
                } else if (infinitive == "saber") {
                    infinitive = "sabr"
                    doFutureTense()
                } else if (infinitive == "poner") {
                    infinitive = "pondr"
                    doFutureTense()
                } else if (infinitive == "salir") {
                    infinitive = "saldr"
                    doFutureTense()
                } else if (infinitive == "tener") {
                    infinitive = "tendr"
                    doFutureTense()
                } else if (infinitive == "venir") {
                    infinitive = "vendr"
                    doFutureTense()
                } else if (infinitive == "decir") {
                    infinitive = "dir"
                    doFutureTense()
                } else if (infinitive == "hacer") {
                    infinitive = "har"
                    doFutureTense()
                } else if (infinitive == "oír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    doFutureTense()
                } else if (infinitive == "freír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    doFutureTense()
                } else if (infinitive == "reír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    doFutureTense()
                } else if (infinitive == "sonreír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    doFutureTense()
                } else if (infinitive == "servir") {
                    conjugationYo = "serviré"
                    conjugationTu = "servirás"
                    conjugationEl = "servirá"
                    conjugationNos = "serviremos"
                    conjugationVos = "serviréis"
                    conjugationEllos = "servirán"
                    
                } else {
                    doFutureTense()
                }
            } else if (mainViewController!.currentTense == "Imperative Tense") {
                if (infinitive == "decir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "di"
                    conjugationEl = "diga"
                    conjugationNos = "digamos"
                    conjugationEllos = "digan"
                    
                } else if (infinitive == "hacer") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "haz"
                    conjugationEl = "haga"
                    conjugationNos = "hagamos"
                    conjugationEllos = "hagan"
                    
                } else if (infinitive == "ir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "ve"
                    conjugationEl = "vaya"
                    conjugationNos = "vayamos"
                    conjugationEllos = "vayan"
                    
                } else if (infinitive == "poner") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "pon"
                    conjugationEl = "ponga"
                    conjugationNos = "pongamos"
                    conjugationEllos = "pongan"
                    
                } else if (infinitive == "salir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "sal"
                    conjugationEl = "salga"
                    conjugationNos = "salgamos"
                    conjugationEllos = "salgan"
                    
                } else if (infinitive == "ser") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "sé"
                    conjugationEl = "sea"
                    conjugationNos = "seamos"
                    conjugationEllos = "sean"
                    
                } else if (infinitive == "tener") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "ten"
                    conjugationEl = "tenga"
                    conjugationNos = "tengamos"
                    conjugationEllos = "tengan"
                    
                } else if (infinitive == "venir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "ve"
                    conjugationEl = "venga"
                    conjugationNos = "vengamos"
                    conjugationEllos = "vengan"
                    
                } else if (infinitive == "querer") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "quiere"
                    conjugationEl = "quiera"
                    conjugationNos = "queramos"
                    conjugationEllos = "quieran"
                    
                } else if (infinitive == "conducir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "conduce"
                    conjugationEl = "conduzca"
                    conjugationNos = "conduzcamos"
                    conjugationEllos = "conduzcan"
                    
                } else if (infinitive == "estar") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "está"
                    conjugationEl = "esté"
                    conjugationNos = "estemos"
                    conjugationEllos = "estén"
                    
                } else if (infinitive == "dar") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "da"
                    conjugationEl = "dé"
                    conjugationNos = "demos"
                    conjugationEllos = "den"
                    
                } else if (infinitive == "oír") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "oye"
                    conjugationEl = "oiga"
                    conjugationNos = "oigamos"
                    conjugationEllos = "oigan"
                    
                } else if (infinitive == "freír") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "fríe"
                    conjugationEl = "fría"
                    conjugationNos = "fríamos"
                    conjugationEllos = "frían"
                    
                } else if (infinitive == "reír") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "ríe"
                    conjugationEl = "ría"
                    conjugationNos = "ríamos"
                    conjugationEllos = "rían"
                    
                } else if (infinitive == "sonreír") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "sonríe"
                    conjugationEl = "sonría"
                    conjugationNos = "sonríamos"
                    conjugationEllos = "sonrían"
                    
                } else if (infinitive == "caer") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "cae"
                    conjugationEl = "caiga"
                    conjugationNos = "caigamos"
                    conjugationEllos = "caigan"
                    
                } else if (infinitive == "ver") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "ve"
                    conjugationEl = "vea"
                    conjugationNos = "veamos"
                    conjugationEllos = "vean"
                    
                } else if (infinitive == "poder") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "puede"
                    conjugationEl = "pueda"
                    conjugationNos = "podamos"
                    conjugationEllos = "puedan"
                    
                } else if (infinitive == "servir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "sirve"
                    conjugationEl = "sirva"
                    conjugationNos = "sirvamos"
                    conjugationEllos = "sirvan"
                    
                }
                // Negative commands
            } else if (mainViewController!.currentTense == "Negative Imperative Tense") {
                if (infinitive == "decir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no digas"
                    conjugationEl = "no diga"
                    conjugationNos = "no digamos"
                    conjugationEllos = "no digan"
                    
                } else if (infinitive == "hacer") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no haz"
                    conjugationEl = "no haga"
                    conjugationNos = "no hagamos"
                    conjugationEllos = "no hagan"
                    
                } else if (infinitive == "ir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no vayas"
                    conjugationEl = "no vaya"
                    conjugationNos = "no vayamos"
                    conjugationEllos = "no vayan"
                    
                } else if (infinitive == "poner") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no pongas"
                    conjugationEl = "no ponga"
                    conjugationNos = "no pongamos"
                    conjugationEllos = "no pongan"
                    
                } else if (infinitive == "salir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no salgas"
                    conjugationEl = "no salga"
                    conjugationNos = "no salgamos"
                    conjugationEllos = "no salgan"
                    
                } else if (infinitive == "ser") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no seas"
                    conjugationEl = "no sea"
                    conjugationNos = "no seamos"
                    conjugationEllos = "no sean"
                    
                } else if (infinitive == "tener") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no tengas"
                    conjugationEl = "no tenga"
                    conjugationNos = "no tengamos"
                    conjugationEllos = "no tengan"
                    
                } else if (infinitive == "venir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no vengas"
                    conjugationEl = "no venga"
                    conjugationNos = "no vengamos"
                    conjugationEllos = "no vengan"
                    
                } else if (infinitive == "querer") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no quieras"
                    conjugationEl = "no quiera"
                    conjugationNos = "no queramos"
                    conjugationEllos = "no quieran"
                    
                } else if (infinitive == "conducir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no conduczas"
                    conjugationEl = "no conduzca"
                    conjugationNos = "no conduzcamos"
                    conjugationEllos = "no conduzcan"
                    
                } else if (infinitive == "estar") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no estés"
                    conjugationEl = "no esté"
                    conjugationNos = "no estemos"
                    conjugationEllos = "no estén"
                    
                } else if (infinitive == "dar") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no des"
                    conjugationEl = "no dé"
                    conjugationNos = "no demos"
                    conjugationEllos = "no den"
                    
                } else if (infinitive == "oír") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no oye"
                    conjugationEl = "no oiga"
                    conjugationNos = "no oigamos"
                    conjugationEllos = "no oigan"
                    
                } else if (infinitive == "freír") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no fríes"
                    conjugationEl = "no fría"
                    conjugationNos = "no fríamos"
                    conjugationEllos = "no frían"
                    
                } else if (infinitive == "reír") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no ríes"
                    conjugationEl = "no ría"
                    conjugationNos = "no ríamos"
                    conjugationEllos = "no rían"
                    
                } else if (infinitive == "sonreír") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no sonrías"
                    conjugationEl = "no sonría"
                    conjugationNos = "no sonríamos"
                    conjugationEllos = "no sonrían"
                    
                } else if (infinitive == "ver") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no veas"
                    conjugationEl = "no vea"
                    conjugationNos = "no veamos"
                    conjugationEllos = "no vean"
                    
                } else if (infinitive == "poder") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no puedas"
                    conjugationEl = "no pueda"
                    conjugationNos = "no podamos"
                    conjugationEllos = "no puedan"
                    
                } else if (infinitive == "servir") {
                    conjugationYo = " "
                    conjugationVos = " "
                    conjugationTu = "no sirvas"
                    conjugationEl = "no sirva"
                    conjugationNos = "no sirvamos"
                    conjugationEllos = "no sirvan"
                    
                }
                // Present subjunctive verb conjugations
            } else if (mainViewController!.currentTense == "Present Subjunctive Tense") {
                if (infinitive == "ir") {
                    conjugationYo = "vaya"
                    conjugationTu = "vayas"
                    conjugationEl = conjugationYo
                    conjugationNos = "vayamos"
                    conjugationVos = "vayáis"
                    conjugationEllos = "vayan"
                    
                } else if (infinitive == "ser") {
                    conjugationYo = "sea"
                    conjugationTu = "seas"
                    conjugationEl = conjugationYo
                    conjugationNos = "seamos"
                    conjugationVos = "seáis"
                    conjugationEllos = "sean"
                    
                } else if (infinitive == "estar") {
                    conjugationYo = "esté"
                    conjugationTu = "estés"
                    conjugationEl = conjugationYo
                    conjugationNos = "estemos"
                    conjugationVos = "estéis"
                    conjugationEllos = "estén"
                    
                } else if (infinitive == "dar") {
                    conjugationYo = "dé"
                    conjugationTu = "des"
                    conjugationEl = conjugationYo
                    conjugationNos = "demos"
                    conjugationVos = "deis"
                    conjugationEllos = "den"
                    
                } else if (infinitive == "saber") {
                    conjugationYo = "sepa"
                    conjugationTu = "sepas"
                    conjugationEl = conjugationYo
                    conjugationNos = "sepamos"
                    conjugationVos = "sepáis"
                    conjugationEllos = "sepan"
                    
                } else if (infinitive == "conocer") {
                    conjugationYo = "conozca"
                    conjugationTu = "conozcas"
                    conjugationEl = conjugationYo
                    conjugationNos = "conozcamos"
                    conjugationVos = "conozcáis"
                    conjugationEllos = "conozcan"
                    
                } else if (infinitive == "hacer") {
                    conjugationYo = "haga"
                    conjugationTu = "hagas"
                    conjugationEl = conjugationYo
                    conjugationNos = "hagamos"
                    conjugationVos = "hagáis"
                    conjugationEllos = "hagan"
                    
                } else if (infinitive == "traer") {
                    conjugationYo = "traiga"
                    conjugationTu = "traigas"
                    conjugationEl =     conjugationYo
                    conjugationNos = "traigamos"
                    conjugationVos = "traigáis"
                    conjugationEllos = "traigan"
                    
                } else if (infinitive == "poner") {
                    conjugationYo = "ponga"
                    conjugationTu = "pongas"
                    conjugationEl = conjugationYo
                    conjugationNos = "pongamos"
                    conjugationVos = "pongáis"
                    conjugationEllos = "pongan"
                    
                } else if (infinitive == "ver") {
                    conjugationYo = "vea"
                    conjugationTu = "veas"
                    conjugationEl = conjugationYo
                    conjugationNos = "veamos"
                    conjugationVos = "veáis"
                    conjugationEllos = "vean"
                    
                } else if (infinitive == "salir") {
                    conjugationYo = "salga"
                    conjugationTu = "salgas"
                    conjugationEl = conjugationYo
                    conjugationNos = "salgamos"
                    conjugationVos = "salgáis"
                    conjugationEllos = "salgan"
                    
                } else if (infinitive == "conducir") {
                    conjugationYo = "conduzca"
                    conjugationTu = "conduzcas"
                    conjugationEl = conjugationYo
                    conjugationNos = "conduzcamos"
                    conjugationVos = "conduzcáis"
                    conjugationEllos = "conduzcan"
                    
                } else if (infinitive == "haber") {
                    conjugationYo = "haya"
                    conjugationTu = "hayas"
                    conjugationEl =     conjugationYo
                    conjugationNos = "hayamos"
                    conjugationVos = "hayáis"
                    conjugationEllos = "hayan"
                    
                } else if (infinitive == "poder") {
                    conjugationYo = "pueda"
                    conjugationTu = "puedas"
                    conjugationEl = conjugationYo
                    conjugationNos = "podamos"
                    conjugationVos = "podáis"
                    conjugationEllos = "puedan"
                    
                } else if (infinitive == "querer") {
                    conjugationYo = "quiera"
                    conjugationTu = "quieras"
                    conjugationEl = conjugationYo
                    conjugationNos = "queramos"
                    conjugationVos = "queráis"
                    conjugationEllos = "quieran"
                    
                } else if (infinitive == "venir") {
                    conjugationYo = "venga"
                    conjugationTu = "vengas"
                    conjugationEl = conjugationYo
                    conjugationNos = "vengamos"
                    conjugationVos = "vengáis"
                    conjugationEllos = "vengan"
                    
                } else if (infinitive == "decir") {
                    conjugationYo = "diga"
                    conjugationTu = "digas"
                    conjugationEl = conjugationYo
                    conjugationNos = "digamos"
                    conjugationVos = "digáis"
                    conjugationEllos = "digan"
                    
                } else if (infinitive == "tener") {
                    conjugationYo = "tenga"
                    conjugationTu = "tengas"
                    conjugationEl =     conjugationYo
                    conjugationNos = "tengamos"
                    conjugationVos = "tengáis"
                    conjugationEllos = "tengan"
                    
                } else if (infinitive == "oír") {
                    conjugationYo = "oiga"
                    conjugationTu = "oigas"
                    conjugationEl =     conjugationYo
                    conjugationNos = "oigamos"
                    conjugationVos = "oigáis"
                    conjugationEllos = "oigan"
                    
                } else if (infinitive == "freír") {
                    conjugationYo = "fría"
                    conjugationTu = "frías"
                    conjugationEl =     conjugationYo
                    conjugationNos = "fríamos"
                    conjugationVos = "friais"
                    conjugationEllos = "frían"
                    
                } else if (infinitive == "reír") {
                    conjugationYo = "ría"
                    conjugationTu = "rías"
                    conjugationEl =     conjugationYo
                    conjugationNos = "riamos"
                    conjugationVos = "riais"
                    conjugationEllos = "rían"
                    
                } else if (infinitive == "sonreír") {
                    conjugationYo = "sonría"
                    conjugationTu = "sonrías"
                    conjugationEl =     conjugationYo
                    conjugationNos = "sonriamos"
                    conjugationVos = "sonriáis"
                    conjugationEllos = "sonrían"
                    
                } else if (infinitive == "caer") {
                    conjugationYo = "caiga"
                    conjugationTu = "caigas"
                    conjugationEl = "caiga"
                    conjugationNos = "caigamos"
                    conjugationVos = "caigáis"
                    conjugationEllos = "caigan"
                    
                } else if (infinitive == "servir") {
                    conjugationYo = "sirva"
                    conjugationTu = "sirvas"
                    conjugationEl = "sirva"
                    conjugationNos = "sirvamos"
                    conjugationVos = "sirváis"
                    conjugationEllos = "sirvan"
                    
                }
                // Imperfect subjunctive verb conjugations
            } else if (mainViewController!.currentTense == "Imperfect Subjunctive Tense") {
                if (infinitive == "ir") {
                    conjugationYo = "fuera"
                    conjugationTu = "fueras"
                    conjugationEl = "fuera"
                    conjugationNos = "fuéramos"
                    conjugationVos = "fuerais"
                    conjugationEllos = "fueran"
                    
                } else if (infinitive == "ser") {
                    conjugationYo = "fuera"
                    conjugationTu = "fueras"
                    conjugationEl = "fuera"
                    conjugationNos = "fuéramos"
                    conjugationVos = "fuerais"
                    conjugationEllos = "fueran"
                    
                } else if (infinitive == "estar") {
                    conjugationYo = "estuviera"
                    conjugationTu = "estuvieras"
                    conjugationEl = "estuviera"
                    conjugationNos = "estuviéramos"
                    conjugationVos = "estuvierais"
                    conjugationEllos = "estuvieran"
                    
                } else if (infinitive == "dar") {
                    conjugationYo = "diera"
                    conjugationTu = "dieras"
                    conjugationEl = "diera"
                    conjugationNos = "diéramos"
                    conjugationVos = "dierais"
                    conjugationEllos = "dieran"
                    
                } else if (infinitive == "saber") {
                    conjugationYo = "supiera"
                    conjugationTu = "supieras"
                    conjugationEl = "supiera"
                    conjugationNos = "supiéramos"
                    conjugationVos = "supierais"
                    conjugationEllos = "supieran"
                    
                } else if (infinitive == "conocer") {
                    conjugationYo = "conociera"
                    conjugationTu = "conocieras"
                    conjugationEl = "conociera"
                    conjugationNos = "conociéramos"
                    conjugationVos = "conocierais"
                    conjugationEllos = "conocieran"
                    
                } else if (infinitive == "hacer") {
                    conjugationYo = "hiciera"
                    conjugationTu = "hicieras"
                    conjugationEl = "hiciera"
                    conjugationNos = "hiciéramos"
                    conjugationVos = "hicierais"
                    conjugationEllos = "hicieran"
                    
                } else if (infinitive == "traer") {
                    conjugationYo = "trajera"
                    conjugationTu = "trajeras"
                    conjugationEl = "trajera"
                    conjugationNos = "trajéramos"
                    conjugationVos = "trajerais"
                    conjugationEllos = "trajeran"
                    
                } else if (infinitive == "poner") {
                    conjugationYo = "pusiera"
                    conjugationTu = "pusieras"
                    conjugationEl = "pusiera"
                    conjugationNos = "pusiéramos"
                    conjugationVos = "pusierais"
                    conjugationEllos = "pusieran"
                    
                } else if (infinitive == "ver") {
                    conjugationYo = "cupiera"
                    conjugationTu = "cupieras"
                    conjugationEl = "cupiera"
                    conjugationNos = "cupiéramos"
                    conjugationVos = "cupierais"
                    conjugationEllos = "cupieran"
                    
                } else if (infinitive == "salir") {
                    conjugationYo = "saliera"
                    conjugationTu = "salieras"
                    conjugationEl = "saliera"
                    conjugationNos = "saliéramos"
                    conjugationVos = "salierais"
                    conjugationEllos = "salieran"
                    
                } else if (infinitive == "conducir") {
                    conjugationYo = "condujera"
                    conjugationTu = "condujeras"
                    conjugationEl = "condujera"
                    conjugationNos = "condujéramos"
                    conjugationVos = "condujerais"
                    conjugationEllos = "condujeran"
                    
                } else if (infinitive == "haber") {
                    conjugationYo = "hubiera"
                    conjugationTu = "hubieras"
                    conjugationEl = "hubiera"
                    conjugationNos = "hubiéramos"
                    conjugationVos = "hubierais"
                    conjugationEllos = "hubieran"
                    
                } else if (infinitive == "poder") {
                    conjugationYo = "pudiera"
                    conjugationTu = "pudieras"
                    conjugationEl = "pudiera"
                    conjugationNos = "pudiéramos"
                    conjugationVos = "pudierais"
                    conjugationEllos = "pudieran"
                    
                } else if (infinitive == "querer") {
                    conjugationYo = "quisiera"
                    conjugationTu = "quisieras"
                    conjugationEl = "quisiera"
                    conjugationNos = "quisiéramos"
                    conjugationVos = "quisierais"
                    conjugationEllos = "quisieran"
                    
                } else if (infinitive == "tener") {
                    conjugationYo = "tuviera"
                    conjugationTu = "tuvieras"
                    conjugationEl = "tuviera"
                    conjugationNos = "tuviéramos"
                    conjugationVos = "tuvierais"
                    conjugationEllos = "tuvieran"
                    
                } else if (infinitive == "venir") {
                    conjugationYo = "viniera"
                    conjugationTu = "vinieras"
                    conjugationEl = "viniera"
                    conjugationNos = "viniéramos"
                    conjugationVos = "vinierais"
                    conjugationEllos = "vinieran"
                    
                } else if (infinitive == "decir") {
                    conjugationYo = "dijera"
                    conjugationTu = "dijeras"
                    conjugationEl = "dijera"
                    conjugationNos = "dijéramos"
                    conjugationVos = "dijerais"
                    conjugationEllos = "dijeran"
                    
                } else if (infinitive == "oír") {
                    conjugationYo = "oyera"
                    conjugationTu = "oyeras"
                    conjugationEl = "oyera"
                    conjugationNos = "oyéramos"
                    conjugationVos = "oyerais"
                    conjugationEllos = "oyeran"
                    
                } else if (infinitive == "freír") {
                    conjugationYo = "friera"
                    conjugationTu = "frieras"
                    conjugationEl = "friera"
                    conjugationNos = "friéramos"
                    conjugationVos = "frierais"
                    conjugationEllos = "frieran"
                    
                } else if (infinitive == "reír") {
                    conjugationYo = "riera"
                    conjugationTu = "rieras"
                    conjugationEl = "riera"
                    conjugationNos = "riéramos"
                    conjugationVos = "rierais"
                    conjugationEllos = "rieran"
                    
                } else if (infinitive == "sonreír") {
                    conjugationYo = "sonriera"
                    conjugationTu = "sonrieras"
                    conjugationEl = "sonriera"
                    conjugationNos = "sonriéramos"
                    conjugationVos = "sonrierais"
                    conjugationEllos = "sonrieran"
                    
                } else if (infinitive == "caer") {
                    conjugationYo = "cayera"
                    conjugationTu = "cayeras"
                    conjugationEl = "cayera"
                    conjugationNos = "cayéramos"
                    conjugationVos = "cayerais"
                    conjugationEllos = "cayeran"
                    
                } else if (infinitive == "servir") {
                    conjugationYo = "sirviera"
                    conjugationTu = "sirvieras"
                    conjugationEl = "sirviera"
                    conjugationNos = "sirviéramos"
                    conjugationVos = "sirvierais"
                    conjugationEllos = "sirvieran"
                    
                }
                // Conditional tense verb conjugations
            } else if (mainViewController!.currentTense == "Conditional Tense") {
                if (infinitive == "haber") {
                    infinitive = "habr"
                    doConditionalTense()
                } else if (infinitive == "poder") {
                    infinitive = "podr"
                    doConditionalTense()
                } else if (infinitive == "querer") {
                    infinitive = "querr"
                    doConditionalTense()
                } else if (infinitive == "saber") {
                    infinitive = "sabr"
                    doConditionalTense()
                } else if (infinitive == "poner") {
                    infinitive = "pondr"
                    doConditionalTense()
                } else if (infinitive == "salir") {
                    infinitive = "saldr"
                    doConditionalTense()
                } else if (infinitive == "tener") {
                    infinitive = "tendr"
                    doConditionalTense()
                } else if (infinitive == "venir") {
                    infinitive = "vendr"
                    doConditionalTense()
                } else if (infinitive == "decir") {
                    infinitive = "dir"
                    doConditionalTense()
                } else if (infinitive == "hacer") {
                    infinitive = "har"
                    doConditionalTense()
                } else if (infinitive == "oír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    doConditionalTense()
                } else if (infinitive == "freír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    doConditionalTense()
                } else if (infinitive == "reír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    doConditionalTense()
                } else if (infinitive == "sonreír") {
                    infinitive = infinitive.replacingOccurrences(of: "ír", with: "ir")
                    doConditionalTense()
                } else if (infinitive == "servir") {
                    conjugationYo = "serviría"
                    conjugationTu = "servirías"
                    conjugationEl = "serviría"
                    conjugationNos = "serviríamos"
                    conjugationVos = "serviríais"
                    conjugationEllos = "servirían"
                    
                } else {
                    doConditionalTense()
                }
            }
            /* CODE SPILL */
        } else if (isNotGoingToWork && !isIrregularVerb) {
            if (mainViewController!.currentTense == "Present Tense") {
                if (isEndingAr) {
                    if let range = infinitive.range(of: "ar", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "o")
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "as")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "a")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "amos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "áis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "an")
                    
                } else if (isEndingEr) {
                    if (infinitive == "perder") {
                        conjugationYo = "pierdo"
                        conjugationTu = "pierdes"
                        conjugationEl = "pierde"
                        conjugationNos = "perdemos"
                        conjugationVos = "perdéis"
                        conjugationEllos = "pierden"
                    } else {
                        if let range = infinitive.range(of: "er", options: NSString.CompareOptions.backwards) {
                            infinitive.replaceSubrange(range, with: "bby")
                        }
                        
                        conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "o")
                        conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "es")
                        conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "e")
                        conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "emos")
                        conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "éis")
                        conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "en")
                    }
                } else if (isEndingIr) {
                    if let range = infinitive.range(of: "ir", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "o")
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "es")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "e")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "imos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "ís")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "en")
                }
            } else if (mainViewController!.currentTense == "Preterite Tense") {
                if (isEndingAr) {
                    if (hasSpellingChange) {
                        if (infinitive.hasSuffix("car")) {
                            conjugationYo = infinitive.replacingOccurrences(of: "car", with: "qué")
                        } else if (infinitive.hasSuffix("gar")) {
                            conjugationYo = infinitive.replacingOccurrences(of: "gar", with: "gué")
                        } else if (infinitive.hasSuffix("zar")) {
                            conjugationYo = infinitive.replacingOccurrences(of: "zar", with: "cé")
                        }
                    } else {
                        if let range = infinitive.range(of: "ar", options: NSString.CompareOptions.backwards) {
                            infinitive.replaceSubrange(range, with: "bby")
                        }
                        
                        conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "é")
                    }
                    
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "aste")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "ó")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "amos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "asteis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "aron")
                    
                } else if (isEndingEr) {
                    if let range = infinitive.range(of: "er", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "í")
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "iste")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "ió")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "imos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "isteis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "ieron")
                } else if (isEndingIr) {
                    if let range = infinitive.range(of: "ir", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "í")
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "iste")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "ió")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "imos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "isteis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "ieron")
                }
            } else if (mainViewController!.currentTense == "Imperfect Tense") {
                if (isEndingAr) {
                    if let range = infinitive.range(of: "ar", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "aba")
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "abas")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "aba")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "ábamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "abais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "aban")
                    
                } else if (isEndingEr) {
                    if let range = infinitive.range(of: "er", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "ía")
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "ías")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "ía")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "íamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "íais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "ían")
                    
                } else if (isEndingIr) {
                    if let range = infinitive.range(of: "ir", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "ía")
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "ías")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "ía")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "íamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "íais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "ían")
                }
            } else if (mainViewController!.currentTense == "Future Tense") {
                conjugationYo = infinitive + "é"
                conjugationTu = infinitive + "ás"
                conjugationEl = infinitive + "á"
                conjugationNos = infinitive + "emos"
                conjugationVos = infinitive + "éis"
                conjugationEllos = infinitive + "án"
            } else if (mainViewController!.currentTense == "Imperative Tense") {
                if (isEndingAr) {
                    
                    if let range = infinitive.range(of: "ar", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "a")
                    if hasSpellingChange { spellingChange() }
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "e")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "emos")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "en")
                } else if (isEndingEr) {
                    
                    if (infinitive == "perder") {
                        conjugationTu = "pierde"
                        conjugationEl = "pierda"
                        conjugationNos = "pierdamos"
                        conjugationEllos = "pierdan"
                    } else {
                        
                        if let range = infinitive.range(of: "er", options: NSString.CompareOptions.backwards) {
                            infinitive.replaceSubrange(range, with: "bby")
                        }
                        
                        conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "e")
                        if hasSpellingChange { spellingChange() }
                        conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "a")
                        conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "amos")
                        conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "an")
                    }
                } else if (isEndingIr) {
                    
                    if let range = infinitive.range(of: "ir", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "e")
                    if hasSpellingChange { spellingChange() }
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "a")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "amos")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "an")
                }
                
                // No commands for these two forms
                conjugationYo = " "
                conjugationVos = " "
                
            } else if (mainViewController!.currentTense == "Negative Imperative Tense") {
                if (isEndingAr) {
                    
                    if let range = infinitive.range(of: "ar", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationTu = "no " + infinitive.replacingOccurrences(of: "bby", with: "es")
                    if hasSpellingChange { spellingChange() }
                    conjugationEl = "no " + infinitive.replacingOccurrences(of: "bby", with: "e")
                    conjugationNos = "no " + infinitive.replacingOccurrences(of: "bby", with: "emos")
                    conjugationEllos = "no " + infinitive.replacingOccurrences(of: "bby", with: "en")
                } else if (isEndingEr) {
                    
                    if (infinitive == "perder") {
                        conjugationTu = "no pierde"
                        conjugationEl = "no pierda"
                        conjugationNos = "no pierdamos"
                        conjugationEllos = "no pierdan"
                    } else {
                        if let range = infinitive.range(of: "er", options: NSString.CompareOptions.backwards) {
                            infinitive.replaceSubrange(range, with: "bby")
                        }
                        
                        conjugationTu = "no " + infinitive.replacingOccurrences(of: "bby", with: "as")
                        if hasSpellingChange { spellingChange() }
                        conjugationEl = "no " + infinitive.replacingOccurrences(of: "bby", with: "a")
                        conjugationNos = "no " + infinitive.replacingOccurrences(of: "bby", with: "amos")
                        conjugationEllos = "no " + infinitive.replacingOccurrences(of: "bby", with: "an")
                    }
                } else if (isEndingIr) {
                    
                    if let range = infinitive.range(of: "ir", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationTu = "no " + infinitive.replacingOccurrences(of: "bby", with: "as")
                    if hasSpellingChange { spellingChange() }
                    conjugationEl = "no " + infinitive.replacingOccurrences(of: "bby", with: "a")
                    conjugationNos = "no " + infinitive.replacingOccurrences(of: "bby", with: "amos")
                    conjugationEllos = "no " + infinitive.replacingOccurrences(of: "bby", with: "an")
                }
                
                // No commands for these two forms
                conjugationYo = " "
                conjugationVos = " "
                
            } else if (mainViewController!.currentTense == "Present Subjunctive Tense") {
                if (infinitive.hasSuffix("car")) { hasSpellingChange = true }
                if (infinitive.hasSuffix("gar")) { hasSpellingChange = true }
                if (infinitive.hasSuffix("zar")) { hasSpellingChange = true }
                if (hasSpellingChange) { spellingChangeForSubjunctive() }
                
                if (isEndingAr) {
                    
                    // change ending to something else
                    if let range = infinitive.range(of: "ar", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "e")
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "es")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "e")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "emos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "éis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "en")
                } else if (isEndingEr) {
                    
                    if (infinitive == "perder") {
                        conjugationYo = "pierda"
                        conjugationTu = "pierdas"
                        conjugationEl = "pierda"
                        conjugationNos = "perdamos"
                        conjugationVos = "perdáis"
                        conjugationEllos = "pierdan"
                        setText()
                    } else {
                        // change ending to something else
                        if let range = infinitive.range(of: "er", options: NSString.CompareOptions.backwards) {
                            infinitive.replaceSubrange(range, with: "bby")
                        }
                        
                        conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "a")
                        conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "as")
                        conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "a")
                        conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "amos")
                        conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "áis")
                        conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "an")
                    }
                } else if (isEndingIr) {
                    
                    // change ending to something else
                    if let range = infinitive.range(of: "ir", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    conjugationYo = infinitive.replacingOccurrences(of: "bby", with: "a")
                    conjugationTu = infinitive.replacingOccurrences(of: "bby", with: "as")
                    conjugationEl = infinitive.replacingOccurrences(of: "bby", with: "a")
                    conjugationNos = infinitive.replacingOccurrences(of: "bby", with: "amos")
                    conjugationVos = infinitive.replacingOccurrences(of: "bby", with: "áis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "bby", with: "an")
                }
            } else if (mainViewController!.currentTense == "Imperfect Subjunctive Tense") {
                if (isEndingAr) {
                    // change ending to something else
                    if let range = infinitive.range(of: "ar", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    // first conjugates to preterite tense of ellos/ellas/ustedes form
                    infinitive = infinitive.replacingOccurrences(of: "bby", with: "aron")
                    
                    // then change to imperfect subjunctive endings
                    conjugationYo = infinitive.replacingOccurrences(of: "ron", with: "ra")
                    conjugationTu = infinitive.replacingOccurrences(of: "ron", with: "ras")
                    conjugationEl = infinitive.replacingOccurrences(of: "ron", with: "ra")
                    conjugationNos = infinitive.replacingOccurrences(of: "aron", with: "áramos")
                    conjugationVos = infinitive.replacingOccurrences(of: "ron", with: "rais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "ron", with: "ran")
                    
                } else if (isEndingEr) {
                    // change ending to something else
                    if let range = infinitive.range(of: "er", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    // first conjugates to preterite tense of ellos/ellas/ustedes form
                    infinitive = infinitive.replacingOccurrences(of: "bby", with: "ieron")
                    
                    // then change to imperfect subjunctive endings
                    conjugationYo = infinitive.replacingOccurrences(of: "ron", with: "ra")
                    conjugationTu = infinitive.replacingOccurrences(of: "ron", with: "ras")
                    conjugationEl = infinitive.replacingOccurrences(of: "ron", with: "ra")
                    conjugationNos = infinitive.replacingOccurrences(of: "eron", with: "éramos")
                    conjugationVos = infinitive.replacingOccurrences(of: "ron", with: "rais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "ron", with: "ran")
                } else if (isEndingIr) {
                    // change ending to something else
                    if let range = infinitive.range(of: "ir", options: NSString.CompareOptions.backwards) {
                        infinitive.replaceSubrange(range, with: "bby")
                    }
                    
                    infinitive = infinitive.replacingOccurrences(of: "bby", with: "ieron")
                    
                    // then change to imperfect subjunctive endings
                    conjugationYo = infinitive.replacingOccurrences(of: "ron", with: "ra")
                    conjugationTu = infinitive.replacingOccurrences(of: "ron", with: "ras")
                    conjugationEl = infinitive.replacingOccurrences(of: "ron", with: "ra")
                    conjugationNos = infinitive.replacingOccurrences(of: "eron", with: "éramos")
                    conjugationVos = infinitive.replacingOccurrences(of: "ron", with: "rais")
                    conjugationEllos = infinitive.replacingOccurrences(of: "ron", with: "ran")
                }
            } else if (mainViewController!.currentTense == "Conditional Tense") {
                conjugationYo = infinitive + "ía"
                conjugationTu = infinitive + "ías"
                conjugationEl = infinitive + "ía"
                conjugationNos = infinitive + "íamos"
                conjugationVos = infinitive + "íais"
                conjugationEllos = infinitive + "ían"
            }
        }
        
        // reloads conjugation data in table
        setText()
    }

    func conjugateIrregularYoVerb() {
        if (infinitive == "hacer") {
            conjugationYo = "hago"
        } else if (infinitive == "oír") {
            conjugationYo = "oigo"
        } else if (infinitive == "traer") {
            conjugationYo = "traigo"
        } else if (infinitive == "caer") {
            conjugationYo = "caigo"
        } else if (infinitive == "decir") {
            conjugationYo = "digo"
        } else if (infinitive == "conducir") {
            conjugationYo = "conduzco"
        } else if (infinitive == "conocer") {
            conjugationYo = "conozco"
        } else if (isEndingEr) {
            conjugationYo = infinitive.replacingOccurrences(of: "er", with: "go")
        } else if (isEndingIr) {
            conjugationYo = infinitive.replacingOccurrences(of: "ir", with: "go")
        }
    }

    
    // PRESENT TENSE CONJUGATOR
    func doPresentTense() {
        
        if (!hasStemChange) {
            if (isEndingAr) {
                conjugationYo = infinitive.replacingOccurrences(of: "ar", with: "o")
                conjugationTu = infinitive.replacingOccurrences(of: "ar", with: "as")
                conjugationEl = infinitive.replacingOccurrences(of: "ar", with: "a")
                conjugationNos = infinitive.replacingOccurrences(of: "ar", with: "amos")
                conjugationVos = infinitive.replacingOccurrences(of: "ar", with: "áis")
                conjugationEllos = infinitive.replacingOccurrences(of: "ar", with: "an")
            } else if (isEndingEr) {
                conjugationYo = infinitive.replacingOccurrences(of: "er", with: "o")
                conjugationTu = infinitive.replacingOccurrences(of: "er", with: "es")
                conjugationEl = infinitive.replacingOccurrences(of: "er", with: "e")
                conjugationNos = infinitive.replacingOccurrences(of: "er", with: "emos")
                conjugationVos = infinitive.replacingOccurrences(of: "er", with: "éis")
                conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "en")
            } else if (isEndingIr) {
                conjugationYo = infinitive.replacingOccurrences(of: "ir", with: "o")
                conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "es")
                conjugationEl = infinitive.replacingOccurrences(of: "ir", with: "e")
                conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "imos")
                conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "ís")
                conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "en")
            }
        } else {
            // stem change conjugations
            if (isEndingAr) {
                conjugationYo = stemChangedVerb.replacingOccurrences(of: "ar", with: "o")
                conjugationTu = stemChangedVerb.replacingOccurrences(of: "ar", with: "as")
                conjugationEl = stemChangedVerb.replacingOccurrences(of: "ar", with: "a")
                conjugationNos = infinitive.replacingOccurrences(of: "ar", with: "amos") // stem doesn't change
                conjugationVos = infinitive.replacingOccurrences(of: "ar", with: "áis") // stem doesn't change
                conjugationEllos = stemChangedVerb.replacingOccurrences(of: "ar", with: "an")
            } else if (isEndingEr) {
                // spelling change for yo conjugations
                if (infinitive.hasSuffix("cer")) {
                    conjugationYo = stemChangedVerb.replacingOccurrences(of: "cer", with: "zco")
                } else if (infinitive.hasSuffix("ger")) {
                    conjugationYo = stemChangedVerb.replacingOccurrences(of: "ger", with: "jo")
                } else {
                    conjugationYo = stemChangedVerb.replacingOccurrences(of: "er", with: "o")
                }

                conjugationTu = stemChangedVerb.replacingOccurrences(of: "er", with: "es")
                conjugationEl = stemChangedVerb.replacingOccurrences(of: "er", with: "e")
                conjugationNos = infinitive.replacingOccurrences(of: "er", with: "emos") // stem doesn't change
                conjugationVos = infinitive.replacingOccurrences(of: "er", with: "éis") // stem doesn't change
                conjugationEllos = stemChangedVerb.replacingOccurrences(of: "er", with: "en")
            } else if (isEndingIr) {
                // spelling change for yo conjugations
                if (infinitive.hasSuffix("cir") && !infinitive.hasSuffix("decir")) {
                    conjugationYo = stemChangedVerb.replacingOccurrences(of: "cir", with: "zco")
                } else if (infinitive.hasSuffix("decir")) {
                    conjugationYo = stemChangedVerb.replacingOccurrences(of: "decir", with: "digo")
                } else if (infinitive.hasSuffix("gir")) {
                    conjugationYo = stemChangedVerb.replacingOccurrences(of: "gir", with: "jo")
                } else if (infinitive.hasSuffix("uir") && !infinitive.hasSuffix("guir")) {
                    conjugationYo = stemChangedVerb.replacingOccurrences(of: "ir", with: "yo")
                } else if (infinitive.hasSuffix("guir")) {
                    conjugationYo = stemChangedVerb.replacingOccurrences(of: "guir", with: "go")
                } else {
                    conjugationYo = stemChangedVerb.replacingOccurrences(of: "ir", with: "o")
                }

                if (infinitive.hasSuffix("uir") && !infinitive.hasSuffix("guir")) {
                    conjugationTu = stemChangedVerb.replacingOccurrences(of: "ir", with: "yes")
                    conjugationEl = stemChangedVerb.replacingOccurrences(of: "ir", with:"ye")
                    conjugationNos = infinitive.replacingOccurrences(of: "ir", with:"imos") // stem doesn't change
                    conjugationVos = infinitive.replacingOccurrences(of: "ir", with:"ís") // stem doesn't change
                    conjugationEllos = stemChangedVerb.replacingOccurrences(of: "ir", with: "yen")
                } else {
                    conjugationTu = stemChangedVerb.replacingOccurrences(of: "ir", with: "es")
                    conjugationEl = stemChangedVerb.replacingOccurrences(of: "ir", with: "e")
                    conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "imos") // stem doesn't change
                    conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "ís") // stem doesn't change
                    conjugationEllos = stemChangedVerb.replacingOccurrences(of: "ir", with: "en")
                }
            }
        }
    }
    
    // PRETERITE TENSE CONJUGATOR
    func doPreteriteTense() {
        
        if (isEndingAr) {
        // Spelling change of car/gar/zar verbs to maintain pronunciation
        if (hasSpellingChange) {
            if (infinitive.hasSuffix("car")) {
                conjugationYo = infinitive.replacingOccurrences(of: "car", with: "qué")
            } else if (infinitive.hasSuffix("gar")) {
                conjugationYo = infinitive.replacingOccurrences(of: "gar", with: "gué")
            } else if (infinitive.hasSuffix("zar")) {
                conjugationYo = infinitive.replacingOccurrences(of: "zar", with: "cé")
            }
        } else { conjugationYo = infinitive.replacingOccurrences(of: "ar", with: "é") }
    
            conjugationTu = infinitive.replacingOccurrences(of: "ar", with: "aste")
            conjugationEl = infinitive.replacingOccurrences(of: "ar", with: "ó")
            conjugationNos = infinitive.replacingOccurrences(of: "ar", with: "amos")
            conjugationVos = infinitive.replacingOccurrences(of: "ar", with: "asteis")
            conjugationEllos = infinitive.replacingOccurrences(of: "ar", with: "aron")
        } else if (isEndingEr) {
            if (!infinitive.hasSuffix("raer") && !infinitive.hasSuffix("hacer")) {
                conjugationYo = infinitive.replacingOccurrences(of: "er", with: "í")
                conjugationTu = infinitive.replacingOccurrences(of: "er", with: "iste")
                conjugationEl = infinitive.replacingOccurrences(of: "er", with: "ió")
                conjugationNos = infinitive.replacingOccurrences(of: "er", with: "imos")
                conjugationVos = infinitive.replacingOccurrences(of: "er", with: "isteis")
                conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "ieron")
                
                if (isIrregularInPreterite) {
                    conjugationTu = infinitive.replacingOccurrences(of: "er", with: "íste")
                    conjugationEl = infinitive.replacingOccurrences(of: "er", with: "yó")
                    conjugationNos = infinitive.replacingOccurrences(of: "er", with: "ímos")
                    conjugationVos = infinitive.replacingOccurrences(of: "er", with: "ísteis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "yeron")
                }
            } else if (infinitive.hasSuffix("raer")) {
                conjugationYo = infinitive.replacingOccurrences(of: "er", with: "je")
                conjugationTu = infinitive.replacingOccurrences(of: "er", with: "jiste")
                conjugationEl = infinitive.replacingOccurrences(of: "er", with: "jo")
                conjugationNos = infinitive.replacingOccurrences(of: "er", with: "imos")
                conjugationVos = infinitive.replacingOccurrences(of: "er", with: "jisteis")
                conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "jeron")
            } else if (infinitive.hasSuffix("hacer")) {
                conjugationYo = infinitive.replacingOccurrences(of: "hacer", with: "hice")
                conjugationTu = infinitive.replacingOccurrences(of: "hacer", with: "hiciste")
                conjugationEl = infinitive.replacingOccurrences(of: "hacer", with: "hizo")
                conjugationNos = infinitive.replacingOccurrences(of: "hacer", with: "hicimos")
                conjugationVos = infinitive.replacingOccurrences(of: "hacer", with: "hicisteis")
                conjugationEllos = infinitive.replacingOccurrences(of: "hacer", with: "hicieron")
            } else if (infinitive.hasSuffix("tener")) {
                conjugationYo = infinitive.replacingOccurrences(of: "hacer", with: "hice")
                conjugationTu = infinitive.replacingOccurrences(of: "hacer", with: "hiciste")
                conjugationEl = infinitive.replacingOccurrences(of: "hacer", with: "hizo")
                conjugationNos = infinitive.replacingOccurrences(of: "hacer", with: "hicimos")
                conjugationVos = infinitive.replacingOccurrences(of: "hacer", with: "hicisteis")
                conjugationEllos = infinitive.replacingOccurrences(of: "hacer", with: "hicieron")
            }
        } else if (isEndingIr) {
            
            if (!infinitive.hasSuffix("ucir")) {
                conjugationYo = infinitive.replacingOccurrences(of: "ir", with: "í")
                conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "iste")
                
                // conjugationEl stem-changing code
                if (hasStemChange) {
                    if (E2I) {
                        if (nextIndexI) {
                            if (infinitive == "perseguir") {
                                
                            } else {
                                
                            }
                        } else {
                            
                        }
                    } else if (O2UE) {
                        
                    } else if (IEStemChange) {
                        
                    } else if (infinitive == "divertir") {
                        conjugationEl = "divirtió"
                    } else if (infinitive == "preferir") {
                        conjugationEl = "prefirió"
                    } else if (infinitive == "sugerir") {
                        conjugationEl = "sugirió"
                    } else {
                        
                    }
                } else if (!hasStemChange) {
                    conjugationEl = infinitive.replacingOccurrences(of: "ir", with: "ió")
                }
                
                conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "imos")
                conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "isteis")
                
                // conjugationEllos stem-changing code
                if (hasStemChange) {
                    if (E2I) {
                        if (nextIndexI) {
                            if (infinitive == "perseguir") {
                                
                            } else {
                                
                            }
                        } else {
                            
                        }
                    } else if (O2UE) {
                        
                    } else if (IEStemChange) {
                        
                    } else if (infinitive == "divertir") {
                        conjugationEllos = "divirtieron"
                    } else if (infinitive == "preferir") {
                        conjugationEllos = "prefirieron"
                    } else if (infinitive == "sugerir") {
                        conjugationEllos = "sugirieron"
                    } else {
                        
                    }
                } else if (!hasStemChange) {
                    conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "ieron")
                }
                
                if (isIrregularInPreterite) {
                    conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "íste")
                    conjugationEl = infinitive.replacingOccurrences(of: "ir",with: "yó")
                    conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "ímos")
                    conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "ísteis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "yeron")
                }
            
            } else if (infinitive.hasSuffix("ucir")) {
                conjugationYo = infinitive.replacingOccurrences(of: "cir", with: "je")
                conjugationTu = infinitive.replacingOccurrences(of: "cir", with: "jiste")
                conjugationEl = infinitive.replacingOccurrences(of: "cir", with: "jo")
                conjugationNos = infinitive.replacingOccurrences(of: "cir", with: "imos")
                conjugationVos = infinitive.replacingOccurrences(of: "cir", with: "jisteis")
                conjugationEllos = infinitive.replacingOccurrences(of: "cir", with: "jeron")
            }
        }
    }
    
    // IMPERFECT TENSE CONJUGATOR
    func doImperfectTense() {
        if (isEndingAr) {
            conjugationYo = infinitive.replacingOccurrences(of: "ar", with: "aba")
            conjugationTu = infinitive.replacingOccurrences(of: "ar", with: "abas")
            conjugationEl = infinitive.replacingOccurrences(of: "ar", with: "aba")
            conjugationNos = infinitive.replacingOccurrences(of: "ar", with: "ábamos")
            conjugationVos = infinitive.replacingOccurrences(of: "ar", with: "abais")
            conjugationEllos = infinitive.replacingOccurrences(of: "ar", with: "aban")
        } else if (isEndingEr) {
            conjugationYo = infinitive.replacingOccurrences(of: "er", with: "ía")
            conjugationTu = infinitive.replacingOccurrences(of: "er", with: "ías")
            conjugationEl = infinitive.replacingOccurrences(of: "er", with: "ía")
            conjugationNos = infinitive.replacingOccurrences(of: "er", with: "íamos")
            conjugationVos = infinitive.replacingOccurrences(of: "er", with: "íais")
            conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "ían")
        } else if (isEndingIr) {
            conjugationYo = infinitive.replacingOccurrences(of: "ir", with: "ía")
            conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "ías")
            conjugationEl = infinitive.replacingOccurrences(of: "ir", with: "ía")
            conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "íamos")
            conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "íais")
            conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "ían")
        }
    }
    
    // FUTURE TENSE CONJUGATOR
    func doFutureTense() {
        if (infinitive == "valer") {
            conjugationYo = "valdré"
            conjugationTu = "valdrás"
            conjugationEl = "valdrá"
            conjugationNos = "valdremos"
            conjugationVos = "valdréis"
            conjugationEllos = "valdrán"
        } else if (infinitive == "caber") {
            conjugationYo = "cabré"
            conjugationTu = "cabrás"
            conjugationEl = "cabrá"
            conjugationNos = "cabremos"
            conjugationVos = "cabréis"
            conjugationEllos = "cabrán"
        } else if (infinitive == "deshacer") {
            conjugationYo = "desharé"
            conjugationTu = "desharás"
            conjugationEl = "deshará"
            conjugationNos = "desharemos"
            conjugationVos = "desharéis"
            conjugationEllos = "desharán"
        } else if (infinitive == "suponer") {
            conjugationYo = "supondré"
            conjugationTu = "supondrás"
            conjugationEl = "supondrá"
            conjugationNos = "supondremos"
            conjugationVos = "supondrés"
            conjugationEllos = "supondrán"
        } else if (infinitive.hasSuffix("tener")) {
            conjugationYo = infinitive.replacingOccurrences(of: "tener", with: "tendré")
            conjugationTu = infinitive.replacingOccurrences(of: "tener", with: "tendrás")
            conjugationEl = infinitive.replacingOccurrences(of: "tener", with: "tendrá")
            conjugationNos = infinitive.replacingOccurrences(of: "tener", with: "tendremos")
            conjugationVos = infinitive.replacingOccurrences(of: "tener", with: "tendréis")
            conjugationEllos = infinitive.replacingOccurrences(of: "tener", with: "tendrán")
        } else {
            conjugationYo = infinitive + "é"
            conjugationTu = infinitive + "ás"
            conjugationEl = infinitive + "á"
            conjugationNos = infinitive + "emos"
            conjugationVos = infinitive + "éis"
            conjugationEllos = infinitive + "án"
        }
    }
    
    // AFFIRMATIVE COMMAND CONJUGATOR
    func doAffirmativeCommand() {
        // Spelling change for pronunciation
        if (infinitive.hasSuffix("ger")) { hasSpellingChange = true }
        if (infinitive.hasSuffix("guir")) { hasSpellingChange = true }
        
        if (isEndingAr) {
            if (hasStemChange) {
                conjugationTu = stemChangedVerb.replacingOccurrences(of: "ar", with: "a")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = stemChangedVerb.replacingOccurrences(of: "ar", with: "e")
                conjugationNos = infinitive.replacingOccurrences(of: "ar", with: "emos")
                conjugationEllos = stemChangedVerb.replacingOccurrences(of: "ar", with: "en")
            } else {
                conjugationTu = infinitive.replacingOccurrences(of: "ar", with: "a")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = infinitive.replacingOccurrences(of: "ar", with: "e")
                conjugationNos = infinitive.replacingOccurrences(of: "ar", with: "emos")
                conjugationEllos = infinitive.replacingOccurrences(of: "ar", with: "en")
            }
        } else if (isEndingEr) {
            if (hasStemChange) {
                conjugationTu = stemChangedVerb.replacingOccurrences(of: "er", with: "e")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = stemChangedVerb.replacingOccurrences(of: "er", with: "a")
                conjugationNos = infinitive.replacingOccurrences(of: "er", with: "amos")
                conjugationEllos = stemChangedVerb.replacingOccurrences(of: "o", with: "an")
            } else {
                if (infinitive.hasSuffix("cer")) {
                    if (infinitive.hasSuffix("hacer")) {
                        conjugationTu = infinitive.replacingOccurrences(of: "hacer", with: "haz")
                        conjugationEl = infinitive.replacingOccurrences(of: "cer", with: "ga")
                        conjugationNos = infinitive.replacingOccurrences(of: "cer", with: "gamos")
                        conjugationEllos = infinitive.replacingOccurrences(of: "cer", with: "gan")
                    } else {
                        conjugationTu = infinitive.replacingOccurrences(of: "cer", with: "ce")
                        conjugationEl = infinitive.replacingOccurrences(of: "cer", with: "zca")
                        conjugationNos = infinitive.replacingOccurrences(of: "cer", with: "zcamos")
                        conjugationEllos = infinitive.replacingOccurrences(of: "cer", with: "zcan")
                    }
                } else if (infinitive.hasSuffix("suponer")) {
                    conjugationTu = infinitive.replacingOccurrences(of: "suponer", with: "suponga")
                    conjugationEl = infinitive.replacingOccurrences(of: "er", with: "ga")
                    conjugationNos = infinitive.replacingOccurrences(of: "er", with: "gamos")
                    conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "gan")
                } else if (infinitive.hasSuffix("detener")) {
                    conjugationTu = infinitive.replacingOccurrences(of: "detener", with: "detén")
                    conjugationEl = infinitive.replacingOccurrences(of: "er", with: "ga")
                    conjugationNos = infinitive.replacingOccurrences(of: "er", with: "gamos")
                    conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "gan")
                } else if (infinitive.hasSuffix("aer")) {
                    conjugationTu = infinitive.replacingOccurrences(of: "er", with: "e")
                    conjugationEl = infinitive.replacingOccurrences(of: "er", with: "iga")
                    conjugationNos = infinitive.replacingOccurrences(of: "er", with: "igamos")
                    conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "igan")
                } else if (infinitive.hasSuffix("caber")) {
                    conjugationTu = infinitive.replacingOccurrences(of: "caber", with: "cabe")
                    conjugationEl = infinitive.replacingOccurrences(of: "caber", with: "quepa")
                    conjugationNos = infinitive.replacingOccurrences(of: "caber", with: "quepamos")
                    conjugationEllos = infinitive.replacingOccurrences(of: "caber", with: "quepan")
                } else if (infinitive.hasSuffix("valer")) {
                    conjugationTu = infinitive.replacingOccurrences(of: "valer", with: "vale")
                    conjugationEl = infinitive.replacingOccurrences(of: "valer", with: "valga")
                    conjugationNos = infinitive.replacingOccurrences(of: "valer", with: "valgamos")
                    conjugationEllos = infinitive.replacingOccurrences(of: "valer", with: "valgan")
                } else {
                    conjugationTu = infinitive.replacingOccurrences(of: "er", with: "e")
                    if (hasSpellingChange) { spellingChange() }
                    conjugationEl = infinitive.replacingOccurrences(of: "er", with: "a")
                    conjugationNos = infinitive.replacingOccurrences(of: "er", with: "amos")
                    conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "an")
                }
            }
        } else if (isEndingIr) {
            if (hasStemChange) {
                conjugationTu = stemChangedVerb.replacingOccurrences(of: "ir", with: "e")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = stemChangedVerb.replacingOccurrences(of: "ir", with: "a")
                conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "amos")
                conjugationEllos = stemChangedVerb.replacingOccurrences(of: "ir", with: "an")
            } else {
                conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "e")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = infinitive.replacingOccurrences(of: "ir", with: "a")
                conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "amos")
                conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "an")
            }
        }
        
        // No commands for these two forms
        conjugationYo = " "
        conjugationVos = " "
    }
    
    // NEGATIVE COMMAND TENSE CONJUGATOR
    func doNegativeCommand() {
        // Spelling change for pronunciation
        if (infinitive.hasSuffix("ger")) { hasSpellingChange = true }
        if (infinitive.hasSuffix("guir")) { hasSpellingChange = true }
        
        // Tú commands are just present tense el/ella/usted
        if (isEndingAr) {
            if (hasStemChange) {
                conjugationTu = "no " + stemChangedVerb.replacingOccurrences(of: "ar", with: "es")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = "no " + stemChangedVerb.replacingOccurrences(of: "ar", with: "e")
                conjugationNos = "no " + infinitive.replacingOccurrences(of: "ar", with: "emos")
                conjugationEllos = "no " + stemChangedVerb.replacingOccurrences(of: "ar", with: "en")
            } else {
                conjugationTu = "no " + infinitive.replacingOccurrences(of: "ar", with: "es")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = "no " + infinitive.replacingOccurrences(of: "ar", with: "e")
                conjugationNos = "no " + infinitive.replacingOccurrences(of: "ar", with: "emos")
                conjugationEllos = "no " + infinitive.replacingOccurrences(of: "ar", with: "en")
            }
        } else if (isEndingEr) {
            if (hasStemChange) {
                conjugationTu = "no " + stemChangedVerb.replacingOccurrences(of: "er", with: "as")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = "no " + stemChangedVerb.replacingOccurrences(of: "er", with: "a")
                conjugationNos = "no " + infinitive.replacingOccurrences(of: "er", with: "amos")
                conjugationEllos = "no " + stemChangedVerb.replacingOccurrences(of: "er", with: "an")
            } else {
                if (infinitive.hasSuffix("cer")) {
                    if (infinitive.hasSuffix("hacer")) {
                        conjugationTu = "no " + infinitive.replacingOccurrences(of: "hacer", with: "gas")
                        conjugationEl = "no " + infinitive.replacingOccurrences(of: "cer", with: "ga")
                        conjugationNos = "no " + infinitive.replacingOccurrences(of: "cer", with: "gamos")
                        conjugationEllos = "no " + infinitive.replacingOccurrences(of: "cer", with: "gan")
                    } else {
                        conjugationTu = "no " + infinitive.replacingOccurrences(of: "cer", with: "zcas")
                        conjugationEl = "no " + infinitive.replacingOccurrences(of: "cer", with: "zca")
                        conjugationNos = "no " + infinitive.replacingOccurrences(of: "cer", with: "zcamos")
                        conjugationEllos = "no " + infinitive.replacingOccurrences(of: "cer", with: "zcan")
                    }
                } else if (infinitive.hasSuffix("suponer")) {
                    conjugationTu = "no " + infinitive.replacingOccurrences(of: "suponer", with: "suponga")
                    conjugationEl = "no " + infinitive.replacingOccurrences(of: "er", with: "ga")
                    conjugationNos = "no " + infinitive.replacingOccurrences(of: "er", with: "gamos")
                    conjugationEllos = "no " + infinitive.replacingOccurrences(of: "er", with: "gan")
                } else if (infinitive.hasSuffix("detener")) {
                    conjugationTu = "no " + infinitive.replacingOccurrences(of: "detener", with: "detengas")
                    conjugationEl = "no " + infinitive.replacingOccurrences(of: "er", with: "ga")
                    conjugationNos = "no " + infinitive.replacingOccurrences(of: "er", with: "gamos")
                    conjugationEllos = "no " + infinitive.replacingOccurrences(of: "er", with: "gan")
                } else if (infinitive.hasSuffix("aer")) {
                    conjugationTu = "no " + infinitive.replacingOccurrences(of: "er", with: "igas")
                    conjugationEl = "no " + infinitive.replacingOccurrences(of: "er", with: "iga")
                    conjugationNos = "no " + infinitive.replacingOccurrences(of: "er", with: "igamos")
                    conjugationEllos = "no " + infinitive.replacingOccurrences(of: "er", with: "igan")
                } else if (infinitive.hasSuffix("caber")) {
                    conjugationTu = "no " + infinitive.replacingOccurrences(of: "caber", with: "quepas")
                    conjugationEl = "no " + infinitive.replacingOccurrences(of: "caber", with: "quepa")
                    conjugationNos = "no " + infinitive.replacingOccurrences(of: "caber", with: "quepamos")
                    conjugationEllos = "no " + infinitive.replacingOccurrences(of: "caber", with: "quepan")
                } else if (infinitive.hasSuffix("valer")) {
                    conjugationTu = "no " + infinitive.replacingOccurrences(of: "valer", with: "valgas")
                    conjugationEl = "no " + infinitive.replacingOccurrences(of: "valer", with: "valga")
                    conjugationNos = "no " + infinitive.replacingOccurrences(of: "valer", with: "valgamos")
                    conjugationEllos = "no " + infinitive.replacingOccurrences(of: "valer", with: "valgan")
                } else {
                    conjugationTu = "no " + infinitive.replacingOccurrences(of: "er", with: "as")
                    if (hasSpellingChange) { spellingChange() }
                    conjugationEl = "no " + infinitive.replacingOccurrences(of: "er", with: "a")
                    conjugationNos = "no " + infinitive.replacingOccurrences(of: "er", with: "amos")
                    conjugationEllos = "no " + infinitive.replacingOccurrences(of: "er", with: "an")
                }
            }
        } else if (isEndingIr) {
            if (hasStemChange) {
                conjugationTu = "no " + stemChangedVerb.replacingOccurrences(of: "ir", with: "as")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = "no " + stemChangedVerb.replacingOccurrences(of: "ir", with: "a")
                conjugationNos = "no " + infinitive.replacingOccurrences(of: "ir", with: "amos")
                conjugationEllos = "no " + stemChangedVerb.replacingOccurrences(of: "ir", with: "an")
            } else {
                conjugationTu = "no " + infinitive.replacingOccurrences(of: "ir", with: "as")
                if (hasSpellingChange) { spellingChange() }
                conjugationEl = "no " + infinitive.replacingOccurrences(of: "ir", with: "a")
                conjugationNos = "no " + infinitive.replacingOccurrences(of: "ir", with: "amos")
                conjugationEllos = "no " + infinitive.replacingOccurrences(of: "ir", with: "an")
            }
        }
        
        // No commands for these two forms
        conjugationYo = " "
        conjugationVos = " "
    }
    
    // PRESENT SUBJUNCTIVE TENSE CONJUGATOR
    func doPresentSubjunctiveTense() {
        
        if (infinitive.hasSuffix("ger")) { hasSpellingChange = true }
        if (infinitive.hasSuffix("gir")) { hasSpellingChange = true }
        if (infinitive.hasSuffix("guir")) { hasSpellingChange = true }
        if (hasSpellingChange) { spellingChange() }
        if (hasStemChange) { doStemChange() }
        
        if (isEndingAr) {
            
            if (hasStemChange) {
                conjugationYo = stemChangedVerb.replacingOccurrences(of: "ar", with: "e")
                conjugationTu = stemChangedVerb.replacingOccurrences(of: "ar", with: "es")
                conjugationEl = stemChangedVerb.replacingOccurrences(of: "ar", with: "e")
                conjugationNos = infinitive.replacingOccurrences(of: "ar", with: "emos")
                conjugationVos = infinitive.replacingOccurrences(of: "ar", with: "éis")
                conjugationEllos = stemChangedVerb.replacingOccurrences(of: "ar", with: "en")
            } else {
                conjugationYo = infinitive.replacingOccurrences(of: "ar", with: "e")
                conjugationTu = infinitive.replacingOccurrences(of: "ar", with: "es")
                conjugationEl = infinitive.replacingOccurrences(of: "ar", with: "e")
                conjugationNos = infinitive.replacingOccurrences(of: "ar", with: "emos")
                conjugationVos = infinitive.replacingOccurrences(of: "ar", with: "éis")
                conjugationEllos = infinitive.replacingOccurrences(of: "ar", with: "en")
            }
        } else if (isEndingEr) {
            
            if (hasStemChange) {
                conjugationYo = stemChangedVerb.replacingOccurrences(of: "er", with: "a")
                conjugationTu = stemChangedVerb.replacingOccurrences(of: "er", with: "as")
                conjugationEl = stemChangedVerb.replacingOccurrences(of: "er", with: "a")
                conjugationNos = infinitive.replacingOccurrences(of: "er", with: "amos")
                conjugationVos = infinitive.replacingOccurrences(of: "er", with: "áis")
                conjugationEllos = stemChangedVerb.replacingOccurrences(of: "er", with: "an")
            } else {
                if (infinitive.hasSuffix("cer")) {
                    if (infinitive.hasSuffix("hacer")) {
                        conjugationYo = infinitive.replacingOccurrences(of: "cer", with: "ga")
                        conjugationTu = infinitive.replacingOccurrences(of: "cer", with: "gas")
                        conjugationEl = infinitive.replacingOccurrences(of: "cer", with: "ga")
                        conjugationNos = infinitive.replacingOccurrences(of: "cer", with: "gamos")
                        conjugationVos = infinitive.replacingOccurrences(of: "cer", with: "gáis")
                        conjugationEllos = infinitive.replacingOccurrences(of: "cer", with: "gan")
                    } else {
                        conjugationYo = infinitive.replacingOccurrences(of: "cer", with: "zca")
                        conjugationTu = infinitive.replacingOccurrences(of: "cer", with: "zcas")
                        conjugationEl = infinitive.replacingOccurrences(of: "cer", with: "zca")
                        conjugationNos = infinitive.replacingOccurrences(of: "cer", with: "zcamos")
                        conjugationVos = infinitive.replacingOccurrences(of: "cer", with: "zcáis")
                        conjugationEllos = infinitive.replacingOccurrences(of: "cer", with: "zcan")
                    }
                } else if (infinitive.hasSuffix("tener")) {
                    conjugationYo = infinitive.replacingOccurrences(of: "er", with: "ga")
                    conjugationTu = infinitive.replacingOccurrences(of: "er", with: "gas")
                    conjugationEl = infinitive.replacingOccurrences(of: "er", with: "ga")
                    conjugationNos = infinitive.replacingOccurrences(of: "er", with: "gamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "er", with: "gáis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "gan")
                } else if (infinitive.hasSuffix("suponer")) {
                    conjugationYo = infinitive.replacingOccurrences(of: "er", with: "ga")
                    conjugationTu = infinitive.replacingOccurrences(of: "er", with: "gas")
                    conjugationEl = infinitive.replacingOccurrences(of: "er", with: "ga")
                    conjugationNos = infinitive.replacingOccurrences(of: "er", with: "gamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "er", with: "gáis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "gan")
                } else if (infinitive.hasSuffix("aer")) {
                    conjugationYo = infinitive.replacingOccurrences(of: "er", with: "iga")
                    conjugationTu = infinitive.replacingOccurrences(of: "er", with: "igas")
                    conjugationEl = infinitive.replacingOccurrences(of: "er", with: "iga")
                    conjugationNos = infinitive.replacingOccurrences(of: "er", with: "igamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "er", with: "igáis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "igan")
                } else if (infinitive.hasSuffix("caber")) {
                    conjugationYo = infinitive.replacingOccurrences(of: "caber", with: "quepa")
                    conjugationTu = infinitive.replacingOccurrences(of: "caber", with: "quepas")
                    conjugationEl = infinitive.replacingOccurrences(of: "caber", with: "quepa")
                    conjugationNos = infinitive.replacingOccurrences(of: "caber", with: "quepamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "caber", with: "quepáis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "caber", with: "quepan")
                } else if (infinitive.hasSuffix("valer")) {
                    conjugationYo = infinitive.replacingOccurrences(of: "valer", with: "valga")
                    conjugationTu = infinitive.replacingOccurrences(of: "valer", with: "valgas")
                    conjugationEl = infinitive.replacingOccurrences(of: "valer", with: "valga")
                    conjugationNos = infinitive.replacingOccurrences(of: "valer", with: "valgamos")
                    conjugationVos = infinitive.replacingOccurrences(of: "valer", with: "valgáis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "valer", with: "valgan")
                } else {
                    conjugationYo = infinitive.replacingOccurrences(of: "er", with: "a")
                    conjugationTu = infinitive.replacingOccurrences(of: "er", with: "as")
                    conjugationEl = infinitive.replacingOccurrences(of: "er", with: "a")
                    conjugationNos = infinitive.replacingOccurrences(of: "er", with: "amos")
                    conjugationVos = infinitive.replacingOccurrences(of: "er", with: "áis")
                    conjugationEllos = infinitive.replacingOccurrences(of: "er", with: "an")
                }
            }
        } else if (isEndingIr) {
            
            if (hasStemChange) {
                conjugationYo = stemChangedVerb.replacingOccurrences(of: "ir", with: "a")
                conjugationTu = stemChangedVerb.replacingOccurrences(of: "ir", with: "as")
                conjugationEl = stemChangedVerb.replacingOccurrences(of: "ir", with: "a")
                if (infinitive == "dormir") {
                    conjugationNos = "durmamos"
                    conjugationVos = "durmáis"
                } else if (infinitive == "sentir") {
                    conjugationNos = "sintamos"
                    conjugationVos = "sintáis"
                } else if (E2I) {
                    conjugationNos = stemChangedVerb.replacingOccurrences(of: "ir", with: "amos")
                    conjugationVos = stemChangedVerb.replacingOccurrences(of: "ir", with: "áis")
                } else {
                    conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "amos")
                    conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "áis")
                }
                conjugationEllos = stemChangedVerb.replacingOccurrences(of: "ir", with: "an")
            } else {
                conjugationYo = infinitive.replacingOccurrences(of: "ir", with: "a")
                conjugationTu = infinitive.replacingOccurrences(of: "ir", with: "as")
                conjugationEl = infinitive.replacingOccurrences(of: "ir", with: "a")
                conjugationNos = infinitive.replacingOccurrences(of: "ir", with: "amos")
                conjugationVos = infinitive.replacingOccurrences(of: "ir", with: "áis")
                conjugationEllos = infinitive.replacingOccurrences(of: "ir", with: "an")
            }
        }
    }
    
    // IMPERFECT SUBJUNCTIVE TENSE CONJUGATOR
    func doImperfectSubjunctiveTense() {
        if (isEndingAr) {
            // first conjugates to preterite tense of ellos/ellas/ustedes form
            infinitive = infinitive.replacingOccurrences(of: "ar", with: "aron")
            
            // then change to imperfect subjunctive endings
            conjugationYo = infinitive.replacingOccurrences(of: "ron", with: "ra")
            conjugationTu = infinitive.replacingOccurrences(of: "ron", with: "ras")
            conjugationEl = infinitive.replacingOccurrences(of: "ron", with: "ra")
            conjugationNos = infinitive.replacingOccurrences(of: "aron", with: "áramos")
            conjugationVos = infinitive.replacingOccurrences(of: "ron", with: "rais")
            conjugationEllos = infinitive.replacingOccurrences(of: "ron", with: "ran")
        } else if (isEndingEr) {
            // first conjugates to preterite tense of ellos/ellas/ustedes form
            if (infinitive.hasSuffix("eer")) {
                infinitive = infinitive.replacingOccurrences(of: "er", with: "yeron")
            } else if (infinitive.hasSuffix("aer")) {
                infinitive = infinitive.replacingOccurrences(of: "er", with: "jeron")
            } else if (infinitive.hasSuffix("hacer")) {
                infinitive = infinitive.replacingOccurrences(of: "hacer", with: "hicieron")
            } else if (infinitive.hasSuffix("tener")) {
                infinitive = infinitive.replacingOccurrences(of: "tener", with: "tuvieron")
            } else {
                infinitive = infinitive.replacingOccurrences(of: "er", with: "ieron")
            }
            
            // then change to imperfect subjunctive endings
            conjugationYo = infinitive.replacingOccurrences(of: "ron", with: "ra")
            conjugationTu = infinitive.replacingOccurrences(of: "ron", with: "ras")
            conjugationEl = infinitive.replacingOccurrences(of: "ron", with: "ra")
            conjugationNos = infinitive.replacingOccurrences(of: "eron", with: "éramos")
            conjugationVos = infinitive.replacingOccurrences(of: "ron", with: "rais")
            conjugationEllos = infinitive.replacingOccurrences(of: "ron", with: "ran")
        } else if (isEndingIr) {
            
            // For stem changed -ir verbs from preterite tense
            var stemChangedVerb1  = infinitive
            var stemChangedVerb2 = infinitive
            
            /* TODO: first conjugates to preterite tense of ellos/ellas/ustedes form
            if (hasStemChange) {
                if (E2I) {
                    if (nextIndexI) {
                        if (infinitive == "perseguir") {
                            if let index = stemChangedVerb1?.index(of: "e") {
                                stemChangedVerb1.replaceSubrange(stemChangedVerb1.index(index, offsetBy: 2)..<stemChangedVerb1.index(index, offsetBy: 3), with: "i")
                            }
                            infinitive = stemChangedVerb1?.replacingOccurrences(of: "ir", with: "ieron")
                        } else {
                            if let index = stemChangedVerb1?.index(of: "e") {
                                stemChangedVerb1.replaceSubrange(stemChangedVerb1.index(index, offsetBy: 2)..<stemChangedVerb1.index(index, offsetBy: 3), with: "i")
                            }
                            infinitive = stemChangedVerb1?.replacingOccurrences(of: "ir", with: "ieron")
                        }
                    } else {
                        // finds "e" and changes to stem "i"
                        if let index = stemChangedVerb1?.index(of: "e") {
                            stemChangedVerb1.replaceSubrange(stemChangedVerb1.index(index, offsetBy: 2)..<stemChangedVerb1.index(index, offsetBy: 3), with: "ie")
                        }
                        infinitive = stemChangedVerb1?.replacingOccurrences(of: "ir", with: "ieron")
                    }
                } else if (O2UE) {
                    // finds "o" and changes to stem "u"
                    if let range = stemChangedVerb2?.range(of: "o") {
                        stemChangedVerb2.replaceSubrange(range, with: "ue")
                    }
                    infinitive = stemChangedVerb2?.replacingOccurrences(of: "ir", with: "ieron")
                }
            } else if (infinitive.hasSuffix("uir")) {
                infinitive = infinitive.replacingOccurrences(of: "ir", with: "yeron")
            } else {
                infinitive = infinitive.replacingOccurrences(of: "ir", with: "ieron")
            } */
            
            // then change to imperfect subjunctive endings
            conjugationYo = infinitive.replacingOccurrences(of: "ron", with: "ra")
            conjugationTu = infinitive.replacingOccurrences(of: "ron", with: "ras")
            conjugationEl = infinitive.replacingOccurrences(of: "ron", with: "ra")
            conjugationNos = infinitive.replacingOccurrences(of: "eron", with: "éramos")
            conjugationVos = infinitive.replacingOccurrences(of: "ron", with: "rais")
            conjugationEllos = infinitive.replacingOccurrences(of: "ron", with: "ran")
        }

    }
    
    // CONDITIONAL TENSE CONJUGATOR
    func doConditionalTense() {
        if (infinitive == "valer") {
            conjugationYo = "valdría"
            conjugationTu = "valdrías"
            conjugationEl = "valdría"
            conjugationNos = "valdríamos"
            conjugationVos = "valdríais"
            conjugationEllos = "valdrían"
        } else if (infinitive == "caber") {
            conjugationYo = "cabría"
            conjugationTu = "cabrías"
            conjugationEl = "cabría"
            conjugationNos = "cabríamos"
            conjugationVos = "cabríais"
            conjugationEllos = "cabrían"
        } else if (infinitive.hasSuffix("deshacer")) {
            conjugationYo = "desharía"
            conjugationTu = "desharías"
            conjugationEl = "desharía"
            conjugationNos = "desharíamos"
            conjugationVos = "desharíais"
            conjugationEllos = "desharían"
        } else if (infinitive.hasSuffix("suponer")) {
            conjugationYo = "supondría"
            conjugationTu = "supondrías"
            conjugationEl = "supondría"
            conjugationNos = "supondríamos"
            conjugationVos = "supondríais"
            conjugationEllos = "supondrían"
        } else if (infinitive.hasSuffix("tener")) {
            conjugationYo = infinitive.replacingOccurrences(of: "tener", with: "tendría")
            conjugationTu = infinitive.replacingOccurrences(of: "tener", with: "tendrías")
            conjugationEl = infinitive.replacingOccurrences(of: "tener", with: "tendría")
            conjugationNos = infinitive.replacingOccurrences(of: "tener", with: "tendríamos")
            conjugationVos = infinitive.replacingOccurrences(of: "tener", with: "tendríais")
            conjugationEllos = infinitive.replacingOccurrences(of: "tener", with: "tendrían")
        } else {
            conjugationYo = infinitive + "ía"
            conjugationTu = infinitive + "ías"
            conjugationEl = infinitive + "ía"
            conjugationNos = infinitive + "íamos"
            conjugationVos = infinitive + "íais"
            conjugationEllos = infinitive + "ían"
        }
    }
    
    func doStemChange() {
        
        if (otherStemChangingVerbsIE.contains(infinitive)) {
            nextIndexIE = true
            nextIndexI = false
        } else if (otherStemChangingVerbsI.contains(infinitive)) {
            nextIndexIE = false
            nextIndexI = true
        }
        
        stemChangedVerb = infinitive
        
        if (E2IE) {
            if (nextIndexIE) {
                if (infinitive != "preferir") {
                    if let index = stemChangedVerb.index(of: "e") {
                        stemChangedVerb.replaceSubrange(stemChangedVerb.index(index, offsetBy: 3)..<stemChangedVerb.index(index, offsetBy: 4), with: "ie")
                    }
                } else {
                    if let index = stemChangedVerb.index(of: "e") {
                        stemChangedVerb.replaceSubrange(stemChangedVerb.index(index, offsetBy: 2)..<stemChangedVerb.index(index, offsetBy: 3), with: "ie")
                    }
                }
            } else {
                // finds "e" and changes to stem "ie"
                if let range = stemChangedVerb.range(of: "e") {
                    stemChangedVerb.replaceSubrange(range, with: "ie")
                }
            }
        } else if (O2UE) {
            // finds "o" and changes to stem "ue"
            if let range = stemChangedVerb.range(of: "o") {
                stemChangedVerb.replaceSubrange(range, with: "ue")
            }
        } else if (E2I) {
            if (nextIndexI) {
                if (infinitive != "perseguir") {
                    if let index = stemChangedVerb.index(of: "e") {
                        stemChangedVerb.replaceSubrange(stemChangedVerb.index(index, offsetBy: 2)..<stemChangedVerb.index(index, offsetBy: 3), with: "i")
                    }
                } else {
                    // TODO: WHY ISN'T THIS WORKING IN THE SUBJUNCTIVE FORM
                    if let index = stemChangedVerb.index(of: "e") {
                        stemChangedVerb.replaceSubrange(stemChangedVerb.index(index, offsetBy: 3)..<stemChangedVerb.index(index, offsetBy: 4), with: "i")
                    }
                }
            } else {
                // finds "e" and changes to stem "i"
                if let range = stemChangedVerb.range(of: "e") {
                    stemChangedVerb.replaceSubrange(range, with: "i")
                }
            }
        } else if (U2UE) {
            if let range = stemChangedVerb.range(of: "u") {
                stemChangedVerb.replaceSubrange(range, with: "ue")
            }
        } else if (O2HUE) {
            if let range = stemChangedVerb.range(of: "o") {
                stemChangedVerb.replaceSubrange(range, with: "hue")
            }
        }
    }
    
    // Spelling change for pronunciation in imperative, subjunctive form
    func spellingChange() {
        if (isEndingAr) {
            if (infinitive.hasSuffix("car")) {
                infinitive = infinitive.replacingOccurrences(of: "car", with: "quar")
            } else if (infinitive.hasSuffix("gar")) {
                infinitive = infinitive.replacingOccurrences(of: "gar", with: "guar")
            } else if (infinitive.hasSuffix("zar")) {
                infinitive = infinitive.replacingOccurrences(of: "zar", with: "car")
            }
        } else if (isEndingEr) {
            if (infinitive.hasSuffix("ger")) {
                infinitive = infinitive.replacingOccurrences(of: "ger", with: "jer")
            }
        } else if (isEndingIr) {
            if (infinitive.hasSuffix("guir")) {
                infinitive = infinitive.replacingOccurrences(of: "guir", with: "gir")
            } else if (infinitive.hasSuffix("gir")) {
                infinitive = infinitive.replacingOccurrences(of: "gir", with: "jir")
            }
        }
    }
    
    func spellingChangeForSubjunctive() {
        // spelling change of -car, -gar, -zar verbs
        if (hasSpellingChange) { spellingChange() }
        }
    
    func setText() {
        self.mainViewController!.table.reloadData()
    }
}

