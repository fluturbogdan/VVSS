package Tests

import repository.classes.RepositoryContactFile

/**
 * Created by Bogdan on 08.05.2017.
 */
class WBT extends GroovyTestCase {
    void testWB1() {
        RepositoryContactFile repc=new RepositoryContactFile();
        if(repc.saveContracts("bin\\files\\contacts.txt")==true)
            assert true;
        else
            assert false;
    }

    void testWB2() {
        RepositoryContactFile repc=new RepositoryContactFile();
        if(repc.saveContracts("bin\\asd\\contacts.txt")==false)
            assert true;
        else
            assert false;
    }
}
