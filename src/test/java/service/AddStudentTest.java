package service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.StudentXMLRepository;
import validation.StudentValidator;

import static org.junit.Assert.*;

public class AddStudentTest
{
    private StudentXMLRepository studentRepo;
    private Service service;

    @Before
    public void setUp() throws Exception
    {
        StudentValidator studentValidator = new StudentValidator();
        this.studentRepo = new StudentXMLRepository(studentValidator,"studentiTest.xml");
        this.service = new Service(studentRepo,null,null);
    }

    @After
    public void tearDown() throws Exception
    {
        studentRepo.delete("testId");
    }

    @Test
    public void addStudentGroup111Success()
    {
        String id = "testId";
        String nume = "testNume";
        int grupa = 111;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(1, result);
    }

    @Test
    public void addStudentIdEmptyFailure()
    {
        String id = "";
        String nume = "testNume";
        int grupa = 111;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(0, result);
    }

    @Test
    public void addStudentIdNullFailure()
    {
        String id = null;
        String nume = "testNume";
        int grupa = 111;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(0, result);
    }

    @Test
    public void addStudentNameEmptyFailure()
    {
        String id = "testId";
        String nume = "";
        int grupa = 111;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(0, result);
    }

    @Test
    public void addStudentNameNullFailure()
    {
        String id = "testId";
        String nume = null;
        int grupa = 111;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(0, result);
    }

    @Test
    public void addStudentGroup110Failure()
    {
        String id = "testId";
        String nume = "testNume";
        int grupa = 110;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(0, result);
    }

    @Test
    public void addStudentGroup938Failure()
    {
        String id = "testId";
        String nume = "testNume";
        int grupa = 938;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(0, result);
    }

    @Test
    public void addStudentGroup937Success()
    {
        String id = "testId";
        String nume = "testNume";
        int grupa = 937;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(1, result);
    }

    @Test
    public void addStudentGroup112Success()
    {
        String id = "testId";
        String nume = "testNume";
        int grupa = 112;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(1, result);
    }

    @Test
    public void addStudentGroup936Success()
    {
        String id = "testId";
        String nume = "testNume";
        int grupa = 936;
        int result = service.saveStudent(id, nume, grupa);

        assertEquals(1, result);
    }

}
