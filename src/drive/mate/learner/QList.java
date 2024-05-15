package drive.mate.learner;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author smbha
 */
public class QList {

    //English Questions
    public static final String[] questionsEn = {
        "What animal is shown in the video?",
        "What object is depicted in the video?",
        "Which pet is featured in the video?",
        "What fruit is shown in the video?",
        "What vehicle is shown in the video?",
        "What building is shown in the video?",
        "What sport is played in the video?",
        "What musical instrument is played in the video?",
        "What natural phenomenon is shown in the video?",
        "What type of dance is performed in the video?",
        "What type of weather is shown in the video?",
        "What type of plant is shown in the video?",
        "What type of fish is shown in the video?",
        "What famous landmark is shown in the video?",
        "What type of bird is shown in the video?",
        "What mode of transportation is shown in the video?",
        "What kitchen utensil is shown in the video?",
        "What type of fabric is shown in the video?",
        "What type of animal habitat is shown in the video?",
        "What famous person is shown in the video?"
    };

    //Answers in English
    public static final Map<Integer, String[]> videoButtonTextsEn = new HashMap<>();

    static {
        videoButtonTextsEn.put(0, new String[]{"animal is shown in the vide", "animal is shown in the vide", "animal is shown in the vide", "Mango animal is shown in the vide"});
        videoButtonTextsEn.put(1, new String[]{"Mask", "Did", "Horn", "Tim"});
        videoButtonTextsEn.put(2, new String[]{"Cat", "Dog", "Fish", "Bird"});
        videoButtonTextsEn.put(3, new String[]{"Banana", "Car", "Apple", "Orange"});
        videoButtonTextsEn.put(4, new String[]{"Bus", "Train", "Bicycle", "Truck"});
        videoButtonTextsEn.put(5, new String[]{"Skyscraper", "House", "Cottage", "Cabin"});
        videoButtonTextsEn.put(6, new String[]{"Football", "Tennis", "Basketball", "Hockey"});
        videoButtonTextsEn.put(7, new String[]{"Piano", "Guitar", "Violin", "Drum"});
        videoButtonTextsEn.put(8, new String[]{"Rainbow", "Tornado", "Rain", "Sunshine"});
        videoButtonTextsEn.put(9, new String[]{"Ballet", "Jazz", "Hip-Hop", "Salsa"});
        videoButtonTextsEn.put(10, new String[]{"Sunny", "Rainy", "Snowy", "Windy"});
        videoButtonTextsEn.put(11, new String[]{"Rose", "Tulip", "Sunflower", "Daisy"});
        videoButtonTextsEn.put(12, new String[]{"Goldfish", "Shark", "Salmon", "Trout"});
        videoButtonTextsEn.put(13, new String[]{"Eiffel Tower", "Statue of Liberty", "Big Ben", "Colosseum"});
        videoButtonTextsEn.put(14, new String[]{"Eagle", "Parrot", "Sparrow", "Pigeon"});
        videoButtonTextsEn.put(15, new String[]{"Car", "Airplane", "Boat", "Train"});
        videoButtonTextsEn.put(16, new String[]{"Spoon", "Fork", "Knife", "Whisk"});
        videoButtonTextsEn.put(17, new String[]{"Cotton", "Silk", "Wool", "Denim"});
        videoButtonTextsEn.put(18, new String[]{"Forest", "Desert", "Ocean", "Jungle"});
        videoButtonTextsEn.put(19, new String[]{"Albert Einstein", "Leonardo da Vinci", "Marie Curie", "Isaac Newton"});
    }

    //Sinhala Questions
    public static final String[] questionsSi = {
        "වීඩියෝවෙහි පෙන්වන සත්ත්වයා කවරෙකි?",
        "වීඩියෝවෙහි පෙන්වන වස්තුව කවරේද?",
        "වීඩියෝවෙහි පෙන්වන සුරතලියා කවරෙකි?",
        "වීඩියෝවෙහි පෙන්වන පළතුරු කවරේද?",
        "වීඩියෝවෙහි පෙන්වන වාහනය කවරේද?",
        "වීඩියෝවෙහි පෙන්වන ගොඩනැගිල්ල කවරේද?",
        "වීඩියෝවෙහි ක්‍රීඩාව කවරක්ද?",
        "වීඩියෝවෙහි වාදනය කරන සංගීත උපකරණය කවරක්ද?",
        "වීඩියෝවෙහි පෙන්වන ස්වාභාවික පෙනුම කවරක්ද?",
        "වීඩියෝවෙහි නර්තනය කවරක්ද?",
        "වීඩියෝවෙහි පෙන්වන කාලගුණය කවරක්ද?",
        "වීඩියෝවෙහි පෙන්වන පැළයක් කවරක්ද?",
        "වීඩියෝවෙහි පෙන්වන මසුන් කවරෙක්ද?",
        "වීඩියෝවෙහි පෙන්වන ප්‍රසිද්ධ ස්ථානය කවරක්ද?",
        "වීඩියෝවෙහි පෙන්වන කුරුල්ලෙක් කවරෙක්ද?",
        "වීඩියෝවෙහි පෙන්වන ප්‍රවාහන ක්‍රමය කවරක්ද?",
        "වීඩියෝවෙහි පෙන්වන කුස්සියේ උපකරණය කවරක්ද?",
        "වීඩියෝවෙහි පෙන්වන රෙදි පටය කවරක්ද?",
        "වීඩියෝවෙහි පෙන්වන සත්ත්ව පරිසරය කවරක්ද?",
        "වීඩියෝවෙහි පෙන්වන ප්‍රසිද්ධ පුද්ගලයා කවරෙක්ද?"
    };

