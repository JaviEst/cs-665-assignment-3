/**
 * Name: Javier Estevez
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/17/2025
 * File Name: EmailGenerationApp.java
 * Description: Main application class that demonstrates the Email Generation system.
 * Assignment #: 3
 * Course CS665
 */

package emailgeneration;

import customers.BusinessCustomer;
import customers.Customer;
import customers.FrequentCustomer;
import customers.NewCustomer;
import customers.ReturningCustomer;
import customers.VipCustomer;

public class EmailGenerationApp {

  /**
   * Generates an email for a given customer using the Strategy Pattern.
   * The email generation strategy is determined by the customer type.
   *
   * @param customer the customer for whom to generate an email
   * @return the generated email text
   * @throws IllegalArgumentException if customer is null
   */
  public String generateEmailForCustomer(Customer customer) {
    if (customer == null) {
      throw new IllegalArgumentException("Customer cannot be null");
    }
    return customer.generateEmail();
  }

  /**
   * Main method for demonstration purposes.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    EmailGenerationApp app = new EmailGenerationApp();

    // Create instances of each customer type
    Customer businessCustomer = new BusinessCustomer("Acme Corporation");
    Customer returningCustomer = new ReturningCustomer("John Smith");
    Customer frequentCustomer = new FrequentCustomer("Jane Doe");
    Customer newCustomer = new NewCustomer("Alice Johnson");
    Customer vipCustomer = new VipCustomer("Robert Williams");

    // Generate and display emails
    System.out.println("=== Business Customer Email ===");
    System.out.println(app.generateEmailForCustomer(businessCustomer));
    System.out.println("\n=== Returning Customer Email ===");
    System.out.println(app.generateEmailForCustomer(returningCustomer));
    System.out.println("\n=== Frequent Customer Email ===");
    System.out.println(app.generateEmailForCustomer(frequentCustomer));
    System.out.println("\n=== New Customer Email ===");
    System.out.println(app.generateEmailForCustomer(newCustomer));
    System.out.println("\n=== VIP Customer Email ===");
    System.out.println(app.generateEmailForCustomer(vipCustomer));
  }
}
