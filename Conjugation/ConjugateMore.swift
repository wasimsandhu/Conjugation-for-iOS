//
//  ConjugateMore.swift
//  Conjugation
//
//  Created by Wasim Sandhu on 4/16/16.
//  Copyright © 2016 Wasim Sandhu. All rights reserved.
//

import Foundation

class ConjugateMore {
    
    var moreViewController: MoreTensesVC?
    
    var infinitive: String!
    var gerund: String!
    var translation: String!
    var pastParticiple: String!
    
    var isEndingAr = false
    var isEndingEr = false
    var isEndingIr = false
    
    let stemChangeGerunds = ["advertir", "competir", "conseguir", "consentir", "convertir",
    "decir", "hervir", "mentir", "pedir", "reñir", "repetir", "seguir", "servir", "sugerir",
    "venir", "poder", "dormir", "morir", "querer"]
    
    let irregularPastParticiples = ["abrir", "decir", "cubrir", "descubrir", "poner", "freír",
    "hacer", "imprimir", "ir", "morir", "escribir", "resolver", "romper", "ver", "volver", "querer"]
    
    let verbsVoidToAlgorithms = ["arreglar", "aclarar", "ejercer", "merecer", "perder", "permanecer", "pertenecer",
    "agarrar", "aguardar", "alarmar", "apartar", "argumentar", "armar", "arrancar", "arreglar", "arrestar",
    "caracterizar", "cargar", "cariar", "cariciar", "clarificar", "comparar", "contrariar", "charlar",
    "declarar", "descarriar", "disparar", "embarazar", "encarcelar", "encargar", "garantizar", "martillar",
    "paralizar", "parar", "participar", "preparar", "reparar", "variar", "dirigir", "circunvenir", "adquirir",
    "acarrear", "marcar", "articular", "arriar", "arrojar", "arrastrar"]
    
    var isIrregularPastParticiple = false
    var isNotGoingToWork = false
    var isIrregularGerund = false
    
    func conjugate() {
        
        // gets verb from text field
        infinitive = self.moreViewController!.input!
        
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
        
        if (irregularPastParticiples.contains(infinitive)) {
            isIrregularPastParticiple = true
        } else {
            isIrregularPastParticiple = false
        }
        
        if (verbsVoidToAlgorithms.contains(infinitive)) {
            isNotGoingToWork = true
        } else {
            isNotGoingToWork = false
        }
        
        getTranslation()

        if (isNotGoingToWork) {
            replaceWithMoreThanOneEnding1()
            replaceWithMoreThanOneEnding2()
        } else {
            getPastParticiple()
            getGerund()
        }

        self.moreViewController!.otherTable.reloadData()
    }
    
