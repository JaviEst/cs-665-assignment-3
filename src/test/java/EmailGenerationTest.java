/**
 * Name: Javier Estevez
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/17/2025
 * File Name: EmailGenerationTest.java
 * Description: Comprehensive test suite for the Email Generation Application.
 * Assignment #: 3
 * Course CS665
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import customers.BusinessCustomer;
import customers.Customer;
import customers.FrequentCustomer;
import customers.NewCustomer;
import customers.ReturningCustomer;
import customers.VipCustomer;
import emailgeneration.EmailGenerationApp;

import org.junit.Before;
import org.junit.Test;

public class EmailGenerationTest {

  private EmailGenerationApp app;

  /**
   * Set up the test environment before each test.
   */
  @Before
  public void setUp() {
    app = new EmailGenerationApp();
  }

  /**
   * Test email generation for Business customer.
   * Verifies that business-specific content is included in the generated email.
   */
  @Test
  public void testBusinessCustomerEmail() {
    Customer customer = new BusinessCustomer("Acme Corporation");
    String email = app.generateEmailForCustomer(customer);

    assertNotNull("Email should not be null", email);
    assertTrue("Email should contain business greeting",
        email.contains("Dear Acme Corporation Team"));
    assertTrue("Email should contain business-specific content",
        email.contains("business partnership"));
    assertTrue("Email should contain business offer",
        email.contains("Business Premium Package"));
    assertTrue("Email should contain appropriate closing",
        email.contains("Corporate Relations Department"));
  }

  /**
   * Test email generation for Returning customer.
   * Verifies that welcome-back content and offers are included.
   */
  @Test
  public void testReturningCustomerEmail() {
    Customer customer = new ReturningCustomer("John Smith");
    String email = app.generateEmailForCustomer(customer);

    assertNotNull("Email should not be null", email);
    assertTrue("Email should contain welcome back greeting",
        email.contains("Welcome back, John Smith"));
    assertTrue("Email should mention being thrilled to see customer again",
        email.contains("thrilled to see you again"));
    assertTrue("Email should contain welcome-back offer",
        email.contains("WELCOMEBACK20"));
    assertTrue("Email should express excitement about customer's return",
        email.contains("excited to have you back"));
  }

  /**
   * Test email generation for Frequent customer.
   * Verifies that loyalty recognition and rewards are included.
   */
  @Test
  public void testFrequentCustomerEmail() {
    Customer customer = new FrequentCustomer("Jane Doe");
    String email = app.generateEmailForCustomer(customer);

    assertNotNull("Email should not be null", email);
    assertTrue("Email should contain personalized greeting",
        email.contains("Hello Jane Doe"));
    assertTrue("Email should mention loyalty",
        email.contains("loyalty"));
    assertTrue("Email should contain loyalty rewards",
        email.contains("double loyalty points"));
    assertTrue("Email should thank customer for loyalty",
        email.contains("loyal customer"));
  }

  /**
   * Test email generation for New customer.
   * Verifies that welcome content and introductory offers are included.
   */
  @Test
  public void testNewCustomerEmail() {
    Customer customer = new NewCustomer("Alice Johnson");
    String email = app.generateEmailForCustomer(customer);

    assertNotNull("Email should not be null", email);
    assertTrue("Email should contain welcome greeting",
        email.contains("Welcome, Alice Johnson"));
    assertTrue("Email should thank new customer",
        email.contains("Thank you for choosing us"));
    assertTrue("Email should contain new customer discount",
        email.contains("WELCOME15"));
    assertTrue("Email should welcome customer aboard",
        email.contains("Welcome aboard"));
  }

  /**
   * Test email generation for VIP customer.
   * Verifies that exclusive VIP benefits and premium treatment are included.
   */
  @Test
  public void testVipCustomerEmail() {
    Customer customer = new VipCustomer("Robert Williams");
    String email = app.generateEmailForCustomer(customer);

    assertNotNull("Email should not be null", email);
    assertTrue("Email should contain formal greeting",
        email.contains("Dear Robert Williams"));
    assertTrue("Email should mention VIP status",
        email.contains("VIP"));
    assertTrue("Email should contain exclusive privileges",
        email.contains("exclusive VIP privileges"));
    assertTrue("Email should contain VIP signature",
        email.contains("VIP Customer Relations Team"));
  }

  /**
   * Test customer type identification.
   * Verifies that each customer correctly identifies its type.
   */
  @Test
  public void testCustomerTypes() {
    Customer business = new BusinessCustomer("Test Business");
    Customer returning = new ReturningCustomer("Test Returning");
    Customer frequent = new FrequentCustomer("Test Frequent");
    Customer newCust = new NewCustomer("Test New");
    Customer vip = new VipCustomer("Test VIP");

    assertEquals("Business", business.getCustomerType());
    assertEquals("Returning", returning.getCustomerType());
    assertEquals("Frequent", frequent.getCustomerType());
    assertEquals("New", newCust.getCustomerType());
    assertEquals("VIP", vip.getCustomerType());
  }

  /**
   * Test customer name storage and retrieval.
   * Verifies that customer names are correctly stored and returned.
   */
  @Test
  public void testCustomerNames() {
    String businessName = "Tech Solutions Inc";
    String returningName = "Michael Brown";
    String frequentName = "Sarah Davis";
    String newName = "Tom Anderson";
    String vipName = "Elizabeth Taylor";

    Customer business = new BusinessCustomer(businessName);
    Customer returning = new ReturningCustomer(returningName);
    Customer frequent = new FrequentCustomer(frequentName);
    Customer newCust = new NewCustomer(newName);
    Customer vip = new VipCustomer(vipName);

    assertEquals(businessName, business.getName());
    assertEquals(returningName, returning.getName());
    assertEquals(frequentName, frequent.getName());
    assertEquals(newName, newCust.getName());
    assertEquals(vipName, vip.getName());
  }

  /**
   * Test null customer handling.
   * Verifies that the application handles null input appropriately.
   */
  @Test
  public void testNullCustomerHandling() {
    try {
      app.generateEmailForCustomer(null);
      fail("Should throw IllegalArgumentException for null customer");
    } catch (IllegalArgumentException e) {
      assertTrue("Exception message should mention null",
          e.getMessage().contains("null"));
    }
  }
}
