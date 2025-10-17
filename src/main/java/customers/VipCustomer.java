/**
 * Name: Javier Estevez
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/17/2025
 * File Name: VipCustomer.java
 * Description: Concrete implementation representing VIP customers.
 * Assignment #: 3
 * Course CS665
 */

package customers;

import emailgeneration.EmailGenerator;

public class VipCustomer implements Customer {

  private final String name;
  private final EmailGenerator emailGenerator;

  /**
   * Constructor for VipCustomer.
   *
   * @param name the name of the VIP customer
   */
  public VipCustomer(String name) {
    this.name = name;
    this.emailGenerator = new VipEmailGenerator();
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
    return "VIP";
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
   * Inner class that implements the email generation strategy for VIP customers.
   * This strategy emphasizes exclusivity and premium benefits.
   */
  private static class VipEmailGenerator extends EmailGenerator {

    /**
     * Generates a personalized greeting for the customer.
     * Subclasses must implement this to provide customer-type-specific greetings.
     *
     * @param customerName the name of the customer
     * @return the greeting text
     */
    @Override
    protected String getGreeting(String customerName) {
      return "Dear " + customerName + ",";
    }

    /**
     * Generates the main body of the email.
     * Subclasses must implement this to provide customer-type-specific content.
     *
     * @return the email body text
     */
    @Override
    protected String getBody() {
      return "As one of our most valued VIP customers, you hold a special place in our "
          + "organization. Your exceptional loyalty and patronage have earned you access to "
          + "our most exclusive services and benefits. We are dedicated to ensuring your "
          + "experience exceeds all expectations and reflects the premium status you deserve.";
    }

    /**
     * Generates a special offer or promotion section.
     * Subclasses must implement this to provide customer-type-specific offers.
     *
     * @return the offer text
     */
    @Override
    protected String getOffer() {
      return "You have been granted exclusive VIP privileges including: complimentary premium "
          + "shipping, 24/7 priority concierge support, early access to limited edition products, "
          + "and invitations to exclusive VIP-only events. Your dedicated account specialist "
          + "will contact you shortly to discuss additional personalized benefits.";
    }

    /**
     * Generates the closing message of the email.
     * Default implementation provided, but can be overridden.
     *
     * @return the closing text
     */
    @Override
    protected String getClosing() {
      return "It is our privilege to serve you.";
    }

    /**
     * Generates the signature section of the email.
     * Default implementation provided, but can be overridden.
     *
     * @return the signature text
     */
    @Override
    protected String getSignature() {
      return "With highest regards,\nVIP Customer Relations Team";
    }
  }
}
