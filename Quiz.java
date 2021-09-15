import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz{
    private String name; // Name of the Quiz
    private ArrayList<Flashcard> flashcards; // The set of flashcard objects contained in the set.
    private Scanner input = new Scanner(System.in); 

    private static final String BTWN_TERMS = " \\| "; // Delimiter between Flashcards entered in series in one string.
    private static final String BTWN_SIDES = " \\: "; // Delimiter between term and definition on ^above^ mentioned Flashcards.

    public Quiz(){ // 0 parameter constructor
        this.name = "New Quiz";
        this.flashcards = new ArrayList<Flashcard>();
    }

    public Quiz(String name){ // Constructor for only name parameter
        this.name = name;
        this.flashcards = new ArrayList<Flashcard>();
    }

    public Quiz(ArrayList<Flashcard> flashcards){ // Constructor for only flashcards parameter
        this.name = "New Quiz";
        this.flashcards = copy(flashcards);
    }

    public Quiz(String name, ArrayList<Flashcard> flashcards){ // Two parameter constructor
        this.name = name;
        this.flashcards = copy(flashcards);
    }

    public void addFlashcard(Flashcard f) {this.flashcards.add(f);} // Add a Flashcard as an object

    public void addFlashcard(String front, String back) {this.flashcards.add(new Flashcard(front, back));} // Add a Flashcard by defining the parameters of a new Flashdrive object

    public void addFlashcard(Flashcard[] fs){ // Add multiple Flashcards at a time by feeding your quiz an array of Flashcards
        for(Flashcard f : fs)
            this.flashcards.add(f);
    }

    public void addFlashcard(ArrayList<Flashcard> fs){ // Add multiple Flashcards at a time by feeding your quiz an ArrayList of Flashcards
        for(Flashcard f : fs)
            this.flashcards.add(f);
    }

    public void addFlashcard(String s){ // Use the constants at the top of the file to parse through a single-string list of Flashcard Parameters, create Flashcards, and add them to the Quiz
        String[] split = s.split(BTWN_TERMS, 0);
        for(String str : split){
            System.out.println(str);
        }
        String[][] splits = new String[split.length][2];
        for(int i = 0; i < split.length; i++){
            splits[i] = split[i].split(BTWN_SIDES);
        }
        for(String[] strs : splits)
            this.addFlashcard(new Flashcard(strs[0], strs[1]));
    }

    public void setName(String s){this.name = s;} // Set a Quiz's name

    public void removeAllCards(){this.flashcards = new ArrayList<Flashcard>();} // Empty a Quiz of all it's Flashcards

    public void write(){ // Default Write mode, Front is shown, Back is the response
        this.write('f');
    }

    public void write(char s){ // Parameterized Write mode, Choose which side of the card is shown
        if(this.flashcards.size() == 0){
            System.out.println("There are no Flashcards in this Quiz!");
            return;
        }
        ArrayList<Flashcard> fs = copy(this.flashcards);
        Collections.shuffle(fs);

        for(Flashcard f : fs){
            String show, resp;
            if(s == 'b'){
                show = f.getBack();
                resp = f.getFront();
            }else{
                show = f.getFront();
                resp = f.getBack();
            }
            System.out.println(show);
            System.out.print("  Answer: ");
            String answer = input.nextLine();
            if(answer.equals("quit"))
                return;
            while(!answer.equals(resp)){
                System.out.println("Incorrect!\n");
                System.out.println(show);
                System.out.print("  Answer: ");
                answer = input.nextLine();
                    if(answer.equals("quit"))
                return;
            }
            System.out.println("Correct!\n");
        }
        System.out.println("Congrats, you've studied all of this Quiz's Flashcards!\n\n");
    }

    public void test(){ // Default test
        this.test('f');
    }

    public void test(char s){ // Parameterized test; accepts any answer and returns a score at the end
        if(this.flashcards.size() == 0){
            System.out.println("There are no Flashcards in this Quiz!");
            return;
        }
        ArrayList<Flashcard> fs = copy(this.flashcards);
        Collections.shuffle(fs);
        int totalPts = fs.size();
        int pts = 0;

        for(Flashcard f : fs){
            String show, resp;
            if(s == 'b'){
                show = f.getBack();
                resp = f.getFront();
            }else{
                show = f.getFront();
                resp = f.getBack();
            }
            System.out.println(show);
            System.out.print("  Answer: ");
            String answer = input.nextLine();
            if(answer.equals("quit"))
                return;
            if(answer.equals(resp))
                pts++;
        }
        System.out.println("Finished! Score: " + (int)(pts * 100 / totalPts) + "%\n\n");
    }

    public static ArrayList<Flashcard> copy(ArrayList<Flashcard> other){ // Returns an exact copy of a Flashcard arraylist
        ArrayList<Flashcard> output = new ArrayList<Flashcard>();
        for(Flashcard x : other)
            output.add(x);
        return output;
    }

    public String toString(){
        String output = this.name;
        if(this.flashcards.size() == 0){
            output += "\nThere are no Flashcards in this Quiz.";
            return output;
        }
        for(Flashcard x : this.flashcards)
            output += "\n  - " + x.toString();
        return output;
    }

    public static void main(String[] args){
        Quiz german = new Quiz();
        german.setName("German");

        german.addFlashcard("das Verhalten : behavior | " + 
        "das Gras : grass | " + 
        "angenehm : pleasant | " + 
        "wischen : to wipe; to mop | " + 
        "das Altenheim : nursing home | " + 
        "begegnen : to meet | " + 
        "die Bewegung : movement | " + 
        "ungefähr : approximately | " + 
        "der Patient : patient | " + 
        "einnehmen : to take in | " + 
        "unheimlich : scary, eerie | " + 
        "erleichtern : to facilitate | " + 
        "der Kranke : sick person | " + 
        "isoliert : isolated | " + 
        "zu Hause : at home | " + 
        "die Beschäftigung : occupation | " + 
        "die Industrie : industry | " + 
        "die Produktion : production | " + 
        "der Betrieb : business, company | " + 
        "menschlich : humane | " + 
        "der Arbeiter : worker | " + 
        "der Angestellte : employee | " + 
        "verschwinden : to disappear | " + 
        "der Arbeitsplatz : workplace | " + 
        "der Abschnitt : section | " + 
        "die Einleitung : introduction | " + 
        "springen : to jump | " + 
        "lösen : to solve | " + 
        "der Badeanzug : bathing suit | " + 
        "die Badehose : swimming trunks | " + 
        "alternativ : alternative | " + 
        "verbrauchen : to consume | " + 
        "wegen : because of | " + 
        "zahlreich : numerous | " + 
        "nachdenken über : to reflect about | " + 
        "handeln : to deal, trade | " + 
        "das Klima : climate | " + 
        "der Klimawandel : climate change | " + 
        "verschwenden : to waste | " + 
        "die Luft : air, breeze | " + 
        "der Kunststoff : synthetic material | " + 
        "das Insekt : insect | " + 
        "öffentlich : public | " + 
        "kostenlos : free of charge | " + 
        "der Umweltschutz : environmental protection | " + 
        "der Vortrag : lecture | " + 
        "der Zuhörer : audience | " + 
        "verständlich : comprehensible | " + 
        "die Präsentation : presentation | " + 
        "die Folie : slide | " + 
        "der Inhalt : content | " + 
        "die Struktur : structure | " + 
        "das Erlebnis : experience | " + 
        "der Zusammenhang : connection, context | " + 
        "der Abschluss : degree | " + 
        "die Aufmerksamkeit : attention | " + 
        "die Kommunikation : communication | " + 
        "die Temperatur : temperature | " + 
        "die Wissenschaft : science | " + 
        "die Musikanlage : stereo | " + 
        "die Klimaanlage : air conditioning | " + 
        "der Staub : dust | " + 
        "kommunizieren : to communicate | " + 
        "passend : suitable | " + 
        "die Technologie : technology | " + 
        "die Jugend : youth | " + 
        "forschen : to research; to investigate | " + 
        "anschließen : to plug in | " + 
        "erfinden : to invent | " + 
        "die Erfindung : invention | " + 
        "jederzeit : at any time | " + 
        "der Alarm : alarm | " + 
        "entwickeln : to develop | " + 
        "warnen vor : to warn about | " + 
        "der Unternehmer : entrepreneur, employer | " + 
        "die Bremse : brake (car) | " + 
        "der Strom : electricity, power | " + 
        "das Teil : part | " + 
        "der Wahnsinn : madness | " + 
        "die Datei : file | " + 
        "zeichnen : to draw | " + 
        "die Abgase : exhaust fumes | " + 
        "die Bedeutung : meaning | " + 
        "das Benzin : gasoline, fuel | " + 
        "das E-Bike : electric bike | " + 
        "elektrisch : electric | " + 
        "die Energie : energy, power | " + 
        "die Ladestation : charging station | " + 
        "die Steckdose : electrical outlet | " + 
        "tanken : to fill up | " + 
        "die Tankstelle : gas station | " + 
        "umweltfreundlich : environmentally friendly | " + 
        "sondern : but rather | " + 
        "die Elektromobilität : electromobility | " + 
        "die Meldung : announcement | " + 
        "die Medizin : medicine | " + 
        "das Gehirn : brain | " + 
        "ersetzen : to replace | " + 
        "die Entdeckung : discovery | " + 
        "die Pflanze : plant | " + 
        "der Mond : moon | " + 
        "mieten : to rent | " + 
        "wundern : to wonder about | " + 
        "einsetzen : to insert | " + 
        "die Forschung : research | " + 
        "die Wirklichkeit : reality | " + 
        "selbständig : independent | " + 
        "benötigen : to need | " + 
        "allerdings : certainly, indeed | ");
        System.out.println(german);
    }
}