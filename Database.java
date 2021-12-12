import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;


/**
 * Maxim Karpinsky
 * ID: 2405869
 * email: karpinsky@chapman.edu
 * Course: CPSC 231
 * Assignment: Programming Mastery Project 4: Library Database
 */

/**
 * Database class to create a Library Database to store publications along
 * with an interface for ease of Database use.
 */
public class Database
{

  /**
   * Static method to handle when user is prompted for a integer response to
   * a question. Keeps asking question until a valid integer is given,
   * this essentially catches errors when a user tries to use incompatible data
   * types for int parameters.
   * @param  askMessage         Message to ask the user
   * @param  errorMessage       Error message to give user when incompatible
   *                            type is given.
   * @param  scan               Scanner object
   * @return              the user's response to a question
   */
  public static int handleInt(String askMessage, String errorMessage, Scanner scan)
  {
    int value = -1;
    while(value == -1)
    {
      System.out.print(askMessage);
      try
      {
        value = Integer.parseInt(scan.nextLine());
      }
      catch(NumberFormatException e)
      {
        System.out.println(errorMessage);
      }
    }

    return value;
  }

  /**
   * Main method to create a database and user interface to access databse.
   * @param args
   */
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);

    HashMap<Integer, Publication> database = new HashMap<Integer, Publication>();

    String userChoice = null;

    /**
     * Testing zone, commented out lines that affect database for submission
     **/

     Book testBook = new Book("test", 42, "hardbook", "test book", 1999, "tester inc.", 12345);
     //database.put(testBook.getIsbn(), testBook);
     Book testBook2 = new Book("test", 42, "hardbook", "test book", 1999, "tester inc.", 12345);
     Book testBook3 = new Book("test", 21, "paperbook", "test book 2", 2021, "tester inc.", 13246);
     Book testBook4 = new Book(testBook3);
     //System.out.println(testBook.equals(testBook2));
     //System.out.println(testBook.equals(testBook3));

     Journal testJournal = new Journal("editor", 123, "test journal", 1999, "tester inc.", 12347);
     //database.put(testJournal.getIsbn(), testJournal);
     Journal testJournal2 = new Journal("editor", 123, "test journal", 1999, "tester inc.", 12357);
     Journal testJournal3 = new Journal("editor", 346, "test journal", 2355, "tester inc.", 12347);
     Journal testJournal4 = new Journal(testJournal3);
     //System.out.println(testJournal.equals(testJournal2));
     //System.out.println(testJournal.equals(testJournal3));

     EJournal testEJournal = new EJournal("url.com", 423, "editor", 123, "test ejournal", 1999, "tester inc.", 12348);
     //database.put(testEJournal.getIsbn(), testEJournal);
     EJournal testEJournal2 = new EJournal("url.com", 423, "editor", 123, "test ejournal", 1999, "tester inc.", 12348);
     EJournal testEJournal3 = new EJournal("url.com", 423, "editor", 346, "test ejournal", 2355, "tester inc.", 12348);
     EJournal testEjournal4 = new EJournal(testEJournal3);
     //System.out.println(testEJournal.equals(testEJournal2));
     //System.out.println(testEJournal.equals(testEJournal3));



     /**
      * End Testing Zone
      */

    /**
     * Creates while loop to keep asking user database options until they
     * quit the database.
     */
    do
    {
      System.out.println("1 - Create a publication");
      System.out.println("2 - Export publication to file");
      System.out.println("3 - List all publications");
      System.out.println("4 - Delete a publication from the database");
      System.out.println("5 - Quit");
      System.out.println();

      System.out.print("Enter a key: ");
      userChoice = scan.nextLine();
      System.out.println();

      switch(userChoice)
      {

        /**
         * Case for when user wants to create a new publication
         */
        case "1":

          String pubTitle = null;
          String publisher = null;
          int pubYear = -1;
          int isbn = -1;

          String author = null;
          String bindType = null;
          int numPages = -1;

          String editor = null;
          int issueNum = -1;

          String url = null;
          int pubFee = -1;

          /**
           * First asks for generic publication data, because all publication
           * will have this regardless of type, then moves on to specific
           * publication.
           */

          System.out.println("Entering general publication data... You will be able to select the publication type after.");
          System.out.println();

          System.out.print("Publication Title: ");
          pubTitle = scan.nextLine();

          pubYear = handleInt("Publication Year: ", "Enter a valid year!", scan);

          System.out.print("Publisher: ");
          publisher = scan.nextLine();

          isbn = handleInt("ISBN: ", "Enter a valid ISBN!", scan);

          String pubChoice = null;

          boolean validChoice = true;

          System.out.println();

          /**
           * Creates a while loop until user selects and fills data for a
           * specific publication type.
           */
          do
          {
            validChoice = true;
            System.out.println("1 - Create a Book Entry");
            System.out.println("2 - Create a Journal Entry");
            System.out.println("3 - Create a E-Journal Entry");
            System.out.println();

            System.out.print("Enter a key: ");
            pubChoice = scan.nextLine();
            System.out.println();

            switch(pubChoice)
            {
              /**
               * Case for creating a Book Entry
               */
              case "1":

                System.out.print("Author: ");
                author = scan.nextLine();

                numPages = handleInt("# of Pages: ", "Enter a valid # of pages!", scan);

                System.out.print("Binding Type: ");
                bindType = scan.nextLine();

                break;

              /**
               * Case for creating a Journal entry
               */
              case "2":

                System.out.print("Editor: ");
                editor = scan.nextLine();

                issueNum = handleInt("Issue #: ", "Enter a valid Issue #!", scan);

                break;
              /**
               * Case for creating a EJournal entry
               */
              case "3":

                System.out.print("Editor: ");
                editor = scan.nextLine();

                issueNum = handleInt("Issue #: ", "Enter a valid Issue #!", scan);

                System.out.print("URL: ");
                url = scan.nextLine();

                pubFee = handleInt("Publication Fee: ", "Enter a valid Publication Fee!", scan);

                break;
              /**
               * Repeats loop if invalid choice is inputted.
               */
              default:
                System.out.println("Invalid Choice.");
                validChoice = false;
                break;
            }

            System.out.println();
          }
          while (!validChoice);

          /**
           * Creates publication based on final case before while loop exited.
           */
          if(pubChoice.equals("1"))
          {
            Book newBook = new Book(author, numPages, bindType, pubTitle, pubYear, publisher, isbn);
            database.put(newBook.getIsbn(), newBook);
          }
          else if(pubChoice.equals("2"))
          {
            Journal newJournal = new Journal(editor, issueNum, pubTitle, pubYear, publisher, isbn);
            database.put(newJournal.getIsbn(), newJournal);
          }
          else if (pubChoice.equals("3"))
          {
            EJournal newEJournal = new EJournal(url, pubFee, editor, issueNum, pubTitle, pubYear, publisher, isbn);
            database.put(newEJournal.getIsbn(), newEJournal);
          }

          System.out.println("Success! Added to Database!");

          System.out.println();

          break;
        /**
         * Case to export a specific publication object in database to file.
         */
        case "2":

          System.out.print("File name to export to: ");
          String fileName = scan.nextLine();

          int pulledISBN = handleInt("ISBN of the Publication: ", "Enter a valid ISBN!", scan);

          /**
           * Tries to fetch publication object based on ISBN, if one not
           * found catches a NullPointerException and tells user wasn't able
           * to find.
           */
          try
          {
            database.get(pulledISBN).print(fileName);
            System.out.println("Successfully exported!");
          }
          catch(NullPointerException e)
          {
            System.out.println();
            System.out.println("Could not find entry with that ISBN");
          }

          System.out.println();

          break;
        /**
         * Case for when user tries to list all Publication objects in database
         */
        case "3":
          List<Publication> sortedList = new LinkedList<Publication>(database.values());
          Collections.sort(sortedList);

          System.out.println("Here's all the publications in the database!");

          if(sortedList.size() == 0)
          {
            System.out.println("Empty!");
          }
          else
          {
            for(Publication item : sortedList)
            {
              System.out.println(item.getYearPub() + " - " + item.getTitle());
            }
          }


          System.out.println();

          break;
        /**
         * Case for when user wants to delete a publication object from the
         * database.
         */
        case "4":

          int isbnDel = handleInt("Publication to Delete ISBN value: ", "Enter a valid ISBN!", scan);

          Publication removedPub = database.remove(isbnDel);

          if (removedPub == null)
          {
            System.out.println("Could not find publication with that ISBN");
          }
          else
          {
            System.out.println("Successfully removed publication!");
          }

          System.out.println();

          break;
        /**
         * Case when user wants to exit the database.
         */
        case "5":
          System.out.println("Exiting Database.");
          break;
        /**
         * default case when user selects an invalid choice, repeats loop.
         */
        default:
          System.out.println("Invalid Choice.");
          break;
      }

    }
    while(!userChoice.equals("5"));
  }
}
