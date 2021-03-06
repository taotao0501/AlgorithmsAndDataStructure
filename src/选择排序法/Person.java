package 选择排序法;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person() {};

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person: name = " + name + ", age = " + age;
    }

    @Override
    public int compareTo(Person person) {
        return person.getAge() - this.getAge(); //从大到小
        //return this.getAge() - person.getAge(); //从小到小
    }
}
