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
        "What is meant by this single white line in the middle of the road?",
        "What does it mean when there are 2 white lines next to each other in the middle of the road?",
        "What should you do when your mobile phone rings while driving on the road?",
        "What does this road sign indicate?",
        "What should you do at a pedestrian crossing?",
        "What is the instruction given by the shown police officer?",
        "What does this road sign indicate?",
        "What is the instruction given by the shown police officer?",
        "What does this road sign indicate?",
        "When is the use of the expressway not prohibited?",
        "What does this road sign indicate?",
        "What is considered a vehicle suitable for highway driving?",
        "When should you not overtake another vehicle?",
        "What should you do when the vehicle's tires have less air than the recommended amount?",
        "When should hazard warning lights be turned on?",
        "What should you do when driving in rainy weather?",
        "What is meant by this road sign?",
        "What should you do to reduce the risk when a vehicle skids?",
        "When should the hazard warning lamps of a vehicle be used?",
        "What should you do when a vehicle has met with an accident on the road?"
    };

    //Answers in English
    public static final Map<Integer, String[]> videoButtonTextsEn = new HashMap<>();

    static {
        videoButtonTextsEn.put(0, new String[]{"Overtaking by crossing the white line is prohibited", "Used to indicate the danger of a bend", "Turning to the right is prohibited", "Line used to divide the road"});
        videoButtonTextsEn.put(1, new String[]{"Overtaking or turning to the right by crossing the lines is prohibited", "Turning to the right is allowed", "Overtaking is allowed", "Both overtaking and turning to the right are allowed"});
        videoButtonTextsEn.put(2, new String[]{"Stop the vehicle and then respond to the phone", "Steer with one hand and take the phone with the other hand", "Cannot respond only in urban areas", "Do not carry the phone while driving the vehicle"});
        videoButtonTextsEn.put(3, new String[]{"Children crossing ahead", "Children crossing", "School ahead", "Blind people crossing ahead"});
        videoButtonTextsEn.put(4, new String[]{"Pedestrians can cross only at the pedestrian crossing", "Pedestrians can cross at any place within 25 meters", "Pedestrians can cross at any place within 50 meters", "Pedestrians can cross at any place within 30 meters"});
        videoButtonTextsEn.put(5, new String[]{"Stop", "Move forward", "Vehicles in front and behind stop", "Vehicles coming from behind stop"});
        videoButtonTextsEn.put(6, new String[]{"Speed limit", "Speed limit within city limits", "Minimum speed", "Normal speed"});
        videoButtonTextsEn.put(7, new String[]{"Vehicles in front and behind stop", "Vehicles coming from the front stop", "Stop", "Vehicles coming from behind stop"});
        videoButtonTextsEn.put(8, new String[]{"Prohibitory sign", "Mandatory sign", "Warning sign", "Information sign"});
        videoButtonTextsEn.put(9, new String[]{"For lorries", "For three-wheelers", "For land vehicles", "For motorcycles"});
        videoButtonTextsEn.put(10, new String[]{"Parking prohibited", "Parking is prohibited on even days", "Parking and loading prohibited", "Road closed for all vehicles"});
        videoButtonTextsEn.put(11, new String[]{"Having proper mechanical condition and required documents", "Any vehicle that the driver can control", "Only having steering, brakes, and tires", "Having the driving license and insurance certificate"});
        videoButtonTextsEn.put(12, new String[]{"At a dangerous bend", "In front of a court", "On a road with broken lines marked", "In front of a hospital"});
        videoButtonTextsEn.put(13, new String[]{"Tire wears quickly on both sides", "Tire wears quickly in the middle", "Tire wears quickly", "Tire wears unevenly"});
        videoButtonTextsEn.put(14, new String[]{"When stopping a vehicle involved in an accident on the highway", "When overtaking a vehicle in a dangerous place", "When going straight at an intersection", "When transporting a patient"});
        videoButtonTextsEn.put(15, new String[]{"Driving slowly in low gear", "Driving fast in high gear", "Driving slowly in high gear", "No need to worry if the vehicle tires are in good condition"});
        videoButtonTextsEn.put(16, new String[]{"Slippery road ahead", "Curvy road ahead", "Narrow road ahead", "Dangerous intersection ahead"});
        videoButtonTextsEn.put(17, new String[]{"Control the skid with the gears and gradually steer in the direction of the skid", "Turn the steering wheel in the direction of the skid without braking", "Cannot reduce the danger during a skid", "Apply brakes immediately to control speed"});
        videoButtonTextsEn.put(18, new String[]{"When the vehicle is disabled and parked on the road", "To gain priority", "When driving straight at an intersection", "To indicate that the vehicle is traveling due to an emergency"});
        videoButtonTextsEn.put(19, new String[]{"Can mark the vehicle's position and transport patients", "The vehicle cannot be removed for any reason", "The vehicle must be kept in the same place", "Can be removed from the road to avoid obstructing other vehicles"});
   }

    
