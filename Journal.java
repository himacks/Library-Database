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
  * Child class of Publication, allows for creation of Journal publication
  */
public class Journal extends Publication
{
  private String editor;
  private int issueNum;
  private FileOutputStream fileStream;
  private PrintWriter outFS;

  /**
   * Default constructor for Journal which creates generic object with no data.
   */
  public Journal()
  {
    super();

    editor = "";
    issueNum = 0;

    fileStream = null;
    outFS = null;
  }

  /**
   * Overloaded constructor for Journal class
   * @param editor     Editor of journal
   * @param issueNum   The issue number
   * @param title      Title of Publication
   * @param yearPub    Year Published
   * @param publisher  The Publisher name
   * @param isbn       ISBN value
   */
  public Journal(String editor, int issueNum, String title, int yearPub, String publisher, int isbn)
  {
    super(title, yearPub, publisher, isbn);

    this.editor = editor;
    this.issueNum = issueNum;

    fileStream = null;
    outFS = null;

  }

  /**
   * Copy constructor for Journal class
   * @param other  other Journal object to copy data from.
   */
  public Journal(Journal other)
  {
    super(other);
    editor = other.getEditor();
    issueNum = other.getIssueNum();
  }

  /**
   * Get method to get the editor of journal
   * @return the editor
   */
  public String getEditor()
  {
    return editor;
  }

  /**
   * Set method to set the editor of journal
   * @param toSet  editor name to set to
   */
  public void setEditor(String toSet)
  {
    editor = toSet;
  }

  /**
   * Get method to get the journal's issue number
   * @return The issue number
   */
  public int getIssueNum()
  {
    return issueNum;
  }

  /**
   * Set method to set the journal's issue number
   * @param toSet  issue number to set to
   */
  public void setIssueNum(int toSet)
  {
    issueNum = toSet;
  }

  /**
   * Gets the publication type, Journal
   * @return String value of publication type
   */
  public String getType()
  {
    return "Journal";
  }

  /**
   * Method to return string representation of Journal object with all unique
   * data.
   * @return string representation of Journal
   */
  public String toString()
  {
    String journalString = "Publication Type: " + getType() + "\n" +
                           super.toString() +
                           "Editor: " + getEditor() + "\n" +
                           "Issue #: " + getIssueNum() + "\n";

    return journalString;
  }

  /**
   * Equals method to check whether this journal object is equal to another
   * journal object based on if all their values match.
   * @param  other               other journal object to compare to.
   * @return       true whether object values are equals, false otherwise.
   */
  public boolean equals(Journal other)
  {
    return (super.equals(other) &&
            getIssueNum() == other.getIssueNum() &&
            getEditor().equals(other.getEditor()));
  }


  /**
   * Export method to export all data of Journal Object to specified file
   * @param fileName  file name to export to
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
      System.out.println("File Not Found " + fileName);
    }

    outFS.print(toString());

    outFS.close();
  }
}
