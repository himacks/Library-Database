import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class Book extends Publication
{
  private String author;
  private int numPages;
  private String bindingType;
  private FileOutputStream fileStream;
  private PrintWriter outFS;


  public Book(String author, int numPages, String bindingType, String title, int yearPub, String publisher, int isbn)
  {
    super(title, yearPub, publisher, isbn);
    this.author = author;
    this.numPages = numPages;
    this.bindingType = bindingType;

    fileStream = null;
    outFS = null;
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

    outFS.println("Author: " + author);
    outFS.println("# of Pages: " + numPages);
    outFS.println("Binding Type: " + bindingType);

    outFS.close();
  }
}