    //Answers in Sinhala
    public static final Map<Integer, String[]> videoButtonTextsSi = new HashMap<>();

    static {
        videoButtonTextsSi.put(0, new String[]{"මුස්", "උර", "ඇපල්", "අඹ"});
        videoButtonTextsSi.put(1, new String[]{"මුව ආවරණය", "කලේය", "හෙණ", "ටිම්"});
        videoButtonTextsSi.put(2, new String[]{"පූස", "බල්ලා", "මාළු", "කුරුල්ලෙක්"});
        videoButtonTextsSi.put(3, new String[]{"කෙසෙල්", "මෝටර් රථයක්", "ඇපල්", "ඕරේන්ජ්"});
        videoButtonTextsSi.put(4, new String[]{"බස් රථය", "දුම්රිය", "බයිසිකලය", "ලොරිය"});
        videoButtonTextsSi.put(5, new String[]{"ඉහළ ගොඩනැගිල්ල", "නිවස", "කුටි කාමරය", "කැබිනය"});
        videoButtonTextsSi.put(6, new String[]{"පෙති", "ටෙනිස්", "බාස්කට්බෝල්", "හොකී"});
        videoButtonTextsSi.put(7, new String[]{"පියානෝ", "ගිටාර්", "වයලින්", "ඩ්රම්"});
        videoButtonTextsSi.put(8, new String[]{"ඇඳිරිනීතිය", "සුළි කුණාටුව", "වැසි", "හිරු"});
        videoButtonTextsSi.put(9, new String[]{"බැලේ", "ජැස්", "හිපොප්", "සැල්සා"});
        videoButtonTextsSi.put(10, new String[]{"උණුසුම", "වැසි", "හිම", "සුළං"});
        videoButtonTextsSi.put(11, new String[]{"රෝස", "ට්යුලිප්", "සුර්යකාන්ත", "මල් කැකුළ"});
        videoButtonTextsSi.put(12, new String[]{"ගෝල්ඩ්ෆිෂ්", "සූර", "සැල්මන්", "ට්‍රවුට්"});
        videoButtonTextsSi.put(13, new String[]{"අයිෆල් කුළුණ", "ස්වයං නිදහස් රුපකය", "බිග් බෑන්", "කොලිසියම්"});
        videoButtonTextsSi.put(14, new String[]{"රජළිය", "පරිට්ටුව", "කුරුල්ලෙක්", "පිජන්"});
        videoButtonTextsSi.put(15, new String[]{"මෝටර් රථය", "විමානය", "බෝට්ටුව", "දුම්රිය"});
        videoButtonTextsSi.put(16, new String[]{"හන්දි", "කාම", "පිහිය", "වීදුරු"});
        videoButtonTextsSi.put(17, new String[]{"කපු", "සෙර", "වූල්", "ඩෙනිම්"});
        videoButtonTextsSi.put(18, new String[]{"වනාන්තර", "අහස", "මහ සයුර", "ජංගි"});
        videoButtonTextsSi.put(19, new String[]{"ඇල්බට් අයින්ස්ටයින්", "ලියොනාර්ඩෝ ද වින්චි", "මරී කුරී", "අයිසැක් නිව්ටන්"});
    }

