package z_others.demo;

import lombok.Getter;
import lombok.Setter;

public class ShallowCopyTest {
    public static void main(String[] args) {
        Person person = new Person();

        person.setAge(180);
        person.setAddress(new Address(180, "xxxxxxx"));

        Person newPerson = new Person();
        newPerson.setAge(person.getAge());
        newPerson.setAddress(person.getAddress());

        System.out.println(newPerson == person);
        System.out.println(newPerson.getAge() == person.getAge());
        System.out.println(newPerson.getAddress() == person.getAddress());
    }

    @Getter
    @Setter
    public static class Person implements Cloneable {
        Integer age;
        String name;
        Address address;

        Person() {

        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Person person = (Person) super.clone();
            person.setAddress((Address) address.clone());
            return person;
        }
    }

    @Getter
    @Setter
    public static class Address implements Cloneable {
        Integer num;
        String addr;

        Address(Integer num, String addr) {
            this.num = num;
            this.addr = addr;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
