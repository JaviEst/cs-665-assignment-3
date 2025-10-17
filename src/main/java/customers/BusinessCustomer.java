/**
 * Name: Javier Estevez
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/17/2025
 * File Name: BusinessCustomer.java
 * Description: Concrete implementation representing Business customers.
 * Assignment #: 3
 * Course CS665
 */

package customers;

import emailgeneration.EmailGenerator;

public class BusinessCustomer implements Customer {

  private final String name;
  private final EmailGenerator emailGenerator;

  /**
   * Constructor for BusinessCustomer.
   *
   * @param name the name of the business customer
   */
  public BusinessCustomer(String name) {
    this.name = name;
    this.emailGenerator = new BusinessEmailGenerator();
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
    return "Business";
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
   * Inner class that implements the email generation strategy for Business customers.
   * This strategy focuses on professional communication and enterprise solutions.
   */
  private static class BusinessEmailGenerator extends EmailGenerator {

    /**
     * Generates a personalized greeting for the customer.
     * Subclasses must implement this to provide customer-type-specific greetings.
     *
     * @param customerName the name of the customer
     * @return the greeting text
     */
    @Override
    protected String getGreeting(String customerName) {
      return "Dear " + customerName + " Team,";
    }

    /**
     * Generates the main body of the email.
     * Subclasses must implement this to provide customer-type-specific content.
     *
     * @return the email body text
     */
    @Override
    protected String getBody() {
      return "We appreciate your business partnership and the trust you place in our services. "
          + "As a valued business client, we understand the importance of reliable solutions "
          + "that help your organization thrive and achieve its strategic objectives.";
    }

    /**
     * Generates a special offer or promotion section.
     * Subclasses must implement this to provide customer-type-specific offers.
     *
     * @return the offer text
     */
    @Override
    protected String getOffer() {
      return "We're pleased to offer you exclusive access to our Business Premium Package, "
          + "which includes priority support, bulk discounts, and dedicated account management. "
          + "Contact your account manager to learn more about these enterprise solutions "
          + "tailored to your organizational needs.";
    }

    /**
     * Generates the closing message of the email.
     * Default implementation provided, but can be overridden.
     *
     * @return the closing text
     */
    @Override
    protected String getClosing() {
      return "We look forward to continuing our successful business relationship.";
    }

    /**
     * Generates the signature section of the email.
     * Default implementation provided, but can be overridden.
     *
     * @return the signature text
     */
    @Override
    protected String getSignature() {
      return "Sincerely,\nCorporate Relations Department";
    }
  }
}
