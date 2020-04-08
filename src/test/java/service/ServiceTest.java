package service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.TemaXMLRepository;
import validation.TemaValidator;

import static org.junit.Assert.*;

public class ServiceTest
{
    private TemaXMLRepository temaRepo;
    private Service service;

    @Before
    public void setUp() throws Exception
    {
        TemaValidator temaValidator = new TemaValidator();
        this.temaRepo = new TemaXMLRepository(temaValidator,"temeTest.xml");
        this.service = new Service(null,temaRepo,null);
    }

    @After
    public void tearDown() throws Exception
    {
        temaRepo.delete("testId");
    }

    @Test
    public void saveTemaSuccess()
    {
        String id = "testId";
        String descriere = "testDesc";
        int deadline = 13;
        int startline = 2;
        int result = service.saveTema(id,descriere,deadline,startline);

        assertEquals(1,result);
    }

    @Test
    public void saveTemaFailIdNull()
    {
        String id = null;
        String descriere = "testDesc";
        int deadline = 13;
        int startline = 2;
        int result = service.saveTema(id,descriere,deadline,startline);

        assertEquals(0,result);
    }

    @Test
    public void saveTemaFailDescEmpty()
    {
        String id = "testId";
        String descriere = "";
        int deadline = 13;
        int startline = 2;
        int result = service.saveTema(id,descriere,deadline,startline);

        assertEquals(0,result);
    }

    @Test
    public void saveTemaFailDeadlineIncorrect()
    {
        String id = "testId";
        String descriere = "testDesc";
        int deadline = 15;
        int startline = 2;
        int result = service.saveTema(id,descriere,deadline,startline);

        assertEquals(0,result);
    }

    @Test
    public void saveTemaFailStartlineIncorrect()
    {
        String id = "testId";
        String descriere = "testDesc";
        int deadline = 13;
        int startline = 0;
        int result = service.saveTema(id,descriere,deadline,startline);

        assertEquals(0,result);
    }
}
