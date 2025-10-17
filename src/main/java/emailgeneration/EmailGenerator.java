/**
 * Name: Javier Estevez
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/17/2025
 * File Name: EmailGenerator.java
 * Description: Abstract base class that defines the template for email generation.
 *              This class provides a common structure for all emails while allowing
 *              customization through abstract methods that subclasses must implement.
 * Assignment #: 3
 * Course CS665
 */

package emailgeneration;

public abstract class EmailGenerator {

  /**
   * Template method that defines the overall structure of email generation.
   * This method cannot be overridden, ensuring a consistent email structure.
   *
   * @param customerName the name of the customer receiving the email
   * @return the complete email text
   */
  public final String generateEmail(String customerName) {
    StringBuilder email = new StringBuilder();
    
    email.append(getGreeting(customerName));
    email.append("\n\n");
    email.append(getBody());
    email.append("\n\n");
    email.append(getOffer());
    email.append("\n\n");
    email.append(getClosing());
    email.append("\n");
    email.append(getSignature());
    
    return email.toString();
  }

  /**
   * Generates a personalized greeting for the customer.
   * Subclasses must implement this to provide customer-type-specific greetings.
   *
   * @param customerName the name of the customer
   * @return the greeting text
   */
  protected abstract String getGreeting(String customerName);

  /**
   * Generates the main body of the email.
   * Subclasses must implement this to provide customer-type-specific content.
   *
   * @return the email body text
   */
  protected abstract String getBody();

  /**
   * Generates a special offer or promotion section.
   * Subclasses must implement this to provide customer-type-specific offers.
   *
   * @return the offer text
   */
  protected abstract String getOffer();

  /**
   * Generates the closing message of the email.
   * Default implementation provided, but can be overridden.
   *
   * @return the closing text
   */
  protected String getClosing() {
    return "Thank you for your continued support.";
  }

  /**
   * Generates the signature section of the email.
   * Default implementation provided, but can be overridden.
   *
   * @return the signature text
   */
  protected String getSignature() {
    return "Best regards,\nThe Customer Service Team";
  }
}
