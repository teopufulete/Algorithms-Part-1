import java.util.HashMap;
import java.util.Map; 

public class WordNet {
   
   private Map<Integer, String> id2SynsetDefinition; // for quick search ancestor
	// for quick search noun in WordNet. Use bag for values, as there can be more then 1 id correspond to the word. Key - noun
	private Map<String, Bag<Integer>> synset2id;
	private SAP sap;

	
   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms) {
	   id2SynsetDefinition = new HashMap<Integer, String>();
	   synset2id = new HashMap<String, Bag<Integer>>();
	   createMaps(synsets);
	   createSAP(hypernyms);
   }


   // returns all WordNet nouns
   public Iterable<String> nouns() {
	   return synset2id.keySet();
   }


   // is the word a WordNet noun?
   public boolean isNoun(String word) {
	   return synset2id.containsKey(word)
   }


   // distance between nounA and nounB 
   public int distance(String nounA, String nounB) {
	   if (!isNoun(nounA) || !isNoun(nounB)) throw new java.lang.IllegalArgumentException("No such nouns in WordNet!");
	   return sap.length(synset2id.get(nounA), synset2id.get(nounB));
   }


   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB in a shortest ancestral path 
   public String sap(String nounA, String nounB) {
	   if (!isNoun(nounA) || !isNoun(nounB)) throw new java.lang.IllegalArgumentException("No such nouns in WordNet!");
	   int ancestorId = sap.ancestor(synset2id.get(nounA), synset2id.get(nounB));
	   String valueFields[] = id2SynsetDefinition.get(ancestorId).split(",");
	   return valueFields[0];
   }   
      
	   
   private void createMaps(String synsets) {
	   In in = new In(synsets);
	   while (in.hasNextLine()) {
		   String curString = in.readLine();
		   String[] fields = curString.split(",");
		   for (int i = 0; i < fields.length; i++) {
			   fields[i] = fields[i].trim();
		   }
		   
		   int id = Integer.parseInt(fields[0]);
		   String synsetDefinition = fields[1] + "," + fields[2];
		   id2SynsetDefinition.put(id, synsetDefinition);
	   
      
      
   private void createSAP(String hypernyms)
      

   // do unit testing of this class
   public static void main(String[] args)
}
