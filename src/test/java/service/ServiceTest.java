package service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.TemaXMLRepository;
import validation.TemaValidator;
import validation.ValidationException;

import static org.junit.Assert.*;

public class ServiceTest
{

    private Service service;
    private TemaXMLRepository repo;
    private TemaValidator validator;

    @Before
    public void setUp() throws Exception
    {
        this.validator = new TemaValidator();
        this.repo = new TemaXMLRepository(validator, "temeTest.xml");
        this.service = new Service(null, repo, null);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void saveStudent()
    {
        int a = 3 + 2;
        assertEquals(5, a);
    }

    @Test
    public void saveTemaSuccess()
    {
        int deadline = 13;
        int startline = 2;
        String id = "SomeId.txt";
        String description = "SomeDesc.txt";
        int result = service.saveTema(id, description, deadline, startline);

        assertEquals(0, result);
    }

    @Test
    public void saveTemaFailIdNull()
    {
        int deadline = 13;
        int startline = 2;
        String id = null;
        String description = "SomeDesc.txt";
        int result = service.saveTema(id, description, deadline, startline);

        assertEquals(1, result);
    }

    @Test
    public void saveTemaFailIdEmpty()
    {
        int deadline = 13;
        int startline = 2;
        String id = "";
        String description = "SomeDesc.txt";
        int result = service.saveTema(id, description, deadline, startline);

        assertEquals(1, result);
    }

    @Test
    public void saveTemaFailDescNull()
    {
        int deadline = 13;
        int startline = 2;
        String id = "SomeId.txt";
        String description = null;
        int result = service.saveTema(id, description, deadline, startline);

        assertEquals(1, result);
    }

    @Test
    public void saveTemaFailDescEmpty()
    {
        int deadline = 13;
        int startline = 2;
        String id = "SomeId.txt";
        String description = "";
        int result = service.saveTema(id, description, deadline, startline);

        assertEquals(1, result);
    }
}
