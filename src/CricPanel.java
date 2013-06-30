import nu.xom.*;
import javax.swing.*;
import java.io.*;

public class CricPanel extends JPanel  {
    public String[] title = new String[15];
    public String[] link = new String[15];
    public int count = 0;
    
    public CricPanel() {
        try {
            // retrieve the XML document
            Builder builder = new Builder();
            Document doc = builder.build("http://static.cricinfo.com/rss/livescores.xml");
            // retrieve the document's root element
            Element root = doc.getRootElement();
            // retrieve the root's channel element
            Element channel = root.getFirstChildElement("channel");
            // retrieve the item elements in the channel
            if (channel != null) {
                Elements items = channel.getChildElements("item");
                for (int current = 0; current < items.size(); current++) {
                    if (count > 15) {
                        break;
                    }
                    // retrieve the current item
                    Element item = items.get(current);
                    Element titleElement = item.getFirstChildElement("title");
                    Element linkElement = item.getFirstChildElement("link");
                    title[current] = titleElement.getValue();
                    link[current] = linkElement.getValue();
                    count++;
                }
            }   
        } catch (ParsingException exception) {
            System.out.println("XML error: " + exception.getMessage());
            exception.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("IO error: " + ioException.getMessage());
            ioException.printStackTrace();
        }
        
        //JPanel scorePanel=new JPanel();
        JLabel[] scoreLabel=new JLabel[3];
        String scr=getScores();
        JTextArea scoreCard=new JTextArea(scr,10,22);
        /*for(int i=0;i<5;i++) {
            scoreLabel[i]=new JLabel(title[i]);
            scorePanel.add(scoreLabel[i]);
            
        }*/
        scoreCard.setEditable(false);
        add(scoreCard);
        
            
       }
    public String getScores() {
        String score="";
        for(int i=0;i<15;i++) {
            if(title[i]!=null) {
            score="\n\n"+title[i];
         }
        }
       return score;   
    }
}