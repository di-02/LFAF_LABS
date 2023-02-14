import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.HashMap;

public class Grammar {
    
    private Set<String> Vt = new HashSet<>();//the set of terminal symbols
    private Set<String> Vn = new HashSet<>();//the set of nonterminal symbols
    private Set<String> P = new HashSet<>();//the set of productions
    private String word;
    //create arrays for productions
    private String SProductions[] = new String[] {"bS", "aF", "d"};
    private String FProductions[] = new String[] {"cF", "dF", "aL", "b"};
    private String LProductions[] = new String[] {"aL", "c"};

    public void setGrammar(){
        Vt.add("a");
        Vt.add("b");
        Vt.add("c");
        Vt.add("d");

        Vn.add("S");
        Vn.add("F");
        Vn.add("L");

        P.add("S -> bS");
        P.add("S -> aF");
        P.add("S -> d");
        P.add("F -> cF");
        P.add("F -> dF");
        P.add("F -> aL");
        P.add("L -> aL");
        P.add("L -> c");
        P.add("F -> b");
    }

    public void getGrammar(){

        System.out.println("The set of terminal symbols Vt = "+Vt);
        System.out.println("The set of nonterminal symbols Vn = "+Vn);
        System.out.println("The set of productions P = "+P);
    }

    public void generateString(){

        Random rand = new Random();
        word = "S";
        //using array created before we can generate a string by replacing nonterminal symbols by their productions
        while (true){
            switch (word.substring(word.length()-1)){
                case "S":
                    word = word.replace(word.substring(word.length()-1), SProductions[rand.nextInt(3)]);
                    break;
                case "F":
                    word = word.replace(word.substring(word.length()-1), FProductions[rand.nextInt(4)]);
                    break;
                case "L":
                    word = word.replace(word.substring(word.length()-1), LProductions[rand.nextInt(2)]);
                    break;
            }
            //since we have only left-side productions we check if out last symbol in the string is terminal
            boolean cont = Vt.contains(word.substring(word.length()-1));

            if (cont){
                break;
            }
        }
    }

    public void printWord(){
        System.out.print(word);
    }

    public String getWord(){
        return word;
    }
    //return alphabet to FiniteAutomaton
    public Set<String> getAlphbet(){
        return Vt;
    }
    //return set of states for FA
    public Set<String> getPossibleStates(){
        return Vn;
    }
    //convert productions to HashMap for analitical representation of FA
    public HashMap<String, String> convetToFiniteAutomaton(){
        HashMap<String, String> transitions = new HashMap<>();
        for (int i = 0; i< SProductions.length; i++){
            if (SProductions[i].length()>1){
                transitions.put("(S,"+SProductions[i].substring(0,1)+")",SProductions[i].substring(SProductions[i].length()-1));
            }
            else {
                transitions.put("(S,"+SProductions[i]+")","X");
            }
        }

        for (int i=0;i<FProductions.length;i++){
            if (FProductions[i].length()>1){
                transitions.put("(F,"+FProductions[i].substring(0,1)+")",FProductions[i].substring(FProductions[i].length()-1));
            }
            else {
                transitions.put("(F,"+FProductions[i]+")","X");
            }
        }

        for (int i = 0;i<LProductions.length;i++){
            if (LProductions[i].length()>1){
                transitions.put("(L,"+LProductions[i].substring(0,1)+")",LProductions[i].substring(LProductions[i].length()-1));
            }
            else {
                transitions.put("(L,"+LProductions[i]+")","X");
            }
        }

       return transitions;
    }
}
