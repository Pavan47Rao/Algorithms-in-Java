import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode {
    int value;
    char c;
    HuffmanNode leftChild;
    HuffmanNode rightChild;
}

//Comparator to insert the node into queue in increasing order node's value
class MyComparator implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.value - y.value;
    }
}

class HuffmanEncoding{

    int[] frequency = { 5, 9, 12, 13, 16, 45 }; 
    char[] characters_to_encode = { 'a', 'b', 'c', 'd', 'e', 'f' };

    //queue that uses custom comparator
    PriorityQueue<HuffmanNode> q = new PriorityQueue<>(characters_to_encode.length, new MyComparator());

    private void populate_queue() {

        for (int i = 0; i < characters_to_encode.length; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.value = frequency[i];
            hn.c = characters_to_encode[i];
            //Initialize node's left and child to null; assigned children while constructing tree: line 62,63
            hn.leftChild = null;
            hn.rightChild = null;
            //Add node to the queue
            q.add(hn);
        }

    }

    private void print_encoded_values(HuffmanNode root, String value) {

        //iterate until leaf node is reached and print
        while(root.leftChild == null && root.rightChild == null && Character.isLetter(root.c)){
            System.out.println(root.c+" "+value);
            return;
        }

        //For each node from root traverse until leaf is reached; add 0 when you traverse left and 1 when you traverse right
        print_encoded_values(root.leftChild, value+"0");
        print_encoded_values(root.rightChild, value+"1");
    }

    private void construct_tree() {

        HuffmanNode root = null;

        //iterate until queue has atleast 1 node left; 1 because topmost node is fetched everytime
        while(q.size() > 1) {
            //Fetch the first least node and make it left child
            HuffmanNode leftChild = q.peek();
            q.poll();
            //Fetch the next least node and make it right child
            HuffmanNode rightChild = q.peek();
            q.poll();

            HuffmanNode newParent = new HuffmanNode();
            newParent.value = leftChild.value + rightChild.value;
            newParent.c = '-';
            newParent.leftChild = leftChild;
            newParent.rightChild = rightChild;

            root = newParent;
            q.add(newParent);
        }

        print_encoded_values(root, "");

    }

    public static void main(String[] args) {
        HuffmanEncoding hfe = new HuffmanEncoding();
        hfe.populate_queue();
        hfe.construct_tree();
    }
}