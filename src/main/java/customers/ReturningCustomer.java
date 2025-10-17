/**
 * Name: Javier Estevez
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/17/2025
 * File Name: ReturningCustomer.java
 * Description: Concrete implementation representing Returning customers.
 * Assignment #: 3
 * Course CS665
 */

package customers;

import emailgeneration.EmailGenerator;

public class ReturningCustomer implements Customer {

  private final String name;
  private final EmailGenerator emailGenerator;

  /**
   * Constructor for ReturningCustomer.
   *
   * @param name the name of the returning customer
   */
  public ReturningCustomer(String name) {
    this.name = name;
    this.emailGenerator = new ReturningEmailGenerator();
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
    return "Returning";
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
   * Inner class that implements the email generation strategy for Returning customers.
   * This strategy focuses on welcoming back customers and re-engagement.
   */
  private static class ReturningEmailGenerator extends EmailGenerator {

    /**
     * Generates a personalized greeting for the customer.
     * Subclasses must implement this to provide customer-type-specific greetings.
     *
     * @param customerName the name of the customer
     * @return the greeting text
     */
    @Override
    protected String getGreeting(String customerName) {
      return "Welcome back, " + customerName + "!";
    }

    /**
     * Generates the main body of the email.
     * Subclasses must implement this to provide customer-type-specific content.
     *
     * @return the email body text
     */
    @Override
    protected String getBody() {
      return "We're thrilled to see you again! We've missed you and have been working hard "
          + "to improve our services since your last visit. We hope you'll find our new features "
          + "and improvements to your liking, and we're excited to serve you once more.";
    }

    /**
     * Generates a special offer or promotion section.
     * Subclasses must implement this to provide customer-type-specific offers.
     *
     * @return the offer text
     */
    @Override
    protected String getOffer() {
      return "As a special welcome-back gift, we'd like to offer you 20% off your next purchase. "
          + "Use code WELCOMEBACK20 at checkout. This offer is our way of showing how much we "
          + "value your return and look forward to serving you again.";
    }

    /**
     * Generates the closing message of the email.
     * Default implementation provided, but can be overridden.
     *
     * @return the closing text
     */
    @Override
    protected String getClosing() {
      return "We're excited to have you back and can't wait to serve you again!";
    }
  }
}
