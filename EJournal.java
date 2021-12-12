import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 * Maxim Karpinsky
 * ID: 2405869
 * email: karpinsky@chapman.edu
 * Course: CPSC 231
 * Assignment: Programming Mastery Project 4: Library Database
 */

/**
 * Extension of Journal class with a specific subtype of Journal.
 */
public class EJournal extends Journal
{
  private String url;
  private int pubFee;

  /**
   * Default construcot which creates generic ejournal object
   */
  public EJournal()
  {
    super();

    url = "";
    pubFee = 0;
  }

  /**
   * Overloaded constructor for ejournal object
   * @param url        URL of Ejournal
   * @param pubFee     Publication Fee of Ejournal
   * @param editor     Editor of Ejournal
   * @param issueNum   Issue Number of EJournal
   * @param title      Publication Title
   * @param yearPub    Year Published
   * @param publisher  The Publisher Name
   * @param isbn       ISBN value
   */
  public EJournal(String url, int pubFee, String editor, int issueNum, String title, int yearPub, String publisher, int isbn)
  {
    super(editor, issueNum, title, yearPub, publisher, isbn);

    this.url = url;
    this.pubFee = pubFee;

  }

  /**
   * Copy constructor to create ejournal object based on existing one's values
   * @param other  Ejournal object to copy data from.
   */
  public EJournal(EJournal other)
  {
    super(other);
    url = other.getUrl();
    pubFee = other.getPubFee();
  }

  /**
   * Get method to get the EJournal's URL
   * @return the URL
   */
  public String getUrl()
  {
    return url;
  }

  /**
   * Set method to set the EJournal's URL
   * @param toSet  URL to set to
   */
  public void setUrl(String toSet)
  {
    url = toSet;
  }

  /**
   * Get method to get the publication Fee of Ejournal
   * @return the publication fee
   */
  public int getPubFee()
  {
    return pubFee;
  }

  /**
   * Set method to set the publication fee of Ejournal
   * @param toSet  fee to set to
   */
  public void setPubFee(int toSet)
  {
    pubFee = toSet;
  }

  /**
   * Method to get the Publication type of this class, EJournal
   * @return publication type
   */
  public String getType()
  {
    return "EJournal";
  }

  /**
   * Method to return String representation of EJournal object with all data.
   * @return the string representation of the object.
   */
  public String toString()
  {
    String ejournalString = super.toString() +
                     "URL: " + getUrl() + "\n" +
                     "Publication Fee: " + getPubFee() + "\n";

    return ejournalString;
  }

  /**
   * Equals method to check whether this ejournal is equal to another ejournal
   * object based on whether their attributes match
   * @param  other          the other EJournal object to compare to.
   * @return                true if both object's parameters all match,
   *                        false otherwise.
   */
  public boolean equals(EJournal other)
  {
    return(super.equals(other) &&
           getUrl().equals(other.getUrl()) &&
           getPubFee() == other.getPubFee());
  }

  /**
   * Print method to export all object's data to specified file.
   * Because this is an extension of Journal, just calls Journal print Method
   * the toString is overriden in Journal class due to inheritance so it still
   * prints EJournal data.
   * @param fileName  specified file name to create and export to.
   */
  public void print(String fileName)
  {
    super.print(fileName);
  }
}
