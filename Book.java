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
 * Child class of Publication, allows for creation of Book publication
 */
public class Book extends Publication
{
  private String author;
  private int numPages;
  private String bindingType;
  private FileOutputStream fileStream;
  private PrintWriter outFS;

  /**
   * default constructor for Book, creates generic book with no data.
   */
  public Book()
  {
    super();

    author = "";
    numPages = 0;
    bindingType = "";

    fileStream = null;
    outFS = null;
  }

  /**
   * Overloaded constructor for Book
   * @param author       author of the book
   * @param numPages     number of pages in book
   * @param bindingType  binding type of book (hardbook or paperbook)
   * @param title        the title of publication
   * @param yearPub      year the it was published
   * @param publisher    the publisher of item
   * @param isbn         isbn number
   */
  public Book(String author, int numPages, String bindingType, String title, int yearPub, String publisher, int isbn)
  {
    super(title, yearPub, publisher, isbn);
    this.author = author;
    this.numPages = numPages;
    this.bindingType = bindingType;

    fileStream = null;
    outFS = null;
  }

  /**
   * Copy constructor for Book
   * @param other  the other Book object to copy.
   */
  public Book(Book other)
  {
    super(other);
    author = other.getAuthor();
    numPages = other.getNumPages();
    bindingType = other.getBindingType();
  }

  /**
   * Get method to get the book author
   * @return the author of the book
   */
  public String getAuthor()
  {
    return author;
  }

  /**
   * Set method to set the book author
   * @param toSet author of book to set
   */
  public void setAuthor(String toSet)
  {
    author = toSet;
  }

  /**
   * Get method to get the num of pages in book
   * @return num of pages in book
   */
  public int getNumPages()
  {
    return numPages;
  }

  /**
   * Set method to set the num pages
   * @param toSet  num of pages to set to
   */
  public void setNumPages(int toSet)
  {
    numPages = toSet;
  }

  /**
   * Get method to get the bindingType
   * @return the binding type
   */
  public String getBindingType()
  {
    return bindingType;
  }

  /**
   * Set method to set the bindingtype
   * @param toSet  value to set to
   */
  public void setBindingType(String toSet)
  {
    bindingType = toSet;
  }

  /**
   * Returns the type of publication, Book
   * @return String type of publication
   */
  public String getType()
  {
    return "Book";
  }

  /**
   * String method to get string representation of object with
   * all values.
   * @return String representation of Book
   */
  public String toString()
  {
    String bookString = "Publication Type: " + getType() + "\n" +
                        super.toString() +
                        "Author: " + getAuthor() + "\n" +
                        "# of Pages: " + getNumPages() + "\n" +
                        "Binding Type: " + getBindingType() + "\n";

    return bookString;
  }

  /**
   * Equals method to check whether this book object is equal to another book
   * object based on their values all matching.
   * @param  other the other book object to compare to
   * @return       true if equal, false if not.
   */
  public boolean equals(Book other)
  {
    return (super.equals(other) &&
            getAuthor().equals(other.getAuthor()) &&
            getNumPages() == other.getNumPages() &&
            getBindingType().equals(other.getBindingType()));
   }

  /**
   * Print method to export Book object's values to a file in exportLog directory
   * @param fileName  name of file to create and export data to.
   */
  public void print(String fileName)
  {
    super.print(fileName);

    if(fileName.indexOf(".txt") == -1)
    {
      fileName = fileName + ".txt";
    }

    try
    {
      File file = new File("exportLog/" + fileName);
      fileStream = new FileOutputStream(file, true);
      outFS = new PrintWriter(fileStream);
    }
    catch(IOException e)
    {
      System.out.println(e.toString());
      System.out.println("File Not Found: " + fileName);
    }

    outFS.print(toString());

    outFS.close();
  }
}
