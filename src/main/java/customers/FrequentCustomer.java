/**
 * Name: Javier Estevez
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/17/2025
 * File Name: FrequentCustomer.java
 * Description: Concrete implementation representing Frequent customers.
 * Assignment #: 3
 * Course CS665
 */

package customers;

import emailgeneration.EmailGenerator;

public class FrequentCustomer implements Customer {

  private final String name;
  private final EmailGenerator emailGenerator;

  /**
   * Constructor for FrequentCustomer.
   *
   * @param name the name of the frequent customer
   */
  public FrequentCustomer(String name) {
    this.name = name;
    this.emailGenerator = new FrequentEmailGenerator();
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
    return "Frequent";
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
   * Inner class that implements the email generation strategy for Frequent customers.
   * This strategy emphasizes loyalty recognition and rewards.
   */
  private static class FrequentEmailGenerator extends EmailGenerator {

    /**
     * Generates a personalized greeting for the customer.
     * Subclasses must implement this to provide customer-type-specific greetings.
     *
     * @param customerName the name of the customer
     * @return the greeting text
     */
    @Override
    protected String getGreeting(String customerName) {
      return "Hello " + customerName + ",";
    }

    /**
     * Generates the main body of the email.
     * Subclasses must implement this to provide customer-type-specific content.
     *
     * @return the email body text
     */
    @Override
    protected String getBody() {
      return "Your loyalty means the world to us! As one of our most frequent customers, "
          + "you've shown incredible support for our business. We want you to know that "
          + "we recognize and deeply appreciate your continued patronage and trust in our "
          + "services.";
    }

    /**
     * Generates a special offer or promotion section.
     * Subclasses must implement this to provide customer-type-specific offers.
     *
     * @return the offer text
     */
    @Override
    protected String getOffer() {
      return "You've earned double loyalty points on your next purchase! Plus, enjoy early "
          + "access to our upcoming sales and exclusive product launches. Check your account "
          + "for your personalized rewards and benefits that we've prepared just for you.";
    }

    /**
     * Generates the closing message of the email.
     * Default implementation provided, but can be overridden.
     *
     * @return the closing text
     */
    @Override
    protected String getClosing() {
      return "Thank you for being such a loyal customer!";
    }
  }
}
