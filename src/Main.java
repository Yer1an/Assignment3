import com.sun.security.jgss.GSSUtil;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
    }
}