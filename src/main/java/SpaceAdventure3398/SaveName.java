import javax.swing.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SaveName
{
	String name;
	public void nameInput() 
     	{
		
	        name = JOptionPane.showInputDialog("Enter Name");
		
		
	        /*JFileChooser chooser = new JFileChooser();
        	chooser.setCurrentDirectory( new File( "./") );
	        int actionDialog = chooser.showSaveDialog(null); //show dialogue
        	if (actionDialog == JFileChooser.APPROVE_OPTION)
        	{
            		File fileName = new File(chooser.getSelectedFile( ) + ".txt" );
            			if(fileName == null)
               	 		return;
            		if(fileName.exists()) //Check for existing file name
            		{
                		actionDialog = JOptionPane.showConfirmDialog(null,
                        	           "Replace existing file?");
                	if (actionDialog == JOptionPane.NO_OPTION) 
                    		return;
            		}
            		try
            		{
                	    BufferedWriter out = new BufferedWriter(new FileWriter(fileName)); 

	                    out.write(name);
        	            out.close();  
            		}
            		catch(Exception ex)
            		{
             	   	    System.err.println("Error: " + ex.getMessage());
            		}
       		}*/
      	}
	
	public String getName() {
		return name;
	}
}