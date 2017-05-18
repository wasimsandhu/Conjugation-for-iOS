package com.wsandhu.conjugation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LearnFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener {

    Spinner tenseSpinner;
    TextView learnText;
    int verbTense;

    public LearnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.learn_fragment, container, false);

        learnText = (TextView) rootView.findViewById(R.id.learn_textview);
        tenseSpinner = (Spinner) rootView.findViewById(R.id.tense_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.all_tenses, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tenseSpinner.setAdapter(adapter);
        tenseSpinner.setOnItemSelectedListener(this);

        return rootView;
    }

    private void teach() {
        if (verbTense == 0) {
            // Present tense
            learnText.setText("The present tense is used to describe an action that is happening now.\n" +
                    "\n" +
                    "Verbs that end with -ar, -er, and -ir in the present tense each have their own respective endings.\n" +
                    "\n" +
                    "The -ar endings:\n" +
                    "\n" +
                    "Yo: -o\n" +
                    "Tú: -as\n" +
                    "Él/ella/usted: -a\n" +
                    "Nosotros: -amos\n" +
                    "Vosotros: -áis\n" +
                    "Ellos/ellas/ustedes: -an\n" +
                    "\n" +
                    "The -er endings:\n" +
                    "\n" +
                    "Yo: -o\n" +
                    "Tú: -es\n" +
                    "Él/ella/usted: -e\n" +
                    "Nosotros: -emos\n" +
                    "Vosotros: -éis\n" +
                    "Ellos/ellas/ustedes: -en\n" +
                    "\n" +
                    "The -ir endings:\n" +
                    "\n" +
                    "Yo: -o\n" +
                    "Tú: -es\n" +
                    "Él/ella/usted: -e\n" +
                    "Nosotros: -imos\n" +
                    "Vosotros: -ís\n" +
                    "Ellos/ellas/ustedes: -en\n" +
                    "\n" +
                    "To conjugate a verb to the present tense, follow these three steps:\n" +
                    "\n" +
                    "1. Write the infinitive of the verb\n" +
                    "2. Remove -ar, -er, or -ir from the ending\n" +
                    "3. Replace with the respective ending\n" +
                    "\n" +
                    "For example, to conjugate \"hablar\" to the Nosotros form:\n" +
                    "\n" +
                    "1. hablar\n" +
                    "2. habl\n" +
                    "3. hablamos\n" +
                    "\n" +
                    "A verb has two parts, a stem and an ending. Some verbs have a stem change when conjugated. The stem-change does not apply in the nosotros or vosotros form. In the present tense, stem changes occur from e → i, e → ie, and o → ue. Just replace the 'e' or 'o' in the verb.\n" +
                    "\n" +
                    "For example, \"dormir\" has an o → ue stem change, so its conjugations are:\n" +
                    "\n" +
                    "Yo duermo\n" +
                    "Tú duermes\n" +
                    "Él duerme\n" +
                    "Nosotros dormimos\n" +
                    "Vosotros dormís\n" +
                    "Ellos duermen\n" +
                    "\n" +
                    "The following verbs are irregular in the present tense. Conjugate them and learn their patterns!\n" +
                    "\n" +
                    "• ir\n" +
                    "• ser\n" +
                    "• estar\n" +
                    "• dar\n" +
                    "• saber\n" +
                    "• hacer\n" +
                    "• traer\n" +
                    "• poner\n" +
                    "• ver\n" +
                    "• haber\n" +
                    "• poder\n" +
                    "• querer\n" +
                    "• venir\n" +
                    "• decir\n" +
                    "• tener\n" +
                    "• caer");
        } else if (verbTense == 1) {
            // Preterite tense
            learnText.setText("The preterite tense is used to describe things that happened in the past. It tells what happened at a particular moment in the past.\n" +
                    "\n" +
                    "The preterite tense is formed by adding the appropriate tense endings to the verb stem.\n" +
                    "\n" +
                    "The -ar endings:\n" +
                    "\n" +
                    "Yo: -é\n" +
                    "Tú: -aste\n" +
                    "Él/ella/usted: -ó\n" +
                    "Nostros: -amos\n" +
                    "Vosotros: -asteis\n" +
                    "Ellos/ellas/ustedes: -aron\n" +
                    "\n" +
                    "The -er/-ir endings:\n" +
                    "\n" +
                    "Yo: -í\n" +
                    "Tú: -iste\n" +
                    "Él/ella/usted: -ió\n" +
                    "Nostros: -imos\n" +
                    "Vosotros: -isteis\n" +
                    "Ellos/ellas/ustedes: -ieron\n" +
                    "\n" +
                    "To conjugate to the preterite tense, follow these steps:\n" +
                    "\n" +
                    "1. Take the infinitive of the verb\n" +
                    "2. Remove -ar, -er, or -ir from the ending\n" +
                    "3. Replace with the respective ending\n" +
                    "\n" +
                    "For example, to conjugate \"cantar\" to the Yo form:\n" +
                    "\n" +
                    "1. cantar\n" +
                    "2. cant\n" +
                    "3. canté\n" +
                    "\n" +
                    "Irregular verbs such as estar, poder, poner, saber, and tener need a stem change before you add the irregular preterite endings. The stem changes are as follows:\n" +
                    "\n" +
                    "• estar → estuv- \n" +
                    "• poder → pud-\n" +
                    "• poner → pus-\n" +
                    "• saber → sup-\n" +
                    "• tener → tuv-\n" +
                    "• venir → vin-\n" +
                    "• querer → quis-\n" +
                    "• decir → dij-\n" +
                    "• traer → traj-\n" +
                    "\n" +
                    "The irregular preterite endings:\n" +
                    "\n" +
                    "Yo: -e\n" +
                    "Tú: -iste\n" +
                    "Él/ella/usted: -o\n" +
                    "Nostros: -imos\n" +
                    "Vosotros: -isteis\n" +
                    "Ellos/ellas/ustedes: -ieron\n" +
                    "\n" +
                    "Verbs that end with -ir and have a e → i or o → ue stem-change in the present tense also have one in the preterite tense, but it is only in the él/ella/usted and ellos/ellas/ustedes forms. The e → i is the same, but verbs with o → ue use o → u instead.\n" +
                    "\n" +
                    "For example, \"dormir\" has an o → ue stem change in the present tense, so its preterite conjugations are:\n" +
                    "\n" +
                    "Yo dormí\n" +
                    "Tú dormiste\n" +
                    "Él durmió\n" +
                    "Nosotros dormimos\n" +
                    "Vosotros dormisteis\n" +
                    "Ellos durmieron\n" +
                    "\n" +
                    "The following verbs are completely irregular in the preterite tense. Conjugate them to learn their patterns!\n" +
                    "\n" +
                    "• ir\n" +
                    "• ser\n" +
                    "• hacer\n" +
                    "• ver\n" +
                    "• dar");
        } else if (verbTense == 2) {
            // Imperfect tense
            learnText.setText("The imperfect tense is used to describe something that was not completed in the past. Simple past tense like \"I walked\" would become \"I was walking\" or \"I used to walk\".\n" +
                    "\n" +
                    "The imperfect tense is formed by adding the appropriate tense endings to the verb stem.\n" +
                    "\n" +
                    "The -ar endings:\n" +
                    "\n" +
                    "Yo: -aba\n" +
                    "Tú: -abas\n" +
                    "Él/ella/usted: -aba\n" +
                    "Nosotros: -ábamos\n" +
                    "Vosotros: -abais\n" +
                    "Ellos/ellas/ustedes: -aban\n" +
                    "\n" +
                    "The -er/-ir endings:\n" +
                    "\n" +
                    "Yo: -ía\n" +
                    "Tú: -ías\n" +
                    "Él/ella/usted: -ía\n" +
                    "Nosotros: -íamos\n" +
                    "Vosotros: -íais\n" +
                    "Ellos/ellas/ustedes: -ían\n" +
                    "\n" +
                    "Follow these steps:\n" +
                    "\n" +
                    "1. Take the infinitive of the verb\n" +
                    "2. Remove the -ar, -er, or -ir ending\n" +
                    "3. Add the appropriate imperfect tense ending\n" +
                    "\n" +
                    "For example, to conjugate the verb \"estar\" to the Tú tense:\n" +
                    "\n" +
                    "1. estar\n" +
                    "2. est\n" +
                    "3. estabas\n" +
                    "\n" +
                    "The following three verbs are irregular in the imperfect tense. Conjugate them to learn their patterns!\n" +
                    "\n" +
                    "• ser\n" +
                    "• ir\n" +
                    "• ver");
        } else if (verbTense == 3) {
            // Future tense
            learnText.setText("The future tense is used to describe actions that will happen in the future. For example, \"I dance\" to \"I will dance\".\n" +
                    "\n" +
                    "The future tense is formed by adding the future tense endings to the infinitive of the verb. The endings are the same for each verb.\n" +
                    "\n" +
                    "Future tense endings:\n" +
                    "\n" +
                    "Yo: -é\n" +
                    "Tú: -ás\n" +
                    "Él/ella/usted: -á\n" +
                    "Nosotros: -emos\n" +
                    "Vosotros: -éis\n" +
                    "Ellos/ellas/ustedes: -án\n" +
                    "\n" +
                    "For example, to conjugate the verb \"bailar\" to the ellos/ellas/ustedes form, just add the ending to the verb: \"Las chicas bailarán mañana\".\n" +
                    "\n" +
                    "The following verbs are irregular in the future tense. They require a stem change before the future tense endings are added.\n" +
                    "\n" +
                    "• saber → sabr-\n" +
                    "• haber → habr-\n" +
                    "• poder → podr-\n" +
                    "• querer → querr-\n" +
                    "• poner → pondr-\n" +
                    "• salir → saldr-\n" +
                    "• tener → tendr-\n" +
                    "• venir → vendr-\n" +
                    "• decir → dir-\n" +
                    "• hacer → har-");
        } else if (verbTense == 4) {
            // Negative command tense
            learnText.setText("The imperative tense is used to tell someone to do or not to do something, respectfully or directly. It has three parts: tú commands, nosotros commands, and usted/ustedes commands.\n" +
                    "\n" +
                    "Tú commands are used to give commands to someone you know well. Regular AFFIRMATIVE TÚ COMMANDS are the same as the él/ella/usted form of a verb in the present tense. To form this command, remove the ending and add the present tense él/ella/usted ending.\n" +
                    "\n" +
                    "1. lavar\n" +
                    "2. lav-\n" +
                    "3. lava\n" +
                    "Example: \"¡Lava los platos!\"\n" +
                    "\n" +
                    "The following are irregular affirmative tú commands:\n" +
                    "• hacer → haz\n" +
                    "• ir → ve\n" +
                    "• ser → sé\n" +
                    "• poner → pon\n" +
                    "• salir → sal\n" +
                    "• decir → di\n" +
                    "• venir → ven\n" +
                    "• tener → ten\n" +
                    "\n" +
                    "Example: \"Pon la mesa.\"\n" +
                    "\n" +
                    "NEGATIVE TÚ COMMANDS tell someone you know well to not do something. All negative commands start with \"no\" and then the verb. Here are the steps to form a negative tú command:\n" +
                    "\n" +
                    "1. Write Yo form of the verb in the present tense\n" +
                    "2. Remove the -o ending\n" +
                    "3. Add -es ending if it's an -ar verb\n" +
                    "4. Add -as ending if it's an -er/-ir verb\n" +
                    "\n" +
                    "For example, here is the negative command for \"poder\":\n" +
                    "\n" +
                    "1. No puedo\n" +
                    "2. No pued-\n" +
                    "3. No puedas\n" +
                    "\n" +
                    "And, here is the negative command for \"cantar\":\n" +
                    "\n" +
                    "1. No canto\n" +
                    "2. No cant-\n" +
                    "3. No cantes\n" +
                    "\n" +
                    "Verbs that end with -car, -gar, and -zar have spelling changes for pronunciation.\n" +
                    "\n" +
                    "• c → qu\n" +
                    "• g → gu\n" +
                    "• z → c\n" +
                    "Example of \"almorzar\": \"No almuerces!\"\n" +
                    "\n" +
                    "The following are irregular negative tú commands:\n" +
                    "• dar: \"no des\"\n" +
                    "• estar: \"no estés\"\n" +
                    "• ir: \"no vayas\"\n" +
                    "• saber: \"no sepas\"\n" +
                    "• ser: \"no seas\"\n" +
                    "\n" +
                    "NOSOTROS COMMANDS are used when the speaker is included, following a form of \"Let's...blah blah blah\".\n" +
                    "\n" +
                    "To form nosotros commands, follow these three steps:\n" +
                    "\n" +
                    "1. Write the yo form of the verb in the present tense\n" +
                    "2. Remove the -o ending\n" +
                    "3. Add -emos ending if it's an -ar verb\n" +
                    "4. Add -amos ending if it's an -er/-ir verb\n" +
                    "\n" +
                    "For example, to form a nosotros command with the verb \"hablar\":\n" +
                    "\n" +
                    "1. hablo\n" +
                    "2. habl-\n" +
                    "3. hablemos\n" +
                    "\n" +
                    "USTED/USTEDES COMMANDS are used to tell someone respectfully what to do or not to do. Affirmative commands are just the conjugated verb. Negative commands just add \"no\" before the conjugated verb.\n" +
                    "\n" +
                    "To form an usted command, follow these three steps:\n" +
                    "\n" +
                    "1. Write the yo form of the verb in the present tense\n" +
                    "2. Remove the -o ending\n" +
                    "3. Add -e if it's an -ar verb\n" +
                    "4. Add -a if it's an -er/-ir verb\n" +
                    "\n" +
                    "For example, \"tener\" → \"tenga\" or \"cantar\" to \"cante\".\n" +
                    "\n" +
                    "Verbs that end with -car, -gar, and -zar have spelling changes for pronunciation.\n" +
                    "\n" +
                    "• c → qu\n" +
                    "• g → gu\n" +
                    "• z → c\n" +
                    "Example of \"buscar\": \"No busque!\"\n" +
                    "\n" +
                    "To form the ustedes command, just add an 'n' to the usted command. \"tenga\" → \"tengan\"\n" +
                    "\n" +
                    "The following are irregular usted/ustedes commands:\n" +
                    "• dar → dé/den\n" +
                    "• estar → esté/estén\n" +
                    "• ir → vaya/vayan\n" +
                    "• saber → sepa/sepan\n" +
                    "• ser → sea/sean");
        } else if (verbTense == 5) {
            // Present subjunctive tense
            learnText.setText("The present subjunctive is used to describe emotions of doubt, hope, or other emotion in a subjective manner. For example, \"Es importante que ella aprenda español.\"\n" +
                    "\n" +
                    "To form the present subjunctive, follow these steps:\n" +
                    "\n" +
                    "1. Write the yo form of the verb in the present tense\n" +
                    "2. Remove the -o ending from the verb\n" +
                    "3. Add -e endings if it's an -ar verb\n" +
                    "4. Add -a endings if it's an -er/-ir verb\n" +
                    "\n" +
                    "The -e endings:\n" +
                    "Yo: -e\n" +
                    "Tú: -es\n" +
                    "Él/ella/usted: -e\n" +
                    "Nosotros: -emos\n" +
                    "Vosotros: -éis\n" +
                    "Ellos/ellas/ustedes: -en\n" +
                    "\n" +
                    "The -a endings:\n" +
                    "Yo: -a\n" +
                    "Tú: -as\n" +
                    "Él/ella/usted: -a\n" +
                    "Nosotros: -amos\n" +
                    "Vosotros: -áis\n" +
                    "Ellos/ellas/ustedes: -an\n" +
                    "\n" +
                    "For example, to conjugate \"aprender\" to the ellos/ellas/ustedes form in the present subjunctive:\n" +
                    "\n" +
                    "1. aprendo\n" +
                    "2. aprend-\n" +
                    "4. aprendan\n" +
                    "\n" +
                    "There is a spelling change for verbs that end with -car, -gar, -ger, -guir, and -zar to maintain pronunciation.\n" +
                    "\n" +
                    "• -car: c → qu\n" +
                    "• -gar: g → gu\n" +
                    "• -zar: z → c\n" +
                    "• -ger: g → j\n" +
                    "• -guir: gu → g\n" +
                    "\n" +
                    "Example of \"proteger\": proteja. Example of \"extinguir\": extinga.\n" +
                    "\n" +
                    "The following verbs are irregular in the present subjunctive. Conjugate them and learn their patterns!\n" +
                    "• estar\n" +
                    "• dar\n" +
                    "• ir\n" +
                    "• saber\n" +
                    "• ser\n" +
                    "• haber");
        } else if (verbTense == 6) {
            // Imperfect subjunctive tense
            learnText.setText("The imperfect subjunctive is used to describe expressions of hope, doubt, emotion or opinion in the past.\n" +
                    "\n" +
                    "To form the imperfect subjunctive, follow these three steps:\n" +
                    "\n" +
                    "1. Write the ellos/ellas/ustedes form of the verb in the preterite tense\n" +
                    "2. Remove the -ron ending\n" +
                    "3. Add the appropriate imperfect subjunctive ending\n" +
                    "\n" +
                    "The imperfect subjunctive endings:\n" +
                    "\n" +
                    "Yo: -ra\n" +
                    "Tú: -ras\n" +
                    "Él/ella/usted: -ra\n" +
                    "Nosotros: -'ramos\n" +
                    "Vosotros: -rais\n" +
                    "Ellos/ellas/ustedes: -ran\n" +
                    "\n" +
                    "For example, to conjugate \"dormir\" in the Tú form:\n" +
                    "\n" +
                    "1. durmieron\n" +
                    "2. durmie-\n" +
                    "3. durmieras");
        } else if (verbTense == 7) {
            // Conditional tense
            learnText.setText("The conditional tense is used to describe what someone would or wouldn't do.\n" +
                    "\n" +
                    "To form the conditional tense, just add the conditional endings to the infinitive of the verb.\n" +
                    "\n" +
                    "The conditional endings:\n" +
                    "\n" +
                    "Yo: -ía\n" +
                    "Tú: -ías\n" +
                    "Él/ella/usted: -ía\n" +
                    "Nosotros: -íamos\n" +
                    "Vosotros: -íais\n" +
                    "Ellos/ellas/ustedes: -ían\n" +
                    "\n" +
                    "For example, to conjugate \"comprar\" in the ellos/ellas/ustedes form, just add \"-ían\": comprarían." +
                    "\n" +
                            "The following verbs are irregular in the conditional tense. They require a stem change before the conditional tense endings are added.\n" +
                            "\n" +
                            "• saber → sabr-\n" +
                            "• haber → habr-\n" +
                            "• poder → podr-\n" +
                            "• querer → querr-\n" +
                            "• poner → pondr-\n" +
                            "• salir → saldr-\n" +
                            "• tener → tendr-\n" +
                            "• venir → vendr-\n" +
                            "• decir → dir-\n" +
                            "• hacer → har-");
        } else if (verbTense == 8) {
            // Present Perfect tense
            learnText.setText("The present perfect tense is used to describe events that have already happened.\n" +
                    "\n" +
                    "To form the present perfect tense, follow these steps:\n" +
                    "\n" +
                    "1. Conjugate the verb \"haber\" in the present tense\n" +
                    "2. Add the past participle of the main verb\n" +
                    "\n" +
                    "Basically, present tense \"haber\" plus past participle.\n" +
                    "\n" +
                    "Conjugations of \"haber\":\n" +
                    "• Yo he\n" +
                    "• Tú has\n" +
                    "• Él/ella/usted ha\n" +
                    "• Nosotros hemos\n" +
                    "• Vosotros habéis\n" +
                    "• Ellos/ellas/ustedes han\n" +
                    "\n" +
                    "For example, to conjugate \"comer\" to the Nosotros form: nosotros hemos comido, which translates to \"We have (already) eaten.\"");
        } else if (verbTense == 9) {
            // Past Perfect tense
            learnText.setText("The past perfect tense is used to describe events that had already occurred.\n" +
                    "\n" +
                    "To form the past perfect tense, follow these steps:\n" +
                    "\n" +
                    "1. Conjugate the verb \"haber\" in the imperfect tense\n" +
                    "2. Add the past participle of the main verb\n" +
                    "\n" +
                    "Basically, imperfect tense \"haber\" plus past participle.\n" +
                    "\n" +
                    "Conjugations of \"haber\":\n" +
                    "• Yo había\n" +
                    "• Tú habías\n" +
                    "• Él/ella/usted había\n" +
                    "• Nosotros habíamos\n" +
                    "• Vosotros habíais\n" +
                    "• Ellos/ellas/ustedes habían\n" +
                    "\n" +
                    "For example, to conjugate \"visitar\" to the Nosotros form: nosotros habíamos visitado, which translates to \"We had (already) visited.\"");
        } else if (verbTense == 10) {
            // Future Perfect tense
            learnText.setText("The future perfect tense is used to describe what will have happened at a certain point in the future.\n" +
                    "\n" +
                    "To form the future perfect tense, follow these steps:\n" +
                    "\n" +
                    "1. Conjugate the verb \"haber\" in the future tense\n" +
                    "2. Add the past participle of the main verb\n" +
                    "\n" +
                    "Basically, future tense \"haber\" plus past participle.\n" +
                    "\n" +
                    "Conjugations of \"haber\":\n" +
                    "• Yo habré\n" +
                    "• Tú habrás\n" +
                    "• Él/ella/usted habrá\n" +
                    "• Nosotros habremos\n" +
                    "• Vosotros habréis\n" +
                    "• Ellos/ellas/ustedes habrán\n" +
                    "\n" +
                    "For example, to conjugate \"visitar\" to the Nosotros form: nosotros habremos visitado, which translates to \"We will have (already) visited.\"");
        } else if (verbTense == 11) {
            // Present Perfect Subjunctive tense
            learnText.setText("To form the present perfect subjunctive tense, follow these steps:\n" +
                    "\n" +
                    "1. Conjugate the verb \"haber\" in the present subjunctive tense\n" +
                    "2. Add the past participle of the main verb\n" +
                    "\n" +
                    "Basically, present subjunctive tense \"haber\" plus past participle.\n" +
                    "\n" +
                    "Conjugations of \"haber\":\n" +
                    "• Yo haya\n" +
                    "• Tú hayas\n" +
                    "• Él/ella/usted haya\n" +
                    "• Nosotros hayamos\n" +
                    "• Vosotros hayáis\n" +
                    "• Ellos/ellas/ustedes hayan\n" +
                    "\n" +
                    "For example, to conjugate \"compartir\" to the Yo form: \"Yo haya compartido\".");
        } else if (verbTense == 12) {
            // Past Perfect Subjunctive tense
            learnText.setText("To form the past perfect subjunctive tense, follow these steps:\n" +
                    "\n" +
                    "1. Conjugate the verb \"haber\" in the imperfect subjunctive tense\n" +
                    "2. Add the past participle of the main verb\n" +
                    "\n" +
                    "Basically, imperfect subjunctive tense \"haber\" plus past participle.\n" +
                    "\n" +
                    "Conjugations of \"haber\":\n" +
                    "• Yo hubiera\n" +
                    "• Tú hubieras\n" +
                    "• Él/ella/usted hubiera\n" +
                    "• Nosotros hubiéramos\n" +
                    "• Vosotros hubierais\n" +
                    "• Ellos/ellas/ustedes hubieran\n" +
                    "\n" +
                    "For example, to conjugate \"dormir\" to the Yo form: \"Yo hubiera dormido\".");
        } else if (verbTense == 13) {
            // Past participle
            learnText.setText("The past participle is used as an adjective with the verb \"estar\" to describe the result of an action (and also in the perfect tenses with the verb \"haber\").\n" +
                    "\n" +
                    "To form the past participle, follow these simple three steps:\n" +
                    "\n" +
                    "1. Take the infinitive of the verb\n" +
                    "2. Remove -ar, -er, or -ir ending\n" +
                    "3. Add -ado for -ar verbs and -ido for -er/-ir verbs\n" +
                    "\n" +
                    "For example, the past participle of \"cerrar\" is \"cerrado\". The past participle of \"beber\" is \"bebido\".\n" +
                    "\n" +
                    "The -ir/-er verbs whose stem ends with a vowel have an accent over the i in -ido. For example, the past participle of \"traer\" is \"traído\".\n" +
                    "\n" +
                    "The following are irregular past participles:\n" +
                    "• abrir → abierto\n" +
                    "• decir → dicho\n" +
                    "• poner → puesto\n" +
                    "• freír → frito\n" +
                    "• hacer → hecho\n" +
                    "• imprimir → impreso\n" +
                    "• ir → ido\n" +
                    "• morir → muerto\n" +
                    "• escribir → escrito\n" +
                    "• romper → roto\n" +
                    "• ver → visto\n" +
                    "• volver → vuelto\n" +
                    "• resolver → resuelto\n" +
                    "• cubrir → cubierto\n" +
                    "• descubrir → descubierto");
        } else if (verbTense == 14) {
            // Gerund
            learnText.setText("The gerund, or present participle, is used to describe continuous or progressive actions, usually with the word \"estar\".\n" +
                    "\n" +
                    "To form a gerund, you must first remove -ar, -er, or -ir from the verb ending. Then, add either '-ando' for -ar verbs or '-iendo' for -er verbs. For example:\n" +
                    "\n" +
                    "• hablar → hablando\n" +
                    "• comer → comiendo\n" +
                    "• escribir → escribiendo\n" +
                    "\n" +
                    "If the stem of an -er or -ir verb ends with a vowel, you would replace -iendo with -yendo to maintain pronunciation.\n" +
                    "\n" +
                    "• construir → construyendo\n" +
                    "• leer → leyendo\n" +
                    "• traer → trayendo\n" +
                    "\n" +
                    "Similarly, if the stem of the verb ends with 'ñ' or 'll', you use -endo instead of -iendo.\n" +
                    " \n" +
                    "All -ir verbs that have the e → i and o → u stem change in the preterite tense maintain that stem change in the gerund. Conjugate verbs like 'dormir' and 'pedir' to see this.");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        verbTense = tenseSpinner.getSelectedItemPosition();
        teach();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
