/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;

/**
 * @umplesource Util_Code.ump 836
 */
// line 836 "../../../../src/Util_Code.ump"
public class DeleteLanguage
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static DeleteLanguage theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private DeleteLanguage()
  {}

  public static DeleteLanguage getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new DeleteLanguage();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

}