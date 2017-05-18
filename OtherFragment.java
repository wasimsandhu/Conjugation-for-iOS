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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Arrays;

public class OtherFragment extends android.support.v4.app.Fragment {

    public static String infinitive, translation, gerund, pastParticiple;
    public static TextView translationTextView, gerundTextView, pastParticipleTextView;
    public static boolean isEndingAr, isEndingEr, isEndingIr, isIrregularPastParticiple,
            isIrregularGerund, isNotGoingToWork, isVerb;
    public static AutoCompleteTextView mOtherTextField;
    Button mConjugateButton;

    static String[] stemChangeGerunds = {"advertir", "competir", "conseguir", "consentir", "convertir",
            "decir", "hervir", "mentir", "pedir", "reñir", "repetir", "seguir", "servir", "sugerir",
            "venir", "poder", "dormir", "morir", "querer"};

    public static String[] irregularPastParticiples = {"abrir", "decir", "cubrir", "descubrir", "poner", "freír",
            "hacer", "imprimir", "ir", "morir", "escribir", "resolver", "romper", "ver", "volver", "querer"};

    public static String[] verbsVoidToAlgorithms = {"arreglar", "aclarar", "ejercer", "merecer", "perder", "permanecer", "pertenecer",
            "agarrar", "aguardar", "alarmar", "apartar", "argumentar", "armar", "arrancar", "arreglar", "arrestar",
            "caracterizar", "cargar", "cariar", "cariciar", "clarificar", "comparar", "contrariar", "charlar",
            "declarar", "descarriar", "disparar", "embarazar", "encarcelar", "encargar", "garantizar", "martillar",
            "paralizar", "parar", "participar", "preparar", "reparar", "variar", "dirigir", "circunvenir", "adquirir",
            "acarrear", "marcar", "articular", "arriar", "arrojar", "arrastrar"};


