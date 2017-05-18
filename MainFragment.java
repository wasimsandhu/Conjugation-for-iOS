package com.wsandhu.conjugation;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class MainFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener {

    public static String infinitive;
    public static String conjugationYo, conjugationTu, conjugationEl, conjugationNos, conjugationOs, conjugationEllos;
    String stemChangedVerb;

    public static TextView mYoTextView, mTuTextView, mElTextView, mNosTextView, mOsTextView, mEllosTextView;
    Spinner mConjugationTypeSpinner;
    public static AutoCompleteTextView mMainTextField;
    Button mConjugateButton;

    public static boolean isEndingAr, isEndingEr, isEndingIr, isIrregularVerb, isIrregularYoVerb,
            hasStemChange, hasSpellingChange, isIrregularInPreterite, isNotGoingToWork;
    boolean E2IE, O2UE, E2I, U2UE, O2HUE, IEStemChange;

    public static int verbTense;

    String[] irregularVerbs = {"ir", "ser", "estar", "dar", "saber", "conocer", "hacer", "traer", "poner",
            "ver", "salir", "conducir", "haber", "poder", "querer", "venir", "decir", "tener", "oír", "freír",
            "reír", "caer", "sonreír", "servir" };

    String[] irregularYoVerbs = {"tener", "venir", "salir", "poner", "caer", "traer", "oír", "hacer", "decir",
            "conducir", "conocer"};

    String[] stemChangingVerbsIE = {"cerrar", "comenzar", "despertar", "divertir", "empezar", "empecar",
            "encender", "entender", "sentir", "mentir", "negar", "nevar", "pensar", "preferir",
            "recomendar", "sentar", "querer", "helar", "confesar", "calentar", "encerrar", "fregar", "defender",
             "sugerir", "gobernar", "encerrar", "tropezar"};

    String[] otherStemChangingVerbsIE = {"despertar", "empezar", "empecar", "encender", "entender", "preferir"};

    String[] stemChangingVerbsUE = {"acostar", "acordar", "almorzar", "aprobar", "contar", "costar", "doler", "dormir", "encontrar",
            "llover", "morir", "poder", "probar", "recordar", "soñar", "volar", "promover", "mostrar", "disolver", "devolver", "demostrar",
            "colgar", "cocer", "absolver", "remover", "revolver", "rogar", "soler", "sonar" ,"torcer", "tronar", "demoler", "morder",
            "envolver", "volver", "poblar"};

    String[] stemChangingVerbsI = {"conseguir", "corregir", "seguir", "vestir", "pedir",
            "perseguir", "persegir", "elejir", "elegir", "repetir", "impedir", "medir"};

    String[] otherStemChangingVerbsI = {"perseguir", "persegir", "elejir", "elegir", "repetir" };

    String[] verbsIrregularInPreterite = {"leer", "construir", "creer" };
    String[] verbsIrregularInPreteriteWithStem = {"competir", "repetir", "divertir", "sentir",
            "mentir", "vestir", "preferir", "sugerir"};

    String[] verbsVoidToAlgorithms = {"acarrear", "arreglar", "aclarar", "ejercer", "merecer", "perder", "permanecer", "pertenecer",
            "agarrar", "aguardar", "alarmar", "apartar", "argumentar", "armar", "arrancar", "arreglar", "arrestar",
            "caracterizar", "cargar", "cariar", "caricƒiar", "clarificar", "comparar", "contrariar", "charlar",
            "declarar", "descarriar", "disparar", "embarazar", "encarcelar", "encargar", "garantizar", "martillar",
            "paralizar", "parar", "participar", "preparar", "reparar", "variar", "dirigir", "circunvenir", "adquirir", "marcar",
            "articular", "arriar", "arrojar", "arrastrar"};

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Casting the XML text views into Java objects...
        mYoTextView = (TextView) rootView.findViewById(R.id.yoTextView);
        mTuTextView = (TextView) rootView.findViewById(R.id.tuTextView);
        mElTextView = (TextView) rootView.findViewById(R.id.elTextView);
        mNosTextView = (TextView) rootView.findViewById(R.id.nosTextView);
        mOsTextView = (TextView) rootView.findViewById(R.id.osTextView);
        mEllosTextView = (TextView) rootView.findViewById(R.id.ellosTextView);

        // Spinner for picking how to conjugate the verb
        mConjugationTypeSpinner = (Spinner) rootView.findViewById(R.id.conjugationTypeSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.conjugation_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mConjugationTypeSpinner.setAdapter(adapter);
        mConjugationTypeSpinner.setOnItemSelectedListener(this);

        // Grabs input from text field and places it in String infinitive
        mMainTextField = (AutoCompleteTextView) rootView.findViewById(R.id.mainTextField);

        String[] verbs = getResources().getStringArray(R.array.verbs);
        ArrayAdapter<String> autoCompleteAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, verbs);
        mMainTextField.setAdapter(autoCompleteAdapter);

        mMainTextField.getBackground().setColorFilter(getResources().getColor(R.color.primaryColorDark), PorterDuff.Mode.SRC_ATOP);


        mMainTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    conjugate();
                    handled = true;
                }

                return handled;
            }
        });

        /* The conjugate button code */
        mConjugateButton = (Button) rootView.findViewById(R.id.conjugateButton);
        mConjugateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conjugate();
            }
        });

        return rootView;
    }

    protected void conjugate() {
        // The string "infinitive" is whatever the user types in the text field
        infinitive = mMainTextField.getText().toString();

        PerfectFragment.mPerfTextField.setText(infinitive);
        OtherFragment.mOtherTextField.setText(infinitive);

        // booleans for checking verb type
        isEndingAr = infinitive.endsWith("ar");
        isEndingEr = infinitive.endsWith("er");
        isEndingIr = infinitive.endsWith("ir");

        isIrregularVerb = Arrays.asList(irregularVerbs).contains(infinitive);
        isIrregularYoVerb = Arrays.asList(irregularYoVerbs).contains(infinitive);
        isNotGoingToWork = Arrays.asList(verbsVoidToAlgorithms).contains(infinitive);

        // boolean for checking for -car, -gar, -zar spelling changes for some tenses
        if (infinitive.endsWith("car")) { hasSpellingChange = true; }
        if (infinitive.endsWith("gar")) { hasSpellingChange = true; }
        if (infinitive.endsWith("zar")) { hasSpellingChange = true; }

        // Booleans for checking stem change before conjugation
        E2IE = Arrays.asList(stemChangingVerbsIE).contains(infinitive);
        O2UE = Arrays.asList(stemChangingVerbsUE).contains(infinitive);
        E2I = Arrays.asList(stemChangingVerbsI).contains(infinitive);
        U2UE = infinitive.equals("jugar");
        O2HUE = infinitive.equals("oler");
        IEStemChange = Arrays.asList(verbsIrregularInPreteriteWithStem).contains(infinitive);

        if (E2IE) { hasStemChange = true; }
        if (O2UE) { hasStemChange = true; }
        if (E2I) { hasStemChange = true; }
        if (U2UE) { hasStemChange = true; }
        if (O2HUE) { hasStemChange = true; }
        if (IEStemChange) { hasStemChange = true; }

        // Special verbs irregular in the preterite tense
        isIrregularInPreterite = Arrays.asList(verbsIrregularInPreterite).contains(infinitive);

        // Check to see what kind of verb it is before conjugating
        if (isEndingAr && !isIrregularVerb && !isNotGoingToWork) {
            // checks verb tense and then calls respective method
            if (verbTense == 0) {
                // checks for stem change in present tense
                if (hasStemChange) { stemChange(); }
                conjugateArVerbPresent();
            } else if (verbTense == 1) {
                conjugateArVerbPreterite();
            } else if (verbTense == 2) {
                conjugateArVerbImperfect();
            } else if (verbTense == 3) {
                conjugateVerbFuture();
            } else if (verbTense == 4) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbAffirmativeCommand();
            } else if (verbTense == 5) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbNegativeCommand();
            } else if (verbTense == 6) {
                if (hasSpellingChange) { spellingChangeForSubjunctive(); }
                if (hasStemChange) { stemChange(); }
                conjugatePresentSubjunctive();
            } else if (verbTense == 7) {
                conjugateImperfectSubjunctive();
            } else if (verbTense == 8) {
                conjugateVerbConditional();
            }
        } else if (isEndingEr && !isIrregularVerb && !isNotGoingToWork) {
            // checks verb tense and then calls respective method
            if (verbTense == 0) {
                // checks for stem change in present tense
                if (hasStemChange) { stemChange(); }
                conjugateErVerbPresent();
            } else if (verbTense == 1) {
                conjugateErIrVerbPreterite();
            } else if (verbTense == 2) {
                conjugateErIrVerbImperfect();
            } else if (verbTense == 3) {
                conjugateVerbFuture();
            } else if (verbTense == 4) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbAffirmativeCommand();
            } else if (verbTense == 5) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbNegativeCommand();
            } else if (verbTense == 6) {
                if (infinitive.endsWith("ger")) { hasSpellingChange = true; }
                if (infinitive.endsWith("gir")) { hasSpellingChange = true; }
                if (infinitive.endsWith("guir")) { hasSpellingChange = true; }
                if (hasSpellingChange) { spellingChangeForSubjunctive(); }
                if (hasStemChange) { stemChange(); }
                conjugatePresentSubjunctive();
            } else if (verbTense == 7) {
                conjugateImperfectSubjunctive();
            } else if (verbTense == 8) {
                conjugateVerbConditional();
            }
        } else if (isEndingIr && !isIrregularVerb && !isNotGoingToWork) {
            // checks verb tense and then calls respective method
            if (verbTense == 0) {
                // checks for stem change in present tense
                if (hasStemChange) { stemChange(); }
                conjugateIrVerbPresent();
            } else if (verbTense == 1) {
                conjugateErIrVerbPreterite();
            } else if (verbTense == 2) {
                conjugateErIrVerbImperfect();
            } else if (verbTense == 3) {
                conjugateVerbFuture();
            } else if (verbTense == 4) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbAffirmativeCommand();
            } else if (verbTense == 5) {
                if (hasStemChange) { stemChange(); }
                conjugateVerbNegativeCommand();
            } else if (verbTense == 6) {
                if (infinitive.endsWith("ger")) { hasSpellingChange = true; }
                if (infinitive.endsWith("gir")) { hasSpellingChange = true; }
                if (infinitive.endsWith("guir")) { hasSpellingChange = true; }
                if (hasSpellingChange) { spellingChangeForSubjunctive(); }
                if (hasStemChange) { stemChange(); }
                conjugatePresentSubjunctive();
            } else if (verbTense == 7) {
                conjugateImperfectSubjunctive();
            } else if (verbTense == 8) {
                conjugateVerbConditional();
            }
        } else if (isIrregularVerb) {
            IrregularVerb.conjugate();
        } else if (isNotGoingToWork) {
            IrregularVerb.replaceWithMoreThanOneEnding();
        } else {

        }

        hideKeyboard();
    }

    /* METHODS FOR PRESENT TENSE CONJUGATIONS */
    public void conjugateArVerbPresent() {

        // replaces the ending in the -ar infinitive with present tense ending
        if (!hasStemChange) {
            conjugationYo = infinitive.replace("ar", "o");
            conjugationTu = infinitive.replace("ar", "as");
            conjugationEl = infinitive.replace("ar", "a");
            conjugationNos = infinitive.replace("ar", "amos");
            conjugationOs = infinitive.replace("ar", "áis");
            conjugationEllos = infinitive.replace("ar", "an");
        } else {
            // stem change conjugations
            conjugationYo = stemChangedVerb.replace("ar", "o");
            conjugationTu = stemChangedVerb.replace("ar", "as");
            conjugationEl = stemChangedVerb.replace("ar", "a");
            conjugationNos = infinitive.replace("ar", "amos"); // stem doesn't change
            conjugationOs = infinitive.replace("ar", "áis"); // stem doesn't change
            conjugationEllos = stemChangedVerb.replace("ar", "an");
        }

        setText();

    }

    public void conjugateErVerbPresent() {

        // replaces the ending in the -er infinitive with present tense ending
        if (!hasStemChange) {
            // spelling change for yo conjugations
            if (infinitive.endsWith("cer")) {
                if (infinitive.endsWith("hacer")) {
                    conjugationYo = infinitive.replace("cer", "go");
                } else {
                    conjugationYo = infinitive.replace("cer", "zco");
                }
            } else if (infinitive.endsWith("tener")) {
                conjugationYo = infinitive.replace("er", "go");
            } else if (infinitive.endsWith("suponer")) {
                conjugationYo = infinitive.replace("er", "go");
            } else if (infinitive.endsWith("ger")) {
                conjugationYo = infinitive.replace("ger", "jo");
            } else if (infinitive.endsWith("aer")) {
                conjugationYo = infinitive.replace("er", "igo");
            } else if (infinitive.endsWith("caber")) {
                conjugationYo = infinitive.replace("caber", "quepo");
            } else if (infinitive.endsWith("valer")) {
                conjugationYo = infinitive.replace("valer", "valgo");
            } else {
                conjugationYo = infinitive.replace("er", "o");
            }
            conjugationTu = infinitive.replace("er", "es");
            conjugationEl = infinitive.replace("er", "e");
            conjugationNos = infinitive.replace("er", "emos");
            conjugationOs = infinitive.replace("er", "éis");
            conjugationEllos = infinitive.replace("er", "en");
        } else {
            // stem change conjugations
            // spelling change for yo conjugations
            if (infinitive.endsWith("cer")) {
                conjugationYo = stemChangedVerb.replace("cer", "zco");
            } else if (infinitive.endsWith("ger")) {
                conjugationYo = stemChangedVerb.replace("ger", "jo");
            } else {
                conjugationYo = stemChangedVerb.replace("er", "o");
            }
            conjugationTu = stemChangedVerb.replace("er", "es");
            conjugationEl = stemChangedVerb.replace("er", "e");
            conjugationNos = infinitive.replace("er", "emos"); // stem doesn't change
            conjugationOs = infinitive.replace("er", "éis"); // stem doesn't change
            conjugationEllos = stemChangedVerb.replace("er", "en");
            }

        setText();

    }

    public void conjugateIrVerbPresent() {

        // replaces the ending in the -ir infinitive with present tense ending
        if (!hasStemChange) {
            if (infinitive.endsWith("cir") && !infinitive.endsWith("decir")) {
                conjugationYo = infinitive.replace("cir", "zco");
            } else if (infinitive.endsWith("decir")) {
                conjugationYo = infinitive.replace("decir", "digo");
            } else if (infinitive.endsWith("gir")) {
                conjugationYo = infinitive.replace("gir", "jo");
            } else if (infinitive.endsWith("uir") && !infinitive.endsWith("guir")) {
                conjugationYo = infinitive.replace("ir", "yo");
            } else if (infinitive.endsWith("guir")) {
                conjugationYo = infinitive.replace("guir", "go");
            } else {
                conjugationYo = infinitive.replace("ir", "o");
            }
            if (infinitive.endsWith("uir") && !infinitive.endsWith("guir")) {
                conjugationTu = infinitive.replace("ir", "yes");
                conjugationEl = infinitive.replace("ir", "ye");
                conjugationNos = infinitive.replace("ir", "imos");
                conjugationOs = infinitive.replace("ir", "ís");
                conjugationEllos = infinitive.replace("ir", "yen");
            } else {
                conjugationTu = infinitive.replace("ir", "es");
                conjugationEl = infinitive.replace("ir", "e");
                conjugationNos = infinitive.replace("ir", "imos");
                conjugationOs = infinitive.replace("ir", "ís");
                conjugationEllos = infinitive.replace("ir", "en");
            }
        } else {
            // stem change conjugations
            if (infinitive.endsWith("cir") && !infinitive.endsWith("decir")) {
                conjugationYo = stemChangedVerb.replace("cir", "zco");
            } else if (infinitive.endsWith("decir")) {
                conjugationYo = stemChangedVerb.replace("decir", "digo");
            } else if (infinitive.endsWith("gir")) {
                conjugationYo = stemChangedVerb.replace("gir", "jo");
            } else if (infinitive.endsWith("uir") && !infinitive.endsWith("guir")) {
                conjugationYo = stemChangedVerb.replace("ir", "yo");
            } else if (infinitive.endsWith("guir")) {
                conjugationYo = stemChangedVerb.replace("guir", "go");
            } else {
                conjugationYo = stemChangedVerb.replace("ir", "o");
            }
            if (infinitive.endsWith("uir") && !infinitive.endsWith("guir")) {
                conjugationTu = stemChangedVerb.replace("ir", "yes");
                conjugationEl = stemChangedVerb.replace("ir", "ye");
                conjugationNos = infinitive.replace("ir", "imos"); // stem doesn't change
                conjugationOs = infinitive.replace("ir", "ís"); // stem doesn't change
                conjugationEllos = stemChangedVerb.replace("ir", "yen");
            } else {
                conjugationTu = stemChangedVerb.replace("ir", "es");
                conjugationEl = stemChangedVerb.replace("ir", "e");
                conjugationNos = infinitive.replace("ir", "imos"); // stem doesn't change
                conjugationOs = infinitive.replace("ir", "ís"); // stem doesn't change
                conjugationEllos = stemChangedVerb.replace("ir", "en");
            }
        }

        setText();

    }

    /* METHODS FOR PRETERITE TENSE CONJUGATIONS */
    public void conjugateArVerbPreterite() {

        // Spelling change of car/gar/zar verbs to maintain pronunciation
        if (hasSpellingChange) {
            if (infinitive.endsWith("car")) {
                conjugationYo = infinitive.replace("car", "qué");
            } else if (infinitive.endsWith("gar")) {
                conjugationYo = infinitive.replace("gar", "gué");
            } else if (infinitive.endsWith("zar")) {
                conjugationYo = infinitive.replace("zar", "cé");
            }
        } else { conjugationYo = infinitive.replace("ar", "é"); }

        conjugationTu = infinitive.replace("ar", "aste");
        conjugationEl = infinitive.replace("ar", "ó");
        conjugationNos = infinitive.replace("ar", "amos");
        conjugationOs = infinitive.replace("ar", "asteis");
        conjugationEllos = infinitive.replace("ar", "aron");

        setText();
    }

    public void conjugateErIrVerbPreterite() {

        if (isEndingEr && !infinitive.endsWith("raer") && !infinitive.endsWith("hacer")) {
            conjugationYo = infinitive.replace("er", "í");
            conjugationTu = infinitive.replace("er", "iste");
            conjugationEl = infinitive.replace("er", "ió");
            conjugationNos = infinitive.replace("er", "imos");
            conjugationOs = infinitive.replace("er", "isteis");
            conjugationEllos = infinitive.replace("er", "ieron");
            if (isIrregularInPreterite) {
                conjugationTu = infinitive.replace("er", "íste");
                conjugationEl = infinitive.replace("er", "yó");
                conjugationNos = infinitive.replace("er", "ímos");
                conjugationOs = infinitive.replace("er", "ísteis");
                conjugationEllos = infinitive.replace("er", "yeron");
            } setText();
        } else if (infinitive.endsWith("raer")) {
            conjugationYo = infinitive.replace("er", "je");
            conjugationTu = infinitive.replace("er", "jiste");
            conjugationEl = infinitive.replace("er", "jo");
            conjugationNos = infinitive.replace("er", "imos");
            conjugationOs = infinitive.replace("er", "jisteis");
            conjugationEllos = infinitive.replace("er", "jeron");
            setText();
        } else if (infinitive.endsWith("hacer")) {
            conjugationYo = infinitive.replace("hacer", "hice");
            conjugationTu = infinitive.replace("hacer", "hiciste");
            conjugationEl = infinitive.replace("hacer", "hizo");
            conjugationNos = infinitive.replace("hacer", "hicimos");
            conjugationOs = infinitive.replace("hacer", "hicisteis");
            conjugationEllos = infinitive.replace("hacer", "hicieron");
            setText();
        } else if (infinitive.endsWith("tener")) {
            conjugationYo = infinitive.replace("tener", "tuve");
            conjugationTu = infinitive.replace("tener", "tuviste");
            conjugationEl = infinitive.replace("tener", "tuvo");
            conjugationNos = infinitive.replace("tener", "tuvimos");
            conjugationOs = infinitive.replace("tener", "tuvisteis");
            conjugationEllos = infinitive.replace("tener", "tuvieron");
            setText();
        }

        if (isEndingIr && !infinitive.endsWith("ucir")) {

            int index;
            String stemChangedVerb1 = infinitive;
            String stemChangedVerb2 = infinitive;
            boolean nextIndexI = Arrays.asList(otherStemChangingVerbsI).contains(infinitive);

            conjugationYo = infinitive.replace("ir", "í");
            conjugationTu = infinitive.replace("ir", "iste");

            /* Stem change in el/ella/usted form */
            if (hasStemChange) {
                if (E2I) {
                    if (nextIndexI) {
                        if (infinitive.equals("perseguir")) {
                            index = stemChangedVerb1.indexOf("e");
                            int nextIndex = index + 3;
                            StringBuilder sb = new StringBuilder(stemChangedVerb1);
                            sb = sb.replace(nextIndex, nextIndex + 1, "i");
                            stemChangedVerb1 = sb.toString();
                            conjugationEl = stemChangedVerb1.replace("ir", "ió");
                        } else {
                            index = stemChangedVerb1.indexOf("e");
                            int nextIndex = index + 2;
                            StringBuilder sb = new StringBuilder(stemChangedVerb1);
                            sb = sb.replace(nextIndex, nextIndex + 1, "i");
                            stemChangedVerb1 = sb.toString();
                            conjugationEl = stemChangedVerb1.replace("ir", "ió");
                        }
                    } else {
                        // finds "e" and changes to stem "i"
                        index = stemChangedVerb1.indexOf("e");
                        StringBuilder sb = new StringBuilder(stemChangedVerb1);
                        sb = sb.replace(index, index + 1, "i");
                        stemChangedVerb1 = sb.toString();
                        conjugationEl = stemChangedVerb1.replace("ir", "ió");
                    }
                } else if (O2UE) {
                    // finds "o" and changes to stem "u"
                    index = stemChangedVerb1.indexOf("o");
                    StringBuilder sb2 = new StringBuilder(stemChangedVerb1);
                    sb2 = sb2.replace(index, index + 1, "u");
                    stemChangedVerb1 = sb2.toString();
                    conjugationEl = stemChangedVerb1.replace("ir", "ió");
                } else if (IEStemChange) {
                    if (!infinitive.equals("repetir") && !infinitive.equals("divertir") && !infinitive.equals("preferir")
                            && !infinitive.equals("sugerir")) {
                        // finds "e" and changes to stem "i"
                        index = stemChangedVerb1.indexOf("e");
                        StringBuilder sb2 = new StringBuilder(stemChangedVerb1);
                        sb2 = sb2.replace(index, index + 1, "i");
                        stemChangedVerb1 = sb2.toString();
                        conjugationEl = stemChangedVerb1.replace("ir", "ió");
                    } else if (infinitive.equals("divertir")) {
                        conjugationEl = "divirtió";
                    } else if (infinitive.equals("preferir")) {
                        conjugationEl = "prefirió";
                    } else if (infinitive.equals("sugerir")) {
                        conjugationEl = "sugirió";
                    } else {
                        // finds "e" and changes to stem "i"
                        index = stemChangedVerb1.indexOf("e");
                        StringBuilder sb2 = new StringBuilder(stemChangedVerb1);
                        sb2 = sb2.replace(index, index + 3, "i");
                        stemChangedVerb1 = sb2.toString();
                        conjugationEl = stemChangedVerb1.replace("ir", "ió");
                    }
                }
            } else if (!hasStemChange) {
                conjugationEl = infinitive.replace("ir", "ió");
            }

                conjugationNos = infinitive.replace("ir", "imos");
                conjugationOs = infinitive.replace("ir", "isteis");

            /* Stem change in ellos/ellas/ustedes form */
                if (hasStemChange) {
                    if (E2I) {
                        if (nextIndexI) {
                            if (infinitive.equals("perseguir")) {
                                index = stemChangedVerb2.indexOf("e");
                                int nextIndex = index + 3;
                                StringBuilder sb = new StringBuilder(stemChangedVerb2);
                                sb = sb.replace(nextIndex, nextIndex + 1, "i");
                                stemChangedVerb2 = sb.toString();
                                conjugationEllos = stemChangedVerb2.replace("ir", "ieron");
                            } else {
                                index = stemChangedVerb2.indexOf("e");
                                int nextIndex = index + 2;
                                StringBuilder sb = new StringBuilder(stemChangedVerb2);
                                sb = sb.replace(nextIndex, nextIndex + 1, "i");
                                stemChangedVerb2 = sb.toString();
                                conjugationEllos = stemChangedVerb2.replace("ir", "ieron");
                            }
                        } else {
                            // finds "e" and changes to stem "i"
                            index = stemChangedVerb2.indexOf("e");
                            StringBuilder sb5 = new StringBuilder(stemChangedVerb2);
                            sb5 = sb5.replace(index, index + 1, "i");
                            stemChangedVerb2 = sb5.toString();
                            conjugationEllos = stemChangedVerb2.replace("ir", "ieron");
                        }
                    } else if (O2UE) {
                        // finds "o" and changes to stem "u"
                        index = stemChangedVerb2.indexOf("o");
                        StringBuilder sb4 = new StringBuilder(stemChangedVerb2);
                        sb4 = sb4.replace(index, index + 1, "u");
                        stemChangedVerb2 = sb4.toString();
                        conjugationEllos = stemChangedVerb2.replace("ir", "ieron");
                    } else if (IEStemChange) {
                        if (!infinitive.equals("repetir") && !infinitive.equals("divertir") && !infinitive.equals("preferir")
                                && !infinitive.equals("sugerir")) {
                            // finds "e" and changes to stem "i"
                            index = stemChangedVerb2.indexOf("e");
                            StringBuilder sb2 = new StringBuilder(stemChangedVerb2);
                            sb2 = sb2.replace(index, index + 1, "i");
                            stemChangedVerb2 = sb2.toString();
                            conjugationEllos = stemChangedVerb2.replace("ir", "ieron");
                        } else if (infinitive.equals("divertir")) {
                            conjugationEllos = "divirtieron";
                        } else if (infinitive.equals("preferir")) {
                            conjugationEllos = "prefirieron";
                        } else if (infinitive.equals("sugerir")) {
                            conjugationEllos = "sugirieron";
                        } else {
                            // finds "e" and changes to stem "i"
                            index = stemChangedVerb2.indexOf("e");
                            StringBuilder sb2 = new StringBuilder(stemChangedVerb2);
                            sb2 = sb2.replace(index, index + 3, "i");
                            stemChangedVerb2 = sb2.toString();
                            conjugationEllos = stemChangedVerb2.replace("ir", "ieron");
                        }
                    }
                } else if (!hasStemChange) {
                    conjugationEllos = infinitive.replace("ir", "ieron");
                }

                if (isIrregularInPreterite) {
                    conjugationTu = infinitive.replace("ir", "íste");
                    conjugationEl = infinitive.replace("ir", "yó");
                    conjugationNos = infinitive.replace("ir", "ímos");
                    conjugationOs = infinitive.replace("ir", "ísteis");
                    conjugationEllos = infinitive.replace("ir", "yeron");
                } setText();
        } else if (infinitive.endsWith("ucir")) {
            conjugationYo = infinitive.replace("cir", "je");
            conjugationTu = infinitive.replace("cir", "jiste");
            conjugationEl = infinitive.replace("cir", "jo");
            conjugationNos = infinitive.replace("cir", "imos");
            conjugationOs = infinitive.replace("cir", "jisteis");
            conjugationEllos = infinitive.replace("cir", "jeron");
            setText();
        }
    }

    /* METHODS FOR IMPERFECT TENSE CONJUGATION */
    public static void conjugateArVerbImperfect() {
        conjugationYo = infinitive.replace("ar", "aba");
        conjugationTu = infinitive.replace("ar", "abas");
        conjugationEl = infinitive.replace("ar", "aba");
        conjugationNos = infinitive.replace("ar", "ábamos");
        conjugationOs = infinitive.replace("ar", "abais");
        conjugationEllos = infinitive.replace("ar", "aban");

        setText();
    }

    public static void conjugateErIrVerbImperfect() {

        if (isEndingEr) {
            conjugationYo = infinitive.replace("er", "ía");
            conjugationTu = infinitive.replace("er", "ías");
            conjugationEl = infinitive.replace("er", "ía");
            conjugationNos = infinitive.replace("er", "íamos");
            conjugationOs = infinitive.replace("er", "íais");
            conjugationEllos = infinitive.replace("er", "ían");
        }

        if (isEndingIr) {
            conjugationYo = infinitive.replace("ir", "ía");
            conjugationTu = infinitive.replace("ir", "ías");
            conjugationEl = infinitive.replace("ir", "ía");
            conjugationNos = infinitive.replace("ir", "íamos");
            conjugationOs = infinitive.replace("ir", "íais");
            conjugationEllos = infinitive.replace("ir", "ían");
        }

        setText();
    }

    /* METHODS FOR FUTURE TENSE CONJUGATIONS */
    public static void conjugateVerbFuture() {

        if (infinitive.equals("valer")) {
            conjugationYo = "valdré";
            conjugationTu = "valdrás";
            conjugationEl = "valdrá";
            conjugationNos = "valdremos";
            conjugationOs = "valdréis";
            conjugationEllos = "valdrán";
        } else if (infinitive.equals("caber")) {
            conjugationYo = "cabré";
            conjugationTu = "cabrás";
            conjugationEl = "cabrá";
            conjugationNos = "cabremos";
            conjugationOs = "cabréis";
            conjugationEllos = "cabrán";
        } else if (infinitive.endsWith("deshacer")) {
            conjugationYo = "desharé";
            conjugationTu = "desharás";
            conjugationEl = "deshará";
            conjugationNos = "desharemos";
            conjugationOs = "desharéis";
            conjugationEllos = "desharán";
        } else if (infinitive.endsWith("suponer")) {
            conjugationYo = "supondré";
            conjugationTu = "supondrás";
            conjugationEl = "supondrá";
            conjugationNos = "supondremos";
            conjugationOs = "supondrés";
            conjugationEllos = "supondrán";
        } else if (infinitive.endsWith("tener")) {
            conjugationYo = infinitive.replace("tener", "tendré");
            conjugationTu = infinitive.replace("tener", "tendrás");
            conjugationEl = infinitive.replace("tener", "tendrá");
            conjugationNos = infinitive.replace("tener", "tendremos");
            conjugationOs = infinitive.replace("tener", "tendréis");
            conjugationEllos = infinitive.replace("tener", "tendrán");
        } else {
            conjugationYo = infinitive + "é";
            conjugationTu = infinitive + "ás";
            conjugationEl = infinitive + "á";
            conjugationNos = infinitive + "emos";
            conjugationOs = infinitive + "éis";
            conjugationEllos = infinitive + "án";
        }

        setText();
    }

    /* METHODS FOR IMPERATIVE TENSE CONJUGATION */
    public void conjugateVerbAffirmativeCommand() {

        // Spelling change for pronunciation
        if (infinitive.endsWith("ger")) { hasSpellingChange = true; }
        if (infinitive.endsWith("guir")) { hasSpellingChange = true; }

        if (isEndingAr) {
            if (hasStemChange) {
                conjugationTu = stemChangedVerb.replace("ar", "a");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = stemChangedVerb.replace("ar", "e");
                conjugationNos = infinitive.replace("ar", "emos");
                conjugationEllos = stemChangedVerb.replace("ar", "en");
            } else {
                conjugationTu = infinitive.replace("ar", "a");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = infinitive.replace("ar", "e");
                conjugationNos = infinitive.replace("ar", "emos");
                conjugationEllos = infinitive.replace("ar", "en");
            }
        } else if (isEndingEr) {
            if (hasStemChange) {
                conjugationTu = stemChangedVerb.replace("er", "e");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = stemChangedVerb.replace("er", "a");
                conjugationNos = infinitive.replace("er", "amos");
                conjugationEllos = stemChangedVerb.replace("o", "an");
            } else {
                if (infinitive.endsWith("cer")) {
                    if (infinitive.endsWith("hacer")) {
                        conjugationTu = infinitive.replace("hacer", "haz");
                        conjugationEl = infinitive.replace("cer", "ga");
                        conjugationNos = infinitive.replace("cer", "gamos");
                        conjugationEllos = infinitive.replace("cer", "gan");
                    } else {
                        conjugationTu = infinitive.replace("cer", "ce");
                        conjugationEl = infinitive.replace("cer", "zca");
                        conjugationNos = infinitive.replace("cer", "zcamos");
                        conjugationEllos = infinitive.replace("cer", "zcan");
                    }
                } else if (infinitive.endsWith("suponer")) {
                    conjugationTu = infinitive.replace("suponer", "suponga");
                    conjugationEl = infinitive.replace("er", "ga");
                    conjugationNos = infinitive.replace("er", "gamos");
                    conjugationEllos = infinitive.replace("er", "gan");
                } else if (infinitive.endsWith("detener")) {
                    conjugationTu = infinitive.replace("detener", "detén");
                    conjugationEl = infinitive.replace("er", "ga");
                    conjugationNos = infinitive.replace("er", "gamos");
                    conjugationEllos = infinitive.replace("er", "gan");
                } else if (infinitive.endsWith("aer")) {
                    conjugationTu = infinitive.replace("er", "e");
                    conjugationEl = infinitive.replace("er", "iga");
                    conjugationNos = infinitive.replace("er", "igamos");
                    conjugationEllos = infinitive.replace("er", "igan");
                } else if (infinitive.endsWith("caber")) {
                    conjugationTu = infinitive.replace("caber", "cabe");
                    conjugationEl = infinitive.replace("caber", "quepa");
                    conjugationNos = infinitive.replace("caber", "quepamos");
                    conjugationEllos = infinitive.replace("caber", "quepan");
                } else if (infinitive.endsWith("valer")) {
                    conjugationTu = infinitive.replace("valer", "vale");
                    conjugationEl = infinitive.replace("valer", "valga");
                    conjugationNos = infinitive.replace("valer", "valgamos");
                    conjugationEllos = infinitive.replace("valer", "valgan");
                } else {
                    conjugationTu = infinitive.replace("er", "e");
                    if (hasSpellingChange) { spellingChange(); }
                    conjugationEl = infinitive.replace("er", "a");
                    conjugationNos = infinitive.replace("er", "amos");
                    conjugationEllos = infinitive.replace("er", "an");
                }
            }
        } else if (isEndingIr) {
            if (hasStemChange) {
                conjugationTu = stemChangedVerb.replace("ir", "e");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = stemChangedVerb.replace("ir", "a");
                conjugationNos = infinitive.replace("ir", "amos");
                conjugationEllos = stemChangedVerb.replace("ir", "an");
            } else {
                conjugationTu = infinitive.replace("ir", "e");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = infinitive.replace("ir", "a");
                conjugationNos = infinitive.replace("ir", "amos");
                conjugationEllos = infinitive.replace("ir", "an");
            }
        }

        // No commands for these two forms
        conjugationYo = " ";
        conjugationOs = " ";

        setText();
    }

    public void conjugateVerbNegativeCommand() {

        // Spelling change for pronunciation
        if (infinitive.endsWith("ger")) { hasSpellingChange = true; }
        if (infinitive.endsWith("guir")) { hasSpellingChange = true; }

        // Tú commands are just present tense el/ella/usted
        if (isEndingAr) {
            if (hasStemChange) {
                conjugationTu = "no " + stemChangedVerb.replace("ar", "es");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = "no " + stemChangedVerb.replace("ar", "e");
                conjugationNos = "no " + infinitive.replace("ar", "emos");
                conjugationEllos = "no " + stemChangedVerb.replace("ar", "en");
            } else {
                conjugationTu = "no " + infinitive.replace("ar", "es");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = "no " + infinitive.replace("ar", "e");
                conjugationNos = "no " + infinitive.replace("ar", "emos");
                conjugationEllos = "no " + infinitive.replace("ar", "en");
            }
        } else if (isEndingEr) {
            if (hasStemChange) {
                conjugationTu = "no " + stemChangedVerb.replace("er", "as");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = "no " + stemChangedVerb.replace("er", "a");
                conjugationNos = "no " + infinitive.replace("er", "amos");
                conjugationEllos = "no " + stemChangedVerb.replace("er", "an");
            } else {
                if (infinitive.endsWith("cer")) {
                    if (infinitive.endsWith("hacer")) {
                        conjugationTu = "no " + infinitive.replace("hacer", "gas");
                        conjugationEl = "no " + infinitive.replace("cer", "ga");
                        conjugationNos = "no " + infinitive.replace("cer", "gamos");
                        conjugationEllos = "no " + infinitive.replace("cer", "gan");
                    } else {
                        conjugationTu = "no " + infinitive.replace("cer", "zcas");
                        conjugationEl = "no " + infinitive.replace("cer", "zca");
                        conjugationNos = "no " + infinitive.replace("cer", "zcamos");
                        conjugationEllos = "no " + infinitive.replace("cer", "zcan");
                    }
                } else if (infinitive.endsWith("suponer")) {
                    conjugationTu = "no " + infinitive.replace("suponer", "suponga");
                    conjugationEl = "no " + infinitive.replace("er", "ga");
                    conjugationNos = "no " + infinitive.replace("er", "gamos");
                    conjugationEllos = "no " + infinitive.replace("er", "gan");
                } else if (infinitive.endsWith("detener")) {
                    conjugationTu = "no " + infinitive.replace("detener", "detengas");
                    conjugationEl = "no " + infinitive.replace("er", "ga");
                    conjugationNos = "no " + infinitive.replace("er", "gamos");
                    conjugationEllos = "no " + infinitive.replace("er", "gan");
                } else if (infinitive.endsWith("aer")) {
                    conjugationTu = "no " + infinitive.replace("er", "igas");
                    conjugationEl = "no " + infinitive.replace("er", "iga");
                    conjugationNos = "no " + infinitive.replace("er", "igamos");
                    conjugationEllos = "no " + infinitive.replace("er", "igan");
                } else if (infinitive.endsWith("caber")) {
                    conjugationTu = "no " + infinitive.replace("caber", "quepas");
                    conjugationEl = "no " + infinitive.replace("caber", "quepa");
                    conjugationNos = "no " + infinitive.replace("caber", "quepamos");
                    conjugationEllos = "no " + infinitive.replace("caber", "quepan");
                } else if (infinitive.endsWith("valer")) {
                    conjugationTu = "no " + infinitive.replace("valer", "valgas");
                    conjugationEl = "no " + infinitive.replace("valer", "valga");
                    conjugationNos = "no " + infinitive.replace("valer", "valgamos");
                    conjugationEllos = "no " + infinitive.replace("valer", "valgan");
                } else {
                    conjugationTu = "no " + infinitive.replace("er", "as");
                    if (hasSpellingChange) { spellingChange(); }
                    conjugationEl = "no " + infinitive.replace("er", "a");
                    conjugationNos = "no " + infinitive.replace("er", "amos");
                    conjugationEllos = "no " + infinitive.replace("er", "an");
                }
            }
        } else if (isEndingIr) {
            if (hasStemChange) {
                conjugationTu = "no " + stemChangedVerb.replace("ir", "as");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = "no " + stemChangedVerb.replace("ir", "a");
                conjugationNos = "no " + infinitive.replace("ir", "amos");
                conjugationEllos = "no " + stemChangedVerb.replace("ir", "an");
            } else {
                conjugationTu = "no " + infinitive.replace("ir", "as");
                if (hasSpellingChange) { spellingChange(); }
                conjugationEl = "no " + infinitive.replace("ir", "a");
                conjugationNos = "no " + infinitive.replace("ir", "amos");
                conjugationEllos = "no " + infinitive.replace("ir", "an");
            }
        }

        // No commands for these two forms
        conjugationYo = " ";
        conjugationOs = " ";

        setText();
    }

    public void conjugatePresentSubjunctive() {

        if (isEndingAr) {

                if (hasStemChange) {
                    conjugationYo = stemChangedVerb.replace("ar", "e");
                    conjugationTu = stemChangedVerb.replace("ar", "es");
                    conjugationEl = stemChangedVerb.replace("ar", "e");
                    conjugationNos = infinitive.replace("ar", "emos");
                    conjugationOs = infinitive.replace("ar", "éis");
                    conjugationEllos = stemChangedVerb.replace("ar", "en");
                } else {
                    conjugationYo = infinitive.replace("ar", "e");
                    conjugationTu = infinitive.replace("ar", "es");
                    conjugationEl = infinitive.replace("ar", "e");
                    conjugationNos = infinitive.replace("ar", "emos");
                    conjugationOs = infinitive.replace("ar", "éis");
                    conjugationEllos = infinitive.replace("ar", "en");
                }
            } else if (isEndingEr) {

                if (hasStemChange) {
                    conjugationYo = stemChangedVerb.replace("er", "a");
                    conjugationTu = stemChangedVerb.replace("er", "as");
                    conjugationEl = stemChangedVerb.replace("er", "a");
                    conjugationNos = infinitive.replace("er", "amos");
                    conjugationOs = infinitive.replace("er", "áis");
                    conjugationEllos = stemChangedVerb.replace("er", "an");
                } else {
                    if (infinitive.endsWith("cer")) {
                        if (infinitive.endsWith("hacer")) {
                            conjugationYo = infinitive.replace("cer", "ga");
                            conjugationTu = infinitive.replace("cer", "gas");
                            conjugationEl = infinitive.replace("cer", "ga");
                            conjugationNos = infinitive.replace("cer", "gamos");
                            conjugationOs = infinitive.replace("cer", "gáis");
                            conjugationEllos = infinitive.replace("cer", "gan");
                        } else {
                            conjugationYo = infinitive.replace("cer", "zca");
                            conjugationTu = infinitive.replace("cer", "zcas");
                            conjugationEl = infinitive.replace("cer", "zca");
                            conjugationNos = infinitive.replace("cer", "zcamos");
                            conjugationOs = infinitive.replace("cer", "zcáis");
                            conjugationEllos = infinitive.replace("cer", "zcan");
                        }
                    } else if (infinitive.endsWith("tener")) {
                        conjugationYo = infinitive.replace("er", "ga");
                        conjugationTu = infinitive.replace("er", "gas");
                        conjugationEl = infinitive.replace("er", "ga");
                        conjugationNos = infinitive.replace("er", "gamos");
                        conjugationOs = infinitive.replace("er", "gáis");
                        conjugationEllos = infinitive.replace("er", "gan");
                    } else if (infinitive.endsWith("suponer")) {
                        conjugationYo = infinitive.replace("er", "ga");
                        conjugationTu = infinitive.replace("er", "gas");
                        conjugationEl = infinitive.replace("er", "ga");
                        conjugationNos = infinitive.replace("er", "gamos");
                        conjugationOs = infinitive.replace("er", "gáis");
                        conjugationEllos = infinitive.replace("er", "gan");
                    } else if (infinitive.endsWith("aer")) {
                        conjugationYo = infinitive.replace("er", "iga");
                        conjugationTu = infinitive.replace("er", "igas");
                        conjugationEl = infinitive.replace("er", "iga");
                        conjugationNos = infinitive.replace("er", "igamos");
                        conjugationOs = infinitive.replace("er", "igáis");
                        conjugationEllos = infinitive.replace("er", "igan");
                    } else if (infinitive.endsWith("caber")) {
                        conjugationYo = infinitive.replace("caber", "quepa");
                        conjugationTu = infinitive.replace("caber", "quepas");
                        conjugationEl = infinitive.replace("caber", "quepa");
                        conjugationNos = infinitive.replace("caber", "quepamos");
                        conjugationOs = infinitive.replace("caber", "quepáis");
                        conjugationEllos = infinitive.replace("caber", "quepan");
                    } else if (infinitive.endsWith("valer")) {
                        conjugationYo = infinitive.replace("valer", "valga");
                        conjugationTu = infinitive.replace("valer", "valgas");
                        conjugationEl = infinitive.replace("valer", "valga");
                        conjugationNos = infinitive.replace("valer", "valgamos");
                        conjugationOs = infinitive.replace("valer", "valgáis");
                        conjugationEllos = infinitive.replace("valer", "valgan");
                    } else {
                        conjugationYo = infinitive.replace("er", "a");
                        conjugationTu = infinitive.replace("er", "as");
                        conjugationEl = infinitive.replace("er", "a");
                        conjugationNos = infinitive.replace("er", "amos");
                        conjugationOs = infinitive.replace("er", "áis");
                        conjugationEllos = infinitive.replace("er", "an");
                    }
                }
            } else if (isEndingIr) {

                if (hasStemChange) {
                    conjugationYo = stemChangedVerb.replace("ir", "a");
                    conjugationTu = stemChangedVerb.replace("ir", "as");
                    conjugationEl = stemChangedVerb.replace("ir", "a");
                    if (infinitive.equals("dormir")) {
                        conjugationNos = "durmamos";
                        conjugationOs = "durmáis";
                    } else if (infinitive.equals("sentir")) {
                        conjugationNos = "sintamos";
                        conjugationOs = "sintáis";
                    } else if (infinitive.equals("pedir")) {
                        conjugationNos = "pidamos";
                        conjugationOs = "pidáis";
                    } else {
                        conjugationNos = infinitive.replace("ir", "amos");
                        conjugationOs = infinitive.replace("ir", "áis");
                    }
                    conjugationEllos = stemChangedVerb.replace("ir", "an");
                } else {
                    conjugationYo = infinitive.replace("ir", "a");
                    conjugationTu = infinitive.replace("ir", "as");
                    conjugationEl = infinitive.replace("ir", "a");
                    conjugationNos = infinitive.replace("ir", "amos");
                    conjugationOs = infinitive.replace("ir", "áis");
                    conjugationEllos = infinitive.replace("ir", "an");
                }
            }

            setText();
        }


    public void conjugateImperfectSubjunctive() {

        if (isEndingAr) {
            // first conjugates to preterite tense of ellos/ellas/ustedes form
            infinitive = infinitive.replace("ar", "aron");

            // then change to imperfect subjunctive endings
            conjugationYo = infinitive.replace("ron", "ra");
            conjugationTu = infinitive.replace("ron", "ras");
            conjugationEl = infinitive.replace("ron", "ra");
            conjugationNos = infinitive.replace("aron", "áramos");
            conjugationOs = infinitive.replace("ron", "rais");
            conjugationEllos = infinitive.replace("ron", "ran");
        } else if (isEndingEr) {
            // first conjugates to preterite tense of ellos/ellas/ustedes form
            if (infinitive.endsWith("eer")) {
                infinitive = infinitive.replace("er", "yeron");
            } else if (infinitive.endsWith("aer")) {
               infinitive = infinitive.replace("er", "jeron");
            } else if (infinitive.endsWith("hacer")) {
                infinitive = infinitive.replace("hacer", "hicieron");
            } else if (infinitive.endsWith("tener")) {
                infinitive = infinitive.replace("tener", "tuvieron");
            } else {
                infinitive = infinitive.replace("er", "ieron");
            }

            // then change to imperfect subjunctive endings
            conjugationYo = infinitive.replace("ron", "ra");
            conjugationTu = infinitive.replace("ron", "ras");
            conjugationEl = infinitive.replace("ron", "ra");
            conjugationNos = infinitive.replace("eron", "éramos");
            conjugationOs = infinitive.replace("ron", "rais");
            conjugationEllos = infinitive.replace("ron", "ran");
        } else if (isEndingIr) {

            /* For stem changed -ir verbs from preterite tense */
            int index;
            String stemChangedVerb1 = infinitive;
            String stemChangedVerb2 = infinitive;
            boolean nextIndexI = Arrays.asList(otherStemChangingVerbsI).contains(infinitive);

            // first conjugates to preterite tense of ellos/ellas/ustedes form
            if (hasStemChange) {
                if (E2I) {
                    if (nextIndexI) {
                        if (infinitive.equals("perseguir")) {
                            index = stemChangedVerb1.indexOf("e");
                            int nextIndex = index + 3;
                            StringBuilder sb = new StringBuilder(stemChangedVerb1);
                            sb = sb.replace(nextIndex, nextIndex + 1, "i");
                            stemChangedVerb1 = sb.toString();
                            infinitive = stemChangedVerb1.replace("ir", "ieron");
                        } else {
                            index = stemChangedVerb1.indexOf("e");
                            int nextIndex = index + 2;
                            StringBuilder sb = new StringBuilder(stemChangedVerb1);
                            sb = sb.replace(nextIndex, nextIndex + 1, "i");
                            stemChangedVerb1 = sb.toString();
                            infinitive = stemChangedVerb1.replace("ir", "ieron");
                        }
                    } else {
                        // finds "e" and changes to stem "i"
                        index = stemChangedVerb1.indexOf("e");
                        StringBuilder sb3 = new StringBuilder(stemChangedVerb1);
                        sb3 = sb3.replace(index, index + 1, "i");
                        stemChangedVerb1 = sb3.toString();
                        infinitive = stemChangedVerb1.replace("ir", "ieron");
                    }
                } else if (O2UE) {
                    // finds "o" and changes to stem "u"
                    index = stemChangedVerb2.indexOf("o");
                    StringBuilder sb4 = new StringBuilder(stemChangedVerb2);
                    sb4 = sb4.replace(index, index + 1, "u");
                    stemChangedVerb2 = sb4.toString();
                    infinitive = stemChangedVerb2.replace("ir", "ieron");
                }
            } else if (infinitive.endsWith("uir")) {
                infinitive = infinitive.replace("ir", "yeron");
            } else {
                infinitive = infinitive.replace("ir", "ieron");
            }

            // then change to imperfect subjunctive endings
            conjugationYo = infinitive.replace("ron", "ra");
            conjugationTu = infinitive.replace("ron", "ras");
            conjugationEl = infinitive.replace("ron", "ra");
            conjugationNos = infinitive.replace("eron", "éramos");
            conjugationOs = infinitive.replace("ron", "rais");
            conjugationEllos = infinitive.replace("ron", "ran");
        }

        setText();
    }


    public static void conjugateVerbConditional() {
        if (infinitive.equals("valer")) {
            conjugationYo = "valdría";
            conjugationTu = "valdrías";
            conjugationEl = "valdría";
            conjugationNos = "valdríamos";
            conjugationOs = "valdríais";
            conjugationEllos = "valdrían";
        } else if (infinitive.equals("caber")) {
            conjugationYo = "cabría";
            conjugationTu = "cabrías";
            conjugationEl = "cabría";
            conjugationNos = "cabríamos";
            conjugationOs = "cabríais";
            conjugationEllos = "cabrían";
        } else if (infinitive.endsWith("deshacer")) {
            conjugationYo = "desharía";
            conjugationTu = "desharías";
            conjugationEl = "desharía";
            conjugationNos = "desharíamos";
            conjugationOs = "desharíais";
            conjugationEllos = "desharían";
        } else if (infinitive.endsWith("suponer")) {
            conjugationYo = "supondría";
            conjugationTu = "supondrías";
            conjugationEl = "supondría";
            conjugationNos = "supondríamos";
            conjugationOs = "supondríais";
            conjugationEllos = "supondrían";
        } else if (infinitive.endsWith("tener")) {
            conjugationYo = infinitive.replace("tener", "tendría");
            conjugationTu = infinitive.replace("tener", "tendrías");
            conjugationEl = infinitive.replace("tener", "tendría");
            conjugationNos = infinitive.replace("tener", "tendríamos");
            conjugationOs = infinitive.replace("tener", "tendríais");
            conjugationEllos = infinitive.replace("tener", "tendrían");
        } else {
            conjugationYo = infinitive + "ía";
            conjugationTu = infinitive + "ías";
            conjugationEl = infinitive + "ía";
            conjugationNos = infinitive + "íamos";
            conjugationOs = infinitive + "íais";
            conjugationEllos = infinitive + "ían";
        }

        setText();
    }

    // Sets and clears the text of these placeholder text views to the conjugation
    public static void setText() {
        mYoTextView.setText(conjugationYo);
        mTuTextView.setText(conjugationTu);
        mElTextView.setText(conjugationEl);
        mNosTextView.setText(conjugationNos);
        mOsTextView.setText(conjugationOs);
        mEllosTextView.setText(conjugationEllos);
    }

    public static void clearText() {
        conjugationYo = " ";
        conjugationTu = " ";
        conjugationEl = " ";
        conjugationNos = " ";
        conjugationOs = " ";
        conjugationEllos = " ";
        setText();
    }

    private void stemChange() {
        int index;

        boolean nextIndexIE = Arrays.asList(otherStemChangingVerbsIE).contains(infinitive);
        boolean nextIndexI = Arrays.asList(otherStemChangingVerbsI).contains(infinitive);

        // another string that equals the value of "infinitive",
        // string is stem-changed in the conditional below
        stemChangedVerb = infinitive;

        if (E2IE) {
            if (nextIndexIE) {
                if (!infinitive.equals("preferir")) {
                    index = stemChangedVerb.indexOf("e");
                    int nextIndex = index + 3;
                    StringBuilder sb = new StringBuilder(stemChangedVerb);
                    sb = sb.replace(nextIndex, nextIndex + 1, "ie");
                    stemChangedVerb = sb.toString();
                } else {
                    index = stemChangedVerb.indexOf("e");
                    int nextIndex = index + 2;
                    StringBuilder sb = new StringBuilder(stemChangedVerb);
                    sb = sb.replace(nextIndex, nextIndex + 1, "ie");
                    stemChangedVerb = sb.toString();
                }
            } else {
                // finds "e" and changes to stem "ie"
                index = stemChangedVerb.indexOf("e");
                StringBuilder sb = new StringBuilder(stemChangedVerb);
                sb = sb.replace(index, index + 1, "ie");
                stemChangedVerb = sb.toString();
            }
        } else if (O2UE) {
            // finds "o" and changes to stem "ue"
            index = stemChangedVerb.indexOf("o");
            StringBuilder sb = new StringBuilder(stemChangedVerb);
            sb = sb.replace(index, index + 1, "ue");
            stemChangedVerb = sb.toString();
        } else if (E2I) {
            if (nextIndexI) {
                if (infinitive.equals("perseguir")) {
                    index = stemChangedVerb.indexOf("e");
                    int nextIndex = index + 3;
                    StringBuilder sb = new StringBuilder(stemChangedVerb);
                    sb = sb.replace(nextIndex, nextIndex + 1, "i");
                    stemChangedVerb = sb.toString();
                } else {
                    index = stemChangedVerb.indexOf("e");
                    int nextIndex = index + 2;
                    StringBuilder sb = new StringBuilder(stemChangedVerb);
                    sb = sb.replace(nextIndex, nextIndex + 1, "i");
                    stemChangedVerb = sb.toString();
                }
            } else {
                // finds "e" and changes to stem "i"
                index = stemChangedVerb.indexOf("e");
                StringBuilder sb = new StringBuilder(stemChangedVerb);
                sb = sb.replace(index, index + 1, "i");
                stemChangedVerb = sb.toString();
            }
        } else if (U2UE) {
            // finds "u" and changes to stem "ue"
            index = stemChangedVerb.indexOf("u");
            StringBuilder sb = new StringBuilder(stemChangedVerb);
            sb = sb.replace(index, index + 1, "ue");
            stemChangedVerb = sb.toString();
        } else if (O2HUE) {
            // finds "o" and changes to stem "hue"
            index = stemChangedVerb.indexOf("o");
            StringBuilder sb = new StringBuilder(stemChangedVerb);
            sb = sb.replace(index, index + 1, "hue");
            stemChangedVerb = sb.toString();
        }
    }

    // Spelling change for pronunciation in imperative, subjunctive form
    private void spellingChange() {

        if (isEndingAr) {
            if (infinitive.endsWith("car")) {
                 infinitive = infinitive.replace("car", "quar");
            } else if (infinitive.endsWith("gar")) {
                infinitive = infinitive.replace("gar", "guar");
            } else if (infinitive.endsWith("zar")) {
                infinitive = infinitive.replace("zar", "car");
            }
        } else if (isEndingEr) {
            if (infinitive.endsWith("ger")) {
                infinitive = infinitive.replace("ger", "jer");
            }
        } else if (isEndingIr) {
            if (infinitive.endsWith("guir")) {
                infinitive = infinitive.replace("guir", "gir");
            } else if (infinitive.endsWith("gir")) {
                infinitive = infinitive.replace("gir", "jir");
            }
        }
    }

    private void spellingChangeForSubjunctive() {
        // Spelling change of -car, -gar, -zar verbs
        if (hasSpellingChange) { spellingChange(); }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        // verbTense is the position of the item selected in the spinner
        verbTense = mConjugationTypeSpinner.getSelectedItemPosition();
        /* 0 = present tense, 1 = preterite tense, 2 = imperfect tense, 3 = future tense,
           4 = affirmative imperative tense,  5 = negative imperative tense,
           6 = present subjunctive tense, 7 = imperfect subjunctive tense
         */
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(MainFragment.mMainTextField.getWindowToken(), 0);
    }
}

