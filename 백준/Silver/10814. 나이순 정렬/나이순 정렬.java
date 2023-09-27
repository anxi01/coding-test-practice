import java.util.*;

class Person{
    public int age;
    public String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) {

        /**
         * 객체 사용과 객체 정렬(Comparator)
         */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            String y = sc.next();

            list.add(new Person(x,y));
        }
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });
        for(Person p : list){
            System.out.println(p.age + " " + p.name);
        }
    }
}