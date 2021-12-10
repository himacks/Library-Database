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
public abstract class Publication implements Comparable<Publication>, Printable
{
  private String title;
  private int yearPub;
  private String publisher;
  private int isbn;
  private FileOutputStream fileStream;

  public Publication()
  {
    title = "";
    yearPub = 0;
    publisher = "";
    isbn = 0;

    fileStream = null;
  }

  public Publication(String title, int yearPub, String publisher, int isbn)
  {
    this.title = title;
    this.yearPub = yearPub;
    this.publisher = publisher;
    this.isbn = isbn;

    fileStream = null;
  }

  public Publication(Publication other)
  {
    title = other.getTitle();
    yearPub = other.getYearPub();
    publisher = other.getPublisher();
    isbn = other.getIsbn();
  }

  public String getTitle()
  {
    return title;
  }
  public void setTitle(String toSet)
  {
    title = toSet;
  }

  public int getYearPub()
  {
    return yearPub;
  }

  public void setYearPub(int toSet)
  {
    yearPub = toSet;
  }

  public String getPublisher()
  {
    return publisher;
  }

  public void setPublisher(String toSet)
  {
    publisher = toSet;
  }

  public int getIsbn()
  {
    return isbn;
  }

  public void setIsbn(int toSet)
  {
    isbn = toSet;
  }

  public String toString()
  {
    String publicationString = "Publication Title: " + getTitle() + "\n" +
                               "Publication Year: " + getYearPub() + "\n" +
                               "Publisher: " + getPublisher() + "\n" +
                               "ISBN: " + getIsbn() + "\n";

    return publicationString;
  }

  public boolean equals(Publication other)
  {
    return(getTitle().equals(other.getTitle()) &&
           getYearPub() == other.getYearPub() &&
           getPublisher().equals(other.getPublisher()) &&
           getIsbn() == other.getIsbn());
  }

  public void print(String fileName)
  {

    if(fileName.indexOf(".txt") == -1)
    {
      fileName = fileName + ".txt";
    }

    try
    {
      File dir = new File("exportLog/");
      if(!dir.exists())
      {
        dir.mkdir();
      }

      File file = new File("exportLog/" + fileName);
      fileStream = new FileOutputStream(file);

    }
    catch(IOException e)
    {
      System.out.println(e.toString());
      System.out.println("File Not Found " + fileName);
    }
  }

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
