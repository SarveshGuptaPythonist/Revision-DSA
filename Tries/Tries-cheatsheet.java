// Question 208
class Trie {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean getEnd(){
            return isEnd;
        }
        
        public void setEnd(){
            isEnd = true;
        }
    }
    
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                return false;
        
            curr = curr.get(ch);
        }
        
        return curr.getEnd();
    }
    public boolean search(String word, int idx, Node curr){
//         words having not char but . in them, Then we can search it with them.
        if(idx == word.length()){
            return curr.getEnd();
        }
        
        char ch = word.charAt(idx);
        
        if(ch != '.'){
            if(curr.contains(ch) == false) return false;
            return search(word, idx + 1, curr.get(ch));
        }
        
        for(char chn = 'a'; chn <= 'z'; chn++){
            if(curr.contains(chn) == false) continue;
            
            if(search(word, idx + 1, curr.get(chn))) 
                return true;
        }
        
        return false;
    }
    
    public boolean startsWith(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                return false;
        
            curr = curr.get(ch);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;

        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }

        public Node get(char ch){
            return children[ch - 'a'];
        }

        public void set(char ch){
            children[ch - 'a'] = new Node();
        }

        public boolean getEnd(){
            return isEnd;
        }

        public void setEnd(){
            isEnd = true;
        }
    }
    String res;
    public void insert(String word, Node root) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false)
                curr.set(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    public String search(String word, Node root) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.getEnd() == true) {
                return word.substring(0, i);
            }
            if(curr.contains(ch) == false)
                return word;

            curr = curr.get(ch);
        }

        return word;
    }
