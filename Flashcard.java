public class Flashcard {
    private String front, back;

    public Flashcard(String front, String back){ // Constructor
        this.front = front;
        this.back = back;
    }

    public String toString(){
        return this.front + " : " + this.back;
    }

    public String getFront(){
        return this.front;
    }
    
    public String getBack(){
        return this.back;
    }
}
