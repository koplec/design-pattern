package tablefactory;

import factory.Item;
import factory.Tray;

public class TableTray extends Tray{
    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer sb = new StringBuffer();
        sb.append("<td>");
        sb.append("<table width=\"100%\" border=\"1\">");
        sb.append("<tr>\n");
        sb.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" 
        + tray.size() 
        + "\"><b>" 
        + caption + "</b></td>");
        sb.append("</tr>\n");

        sb.append("<tr>\n");
        for(Item o : tray){
            sb.append(o.makeHTML());
        }

        sb.append("</tr>\n");
        sb.append("</table>");
        sb.append("</td>");

        return sb.toString();
    }
    
}
