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

public class AddGradeTest
{
    private NotaXMLRepository notaRepo;
    private Service service;

    private String studentId = "studentId";
    private String temaId = "temaId";

    @Before
    public void setUp() throws Exception
    {
        NotaValidator notaValidator = new NotaValidator();
        this.notaRepo = new NotaXMLRepository(notaValidator, "noteTest.xml");

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepository studentRepo = new StudentXMLRepository(studentValidator,"studentiTest.xml");

        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository temaRepo = new TemaXMLRepository(temaValidator, "temeTest.xml");

        this.service = new Service(studentRepo,temaRepo,notaRepo);
        service.saveStudent(studentId, "name", 934);
        service.saveTema(temaId, "descriere", 6, 4);
    }

    @After
    public void tearDown() throws Exception
    {
        service.deleteNota(studentId, temaId);
    }

    @Test
    public void addGrade()
    {
        int valNota = 10;
        int predata = 6;
        String feedback = "feedback";
        int result = service.saveNota(studentId, temaId, valNota, predata, feedback);

        assertEquals(1, result);
    }
}