    func getTranslation() {
        if (infinitive == "abandonar") { translation = "to abandon" }
        else if (infinitive == "abatir") { translation = "to overthrow" }
        else if (infinitive == "abolir") { translation = "to abolish" }
        else if (infinitive == "abrazar") { translation = "to hug" }
        else if (infinitive == "abrir") { translation = "to open" }
        else if (infinitive == "absolver") { translation = "to absolve" }
        else if (infinitive == "absorber") { translation = "to absorb" }
        else if (infinitive == "abstener") { translation = "to abstain" }
        else if (infinitive == "aburrir") { translation = "to bore" }
        else if (infinitive == "abusar") { translation = "to abuse" }
        else if (infinitive == "acabar") { translation = "to complete" }
        else if (infinitive == "acampar") { translation = "to camp" }
        else if (infinitive == "acelerar") { translation = "to accelerate" }
        else if (infinitive == "aceptar") { translation = "to accept" }
        else if (infinitive == "acercar") { translation = "to bring close" }
        else if (infinitive == "acertar") { translation = "to hit the mark" }
        else if (infinitive == "aclamar") { translation = "to acclaim" }
        else if (infinitive == "aclarar") { translation = "to clarify" }
        else if (infinitive == "acompañar") { translation = "to accompany" }
        else if (infinitive == "aconsejar") { translation = "to advise" }
        else if (infinitive == "acordar") { translation = "to remember" }
        else if (infinitive == "acostar") { translation = "to lay down" }
        else if (infinitive == "acostumbrar") { translation = "to be accustomed" }
        else if (infinitive == "actualizar") { translation = "to realize" }
        else if (infinitive == "actuar") { translation = "to act" }
        else if (infinitive == "acuchillar") { translation = "to cut open" }
        else if (infinitive == "acudir") { translation = "to answer a call" }
        else if (infinitive == "acumular") { translation = "to accumulate" }
        else if (infinitive == "acusar") { translation = "to accuse" }
        else if (infinitive == "adaptar") { translation = "to adapt" }
        else if (infinitive == "adelantar") { translation = "to advance" }
        else if (infinitive == "adivinar") { translation = "to guess" }
        else if (infinitive == "administrar") { translation = "to administer" }
        else if (infinitive == "admirar") { translation = "to admire" }
        else if (infinitive == "admitir") { translation = "to admit" }
        else if (infinitive == "adoptar") { translation = "to adopt" }
        else if (infinitive == "adorar") { translation = "to adore" }
        else if (infinitive == "adornar") { translation = "to adorn" }
        else if (infinitive == "adquirir") { translation = "to acquire" }
        else if (infinitive == "advertir") { translation = "to advise" }
        else if (infinitive == "afectar") { translation = "to affect" }
        else if (infinitive == "afeitar") { translation = "to shave" }
        else if (infinitive == "afirmar") { translation = "to affirm" }
        else if (infinitive == "afligir") { translation = "to be afflicted" }
        else if (infinitive == "afluir") { translation = "to flow into" }
        else if (infinitive == "agachar") { translation = "to bend down" }
        else if (infinitive == "agarrar") { translation = "to grab" }
        else if (infinitive == "agitar") { translation = "to agitate" }
        else if (infinitive == "agotar") { translation = "to exhaust" }
        else if (infinitive == "agradecer") { translation = "to thank for" }
        else if (infinitive == "agrandar") { translation = "to enlarge" }
        else if (infinitive == "agravar") { translation = "to aggravate" }
        else if (infinitive == "agraviar") { translation = "to offend" }
        else if (infinitive == "agregar") { translation = "to aggregate" }
        else if (infinitive == "agriar") { translation = "to embitter" }
        else if (infinitive == "agrupar") { translation = "to group" }
        else if (infinitive == "aguantar") { translation = "to endure" }
        else if (infinitive == "aguardar") { translation = "to expect" }
        else if (infinitive == "agujerear") { translation = "to pierce" }
        else if (infinitive == "ahogar") { translation = "to suffocate" }
        else if (infinitive == "ahorrar") { translation = "to save" }
        else if (infinitive == "aislar") { translation = "to isolate" }
        else if (infinitive == "alarmar") { translation = "to alarm" }
        else if (infinitive == "alcanzar") { translation = "to reach for" }
        else if (infinitive == "aliar") { translation = "to ally" }
        else if (infinitive == "alimentar") { translation = "to nourish" }
        else if (infinitive == "aliviar") { translation = "to alleviate" }
        else if (infinitive == "almacenar") { translation = "to store" }
        else if (infinitive == "almorzar") { translation = "to eat lunch" }
        else if (infinitive == "alojar") { translation = "to lodge" }
        else if (infinitive == "alquilar") { translation = "to rent" }
        else if (infinitive == "alterar") { translation = "to alter" }
        else if (infinitive == "alumbrar") { translation = "to illuminate" }
        else if (infinitive == "alzar") { translation = "to store" }
        else if (infinitive == "amanecer") { translation = "to wake up at dawn" }
        else if (infinitive == "amar") { translation = "to love" }
        else if (infinitive == "amenazar") { translation = "to threaten" }
        else if (infinitive == "amnistiar") { translation = "to amnesty" }
        else if (infinitive == "amplifiar") { translation = "to amplify" }
        else if (infinitive == "amplificar") { translation = "to amplify" }
        else if (infinitive == "analizar") { translation = "to analyze" }
        else if (infinitive == "andar") { translation = "to be about" }
        else if (infinitive == "anochecer") { translation = "to become night" }
        else if (infinitive == "anular") { translation = "to annul" }
        else if (infinitive == "anunciar") { translation = "to announce" }
        else if (infinitive == "añadir") { translation = "to add" }
        else if (infinitive == "apaciguar") { translation = "to pacify" }
        else if (infinitive == "apagar") { translation = "to turn off" }
        else if (infinitive == "aparecer") { translation = "to appear" }
        else if (infinitive == "apartar") { translation = "to separate" }
        else if (infinitive == "apestar") { translation = "to corrupt" }
        else if (infinitive == "aplaudir") { translation = "to applaud" }
        else if (infinitive == "aplicar") { translation = "to apply" }
        else if (infinitive == "apoyar") { translation = "to support" }
        else if (infinitive == "apreciar") { translation = "to appreciate" }
        else if (infinitive == "aprehender") { translation = "to aprehend" }
        else if (infinitive == "aprender") { translation = "to learn" }
        else if (infinitive == "apretar") { translation = "to tighten" }
        else if (infinitive == "aprobar") { translation = "to approve" }
        else if (infinitive == "apurar") { translation = "to grieve" }
        else if (infinitive == "argumentar") { translation = "to argue" }
        else if (infinitive == "armar") { translation = "to arm" }
        else if (infinitive == "arrancar") { translation = "to pull up" }
        else if (infinitive == "arreglar") { translation = "to repair" }
        else if (infinitive == "arrestar") { translation = "to arrest" }
        else if (infinitive == "arriar") { translation = "to lower" }
        else if (infinitive == "arrojar") { translation = "to throw" }
        else if (infinitive == "articular") { translation = "to articulate" }
        else if (infinitive == "asaltar") { translation = "to assault" }
        else if (infinitive == "ascender") { translation = "to ascend" }
        else if (infinitive == "asegurar") { translation = "to assure" }
        else if (infinitive == "asesinar") { translation = "to assassinate" }
        else if (infinitive == "asignar") { translation = "to assign" }
        else if (infinitive == "asistir") { translation = "to attend" }
        else if (infinitive == "asociar") { translation = "to associate" }
        else if (infinitive == "aspirar") { translation = "to vacuum" }
        else if (infinitive == "asumir") { translation = "to assume" }
        else if (infinitive == "asustar") { translation = "to scare" }
        else if (infinitive == "atacar") { translation = "to attack" }
        else if (infinitive == "atender") { translation = "to attend" }
        else if (infinitive == "atraer") { translation = "to attract" }
        else if (infinitive == "atrapar") { translation = "to overtake" }
        else if (infinitive == "atribuir") { translation = "to attribute" }
        else if (infinitive == "atravesar") { translation = "to go through" }
        else if (infinitive == "aumentar") { translation = "to increase" }
        else if (infinitive == "autorizar") { translation = "to authorize" }
        else if (infinitive == "avanzar") { translation = "to advance" }
        else if (infinitive == "avergonzar") { translation = "to be ashamed" }
        else if (infinitive == "averiguar") { translation = "to verify" }
        else if (infinitive == "ayudar") { translation = "to help" }
        else if (infinitive == "ayunar") { translation = "to fast" }
        else if (infinitive == "bailar") { translation = "to dance" }
        else if (infinitive == "bajar") { translation = "to lower" }
        else if (infinitive == "balancear") { translation = "to balance" }
        else if (infinitive == "bañar") { translation = "to bath" }
        else if (infinitive == "basar") { translation = "to base" }
        else if (infinitive == "barrer") { translation = "to sweep" }
        else if (infinitive == "beber") { translation = "to drink" }
        else if (infinitive == "beneficiar") { translation = "to benefit" }
        else if (infinitive == "besar") { translation = "to kiss" }
        else if (infinitive == "bloquear") { translation = "to block" }
        else if (infinitive == "borrar") { translation = "to erase" }
        else if (infinitive == "bostezar") { translation = "to yawn" }
        else if (infinitive == "brincar") { translation = "to jump" }
        else if (infinitive == "brindar") { translation = "to toast" }
        else if (infinitive == "buscar") { translation = "to look for" }
        else if (infinitive == "cachear") { translation = "to search" }
        else if (infinitive == "caer") { translation = "to fall" }
        else if (infinitive == "calcular") { translation = "to calculate" }
        else if (infinitive == "calentar") { translation = "to heat up" }
        else if (infinitive == "calificar") { translation = "to qualify" }
        else if (infinitive == "calmar") { translation = "to calm down" }
        else if (infinitive == "callar") { translation = "to make quiet" }
        else if (infinitive == "cambiar") { translation = "to change" }
        else if (infinitive == "caminar") { translation = "to walk" }
        else if (infinitive == "cancelar") { translation = "to cancel" }
        else if (infinitive == "cansar") { translation = "to get tired" }
        else if (infinitive == "cantar") { translation = "to sing" }
        else if (infinitive == "caracterizar") { translation = "to characterize" }
        else if (infinitive == "carecer") { translation = "to lack" }
        else if (infinitive == "cargar") { translation = "to load" }
        else if (infinitive == "cariar") { translation = "to cause cavities" }
        else if (infinitive == "cariciar") { translation = "to caress" }
        else if (infinitive == "casar") { translation = "to get married" }
        else if (infinitive == "castigar") { translation = "to chastise" }
        else if (infinitive == "causar") { translation = "to cause" }
        else if (infinitive == "cauterizar") { translation = "to cauterize" }
        else if (infinitive == "cazar") { translation = "to hunt" }
        else if (infinitive == "celebrar") { translation = "to celebrate" }
        else if (infinitive == "cenar") { translation = "to eat dinner" }
        else if (infinitive == "cepillar") { translation = "to brush" }
        else if (infinitive == "cerrar") { translation = "to close" }
        else if (infinitive == "circular") { translation = "to circulate" }
        else if (infinitive == "circunvenir") { translation = "to circumvent" }
        else if (infinitive == "citar") { translation = "to quote" }
        else if (infinitive == "clarificar") { translation = "to clarify" }
        else if (infinitive == "clasificar") { translation = "to classify" }
        else if (infinitive == "cocinar") { translation = "to cook" }
        else if (infinitive == "coger") { translation = "to choose" }
        else if (infinitive == "colaborar") { translation = "to collaborate" }
        else if (infinitive == "colgar") { translation = "to hang" }
        else if (infinitive == "colocar") { translation = "to place" }
        else if (infinitive == "colonizar") { translation = "to colonize" }
        else if (infinitive == "columpiar") { translation = "to swing" }
        else if (infinitive == "combatir") { translation = "to fight" }
        else if (infinitive == "combinar") { translation = "to combine" }
        else if (infinitive == "comentar") { translation = "to comment" }
        else if (infinitive == "comenzar") { translation = "to commence" }
        else if (infinitive == "comer") { translation = "to to eat" }
        else if (infinitive == "cometer") { translation = "to commit" }
        else if (infinitive == "comparar") { translation = "to compare" }
        else if (infinitive == "compartir") { translation = "to share" }
        else if (infinitive == "compeler") { translation = "to compel" }
        else if (infinitive == "compensar") { translation = "to compensate" }
        else if (infinitive == "competir") { translation = "to compete" }
        else if (infinitive == "compilar") { translation = "to compile" }
        else if (infinitive == "completar") { translation = "to complete" }
        else if (infinitive == "complicar") { translation = "to complicate" }
        else if (infinitive == "componer") { translation = "to compose" }
        else if (infinitive == "comprar") { translation = "to buy" }
        else if (infinitive == "comprender") { translation = "to comprehend" }
        else if (infinitive == "comunicar") { translation = "to communicate" }
        else if (infinitive == "concebir") { translation = "to conceive" }
        else if (infinitive == "conceder") { translation = "to concede" }
        else if (infinitive == "concentrar") { translation = "to concentrate" }
        else if (infinitive == "concluir") { translation = "to conclude" }
        else if (infinitive == "condenar") { translation = "to condemn" }
        else if (infinitive == "condensar") { translation = "to condense" }
        else if (infinitive == "conducir") { translation = "to drive" }
        else if (infinitive == "conectar") { translation = "to connect" }
        else if (infinitive == "confesar") { translation = "to confess" }
        else if (infinitive == "confiar") { translation = "to confide" }
        else if (infinitive == "confirmar") { translation = "to confirm" }
        else if (infinitive == "confluir") { translation = "to flow together" }
        else if (infinitive == "conformar") { translation = "to conform" }
        else if (infinitive == "confortar") { translation = "to comfort" }
        else if (infinitive == "confrontar") { translation = "to confront" }
        else if (infinitive == "confundir") { translation = "to confuse" }
        else if (infinitive == "congregar") { translation = "to congregate" }
        else if (infinitive == "conllevar") { translation = "to help with hardship" }
        else if (infinitive == "conocer") { translation = "to be familiar with" }
        else if (infinitive == "conquistar") { translation = "to conquer" }
        else if (infinitive == "conseguir") { translation = "to acquire" }
        else if (infinitive == "consentir") { translation = "to consent" }
        else if (infinitive == "conservar") { translation = "to conserve" }
        else if (infinitive == "considerar") { translation = "to consider" }
        else if (infinitive == "consolar") { translation = "to console" }
        else if (infinitive == "constipar") { translation = "to constipate" }
        else if (infinitive == "constituir") { translation = "to constitute" }
        else if (infinitive == "construir") { translation = "to construct" }
        else if (infinitive == "consultar") { translation = "to consult" }
        else if (infinitive == "consumir") { translation = "to consume" }
        else if (infinitive == "contaminar") { translation = "to contaminate" }
        else if (infinitive == "contar") { translation = "to count" }
        else if (infinitive == "contemplar") { translation = "to contemplate" }
        else if (infinitive == "contener") { translation = "to contain" }
        else if (infinitive == "contestar") { translation = "to answer" }
        else if (infinitive == "continuar") { translation = "to continue" }
        else if (infinitive == "contradecir") { translation = "to contradict" }
        else if (infinitive == "contraer") { translation = "to contract" }
        else if (infinitive == "contrariar") { translation = "to oppose" }
        else if (infinitive == "contratar") { translation = "to contract" }
        else if (infinitive == "contravenir") { translation = "to contravene" }
        else if (infinitive == "contribuir") { translation = "to contribute" }
        else if (infinitive == "controlar") { translation = "to control" }
        else if (infinitive == "convencer") { translation = "to convince" }
        else if (infinitive == "convenir") { translation = "to convene" }
        else if (infinitive == "conversar") { translation = "to have a conversation" }
        else if (infinitive == "convertir") { translation = "to convert" }
        else if (infinitive == "coordinar") { translation = "to coordinate" }
        else if (infinitive == "corregir") { translation = "to correct" }
        else if (infinitive == "correr") { translation = "to run" }
        else if (infinitive == "cortar") { translation = "to cut" }
        else if (infinitive == "costar") { translation = "to cost" }
        else if (infinitive == "crear") { translation = "to create" }
        else if (infinitive == "crecer") { translation = "to grow" }
        else if (infinitive == "creer") { translation = "to believe" }
        else if (infinitive == "criar") { translation = "to create" }
        else if (infinitive == "criticar") { translation = "to criticize" }
        else if (infinitive == "cruzar") { translation = "to cross" }
        else if (infinitive == "cubrir") { translation = "to cover" }
        else if (infinitive == "cuidar") { translation = "to take care of" }
        else if (infinitive == "cumplir") { translation = "to complete" }
        else if (infinitive == "curar") { translation = "to cute" }
        else if (infinitive == "charlar") { translation = "to chat" }
        else if (infinitive == "chiflar") { translation = "to whistle" }
        else if (infinitive == "chillar") { translation = "to shriek" }
        else if (infinitive == "chirriar") { translation = "to hiss" }
        else if (infinitive == "chismear") { translation = "to gossip" }
        else if (infinitive == "chocar") { translation = "to collide" }
        else if (infinitive == "chupar") { translation = "to suck" }
        else if (infinitive == "dar") { translation = "to give" }
        else if (infinitive == "deber") { translation = "to ought to" }
        else if (infinitive == "decidir") { translation = "to decide" }
        else if (infinitive == "decir") { translation = "to say" }
        else if (infinitive == "declarar") { translation = "to declare" }
        else if (infinitive == "decorar") { translation = "to decorate" }
        else if (infinitive == "dedicar") { translation = "to dedicate" }
        else if (infinitive == "deducir") { translation = "to deduce" }
        else if (infinitive == "defender") { translation = "to defend" }
        else if (infinitive == "definir") { translation = "to define" }
        else if (infinitive == "defraudar") { translation = "to defraud" }
        else if (infinitive == "dejar") { translation = "to leave" }
        else if (infinitive == "delegar") { translation = "to delegate" }
        else if (infinitive == "deliverar") { translation = "to deliver" }
        else if (infinitive == "demandar") { translation = "to demand" }
        else if (infinitive == "demostrar") { translation = "to demonstrate" }
        else if (infinitive == "denunciar") { translation = "to denounce" }
        else if (infinitive == "depender") { translation = "to depend" }
        else if (infinitive == "deponer") { translation = "to depose" }
        else if (infinitive == "deprimir") { translation = "to depress" }
        else if (infinitive == "derivar") { translation = "to derive" }
        else if (infinitive == "desafiar") { translation = "to dare" }
        else if (infinitive == "desaparecer") { translation = "to disappear" }
        else if (infinitive == "desayunar") { translation = "to eat breakfast" }
        else if (infinitive == "descansar") { translation = "to rest" }
        else if (infinitive == "descarriar") { translation = "to mislead" }
        else if (infinitive == "descender") { translation = "to descend" }
        else if (infinitive == "descifrar") { translation = "to decipher" }
        else if (infinitive == "descomponer") { translation = "to decompose" }
        else if (infinitive == "desconfiar") { translation = "to mistrust" }
        else if (infinitive == "desconocer") { translation = "to be unacquainted with" }
        else if (infinitive == "descontar") { translation = "to discount" }
        else if (infinitive == "describir") { translation = "to describe" }
        else if (infinitive == "descubrir") { translation = "to discover" }
        else if (infinitive == "descuidar") { translation = "to relieve from care" }
        else if (infinitive == "desear") { translation = "to wish" }
        else if (infinitive == "desempeñar") { translation = "to redeem" }
        else if (infinitive == "desenchufar") { translation = "to unplug" }
        else if (infinitive == "desengañar") { translation = "to disillusion" }
        else if (infinitive == "desfigurar") { translation = "to disfigure" }
        else if (infinitive == "deshacer") { translation = "to undo" }
        else if (infinitive == "deshumanizar") { translation = "to dehumanize" }
        else if (infinitive == "desilusionar") { translation = "to disillusion" }
        else if (infinitive == "desintoxicar") { translation = "to detoxicate" }
        else if (infinitive == "desmayar") { translation = "to faint" }
        else if (infinitive == "desobstruir") { translation = "to unclog" }
        else if (infinitive == "desocupar") { translation = "to vacate" }
        else if (infinitive == "desorientar") { translation = "to disorient" }
        else if (infinitive == "despedir") { translation = "to say goodbye" }
        else if (infinitive == "despertar") { translation = "to awaken" }
        else if (infinitive == "despreciar") { translation = "to despise" }
        else if (infinitive == "destacar") { translation = "to detach" }
        else if (infinitive == "destruir") { translation = "to destroy" }
        else if (infinitive == "desvestir") { translation = "to undress" }
        else if (infinitive == "desviar") { translation = "to deviate" }
        else if (infinitive == "detectar") { translation = "to detect" }
        else if (infinitive == "detener") { translation = "to detain" }
        else if (infinitive == "determinar") { translation = "to determine" }
        else if (infinitive == "devorar") { translation = "to devour" }
        else if (infinitive == "dibujar") { translation = "to draw" }
        else if (infinitive == "dictar") { translation = "to dictate" }
        else if (infinitive == "dirigir") { translation = "to lead" }
        else if (infinitive == "disculpar") { translation = "to excuse" }
        else if (infinitive == "discutir") { translation = "to discuss" }
        else if (infinitive == "disfrutar") { translation = "to enjoy" }
        else if (infinitive == "disgustar") { translation = "to disgust" }
        else if (infinitive == "disminuir") { translation = "to diminish" }
        else if (infinitive == "disolver") { translation = "to dissolve" }
        else if (infinitive == "disparar") { translation = "to shoot" }
        else if (infinitive == "disponer") { translation = "to dispose" }
        else if (infinitive == "disputar") { translation = "to dispute" }
        else if (infinitive == "distinguir") { translation = "to distinguish" }
        else if (infinitive == "distraer") { translation = "to distract" }
        else if (infinitive == "distribuir") { translation = "to distribute" }
        else if (infinitive == "disuadir") { translation = "to dissuade" }
        else if (infinitive == "diversificar") { translation = "to diversify" }
        else if (infinitive == "divertir") { translation = "to have fun" }
        else if (infinitive == "dividir") { translation = "to divide" }
        else if (infinitive == "divorciar") { translation = "to divorce" }
        else if (infinitive == "doblar") { translation = "to double" }
        else if (infinitive == "doler") { translation = "to hurt" }
        else if (infinitive == "dormir") { translation = "to sleep" }
        else if (infinitive == "duchar") { translation = "to shower" }
        else if (infinitive == "dudar") { translation = "to doubt" }
        else if (infinitive == "echar") { translation = "to put in" }
        else if (infinitive == "educar") { translation = "to educate" }
        else if (infinitive == "ejecutar") { translation = "to execute" }
        else if (infinitive == "ejercer") { translation = "to exercise" }
        else if (infinitive == "elegir") { translation = "to elect" }
        else if (infinitive == "elevar") { translation = "to elevate" }
        else if (infinitive == "eliminar") { translation = "to eliminate" }
        else if (infinitive == "embarazar") { translation = "to make pregnant" }
        else if (infinitive == "emborrachar") { translation = "to intoxicate" }
        else if (infinitive == "emitir") { translation = "to emit" }
        else if (infinitive == "empeorar") { translation = "to worsen" }
        else if (infinitive == "empezar") { translation = "to start" }
        else if (infinitive == "emplear") { translation = "to employ" }
        else if (infinitive == "enamorar") { translation = "to fall in love" }
        else if (infinitive == "encantar") { translation = "to love" }
        else if (infinitive == "encarcelar") { translation = "to imprison" }
        else if (infinitive == "encargar") { translation = "to entrust" }
        else if (infinitive == "encerrar") { translation = "to lock up" }
        else if (infinitive == "encontrar") { translation = "to find" }
        else if (infinitive == "enchilar") { translation = "to burn with chiles" }
        else if (infinitive == "enfadar") { translation = "to annoy" }
        else if (infinitive == "enfatizar") { translation = "to emphasize" }
        else if (infinitive == "enfermar") { translation = "to get sick" }
        else if (infinitive == "enflacar") { translation = "to get thin" }
        else if (infinitive == "enfocar") { translation = "to focus" }
        else if (infinitive == "enfriar") { translation = "to cool" }
        else if (infinitive == "engañar") { translation = "to deceive" }
        else if (infinitive == "engendrar") { translation = "to engender" }
        else if (infinitive == "engordar") { translation = "to gain weight" }
        else if (infinitive == "enloquecer") { translation = "to drive insane" }
        else if (infinitive == "enojar") { translation = "to anger" }
        else if (infinitive == "enriquecer") { translation = "to enrich" }
        else if (infinitive == "enseñar") { translation = "to teach" }
        else if (infinitive == "ensuciar") { translation = "to get dirty" }
        else if (infinitive == "entender") { translation = "to understand" }
        else if (infinitive == "entrar") { translation = "to enter" }
        else if (infinitive == "entregar") { translation = "to return" }
        else if (infinitive == "entretener") { translation = "to entertain" }
        else if (infinitive == "entrevenir") { translation = "to intervene" }
        else if (infinitive == "entrevistar") { translation = "to interview" }
        else if (infinitive == "envejecer") { translation = "to enumerate" }
        else if (infinitive == "enumerar") { translation = "to age" }
        else if (infinitive == "enviar") { translation = "to send" }
        else if (infinitive == "envidiar") { translation = "to envy" }
        else if (infinitive == "envolver") { translation = "to envelope" }
        else if (infinitive == "escapar") { translation = "to escape" }
        else if (infinitive == "escoger") { translation = "to choose" }
        else if (infinitive == "escoltar") { translation = "to escort" }
        else if (infinitive == "esconder") { translation = "to hide" }
        else if (infinitive == "escribir") { translation = "to write" }
        else if (infinitive == "escuchar") { translation = "to listen" }
        else if (infinitive == "escupir") { translation = "to spit" }
        else if (infinitive == "especializar") { translation = "to specialize" }
        else if (infinitive == "especificar") { translation = "to specify" }
        else if (infinitive == "esperar") { translation = "to hope" }
        else if (infinitive == "espiar") { translation = "to spy on" }
        else if (infinitive == "esquiar") { translation = "to ski" }
        else if (infinitive == "establecer") { translation = "to establish" }
        else if (infinitive == "estar") { translation = "to be" }
        else if (infinitive == "esterilizar") { translation = "to sterilize" }
        else if (infinitive == "estipular") { translation = "to stipulate" }
        else if (infinitive == "estornudar") { translation = "to sneeze" }
        else if (infinitive == "estudiar") { translation = "to study" }
        else if (infinitive == "evacuar") { translation = "to evacuate" }
        else if (infinitive == "evaluar") { translation = "to evaluate" }
        else if (infinitive == "evitar") { translation = "to avoid" }
        else if (infinitive == "exagerar") { translation = "to exaggerate" }
        else if (infinitive == "exaltar") { translation = "to exalt" }
        else if (infinitive == "examinar") { translation = "to examine" }
        else if (infinitive == "exceder") { translation = "to exceed" }
        else if (infinitive == "excluir") { translation = "to exclude" }
        else if (infinitive == "excusar") { translation = "to excuse" }
        else if (infinitive == "exhalar") { translation = "to exhale" }
        else if (infinitive == "exhibir") { translation = "to exhibit" }
        else if (infinitive == "exigir") { translation = "to demand" }
        else if (infinitive == "existir") { translation = "to exist" }
        else if (infinitive == "expatriar") { translation = "to expatriate" }
        else if (infinitive == "explicar") { translation = "to explain" }
        else if (infinitive == "exponer") { translation = "to expose" }
        else if (infinitive == "expresar") { translation = "to express" }
        else if (infinitive == "expulsar") { translation = "to expel" }
        else if (infinitive == "extender") { translation = "to extend" }
        else if (infinitive == "extinguir") { translation = "to extinguish" }
        else if (infinitive == "extirpar") { translation = "to extirpate" }
        else if (infinitive == "extraer") { translation = "to extract" }
        else if (infinitive == "fabricar") { translation = "to fabricate" }
        else if (infinitive == "facilitar") { translation = "to facilitate" }
        else if (infinitive == "falsificar") { translation = "to falsify" }
        else if (infinitive == "faltar") { translation = "to lack" }
        else if (infinitive == "fallar") { translation = "to fail" }
        else if (infinitive == "fascinar") { translation = "to fascinate" }
        else if (infinitive == "fastidiar") { translation = "to annoy" }
        else if (infinitive == "fatigar") { translation = "to fatigue" }
        else if (infinitive == "fecundar") { translation = "to fertilize" }
        else if (infinitive == "fiar") { translation = "to answer for" }
        else if (infinitive == "fijar") { translation = "to focus" }
        else if (infinitive == "finalizar") { translation = "to finalize" }
        else if (infinitive == "fingir") { translation = "to fake" }
        else if (infinitive == "firmar") { translation = "to sign" }
        else if (infinitive == "florecer") { translation = "to bloom" }
        else if (infinitive == "fluir") { translation = "to flow" }
        else if (infinitive == "formar") { translation = "to form" }
        else if (infinitive == "formular") { translation = "to formulate" }
        else if (infinitive == "forzar") { translation = "to force" }
        else if (infinitive == "fotografiar") { translation = "to take pictures" }
        else if (infinitive == "fracturar") { translation = "to fracture" }
        else if (infinitive == "freír") { translation = "to fry" }
        else if (infinitive == "frustrar") { translation = "to frustrate" }
        else if (infinitive == "fumar") { translation = "to smoke" }
        else if (infinitive == "funcionar") { translation = "to function" }
        else if (infinitive == "fundar") { translation = "to found" }
        else if (infinitive == "fusilar") { translation = "to shoot" }
        else if (infinitive == "ganar") { translation = "to win" }
        else if (infinitive == "garantizar") { translation = "to guarantee" }
        else if (infinitive == "gastar") { translation = "to spend (money)" }
        else if (infinitive == "gobernar") { translation = "to govern" }
        else if (infinitive == "golpear") { translation = "to strike" }
        else if (infinitive == "gozar") { translation = "to enjoy" }
        else if (infinitive == "grabar") { translation = "to record" }
        else if (infinitive == "graduar") { translation = "to graduate" }
        else if (infinitive == "gritar") { translation = "to scream" }
        else if (infinitive == "gruñir") { translation = "to grunt" }
        else if (infinitive == "guiar") { translation = "to guide" }
        else if (infinitive == "gustar") { translation = "to like" }
        else if (infinitive == "haber") { translation = "to have" }
        else if (infinitive == "hablar") { translation = "to speak" }
        else if (infinitive == "hacer") { translation = "to make/do" }
        else if (infinitive == "hallar") { translation = "to find" }
        else if (infinitive == "heredar") { translation = "to inherit" }
        else if (infinitive == "hervir") { translation = "to boil" }
        else if (infinitive == "hinchar") { translation = "to swell up" }
        else if (infinitive == "historiar") { translation = "to depict history" }
        else if (infinitive == "honrar") { translation = "to honor" }
        else if (infinitive == "hospitalizar") { translation = "to hospitalize" }
        else if (infinitive == "huir") { translation = "to flee" }
        else if (infinitive == "identificar") { translation = "to identify" }
        else if (infinitive == "ignorar") { translation = "to ignore" }
        else if (infinitive == "ilegalizar") { translation = "to make illegal" }
        else if (infinitive == "imaginar") { translation = "to imagine" }
        else if (infinitive == "imitar") { translation = "to imitate" }
        else if (infinitive == "impedir") { translation = "to impede" }
        else if (infinitive == "implantar") { translation = "to implant" }
        else if (infinitive == "implementar") { translation = "to implement" }
        else if (infinitive == "implicar") { translation = "to implicate" }
        else if (infinitive == "imponer") { translation = "to impose" }
        else if (infinitive == "importar") { translation = "to be important" }
        else if (infinitive == "impresionar") { translation = "to impress" }
        else if (infinitive == "imprimir") { translation = "to print" }
        else if (infinitive == "incapacitar") { translation = "to incapacitate" }
        else if (infinitive == "incluir") { translation = "to include" }
        else if (infinitive == "incorporar") { translation = "to incorporate" }
        else if (infinitive == "incrementar") { translation = "to increment" }
        else if (infinitive == "incurrir") { translation = "to incur" }
        else if (infinitive == "indicar") { translation = "to indicate" }
        else if (infinitive == "inducir") { translation = "to induce" }
        else if (infinitive == "industrializar") { translation = "to industrialize" }
        else if (infinitive == "infectar") { translation = "to infect" }
        else if (infinitive == "inferir") { translation = "to infer" }
        else if (infinitive == "inflamar") { translation = "to inflame" }
        else if (infinitive == "infligir") { translation = "to inflict" }
        else if (infinitive == "influir") { translation = "to influence" }
        else if (infinitive == "informar") { translation = "to inform" }
        else if (infinitive == "ingresar") { translation = "to become a member" }
        else if (infinitive == "iniciar") { translation = "to initiate" }
        else if (infinitive == "inscribir") { translation = "to inscribe" }
        else if (infinitive == "insinuar") { translation = "to insinuate" }
        else if (infinitive == "insistir") { translation = "to insist" }
        else if (infinitive == "inspeccionar") { translation = "to inspect" }
        else if (infinitive == "inspirar") { translation = "to inspire" }
        else if (infinitive == "instituir") { translation = "to institute" }
        else if (infinitive == "instruir") { translation = "to instruct" }
        else if (infinitive == "insultar") { translation = "to insult" }
        else if (infinitive == "intentar") { translation = "to intend" }
        else if (infinitive == "intercambiar") { translation = "to exchange" }
        else if (infinitive == "interesar") { translation = "to interest" }
        else if (infinitive == "interpretar") { translation = "to interpret" }
        else if (infinitive == "intervenir") { translation = "to intervene" }
        else if (infinitive == "interrogar") { translation = "to interrogate" }
        else if (infinitive == "interrumpir") { translation = "to interrupt" }
        else if (infinitive == "introducir") { translation = "to introduce" }
        else if (infinitive == "invadir") { translation = "to invade" }
        else if (infinitive == "inventar") { translation = "to invent" }
        else if (infinitive == "inventariar") { translation = "to inventory" }
        else if (infinitive == "invertir") { translation = "to invest" }
        else if (infinitive == "investigar") { translation = "to investigate" }
        else if (infinitive == "invitar") { translation = "to invite" }
        else if (infinitive == "inyectar") { translation = "to inject" }
        else if (infinitive == "ir") { translation = "to go" }
        else if (infinitive == "irritar") { translation = "to irritate" }
        else if (infinitive == "jalar") { translation = "to pull" }
        else if (infinitive == "jubilar") { translation = "to retire" }
        else if (infinitive == "jugar") { translation = "to play" }
        else if (infinitive == "juntar") { translation = "to bring together" }
        else if (infinitive == "jurar") { translation = "to swear" }
        else if (infinitive == "justificar") { translation = "to justify" }
        else if (infinitive == "juzgar") { translation = "to judge" }
        else if (infinitive == "ladrar") { translation = "to bark" }
        else if (infinitive == "lastimar") { translation = "to hurt" }
        else if (infinitive == "lavar") { translation = "to wash" }
        else if (infinitive == "leer") { translation = "to read" }
        else if (infinitive == "legalizar") { translation = "to legalize" }
        else if (infinitive == "levantar") { translation = "to lift up" }
        else if (infinitive == "liar") { translation = "to tie up" }
        else if (infinitive == "liberar") { translation = "to liberate" }
        else if (infinitive == "licenciar") { translation = "to license" }
        else if (infinitive == "limitar") { translation = "to limit" }
        else if (infinitive == "limpiar") { translation = "to clean" }
        else if (infinitive == "localizar") { translation = "to localize" }
        else if (infinitive == "luchar") { translation = "to fight" }
        else if (infinitive == "llamar") { translation = "to call" }
        else if (infinitive == "llegar") { translation = "to arrive" }
        else if (infinitive == "llenar") { translation = "to make full" }
        else if (infinitive == "llevar") { translation = "to wear" }
        else if (infinitive == "llorar") { translation = "to cry" }
        else if (infinitive == "llover") { translation = "to rain" }
        else if (infinitive == "lloviznar") { translation = "to drizzle" }
        else if (infinitive == "machucar") { translation = "to squash" }
        else if (infinitive == "madurar") { translation = "to mature" }
        else if (infinitive == "maldecir") { translation = "to curse" }
        else if (infinitive == "malfuncionar") { translation = "to malfunction" }
        else if (infinitive == "maltratar") { translation = "to mistreat" }
        else if (infinitive == "manchar") { translation = "to spot" }
        else if (infinitive == "mandar") { translation = "to send" }
        else if (infinitive == "manejar") { translation = "to manage" }
        else if (infinitive == "manifestar") { translation = "to manifest" }
        else if (infinitive == "manipular") { translation = "to manipulate" }
        else if (infinitive == "mantener") { translation = "to maintain" }
        else if (infinitive == "martillar") { translation = "to hammer" }
        else if (infinitive == "mascar") { translation = "to chew" }
        else if (infinitive == "masticar") { translation = "to masticate" }
        else if (infinitive == "medir") { translation = "to measure" }
        else if (infinitive == "mejorar") { translation = "to make better" }
        else if (infinitive == "mencionar") { translation = "to mention" }
        else if (infinitive == "mentir") { translation = "to lie" }
        else if (infinitive == "merecer") { translation = "to earn" }
        else if (infinitive == "meter") { translation = "to insert" }
        else if (infinitive == "mirar") { translation = "to see" }
        else if (infinitive == "moderar") { translation = "to moderate" }
        else if (infinitive == "modificar") { translation = "to modify" }
        else if (infinitive == "mojar") { translation = "to moisten" }
        else if (infinitive == "molestar") { translation = "to annoy" }
        else if (infinitive == "montar") { translation = "to ride" }
        else if (infinitive == "morder") { translation = "to bite" }
        else if (infinitive == "morir") { translation = "to die" }
        else if (infinitive == "mostrar") { translation = "to demonstrate" }
        else if (infinitive == "mover") { translation = "to move" }
        else if (infinitive == "mudar") { translation = "to relocate" }
        else if (infinitive == "nacer") { translation = "to be born" }
        else if (infinitive == "nacionalizar") { translation = "to nationalize" }
        else if (infinitive == "nadar") { translation = "to swim" }
        else if (infinitive == "naturalizar") { translation = "to naturalize" }
        else if (infinitive == "navegar") { translation = "to navigate" }
        else if (infinitive == "necesitar") { translation = "to need" }
        else if (infinitive == "negar") { translation = "to say no" }
        else if (infinitive == "nevar") { translation = "to snow" }
        else if (infinitive == "nombrar") { translation = "to name" }
        else if (infinitive == "normalizar") { translation = "to normalize" }
        else if (infinitive == "notar") { translation = "to note" }
        else if (infinitive == "nublar") { translation = "to cloud up" }
        else if (infinitive == "obedecer") { translation = "to obey" }
        else if (infinitive == "obligar") { translation = "to oblige" }
        else if (infinitive == "observar") { translation = "to observe" }
        else if (infinitive == "obstruir") { translation = "to obstruct" }
        else if (infinitive == "obtener") { translation = "to obtain" }
        else if (infinitive == "obviar") { translation = "to remove" }
        else if (infinitive == "ocupar") { translation = "to occupy" }
        else if (infinitive == "ocurrir") { translation = "to occur" }
        else if (infinitive == "odiar") { translation = "to hate" }
        else if (infinitive == "ofender") { translation = "to offend" }
        else if (infinitive == "ofrecer") { translation = "to offer" }
        else if (infinitive == "oír") { translation = "to hear" }
        else if (infinitive == "oler") { translation = "to smell" }
        else if (infinitive == "olvidar") { translation = "to forget" }
        else if (infinitive == "omitir") { translation = "to omit" }
        else if (infinitive == "operar") { translation = "to operate" }
        else if (infinitive == "opinar") { translation = "to be of opinion" }
        else if (infinitive == "oponer") { translation = "to oppose" }
        else if (infinitive == "optar") { translation = "to opt" }
        else if (infinitive == "orar") { translation = "to pray" }
        else if (infinitive == "organizar") { translation = "to organize" }
        else if (infinitive == "padecer") { translation = "to suffer" }
        else if (infinitive == "pagar") { translation = "to pay" }
        else if (infinitive == "paliar") { translation = "to pale" }
        else if (infinitive == "paralizar") { translation = "to paralyze" }
        else if (infinitive == "parar") { translation = "to stand" }
        else if (infinitive == "parecer") { translation = "to resemble" }
        else if (infinitive == "participar") { translation = "to participate" }
        else if (infinitive == "partir") { translation = "to divide" }
        else if (infinitive == "pasar") { translation = "to spend time" }
        else if (infinitive == "pasteurizar") { translation = "to pasteurize" }
        else if (infinitive == "patinar") { translation = "to skate" }
        else if (infinitive == "patrullar") { translation = "to patrol" }
        else if (infinitive == "pedir") { translation = "to ask for" }
        else if (infinitive == "pegar") { translation = "to hit" }
        else if (infinitive == "peinar") { translation = "to comb" }
        else if (infinitive == "pelear") { translation = "to fight" }
        else if (infinitive == "peliscar") { translation = "to pinch" }
        else if (infinitive == "penetrar") { translation = "to penetrate" }
        else if (infinitive == "pensar") { translation = "to think" }
        else if (infinitive == "percibir") { translation = "to perceive" }
        else if (infinitive == "perder") { translation = "to lose" }
        else if (infinitive == "perdonar") { translation = "to pardon" }
        else if (infinitive == "perdurar") { translation = "to last" }
        else if (infinitive == "perfeccionar") { translation = "to perfect" }
        else if (infinitive == "perforar") { translation = "to perforate" }
        else if (infinitive == "perjudicar") { translation = "to damage" }
        else if (infinitive == "permanecer") { translation = "to remain" }
        else if (infinitive == "permitir") { translation = "to permit" }
        else if (infinitive == "perpetrar") { translation = "to perpetrate" }
        else if (infinitive == "persistir") { translation = "to persist" }
        else if (infinitive == "persuadir") { translation = "to persuade" }
        else if (infinitive == "pertenecer") { translation = "to belong" }
        else if (infinitive == "perturbar") { translation = "to perturb" }
        else if (infinitive == "pesar") { translation = "to weigh" }
        else if (infinitive == "pescar") { translation = "to fish" }
        else if (infinitive == "piar") { translation = "to chirp" }
        else if (infinitive == "picar") { translation = "to sting" }
        else if (infinitive == "pintar") { translation = "to paint" }
        else if (infinitive == "pitar") { translation = "to honk" }
        else if (infinitive == "planchar") { translation = "to iron" }
        else if (infinitive == "platicar") { translation = "to chatter" }
        else if (infinitive == "poblar") { translation = "to populate" }
        else if (infinitive == "poder") { translation = "to be able" }
        else if (infinitive == "poner") { translation = "to put" }
        else if (infinitive == "porfiar") { translation = "to persist" }
        else if (infinitive == "portar") { translation = "to bear" }
        else if (infinitive == "poseer") { translation = "to own" }
        else if (infinitive == "posponer") { translation = "to postpone" }
        else if (infinitive == "practicar") { translation = "to practice" }
        else if (infinitive == "precisar") { translation = "to specify" }
        else if (infinitive == "predisponer") { translation = "to predispose" }
        else if (infinitive == "preferir") { translation = "to prefer" }
        else if (infinitive == "preguntar") { translation = "to ask (a question)" }
        else if (infinitive == "prender") { translation = "to switch on" }
        else if (infinitive == "preocupar") { translation = "to preoccupy" }
        else if (infinitive == "preparar") { translation = "to prepare" }
        else if (infinitive == "presentar") { translation = "to present" }
        else if (infinitive == "presidir") { translation = "to preside" }
        else if (infinitive == "prestar") { translation = "to lend" }
        else if (infinitive == "presumir") { translation = "to presume" }
        else if (infinitive == "prevenir") { translation = "to preview" }
        else if (infinitive == "privar") { translation = "to deprive" }
        else if (infinitive == "probar") { translation = "to taste" }
        else if (infinitive == "proceder") { translation = "to proceed" }
        else if (infinitive == "procrear") { translation = "to procreate" }
        else if (infinitive == "producir") { translation = "to produce" }
        else if (infinitive == "programar") { translation = "to program" }
        else if (infinitive == "progresar") { translation = "to progress" }
        else if (infinitive == "prohibir") { translation = "to prohibit" }
        else if (infinitive == "prolongar") { translation = "to prolong" }
        else if (infinitive == "prometer") { translation = "to promise" }
        else if (infinitive == "promover") { translation = "to promote" }
        else if (infinitive == "promulgar") { translation = "to promulgate" }
        else if (infinitive == "pronunciar") { translation = "to pronounce" }
        else if (infinitive == "proporcionar") { translation = "to proportion" }
        else if (infinitive == "proteger") { translation = "to protect" }
        else if (infinitive == "protestar") { translation = "to protest" }
        else if (infinitive == "proveer") { translation = "to provide" }
        else if (infinitive == "provocar") { translation = "to provoke" }
        else if (infinitive == "proyectar") { translation = "to project" }
        else if (infinitive == "publicar") { translation = "to publish" }
        else if (infinitive == "pudrir") { translation = "to rot" }
        else if (infinitive == "pulir") { translation = "to polish" }
        else if (infinitive == "pulsar") { translation = "to pulsate" }
        else if (infinitive == "purificar") { translation = "to purify" }
        else if (infinitive == "quebrar") { translation = "to break" }
        else if (infinitive == "quedar") { translation = "to stay" }
        else if (infinitive == "quejar") { translation = "to complain" }
        else if (infinitive == "quemar") { translation = "to burn" }
        else if (infinitive == "querer") { translation = "to want" }
        else if (infinitive == "quitar") { translation = "to take away" }
        else if (infinitive == "rasgar") { translation = "to rip" }
        else if (infinitive == "recibir") { translation = "to receive" }
        else if (infinitive == "recoger") { translation = "to pick up" }
        else if (infinitive == "recomendar") { translation = "to recommend" }
        else if (infinitive == "reducir") { translation = "to reduce" }
        else if (infinitive == "referir") { translation = "to refer" }
        else if (infinitive == "regañar") { translation = "to nag" }
        else if (infinitive == "regatear") { translation = "to barter" }
        else if (infinitive == "regresar") { translation = "to return" }
        else if (infinitive == "reír") { translation = "to laugh" }
        else if (infinitive == "rentar") { translation = "to rent" }
        else if (infinitive == "reparar") { translation = "to repair" }
        else if (infinitive == "repatriar") { translation = "to repatriate" }
        else if (infinitive == "resfriar") { translation = "to cool" }
        else if (infinitive == "respetar") { translation = "to respect" }
        else if (infinitive == "resultar") { translation = "to result" }
        else if (infinitive == "rociar") { translation = "to sprinkle" }
        else if (infinitive == "romper") { translation = "to break" }
        else if (infinitive == "roncar") { translation = "to snore" }
        else if (infinitive == "saber") { translation = "to know" }
        else if (infinitive == "sacar") { translation = "to take out" }
        else if (infinitive == "sacudir") { translation = "to shake off" }
        else if (infinitive == "salir") { translation = "to leave" }
        else if (infinitive == "saludar") { translation = "to greet" }
        else if (infinitive == "satisfacer") { translation = "to satisfy" }
        else if (infinitive == "secar") { translation = "to dry" }
        else if (infinitive == "seguir") { translation = "to follow" }
        else if (infinitive == "señalar") { translation = "to signal" }
        else if (infinitive == "ser") { translation = "to be" }
        else if (infinitive == "servir") { translation = "to serve" }
        else if (infinitive == "sonar") { translation = "to sound" }
        else if (infinitive == "soñar") { translation = "to dream" }
        else if (infinitive == "sonreír") { translation = "to smile" }
        else if (infinitive == "sorprender") { translation = "to surprise" }
        else if (infinitive == "sostener") { translation = "to sustain" }
        else if (infinitive == "subir") { translation = "to rise" }
        else if (infinitive == "suponer") { translation = "to suppose" }
        else if (infinitive == "sentir") { translation = "to feel" }
        else if (infinitive == "sustituir") { translation = "to substitute" }
        else if (infinitive == "tejer") { translation = "to braid" }
        else if (infinitive == "telegrafiar") { translation = "to telegraph" }
        else if (infinitive == "temblar") { translation = "to tremble" }
        else if (infinitive == "temer") { translation = "to fear" }
        else if (infinitive == "tender") { translation = "to extend" }
        else if (infinitive == "tener") { translation = "to have" }
        else if (infinitive == "tentar") { translation = "to tempt" }
        else if (infinitive == "terminar") { translation = "to terminate" }
        else if (infinitive == "testigar") { translation = "to testify" }
        else if (infinitive == "tirar") { translation = "to throw" }
        else if (infinitive == "tocar") { translation = "to play (instrument)" }
        else if (infinitive == "tolerar") { translation = "to tolerate" }
        else if (infinitive == "tomar") { translation = "to take" }
        else if (infinitive == "torcer") { translation = "to twist" }
        else if (infinitive == "toser") { translation = "to cough" }
        else if (infinitive == "trabajar") { translation = "to work" }
        else if (infinitive == "traducir") { translation = "to translate" }
        else if (infinitive == "traer") { translation = "to bring" }
        else if (infinitive == "tragar") { translation = "to swallow" }
        else if (infinitive == "traicionar") { translation = "to betray" }
        else if (infinitive == "trancar") { translation = "to lock" }
        else if (infinitive == "transcribir") { translation = "to transcribe" }
        else if (infinitive == "transferir") { translation = "to transfer" }
        else if (infinitive == "transformar") { translation = "to transform" }
        else if (infinitive == "transmitir") { translation = "to transmit" }
        else if (infinitive == "transportar") { translation = "to transport" }
        else if (infinitive == "trasladar") { translation = "to move" }
        else if (infinitive == "tratar") { translation = "to try" }
        else if (infinitive == "triunfar") { translation = "to triumph" }
        else if (infinitive == "tropezar") { translation = "to trip" }
        else if (infinitive == "ubicar") { translation = "to be located" }
        else if (infinitive == "unir") { translation = "to unite" }
        else if (infinitive == "untar") { translation = "to bribe" }
        else if (infinitive == "usar") { translation = "to use" }
        else if (infinitive == "utilizar") { translation = "to utilize" }
        else if (infinitive == "vaciar") { translation = "to empty" }
        else if (infinitive == "valer") { translation = "to be worth something" }
        else if (infinitive == "variar") { translation = "to very" }
        else if (infinitive == "vender") { translation = "to sell" }
        else if (infinitive == "venir") { translation = "to come" }
        else if (infinitive == "ver") { translation = "to see" }
        else if (infinitive == "verificar") { translation = "to verify" }
        else if (infinitive == "vestir") { translation = "to dress" }
        else if (infinitive == "viajar") { translation = "to travel" }
        else if (infinitive == "vibrar") { translation = "to vibrate" }
        else if (infinitive == "vigilar") { translation = "to watch over" }
        else if (infinitive == "vincular") { translation = "to conquer" }
        else if (infinitive == "violar") { translation = "to violate" }
        else if (infinitive == "visitar") { translation = "to visit" }
        else if (infinitive == "vivir") { translation = "to live" }
        else if (infinitive == "volar") { translation = "to fly" }
        else if (infinitive == "voltear") { translation = "to turn" }
        else if (infinitive == "volver") { translation = "to return" }
        else if (infinitive == "vomitar") { translation = "to vomit" }
        else if (infinitive == "votar") { translation = "to vote" }
        else if (infinitive == "yacer") { translation = "to be situated" }
        else if (infinitive == "yodurar") { translation = "to iodize" }
        else if (infinitive == "yuxtaponer") { translation = "to juxtapose" }
        else if (infinitive == "zapatear") { translation = "to kick" }
        else if (infinitive == "zonar") { translation = "to whirr" }
        else if (infinitive == "zurriar") { translation = "to buzz" }
        else if (infinitive == "perseguir") { translation = "to pursue" }
        else if (infinitive == "repetir") { translation = "to repeat" }
        else if (infinitive == "sugerir") { translation = "to suggest" }
        else if (infinitive == "predecir") { translation = "to predict" }
        else if (infinitive == "acarrear") { translation = "to carry" }
        else if (infinitive == "detraer") { translation = "to detract" }
        else if (infinitive == "reflejar") { translation = "to reflect" }
        else if (infinitive == "caber") { translation = "to fit" }
        else if (infinitive == "aclarar") { translation = "to clarify" }
        else { translation = " " }
    }

