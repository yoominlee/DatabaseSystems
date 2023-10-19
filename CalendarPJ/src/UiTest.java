import javax.swing.*;
import java.awt.*;


public class UiTest {
    public static void main(String[] args) {
        Dimension dim = new Dimension(840,450);

        JFrame frame = new JFrame("calendar");
        frame.setLocation(200,200);
        frame.setPreferredSize(dim);

        // String header[] = {"name","event","start","end"};
        // String contents[][] = {
        //     {"yoom","school","2023/03/02","2023/07/20"},
        //     {"anh","lunch","2023/03/01","2023/03/01"},
        //     {"jack","school","2023/03/02","2023/07/20"}
        // };


        String header[] = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
        String contents[][] = {
            {"","1","2","3","4","5","6"},{"","","","","","",""},
            {"7","8","9","10","11","12","13"},{"","","","","","",""},
            {"14","15","16","17","18","19","20"},{"","","","","","",""},
            {"21","22","23","24","25","26","27"},{"","","","","","",""},
            {"28","29","30","31","","",""},{"","","","","","",""}
        };

        // sample button
        JButton btn = new JButton("Yoom-BDAY");
        btn.setLocation(240, 90);
        btn.setSize(115, 20);
        frame.add(btn);

        JTable table = new JTable(contents, header);
        for(int i=0;i<10; i++){
            if(i%2==0){
                table.setRowHeight(i,17); // not the content size, fixed height
            }else{
                table.setRowHeight(i,65);
            }
        }
        JScrollPane scrollpane = new JScrollPane(table);
        frame.add(scrollpane);
        frame.pack();
        frame.setVisible(true);

        // TODO LIST
        /*
         * date align (left center) -> (left top)
         * make evert to button? -> date too?
         * 
         */

    }
}
