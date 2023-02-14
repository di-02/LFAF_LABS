import java.util.*;

public class FiniteAutomata {
    private Set<String> Alphabet = new HashSet<>();
    private Set<String> PossibleStates = new HashSet<>();
    private HashMap<String, String> Delta = new HashMap<>();
    private String InitialState;
    private String FinalState;
    private boolean valid;

    public FiniteAutomata(Set<String> NewAlphabet, Set<String> SetPossibleStates, HashMap<String, String> Transitions){
        Alphabet = NewAlphabet;
        PossibleStates = SetPossibleStates;
        PossibleStates.add("X");
        Delta = Transitions;
        InitialState = "S";
        FinalState = "X";
    }

    public void getFiniteAutomata(){
        System.out.println("Finite set of states: "+PossibleStates);
        System.out.println("Alphabet: "+Alphabet);
        System.out.println("Initial state: "+InitialState);
        System.out.println("Final state: "+FinalState);
        System.out.println("Transition function: "+Delta);
    }
    //method to check if the string is valid
    public boolean validationString(String NewWord){
        String word = NewWord;
        String preff = "(S,";
        for (int i = 0; i< word.length();i++){
            preff+=word.substring(i,i+1)+")";
            if (Delta.containsKey(preff)){
                preff = "("+Delta.get(preff)+",";
                valid = true;
            }
            else {
                return valid = false;
            }
        }
        return valid;
    }


}