    func getPastParticiple() {
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

    func getGerund() {
        
        if (stemChangeGerunds.contains(infinitive)) {
            isIrregularGerund = true
        } else {
            isIrregularGerund = false
        }
        
        if (isEndingAr && !isIrregularGerund) {
            gerund = infinitive.replacingOccurrences(of: "ar", with: "ando")
        } else if (isEndingEr && !isIrregularGerund) {
            if (infinitive.hasSuffix("aer")) {
                gerund = infinitive.replacingOccurrences(of: "er", with: "yendo")
            } else if (infinitive.hasSuffix("eer")) {
                gerund = infinitive.replacingOccurrences(of: "er", with: "yendo")
            } else if (infinitive.hasSuffix("ñer")) {
                gerund = infinitive.replacingOccurrences(of: "er", with: "endo")
            } else {
                gerund = infinitive.replacingOccurrences(of: "er", with: "iendo")
            }
        } else if (isEndingIr && !isIrregularGerund) {
            if (infinitive.hasSuffix("ñir")) {
                gerund = infinitive.replacingOccurrences(of: "ir", with: "endo")
            } else if (infinitive.hasSuffix("llir")) {
                gerund = infinitive.replacingOccurrences(of: "ir", with: "endo")
            } else if (infinitive == "ir") {
                gerund = "yendo"
            } else if (infinitive.hasSuffix("uir")) {
                gerund = infinitive.replacingOccurrences(of: "ir", with: "yendo")
            } else if (infinitive.hasSuffix("ír")) {
                gerund = infinitive.replacingOccurrences(of: "ír", with: "íendo")
            } else {
                gerund = infinitive.replacingOccurrences(of: "ir", with: "iendo")
            }
        } else if (isIrregularGerund) {
            if (infinitive == "advertir") {
                gerund = "advirtiendo"
            } else if (infinitive == "competir") {
                gerund = "compititendo"
            } else if (infinitive == "conseguir") {
                gerund = "consiguiendo"
            } else if (infinitive == "consentir") {
                gerund = "consintiendo"
            } else if (infinitive == "convertir") {
                gerund = "convirtiendo"
            } else if (infinitive == "decir") {
                gerund = "diciendo"
            } else if (infinitive == "hervir") {
                gerund = "hirviendo"
            } else if (infinitive == "mentir") {
                gerund = "mintiendo"
            } else if (infinitive == "pedir") {
                gerund = "pidiendo"
            } else if (infinitive == "reñir") {
                gerund = "riñendo"
            } else if (infinitive == "repetir") {
                gerund = "repitiendo"
            } else if (infinitive == "seguir") {
                gerund = "siguiendo"
            } else if (infinitive == "servir") {
                gerund = "sirviendo"
            } else if (infinitive == "sugerir") {
                gerund = "sugiriendo"
            } else if (infinitive == "venir") {
                gerund = "viniendo"
            } else if (infinitive == "poder") {
                gerund = "pudiendo"
            } else if (infinitive == "dormir") {
                gerund = "durmiendo"
            } else if (infinitive == "morir") {
                gerund = "muriendo"
            } else if (infinitive == "querer") {
                gerund = "queriendo"
            }
        } else {
            gerund = " "
        }
    }

    func replaceWithMoreThanOneEnding1() {

        var infinitive1 = infinitive

        if isEndingAr {

            if let range = infinitive1?.range(of: "ar", options: NSString.CompareOptions.backwards) {
                infinitive1.replaceSubrange(range, with: "bby")
            }

            pastParticiple = infinitive1?.replacingOccurrences(of: "bby", with: "ado")

        } else if isEndingEr {

            if let range = infinitive1?.range(of: "er", options: NSString.CompareOptions.backwards) {
                infinitive1.replaceSubrange(range, with: "bby")
            }

            pastParticiple = infinitive1?.replacingOccurrences(of: "bby", with: "ido")

        } else if isEndingIr {
            if let range = infinitive1?.range(of: "ir", options: NSString.CompareOptions.backwards) {
                infinitive1.replaceSubrange(range, with: "bby")
            }

            pastParticiple = infinitive1?.replacingOccurrences(of: "bby", with: "ido")

        } else {
            pastParticiple = " "
        }
    }

    func replaceWithMoreThanOneEnding2() {

        var infinitive2 = infinitive

        if isEndingAr {

            if let range = infinitive2?.range(of: "ar", options: NSString.CompareOptions.backwards) {
                infinitive2.replaceSubrange(range, with: "bby")
            }

            gerund = infinitive2?.replacingOccurrences(of: "bby", with: "ando")

        } else if isEndingEr {

            if let range = infinitive2?.range(of: "er", options: NSString.CompareOptions.backwards) {
                infinitive2.replaceSubrange(range, with: "bby")
            }

            gerund = infinitive2?.replacingOccurrences(of: "bby", with: "iendo")

        } else if isEndingIr {
            if let range = infinitive2?.range(of: "ir", options: NSString.CompareOptions.backwards) {
                infinitive2.replaceSubrange(range, with: "bby")
            }

            gerund = infinitive2?.replacingOccurrences(of: "bby", with: "iendo")

        } else {
            gerund = " "
        }
    }
}
