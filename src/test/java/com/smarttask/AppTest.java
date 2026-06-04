package com.smarttask;
import org.junit.Test;
import static org.junit.Assert.*;
public class AppTest {
@Test
public void testAddTasks() {
    
    App app = new App();
    assertEquals(10, app.addTasks(5,5));
}
}