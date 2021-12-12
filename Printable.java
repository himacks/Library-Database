/**
 * Maxim Karpinsky
 * ID: 2405869
 * email: karpinsky@chapman.edu
 * Course: CPSC 231
 * Assignment: Programming Mastery Project 4: Library Database
 */

/**
 * Interface to ensure all objects within project have a method to export
 * their data to a file.
 */
public interface Printable
{
  /**
   * Method to export object data to file
   * @param fileName  name of file to create and export to
   */
  void print(String fileName);
}
