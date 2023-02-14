public class App {
    public static void main(String[] args) throws Exception {
        Grammar gr = new Grammar();
        FiniteAutomata FA = new FiniteAutomata(gr.getAlphbet(), gr.getPossibleStates(), gr.convetToFiniteAutomaton());
        System.out.println("Grammar:");
        System.out.println();
        gr.setGrammar();
        gr.getGrammar();
        gr.generateString();

        //generating strings
        System.out.println();
        System.out.println("5 generated strings:");
        System.out.println();
        for (int i = 0; i<5; i++){
            gr.generateString();
            System.out.print("Word: ");
            gr.printWord();
            System.out.println();
            //validation of strings
            boolean IsValid = FA.validationString(gr.getWord());
            System.out.println("IsValid: "+IsValid);
            System.out.println();
        }
        //Finite Automaton
        System.out.println("Finite Automaton: ");
        System.out.println();
        FA.getFiniteAutomata();
    }
}
