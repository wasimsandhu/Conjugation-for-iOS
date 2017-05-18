package com.wsandhu.conjugation;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class PerfectFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    public static String infinitive, pastParticiple;
    public static String conjugationYo, conjugationTu, conjugationEl, conjugationNos, conjugationOs, conjugationEllos;

    public static TextView mYoTextView, mTuTextView, mElTextView, mNosTextView, mOsTextView, mEllosTextView;
    Spinner mConjugationTypeSpinner;
    public static AutoCompleteTextView mPerfTextField;
    Button mConjugateButton;

    public static boolean isEndingAr, isEndingEr, isEndingIr, isIrregularPastParticiple, isNotGoingToWork;

    public static int verbTense;

    public static String[] irregularPastParticiples = {"abrir", "decir", "cubrir", "descubrir", "poner", "freír",
            "hacer", "imprimir", "ir", "morir", "escribir", "resolver", "romper", "ver", "volver", "querer"};

    public static String[] verbsVoidToAlgorithms = {"arreglar", "ejercer", "merecer", "perder", "permanecer", "pertenecer",
            "agarrar", "aguardar", "alarmar", "apartar", "argumentar", "armar", "arrancar", "arreglar", "arrestar",
            "caracterizar", "cargar", "cariar", "cariciar", "clarificar", "comparar", "contrariar", "charlar",
            "declarar", "descarriar", "disparar", "embarazar", "encarcelar", "encargar", "garantizar", "martillar",
            "paralizar", "parar", "participar", "preparar", "reparar", "variar", "dirigir", "circunvenir", "adquirir", "marcar",
            "articular", "arriar", "arrojar", "arrastrar", "aclarar" };

    public PerfectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_perfect, container, false);

        // Casting the XML text views into Java objects...
        mYoTextView = (TextView) rootView.findViewById(R.id.perfYoTextView);
        mTuTextView = (TextView) rootView.findViewById(R.id.perfTuTextView);
        mElTextView = (TextView) rootView.findViewById(R.id.perfElTextView);
        mNosTextView = (TextView) rootView.findViewById(R.id.perfNosTextView);
        mOsTextView = (TextView) rootView.findViewById(R.id.perfOsTextView);
        mEllosTextView = (TextView) rootView.findViewById(R.id.perfEllosTextView);

        // Spinner for picking how to conjugate the verb
        mConjugationTypeSpinner = (Spinner) rootView.findViewById(R.id.perfConjugationTypeSpinner);

        ArrayAdapter<CharSequence> perfAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.perfect_conjugation_types, android.R.layout.simple_spinner_item);
        perfAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mConjugationTypeSpinner.setAdapter(perfAdapter);
        mConjugationTypeSpinner.setOnItemSelectedListener(this);

        // Grabs input from text field and places it in String infinitive
        mPerfTextField = (AutoCompleteTextView) rootView.findViewById(R.id.perfTextField);

        String[] verbs = getResources().getStringArray(R.array.verbs);
        ArrayAdapter<String> autoCompleteAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, verbs);
        mPerfTextField.setAdapter(autoCompleteAdapter);
        mPerfTextField.getBackground().setColorFilter(getResources().getColor(R.color.primaryColorDark), PorterDuff.Mode.SRC_ATOP);

        mPerfTextField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPerfTextField.setText("");
            }
        });

        mPerfTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {

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

        /* The conjugate button code
        mConjugateButton = (Button) rootView.findViewById(R.id.perfConjugateButton);
        mConjugateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infinitive = mPerfTextField.getText().toString();
                MainFragment.mMainTextField.setText(infinitive);
                OtherFragment.mOtherTextField.setText(infinitive);
                isNotGoingToWork = Arrays.asList(verbsVoidToAlgorithms).contains(infinitive);

                if (isNotGoingToWork) {
                    replaceWithMoreThanOneEnding();
                } else {
                    makePastParticiple();
                }
                conjugate();
            }
        }); */

        return rootView;
    }

    public static void makePastParticiple() {

        // booleans for checking verb type
        isEndingAr = infinitive.endsWith("ar");
        isEndingEr = infinitive.endsWith("er");
        isEndingIr = infinitive.endsWith("ir");
        if (infinitive.endsWith("ír")) { isEndingIr = true; }
        isIrregularPastParticiple = Arrays.asList(irregularPastParticiples).contains(infinitive);

        if (isEndingAr && !isIrregularPastParticiple) {
            // -ar endings
            pastParticiple = infinitive.replace("ar", "ado");
        } else if (isEndingEr && !isIrregularPastParticiple) {
            // -er endings
            pastParticiple = infinitive.replace("er", "ido");
            if (infinitive.endsWith("aer")) {
                pastParticiple = infinitive.replace("aer", "aído");
            } else if (infinitive.endsWith("eer")) {
                pastParticiple = infinitive.replace("eer", "eído");
            }
        } else if (isEndingIr && !isIrregularPastParticiple) {
            // -ir endings
            pastParticiple = infinitive.replace("ir", "ido");
            if (infinitive.endsWith("ír")) {
                pastParticiple = infinitive.replace("ír", "ído");
            }
        } else {
            // method call in IrregularVerb.java
            IrregularVerb.makePastParticiple();
        }
    }

    private static void replaceWithMoreThanOneEnding() {

        // booleans for checking verb type
        isEndingAr = infinitive.endsWith("ar");
        isEndingEr = infinitive.endsWith("er");
        isEndingIr = infinitive.endsWith("ir");

        int index;

        if (isEndingAr) {
            // change ending to something else
            index = infinitive.lastIndexOf("ar");
            StringBuilder sb = new StringBuilder(infinitive);
            sb = sb.replace(index, index + 2, "bby");
            infinitive = sb.toString();
            pastParticiple = infinitive.replace("bby", "ado");
        } else if (isEndingEr) {
            // change ending to something else
            index = infinitive.lastIndexOf("er");
            StringBuilder sb = new StringBuilder(infinitive);
            sb = sb.replace(index, index + 2, "bby");
            infinitive = sb.toString();
            pastParticiple = infinitive.replace("bby", "ido");
        } else if (isEndingIr) {
            // change ending to something else
            index = infinitive.lastIndexOf("ir");
            StringBuilder sb = new StringBuilder(infinitive);
            sb = sb.replace(index, index + 2, "bby");
            infinitive = sb.toString();
            pastParticiple = infinitive.replace("bby", "ido");
        }
    }

    protected void conjugate() {

        infinitive = mPerfTextField.getText().toString();
        OtherFragment.mOtherTextField.setText(infinitive);
        isNotGoingToWork = Arrays.asList(verbsVoidToAlgorithms).contains(infinitive);

        if (isNotGoingToWork) {
            replaceWithMoreThanOneEnding();
        } else {
            makePastParticiple();
        }

        if (!infinitive.equals("")) {
            if (verbTense == 0) {
                conjugationYo = "he " + pastParticiple;
                conjugationTu = "has " + pastParticiple;
                conjugationEl = "ha " + pastParticiple;
                conjugationNos = "hemos " + pastParticiple;
                conjugationOs = "habéis " + pastParticiple;
                conjugationEllos = "han " + pastParticiple;
            } else if (verbTense == 1) {
                conjugationYo = "había " + pastParticiple;
                conjugationTu = "habías " + pastParticiple;
                conjugationEl = "había " + pastParticiple;
                conjugationNos = "habíamos " + pastParticiple;
                conjugationOs = "habíais " + pastParticiple;
                conjugationEllos = "habían " + pastParticiple;
            } else if (verbTense == 2) {
                conjugationYo = "habré " + pastParticiple;
                conjugationTu = "habrás " + pastParticiple;
                conjugationEl = "habrá " + pastParticiple;
                conjugationNos = "habremos " + pastParticiple;
                conjugationOs = "habréis " + pastParticiple;
                conjugationEllos = "habrán " + pastParticiple;
            } else if (verbTense == 3) {
                conjugationYo = "haya " + pastParticiple;
                conjugationTu = "hayas " + pastParticiple;
                conjugationEl = "haya " + pastParticiple;
                conjugationNos = "hayamos " + pastParticiple;
                conjugationOs = "hayáis " + pastParticiple;
                conjugationEllos = "hayan " + pastParticiple;
            } else if (verbTense == 4) {
                conjugationYo = "hubiera " + pastParticiple;
                conjugationTu = "hubieras " + pastParticiple;
                conjugationEl = "hubiera " + pastParticiple;
                conjugationNos = "hubiéramos " + pastParticiple;
                conjugationOs = "hubierais " + pastParticiple;
                conjugationEllos = "hubieran " + pastParticiple;
            } else if (verbTense == 5) {
                conjugationYo = "habría " + pastParticiple;
                conjugationTu = "habrías " + pastParticiple;
                conjugationEl = "habría " + pastParticiple;
                conjugationNos = "habríamos " + pastParticiple;
                conjugationOs = "habríais " + pastParticiple;
                conjugationEllos = "habrían " + pastParticiple;
            }
        } else {

        }

        setText();
        hideKeyboard();
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

    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        // verbTense is the position of the item selected in the spinner
        verbTense = mConjugationTypeSpinner.getSelectedItemPosition();
        /* 0 = present perfect tense, 1 = past perfect tense, 2 = future perfect tense */
        conjugate();
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