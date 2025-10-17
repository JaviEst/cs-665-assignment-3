/**
 * Name: Javier Estevez
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/17/2025
 * File Name: Customer.java
 * Description: Interface that defines the contract for all customer types.
 * Assignment #: 3
 * Course CS665
 */

package customers;

public interface Customer {

  /**
   * Gets the customer's name.
   *
   * @return the customer's name
   */
  String getName();

  /**
   * Gets the customer type identifier.
   *
   * @return the customer type (e.g., "Business", "VIP", etc.)
   */
  String getCustomerType();

  /**
   * Generates a personalized email for this customer.
   * This method delegates to the customer's specific email generation strategy.
   *
   * @return the generated email text
   */
  String generateEmail();
}
