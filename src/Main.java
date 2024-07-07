import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Main extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public  static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (Throwable e){
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        });
    }
    public Main() {
        setTitle("用List集合传递学生信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 392, 223);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(getTable());
    }
    private JTable getTable() {
        if (table == null) {
            table = new JTable();
            table.setRowHeight(23);
            String[] columns = {"姓名", "性别", "出生日期"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            table.setModel(model);
            List<String> students = getStudents();
            for (String info : students){
                String[] args = info.split(",");
                model.addRow(args);
            }
        }
        return table;
    }
    private List<String> getStudents() {
        List<String> list = new java.util.ArrayList<>();
        list.add("张三,男,1990-01-01");
        list.add("李四,女,1991-02-02");
        list.add("王五,男,1992-03-03");
        list.add("赵六,女,1993-04-04");
        list.add("孙七,男,1994-05-05");
        return list;
    }
}