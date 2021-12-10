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
public class EJournal extends Journal
{
  private String url;
  private int pubFee;

  public EJournal()
  {
    super();

    url = "";
    pubFee = 0;
  }

  public EJournal(String url, int pubFee, String editor, int issueNum, String title, int yearPub, String publisher, int isbn)
  {
    super(editor, issueNum, title, yearPub, publisher, isbn);

    this.url = url;
    this.pubFee = pubFee;

  }

  public EJournal(EJournal other)
  {
    super(other);
    url = other.getUrl();
    pubFee = other.getPubFee();
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String toSet)
  {
    url = toSet;
  }

  public int getPubFee()
  {
    return pubFee;
  }

  public void setPubFee(int toSet)
  {
    pubFee = toSet;
  }

  public String getType()
  {
    return "EJournal";
  }

  public String toString()
  {
    String ejournalString = super.toString() +
                     "URL: " + getUrl() + "\n" +
                     "Publication Fee: " + getPubFee() + "\n";

    return ejournalString;
  }

  public boolean equals(EJournal other)
  {
    return(super.equals(other) &&
           getUrl().equals(other.getUrl()) &&
           getPubFee() == other.getPubFee());
  }

  public void print(String fileName)
  {
    super.print(fileName);
  }
}
