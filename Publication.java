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
 * Publication class, parent class which classifies any publication with
 * necessary data like title, publishing year, publisher, and ISBN.
 */
public abstract class Publication implements Comparable<Publication>, Printable
{
  private String title;
  private int yearPub;
  private String publisher;
  private int isbn;
  private FileOutputStream fileStream;

  /**
   * Default constructor for Publication, creates generic blank publication
   * object.
   */
  public Publication()
  {
    title = "";
    yearPub = 0;
    publisher = "";
    isbn = 0;

    fileStream = null;
  }

  /**
   * Overloaded constructor for Publication
   * @param title      title of publication
   * @param yearPub    year published
   * @param publisher  the publisher name
   * @param isbn       isbn identifation value
   */
  public Publication(String title, int yearPub, String publisher, int isbn)
  {
    this.title = title;
    this.yearPub = yearPub;
    this.publisher = publisher;
    this.isbn = isbn;

    fileStream = null;
  }

  /**
   * Copy constructor for publication
   * @param other  Other publication to copy data from.
   */
  public Publication(Publication other)
  {
    title = other.getTitle();
    yearPub = other.getYearPub();
    publisher = other.getPublisher();
    isbn = other.getIsbn();
  }

  /**
   * Get method to return publication title
   * @return publication title
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * Set method to set the publication title
   * @param toSet  publication title to set
   */
  public void setTitle(String toSet)
  {
    title = toSet;
  }

  /**
   * Get mehtod to return year published
   * @return year published
   */
  public int getYearPub()
  {
    return yearPub;
  }

  /**
   * Set method to set the published year
   * @param toSet year to set to
   */
  public void setYearPub(int toSet)
  {
    yearPub = toSet;
  }

  /**
   * Get method to return the publisher
   * @return the publisher
   */
  public String getPublisher()
  {
    return publisher;
  }

  /**
   * Set method to set the publisher
   * @param toSet  publisher name to set to
   */
  public void setPublisher(String toSet)
  {
    publisher = toSet;
  }

  /**
   * Get method to get the publication's ibsn value
   * @return isbn value
   */
  public int getIsbn()
  {
    return isbn;
  }

  /**
   * Set method to set the publication's isbn
   * @param toSet  publisher isbn to set to
   */
  public void setIsbn(int toSet)
  {
    isbn = toSet;
  }

  /**
   * Method to return the string representation of the publication object
   * @return the publication's string representation with all unique data.
   */
  public String toString()
  {
    String publicationString = "Publication Title: " + getTitle() + "\n" +
                               "Publication Year: " + getYearPub() + "\n" +
                               "Publisher: " + getPublisher() + "\n" +
                               "ISBN: " + getIsbn() + "\n";

    return publicationString;
  }

  /**
   * Equals method to check whether this publication is equal to another
   * publication.
   * @param  other the other publication object to compare to
   * @return    true whether both publication objects' values match,
   *            false otherwise.
   */
  public boolean equals(Publication other)
  {
    return(getTitle().equals(other.getTitle()) &&
           getYearPub() == other.getYearPub() &&
           getPublisher().equals(other.getPublisher()) &&
           getIsbn() == other.getIsbn());
  }

  /**
   * Method to export all publication data to file in ExportLog directory,
   * this class is abstract so it method doesn't export data but rather set's
   * up file so that child class and export all data including Publication parent
   * data to file.
   *
   * @param fileName  the file name to create and drop data in.
   */
  public void print(String fileName)
  {

    //Checks whether input has txt at end, if not it adds it so proper
    //file is created.
    if(fileName.indexOf(".txt") == -1)
    {
      fileName = fileName + ".txt";
    }

    //Attempts to create an exportLog directory if one does not already exist
    try
    {
      File dir = new File("exportLog/");
      if(!dir.exists())
      {
        dir.mkdir();
      }

      //Creates a file object to export data to, overrides any existing file
      //with same name, to make sure no data is dupdlicate
      File file = new File("exportLog/" + fileName);
      fileStream = new FileOutputStream(file);

    }
    catch(IOException e)
    {
      System.out.println(e.toString());
      System.out.println("File Not Found " + fileName);
    }
  }

  /**
   * Compare to method to compare Publication objects based on their
   * publication year.
   * @param  other               The other publication object to compare to.
   * @return                     1 if published year is later than other,
   *                             -1 if published year less than other,
   *                             0 if published years are same.
   */
  public int compareTo(Publication other)
  {
    if (this.getYearPub() > other.getYearPub())
    {
      return 1;
    }
    else if(this.getYearPub() < other.getYearPub())
    {
      return -1;
    }
    else
    {
      return 0;
    }
  }

}
