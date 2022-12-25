package day05_JUnit;
import org.junit.*;


public class C04_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass Annotations sadece static metodlar icin calisir.
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz test metodlarinin hepsini ayni anda calistirip
    en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
     */
    @BeforeClass
    public static void setup() {
        System.out.println("Butun testlerden once calisti");

    }

    @AfterClass
    public static void teardown() {
        System.out.println("butun testlerden sonra calisti");

    }

    @Before
    public void setup01() {
        System.out.println("Her testten once calisir");

    }

    @After
    public void teardown01() {
        System.out.println("Her testten sonra calisir ");

    }

    @Test
    public void tes01() {
        System.out.println("1.test");

    }

    @Test
    public void test02() {
        System.out.println("2.Test");

    }

    @Test
    @Ignore
    public void test03() {
        System.out.println("3.Test");

// BeforeClass
// Before
// Test1
// After
// Before
// Test2
// After
// AfterClass
    }
}
