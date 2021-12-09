import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class EJournal extends Journal
{
  private String url;
  private int pubFee;
  private FileOutputStream fileStream;
  private PrintWriter outFS;


  public EJournal(String url, int pubFee, String editor, int issueNum, String title, int yearPub, String publisher, int isbn)
  {
    super(editor, issueNum, title, yearPub, publisher, isbn);

    this.url = url;
    this.pubFee = pubFee;

    fileStream = null;
    outFS = null;

  }

  public String getUrl()
  {
    return url;
  }

  public int getPubFee()
  {
    return pubFee;
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
      System.out.println("File Not Found " + fileName);
    }

    outFS.println("URL: " + url);
    outFS.println("Publication Fee: " + pubFee);

    outFS.close();
  }
}