    //Tamil Questions
    public static final String[] questionsTa = {
        "வீடியோவில் காணப்படும் விலங்கு என்ன?",
        "வீடியோவில் காணப்படும் பொருள் என்ன?",
        "வீடியோவில் காணப்படும் செல்லப்பிராணி என்ன?",
        "வீடியோவில் காணப்படும் பழம் என்ன?",
        "வீடியோவில் காணப்படும் வாகனம் என்ன?",
        "வீடியோவில் காணப்படும் கட்டிடம் என்ன?",
        "வீடியோவில் விளையாடப்படும் விளையாட்டு என்ன?",
        "வீடியோவில் வாசிக்கப்படும் இசைக்கருவி என்ன?",
        "வீடியோவில் காணப்படும் இயற்கை நிகழ்வு என்ன?",
        "வீடியோவில் நடன வகை என்ன?",
        "வீடியோவில் காணப்படும் வானிலை என்ன?",
        "வீடியோவில் காணப்படும் செடி என்ன?",
        "வீடியோவில் காணப்படும் மீன் என்ன?",
        "வீடியோவில் காணப்படும் புகழ்பெற்ற இடம் என்ன?",
        "வீடியோவில் காணப்படும் பறவை என்ன?",
        "வீடியோவில் காணப்படும் போக்குவரத்து முறை என்ன?",
        "வீடியோவில் காணப்படும் சமையல் சாதனம் என்ன?",
        "வீடியோவில் காணப்படும் துணி வகை என்ன?",
        "வீடியோவில் காணப்படும் விலங்கு வாழிடம் என்ன?",
        "வீடியோவில் காணப்படும் புகழ்பெற்ற நபர் யார்?"
    };

    // Answers in Tamil
    public static final Map<Integer, String[]> videoButtonTextsTa = new HashMap<>();

    static {
        videoButtonTextsTa.put(0, new String[]{"மூஸ்", "வெள்ளாடு", "ஆப்பிள்", "மாம்பழம்"});
        videoButtonTextsTa.put(1, new String[]{"முக கவசம்", "செய்தது", "கொம்பு", "டிம்"});
        videoButtonTextsTa.put(2, new String[]{"பூனை", "நாய்", "மீன்", "பறவை"});
        videoButtonTextsTa.put(3, new String[]{"வாழைப்பழம்", "கார்", "ஆப்பிள்", "ஆரஞ்சு"});
        videoButtonTextsTa.put(4, new String[]{"பஸ்", "ரயில்", "மிதிவண்டி", "லாரி"});
        videoButtonTextsTa.put(5, new String[]{"ஆகாயசாளரம்", "வீடு", "குடிசை", "மோடை"});
        videoButtonTextsTa.put(6, new String[]{"கால்பந்து", "டென்னிஸ்", "விளையாட்டுப் பந்து", "ஹாக்கி"});
        videoButtonTextsTa.put(7, new String[]{"பியானோ", "கிட்டார்", "வயலின்", "மிருதங்கம்"});
        videoButtonTextsTa.put(8, new String[]{"வானவில்", "சூறாவளி", "மழை", "வெயில்"});
        videoButtonTextsTa.put(9, new String[]{"பாலே", "ஜாஸ்", "ஹிப்-ஹாப்", "சால்சா"});
        videoButtonTextsTa.put(10, new String[]{"வெயில்", "மழை", "பனிச்சாரல்", "காற்று"});
        videoButtonTextsTa.put(11, new String[]{"ரோஜா", "தூலிப் பூ", "சூரியகாந்தி", "டெய்ஸி"});
        videoButtonTextsTa.put(12, new String[]{"கோல்ட்ஃபிஷ்", "சுறா", "சால்மன்", "ட்ரவுட்"});
        videoButtonTextsTa.put(13, new String[]{"ஐஃபெல் கோபுரம்", "சுதந்திர சிலை", "பிக் பென்", "கோலிசியம்"});
        videoButtonTextsTa.put(14, new String[]{"கழுகு", "கிளி", "சிட்டுக்குருவி", "புறா"});
        videoButtonTextsTa.put(15, new String[]{"கார்", "விமானம்", "படகு", "ரயில்"});
        videoButtonTextsTa.put(16, new String[]{"கரண்டி", "முள்", "கத்தி", "விசிறி"});
        videoButtonTextsTa.put(17, new String[]{"காட்டன்", "பட்டு", "கம்பளி", "டெனிம்"});
        videoButtonTextsTa.put(18, new String[]{"காடு", "பாலைவனம்", "கடல்", "காட்டில்"});
        videoButtonTextsTa.put(19, new String[]{"ஆல்பர்ட் ஐன்ஸ்டீன்", "லியோனார்டோ டா வின்சி", "மேரி கியூரி", "ஐசக் நியூட்டன்"});
    }
    
    public static String[] getQuestions(String language) {
        switch (language) {
            case "Sinhala":
                return questionsSi;
            case "Tamil":
                return questionsTa;
            default:
                return questionsEn;
        }
    }

    public static Map<Integer, String[]> getVideoButtonTexts(String language) {
        switch (language) {
            case "Sinhala":
                return videoButtonTextsSi;
            case "Tamil":
                return videoButtonTextsTa;
            default:
                return videoButtonTextsEn;
        }
    }
}
