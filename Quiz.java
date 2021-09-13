import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz{
    private String name; // Name of the Quiz
    private ArrayList<Flashcard> flashcards; // The set of flashcard objects contained in the set.
    private Scanner input = new Scanner(System.in);

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

    public void setName(String s){this.name = s;} // Set a Quiz's name

    public void removeAllCards(){this.flashcards = new ArrayList<Flashcard>();} // Empty a Quiz of all it's Flashcards

    public void write(){ // Default Write mode, Front is shown, Back is the response.
        Collections.shuffle(this.flashcards);
        for(Flashcard f : this.flashcards){
            System.out.println(f.getFront());
            System.out.print("  Answer: ");
            String answer = input.nextLine();
            while(!answer.equals(f.getBack())){
                System.out.println("Incorrect!\n");
                System.out.println(f.getFront());
                System.out.print("  Answer: ");
                answer = input.nextLine();
            }
            System.out.println("Correct!\n");
        }
        System.out.println("Congrats, you've studied all of this Quiz's Flashcards!");
    }

    public void write(char s){ // Parameterized Write mode, Choose which side of the card is shown.
        
        Collections.shuffle(this.flashcards);
        for(Flashcard f : this.flashcards){
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
            while(!answer.equals(resp)){
                System.out.println("Incorrect!\n");
                System.out.println(show);
                System.out.print("  Answer: ");
                answer = input.nextLine();
            }
            System.out.println("Correct!\n");
        }
        System.out.println("Congrats, you've studied all of this Quiz's Flashcards!");
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
        System.out.println(german);

        german.addFlashcard("gehen", "to go");
        System.out.println(german);

        german.addFlashcard("der Apfel", "apple");
        System.out.println(german);

        german.addFlashcard("das Gehirn", "brain");
        System.out.println(german);

        german.addFlashcard("die Bedeutung", "meaning");
        System.out.println(german);
        
        german.write();

        german.write('b');

        german.write('f');
    }
}