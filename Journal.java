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
public class Journal extends Publication
{
  private String editor;
  private int issueNum;
  private FileOutputStream fileStream;
  private PrintWriter outFS;

  public Journal()
  {
    super();
    
    editor = "";
    issueNum = 0;

    fileStream = null;
    outFS = null;
  }

  public Journal(String editor, int issueNum, String title, int yearPub, String publisher, int isbn)
  {
    super(title, yearPub, publisher, isbn);

    this.editor = editor;
    this.issueNum = issueNum;

    fileStream = null;
    outFS = null;

  }

  public Journal(Journal other)
  {
    super(other);
    editor = other.getEditor();
    issueNum = other.getIssueNum();
  }

  public String getEditor()
  {
    return editor;
  }

  public void setEditor(String toSet)
  {
    editor = toSet;
  }

  public int getIssueNum()
  {
    return issueNum;
  }

  public void setIssueNum(int toSet)
  {
    issueNum = toSet;
  }

  public String getType()
  {
    return "Journal";
  }

  public String toString()
  {
    String journalString = "Publication Type: " + getType() + "\n" +
                           super.toString() +
                           "Editor: " + getEditor() + "\n" +
                           "Issue #: " + getIssueNum() + "\n";

    return journalString;
  }

  public boolean equals(Journal other)
  {
    return (super.equals(other) &&
            getIssueNum() == other.getIssueNum() &&
            getEditor().equals(other.getEditor()));
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

    outFS.print(toString());

    outFS.close();
  }
}
