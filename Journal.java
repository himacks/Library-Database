import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class Journal extends Publication
{
  private String editor;
  private int issueNum;
  private FileOutputStream fileStream;
  private PrintWriter outFS;


  public Journal(String editor, int issueNum, String title, int yearPub, String publisher, int isbn)
  {
    super(title, yearPub, publisher, isbn);

    this.editor = editor;
    this.issueNum = issueNum;

    fileStream = null;
    outFS = null;

  }

  public String getEditor()
  {
    return editor;
  }

  public int getIssueNum()
  {
    return issueNum;
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

    outFS.println("Editor: " + editor);
    outFS.println("Issue #: " + issueNum);

    outFS.close();
  }
}
