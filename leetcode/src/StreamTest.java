import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        Person p1 = new Person("a a", 11, "aaaaa");
        Person p2 = new Person("b b", 12, "bbbbb");
        Person p3 = new Person("c c", 13, "ccccc");
        Person p4 = new Person("d d", 14, "ddddd");
        Person p5 = new Person("e e", 15, "eeeee");

        list = Arrays.asList(p1,p2,p3,p4,p5);

        //filterTest(list);
        //reduceTest(list);
        //collectTest(list);
        //mapTest(list);
        flatMapTest(list);
    }

    // filter age > 13 & name = d
    private static void filterTest(List<Person> list) {
        List<Person> collect = list.stream().filter(p->(p.getAge() > 13 || "d".equalsIgnoreCase(p.getName())))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void mapTest(List<Person> list) {
        List<String> collect = list.stream().map(p->(p.getName() + " " + p.getAge() + " " + p.getProvince()))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void flatMapTest(List<Person> list) {
        List<String> collect = list.stream().flatMap(p->Arrays.stream(p.getName().split(" ")))
                .collect(Collectors.toList());
        System.out.println(collect);
        List<Stream<String>> collect2 = list.stream().map(p->Arrays.stream(p.getName().split(" ")))
                .collect(Collectors.toList());
        System.out.println(collect2);
    }

    private static void reduceTest(List<Person> list) {
        Integer reduce = Stream.of(1,2,3,4,5)
                .reduce(10, (count,item)->{
                            System.out.println("count :" + count);
                            System.out.println("item :" + item);
                            return count + item;
                        });
        System.out.println(reduce);

        Integer reduce2 = Stream.of(1,2,3,4,5)
                .reduce(0,(x,y)->x+y);
        System.out.println(reduce2);
        String str = list.stream().map(p->p.getName()).
                reduce("",(p1,p2)->(p1+ " " + p2));
        System.out.println(str);

    }

    private static void collectTest(List<Person> list) {

        Map<String,Integer> collect = list.stream()
                .collect(Collectors.toMap(p->p.getName(),p->p.getAge()));
        System.out.println(collect);
    }
}

class Person {

    private String name;
    private int age;
    private String province;

    public Person(String name, int age, String province) {
        this.name = name;
        this.age = age;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", province='" + province + '\'' +
                '}';
    }
}
