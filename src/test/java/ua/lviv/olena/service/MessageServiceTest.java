package ua.lviv.olena.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    private MessageService messageService;

    @Mock
    private UserService userService;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all");
    }
    @BeforeEach
    void setUp() {
        messageService=new MessageService(userService);
        System.out.println("    Befoure each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("    After each");

    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all");
    }

    @Test
    void generateDefaultMessage_ReturnNotNullValue() {
        String actualMessage = messageService.generateDefaultMessage();
        Assertions.assertNotNull(actualMessage);
    }
    @Test
    void generateDefaultMessage_ReturnHello() {
        String actualMessage = messageService.generateDefaultMessage();
        Assertions.assertEquals("Hello!", actualMessage);
    }
    @Test
    void generateDefaultMessage_ReturnHellos() {
        String actualMessage = messageService.generateDefaultMessage();
        Assertions.assertEquals("Hello", actualMessage);
    }

    @Test
    void generateMessageForAdmin_ReturnHelloAdman(){
        Mockito.when(userService.getAdminName()).thenReturn("Admin");
        String adminMessage = messageService.generateMessageForAdmin();
        Assertions.assertEquals("Hello Admin",adminMessage);
    }

    @Test
    void generateMessageForUser_ReturnHelloFirstName(){
        Mockito.when(userService.getUserName()).thenReturn("First Name");
        String user = messageService.generateMessageForUser();
        Assertions.assertEquals("Hello First Name",user);
    }
}
