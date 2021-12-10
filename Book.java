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
public class Book extends Publication
{
  private String author;
  private int numPages;
  private String bindingType;
  private FileOutputStream fileStream;
  private PrintWriter outFS;

  public Book()
  {
    super();

    author = "";
    numPages = 0;
    bindingType = "";
    
    fileStream = null;
    outFS = null;
  }

  public Book(String author, int numPages, String bindingType, String title, int yearPub, String publisher, int isbn)
  {
    super(title, yearPub, publisher, isbn);
    this.author = author;
    this.numPages = numPages;
    this.bindingType = bindingType;

    fileStream = null;
    outFS = null;
  }

  public Book(Book other)
  {
    super(other);
    author = other.getAuthor();
    numPages = other.getNumPages();
    bindingType = other.getBindingType();
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String toSet)
  {
    author = toSet;
  }

  public int getNumPages()
  {
    return numPages;
  }

  public void setNumPages(int toSet)
  {
    numPages = toSet;
  }

  public String getBindingType()
  {
    return bindingType;
  }

  public void setBindingType(String toSet)
  {
    bindingType = toSet;
  }

  public String getType()
  {
    return "Book";
  }

  public String toString()
  {
    String bookString = "Publication Type: " + getType() + "\n" +
                        super.toString() +
                        "Author: " + getAuthor() + "\n" +
                        "# of Pages: " + getNumPages() + "\n" +
                        "Binding Type: " + getBindingType() + "\n";

    return bookString;
  }

  public boolean equals(Book other)
  {
    return (super.equals(other) &&
            getAuthor().equals(other.getAuthor()) &&
            getNumPages() == other.getNumPages() &&
            getBindingType().equals(other.getBindingType()));
   }

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
