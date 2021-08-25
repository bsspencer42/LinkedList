public class Test {
        public static void main(String[] args) {
            LinkedList<String> x = new LinkedList<>();
            x.addAtIndex("0",0);
            x.addAtIndex("2",1);
            x.addAtIndex("2",2);
            x.addAtIndex("3",3);
            x.addAtIndex("3",4);
            x.addAtIndex("4",5);

            Node<String> currentNode = x.getHead();
            int index = 0;
            String myData = "";
            while (currentNode != null){
                myData += currentNode.getData() + " -->  ";
                currentNode = currentNode.getNext();
                index += 1;
            }
            System.out.println(myData);

            // Recursive remove duplicates
            System.out.println("Duplicates removed.");
            x.removeDups();

            currentNode = x.getHead();
            index = 0;
            myData = "";
            while (currentNode != null){
                myData += currentNode.getData() + " -->  ";
                currentNode = currentNode.getNext();
                index += 1;
            }
            System.out.println(myData);
        }
    }
