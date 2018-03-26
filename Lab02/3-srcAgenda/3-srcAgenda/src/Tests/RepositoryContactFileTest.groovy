package Tests

import exceptions.InvalidFormatException
import model.base.Contact
import repository.classes.RepositoryContactFile

/**
 * Created by Bogdan on 23.04.2017.
 */
class RepositoryContactFileTest extends GroovyTestCase {
    void testTCEP1() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("nume1","adresa1","0712312312","email1@email.com"))
            repc.addContact(new Contact("nume2","adresa2","0712312313","email2@email.com"))

            if(repc.count()!=2) assert false
        }
        catch (InvalidFormatException ignored){

        }
    }

    void testTCEP2() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("123.23","12412","asdasdasd","asd@asd@asd.asd"))
        }
        catch (InvalidFormatException ignored){
            if(repc.count()!=0) assert false
        }
    }

    void testTCEP3() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("","asd","09876543456","asd@asd@asd.asd"))
        }
        catch (InvalidFormatException ignored){
            if(repc.count()!=0) assert false
        }
    }

    void testTCEP4() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("nume2","adresa2","",""))
        }
        catch (InvalidFormatException ignored){
            if(repc.count()!=0) assert false
        }
    }

    void testTCBVA3() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("M","ceva adresa","0123123123","ceva@ceva.ceva"))
            if(repc.count()!=1) assert false
        }
        catch (InvalidFormatException ignored){
        }
    }

//    void testTCBVA4() {
//        RepositoryContactFile repc=new RepositoryContactFile();
//        repc.clear();
//        try{
//            String nume;
//            for (int i=1;i<=Math.pow(2,31) - 1;i++)
//                nume=nume+"a";
//            repc.addContact(new Contact(nume,"ceva adresa","0123123123","ceva@ceva.ceva"));
//            if(repc.count()!=1) assert false;
//        }
//        catch (InvalidFormatException e){
//        }
//    }


//    void testTCBVA5() {
//        RepositoryContactFile repc=new RepositoryContactFile();
//        repc.clear();
//        try{
//            String nume;
//            for (int i=1;i<=Math.pow(2,31) - 2;i++)
//                nume=nume+"a";
//            repc.addContact(new Contact(nume,"ceva adresa","0123123123","ceva@ceva.ceva"));
//            if(repc.count()!=1) assert false;
//        }
//        catch (InvalidFormatException e){
//        }
//    }

//   void testTCBVA6() {
//        RepositoryContactFile repc=new RepositoryContactFile();
//        repc.clear();
//        try{
//            String nume;
//            for (int i=1;i<=Math.pow(2,31);i++)
//                nume=nume+"a";
//            repc.addContact(new Contact(nume,"ceva adresa","0123123123","ceva@ceva.ceva"));
//            if(repc.count()!=1) assert false;
//        }
//        catch (InvalidFormatException e){
//        }
//    }

    void testTCBVA7() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("Nume","","0123123123","ceva@ceva.ceva"))
        }
        catch (InvalidFormatException ignored){
            if(repc.count()!=0) assert false

        }
    }

    void testTCBVA9() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("Nume","D","0123123123","ceva@ceva.ceva"))
            if(repc.count()!=1) assert false

        }
        catch (InvalidFormatException ignored){

        }
    }

//    void testTCBVA10() {
//        RepositoryContactFile repc=new RepositoryContactFile();
//        repc.clear();
//        try{
//            String adresa;
//            for (int i=1;i<=Math.pow(2,31) - 1;i++)
//                adresa=adresa+"a";
//            repc.addContact(new Contact("Nume",adresa,"0123123123","ceva@ceva.ceva"));
//            if(repc.count()!=1) assert false;
//        }
//        catch (InvalidFormatException e){
//        }
//    }


//    void testTCBVA11() {
//        RepositoryContactFile repc=new RepositoryContactFile();
//        repc.clear();
//        try{
//            String adresa;
//            for (int i=1;i<=Math.pow(2,31) - 2;i++)
//                adresa=adresa+"a";
//            repc.addContact(new Contact("Nume",adresa,"0123123123","ceva@ceva.ceva"));
//            if(repc.count()!=1) assert false;
//        }
//        catch (InvalidFormatException e){
//        }
//    }

//   void testTCBVA12() {
//        RepositoryContactFile repc=new RepositoryContactFile();
//        repc.clear();
//        try{
//            String adresa;
//            for (int i=1;i<=Math.pow(2,31);i++)
//                adresa=adresa+"a";
//            repc.addContact(new Contact("Nume",adresa,"0123123123","ceva@ceva.ceva"));
//            if(repc.count()!=1) assert false;
//        }
//        catch (InvalidFormatException e){
//        }
//    }

    void testTCBVA14() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("Nume","ceva adresa","0000000000","ceva@ceva.ceva"))
            if(repc.count()!=1) assert false
        }
        catch (InvalidFormatException ignored){

        }
    }

    void testTCBVA15() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("Nume","ceva adresa","999999999","ceva@ceva.ceva"))
        }
        catch (InvalidFormatException ignored){
            if(repc.count()!=0) assert false
        }
    }

    void testTCBVA16() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("Nume","ceva adresa","0000000001","ceva@ceva.ceva"))
            if(repc.count()!=1) assert false
        }
        catch (InvalidFormatException ignored){

        }
    }

    void testTCBVA17() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("Nume","ceva adresa","0999999998","ceva@ceva.ceva"))
            if(repc.count()!=1) assert false
        }
        catch (InvalidFormatException ignored){
        }
    }

    void testTCBVA18() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("Nume","ceva adresa","1000000000","ceva@ceva.ceva"))
        }
        catch (InvalidFormatException ignored){
            if(repc.count()!=0) assert false
        }
    }

    void testTCBVA19() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("Nume","ceva adresa","0999999999","ceva@ceva.ceva"))
            if(repc.count()!=1) assert false
        }
        catch (InvalidFormatException ignored){
        }
    }

    void testTCBVA22() {
        RepositoryContactFile repc=new RepositoryContactFile()
        repc.clear()
        try{
            repc.addContact(new Contact("Nume","ceva adresa","0999999999","E"))
        }
        catch (InvalidFormatException ignored){
            if(repc.count()!=0) assert false
        }
    }

//    void testTCBVA23() {
//        RepositoryContactFile repc=new RepositoryContactFile();
//        repc.clear();
//        try{
//            String email="E@";
//            for (int i=1;i<=Math.pow(2,31) - 3;i++)
//                email=email+"a";
//            repc.addContact(new Contact("Nume","ceva adresa","0123123123",email));
//            if(repc.count()!=1) assert false;
//        }
//        catch (InvalidFormatException e){
//        }
//    }


//    void testTCBVA24() {
//        RepositoryContactFile repc=new RepositoryContactFile();
//        repc.clear();
//        try{
//            String email="E@";
//            for (int i=1;i<=Math.pow(2,31) - 5;i++)
//                email=email+"a";
//            repc.addContact(new Contact("Nume","ceva adresa","0123123123",email));
//            if(repc.count()!=1) assert false;
//        }
//        catch (InvalidFormatException e){
//        }
//    }

//   void testTCBVA25() {
//        RepositoryContactFile repc=new RepositoryContactFile();
//        repc.clear();
//        try{
//            String email="E@";
//            for (int i=1;i<=Math.pow(2,31 -2);i++)
//                email=email+"a";
//            repc.addContact(new Contact("Nume","ceva adresa","0123123123",email));
//            if(repc.count()!=1) assert false;
//        }
//        catch (InvalidFormatException e){
//        }
//    }

}