//Sinhala Questions
public static final String[] questionsSi = {
        "පාරේ මැද ඇති මෙම තනි සුදු ඉරෙන් අදහස් වන්නේ ? ",
        "පාරේ මැද එක ළඟින් වූ සුදු ඉරි 2ක් ඇති විට ?",
        "ඔබ මාර්ගයේ ගමන් කරන විට මෙලෙස ජංගම දුරකථනය නාද වූවහොත් ?",
        "මෙම මාර්ග සංඥාවෙන් දැක්වෙන්නේ",
        "පදික මාරුවක් ඇතිවිට ",
        "පෙන්වා ඇති පොලිස් නිළධාරියාගේ විධානය කුමක්ද?",
        "මෙම මාර්ග සංඥාවෙන් දැක්වෙන්නේ",
        "පෙන්වා ඇති පොලිස් නිළධාරියාගේ විධානය කුමක්ද",
        "මෙම මාර්ග සංඥාවෙන් දැක්වෙන්නේ",
        "අධිවේගී මාර්ගය භාවිතා කිරීම තහනම් කර නොමැති වන්නේ,",
        " මෙම මාර්ග සංඥාවෙන් දැක්වෙන්නේ",
        "මහාමාර්ගයේ ධාවනයට සුසුසු වාහනයක් යනු, ",
        "ඔබ වෙනත් හාහනයක් ඉස්සර නොකල යුත්තේ,",
        "වාහනයේ ටයරවල හුළං නියමිත ප්‍රමාණයට වඩා අඩුවූ විට ",
        "අවදානම් හැඟවීමේ පහන් දැල්විය යුත්තේ ",
        "වැසි සහිත කාලගුණයක් ඇති විටක වාහනය පදවන විටදී,",
        "මෙම මාර්ග සංඥාවෙන් අදහස් වන්නේ? ",
        "වාහනයක් ලිස්සා යන අවස්ථාවකදී අවදානම අඩුකර ගැනීම සඳහා",
        "වාහනයක අවධානම් හැඟවීමේ ලාම්පු භාවිතා කල යුත්තේ? ",
        "වාහනයක් මාර්ගයේ අනතුරකට ලක්වූ විටක,"
    };

    //Answers in Sinhala
    public static final Map<Integer, String[]> videoButtonTextsSi = new HashMap<>();

    static {
        videoButtonTextsSi.put(0, new String[]{"සුදු ඉර කැපෙන සේ ඉස්සර කිරීම තහනම්ය", "වංගුවක අවදානම පෙන්වීම සඳහා යොදා ඇත", "දකුණට හැරවීම තහනම්ය", "මාර්ගය බෙදීමට ඉර යොදා ඇත"});
        videoButtonTextsSi.put(1, new String[]{"ඉරි කැපෙන සේ ඉස්සර කිරීම හෝ දකුණට හැරවීම තහනම්ය", "දකුණට හැරවීමට හැකිය", "ඉස්සර කිරීමට හැකිය", "දකුණට හැරවීමට හා ඉස්සර කිරීම කල හැක"});
        videoButtonTextsSi.put(2, new String[]{"වාහනය අයින්කර නවතා දුරකථනයට ප්‍රතිචාර දැක්වීම ", "එක් අතකින් සුක්කානම ගෙන අනෙක් අතින්  දුරකථනය ගැනීම ", "නාගරික ප්‍රදේශයකදී පමණක් ප්‍රතිචාර දැක්විය නොහැක ", "වාහනයේ යනවිට දුරකතනය රැගෙන නොයාම"});
        videoButtonTextsSi.put(3, new String[]{"ළමයින් මාරුවන ස්ථානය ඉදිරියෙනි ", "ළමයින් මාරුවන ස්ථානය ", "පාසල ඉදිරියෙනි ", "අන්ධ මිනිසුන් මාරුවන ස්ථානය ඉදිරියෙනි "});
        videoButtonTextsSi.put(4, new String[]{"පදික මාරුව හරහා පමණක් පදිකයින්ට මාරුවිය හැක ", "මීටර 25ක් ඇතුලත ඕනෑම ස්ථානයකින් පදිකයින්ට මාරුවිය හැක", "මීටර 50ක් ඇතුලත ඕනෑම ස්ථානයකින් පදිකයින්ට මාරුවිය හැක", "මීටර 30ක් ඇතුලත ඕනෑම ස්ථානයකින් පදිකයින්ට මාරුවිය හැක"});
        videoButtonTextsSi.put(5, new String[]{"නවතිනු", "ඉදිරියට එනු", "ඉදීරියෙන් හා පසුපසින් එන වාහන නවතිනු", "පසුපසින් පැමිණෙන වාහන නවතිනු"});
        videoButtonTextsSi.put(6, new String[]{"වේග සීමාව", "නගර සීමාව තුළ වේග සීමාව", "අවම වේගය ", "සාමාන්‍ය වේගය"});
        videoButtonTextsSi.put(7, new String[]{"ඉදීරියෙන් හා පසුපසින් එන වාහන නවතිනු", "ඉදීරියෙන් පැමිණෙන වාහන නවතිනු ", "නවතිනු", "පසුපසින් පැමිණෙන වාහන නවතිනු"});
        videoButtonTextsSi.put(8, new String[]{"තහනම් සංඥාවකි", "විධාන සංඥාවකි", "අනතුරු හැඟවීමේ සංඥාවකි", "තොරතුරු සංඥාවකි "});
        videoButtonTextsSi.put(9, new String[]{"ලොරි සඳහා", "ත්‍රීවීල් රථ සඳහා ", "ඉඩම් වාහන සඳහා ", "මෝටර් සයිකල් සඳහා "});
        videoButtonTextsSi.put(10, new String[]{"වාහන නැවැත්වීම තහනම්", "ඔත්තේ දිනවල වාහන නැවැත්වීම තහනම් ", "නැවැත්වීම හා පැටවීම තහනම්", "සියළුම වාහන සඳහා පාර වසා ඇත"});
        videoButtonTextsSi.put(11, new String[]{"මනා කාර්මික තත්ත්වයක් හා අවශ්‍ය ලේඛන තිබීම ", "රියදුරුට පාලනය කිරීමට හැකි ඕනෑම වාහනයක් ", "සුක්කානම, තිරිංග හා ටයර් පමණක් තිබීම ", "ආදයම් බලපත්‍රය සහ රක්ෂණ සහතිකය තිබීම "});
        videoButtonTextsSi.put(12, new String[]{"අවදානම් වංගුවකදීය ", "උසාවියක් ඉදිරියේදීය ", "මාර්ගයක් මත කඩ ඉරි සලකුණු ඇති තැන්වලදීය", "ආරෝග්‍ය ශාලාවක් ඉදිරියේය"});
        videoButtonTextsSi.put(13, new String[]{"ටයරය දෙපැත්ත ඉක්මනින් ගෙවීයයි ", "ටයරය මැද ඉක්මනින් ගෙවීයයි  ", "ටයරය ඉක්මනින් ගෙවීයයි ", "ටයරයේ තැනින් තැන වේගයෙන් ගෙවීයයි "});
        videoButtonTextsSi.put(14, new String[]{"මහාමාර්ගයේ ආපදාවකට ලක්වූ වාහනයක් නවතා තබන විට  ", "අවදානම් ස්ථානයකදී වාහනයකට ඉස්සර කරන විට", "හතරමං හන්දියක කෙළින් ඉදිරියට ගමන් කරන විට ", "රෝගියෙකු ප්‍රවාහනය කරන අවස්ථාවකදී "});
        videoButtonTextsSi.put(15, new String[]{"අඩු ගියරයක හෙමින් පැදවීම ", "වැඩි ගියරයක වේගයෙන් පැදවීම ", "වැඩි ගියරයක හෙමින් පැදවීම", "වාහනයේ ටයර් හොඳින් ඇතිවිට සැලකිලිමත්විය යුතු නැත "});
        videoButtonTextsSi.put(16, new String[]{"ලිස්සනසුලු මාර්ගය ඉදිරියෙනි ", "වංගු සහිත මාර්ගය ඉදිරියෙනි ", "ඉදිරියෙන් මාර්ගය පටුය ", "අනතුරුදායක මංසන්ධිය ඉදිරියෙනි "});
        videoButtonTextsSi.put(17, new String[]{"ගියර මගින් පාලනය කර ලිස්සා යන දිශාවට ක්‍රමානුකූලව සුක්කානම පාලනය ", "තිරිංග නොයොදා ලිස්සා යන දිශාවටම සුක්කානම හැරවිය යුතුය ", "ලිස්සා යන අවස්ථාවේදී අවධානම අඩුකල නොහැක", "එකවර තිරිංග යොදා වේගය පාලනය කළ යුතුය "});
        videoButtonTextsSi.put(18, new String[]{"වාහනය අබලන්ව පාරේ නවතා තිබියදී ", "ප්‍රමුඛත්වය ලබා ගැනීමට", "හන්දියකින් කෙලින්ම ධාවනය කරන අවස්ථාවකදී ", "වාහනය හදිසි තත්ත්වයක් නිසා ගමන් කරන බව දැක්වීමට"});
        videoButtonTextsSi.put(19, new String[]{"වාහනයේ පිහිටීම සළකුණුකොට රෝගීන් ප්‍රවාහනය කල හැක  ", "කිසිම හේතුවකට වාහනය ඉවත් කළ නොහැක ", "එම වාහනය එම ස්ථානයේම තැබිය යුතුය", "අන් වාහනවලට අවහිර වීම වැලැක්වීමට මර්ගයෙන් ඉවත් කල හැක "});
    }

    //Tamil Questions
    public static final String[] questionsTa = {
        "சாலையின் நடுவில் உள்ள இந்த ஒற்றை வெள்ளைக் கோட்டின் அர்த்தம் என்ன?",
        "சாலையின் நடுவில் 2 வெள்ளைக் கோடுகள் அடுத்தடுத்து இருந்தால் என்ன அர்த்தம்?",
        "சாலையில் வாகனம் ஓட்டும்போது உங்கள் மொபைல் ஃபோன் ஒலித்தால் என்ன செய்ய வேண்டும்?",
        "இந்த சாலை அடையாளம் எதைக் குறிக்கிறது?",
        "பாதசாரி கடக்கும் இடத்தில் நீங்கள் என்ன செய்ய வேண்டும்?",
        "காட்டப்பட்ட போலீஸ் அதிகாரி கொடுத்த அறிவுரை என்ன?",
        "இந்த சாலை அடையாளம் எதைக் குறிக்கிறது?",
        "காட்டப்பட்ட போலீஸ் அதிகாரி கொடுத்த அறிவுரை என்ன?",
        "இந்த சாலை அடையாளம் எதைக் குறிக்கிறது?",
        "எப்போது எக்ஸ்பிரஸ்வேயின் பயன்பாடு தடை செய்யப்படவில்லை?",
        "இந்த சாலை அடையாளம் எதைக் குறிக்கிறது?",
        "நெடுஞ்சாலை ஓட்டுவதற்கு ஏற்ற வாகனம் எது?",
        "நீங்கள் எப்போது மற்றொரு வாகனத்தை முந்திச் செல்லக்கூடாது?",
        "வாகனத்தின் டயர்களில் பரிந்துரைக்கப்பட்ட அளவை விட குறைவான காற்று இருக்கும்போது நீங்கள் என்ன செய்ய வேண்டும்?",
        "அபாய எச்சரிக்கை விளக்குகளை எப்போது இயக்க வேண்டும்?",
        "மழை காலநிலையில் வாகனம் ஓட்டும்போது என்ன செய்ய வேண்டும்?",
        "இந்த சாலை அடையாளத்தின் அர்த்தம் என்ன?",
        "வாகனம் சறுக்கும் போது ஏற்படும் ஆபத்தை குறைக்க என்ன செய்ய வேண்டும்?",
        "வாகனத்தின் அபாய எச்சரிக்கை விளக்குகளை எப்போது பயன்படுத்த வேண்டும்?",
        "சாலையில் ஒரு வாகனம் விபத்துக்குள்ளானால் நீங்கள் என்ன செய்ய வேண்டும்?"
    };

    // Answers in Tamil
    public static final Map<Integer, String[]> videoButtonTextsTa = new HashMap<>();

