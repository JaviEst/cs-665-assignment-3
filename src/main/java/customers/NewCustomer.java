/**
 * Name: Javier Estevez
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/17/2025
 * File Name: NewCustomer.java
 * Description: Concrete implementation representing New customers.
 * Assignment #: 3
 * Course CS665
 */

package customers;

import emailgeneration.EmailGenerator;

public class NewCustomer implements Customer {

  private final String name;
  private final EmailGenerator emailGenerator;

  /**
   * Constructor for NewCustomer.
   *
   * @param name the name of the new customer
   */
  public NewCustomer(String name) {
    this.name = name;
    this.emailGenerator = new NewEmailGenerator();
  }

  /**
   * Gets the customer's name.
   *
   * @return the customer's name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Gets the customer type identifier.
   *
   * @return the customer type (e.g., "Business", "VIP", etc.)
   */
  @Override
  public String getCustomerType() {
    return "New";
  }

  /**
   * Generates a personalized email for this customer.
   * This method delegates to the customer's specific email generation strategy.
   *
   * @return the generated email text
   */
  @Override
  public String generateEmail() {
    return emailGenerator.generateEmail(name);
  }

  /**
   * Inner class that implements the email generation strategy for New customers.
   * This strategy focuses on welcome messages and introductory offers.
   */
  private static class NewEmailGenerator extends EmailGenerator {

    /**
     * Generates a personalized greeting for the customer.
     * Subclasses must implement this to provide customer-type-specific greetings.
     *
     * @param customerName the name of the customer
     * @return the greeting text
     */
    @Override
    protected String getGreeting(String customerName) {
      return "Welcome, " + customerName + "!";
    }

    /**
     * Generates the main body of the email.
     * Subclasses must implement this to provide customer-type-specific content.
     *
     * @return the email body text
     */
    @Override
    protected String getBody() {
      return "Thank you for choosing us! We're excited to have you as a new customer and "
          + "are committed to providing you with exceptional service. We want to ensure your "
          + "experience with us is outstanding from the very beginning, and we're here to "
          + "support you every step of the way.";
    }

    /**
     * Generates a special offer or promotion section.
     * Subclasses must implement this to provide customer-type-specific offers.
     *
     * @return the offer text
     */
    @Override
    protected String getOffer() {
      return "To help you get started, we're offering you 15% off your first purchase! "
          + "Use code WELCOME15 at checkout. Plus, check out our beginner's guide to make "
          + "the most of our services and explore our most popular products curated just for "
          + "new customers.";
    }

    /**
     * Generates the closing message of the email.
     * Default implementation provided, but can be overridden.
     *
     * @return the closing text
     */
    @Override
    protected String getClosing() {
      return "Welcome aboard! We're here to help you every step of the way.";
    }
  }
}
