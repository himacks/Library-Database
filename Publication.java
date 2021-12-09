import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public abstract class Publication implements Comparable<Publication>, Printable
{
  private String title;
  private int yearPub;
  private String publisher;
  private int isbn;
  private FileOutputStream fileStream;
  private PrintWriter outFS;

  public Publication(String title, int yearPub, String publisher, int isbn)
  {
    this.title = title;
    this.yearPub = yearPub;
    this.publisher = publisher;
    this.isbn = isbn;

    fileStream = null;
    outFS = null;
  }

  public String getTitle()
  {
    return title;
  }

  public int getYearPub()
  {
    return yearPub;
  }

  public String getPublisher()
  {
    return publisher;
  }

  public int getIsbn()
  {
    return isbn;
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
      outFS = new PrintWriter(fileStream);
    }
    catch(IOException e)
    {
      System.out.println(e.toString());
      System.out.println("File Not Found " + fileName);
    }

    outFS.println("Publication Title: " + getTitle());
    outFS.println("Publication Year: " + getYearPub());
    outFS.println("Publisher: " + getPublisher());
    outFS.println("ISBN: " + getIsbn());

    outFS.close();
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
