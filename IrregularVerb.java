package com.wsandhu.conjugation;

/**
 * Created by wasimsandhu on 9/28/14.
 * FOR ANYONE CURRENTLY VIEWING THIS CLASS,
 * I personally apologize for my sloppiness and laziness.
 * Someday, all of these hard-coded strings will be cleaned up.
 * Maybe.
 */
public class IrregularVerb {

    // String[] irregularVerbs = {"ir", "ser", "estar", "dar", "saber", "conocer", "hacer", "traer", "poner",
    // "ver", "salir", "conducir", "haber", "poder", "querer", "venir", "decir", "tener"};

    static String stemChangedVerb;
    static boolean hasSpellingChange;

    public static void conjugate() {

        // Present tense irregular verbs
        if (MainFragment.verbTense == 0) {
            // Irregular yo endings
            if (MainFragment.isIrregularYoVerb) {
                conjugateIrregularYoVerb();
            }

            if (MainFragment.infinitive.equals("ir")) {
                MainFragment.conjugationYo = "voy";
                MainFragment.conjugationTu = "vas";
                MainFragment.conjugationEl = "va";
                MainFragment.conjugationNos = "vamos";
                MainFragment.conjugationOs = "vais";
                MainFragment.conjugationEllos = "van";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.conjugationYo = "soy";
                MainFragment.conjugationTu = "eres";
                MainFragment.conjugationEl = "es";
                MainFragment.conjugationNos = "somos";
                MainFragment.conjugationOs = "sois";
                MainFragment.conjugationEllos = "son";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.conjugationYo = "estoy";
                MainFragment.conjugationTu = "estás";
                MainFragment.conjugationEl = "está";
                MainFragment.conjugationNos = "estamos";
                MainFragment.conjugationOs = "estáis";
                MainFragment.conjugationEllos = "están";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.conjugationYo = "doy";
                MainFragment.conjugationTu = "das";
                MainFragment.conjugationEl = "da";
                MainFragment.conjugationNos = "damos";
                MainFragment.conjugationOs = "dais";
                MainFragment.conjugationEllos = "dan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("saber")) {
                MainFragment.conjugationYo = "sé";
                MainFragment.conjugationTu = "sabes";
                MainFragment.conjugationEl = "sabe";
                MainFragment.conjugationNos = "sabemos";
                MainFragment.conjugationOs = "sabéis";
                MainFragment.conjugationEllos = "saben";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conocer")) {

                MainFragment.conjugationTu = "conoces";
                MainFragment.conjugationEl = "conoce";
                MainFragment.conjugationNos = "conocemos";
                MainFragment.conjugationOs = "conocéis";
                MainFragment.conjugationEllos = "conocen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {

                MainFragment.conjugationTu = "haces";
                MainFragment.conjugationEl = "hace";
                MainFragment.conjugationNos = "hacemos";
                MainFragment.conjugationOs = "hacéis";
                MainFragment.conjugationEllos = "hacen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("traer")) {

                MainFragment.conjugationTu = "traes";
                MainFragment.conjugationEl = "trae";
                MainFragment.conjugationNos = "traemos";
                MainFragment.conjugationOs = "traéis";
                MainFragment.conjugationEllos = "traen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {

                MainFragment.conjugationTu = "pones";
                MainFragment.conjugationEl = "pone";
                MainFragment.conjugationNos = "ponemos";
                MainFragment.conjugationOs = "ponéis";
                MainFragment.conjugationEllos = "ponen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.conjugationYo = "veo";
                MainFragment.conjugationTu = "ves";
                MainFragment.conjugationEl = "ve";
                MainFragment.conjugationNos = "vemos";
                MainFragment.conjugationOs = "véis";
                MainFragment.conjugationEllos = "ven";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {

                MainFragment.conjugationTu = "sales";
                MainFragment.conjugationEl = "sale";
                MainFragment.conjugationNos = "salemos";
                MainFragment.conjugationOs = "salís";
                MainFragment.conjugationEllos = "salen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {

                MainFragment.conjugationTu = "conduces";
                MainFragment.conjugationEl = "conduce";
                MainFragment.conjugationNos = "conducimos";
                MainFragment.conjugationOs = "conducís";
                MainFragment.conjugationEllos = "conducen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.conjugationYo = "puedo";
                MainFragment.conjugationTu = "puedes";
                MainFragment.conjugationEl = "puede";
                MainFragment.conjugationNos = "podemos";
                MainFragment.conjugationOs = "podéis";
                MainFragment.conjugationEllos = "pueden";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.conjugationYo = "quiero";
                MainFragment.conjugationTu = "quieres";
                MainFragment.conjugationEl = "quiere";
                MainFragment.conjugationNos = "queremos";
                MainFragment.conjugationOs = "queréis";
                MainFragment.conjugationEllos = "quieren";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {

                MainFragment.conjugationTu = "tienes";
                MainFragment.conjugationEl = "tiene";
                MainFragment.conjugationNos = "tenemos";
                MainFragment.conjugationOs = "tenéis";
                MainFragment.conjugationEllos = "tienen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("decir")) {

                MainFragment.conjugationTu = "dices";
                MainFragment.conjugationEl = "dice";
                MainFragment.conjugationNos = "decimos";
                MainFragment.conjugationOs = "decís";
                MainFragment.conjugationEllos = "dicen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {

                MainFragment.conjugationTu = "vienes";
                MainFragment.conjugationEl = "viene";
                MainFragment.conjugationNos = "venimos";
                MainFragment.conjugationOs = "venís";
                MainFragment.conjugationEllos = "vienen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("haber")) {
                MainFragment.conjugationYo = "he";
                MainFragment.conjugationTu = "has";
                MainFragment.conjugationEl = "ha";
                MainFragment.conjugationNos = "hemos";
                MainFragment.conjugationOs = "habéis";
                MainFragment.conjugationEllos = "han";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("oír")) {

                MainFragment.conjugationTu = "oyes";
                MainFragment.conjugationEl = "oye";
                MainFragment.conjugationNos = "oímos";
                MainFragment.conjugationOs = "oís";
                MainFragment.conjugationEllos = "oyen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("freír")) {
                MainFragment.conjugationYo = "frío";
                MainFragment.conjugationTu = "fríes";
                MainFragment.conjugationEl = "fríe";
                MainFragment.conjugationNos = "freímos";
                MainFragment.conjugationOs = "freís";
                MainFragment.conjugationEllos = "fríen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("reír")) {
                MainFragment.conjugationYo = "río";
                MainFragment.conjugationTu = "ríes";
                MainFragment.conjugationEl = "ríe";
                MainFragment.conjugationNos = "reímos";
                MainFragment.conjugationOs = "reís";
                MainFragment.conjugationEllos = "ríen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("sonreír")) {
                MainFragment.conjugationYo = "sonrío";
                MainFragment.conjugationTu = "sonríes";
                MainFragment.conjugationEl = "sonríe";
                MainFragment.conjugationNos = "sonreímos";
                MainFragment.conjugationOs = "sonreís";
                MainFragment.conjugationEllos = "sonríen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("caer")) {

                MainFragment.conjugationTu = "caes";
                MainFragment.conjugationEl = "cae";
                MainFragment.conjugationNos = "caemos";
                MainFragment.conjugationOs = "caéis";
                MainFragment.conjugationEllos = "caen";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("servir")) {
                MainFragment.conjugationYo = "sirvo";
                MainFragment.conjugationTu = "sirves";
                MainFragment.conjugationEl = "sirve";
                MainFragment.conjugationNos = "servimos";
                MainFragment.conjugationOs = "servís";
                MainFragment.conjugationEllos = "sirven";
                MainFragment.setText();
            }
            // Preterite tense irregular verbs
        } else if (MainFragment.verbTense == 1) {
            if (MainFragment.infinitive.equals("ir")) {
                MainFragment.conjugationYo = "fui";
                MainFragment.conjugationTu = "fuiste";
                MainFragment.conjugationEl = "fue";
                MainFragment.conjugationNos = "fuimos";
                MainFragment.conjugationOs = "fuisteis";
                MainFragment.conjugationEllos = "fueron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.conjugationYo = "fui";
                MainFragment.conjugationTu = "fuiste";
                MainFragment.conjugationEl = "fue";
                MainFragment.conjugationNos = "fuimos";
                MainFragment.conjugationOs = "fuisteis";
                MainFragment.conjugationEllos = "fueron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.conjugationYo = "estuve";
                MainFragment.conjugationTu = "estuviste";
                MainFragment.conjugationEl = "estuvo";
                MainFragment.conjugationNos = "estuvimos";
                MainFragment.conjugationOs = "estuvisteis";
                MainFragment.conjugationEllos = "estuvieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.conjugationYo = "di";
                MainFragment.conjugationTu = "diste";
                MainFragment.conjugationEl = "dio";
                MainFragment.conjugationNos = "dimos";
                MainFragment.conjugationOs = "disteis";
                MainFragment.conjugationEllos = "dieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("saber")) {
                MainFragment.conjugationYo = "supe";
                MainFragment.conjugationTu = "supiste";
                MainFragment.conjugationEl = "supo";
                MainFragment.conjugationNos = "supimos";
                MainFragment.conjugationOs = "supisteis";
                MainFragment.conjugationEllos = "supieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conocer")) {
                MainFragment.conjugationYo = "conocí";
                MainFragment.conjugationTu = "conociste";
                MainFragment.conjugationEl = "conoció";
                MainFragment.conjugationNos = "conocimos";
                MainFragment.conjugationOs = "conocisteis";
                MainFragment.conjugationEllos = "conocieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.conjugationYo = "hice";
                MainFragment.conjugationTu = "hiciste";
                MainFragment.conjugationEl = "hizo";
                MainFragment.conjugationNos = "hicimos";
                MainFragment.conjugationOs = "hicisteis";
                MainFragment.conjugationEllos = "hicieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("traer")) {
                MainFragment.conjugationYo = "traje";
                MainFragment.conjugationTu = "trajiste";
                MainFragment.conjugationEl = "trajo";
                MainFragment.conjugationNos = "trajimos";
                MainFragment.conjugationOs = "trajisteis";
                MainFragment.conjugationEllos = "trajeron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.conjugationYo = "puse";
                MainFragment.conjugationTu = "pusiste";
                MainFragment.conjugationEl = "puso";
                MainFragment.conjugationNos = "pusimos";
                MainFragment.conjugationOs = "pusisteis";
                MainFragment.conjugationEllos = "pusieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.conjugationYo = "ví";
                MainFragment.conjugationTu = "viste";
                MainFragment.conjugationEl = "vió";
                MainFragment.conjugationNos = "vimos";
                MainFragment.conjugationOs = "visteis";
                MainFragment.conjugationEllos = "vieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.conjugationYo = "salí";
                MainFragment.conjugationTu = "saliste";
                MainFragment.conjugationEl = "salió";
                MainFragment.conjugationNos = "salimos";
                MainFragment.conjugationOs = "salisteis";
                MainFragment.conjugationEllos = "salieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {
                MainFragment.conjugationYo = "conduje";
                MainFragment.conjugationTu = "condujiste";
                MainFragment.conjugationEl = "condujo";
                MainFragment.conjugationNos = "condujimos";
                MainFragment.conjugationOs = "condujisteis";
                MainFragment.conjugationEllos = "condujeron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("haber")) {
                MainFragment.conjugationYo = "hube";
                MainFragment.conjugationTu = "hubiste";
                MainFragment.conjugationEl = "hubo";
                MainFragment.conjugationNos = "hubimos";
                MainFragment.conjugationOs = "hubisteis";
                MainFragment.conjugationEllos = "hubieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.conjugationYo = "pude";
                MainFragment.conjugationTu = "pudiste";
                MainFragment.conjugationEl = "pudo";
                MainFragment.conjugationNos = "pudimos";
                MainFragment.conjugationOs = "pudisteis";
                MainFragment.conjugationEllos = "pudieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.conjugationYo = "quise";
                MainFragment.conjugationTu = "quisiste";
                MainFragment.conjugationEl = "quiso";
                MainFragment.conjugationNos = "quisimos";
                MainFragment.conjugationOs = "quisisteis";
                MainFragment.conjugationEllos = "quisieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.conjugationYo = "tuve";
                MainFragment.conjugationTu = "tuviste";
                MainFragment.conjugationEl = "tuvo";
                MainFragment.conjugationNos = "tuvimos";
                MainFragment.conjugationOs = "tuvisteis";
                MainFragment.conjugationEllos = "tuvieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.conjugationYo = "vine";
                MainFragment.conjugationTu = "viniste";
                MainFragment.conjugationEl = "vino";
                MainFragment.conjugationNos = "vinimos";
                MainFragment.conjugationOs = "visteis";
                MainFragment.conjugationEllos = "vinieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("decir")) {
                MainFragment.conjugationYo = "dije";
                MainFragment.conjugationTu = "dijiste";
                MainFragment.conjugationEl = "dijo";
                MainFragment.conjugationNos = "dijimos";
                MainFragment.conjugationOs = "dijisteis";
                MainFragment.conjugationEllos = "dijeron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("oír")) {
                MainFragment.conjugationYo = "oí";
                MainFragment.conjugationTu = "oíste";
                MainFragment.conjugationEl = "oyó";
                MainFragment.conjugationNos = "oímos";
                MainFragment.conjugationOs = "oísteis";
                MainFragment.conjugationEllos = "oyeron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("freír")) {
                MainFragment.conjugationYo = "freí";
                MainFragment.conjugationTu = "freíste";
                MainFragment.conjugationEl = "frió";
                MainFragment.conjugationNos = "freímos";
                MainFragment.conjugationOs = "freísteis";
                MainFragment.conjugationEllos = "frieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("reír")) {
                MainFragment.conjugationYo = "reí";
                MainFragment.conjugationTu = "reíste";
                MainFragment.conjugationEl = "rió";
                MainFragment.conjugationNos = "reímos";
                MainFragment.conjugationOs = "reísteis";
                MainFragment.conjugationEllos = "rieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("sonreír")) {
                MainFragment.conjugationYo = "sonreí";
                MainFragment.conjugationTu = "sonreíste";
                MainFragment.conjugationEl = "sonrió";
                MainFragment.conjugationNos = "sonreímos";
                MainFragment.conjugationOs = "sonreísteis";
                MainFragment.conjugationEllos = "sonrieron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("caer")) {
                MainFragment.conjugationYo = "caí";
                MainFragment.conjugationTu = "caíste";
                MainFragment.conjugationEl = "cayó";
                MainFragment.conjugationNos = "caímos";
                MainFragment.conjugationOs = "caísteis";
                MainFragment.conjugationEllos = "cayeron";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("servir")) {
                MainFragment.conjugationYo = "serví";
                MainFragment.conjugationTu = "serviste";
                MainFragment.conjugationEl = "sirvió";
                MainFragment.conjugationNos = "servimos";
                MainFragment.conjugationOs = "servisteis";
                MainFragment.conjugationEllos = "sirvieron";
                MainFragment.setText();
            }
            // Imperfect tense irregular verbs
        } else if (MainFragment.verbTense == 2) {
            if (MainFragment.infinitive.equals("ir")) {
                MainFragment.conjugationYo = "iba";
                MainFragment.conjugationTu = "ibas";
                MainFragment.conjugationEl = "iba";
                MainFragment.conjugationNos = "íbamos";
                MainFragment.conjugationOs = "ibais";
                MainFragment.conjugationEllos = "iban";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.conjugationYo = "era";
                MainFragment.conjugationTu = "eras";
                MainFragment.conjugationEl = "era";
                MainFragment.conjugationNos = "éramos";
                MainFragment.conjugationOs = "erais";
                MainFragment.conjugationEllos = "eran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.conjugationYo = "veía";
                MainFragment.conjugationTu = "veías";
                MainFragment.conjugationEl = "veía";
                MainFragment.conjugationNos = "veíamos";
                MainFragment.conjugationOs = "veíais";
                MainFragment.conjugationEllos = "veían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("oír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugationYo = MainFragment.infinitive.replace("ir", "ía");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("ir", "ías");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("ir", "ía");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("ir", "íamos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("ir", "íais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("ir", "ían");
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("freír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugationYo = MainFragment.infinitive.replace("ir", "ía");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("ir", "ías");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("ir", "ía");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("ir", "íamos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("ir", "íais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("ir", "ían");
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("reír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugationYo = MainFragment.infinitive.replace("ir", "ía");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("ir", "ías");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("ir", "ía");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("ir", "íamos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("ir", "íais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("ir", "ían");
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("sonreír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugationYo = MainFragment.infinitive.replace("ir", "ía");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("ir", "ías");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("ir", "ía");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("ir", "íamos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("ir", "íais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("ir", "ían");
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.conjugationYo = MainFragment.infinitive.replace("querer", "quería");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("querer", "querías");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("querer", "quería");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("querer", "queríamos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("querer", "queríais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("querer", "querían");
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("servir")) {
                MainFragment.conjugationYo = "servía";
                MainFragment.conjugationTu = "servías";
                MainFragment.conjugationEl = "servía";
                MainFragment.conjugationNos = "servíamos";
                MainFragment.conjugationOs = "servíais";
                MainFragment.conjugationEllos = "servían";
                MainFragment.setText();
            } else {
                if (MainFragment.isEndingAr) {
                    MainFragment.conjugateArVerbImperfect();
                } else {
                    MainFragment.conjugateErIrVerbImperfect();
                }
            }
            // Future tense irregular verbs
        } else if (MainFragment.verbTense == 3) {
            if (MainFragment.infinitive.equals("haber")) {
                MainFragment.infinitive = "habr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.infinitive = "podr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.infinitive = "querr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("saber")) {
                MainFragment.infinitive = "sabr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.infinitive = "pondr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.infinitive = "saldr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.infinitive = "tendr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.infinitive = "vendr";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("decir")) {
                MainFragment.infinitive = "dir";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.infinitive = "har";
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("oír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("freír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("reír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("sonreír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugateVerbFuture();
            } else if (MainFragment.infinitive.equals("servir")) {
                MainFragment.conjugationYo = "serviré";
                MainFragment.conjugationTu = "servirás";
                MainFragment.conjugationEl = "servirá";
                MainFragment.conjugationNos = "serviremos";
                MainFragment.conjugationOs = "serviréis";
                MainFragment.conjugationEllos = "servirán";
                MainFragment.setText();
            } else {
                MainFragment.conjugateVerbFuture();
            } // Affirmative commands
        } else if (MainFragment.verbTense == 4) {
            if (MainFragment.infinitive.equals("decir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "di";
                MainFragment.conjugationEl = "diga";
                MainFragment.conjugationNos = "digamos";
                MainFragment.conjugationEllos = "digan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "haz";
                MainFragment.conjugationEl = "haga";
                MainFragment.conjugationNos = "hagamos";
                MainFragment.conjugationEllos = "hagan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "ve";
                MainFragment.conjugationEl = "vaya";
                MainFragment.conjugationNos = "vayamos";
                MainFragment.conjugationEllos = "vayan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "pon";
                MainFragment.conjugationEl = "ponga";
                MainFragment.conjugationNos = "pongamos";
                MainFragment.conjugationEllos = "pongan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "sal";
                MainFragment.conjugationEl = "salga";
                MainFragment.conjugationNos = "salgamos";
                MainFragment.conjugationEllos = "salgan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "sé";
                MainFragment.conjugationEl = "sea";
                MainFragment.conjugationNos = "seamos";
                MainFragment.conjugationEllos = "sean";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "ten";
                MainFragment.conjugationEl = "tenga";
                MainFragment.conjugationNos = "tengamos";
                MainFragment.conjugationEllos = "tengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "ve";
                MainFragment.conjugationEl = "venga";
                MainFragment.conjugationNos = "vengamos";
                MainFragment.conjugationEllos = "vengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "quiere";
                MainFragment.conjugationEl = "quiera";
                MainFragment.conjugationNos = "queramos";
                MainFragment.conjugationEllos = "quieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "conduce";
                MainFragment.conjugationEl = "conduzca";
                MainFragment.conjugationNos = "conduzcamos";
                MainFragment.conjugationEllos = "conduzcan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "está";
                MainFragment.conjugationEl = "esté";
                MainFragment.conjugationNos = "estemos";
                MainFragment.conjugationEllos = "estén";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "da";
                MainFragment.conjugationEl = "dé";
                MainFragment.conjugationNos = "demos";
                MainFragment.conjugationEllos = "den";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("oír")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "oye";
                MainFragment.conjugationEl = "oiga";
                MainFragment.conjugationNos = "oigamos";
                MainFragment.conjugationEllos = "oigan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("freír")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "fríe";
                MainFragment.conjugationEl = "fría";
                MainFragment.conjugationNos = "fríamos";
                MainFragment.conjugationEllos = "frían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("reír")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "ríe";
                MainFragment.conjugationEl = "ría";
                MainFragment.conjugationNos = "ríamos";
                MainFragment.conjugationEllos = "rían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("sonreír")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "sonríe";
                MainFragment.conjugationEl = "sonría";
                MainFragment.conjugationNos = "sonríamos";
                MainFragment.conjugationEllos = "sonrían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("caer")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "cae";
                MainFragment.conjugationEl = "caiga";
                MainFragment.conjugationNos = "caigamos";
                MainFragment.conjugationEllos = "caigan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "ve";
                MainFragment.conjugationEl = "vea";
                MainFragment.conjugationNos = "veamos";
                MainFragment.conjugationEllos = "vean";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "puede";
                MainFragment.conjugationEl = "pueda";
                MainFragment.conjugationNos = "podamos";
                MainFragment.conjugationEllos = "puedan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("servir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "sirve";
                MainFragment.conjugationEl = "sirva";
                MainFragment.conjugationNos = "sirvamos";
                MainFragment.conjugationEllos = "sirvan";
                MainFragment.setText();
            }
            // Negative commands
        } else if (MainFragment.verbTense == 5) {
            if (MainFragment.infinitive.equals("decir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no digas";
                MainFragment.conjugationEl = "no diga";
                MainFragment.conjugationNos = "no digamos";
                MainFragment.conjugationEllos = "no digan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no haz";
                MainFragment.conjugationEl = "no haga";
                MainFragment.conjugationNos = "no hagamos";
                MainFragment.conjugationEllos = "no hagan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no vayas";
                MainFragment.conjugationEl = "no vaya";
                MainFragment.conjugationNos = "no vayamos";
                MainFragment.conjugationEllos = "no vayan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no pongas";
                MainFragment.conjugationEl = "no ponga";
                MainFragment.conjugationNos = "no pongamos";
                MainFragment.conjugationEllos = "no pongan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no salgas";
                MainFragment.conjugationEl = "no salga";
                MainFragment.conjugationNos = "no salgamos";
                MainFragment.conjugationEllos = "no salgan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no seas";
                MainFragment.conjugationEl = "no sea";
                MainFragment.conjugationNos = "no seamos";
                MainFragment.conjugationEllos = "no sean";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no tengas";
                MainFragment.conjugationEl = "no tenga";
                MainFragment.conjugationNos = "no tengamos";
                MainFragment.conjugationEllos = "no tengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no vengas";
                MainFragment.conjugationEl = "no venga";
                MainFragment.conjugationNos = "no vengamos";
                MainFragment.conjugationEllos = "no vengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no quieras";
                MainFragment.conjugationEl = "no quiera";
                MainFragment.conjugationNos = "no queramos";
                MainFragment.conjugationEllos = "no quieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no conduczas";
                MainFragment.conjugationEl = "no conduzca";
                MainFragment.conjugationNos = "no conduzcamos";
                MainFragment.conjugationEllos = "no conduzcan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no estés";
                MainFragment.conjugationEl = "no esté";
                MainFragment.conjugationNos = "no estemos";
                MainFragment.conjugationEllos = "no estén";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no des";
                MainFragment.conjugationEl = "no dé";
                MainFragment.conjugationNos = "no demos";
                MainFragment.conjugationEllos = "no den";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("oír")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no oye";
                MainFragment.conjugationEl = "no oiga";
                MainFragment.conjugationNos = "no oigamos";
                MainFragment.conjugationEllos = "no oigan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("freír")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no fríes";
                MainFragment.conjugationEl = "no fría";
                MainFragment.conjugationNos = "no fríamos";
                MainFragment.conjugationEllos = "no frían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("reír")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no ríes";
                MainFragment.conjugationEl = "no ría";
                MainFragment.conjugationNos = "no ríamos";
                MainFragment.conjugationEllos = "no rían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("sonreír")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no sonrías";
                MainFragment.conjugationEl = "no sonría";
                MainFragment.conjugationNos = "no sonríamos";
                MainFragment.conjugationEllos = "no sonrían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no veas";
                MainFragment.conjugationEl = "no vea";
                MainFragment.conjugationNos = "no veamos";
                MainFragment.conjugationEllos = "no vean";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no puedas";
                MainFragment.conjugationEl = "no pueda";
                MainFragment.conjugationNos = "no podamos";
                MainFragment.conjugationEllos = "no puedan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("servir")) {
                MainFragment.clearText();
                MainFragment.conjugationTu = "no sirvas";
                MainFragment.conjugationEl = "no sirva";
                MainFragment.conjugationNos = "no sirvamos";
                MainFragment.conjugationEllos = "no sirvan";
                MainFragment.setText();
            }
             // Present subjunctive verb conjugations
        } else if (MainFragment.verbTense == 6) {
            if (MainFragment.infinitive.equals("ir")) {
                MainFragment.conjugationYo = "vaya";
                MainFragment.conjugationTu = "vayas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "vayamos";
                MainFragment.conjugationOs = "vayáis";
                MainFragment.conjugationEllos = "vayan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.conjugationYo = "sea";
                MainFragment.conjugationTu = "seas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "seamos";
                MainFragment.conjugationOs = "seáis";
                MainFragment.conjugationEllos = "sean";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.conjugationYo = "esté";
                MainFragment.conjugationTu = "estés";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "estemos";
                MainFragment.conjugationOs = "estéis";
                MainFragment.conjugationEllos = "estén";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.conjugationYo = "dé";
                MainFragment.conjugationTu = "des";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "demos";
                MainFragment.conjugationOs = "deis";
                MainFragment.conjugationEllos = "den";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("saber")) {
                MainFragment.conjugationYo = "sepa";
                MainFragment.conjugationTu = "sepas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "sepamos";
                MainFragment.conjugationOs = "sepáis";
                MainFragment.conjugationEllos = "sepan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conocer")) {
                MainFragment.conjugationYo = "conozca";
                MainFragment.conjugationTu = "conozcas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "conozcamos";
                MainFragment.conjugationOs = "conozcáis";
                MainFragment.conjugationEllos = "conozcan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.conjugationYo = "haga";
                MainFragment.conjugationTu = "hagas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "hagamos";
                MainFragment.conjugationOs = "hagáis";
                MainFragment.conjugationEllos = "hagan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("traer")) {
                MainFragment.conjugationYo = "traiga";
                MainFragment.conjugationTu = "traigas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "traigamos";
                MainFragment.conjugationOs = "traigáis";
                MainFragment.conjugationEllos = "traigan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.conjugationYo = "ponga";
                MainFragment.conjugationTu = "pongas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "pongamos";
                MainFragment.conjugationOs = "pongáis";
                MainFragment.conjugationEllos = "pongan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.conjugationYo = "vea";
                MainFragment.conjugationTu = "veas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "veamos";
                MainFragment.conjugationOs = "veáis";
                MainFragment.conjugationEllos = "vean";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.conjugationYo = "salga";
                MainFragment.conjugationTu = "salgas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "salgamos";
                MainFragment.conjugationOs = "salgáis";
                MainFragment.conjugationEllos = "salgan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {
                MainFragment.conjugationYo = "conduzca";
                MainFragment.conjugationTu = "conduzcas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "conduzcamos";
                MainFragment.conjugationOs = "conduzcáis";
                MainFragment.conjugationEllos = "conduzcan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("haber")) {
                MainFragment.conjugationYo = "haya";
                MainFragment.conjugationTu = "hayas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "hayamos";
                MainFragment.conjugationOs = "hayáis";
                MainFragment.conjugationEllos = "hayan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.conjugationYo = "pueda";
                MainFragment.conjugationTu = "puedas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "podamos";
                MainFragment.conjugationOs = "podáis";
                MainFragment.conjugationEllos = "puedan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.conjugationYo = "quiera";
                MainFragment.conjugationTu = "quieras";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "queramos";
                MainFragment.conjugationOs = "queráis";
                MainFragment.conjugationEllos = "quieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.conjugationYo = "venga";
                MainFragment.conjugationTu = "vengas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "vengamos";
                MainFragment.conjugationOs = "vengáis";
                MainFragment.conjugationEllos = "vengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("decir")) {
                MainFragment.conjugationYo = "diga";
                MainFragment.conjugationTu = "digas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "digamos";
                MainFragment.conjugationOs = "digáis";
                MainFragment.conjugationEllos = "digan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.conjugationYo = "tenga";
                MainFragment.conjugationTu = "tengas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "tengamos";
                MainFragment.conjugationOs = "tengáis";
                MainFragment.conjugationEllos = "tengan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("oír")) {
                MainFragment.conjugationYo = "oiga";
                MainFragment.conjugationTu = "oigas";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "oigamos";
                MainFragment.conjugationOs = "oigáis";
                MainFragment.conjugationEllos = "oigan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("freír")) {
                MainFragment.conjugationYo = "fría";
                MainFragment.conjugationTu = "frías";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "fríamos";
                MainFragment.conjugationOs = "friais";
                MainFragment.conjugationEllos = "frían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("reír")) {
                MainFragment.conjugationYo = "ría";
                MainFragment.conjugationTu = "rías";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "riamos";
                MainFragment.conjugationOs = "riais";
                MainFragment.conjugationEllos = "rían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("sonreír")) {
                MainFragment.conjugationYo = "sonría";
                MainFragment.conjugationTu = "sonrías";
                MainFragment.conjugationEl = MainFragment.conjugationYo;
                MainFragment.conjugationNos = "sonriamos";
                MainFragment.conjugationOs = "sonriáis";
                MainFragment.conjugationEllos = "sonrían";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("caer")) {
                MainFragment.conjugationYo = "caiga";
                MainFragment.conjugationTu = "caigas";
                MainFragment.conjugationEl = "caiga";
                MainFragment.conjugationNos = "caigamos";
                MainFragment.conjugationOs = "caigáis";
                MainFragment.conjugationEllos = "caigan";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("servir")) {
                MainFragment.conjugationYo = "sirva";
                MainFragment.conjugationTu = "sirvas";
                MainFragment.conjugationEl = "sirva";
                MainFragment.conjugationNos = "sirvamos";
                MainFragment.conjugationOs = "sirváis";
                MainFragment.conjugationEllos = "sirvan";
                MainFragment.setText();
            }
            // Imperfect subjunctive verb conjugations
        } else if (MainFragment.verbTense == 7) {
            if (MainFragment.infinitive.equals("ir")) {
                MainFragment.conjugationYo = "fuera";
                MainFragment.conjugationTu = "fueras";
                MainFragment.conjugationEl = "fuera";
                MainFragment.conjugationNos = "fuéramos";
                MainFragment.conjugationOs = "fuerais";
                MainFragment.conjugationEllos = "fueran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ser")) {
                MainFragment.conjugationYo = "fuera";
                MainFragment.conjugationTu = "fueras";
                MainFragment.conjugationEl = "fuera";
                MainFragment.conjugationNos = "fuéramos";
                MainFragment.conjugationOs = "fuerais";
                MainFragment.conjugationEllos = "fueran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("estar")) {
                MainFragment.conjugationYo = "estuviera";
                MainFragment.conjugationTu = "estuvieras";
                MainFragment.conjugationEl = "estuviera";
                MainFragment.conjugationNos = "estuviéramos";
                MainFragment.conjugationOs = "estuvierais";
                MainFragment.conjugationEllos = "estuvieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("dar")) {
                MainFragment.conjugationYo = "diera";
                MainFragment.conjugationTu = "dieras";
                MainFragment.conjugationEl = "diera";
                MainFragment.conjugationNos = "diéramos";
                MainFragment.conjugationOs = "dierais";
                MainFragment.conjugationEllos = "dieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("saber")) {
                MainFragment.conjugationYo = "supiera";
                MainFragment.conjugationTu = "supieras";
                MainFragment.conjugationEl = "supiera";
                MainFragment.conjugationNos = "supiéramos";
                MainFragment.conjugationOs = "supierais";
                MainFragment.conjugationEllos = "supieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conocer")) {
                MainFragment.conjugationYo = "conociera";
                MainFragment.conjugationTu = "conocieras";
                MainFragment.conjugationEl = "conociera";
                MainFragment.conjugationNos = "conociéramos";
                MainFragment.conjugationOs = "conocierais";
                MainFragment.conjugationEllos = "conocieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.conjugationYo = "hiciera";
                MainFragment.conjugationTu = "hicieras";
                MainFragment.conjugationEl = "hiciera";
                MainFragment.conjugationNos = "hiciéramos";
                MainFragment.conjugationOs = "hicierais";
                MainFragment.conjugationEllos = "hicieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("traer")) {
                MainFragment.conjugationYo = "trajera";
                MainFragment.conjugationTu = "trajeras";
                MainFragment.conjugationEl = "trajera";
                MainFragment.conjugationNos = "trajéramos";
                MainFragment.conjugationOs = "trajerais";
                MainFragment.conjugationEllos = "trajeran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.conjugationYo = "pusiera";
                MainFragment.conjugationTu = "pusieras";
                MainFragment.conjugationEl = "pusiera";
                MainFragment.conjugationNos = "pusiéramos";
                MainFragment.conjugationOs = "pusierais";
                MainFragment.conjugationEllos = "pusieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("ver")) {
                MainFragment.conjugationYo = "cupiera";
                MainFragment.conjugationTu = "cupieras";
                MainFragment.conjugationEl = "cupiera";
                MainFragment.conjugationNos = "cupiéramos";
                MainFragment.conjugationOs = "cupierais";
                MainFragment.conjugationEllos = "cupieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.conjugationYo = "saliera";
                MainFragment.conjugationTu = "salieras";
                MainFragment.conjugationEl = "saliera";
                MainFragment.conjugationNos = "saliéramos";
                MainFragment.conjugationOs = "salierais";
                MainFragment.conjugationEllos = "salieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("conducir")) {
                MainFragment.conjugationYo = "condujera";
                MainFragment.conjugationTu = "condujeras";
                MainFragment.conjugationEl = "condujera";
                MainFragment.conjugationNos = "condujéramos";
                MainFragment.conjugationOs = "condujerais";
                MainFragment.conjugationEllos = "condujeran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("haber")) {
                MainFragment.conjugationYo = "hubiera";
                MainFragment.conjugationTu = "hubieras";
                MainFragment.conjugationEl = "hubiera";
                MainFragment.conjugationNos = "hubiéramos";
                MainFragment.conjugationOs = "hubierais";
                MainFragment.conjugationEllos = "hubieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.conjugationYo = "pudiera";
                MainFragment.conjugationTu = "pudieras";
                MainFragment.conjugationEl = "pudiera";
                MainFragment.conjugationNos = "pudiéramos";
                MainFragment.conjugationOs = "pudierais";
                MainFragment.conjugationEllos = "pudieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.conjugationYo = "quisiera";
                MainFragment.conjugationTu = "quisieras";
                MainFragment.conjugationEl = "quisiera";
                MainFragment.conjugationNos = "quisiéramos";
                MainFragment.conjugationOs = "quisierais";
                MainFragment.conjugationEllos = "quisieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.conjugationYo = "tuviera";
                MainFragment.conjugationTu = "tuvieras";
                MainFragment.conjugationEl = "tuviera";
                MainFragment.conjugationNos = "tuviéramos";
                MainFragment.conjugationOs = "tuvierais";
                MainFragment.conjugationEllos = "tuvieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.conjugationYo = "viniera";
                MainFragment.conjugationTu = "vinieras";
                MainFragment.conjugationEl = "viniera";
                MainFragment.conjugationNos = "viniéramos";
                MainFragment.conjugationOs = "vinierais";
                MainFragment.conjugationEllos = "vinieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("decir")) {
                MainFragment.conjugationYo = "dijera";
                MainFragment.conjugationTu = "dijeras";
                MainFragment.conjugationEl = "dijera";
                MainFragment.conjugationNos = "dijéramos";
                MainFragment.conjugationOs = "dijerais";
                MainFragment.conjugationEllos = "dijeran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("oír")) {
                MainFragment.conjugationYo = "oyera";
                MainFragment.conjugationTu = "oyeras";
                MainFragment.conjugationEl = "oyera";
                MainFragment.conjugationNos = "oyéramos";
                MainFragment.conjugationOs = "oyerais";
                MainFragment.conjugationEllos = "oyeran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("freír")) {
                MainFragment.conjugationYo = "friera";
                MainFragment.conjugationTu = "frieras";
                MainFragment.conjugationEl = "friera";
                MainFragment.conjugationNos = "friéramos";
                MainFragment.conjugationOs = "frierais";
                MainFragment.conjugationEllos = "frieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("reír")) {
                MainFragment.conjugationYo = "riera";
                MainFragment.conjugationTu = "rieras";
                MainFragment.conjugationEl = "riera";
                MainFragment.conjugationNos = "riéramos";
                MainFragment.conjugationOs = "rierais";
                MainFragment.conjugationEllos = "rieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("sonreír")) {
                MainFragment.conjugationYo = "sonriera";
                MainFragment.conjugationTu = "sonrieras";
                MainFragment.conjugationEl = "sonriera";
                MainFragment.conjugationNos = "sonriéramos";
                MainFragment.conjugationOs = "sonrierais";
                MainFragment.conjugationEllos = "sonrieran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("caer")) {
                MainFragment.conjugationYo = "cayera";
                MainFragment.conjugationTu = "cayeras";
                MainFragment.conjugationEl = "cayera";
                MainFragment.conjugationNos = "cayéramos";
                MainFragment.conjugationOs = "cayerais";
                MainFragment.conjugationEllos = "cayeran";
                MainFragment.setText();
            } else if (MainFragment.infinitive.equals("servir")) {
                MainFragment.conjugationYo = "sirviera";
                MainFragment.conjugationTu = "sirvieras";
                MainFragment.conjugationEl = "sirviera";
                MainFragment.conjugationNos = "sirviéramos";
                MainFragment.conjugationOs = "sirvierais";
                MainFragment.conjugationEllos = "sirvieran";
                MainFragment.setText();
            }
            // Conditional tense verb conjugations
        } else if (MainFragment.verbTense == 8) {
            if (MainFragment.infinitive.equals("haber")) {
                MainFragment.infinitive = "habr";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("poder")) {
                MainFragment.infinitive = "podr";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("querer")) {
                MainFragment.infinitive = "querr";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("saber")) {
                MainFragment.infinitive = "sabr";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("poner")) {
                MainFragment.infinitive = "pondr";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("salir")) {
                MainFragment.infinitive = "saldr";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("tener")) {
                MainFragment.infinitive = "tendr";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("venir")) {
                MainFragment.infinitive = "vendr";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("decir")) {
                MainFragment.infinitive = "dir";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("hacer")) {
                MainFragment.infinitive = "har";
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("oír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("freír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("reír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("sonreír")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ír", "ir");
                MainFragment.conjugateVerbConditional();
            } else if (MainFragment.infinitive.equals("servir")) {
                MainFragment.conjugationYo = "serviría";
                MainFragment.conjugationTu = "servirías";
                MainFragment.conjugationEl = "serviría";
                MainFragment.conjugationNos = "serviríamos";
                MainFragment.conjugationOs = "serviríais";
                MainFragment.conjugationEllos = "servirían";
                MainFragment.setText();
            } else {
                MainFragment.conjugateVerbConditional();
            }
        }
    }

    public static void conjugateIrregularYoVerb() {
        if (MainFragment.infinitive.equals("hacer")) {
            MainFragment.conjugationYo = "hago";
        } else if (MainFragment.infinitive.equals("oír")) {
            MainFragment.conjugationYo = "oigo";
        } else if (MainFragment.infinitive.equals("traer")) {
            MainFragment.conjugationYo = "traigo";
        } else if (MainFragment.infinitive.equals("caer")) {
            MainFragment.conjugationYo = "caigo";
        } else if (MainFragment.infinitive.equals("decir")) {
            MainFragment.conjugationYo = "digo";
        } else if (MainFragment.infinitive.equals("conducir")) {
            MainFragment.conjugationYo = "conduzco";
        } else if (MainFragment.infinitive.equals("conocer")) {
            MainFragment.conjugationYo = "conozco";
        } else if (MainFragment.isEndingEr) {
            MainFragment.conjugationYo = MainFragment.infinitive.replace("er", "go");
        } else if (MainFragment.isEndingIr) {
            MainFragment.conjugationYo = MainFragment.infinitive.replace("ir", "go");
        }
    }

    public static void makePastParticiple() {
        if (PerfectFragment.infinitive.equals("abrir")) {
            PerfectFragment.pastParticiple = "abierto";
        } else if (PerfectFragment.infinitive.equals("decir")) {
            PerfectFragment.pastParticiple = "dicho";
        } else if (PerfectFragment.infinitive.equals("poner")) {
            PerfectFragment.pastParticiple = "puesto";
        } else if (PerfectFragment.infinitive.equals("freír")) {
            PerfectFragment.pastParticiple = "frito";
        } else if (PerfectFragment.infinitive.equals("hacer")) {
            PerfectFragment.pastParticiple = "hecho";
        } else if (PerfectFragment.infinitive.equals("imprimir")) {
            PerfectFragment.pastParticiple = "impreso";
        } else if (PerfectFragment.infinitive.equals("ir")) {
            PerfectFragment.pastParticiple = "ido";
        } else if (PerfectFragment.infinitive.equals("morir")) {
            PerfectFragment.pastParticiple = "muerto";
        } else if (PerfectFragment.infinitive.equals("escribir")) {
            PerfectFragment.pastParticiple = "escrito";
        } else if (PerfectFragment.infinitive.equals("romper")) {
            PerfectFragment.pastParticiple = "roto";
        } else if (PerfectFragment.infinitive.equals("ver")) {
            PerfectFragment.pastParticiple = "visto";
        } else if (PerfectFragment.infinitive.equals("volver")) {
            PerfectFragment.pastParticiple = "vuelto";
        } else if (PerfectFragment.infinitive.equals("resolver")) {
            PerfectFragment.pastParticiple = "resuelto";
        } else if (PerfectFragment.infinitive.equals("cubrir")) {
            PerfectFragment.pastParticiple = "cubierto";
        } else if (PerfectFragment.infinitive.equals("descubrir")) {
            PerfectFragment.pastParticiple = "descubierto";
        } else if (PerfectFragment.infinitive.equals("querer")) {
            PerfectFragment.pastParticiple = "querido";
        }
    }

    public static void makeGerund() {
        if (OtherFragment.infinitive.equals("advertir")) {
            OtherFragment.gerund = "advirtiendo";
        } else if (OtherFragment.infinitive.equals("competir")) {
            OtherFragment.gerund = "compititendo";
        } else if (OtherFragment.infinitive.equals("conseguir")) {
            OtherFragment.gerund = "consiguiendo";
        } else if (OtherFragment.infinitive.equals("consentir")) {
            OtherFragment.gerund = "consintiendo";
        } else if (OtherFragment.infinitive.equals("convertir")) {
            OtherFragment.gerund = "convirtiendo";
        } else if (OtherFragment.infinitive.equals("decir")) {
            OtherFragment.gerund = "diciendo";
        } else if (OtherFragment.infinitive.equals("hervir")) {
            OtherFragment.gerund = "hirviendo";
        } else if (OtherFragment.infinitive.equals("mentir")) {
            OtherFragment.gerund = "mintiendo";
        } else if (OtherFragment.infinitive.equals("pedir")) {
            OtherFragment.gerund = "pidiendo";
        } else if (OtherFragment.infinitive.equals("reñir")) {
            OtherFragment.gerund = "riñendo";
        } else if (OtherFragment.infinitive.equals("repetir")) {
            OtherFragment.gerund = "repitiendo";
        } else if (OtherFragment.infinitive.equals("seguir")) {
            OtherFragment.gerund = "siguiendo";
        } else if (OtherFragment.infinitive.equals("servir")) {
            OtherFragment.gerund = "sirviendo";
        } else if (OtherFragment.infinitive.equals("sugerir")) {
            OtherFragment.gerund = "sugiriendo";
        } else if (OtherFragment.infinitive.equals("venir")) {
            OtherFragment.gerund = "viniendo";
        } else if (OtherFragment.infinitive.equals("poder")) {
            OtherFragment.gerund = "pudiendo";
        } else if (OtherFragment.infinitive.equals("dormir")) {
            OtherFragment.gerund = "durmiendo";
        } else if (OtherFragment.infinitive.equals("morir")) {
            OtherFragment.gerund = "muriendo";
        } else if (OtherFragment.infinitive.equals("querer")) {
            OtherFragment.gerund = "queriendo";
        }
    }

    public static void replaceWithMoreThanOneEnding() {

        int index;

        if (MainFragment.verbTense == 0) {
            // Present tense
            if (MainFragment.isEndingAr) {
                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("ar");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                // "conjugate" by replacing new ending
                MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "o");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "as");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "a");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "amos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "áis");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "an");
            } else if (MainFragment.isEndingEr) {
                if (MainFragment.infinitive.equals("perder")) {
                    MainFragment.conjugationYo = "pierdo";
                    MainFragment.conjugationTu = "pierdes";
                    MainFragment.conjugationEl = "pierde";
                    MainFragment.conjugationNos = "perdemos";
                    MainFragment.conjugationOs = "perdéis";
                    MainFragment.conjugationEllos = "pierden";
                    MainFragment.setText();
                } else {
                    // change ending to something else
                    index = MainFragment.infinitive.lastIndexOf("er");
                    StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                    sb = sb.replace(index, index + 2, "bby");
                    MainFragment.infinitive = sb.toString();

                    // "conjugate" by replacing new ending
                    MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "o");
                    MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "es");
                    MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "e");
                    MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "emos");
                    MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "éis");
                    MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "en");
                }
            } else if (MainFragment.isEndingIr) {
                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("ir");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                // "conjugate" by replacing new ending
                MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "o");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "es");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "e");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "imos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "ís");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "en");
            }

            MainFragment.setText();

        } else if (MainFragment.verbTense == 1) {
            // Preterite tense
            if (MainFragment.isEndingAr) {
                // Spelling change of car/gar/zar verbs to maintain pronunciation
                if (MainFragment.hasSpellingChange) {
                    if (MainFragment.infinitive.endsWith("car")) {
                        MainFragment.conjugationYo = MainFragment.infinitive.replace("car", "qué");
                    } else if (MainFragment.infinitive.endsWith("gar")) {
                        MainFragment.conjugationYo = MainFragment.infinitive.replace("gar", "gué");
                    } else if (MainFragment.infinitive.endsWith("zar")) {
                        MainFragment.conjugationYo = MainFragment.infinitive.replace("zar", "cé");
                    }
                } else {
                    // change ending to something else
                    index = MainFragment.infinitive.lastIndexOf("ar");
                    StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                    sb = sb.replace(index, index + 2, "bby");
                    MainFragment.infinitive = sb.toString();

                    MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "é");
                }

                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "aste");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "ó");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "amos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "asteis");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "aron");
            } else if (MainFragment.isEndingEr) {
                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("er");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "í");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "iste");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "ió");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "imos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "isteis");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "ieron");
            } else if (MainFragment.isEndingIr) {
                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("ir");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "í");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "iste");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "ió");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "imos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "isteis");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "ieron");
            }

            MainFragment.setText();

        } else if (MainFragment.verbTense == 2) {
            // Imperfect tense
            if (MainFragment.isEndingAr) {
                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("ar");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "aba");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "abas");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "aba");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "ábamos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "abais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "aban");
            } else if (MainFragment.isEndingEr) {
                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("er");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "ía");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "ías");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "ía");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "íamos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "íais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "ían");
            } else if (MainFragment.isEndingIr) {
                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("ir");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "ía");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "ías");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "ía");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "íamos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "íais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "ían");
            }

            MainFragment.setText();

        } else if (MainFragment.verbTense == 3) {
            // Future tense
            MainFragment.conjugationYo = MainFragment.infinitive + "é";
            MainFragment.conjugationTu = MainFragment.infinitive + "ás";
            MainFragment.conjugationEl = MainFragment.infinitive + "á";
            MainFragment.conjugationNos = MainFragment.infinitive + "emos";
            MainFragment.conjugationOs = MainFragment.infinitive + "éis";
            MainFragment.conjugationEllos = MainFragment.infinitive + "án";

            MainFragment.setText();

        } else if (MainFragment.verbTense == 4) {
            // Affirmative commands

            if (MainFragment.isEndingAr) {

                index = MainFragment.infinitive.lastIndexOf("ar");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "a");
                if (hasSpellingChange) { spellingChange(); }
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "e");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "emos");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "en");
            } else if (MainFragment.isEndingEr) {

                if (MainFragment.infinitive.equals("perder")) {
                    MainFragment.conjugationTu = "pierde";
                    MainFragment.conjugationEl = "pierda";
                    MainFragment.conjugationNos = "pierdamos";
                    MainFragment.conjugationEllos = "pierdan";
                } else {
                    index = MainFragment.infinitive.lastIndexOf("er");
                    StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                    sb = sb.replace(index, index + 2, "bby");
                    MainFragment.infinitive = sb.toString();

                    MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "e");
                    if (hasSpellingChange) { spellingChange(); }
                    MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "a");
                    MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "amos");
                    MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "an");
                }
            } else if (MainFragment.isEndingIr) {

                index = MainFragment.infinitive.lastIndexOf("ir");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "e");
                if (hasSpellingChange) { spellingChange(); }
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "a");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "amos");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "an");
            }

            // No commands for these two forms
            MainFragment.conjugationYo = " ";
            MainFragment.conjugationOs = " ";

            MainFragment.setText();

        } else if (MainFragment.verbTense == 5) {
            // Negative commands
            if (MainFragment.isEndingAr) {

                index = MainFragment.infinitive.lastIndexOf("ar");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationTu = "no " + MainFragment.infinitive.replace("bby", "es");
                if (hasSpellingChange) { spellingChange(); }
                MainFragment.conjugationEl = "no " + MainFragment.infinitive.replace("bby", "e");
                MainFragment.conjugationNos = "no " + MainFragment.infinitive.replace("bby", "emos");
                MainFragment.conjugationEllos = "no " + MainFragment.infinitive.replace("bby", "en");
            } else if (MainFragment.isEndingEr) {

                if (MainFragment.infinitive.equals("perder")) {
                    MainFragment.conjugationTu = "no pierde";
                    MainFragment.conjugationEl = "no pierda";
                    MainFragment.conjugationNos = "no pierdamos";
                    MainFragment.conjugationEllos = "no pierdan";
                } else {
                    index = MainFragment.infinitive.lastIndexOf("er");
                    StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                    sb = sb.replace(index, index + 2, "bby");
                    MainFragment.infinitive = sb.toString();

                    MainFragment.conjugationTu = "no " + MainFragment.infinitive.replace("bby", "as");
                    if (hasSpellingChange) { spellingChange(); }
                    MainFragment.conjugationEl = "no " + MainFragment.infinitive.replace("bby", "a");
                    MainFragment.conjugationNos = "no " + MainFragment.infinitive.replace("bby", "amos");
                    MainFragment.conjugationEllos = "no " + MainFragment.infinitive.replace("bby", "an");
                }
            } else if (MainFragment.isEndingIr) {

                index = MainFragment.infinitive.lastIndexOf("ir");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationTu = "no " + MainFragment.infinitive.replace("bby", "as");
                if (hasSpellingChange) { spellingChange(); }
                MainFragment.conjugationEl = "no " + MainFragment.infinitive.replace("bby", "a");
                MainFragment.conjugationNos = "no " + MainFragment.infinitive.replace("bby", "amos");
                MainFragment.conjugationEllos = "no " + MainFragment.infinitive.replace("bby", "an");
            }

            // No commands for these two forms
            MainFragment.conjugationYo = " ";
            MainFragment.conjugationOs = " ";

            MainFragment.setText();

        } else if (MainFragment.verbTense == 6) {

            if (MainFragment.infinitive.endsWith("car")) { hasSpellingChange = true; }
            if (MainFragment.infinitive.endsWith("gar")) { hasSpellingChange = true; }
            if (MainFragment.infinitive.endsWith("zar")) { hasSpellingChange = true; }
            if (hasSpellingChange) { spellingChangeForSubjunctive(); }

            if (MainFragment.isEndingAr) {

                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("ar");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "e");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "es");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "e");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "emos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "éis");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "en");
            } else if (MainFragment.isEndingEr) {

                if (MainFragment.infinitive.equals("perder")) {
                    MainFragment.conjugationYo = "pierda";
                    MainFragment.conjugationTu = "pierdas";
                    MainFragment.conjugationEl = "pierda";
                    MainFragment.conjugationNos = "perdamos";
                    MainFragment.conjugationOs = "perdáis";
                    MainFragment.conjugationEllos = "pierdan";
                    MainFragment.setText();
                } else {
                    // change ending to something else
                    index = MainFragment.infinitive.lastIndexOf("er");
                    StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                    sb = sb.replace(index, index + 2, "bby");
                    MainFragment.infinitive = sb.toString();

                    MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "a");
                    MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "as");
                    MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "a");
                    MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "amos");
                    MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "áis");
                    MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "an");
                }
            } else if (MainFragment.isEndingIr) {

                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("ir");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.conjugationYo = MainFragment.infinitive.replace("bby", "a");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("bby", "as");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("bby", "a");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("bby", "amos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("bby", "áis");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("bby", "an");
            }

            MainFragment.setText();

        } else if (MainFragment.verbTense == 7) {
            if (MainFragment.isEndingAr) {

                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("ar");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                // first conjugates to preterite tense of ellos/ellas/ustedes form
                MainFragment.infinitive = MainFragment.infinitive.replace("bby", "aron");

                // then change to imperfect subjunctive endings
                MainFragment.conjugationYo = MainFragment.infinitive.replace("ron", "ra");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("ron", "ras");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("ron", "ra");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("aron", "áramos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("ron", "rais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("ron", "ran");
            } else if (MainFragment.isEndingEr) {

                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("er");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                // first conjugates to preterite tense of ellos/ellas/ustedes form
                MainFragment.infinitive = MainFragment.infinitive.replace("bby", "ieron");

                // then change to imperfect subjunctive endings
                MainFragment.conjugationYo = MainFragment.infinitive.replace("ron", "ra");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("ron", "ras");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("ron", "ra");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("eron", "éramos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("ron", "rais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("ron", "ran");
            } else if (MainFragment.isEndingIr) {

                // change ending to something else
                index = MainFragment.infinitive.lastIndexOf("ir");
                StringBuilder sb = new StringBuilder(MainFragment.infinitive);
                sb = sb.replace(index, index + 2, "bby");
                MainFragment.infinitive = sb.toString();

                MainFragment.infinitive = MainFragment.infinitive.replace("bby", "ieron");

                // then change to imperfect subjunctive endings
                MainFragment.conjugationYo = MainFragment.infinitive.replace("ron", "ra");
                MainFragment.conjugationTu = MainFragment.infinitive.replace("ron", "ras");
                MainFragment.conjugationEl = MainFragment.infinitive.replace("ron", "ra");
                MainFragment.conjugationNos = MainFragment.infinitive.replace("eron", "éramos");
                MainFragment.conjugationOs = MainFragment.infinitive.replace("ron", "rais");
                MainFragment.conjugationEllos = MainFragment.infinitive.replace("ron", "ran");
            }

            MainFragment.setText();

        } else if (MainFragment.verbTense == 8) {
            // Conditional tense
            MainFragment.conjugationYo = MainFragment.infinitive + "ía";
            MainFragment.conjugationTu = MainFragment.infinitive + "ías";
            MainFragment.conjugationEl = MainFragment.infinitive + "ía";
            MainFragment.conjugationNos = MainFragment.infinitive + "íamos";
            MainFragment.conjugationOs = MainFragment.infinitive + "íais";
            MainFragment.conjugationEllos = MainFragment.infinitive + "ían";

            MainFragment.setText();
        }
    }

    // Spelling change for pronunciation in imperative, subjunctive form
    private static void spellingChange() {

        if (MainFragment.isEndingAr) {
            if (MainFragment.infinitive.endsWith("car")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("car", "quar");
            } else if (MainFragment.infinitive.endsWith("gar")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("gar", "guar");
            } else if (MainFragment.infinitive.endsWith("zar")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("zar", "car");
            } else if (MainFragment.infinitive.endsWith("cbby")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("cbby", "qubby");
            } else if (MainFragment.infinitive.endsWith("gbby")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("gbby", "gubby");
            } else if (MainFragment.infinitive.endsWith("zbby")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("zbby", "cbby");
            }
        } else if (MainFragment.isEndingEr) {
            if (MainFragment.infinitive.endsWith("ger")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("ger", "jer");
            } else if (MainFragment.infinitive.endsWith("gbby")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("gbby", "jbby");
            }
        } else if (MainFragment.isEndingIr) {
            if (MainFragment.infinitive.endsWith("guir")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("guir", "gir");
            } else if (MainFragment.infinitive.endsWith("gir")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("gir", "jir");
            } else if (MainFragment.infinitive.endsWith("gubby")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("gubby", "gbby");
            } else if (MainFragment.infinitive.endsWith("gbby")) {
                MainFragment.infinitive = MainFragment.infinitive.replace("gbby", "jbby");
            }
        }
    }

    private static void spellingChangeForSubjunctive() {
        // Spelling change of -car, -gar, -zar verbs
        if (MainFragment.infinitive.endsWith("ger")) { hasSpellingChange = true; }
        if (MainFragment.infinitive.endsWith("gir")) { hasSpellingChange = true; }
        if (MainFragment.infinitive.endsWith("guir")) { hasSpellingChange = true; }
        if (hasSpellingChange) { spellingChange(); }
    }


}