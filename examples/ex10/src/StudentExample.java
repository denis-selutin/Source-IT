import java.util.*;

/**
 * Created by denis.selutin on 6/5/2015.
 * ???????????? ?????? ???????? ???? ??????? ?? ?????????? ??????:
 ???????, ???, ??? ????????, ???????? ??????, ????? ?????????? ????????
 ??????????? ?????????, ? ??????? :
 1) ????????? ?????? ??????????? ?? ??????? ????? ? ????????
 2) ????? ???????? ?? ??????? (??????? ? ?????? ??????)
 3) ????? ???????? ?? ????? ??????????? ??????
 */
public class StudentExample {

    private static final Comparator<Student> BY_FIRST_NAME = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.getFirstName().equalsIgnoreCase(o2.getFirstName())) {
                System.out.println(o1.toString() + o2.toString());
                return 0;
            } else if(o1.getFirstName().indexOf(o2.getFirstName()) == 0  ||
                    o2.getFirstName().indexOf(o1.getFirstName()) == 0) {
                System.out.println(o1.toString() + o2.toString());
                return 0;
            } else {
                return o1.compareTo(o2);
            }
        }
    };

    private static final Comparator<Student> BY_PHONE_NUMBER = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.getPhoneNumber().contains(o2.getPhoneNumber())) {
                return 0;
            } else {
                return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
            }
        }
    };

    public static void main(String[] args) {
        //??????? ????????? ??? ??????
        List<Student> myElements = new ArrayList<>();
        myElements.add(new Student("fname1", "lname1", "mname1", "g1", "48445485"));
        myElements.add(new Student("fname1", "lname2", "mname1", "g1", "8945154465646"));
        myElements.add(new Student("fname1", "lname1", "mname2", "g1", "51464463148"));
        myElements.add(new Student("fname2", "lname2", "mname2", "g2", "5446654461"));
        myElements.add(new Student("fname3", "lname3", "mname3", "g3", "5464513164"));
        myElements.add(new Student("fname1", "lname2", "mname2", "g1", "91191155152154"));
        myElements.add(new Student("fname1", "lname2", "mname3", "g1", "9154451444"));
        myElements.add(new Student("fname1", "lname3", "mname1", "g1", "55444515445"));
        myElements.add(new Student("asdsad", "lname45", "mname6", "g2", "9123451644"));
        System.out.println(myElements);

        //????????? ???????? ?????? ?? ????????? ?????????? ? ????? ??????
        Collections.sort(myElements);
        System.out.println(myElements);

        //???? ?? ???????
        int index = Collections.binarySearch(myElements, new Student("asd", "", "", "", "") ,BY_FIRST_NAME);
        System.out.println(index);
        System.out.println(myElements.get(index));

        //????????? ????????? ?? ?????????
        Collections.sort(myElements, BY_PHONE_NUMBER);
        System.out.println(myElements);
        index = Collections.binarySearch(myElements, new Student("", "", "", "", "44451") ,BY_PHONE_NUMBER);
        //??? ????????????? ????????? ?????? ????????? ?????? ???? ?????????????
        System.out.println(index);
        System.out.println(myElements.get(index));

        //?????? ?? ???????
        Student serach = myElements.stream()
                .filter(student -> student.getPhoneNumber().contains("44451"))
                .findFirst().get();
        System.out.println(serach);
    }

    public static class Person {
        private String firstName;
        private String lastName;
        private String middleName;

        public Person(String firstName, String lastName, String middleName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String toString() {
            return this.firstName + " " + this.lastName + " " + this.middleName;
        }
    }

    public static class Student extends Person implements Comparable<Student>{
        private String group;
        private String phoneNumber;

        public Student(String firstName, String lastName, String middleName, String group, String phoneNumber) {
            super(firstName, lastName, middleName);
            this.group = group;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public int compareTo(Student o) {
            String name = getFirstName() + getLastName() + getMiddleName();
            String targetName = o.getFirstName() + o.getLastName() + o.getMiddleName();
            return name.toLowerCase().compareTo(targetName.toLowerCase());
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String toString() {
            return super.toString() + " " + this.group + " " + this.phoneNumber;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}