    public OtherFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_other, container, false);

        translationTextView = (TextView) rootView.findViewById(R.id.translation);
        gerundTextView = (TextView) rootView.findViewById(R.id.gerund);
        pastParticipleTextView = (TextView) rootView.findViewById(R.id.pastParticiple);

        mOtherTextField = (AutoCompleteTextView) rootView.findViewById(R.id.otherTextField);
        String[] verbs = getResources().getStringArray(R.array.verbs);
        ArrayAdapter<String> autoCompleteAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, verbs);
        mOtherTextField.setAdapter(autoCompleteAdapter);

        mOtherTextField.getBackground().setColorFilter(getResources().getColor(R.color.primaryColorDark), PorterDuff.Mode.SRC_ATOP);

        mOtherTextField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOtherTextField.setText("");
            }
        });

        mOtherTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {

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

        mConjugateButton = (Button) rootView.findViewById(R.id.otherConjugateButton);
        mConjugateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conjugate();
            }
        });

        return rootView;

    }

    private void conjugate() {

        infinitive = mOtherTextField.getText().toString();

        isNotGoingToWork = Arrays.asList(verbsVoidToAlgorithms).contains(infinitive);
        isIrregularPastParticiple = Arrays.asList(irregularPastParticiples).contains(infinitive);

        // booleans for checking verb type
        isEndingAr = infinitive.endsWith("ar");
        isEndingEr = infinitive.endsWith("er");
        isEndingIr = infinitive.endsWith("ir");
        if (infinitive.endsWith("ír")) { isEndingIr = true; }

        if (isEndingAr) { isVerb = true; }
        if (isEndingEr) { isVerb = true; }
        if (isEndingIr) { isVerb = true; }

        if (isVerb) {
            getTranslation();

            if (isNotGoingToWork) {
                replaceWithMoreThanOneEnding();
                replaceWithMoreThanOneEnding2();
            } else {
                getGerund();
                getPastParticiple();
            }

        } else {

        }

        hideKeyboard();
    }

    private static void getTranslation() {
        // TODO All of this -_-
        if (infinitive.equals("abandonar")) { translation = "to abandon"; }
        else if (infinitive.equals("abatir")) { translation = "to overthrow"; }
        else if (infinitive.equals("abolir")) { translation = "to abolish"; }
        else if (infinitive.equals("abrazar")) { translation = "to hug"; }
        else if (infinitive.equals("abrir")) { translation = "to open"; }
        else if (infinitive.equals("absolver")) { translation = "to absolve"; }
        else if (infinitive.equals("absorber")) { translation = "to absorb"; }
        else if (infinitive.equals("abstener")) { translation = "to abstain"; }
        else if (infinitive.equals("aburrir")) { translation = "to bore"; }
        else if (infinitive.equals("abusar")) { translation = "to abuse"; }
        else if (infinitive.equals("acabar")) { translation = "to complete"; }
        else if (infinitive.equals("acampar")) { translation = "to camp"; }
        else if (infinitive.equals("acelerar")) { translation = "to accelerate"; }
        else if (infinitive.equals("aceptar")) { translation = "to accept"; }
        else if (infinitive.equals("acercar")) { translation = "to bring close"; }
        else if (infinitive.equals("acertar")) { translation = "to hit the mark"; }
        else if (infinitive.equals("aclamar")) { translation = "to acclaim"; }
        else if (infinitive.equals("aclarar")) { translation = "to clarify"; }
        else if (infinitive.equals("acompañar")) { translation = "to accompany"; }
        else if (infinitive.equals("aconsejar")) { translation = "to advise"; }
        else if (infinitive.equals("acordar")) { translation = "to remember"; }
        else if (infinitive.equals("acostar")) { translation = "to lay down"; }
        else if (infinitive.equals("acostumbrar")) { translation = "to be accustomed"; }
        else if (infinitive.equals("actualizar")) { translation = "to realize"; }
        else if (infinitive.equals("actuar")) { translation = "to act"; }
        else if (infinitive.equals("acuchillar")) { translation = "to cut open"; }
        else if (infinitive.equals("acudir")) { translation = "to answer a call"; }
        else if (infinitive.equals("acumular")) { translation = "to accumulate"; }
        else if (infinitive.equals("acusar")) { translation = "to accuse"; }
        else if (infinitive.equals("adaptar")) { translation = "to adapt"; }
        else if (infinitive.equals("adelantar")) { translation = "to advance"; }
        else if (infinitive.equals("adivinar")) { translation = "to guess"; }
        else if (infinitive.equals("administrar")) { translation = "to administer"; }
        else if (infinitive.equals("admirar")) { translation = "to admire"; }
        else if (infinitive.equals("admitir")) { translation = "to admit"; }
        else if (infinitive.equals("adoptar")) { translation = "to adopt"; }
        else if (infinitive.equals("adorar")) { translation = "to adore"; }
        else if (infinitive.equals("adornar")) { translation = "to adorn"; }
        else if (infinitive.equals("adquirir")) { translation = "to acquire"; }
        else if (infinitive.equals("advertir")) { translation = "to advise"; }
        else if (infinitive.equals("afectar")) { translation = "to affect"; }
        else if (infinitive.equals("afeitar")) { translation = "to shave"; }
        else if (infinitive.equals("afirmar")) { translation = "to affirm"; }
        else if (infinitive.equals("afligir")) { translation = "to be afflicted"; }
        else if (infinitive.equals("afluir")) { translation = "to flow into"; }
        else if (infinitive.equals("agachar")) { translation = "to bend down"; }
        else if (infinitive.equals("agarrar")) { translation = "to grab"; }
        else if (infinitive.equals("agitar")) { translation = "to agitate"; }
        else if (infinitive.equals("agotar")) { translation = "to exhaust"; }
        else if (infinitive.equals("agradecer")) { translation = "to thank for"; }
        else if (infinitive.equals("agrandar")) { translation = "to enlarge"; }
        else if (infinitive.equals("agravar")) { translation = "to aggravate"; }
        else if (infinitive.equals("agraviar")) { translation = "to offend"; }
        else if (infinitive.equals("agregar")) { translation = "to aggregate"; }
        else if (infinitive.equals("agriar")) { translation = "to embitter"; }
        else if (infinitive.equals("agrupar")) { translation = "to group"; }
        else if (infinitive.equals("aguantar")) { translation = "to endure"; }
        else if (infinitive.equals("aguardar")) { translation = "to expect"; }
        else if (infinitive.equals("agujerear")) { translation = "to pierce"; }
        else if (infinitive.equals("ahogar")) { translation = "to suffocate"; }
        else if (infinitive.equals("ahorrar")) { translation = "to save"; }
        else if (infinitive.equals("aislar")) { translation = "to isolate"; }
        else if (infinitive.equals("alarmar")) { translation = "to alarm"; }
        else if (infinitive.equals("alcanzar")) { translation = "to reach for"; }
        else if (infinitive.equals("aliar")) { translation = "to ally"; }
        else if (infinitive.equals("alimentar")) { translation = "to nourish"; }
        else if (infinitive.equals("aliviar")) { translation = "to alleviate"; }
        else if (infinitive.equals("almacenar")) { translation = "to store"; }
        else if (infinitive.equals("almorzar")) { translation = "to eat lunch"; }
        else if (infinitive.equals("alojar")) { translation = "to lodge"; }
        else if (infinitive.equals("alquilar")) { translation = "to rent"; }
        else if (infinitive.equals("alterar")) { translation = "to alter"; }
        else if (infinitive.equals("alumbrar")) { translation = "to illuminate"; }
        else if (infinitive.equals("alzar")) { translation = "to store"; }
        else if (infinitive.equals("amanecer")) { translation = "to wake up at dawn"; }
        else if (infinitive.equals("amar")) { translation = "to love"; }
        else if (infinitive.equals("amenazar")) { translation = "to threaten"; }
        else if (infinitive.equals("amnistiar")) { translation = "to amnesty"; }
        else if (infinitive.equals("amplifiar")) { translation = "to amplify"; }
        else if (infinitive.equals("amplificar")) { translation = "to amplify"; }
        else if (infinitive.equals("analizar")) { translation = "to analyze"; }
        else if (infinitive.equals("andar")) { translation = "to be about"; }
        else if (infinitive.equals("anochecer")) { translation = "to become night"; }
        else if (infinitive.equals("anular")) { translation = "to annul"; }
        else if (infinitive.equals("anunciar")) { translation = "to announce"; }
        else if (infinitive.equals("añadir")) { translation = "to add"; }
        else if (infinitive.equals("apaciguar")) { translation = "to pacify"; }
        else if (infinitive.equals("apagar")) { translation = "to turn off"; }
        else if (infinitive.equals("aparecer")) { translation = "to appear"; }
        else if (infinitive.equals("apartar")) { translation = "to separate"; }
        else if (infinitive.equals("apestar")) { translation = "to corrupt"; }
        else if (infinitive.equals("aplaudir")) { translation = "to applaud"; }
        else if (infinitive.equals("aplicar")) { translation = "to apply"; }
        else if (infinitive.equals("apoyar")) { translation = "to support"; }
        else if (infinitive.equals("apreciar")) { translation = "to appreciate"; }
        else if (infinitive.equals("aprehender")) { translation = "to aprehend"; }
        else if (infinitive.equals("aprender")) { translation = "to learn"; }
        else if (infinitive.equals("apretar")) { translation = "to tighten"; }
        else if (infinitive.equals("aprobar")) { translation = "to approve"; }
        else if (infinitive.equals("apurar")) { translation = "to grieve"; }
        else if (infinitive.equals("argumentar")) { translation = "to argue"; }
        else if (infinitive.equals("armar")) { translation = "to arm"; }
        else if (infinitive.equals("arrancar")) { translation = "to pull up"; }
        else if (infinitive.equals("arreglar")) { translation = "to repair"; }
        else if (infinitive.equals("arrestar")) { translation = "to arrest"; }
        else if (infinitive.equals("arriar")) { translation = "to lower"; }
        else if (infinitive.equals("arrojar")) { translation = "to throw"; }
        else if (infinitive.equals("articular")) { translation = "to articulate"; }
        else if (infinitive.equals("asaltar")) { translation = "to assault"; }
        else if (infinitive.equals("ascender")) { translation = "to ascend"; }
        else if (infinitive.equals("asegurar")) { translation = "to assure"; }
        else if (infinitive.equals("asesinar")) { translation = "to assassinate"; }
        else if (infinitive.equals("asignar")) { translation = "to assign"; }
        else if (infinitive.equals("asistir")) { translation = "to attend"; }
        else if (infinitive.equals("asociar")) { translation = "to associate"; }
        else if (infinitive.equals("aspirar")) { translation = "to vacuum"; }
        else if (infinitive.equals("asumir")) { translation = "to assume"; }
        else if (infinitive.equals("asustar")) { translation = "to scare"; }
        else if (infinitive.equals("atacar")) { translation = "to attack"; }
        else if (infinitive.equals("atender")) { translation = "to attend"; }
        else if (infinitive.equals("atraer")) { translation = "to attract"; }
        else if (infinitive.equals("atrapar")) { translation = "to overtake"; }
        else if (infinitive.equals("atribuir")) { translation = "to attribute"; }
        else if (infinitive.equals("atravesar")) { translation = "to go through"; }
        else if (infinitive.equals("aumentar")) { translation = "to increase"; }
        else if (infinitive.equals("autorizar")) { translation = "to authorize"; }
        else if (infinitive.equals("avanzar")) { translation = "to advance"; }
        else if (infinitive.equals("avergonzar")) { translation = "to be ashamed"; }
        else if (infinitive.equals("averiguar")) { translation = "to verify"; }
        else if (infinitive.equals("ayudar")) { translation = "to help"; }
        else if (infinitive.equals("ayunar")) { translation = "to fast"; }
        else if (infinitive.equals("bailar")) { translation = "to dance"; }
        else if (infinitive.equals("bajar")) { translation = "to lower"; }
        else if (infinitive.equals("balancear")) { translation = "to balance"; }
        else if (infinitive.equals("bañar")) { translation = "to bath"; }
        else if (infinitive.equals("basar")) { translation = "to base"; }
        else if (infinitive.equals("barrer")) { translation = "to sweep"; }
        else if (infinitive.equals("beber")) { translation = "to drink"; }
        else if (infinitive.equals("beneficiar")) { translation = "to benefit"; }
        else if (infinitive.equals("besar")) { translation = "to kiss"; }
        else if (infinitive.equals("bloquear")) { translation = "to block"; }
        else if (infinitive.equals("borrar")) { translation = "to erase"; }
        else if (infinitive.equals("bostezar")) { translation = "to yawn"; }
        else if (infinitive.equals("brincar")) { translation = "to jump"; }
        else if (infinitive.equals("brindar")) { translation = "to toast"; }
        else if (infinitive.equals("buscar")) { translation = "to look for"; }
        else if (infinitive.equals("cachear")) { translation = "to search"; }
        else if (infinitive.equals("caer")) { translation = "to fall"; }
        else if (infinitive.equals("calcular")) { translation = "to calculate"; }
        else if (infinitive.equals("calentar")) { translation = "to heat up"; }
        else if (infinitive.equals("calificar")) { translation = "to qualify"; }
        else if (infinitive.equals("calmar")) { translation = "to calm down"; }
        else if (infinitive.equals("callar")) { translation = "to make quiet"; }
        else if (infinitive.equals("cambiar")) { translation = "to change"; }
        else if (infinitive.equals("caminar")) { translation = "to walk"; }
        else if (infinitive.equals("cancelar")) { translation = "to cancel"; }
        else if (infinitive.equals("cansar")) { translation = "to get tired"; }
        else if (infinitive.equals("cantar")) { translation = "to sing"; }
        else if (infinitive.equals("caracterizar")) { translation = "to characterize"; }
        else if (infinitive.equals("carecer")) { translation = "to lack"; }
        else if (infinitive.equals("cargar")) { translation = "to load"; }
        else if (infinitive.equals("cariar")) { translation = "to cause cavities"; }
        else if (infinitive.equals("cariciar")) { translation = "to caress"; }
        else if (infinitive.equals("casar")) { translation = "to get married"; }
        else if (infinitive.equals("castigar")) { translation = "to chastise"; }
        else if (infinitive.equals("causar")) { translation = "to cause"; }
        else if (infinitive.equals("cauterizar")) { translation = "to cauterize"; }
        else if (infinitive.equals("cazar")) { translation = "to hunt"; }
        else if (infinitive.equals("celebrar")) { translation = "to celebrate"; }
        else if (infinitive.equals("cenar")) { translation = "to eat dinner"; }
        else if (infinitive.equals("cepillar")) { translation = "to brush"; }
        else if (infinitive.equals("cerrar")) { translation = "to close"; }
        else if (infinitive.equals("circular")) { translation = "to circulate"; }
        else if (infinitive.equals("circunvenir")) { translation = "to circumvent"; }
        else if (infinitive.equals("citar")) { translation = "to quote"; }
        else if (infinitive.equals("clarificar")) { translation = "to clarify"; }
        else if (infinitive.equals("clasificar")) { translation = "to classify"; }
        else if (infinitive.equals("cocinar")) { translation = "to cook"; }
        else if (infinitive.equals("coger")) { translation = "to choose"; }
        else if (infinitive.equals("colaborar")) { translation = "to collaborate"; }
        else if (infinitive.equals("colgar")) { translation = "to hang"; }
        else if (infinitive.equals("colocar")) { translation = "to place"; }
        else if (infinitive.equals("colonizar")) { translation = "to colonize"; }
        else if (infinitive.equals("columpiar")) { translation = "to swing"; }
        else if (infinitive.equals("combatir")) { translation = "to fight"; }
        else if (infinitive.equals("combinar")) { translation = "to combine"; }
        else if (infinitive.equals("comentar")) { translation = "to comment"; }
        else if (infinitive.equals("comenzar")) { translation = "to commence"; }
        else if (infinitive.equals("comer")) { translation = "to to eat"; }
        else if (infinitive.equals("cometer")) { translation = "to commit"; }
        else if (infinitive.equals("comparar")) { translation = "to compare"; }
        else if (infinitive.equals("compartir")) { translation = "to share"; }
        else if (infinitive.equals("compeler")) { translation = "to compel"; }
        else if (infinitive.equals("compensar")) { translation = "to compensate"; }
        else if (infinitive.equals("competir")) { translation = "to compete"; }
        else if (infinitive.equals("compilar")) { translation = "to compile"; }
        else if (infinitive.equals("completar")) { translation = "to complete"; }
        else if (infinitive.equals("complicar")) { translation = "to complicate"; }
        else if (infinitive.equals("componer")) { translation = "to compose"; }
        else if (infinitive.equals("comprar")) { translation = "to buy"; }
        else if (infinitive.equals("comprender")) { translation = "to comprehend"; }
        else if (infinitive.equals("comunicar")) { translation = "to communicate"; }
        else if (infinitive.equals("concebir")) { translation = "to conceive"; }
        else if (infinitive.equals("conceder")) { translation = "to concede"; }
        else if (infinitive.equals("concentrar")) { translation = "to concentrate"; }
        else if (infinitive.equals("concluir")) { translation = "to conclude"; }
        else if (infinitive.equals("condenar")) { translation = "to condemn"; }
        else if (infinitive.equals("condensar")) { translation = "to condense"; }
        else if (infinitive.equals("conducir")) { translation = "to drive"; }
        else if (infinitive.equals("conectar")) { translation = "to connect"; }
        else if (infinitive.equals("confesar")) { translation = "to confess"; }
        else if (infinitive.equals("confiar")) { translation = "to confide"; }
        else if (infinitive.equals("confirmar")) { translation = "to confirm"; }
        else if (infinitive.equals("confluir")) { translation = "to flow together"; }
        else if (infinitive.equals("conformar")) { translation = "to conform"; }
        else if (infinitive.equals("confortar")) { translation = "to comfort"; }
        else if (infinitive.equals("confrontar")) { translation = "to confront"; }
        else if (infinitive.equals("confundir")) { translation = "to confuse"; }
        else if (infinitive.equals("congregar")) { translation = "to congregate"; }
        else if (infinitive.equals("conllevar")) { translation = "to help with hardship"; }
        else if (infinitive.equals("conocer")) { translation = "to be familiar with"; }
        else if (infinitive.equals("conquistar")) { translation = "to conquer"; }
        else if (infinitive.equals("conseguir")) { translation = "to acquire"; }
        else if (infinitive.equals("consentir")) { translation = "to consent"; }
        else if (infinitive.equals("conservar")) { translation = "to conserve"; }
        else if (infinitive.equals("considerar")) { translation = "to consider"; }
        else if (infinitive.equals("consolar")) { translation = "to console"; }
        else if (infinitive.equals("constipar")) { translation = "to constipate"; }
        else if (infinitive.equals("constituir")) { translation = "to constitute"; }
        else if (infinitive.equals("construir")) { translation = "to construct"; }
        else if (infinitive.equals("consultar")) { translation = "to consult"; }
        else if (infinitive.equals("consumir")) { translation = "to consume"; }
        else if (infinitive.equals("contaminar")) { translation = "to contaminate"; }
        else if (infinitive.equals("contar")) { translation = "to count"; }
        else if (infinitive.equals("contemplar")) { translation = "to contemplate"; }
        else if (infinitive.equals("contener")) { translation = "to contain"; }
        else if (infinitive.equals("contestar")) { translation = "to answer"; }
        else if (infinitive.equals("continuar")) { translation = "to continue"; }
        else if (infinitive.equals("contradecir")) { translation = "to contradict"; }
        else if (infinitive.equals("contraer")) { translation = "to contract"; }
        else if (infinitive.equals("contrariar")) { translation = "to oppose"; }
        else if (infinitive.equals("contratar")) { translation = "to contract"; }
        else if (infinitive.equals("contravenir")) { translation = "to contravene"; }
        else if (infinitive.equals("contribuir")) { translation = "to contribute"; }
        else if (infinitive.equals("controlar")) { translation = "to control"; }
        else if (infinitive.equals("convencer")) { translation = "to convince"; }
        else if (infinitive.equals("convenir")) { translation = "to convene"; }
        else if (infinitive.equals("conversar")) { translation = "to have a conversation"; }
        else if (infinitive.equals("convertir")) { translation = "to convert"; }
        else if (infinitive.equals("coordinar")) { translation = "to coordinate"; }
        else if (infinitive.equals("corregir")) { translation = "to correct"; }
        else if (infinitive.equals("correr")) { translation = "to run"; }
        else if (infinitive.equals("cortar")) { translation = "to cut"; }
        else if (infinitive.equals("costar")) { translation = "to cost"; }
        else if (infinitive.equals("crear")) { translation = "to create"; }
        else if (infinitive.equals("crecer")) { translation = "to grow"; }
        else if (infinitive.equals("creer")) { translation = "to believe"; }
        else if (infinitive.equals("criar")) { translation = "to create"; }
        else if (infinitive.equals("criticar")) { translation = "to criticize"; }
        else if (infinitive.equals("cruzar")) { translation = "to cross"; }
        else if (infinitive.equals("cubrir")) { translation = "to cover"; }
        else if (infinitive.equals("cuidar")) { translation = "to take care of"; }
        else if (infinitive.equals("cumplir")) { translation = "to complete"; }
        else if (infinitive.equals("curar")) { translation = "to cute"; }
        else if (infinitive.equals("charlar")) { translation = "to chat"; }
        else if (infinitive.equals("chiflar")) { translation = "to whistle"; }
        else if (infinitive.equals("chillar")) { translation = "to shriek"; }
        else if (infinitive.equals("chirriar")) { translation = "to hiss"; }
        else if (infinitive.equals("chismear")) { translation = "to gossip"; }
        else if (infinitive.equals("chocar")) { translation = "to collide"; }
        else if (infinitive.equals("chupar")) { translation = "to suck"; }
        else if (infinitive.equals("dar")) { translation = "to give"; }
        else if (infinitive.equals("deber")) { translation = "to ought to"; }
        else if (infinitive.equals("decidir")) { translation = "to decide"; }
        else if (infinitive.equals("decir")) { translation = "to say"; }
        else if (infinitive.equals("declarar")) { translation = "to declare"; }
        else if (infinitive.equals("decorar")) { translation = "to decorate"; }
        else if (infinitive.equals("dedicar")) { translation = "to dedicate"; }
        else if (infinitive.equals("deducir")) { translation = "to deduce"; }
        else if (infinitive.equals("defender")) { translation = "to defend"; }
        else if (infinitive.equals("definir")) { translation = "to define"; }
        else if (infinitive.equals("defraudar")) { translation = "to defraud"; }
        else if (infinitive.equals("dejar")) { translation = "to leave"; }
        else if (infinitive.equals("delegar")) { translation = "to delegate"; }
        else if (infinitive.equals("deliverar")) { translation = "to deliver"; }
        else if (infinitive.equals("demandar")) { translation = "to demand"; }
        else if (infinitive.equals("demostrar")) { translation = "to demonstrate"; }
        else if (infinitive.equals("denunciar")) { translation = "to denounce"; }
        else if (infinitive.equals("depender")) { translation = "to depend"; }
        else if (infinitive.equals("deponer")) { translation = "to depose"; }
        else if (infinitive.equals("deprimir")) { translation = "to depress"; }
        else if (infinitive.equals("derivar")) { translation = "to derive"; }
        else if (infinitive.equals("desafiar")) { translation = "to dare"; }
        else if (infinitive.equals("desaparecer")) { translation = "to disappear"; }
        else if (infinitive.equals("desayunar")) { translation = "to eat breakfast"; }
        else if (infinitive.equals("descansar")) { translation = "to rest"; }
        else if (infinitive.equals("descarriar")) { translation = "to mislead"; }
        else if (infinitive.equals("descender")) { translation = "to descend"; }
        else if (infinitive.equals("descifrar")) { translation = "to decipher"; }
        else if (infinitive.equals("descomponer")) { translation = "to decompose"; }
        else if (infinitive.equals("desconfiar")) { translation = "to mistrust"; }
        else if (infinitive.equals("desconocer")) { translation = "to be unacquainted with"; }
        else if (infinitive.equals("descontar")) { translation = "to discount"; }
        else if (infinitive.equals("describir")) { translation = "to describe"; }
        else if (infinitive.equals("descubrir")) { translation = "to discover"; }
        else if (infinitive.equals("descuidar")) { translation = "to relieve from care"; }
        else if (infinitive.equals("desear")) { translation = "to wish"; }
        else if (infinitive.equals("desempeñar")) { translation = "to redeem"; }
        else if (infinitive.equals("desenchufar")) { translation = "to unplug"; }
        else if (infinitive.equals("desengañar")) { translation = "to disillusion"; }
        else if (infinitive.equals("desfigurar")) { translation = "to disfigure"; }
        else if (infinitive.equals("deshacer")) { translation = "to undo"; }
        else if (infinitive.equals("deshumanizar")) { translation = "to dehumanize"; }
        else if (infinitive.equals("desilusionar")) { translation = "to disillusion"; }
        else if (infinitive.equals("desintoxicar")) { translation = "to detoxicate"; }
        else if (infinitive.equals("desmayar")) { translation = "to faint"; }
        else if (infinitive.equals("desobstruir")) { translation = "to unclog"; }
        else if (infinitive.equals("desocupar")) { translation = "to vacate"; }
        else if (infinitive.equals("desorientar")) { translation = "to disorient"; }
        else if (infinitive.equals("despedir")) { translation = "to say goodbye"; }
        else if (infinitive.equals("despertar")) { translation = "to awaken"; }
        else if (infinitive.equals("despreciar")) { translation = "to despise"; }
        else if (infinitive.equals("destacar")) { translation = "to detach"; }
        else if (infinitive.equals("destruir")) { translation = "to destroy"; }
        else if (infinitive.equals("desvestir")) { translation = "to undress"; }
        else if (infinitive.equals("desviar")) { translation = "to deviate"; }
        else if (infinitive.equals("detectar")) { translation = "to detect"; }
        else if (infinitive.equals("detener")) { translation = "to detain"; }
        else if (infinitive.equals("determinar")) { translation = "to determine"; }
        else if (infinitive.equals("devorar")) { translation = "to devour"; }
        else if (infinitive.equals("dibujar")) { translation = "to draw"; }
        else if (infinitive.equals("dictar")) { translation = "to dictate"; }
        else if (infinitive.equals("dirigir")) { translation = "to lead"; }
        else if (infinitive.equals("disculpar")) { translation = "to excuse"; }
        else if (infinitive.equals("discutir")) { translation = "to discuss"; }
        else if (infinitive.equals("disfrutar")) { translation = "to enjoy"; }
        else if (infinitive.equals("disgustar")) { translation = "to disgust"; }
        else if (infinitive.equals("disminuir")) { translation = "to diminish"; }
        else if (infinitive.equals("disolver")) { translation = "to dissolve"; }
        else if (infinitive.equals("disparar")) { translation = "to shoot"; }
        else if (infinitive.equals("disponer")) { translation = "to dispose"; }
        else if (infinitive.equals("disputar")) { translation = "to dispute"; }
        else if (infinitive.equals("distinguir")) { translation = "to distinguish"; }
        else if (infinitive.equals("distraer")) { translation = "to distract"; }
        else if (infinitive.equals("distribuir")) { translation = "to distribute"; }
        else if (infinitive.equals("disuadir")) { translation = "to dissuade"; }
        else if (infinitive.equals("diversificar")) { translation = "to diversify"; }
        else if (infinitive.equals("divertir")) { translation = "to have fun"; }
        else if (infinitive.equals("dividir")) { translation = "to divide"; }
        else if (infinitive.equals("divorciar")) { translation = "to divorce"; }
        else if (infinitive.equals("doblar")) { translation = "to double"; }
        else if (infinitive.equals("doler")) { translation = "to hurt"; }
        else if (infinitive.equals("dormir")) { translation = "to sleep"; }
        else if (infinitive.equals("duchar")) { translation = "to shower"; }
        else if (infinitive.equals("dudar")) { translation = "to doubt"; }
        else if (infinitive.equals("echar")) { translation = "to put in"; }
        else if (infinitive.equals("educar")) { translation = "to educate"; }
        else if (infinitive.equals("ejecutar")) { translation = "to execute"; }
        else if (infinitive.equals("ejercer")) { translation = "to exercise"; }
        else if (infinitive.equals("elegir")) { translation = "to elect"; }
        else if (infinitive.equals("elevar")) { translation = "to elevate"; }
        else if (infinitive.equals("eliminar")) { translation = "to eliminate"; }
        else if (infinitive.equals("embarazar")) { translation = "to make pregnant"; }
        else if (infinitive.equals("emborrachar")) { translation = "to intoxicate"; }
        else if (infinitive.equals("emitir")) { translation = "to emit"; }
        else if (infinitive.equals("empeorar")) { translation = "to worsen"; }
        else if (infinitive.equals("empezar")) { translation = "to start"; }
        else if (infinitive.equals("emplear")) { translation = "to employ"; }
        else if (infinitive.equals("enamorar")) { translation = "to fall in love"; }
        else if (infinitive.equals("encantar")) { translation = "to love"; }
        else if (infinitive.equals("encarcelar")) { translation = "to imprison"; }
        else if (infinitive.equals("encargar")) { translation = "to entrust"; }
        else if (infinitive.equals("encerrar")) { translation = "to lock up"; }
        else if (infinitive.equals("encontrar")) { translation = "to find"; }
        else if (infinitive.equals("enchilar")) { translation = "to burn with chiles"; }
        else if (infinitive.equals("enfadar")) { translation = "to annoy"; }
        else if (infinitive.equals("enfatizar")) { translation = "to emphasize"; }
        else if (infinitive.equals("enfermar")) { translation = "to get sick"; }
        else if (infinitive.equals("enflacar")) { translation = "to get thin"; }
        else if (infinitive.equals("enfocar")) { translation = "to focus"; }
        else if (infinitive.equals("enfriar")) { translation = "to cool"; }
        else if (infinitive.equals("engañar")) { translation = "to deceive"; }
        else if (infinitive.equals("engendrar")) { translation = "to engender"; }
        else if (infinitive.equals("engordar")) { translation = "to gain weight"; }
        else if (infinitive.equals("enloquecer")) { translation = "to drive insane"; }
        else if (infinitive.equals("enojar")) { translation = "to anger"; }
        else if (infinitive.equals("enriquecer")) { translation = "to enrich"; }
        else if (infinitive.equals("enseñar")) { translation = "to teach"; }
        else if (infinitive.equals("ensuciar")) { translation = "to get dirty"; }
        else if (infinitive.equals("entender")) { translation = "to understand"; }
        else if (infinitive.equals("entrar")) { translation = "to enter"; }
        else if (infinitive.equals("entregar")) { translation = "to return"; }
        else if (infinitive.equals("entretener")) { translation = "to entertain"; }
        else if (infinitive.equals("entrevenir")) { translation = "to intervene"; }
        else if (infinitive.equals("entrevistar")) { translation = "to interview"; }
        else if (infinitive.equals("envejecer")) { translation = "to enumerate"; }
        else if (infinitive.equals("enumerar")) { translation = "to age"; }
        else if (infinitive.equals("enviar")) { translation = "to send"; }
        else if (infinitive.equals("envidiar")) { translation = "to envy"; }
        else if (infinitive.equals("envolver")) { translation = "to envelope"; }
        else if (infinitive.equals("escapar")) { translation = "to escape"; }
        else if (infinitive.equals("escoger")) { translation = "to choose"; }
        else if (infinitive.equals("escoltar")) { translation = "to escort"; }
        else if (infinitive.equals("esconder")) { translation = "to hide"; }
        else if (infinitive.equals("escribir")) { translation = "to write"; }
        else if (infinitive.equals("escuchar")) { translation = "to listen"; }
        else if (infinitive.equals("escupir")) { translation = "to spit"; }
        else if (infinitive.equals("especializar")) { translation = "to specialize"; }
        else if (infinitive.equals("especificar")) { translation = "to specify"; }
        else if (infinitive.equals("esperar")) { translation = "to hope"; }
        else if (infinitive.equals("espiar")) { translation = "to spy on"; }
        else if (infinitive.equals("esquiar")) { translation = "to ski"; }
        else if (infinitive.equals("establecer")) { translation = "to establish"; }
        else if (infinitive.equals("estar")) { translation = "to be"; }
        else if (infinitive.equals("esterilizar")) { translation = "to sterilize"; }
        else if (infinitive.equals("estipular")) { translation = "to stipulate"; }
        else if (infinitive.equals("estornudar")) { translation = "to sneeze"; }
        else if (infinitive.equals("estudiar")) { translation = "to study"; }
        else if (infinitive.equals("evacuar")) { translation = "to evacuate"; }
        else if (infinitive.equals("evaluar")) { translation = "to evaluate"; }
        else if (infinitive.equals("evitar")) { translation = "to avoid"; }
        else if (infinitive.equals("exagerar")) { translation = "to exaggerate"; }
        else if (infinitive.equals("exaltar")) { translation = "to exalt"; }
        else if (infinitive.equals("examinar")) { translation = "to examine"; }
        else if (infinitive.equals("exceder")) { translation = "to exceed"; }
        else if (infinitive.equals("excluir")) { translation = "to exclude"; }
        else if (infinitive.equals("excusar")) { translation = "to excuse"; }
        else if (infinitive.equals("exhalar")) { translation = "to exhale"; }
        else if (infinitive.equals("exhibir")) { translation = "to exhibit"; }
        else if (infinitive.equals("exigir")) { translation = "to demand"; }
        else if (infinitive.equals("existir")) { translation = "to exist"; }
        else if (infinitive.equals("expatriar")) { translation = "to expatriate"; }
        else if (infinitive.equals("explicar")) { translation = "to explain"; }
        else if (infinitive.equals("exponer")) { translation = "to expose"; }
        else if (infinitive.equals("expresar")) { translation = "to express"; }
        else if (infinitive.equals("expulsar")) { translation = "to expel"; }
        else if (infinitive.equals("extender")) { translation = "to extend"; }
        else if (infinitive.equals("extinguir")) { translation = "to extinguish"; }
        else if (infinitive.equals("extirpar")) { translation = "to extirpate"; }
        else if (infinitive.equals("extraer")) { translation = "to extract"; }
        else if (infinitive.equals("fabricar")) { translation = "to fabricate"; }
        else if (infinitive.equals("facilitar")) { translation = "to facilitate"; }
        else if (infinitive.equals("falsificar")) { translation = "to falsify"; }
        else if (infinitive.equals("faltar")) { translation = "to lack"; }
        else if (infinitive.equals("fallar")) { translation = "to fail"; }
        else if (infinitive.equals("fascinar")) { translation = "to fascinate"; }
        else if (infinitive.equals("fastidiar")) { translation = "to annoy"; }
        else if (infinitive.equals("fatigar")) { translation = "to fatigue"; }
        else if (infinitive.equals("fecundar")) { translation = "to fertilize"; }
        else if (infinitive.equals("fiar")) { translation = "to answer for"; }
        else if (infinitive.equals("fijar")) { translation = "to focus"; }
        else if (infinitive.equals("finalizar")) { translation = "to finalize"; }
        else if (infinitive.equals("fingir")) { translation = "to fake"; }
        else if (infinitive.equals("firmar")) { translation = "to sign"; }
        else if (infinitive.equals("florecer")) { translation = "to bloom"; }
        else if (infinitive.equals("fluir")) { translation = "to flow"; }
        else if (infinitive.equals("formar")) { translation = "to form"; }
        else if (infinitive.equals("formular")) { translation = "to formulate"; }
        else if (infinitive.equals("forzar")) { translation = "to force"; }
        else if (infinitive.equals("fotografiar")) { translation = "to take pictures"; }
        else if (infinitive.equals("fracturar")) { translation = "to fracture"; }
        else if (infinitive.equals("freír")) { translation = "to fry"; }
        else if (infinitive.equals("frustrar")) { translation = "to frustrate"; }
        else if (infinitive.equals("fumar")) { translation = "to smoke"; }
        else if (infinitive.equals("funcionar")) { translation = "to function"; }
        else if (infinitive.equals("fundar")) { translation = "to found"; }
        else if (infinitive.equals("fusilar")) { translation = "to shoot"; }
        else if (infinitive.equals("ganar")) { translation = "to win"; }
        else if (infinitive.equals("garantizar")) { translation = "to guarantee"; }
        else if (infinitive.equals("gastar")) { translation = "to spend (money)"; }
        else if (infinitive.equals("gobernar")) { translation = "to govern"; }
        else if (infinitive.equals("golpear")) { translation = "to strike"; }
        else if (infinitive.equals("gozar")) { translation = "to enjoy"; }
        else if (infinitive.equals("grabar")) { translation = "to record"; }
        else if (infinitive.equals("graduar")) { translation = "to graduate"; }
        else if (infinitive.equals("gritar")) { translation = "to scream"; }
        else if (infinitive.equals("gruñir")) { translation = "to grunt"; }
        else if (infinitive.equals("guiar")) { translation = "to guide"; }
        else if (infinitive.equals("gustar")) { translation = "to like"; }
        else if (infinitive.equals("haber")) { translation = "to have"; }
        else if (infinitive.equals("hablar")) { translation = "to speak"; }
        else if (infinitive.equals("hacer")) { translation = "to make/do"; }
        else if (infinitive.equals("hallar")) { translation = "to find"; }
        else if (infinitive.equals("heredar")) { translation = "to inherit"; }
        else if (infinitive.equals("hervir")) { translation = "to boil"; }
        else if (infinitive.equals("hinchar")) { translation = "to swell up"; }
        else if (infinitive.equals("historiar")) { translation = "to depict history"; }
        else if (infinitive.equals("honrar")) { translation = "to honor"; }
        else if (infinitive.equals("hospitalizar")) { translation = "to hospitalize"; }
        else if (infinitive.equals("huir")) { translation = "to flee"; }
        else if (infinitive.equals("identificar")) { translation = "to identify"; }
        else if (infinitive.equals("ignorar")) { translation = "to ignore"; }
        else if (infinitive.equals("ilegalizar")) { translation = "to make illegal"; }
        else if (infinitive.equals("imaginar")) { translation = "to imagine"; }
        else if (infinitive.equals("imitar")) { translation = "to imitate"; }
        else if (infinitive.equals("impedir")) { translation = "to impede"; }
        else if (infinitive.equals("implantar")) { translation = "to implant"; }
        else if (infinitive.equals("implementar")) { translation = "to implement"; }
        else if (infinitive.equals("implicar")) { translation = "to implicate"; }
        else if (infinitive.equals("imponer")) { translation = "to impose"; }
        else if (infinitive.equals("importar")) { translation = "to be important"; }
        else if (infinitive.equals("impresionar")) { translation = "to impress"; }
        else if (infinitive.equals("imprimir")) { translation = "to print"; }
        else if (infinitive.equals("incapacitar")) { translation = "to incapacitate"; }
        else if (infinitive.equals("incluir")) { translation = "to include"; }
        else if (infinitive.equals("incorporar")) { translation = "to incorporate"; }
        else if (infinitive.equals("incrementar")) { translation = "to increment"; }
        else if (infinitive.equals("incurrir")) { translation = "to incur"; }
        else if (infinitive.equals("indicar")) { translation = "to indicate"; }
        else if (infinitive.equals("inducir")) { translation = "to induce"; }
        else if (infinitive.equals("industrializar")) { translation = "to industrialize"; }
        else if (infinitive.equals("infectar")) { translation = "to infect"; }
        else if (infinitive.equals("inferir")) { translation = "to infer"; }
        else if (infinitive.equals("inflamar")) { translation = "to inflame"; }
        else if (infinitive.equals("infligir")) { translation = "to inflict"; }
        else if (infinitive.equals("influir")) { translation = "to influence"; }
        else if (infinitive.equals("informar")) { translation = "to inform"; }
        else if (infinitive.equals("ingresar")) { translation = "to become a member"; }
        else if (infinitive.equals("iniciar")) { translation = "to initiate"; }
        else if (infinitive.equals("inscribir")) { translation = "to inscribe"; }
        else if (infinitive.equals("insinuar")) { translation = "to insinuate"; }
        else if (infinitive.equals("insistir")) { translation = "to insist"; }
        else if (infinitive.equals("inspeccionar")) { translation = "to inspect"; }
        else if (infinitive.equals("inspirar")) { translation = "to inspire"; }
        else if (infinitive.equals("instituir")) { translation = "to institute"; }
        else if (infinitive.equals("instruir")) { translation = "to instruct"; }
        else if (infinitive.equals("insultar")) { translation = "to insult"; }
        else if (infinitive.equals("intentar")) { translation = "to intend"; }
        else if (infinitive.equals("intercambiar")) { translation = "to exchange"; }
        else if (infinitive.equals("interesar")) { translation = "to interest"; }
        else if (infinitive.equals("interpretar")) { translation = "to interpret"; }
        else if (infinitive.equals("intervenir")) { translation = "to intervene"; }
        else if (infinitive.equals("interrogar")) { translation = "to interrogate"; }
        else if (infinitive.equals("interrumpir")) { translation = "to interrupt"; }
        else if (infinitive.equals("introducir")) { translation = "to introduce"; }
        else if (infinitive.equals("invadir")) { translation = "to invade"; }
        else if (infinitive.equals("inventar")) { translation = "to invent"; }
        else if (infinitive.equals("inventariar")) { translation = "to inventory"; }
        else if (infinitive.equals("invertir")) { translation = "to invest"; }
        else if (infinitive.equals("investigar")) { translation = "to investigate"; }
        else if (infinitive.equals("invitar")) { translation = "to invite"; }
        else if (infinitive.equals("inyectar")) { translation = "to inject"; }
        else if (infinitive.equals("ir")) { translation = "to go"; }
        else if (infinitive.equals("irritar")) { translation = "to irritate"; }
        else if (infinitive.equals("jalar")) { translation = "to pull"; }
        else if (infinitive.equals("jubilar")) { translation = "to retire"; }
        else if (infinitive.equals("jugar")) { translation = "to play"; }
        else if (infinitive.equals("juntar")) { translation = "to bring together"; }
        else if (infinitive.equals("jurar")) { translation = "to swear"; }
        else if (infinitive.equals("justificar")) { translation = "to justify"; }
        else if (infinitive.equals("juzgar")) { translation = "to judge"; }
        else if (infinitive.equals("ladrar")) { translation = "to bark"; }
        else if (infinitive.equals("lastimar")) { translation = "to hurt"; }
        else if (infinitive.equals("lavar")) { translation = "to wash"; }
        else if (infinitive.equals("leer")) { translation = "to read"; }
        else if (infinitive.equals("legalizar")) { translation = "to legalize"; }
        else if (infinitive.equals("levantar")) { translation = "to lift up"; }
        else if (infinitive.equals("liar")) { translation = "to tie up"; }
        else if (infinitive.equals("liberar")) { translation = "to liberate"; }
        else if (infinitive.equals("licenciar")) { translation = "to license"; }
        else if (infinitive.equals("limitar")) { translation = "to limit"; }
        else if (infinitive.equals("limpiar")) { translation = "to clean"; }
        else if (infinitive.equals("localizar")) { translation = "to localize"; }
        else if (infinitive.equals("luchar")) { translation = "to fight"; }
        else if (infinitive.equals("llamar")) { translation = "to call"; }
        else if (infinitive.equals("llegar")) { translation = "to arrive"; }
        else if (infinitive.equals("llenar")) { translation = "to make full"; }
        else if (infinitive.equals("llevar")) { translation = "to wear"; }
        else if (infinitive.equals("llorar")) { translation = "to cry"; }
        else if (infinitive.equals("llover")) { translation = "to rain"; }
        else if (infinitive.equals("lloviznar")) { translation = "to drizzle"; }
        else if (infinitive.equals("machucar")) { translation = "to squash"; }
        else if (infinitive.equals("madurar")) { translation = "to mature"; }
        else if (infinitive.equals("maldecir")) { translation = "to curse"; }
        else if (infinitive.equals("malfuncionar")) { translation = "to malfunction"; }
        else if (infinitive.equals("maltratar")) { translation = "to mistreat"; }
        else if (infinitive.equals("manchar")) { translation = "to spot"; }
        else if (infinitive.equals("mandar")) { translation = "to send"; }
        else if (infinitive.equals("manejar")) { translation = "to manage"; }
        else if (infinitive.equals("manifestar")) { translation = "to manifest"; }
        else if (infinitive.equals("manipular")) { translation = "to manipulate"; }
        else if (infinitive.equals("mantener")) { translation = "to maintain"; }
        else if (infinitive.equals("martillar")) { translation = "to hammer"; }
        else if (infinitive.equals("mascar")) { translation = "to chew"; }
        else if (infinitive.equals("masticar")) { translation = "to masticate"; }
        else if (infinitive.equals("medir")) { translation = "to measure"; }
        else if (infinitive.equals("mejorar")) { translation = "to make better"; }
        else if (infinitive.equals("mencionar")) { translation = "to mention"; }
        else if (infinitive.equals("mentir")) { translation = "to lie"; }
        else if (infinitive.equals("merecer")) { translation = "to earn"; }
        else if (infinitive.equals("meter")) { translation = "to insert"; }
        else if (infinitive.equals("mirar")) { translation = "to see"; }
        else if (infinitive.equals("moderar")) { translation = "to moderate"; }
        else if (infinitive.equals("modificar")) { translation = "to modify"; }
        else if (infinitive.equals("mojar")) { translation = "to moisten"; }
        else if (infinitive.equals("molestar")) { translation = "to annoy"; }
        else if (infinitive.equals("montar")) { translation = "to ride"; }
        else if (infinitive.equals("morder")) { translation = "to bite"; }
        else if (infinitive.equals("morir")) { translation = "to die"; }
        else if (infinitive.equals("mostrar")) { translation = "to demonstrate"; }
        else if (infinitive.equals("mover")) { translation = "to move"; }
        else if (infinitive.equals("mudar")) { translation = "to relocate"; }
        else if (infinitive.equals("nacer")) { translation = "to be born"; }
        else if (infinitive.equals("nacionalizar")) { translation = "to nationalize"; }
        else if (infinitive.equals("nadar")) { translation = "to swim"; }
        else if (infinitive.equals("naturalizar")) { translation = "to naturalize"; }
        else if (infinitive.equals("navegar")) { translation = "to navigate"; }
        else if (infinitive.equals("necesitar")) { translation = "to need"; }
        else if (infinitive.equals("negar")) { translation = "to say no"; }
        else if (infinitive.equals("nevar")) { translation = "to snow"; }
        else if (infinitive.equals("nombrar")) { translation = "to name"; }
        else if (infinitive.equals("normalizar")) { translation = "to normalize"; }
        else if (infinitive.equals("notar")) { translation = "to note"; }
        else if (infinitive.equals("nublar")) { translation = "to cloud up"; }
        else if (infinitive.equals("obedecer")) { translation = "to obey"; }
        else if (infinitive.equals("obligar")) { translation = "to oblige"; }
        else if (infinitive.equals("observar")) { translation = "to observe"; }
        else if (infinitive.equals("obstruir")) { translation = "to obstruct"; }
        else if (infinitive.equals("obtener")) { translation = "to obtain"; }
        else if (infinitive.equals("obviar")) { translation = "to remove"; }
        else if (infinitive.equals("ocupar")) { translation = "to occupy"; }
        else if (infinitive.equals("ocurrir")) { translation = "to occur"; }
        else if (infinitive.equals("odiar")) { translation = "to hate"; }
        else if (infinitive.equals("ofender")) { translation = "to offend"; }
        else if (infinitive.equals("ofrecer")) { translation = "to offer"; }
        else if (infinitive.equals("oír")) { translation = "to hear"; }
        else if (infinitive.equals("oler")) { translation = "to smell"; }
        else if (infinitive.equals("olvidar")) { translation = "to forget"; }
        else if (infinitive.equals("omitir")) { translation = "to omit"; }
        else if (infinitive.equals("operar")) { translation = "to operate"; }
        else if (infinitive.equals("opinar")) { translation = "to be of opinion"; }
        else if (infinitive.equals("oponer")) { translation = "to oppose"; }
        else if (infinitive.equals("optar")) { translation = "to opt"; }
        else if (infinitive.equals("orar")) { translation = "to pray"; }
        else if (infinitive.equals("organizar")) { translation = "to organize"; }
        else if (infinitive.equals("padecer")) { translation = "to suffer"; }
        else if (infinitive.equals("pagar")) { translation = "to pay"; }
        else if (infinitive.equals("paliar")) { translation = "to pale"; }
        else if (infinitive.equals("paralizar")) { translation = "to paralyze"; }
        else if (infinitive.equals("parar")) { translation = "to stand"; }
        else if (infinitive.equals("parecer")) { translation = "to resemble"; }
        else if (infinitive.equals("participar")) { translation = "to participate"; }
        else if (infinitive.equals("partir")) { translation = "to divide"; }
        else if (infinitive.equals("pasar")) { translation = "to spend time"; }
        else if (infinitive.equals("pasteurizar")) { translation = "to pasteurize"; }
        else if (infinitive.equals("patinar")) { translation = "to skate"; }
        else if (infinitive.equals("patrullar")) { translation = "to patrol"; }
        else if (infinitive.equals("pedir")) { translation = "to ask for"; }
        else if (infinitive.equals("pegar")) { translation = "to hit"; }
        else if (infinitive.equals("peinar")) { translation = "to comb"; }
        else if (infinitive.equals("pelear")) { translation = "to fight"; }
        else if (infinitive.equals("peliscar")) { translation = "to pinch"; }
        else if (infinitive.equals("penetrar")) { translation = "to penetrate"; }
        else if (infinitive.equals("pensar")) { translation = "to think"; }
        else if (infinitive.equals("percibir")) { translation = "to perceive"; }
        else if (infinitive.equals("perder")) { translation = "to lose"; }
        else if (infinitive.equals("perdonar")) { translation = "to pardon"; }
        else if (infinitive.equals("perdurar")) { translation = "to last"; }
        else if (infinitive.equals("perfeccionar")) { translation = "to perfect"; }
        else if (infinitive.equals("perforar")) { translation = "to perforate"; }
        else if (infinitive.equals("perjudicar")) { translation = "to damage"; }
        else if (infinitive.equals("permanecer")) { translation = "to remain"; }
        else if (infinitive.equals("permitir")) { translation = "to permit"; }
        else if (infinitive.equals("perpetrar")) { translation = "to perpetrate"; }
        else if (infinitive.equals("persistir")) { translation = "to persist"; }
        else if (infinitive.equals("persuadir")) { translation = "to persuade"; }
        else if (infinitive.equals("pertenecer")) { translation = "to belong"; }
        else if (infinitive.equals("perturbar")) { translation = "to perturb"; }
        else if (infinitive.equals("pesar")) { translation = "to weigh"; }
        else if (infinitive.equals("pescar")) { translation = "to fish"; }
        else if (infinitive.equals("piar")) { translation = "to chirp"; }
        else if (infinitive.equals("picar")) { translation = "to sting"; }
        else if (infinitive.equals("pintar")) { translation = "to paint"; }
        else if (infinitive.equals("pitar")) { translation = "to honk"; }
        else if (infinitive.equals("planchar")) { translation = "to iron"; }
        else if (infinitive.equals("platicar")) { translation = "to chatter"; }
        else if (infinitive.equals("poblar")) { translation = "to populate"; }
        else if (infinitive.equals("poder")) { translation = "to be able"; }
        else if (infinitive.equals("poner")) { translation = "to put"; }
        else if (infinitive.equals("porfiar")) { translation = "to persist"; }
        else if (infinitive.equals("portar")) { translation = "to bear"; }
        else if (infinitive.equals("poseer")) { translation = "to own"; }
        else if (infinitive.equals("posponer")) { translation = "to postpone"; }
        else if (infinitive.equals("practicar")) { translation = "to practice"; }
        else if (infinitive.equals("precisar")) { translation = "to specify"; }
        else if (infinitive.equals("predisponer")) { translation = "to predispose"; }
        else if (infinitive.equals("preferir")) { translation = "to prefer"; }
        else if (infinitive.equals("preguntar")) { translation = "to ask (a question)"; }
        else if (infinitive.equals("prender")) { translation = "to switch on"; }
        else if (infinitive.equals("preocupar")) { translation = "to preoccupy"; }
        else if (infinitive.equals("preparar")) { translation = "to prepare"; }
        else if (infinitive.equals("presentar")) { translation = "to present"; }
        else if (infinitive.equals("presidir")) { translation = "to preside"; }
        else if (infinitive.equals("prestar")) { translation = "to lend"; }
        else if (infinitive.equals("presumir")) { translation = "to presume"; }
        else if (infinitive.equals("prevenir")) { translation = "to preview"; }
        else if (infinitive.equals("privar")) { translation = "to deprive"; }
        else if (infinitive.equals("probar")) { translation = "to taste"; }
        else if (infinitive.equals("proceder")) { translation = "to proceed"; }
        else if (infinitive.equals("procrear")) { translation = "to procreate"; }
        else if (infinitive.equals("producir")) { translation = "to produce"; }
        else if (infinitive.equals("programar")) { translation = "to program"; }
        else if (infinitive.equals("progresar")) { translation = "to progress"; }
        else if (infinitive.equals("prohibir")) { translation = "to prohibit"; }
        else if (infinitive.equals("prolongar")) { translation = "to prolong"; }
        else if (infinitive.equals("prometer")) { translation = "to promise"; }
        else if (infinitive.equals("promover")) { translation = "to promote"; }
        else if (infinitive.equals("promulgar")) { translation = "to promulgate"; }
        else if (infinitive.equals("pronunciar")) { translation = "to pronounce"; }
        else if (infinitive.equals("proporcionar")) { translation = "to proportion"; }
        else if (infinitive.equals("proteger")) { translation = "to protect"; }
        else if (infinitive.equals("protestar")) { translation = "to protest"; }
        else if (infinitive.equals("proveer")) { translation = "to provide"; }
        else if (infinitive.equals("provocar")) { translation = "to provoke"; }
        else if (infinitive.equals("proyectar")) { translation = "to project"; }
        else if (infinitive.equals("publicar")) { translation = "to publish"; }
        else if (infinitive.equals("pudrir")) { translation = "to rot"; }
        else if (infinitive.equals("pulir")) { translation = "to polish"; }
        else if (infinitive.equals("pulsar")) { translation = "to pulsate"; }
        else if (infinitive.equals("purificar")) { translation = "to purify"; }
        else if (infinitive.equals("quebrar")) { translation = "to break"; }
        else if (infinitive.equals("quedar")) { translation = "to stay"; }
        else if (infinitive.equals("quejar")) { translation = "to complain"; }
        else if (infinitive.equals("quemar")) { translation = "to burn"; }
        else if (infinitive.equals("querer")) { translation = "to want"; }
        else if (infinitive.equals("quitar")) { translation = "to take away"; }
        else if (infinitive.equals("rasgar")) { translation = "to rip"; }
        else if (infinitive.equals("recibir")) { translation = "to receive"; }
        else if (infinitive.equals("recoger")) { translation = "to pick up"; }
        else if (infinitive.equals("recomendar")) { translation = "to recommend"; }
        else if (infinitive.equals("reducir")) { translation = "to reduce"; }
        else if (infinitive.equals("referir")) { translation = "to refer"; }
        else if (infinitive.equals("regañar")) { translation = "to nag"; }
        else if (infinitive.equals("regatear")) { translation = "to barter"; }
        else if (infinitive.equals("regresar")) { translation = "to return"; }
        else if (infinitive.equals("reír")) { translation = "to laugh"; }
        else if (infinitive.equals("rentar")) { translation = "to rent"; }
        else if (infinitive.equals("reparar")) { translation = "to repair"; }
        else if (infinitive.equals("repatriar")) { translation = "to repatriate"; }
        else if (infinitive.equals("resfriar")) { translation = "to cool"; }
        else if (infinitive.equals("respetar")) { translation = "to respect"; }
        else if (infinitive.equals("resultar")) { translation = "to result"; }
        else if (infinitive.equals("rociar")) { translation = "to sprinkle"; }
        else if (infinitive.equals("romper")) { translation = "to break"; }
        else if (infinitive.equals("roncar")) { translation = "to snore"; }
        else if (infinitive.equals("saber")) { translation = "to know"; }
        else if (infinitive.equals("sacar")) { translation = "to take out"; }
        else if (infinitive.equals("sacudir")) { translation = "to shake off"; }
        else if (infinitive.equals("salir")) { translation = "to leave"; }
        else if (infinitive.equals("saludar")) { translation = "to greet"; }
        else if (infinitive.equals("satisfacer")) { translation = "to satisfy"; }
        else if (infinitive.equals("secar")) { translation = "to dry"; }
        else if (infinitive.equals("seguir")) { translation = "to follow"; }
        else if (infinitive.equals("señalar")) { translation = "to signal"; }
        else if (infinitive.equals("ser")) { translation = "to be"; }
        else if (infinitive.equals("servir")) { translation = "to serve"; }
        else if (infinitive.equals("sonar")) { translation = "to sound"; }
        else if (infinitive.equals("soñar")) { translation = "to dream"; }
        else if (infinitive.equals("sonreír")) { translation = "to smile"; }
        else if (infinitive.equals("sorprender")) { translation = "to surprise"; }
        else if (infinitive.equals("sostener")) { translation = "to sustain"; }
        else if (infinitive.equals("subir")) { translation = "to rise"; }
        else if (infinitive.equals("suponer")) { translation = "to suppose"; }
        else if (infinitive.equals("sentir")) { translation = "to feel"; }
        else if (infinitive.equals("sustituir")) { translation = "to substitute"; }
        else if (infinitive.equals("tejer")) { translation = "to braid"; }
        else if (infinitive.equals("telegrafiar")) { translation = "to telegraph"; }
        else if (infinitive.equals("temblar")) { translation = "to tremble"; }
        else if (infinitive.equals("temer")) { translation = "to fear"; }
        else if (infinitive.equals("tender")) { translation = "to extend"; }
        else if (infinitive.equals("tener")) { translation = "to have"; }
        else if (infinitive.equals("tentar")) { translation = "to tempt"; }
        else if (infinitive.equals("terminar")) { translation = "to terminate"; }
        else if (infinitive.equals("testigar")) { translation = "to testify"; }
        else if (infinitive.equals("tirar")) { translation = "to throw"; }
        else if (infinitive.equals("tocar")) { translation = "to play (instrument)"; }
        else if (infinitive.equals("tolerar")) { translation = "to tolerate"; }
        else if (infinitive.equals("tomar")) { translation = "to take"; }
        else if (infinitive.equals("torcer")) { translation = "to twist"; }
        else if (infinitive.equals("toser")) { translation = "to cough"; }
        else if (infinitive.equals("trabajar")) { translation = "to work"; }
        else if (infinitive.equals("traducir")) { translation = "to translate"; }
        else if (infinitive.equals("traer")) { translation = "to bring"; }
        else if (infinitive.equals("tragar")) { translation = "to swallow"; }
        else if (infinitive.equals("traicionar")) { translation = "to betray"; }
        else if (infinitive.equals("trancar")) { translation = "to lock"; }
        else if (infinitive.equals("transcribir")) { translation = "to transcribe"; }
        else if (infinitive.equals("transferir")) { translation = "to transfer"; }
        else if (infinitive.equals("transformar")) { translation = "to transform"; }
        else if (infinitive.equals("transmitir")) { translation = "to transmit"; }
        else if (infinitive.equals("transportar")) { translation = "to transport"; }
        else if (infinitive.equals("trasladar")) { translation = "to move"; }
        else if (infinitive.equals("tratar")) { translation = "to try"; }
        else if (infinitive.equals("triunfar")) { translation = "to triumph"; }
        else if (infinitive.equals("tropezar")) { translation = "to trip"; }
        else if (infinitive.equals("ubicar")) { translation = "to be located"; }
        else if (infinitive.equals("unir")) { translation = "to unite"; }
        else if (infinitive.equals("untar")) { translation = "to bribe"; }
        else if (infinitive.equals("usar")) { translation = "to use"; }
        else if (infinitive.equals("utilizar")) { translation = "to utilize"; }
        else if (infinitive.equals("vaciar")) { translation = "to empty"; }
        else if (infinitive.equals("valer")) { translation = "to be worth something"; }
        else if (infinitive.equals("variar")) { translation = "to very"; }
        else if (infinitive.equals("vender")) { translation = "to sell"; }
        else if (infinitive.equals("venir")) { translation = "to come"; }
        else if (infinitive.equals("ver")) { translation = "to see"; }
        else if (infinitive.equals("verificar")) { translation = "to verify"; }
        else if (infinitive.equals("vestir")) { translation = "to dress"; }
        else if (infinitive.equals("viajar")) { translation = "to travel"; }
        else if (infinitive.equals("vibrar")) { translation = "to vibrate"; }
        else if (infinitive.equals("vigilar")) { translation = "to watch over"; }
        else if (infinitive.equals("vincular")) { translation = "to conquer"; }
        else if (infinitive.equals("violar")) { translation = "to violate"; }
        else if (infinitive.equals("visitar")) { translation = "to visit"; }
        else if (infinitive.equals("vivir")) { translation = "to live"; }
        else if (infinitive.equals("volar")) { translation = "to fly"; }
        else if (infinitive.equals("voltear")) { translation = "to turn"; }
        else if (infinitive.equals("volver")) { translation = "to return"; }
        else if (infinitive.equals("vomitar")) { translation = "to vomit"; }
        else if (infinitive.equals("votar")) { translation = "to vote"; }
        else if (infinitive.equals("yacer")) { translation = "to be situated"; }
        else if (infinitive.equals("yodurar")) { translation = "to iodize"; }
        else if (infinitive.equals("yuxtaponer")) { translation = "to juxtapose"; }
        else if (infinitive.equals("zapatear")) { translation = "to kick"; }
        else if (infinitive.equals("zonar")) { translation = "to whirr"; }
        else if (infinitive.equals("zurriar")) { translation = "to buzz"; }
        else if (infinitive.equals("perseguir")) { translation = "to pursue"; }
        else if (infinitive.equals("repetir")) { translation = "to repeat"; }
        else if (infinitive.equals("sugerir")) { translation = "to suggest"; }
        else if (infinitive.equals("predecir")) { translation = "to predict"; }
        else if (infinitive.equals("acarrear")) { translation = "to carry"; }
        else if (infinitive.equals("detraer")) { translation = "to detract"; }
        else if (infinitive.equals("reflejar")) { translation = "to reflect"; }
        else if (infinitive.equals("caber")) { translation = "to fit"; }
        else if (infinitive.equals("aclarar")) { translation = "to clarify"; }
        else { translation = " "; }
        // TODO Ninja we made it.
    }

    private static void getGerund() {

        isIrregularGerund = Arrays.asList(stemChangeGerunds).contains(infinitive);

        if (isEndingAr && !isIrregularGerund) {
            gerund = infinitive.replace("ar", "ando");
        } else if (isEndingEr && !isIrregularGerund) {
            if (infinitive.endsWith("aer")) {
                gerund = infinitive.replace("er", "yendo");
            } else if (infinitive.endsWith("eer")) {
                gerund = infinitive.replace("er", "yendo");
            } else if (infinitive.endsWith("ñer")) {
                gerund = infinitive.replace("er", "endo");
            } else {
                gerund = infinitive.replace("er", "iendo");
            }
        } else if (isEndingIr && !isIrregularGerund) {
            if (infinitive.endsWith("ñir")) {
                gerund = infinitive.replace("ir", "endo");
            } else if (infinitive.endsWith("llir")) {
                gerund = infinitive.replace("ir", "endo");
            } else if (infinitive.equals("ir")) {
                gerund = "yendo";
            } else if (infinitive.endsWith("uir")) {
                gerund = infinitive.replace("ir", "yendo");
            } else if (infinitive.endsWith("ír")) {
                gerund = infinitive.replace("ír", "íendo");
            } else {
                gerund = infinitive.replace("ir", "iendo");
            }
        } else if (isIrregularGerund) {
            IrregularVerb.makeGerund();
        } else {
            gerund = " ";
        }
    }

    private static void getPastParticiple() {

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
        } else if (isIrregularPastParticiple) {
            if (infinitive.equals("abrir")) {
                pastParticiple = "abierto";
            } else if (infinitive.equals("decir")) {
                pastParticiple = "dicho";
            } else if (infinitive.equals("poner")) {
                pastParticiple = "puesto";
            } else if (infinitive.equals("freír")) {
                pastParticiple = "frito";
            } else if (infinitive.equals("hacer")) {
                pastParticiple = "hecho";
            } else if (infinitive.equals("imprimir")) {
                pastParticiple = "impreso";
            } else if (infinitive.equals("ir")) {
                pastParticiple = "ido";
            } else if (infinitive.equals("morir")) {
                pastParticiple = "muerto";
            } else if (infinitive.equals("escribir")) {
                pastParticiple = "escrito";
            } else if (infinitive.equals("romper")) {
                pastParticiple = "roto";
            } else if (infinitive.equals("ver")) {
                pastParticiple = "visto";
            } else if (infinitive.equals("volver")) {
                pastParticiple = "vuelto";
            } else if (infinitive.equals("resolver")) {
                pastParticiple = "resuelto";
            } else if (infinitive.equals("cubrir")) {
                pastParticiple = "cubierto";
            } else if (infinitive.equals("descubrir")) {
                pastParticiple = "descubierto";
            } else if (infinitive.equals("querer")) {
                pastParticiple = "querido";
            }
        } else {
            pastParticiple = " ";
        }

        setText();
    }

    public static void getConjugationStats() {
        // TODO Good chance to learn about SharedPreferences...
    }

    private void replaceWithMoreThanOneEnding() {

        int index;
        String infinitive1 = infinitive;

        if (isEndingAr) {
            // change ending to something else
            index = infinitive1.lastIndexOf("ar");
            StringBuilder sb = new StringBuilder(infinitive1);
            sb = sb.replace(index, index + 2, "bby");
            infinitive1 = sb.toString();
            pastParticiple = infinitive1.replace("bby", "ado");
        } else if (isEndingEr) {
            // change ending to something else
            index = infinitive1.lastIndexOf("er");
            StringBuilder sb = new StringBuilder(infinitive1);
            sb = sb.replace(index, index + 2, "bby");
            infinitive1 = sb.toString();
            pastParticiple = infinitive1.replace("bby", "ido");
        } else if (isEndingIr) {
            // change ending to something else
            index = infinitive1.lastIndexOf("ir");
            StringBuilder sb = new StringBuilder(infinitive1);
            sb = sb.replace(index, index + 2, "bby");
            infinitive1 = sb.toString();
            pastParticiple = infinitive1.replace("bby", "ido");
        } else {
            pastParticiple = " ";
        }

        setText();
    }

    private void replaceWithMoreThanOneEnding2() {

        int index;
        String infinitive2 = infinitive;

        if (isEndingAr) {
            index = infinitive2.lastIndexOf("ar");
            StringBuilder sb = new StringBuilder(infinitive2);
            sb = sb.replace(index, index + 2, "bby");
            infinitive2 = sb.toString();
            gerund = infinitive2.replace("bby", "ando");
        } else if (isEndingEr) {
            index = infinitive2.lastIndexOf("er");
            StringBuilder sb = new StringBuilder(infinitive2);
            sb = sb.replace(index, index + 2, "bby");
            infinitive2 = sb.toString();
            gerund = infinitive2.replace("bby", "iendo");
        } else if (isEndingIr) {
            index = infinitive2.lastIndexOf("ir");
            StringBuilder sb = new StringBuilder(infinitive2);
            sb = sb.replace(index, index + 2, "bby");
            infinitive2 = sb.toString();
            gerund = infinitive2.replace("bby", "iendo");
        } else {
            gerund = " ";
        }

        setText();
    }

    private static void setText() {
        translationTextView.setText(translation);
        gerundTextView.setText(gerund);
        pastParticipleTextView.setText(pastParticiple);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mOtherTextField.getWindowToken(), 0);
    }
}
