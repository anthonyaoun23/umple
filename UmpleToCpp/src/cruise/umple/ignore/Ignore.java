package cruise.umple.ignore;

public class Ignore
{
  protected static String nl;
  public static synchronized Ignore create(String lineSeparator)
  {
    nl = lineSeparator;
    Ignore result = new Ignore();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
{
  //==== Tracing Code    
  if( model.getTraceType().equals("File") && uClass.hasTraceDirectives() )
  {
    appendln(stringBuffer, "");
	appendln(stringBuffer, "  //------------------------");
	appendln(stringBuffer, "  // FILE TRACER METHOD");
	appendln(stringBuffer, "  //------------------------\n");
	appendln(stringBuffer, "  {0}::fileTracer(Object obj)",uClass.getName());
	appendln(stringBuffer, "  {");
	appendln(stringBuffer, "      // Create and Open an output stream");
	appendln(stringBuffer, "    ofstream fout;");
	appendln(stringBuffer, "    time_t rawTime; // for timestamp");
	appendln(stringBuffer, "    try");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      // Create and Open an output stream");
	appendln(stringBuffer, "      fout.open(\"TraceLog.txt\")");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "    catch (exception& e)");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      cout<<\"Unable to write to file due to:\"<<e.what()<<endl;");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "    // Write traced Item information");
	appendln(stringBuffer, "    fout<<obj;");
	appendln(stringBuffer, "    try");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      // Close output stream");
	appendln(stringBuffer, "      fout.close();");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "    catch (exception& e)");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      fout<<e.what()<<endl;");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "  }");
  }
  
  isFirst = true;
  for( TraceDirective td : uClass.getTraceDirectives() )
  {
    for( Attribute_TraceItem traceAttr : td.getAttributeTraceItems() )
    {
      if( traceAttr.getPeriodClause() != null )
      {
    	if( isFirst )
    	{
          appendln(stringBuffer, "");
      	  appendln(stringBuffer, "  //------------------------");
      	  appendln(stringBuffer, "  // TRACING METHOD(s)");
      	  appendln(stringBuffer, "  //------------------------\n");
      	  isFirst = false;
    	}
    	for( Attribute attr : traceAttr.getAttributes() )
    	{
    	  String attrName = attr.getName();
    	  attrName = attrName.substring(0,1).toUpperCase()+attrName.substring(1).toLowerCase();
          appendln(stringBuffer, "  private void trace{0}Period(final int period)",attrName); 	
          appendln(stringBuffer, "  {");
          appendln(stringBuffer, "    ( new Thread()");
          appendln(stringBuffer, "    {");
          appendln(stringBuffer, "      public void run()");
          appendln(stringBuffer, "      {");
          appendln(stringBuffer, "         while( true )");
          appendln(stringBuffer, "         {");
          appendln(stringBuffer, "           Date date = new Date();");
          appendln(stringBuffer, "           System.err.println(\"{0}=\"+{1} +\", t =\"+date.toString());",attrName,attr.getName());
          appendln(stringBuffer, "           try");
          appendln(stringBuffer, "           {Thread.sleep(period);}");
          appendln(stringBuffer, "           catch (InterruptedException e)");
          appendln(stringBuffer, "           {e.printStackTrace();}");
          appendln(stringBuffer, "         }");
          appendln(stringBuffer, "      }");
          appendln(stringBuffer, "    }");
          appendln(stringBuffer, "    ).start();");
          appendln(stringBuffer, "  }");
    	}
      }
    }
  }
}

    return stringBuffer.toString();
  }
}