static {
    videoButtonTextsTa.put(0, new String[]{"வெள்ளை கோடு கடக்கக் கூடாது", "வளைவு அபாயத்தை சுட்டிக்காட்ட பயன்படுத்தப்படுகிறது", "வலது பக்கம் திருப்பம் தடைசெய்யப்பட்டுள்ளது", "சாலை பிரிக்க கோடு பயன்படுத்தப்படுகிறது"});
    videoButtonTextsTa.put(1, new String[]{"கோடுகளை கடந்து முன்னேற்றம் அல்லது வலது பக்கம் திருப்பம் தடைசெய்யப்பட்டுள்ளது", "வலது பக்கம் திருப்பம் அனுமதிக்கப்படுகிறது", "முன்னேற்றம் அனுமதிக்கப்படுகிறது", "முன்னேற்றம் மற்றும் வலது பக்கம் திருப்பம் இரண்டும் அனுமதிக்கப்படுகிறது"});
    videoButtonTextsTa.put(2, new String[]{"வாகனத்தை நிறுத்தி பிறகு தொலைபேசிக்கு பதிலளிக்கவும் ", "ஒரு கையால் ஸ்டீயரிங் பிடித்து மற்ற கையால் தொலைபேசியை எடுக்கவும்", "நகர்ப்புற பகுதிகளில் மட்டும் பதிலளிக்க முடியாது", "வாகனம் ஓட்டும் போது தொலைபேசியை கொண்டு செல்லக் கூடாது"});
    videoButtonTextsTa.put(3, new String[]{"முன்னிலையில் குழந்தைகள் கடப்பது", "குழந்தைகள் கடக்க", "பள்ளி முன்", "முன்னிலையில் கண் பார்வை இல்லாதவர்கள் கடப்பது"});
    videoButtonTextsTa.put(4, new String[]{"நடைபாதை கடக்கையில் மட்டுமே பாதசாரிகள் கடக்க முடியும்", "25 மீட்டர் உள்ளே எங்கும் பாதசாரிகள் கடக்க முடியும்", "50 மீட்டர் உள்ளே எங்கும் பாதசாரிகள் கடக்க முடியும்", "30 மீட்டர் உள்ளே எங்கும் பாதசாரிகள் கடக்க முடியும்"});
    videoButtonTextsTa.put(5, new String[]{"நிறுத்து", "முன்னேறு", "முன் மற்றும் பின் வாகனங்கள் நிறுத்து", "பின் வரும் வாகனங்கள் நிறுத்து"});
    videoButtonTextsTa.put(6, new String[]{"வேகம் வரம்பு", "நகர எல்லையின் உள்ளே வேகம் வரம்பு", "குறைந்தபட்ச வேகம்", "சாதாரண வேகம்"});
    videoButtonTextsTa.put(7, new String[]{"முன் மற்றும் பின் வாகனங்கள் நிறுத்து", "முன்னே வரும் வாகனங்கள் நிறுத்து", "நிறுத்து", "பின் வரும் வாகனங்கள் நிறுத்து"});
    videoButtonTextsTa.put(8, new String[]{"தடைச் சின்னம்", "கட்டாயச் சின்னம்", "எச்சரிக்கை சின்னம்", "தகவல் சின்னம்"});
    videoButtonTextsTa.put(9, new String[]{"லாரிகளுக்கு", "மூன்று சக்கர வாகனங்களுக்கு", "மணல் வாகனங்களுக்கு", "மோட்டார் சைக்கிள்களுக்கு"});
    videoButtonTextsTa.put(10, new String[]{"நிறுத்தம் தடைசெய்யப்பட்டது", "சம எண்ணிக் கடினங்களில் நிறுத்தம் தடைசெய்யப்பட்டது", "நிறுத்தம் மற்றும் ஏற்றம் தடைசெய்யப்பட்டது", "அனைத்து வாகனங்களுக்கும் சாலை மூடப்பட்டது"});
    videoButtonTextsTa.put(11, new String[]{"சரியான இயந்திரநிலை மற்றும் தேவையான ஆவணங்கள் இருக்கின்றன", "இயக்குநர் கட்டுப்படுத்தக்கூடிய எந்தவொரு வாகனமும்", "ஸ்டீயரிங், பிரேக் மற்றும் டயர்கள் மட்டும் இருக்கின்றன", "டிரைவர் உரிமம் மற்றும் காப்பீட்டு சான்றிதழ் இருக்கின்றன"});
    videoButtonTextsTa.put(12, new String[]{"ஆபத்தான வளைவில்", "நீதிமன்றத்தின் முன்", "நெடுநேர கடமையிலான சாலையில்", "மருத்துவமனையின் முன்"});
    videoButtonTextsTa.put(13, new String[]{"டயர் இரு பக்கங்களிலும் விரைவாக kulikka", "டயர் நடுவில் விரைவாக kulikka", "டயர் விரைவாக kulikka", "டயர் unevenly kulikka"});
    videoButtonTextsTa.put(14, new String[]{"நெடுஞ்சாலையில் விபத்தில் சிக்கிய வாகனத்தை நிறுத்தும்போது", "ஆபத்தான இடத்தில் வாகனத்தை முன்நோக்கிச் செல்லும்போது", "சந்தியில் நேராக செல்லும்போது", "நோயாளியை எடுத்துச் செல்லும் போது"});
    videoButtonTextsTa.put(15, new String[]{"குறைந்த கியரில் மெதுவாக ஓட்டுதல்", "மேல்நிலைக் கியரில் வேகமாக ஓட்டுதல்", "மேல்நிலைக் கியரில் மெதுவாக ஓட்டுதல்", "வாகன டயர்கள் நல்ல நிலையிலிருந்தால் கவலைப்பட தேவையில்லை"});
    videoButtonTextsTa.put(16, new String[]{"முன்னிலையில் சரிவிலுள்ள சாலை", "முன்னிலையில் வளைந்த சாலை", "முன்னிலையில் குறுகிய சாலை", "முன்னிலையில் ஆபத்தான சந்திப்பு"});
    videoButtonTextsTa.put(17, new String[]{"கியர் மூலம் கட்டுப்படுத்தி, மெதுவாக ஸ்டீயரிங் வைத்துக் கொண்டு skiddirection inக்கு சீர்படுத்தவும்", "பிரேக் இல்லாமல் skiddirectionக்கு ஸ்டீயரிங் திருப்பவும்", "skidஅதிர்ச்சி குறைக்க முடியாது", "வேகத்தை கட்டுப்படுத்த உடனடியாக பிரேக் பயன்படுத்தவும்"});
    videoButtonTextsTa.put(18, new String[]{"வாகனம் செயலிழந்தபோது சாலையில் நிறுத்தியபோது", "முதன்மை பெற", "சந்தியில் நேராக செல்கையில்", "அவசரநிலைக்கு வாகனம் பயணம் செய்கிறது என்பதைக் காட்ட"});
    videoButtonTextsTa.put(19, new String[]{"வாகனத்தின் நிலையைச் சுட்டிக்காட்டி நோயாளியை எடுத்துச் செல்ல முடியும்", "எந்தவொரு காரணத்தாலும் வாகனத்தை நகர்த்த முடியாது", "வாகனம் அசையாமல் இருக்க வேண்டும்", "பிற வாகனங்களுக்கு தடையாக இருக்காமல் சாலையில் இருந்து நகர்த்த முடியும்"});
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
