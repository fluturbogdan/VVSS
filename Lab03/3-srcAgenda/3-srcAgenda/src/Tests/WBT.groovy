package Tests

import model.base.Contact
import repository.classes.RepositoryContactFile

/**
 * Created by Bogdan on 08.05.2017.
 */
class WBT extends GroovyTestCase {
    void testWB1() {
        RepositoryContactFile repc=new RepositoryContactFile()
        if(repc.saveContracts("bin\\files\\contacts.txt")) {
            repc.clear()
            repc.addContact(new Contact("nume1","adresa1","0712312312","email1@email.com"))
            repc.getContacts()
            if (repc.count()!=1) assert false
            repc.removeContact(new Contact("nume1","adresa1","0712312312","email1@email.com"))
            if(repc.count()>0) assert false
            assert true
        }
        else
            assert false
    }

    void testWB2() {
        RepositoryContactFile repc=new RepositoryContactFile()
        if(!repc.saveContracts("bin\\asd\\contacts.txt"))
            assert true
        else
            assert false
    }
}
