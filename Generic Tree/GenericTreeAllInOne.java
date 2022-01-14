// 12
// 10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
//       10
//    /  \    \ 
//   20   30   40
//       /   \
//      50   60
public class Main {
  // Main node
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
  // Display 
  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }
  // 10 -> 20, 30, 40, .
  // 20 -> .
  // 30 -> 50, 60, .
  // 50 -> .
  // 60 -> .
  // 40 -> .
  
  public static int size(Node node){
    // write your code here
    // if(node.children.size() == 0) return 1;
    if(node == null) return 0;
    
    int count = 1; // count is 1 so its counting itself
    for(Node child: node.children){
        count += size(child);// if thier is atleast 1 child it will return total children including itself;
        
    } 
    return count;
  }
  // 6
  
  public static int max(Node node) {
    // write your code here
    if(node == null) return Integer.MIN_VALUE;
    int maxNum = node.data;
    for(Node child: node.children) {
        maxNum = Math.max(maxNum, max(child));
    }
    return maxNum;
  }
  // 60
  
  public static int height(Node node) {
    // write your code here
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;
    return h;
  }
  // 2
  
  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);
    for(Node child: node.children){
        System.out.println("Edge Pre " + node.data + "--" + child.data); 
        traversals(child);
        System.out.println("Edge Post " + node.data + "--" + child.data);
    }
    System.out.println("Node Post " + node.data);
  }
  
  // level order traversl
  public static void levelOrder(Node node){
    // write your code here
    // USes Queue
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(node);
    while(queue.size() > 0){
        Node val = queue.remove();
        System.out.print(val.data + " ");
        
        for(Node child: val.children){
            queue.add(child);
        }
    }
    System.out.print(".");
    
  }
  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    if(node.data == data){
        ArrayList<Integer> val = new ArrayList<>();
        val.add(data);
        return val;
    }
    for(Node child: node.children){
        ArrayList<Integer> Final = nodeToRootPath(child, data);
        if(Final.size() > 0){
            Final.add(node.data);
            return Final;
        }
    }
    ArrayList<Integer> Final = new ArrayList<>();
    return Final;
  }
  public static int lca(Node node, int d1, int d2) {
    // write your code here
    ArrayList<Integer> first = nodeToRootPath(node, d1);
    ArrayList<Integer> second = nodeToRootPath(node, d2);
    int check = -1;
    Collections.reverse(first);
    Collections.reverse(second);
    int idx= 0;
    // System.out.println(first);
    // System.out.println(second);
    while(first.size()  > idx && second.size() > idx){
        if(first.get(idx) == second.get(idx)){
            check = first.get(idx);
        }
        else{
            break;
        }
        idx++;
    }
    return check;
    
  }
  public static int distanceBetweenNodes(Node node, int d1, int d2){
    ArrayList<Integer> p1 = nodeToRootPath(node, d1);
    ArrayList<Integer> p2 = nodeToRootPath(node, d2);
    // write your code here
    int p1idx = p1.size()-1;
    int p2idx = p2.size()-1;
    while((p1idx > -1) && (p2idx > -1) && (p1.get(p1idx) == p2.get(p2idx))){
        p1idx--;p2idx--;
    }
    return p1idx + p2idx + 2;// +2 is done becuase index is 0 based but answer should e 1 based
  }
  
  // chceck if given tree is similar
  public static boolean areSimilar(Node n1, Node n2) {
    // write your code here
    if(n1.children.size() != n2.children.size()){return false;}
    boolean check = true;
    for(int i = 0; i < n1.children.size(); i++){
        
        Node child1 = n1.children.get(i);
        Node child2 = n2.children.get(i);
        check = areSimilar(child1, child2);
    }
    return check;
  }
  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    // Write your code here
    if(node.data > data){
      if(node.data < ceil){
        ceil = node.data;
      }
    }

    if(node.data < data){
      if(node.data > floor){
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor(child, data);
    }
  }
  

}
