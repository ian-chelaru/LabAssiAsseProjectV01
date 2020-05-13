package service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import static org.junit.Assert.*;

public class IntegrationTest
{
    private StudentValidator studentValidator = new StudentValidator();
    private TemaValidator temaValidator = new TemaValidator();
    private NotaValidator notaValidator = new NotaValidator();

    private StudentXMLRepository studentRepo;
    private TemaXMLRepository temaRepo;
    private NotaXMLRepository notaRepo;

    private Service service;

    private String testStudentId = "testStudentId";
    private String testTemaId = "testTemaId";

    private String gradeStudentId = "gradeStudentId";
    private String gradeTemaId = "gradeTemaId";

    @Before
    public void setUp() throws Exception
    {
        this.studentRepo = new StudentXMLRepository(studentValidator,"studentiTest.xml");
        this.temaRepo = new TemaXMLRepository(temaValidator,"temeTest.xml");
        this.notaRepo = new NotaXMLRepository(notaValidator,"noteTest.xml");

        this.service = new Service(studentRepo,temaRepo,notaRepo);
        service.saveStudent(gradeStudentId,"name",934);
        service.saveTema(gradeTemaId,"descriere",7,4);
    }

    @After
    public void tearDown() throws Exception
    {
        service.deleteStudent(testStudentId);
        service.deleteTema(testTemaId);
        service.deleteNota(gradeStudentId,gradeTemaId);
        service.deleteNota(testStudentId,testTemaId);
    }

    @Test
    public void addStudentSuccess()
    {
        String nume = "testNume";
        int grupa = 111;
        int result = service.saveStudent(testStudentId,nume,grupa);

        assertEquals(1,result);
    }

    @Test
    public void addAssignmentSuccess()
    {
        String descriere = "testDesc";
        int deadline = 13;
        int startline = 2;
        int result = service.saveTema(testTemaId,descriere,deadline,startline);

        assertEquals(1,result);
    }

    @Test
    public void addGradeSuccess()
    {
        int valNota = 10;
        int predata = 7;
        String feedback = "feedback";
        int result = service.saveNota(gradeStudentId,gradeTemaId,valNota,predata,feedback);

        assertEquals(1,result);
    }

    @Test
    public void addAllSuccess()
    {
        String nume = "testNume";
        int grupa = 111;
        int studentResult = service.saveStudent(testStudentId,nume,grupa);

        String descriere = "testDesc";
        int deadline = 13;
        int startline = 2;
        int temaResult = service.saveTema(testTemaId,descriere,deadline,startline);

        int valNota = 10;
        int predata = 7;
        String feedback = "feedback";
        int notaResult = service.saveNota(gradeStudentId,gradeTemaId,valNota,predata,feedback);

        assertEquals(1,studentResult);
        assertEquals(1,temaResult);
        assertEquals(1,notaResult);
    }

    @Test
    public void addStudentIntegration()
    {
        String nume = "testNume";
        int grupa = 111;
        int result = service.saveStudent(testStudentId,nume,grupa);

        assertEquals(1,result);
    }

    @Test
    public void addAssignmentIntegration()
    {
        String nume = "testNume";
        int grupa = 111;
        int studentResult = service.saveStudent(testStudentId,nume,grupa);

        String descriere = "testDesc";
        int deadline = 14;
        int startline = 1;
        int assignmentResult = service.saveTema(testTemaId,descriere,deadline,startline);

        assertEquals(1,studentResult);
        assertEquals(1,assignmentResult);
    }

    @Test
    public void addGradeIntegration()
    {
        String nume = "testNume";
        int grupa = 111;
        int studentResult = service.saveStudent(testStudentId,nume,grupa);

        String descriere = "testDesc";
        int deadline = 14;
        int startline = 1;
        int assignmentResult = service.saveTema(testTemaId,descriere,deadline,startline);

        int valNota = 10;
        int predata = 11;
        String feedback = "testFeedback";
        int gradeResult = service.saveNota(testStudentId,testTemaId,valNota,predata,feedback);

        assertEquals(1,studentResult);
        assertEquals(1,assignmentResult);
        assertEquals(1,gradeResult);
    }


}
