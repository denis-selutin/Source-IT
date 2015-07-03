package additional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.StringReader;
import java.util.List;

/**
 * Created by denis.selutin on 6/22/2015.
 */
public class JaxbExample {

    public static void main(String[] args) throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Company company = (Company) unmarshaller.unmarshal(new File("examples\\ex11\\src\\standard\\standard.xml"));
        System.out.println(company.getStaffs());
    }

    @XmlRootElement(namespace = "htts://mycustompage.html")
    private static class Company {
        private List<Staff> staffs;

        public List<Staff> getStaffs() {
            return staffs;
        }

        @XmlElement(name = "staff")
        public void setStaffs(List<Staff> staffs) {
            this.staffs = staffs;
        }
    }

    @XmlRootElement(namespace = "htts://mycustompage.html")
    public static class Staff {
        private String id;
        private String lastName;
        private String nick;
        private Integer salary;
        private String firstName;

        public String getId() {
            return id;
        }

        @XmlAttribute(name = "id")
        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        @XmlElement(name = "firstname")
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @XmlElement(name = "lastname")
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getNick() {
            return nick;
        }

        @XmlElement(name = "nickname")
        public void setNick(String nick) {
            this.nick = nick;
        }

        public Integer getSalary() {
            return salary;
        }

        @XmlElement(name = "salary")
        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public String toString() {
            return "{" + id + ", " + firstName + ", " + lastName + ", " + nick + ", " + salary + "}";
        }
    }
}
