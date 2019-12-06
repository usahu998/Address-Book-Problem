import com.bridgelabz.addressbookproblem.model.Person;
import com.bridgelabz.addressbookproblem.service.PersonServicesInf;
import com.bridgelabz.addressbookproblem.service.PersonaServiceImp;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    @Test
    public void givenPersonDetail_WhenProper_ShouldReturnTrue() throws IOException {
        Person person = new Person("Upendra", "Sahu", "malad", "korba", "chhattsigarh", 496683L, 9874563210L);
        PersonServicesInf personServicesInf = new PersonaServiceImp();
        personServicesInf.addPerson(person);
        Assert.assertEquals(person.getFirstName(), personServicesInf.addPerson(person).getFirstName());
    }

    @Test
    public void givenPersonDetail_WhenProper_ShouldReturnFalse() throws IOException {
        Person person = new Person("Upendra", "Sahu", "malad", "korba", "chhattsigarh", 496683L, 9874563210L);
        PersonServicesInf personServicesInf = new PersonaServiceImp();
        personServicesInf.addPerson(person);
        Assert.assertNotEquals(person.getCity(), personServicesInf.addPerson(person).getFirstName());
    }

    @Test
    public void givenPersonDetail_WhenProperEditing_ShouldReturnTrue() throws IOException {
        Person person = new Person("Upendra2", "Sahufdh", "malad1fh", "korba1", "chhattsigarh", 496683L, 9874563210L);
        PersonServicesInf personServicesInf = new PersonaServiceImp();
        personServicesInf.editInfo(person);
        Assert.assertEquals(person.getFirstName(), personServicesInf.addPerson(person).getFirstName());
    }
}
