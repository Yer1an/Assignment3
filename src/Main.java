public class Main {
    public static void main(String[] args) {
        MyHashTable<Group, Student> table = new MyHashTable<>();
        Group group= new Group("MCS");
        Student student = new Student("Yerlan", 16);
        table.put(group,student);
        System.out.println(table.contains(student));
        System.out.println(table.size());
        System.out.println(table.get(group).getName());
        System.out.println(table.getKey(student).getGroupName());
        System.out.println(table.remove(group).getAge());
        System.out.println(table.size());
        //Works well!


        //Binary Search Tree:

        BST<Integer, String> bst = new BST<>();
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(2, "Two");
        bst.put(4, "Four");
        bst.put(6, "Six");
        bst.put(8, "Eight");
        System.out.println(bst.size());

        System.out.println("Keys and values in the BST:");
        for (var node : bst) {
            System.out.println("Key: " + node.getKey() + ", Value: " + node.getValue());
        }

        System.out.println("Value for key 3: " + bst.get(3));
        System.out.println("Value for key 6: " + bst.get(6));

        bst.delete(3);
        System.out.println(bst.size());
        System.out.println("Keys and values in the BST after deleting key 3:");
        for (var node : bst) {
            System.out.println("Key: " + node.getKey() + ", Value: " + node.getValue());
        }
    }
}