import com.bridgelabz.addressbookproblem.model.Person;
import com.bridgelabz.addressbookproblem.service.PersonServicesInf;
import com.bridgelabz.addressbookproblem.service.PersonaServiceImp;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    @Test
    public void givenPersonDetail_WhenProper_ShouldReturnTrue() throws IOException {
        Person person = new Person("horro", "B", "", "Nanded", "chhattsigarh", 496683L, 9534543534L);
        PersonServicesInf personServicesInf = new PersonaServiceImp();
        boolean result=personServicesInf.addPerson(person);
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPersonDetail_WhenProper_ShouldReturnFalse() throws IOException {
        Person person = new Person("Upendra", "Sahu", "malad", "korba", "chhattsigarh", 496683L, 9874563210L);
        PersonServicesInf personServicesInf = new PersonaServiceImp();
        boolean result=personServicesInf.addPerson(person);
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPersonDetail_WhenProperEditing_ShouldReturnTrue() throws IOException {
        Person person = new Person("ajju", "df", "malad", "korba1", "chhattsigarh", 496683L, 9874563210L);
        PersonServicesInf personServicesInf = new PersonaServiceImp();
        boolean result=personServicesInf.editInfo(person,person.getFirstName());
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPersonDetail_WhenProperDelete_ShouldReturnTrue() throws IOException {
        PersonServicesInf personServicesInf = new PersonaServiceImp();
        boolean result=personServicesInf.deletePerson("Anshu");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPersonDetail_WhenProperSortByName_ShouldReturnTrue() throws IOException {
        PersonServicesInf personServicesInf = new PersonaServiceImp();
        boolean result=personServicesInf.sortByName();
        Assert.assertEquals(true, result);

    }
}
