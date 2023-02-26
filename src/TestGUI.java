import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestGUI extends JFrame {

    private JLabel questionLabel = new JLabel();
    private JRadioButton radioButton[] = new JRadioButton[5];
    private JButton nextBtn = new JButton("Далі");
    private JPanel radioPanel = new JPanel();
    private JPanel labelPanel = new JPanel();
    private JPanel btnPanel = new JPanel();
    public ArrayList<Integer> list = new ArrayList<>();
    private int currentQuestion = 0; private int correct = 0; private int invalid = 0;

    public TestGUI()
    {
        setSize(500,500); setResizable(false); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLocationRelativeTo(null);
        radioPanel.setLayout(new GridLayout(0,1,0,0)); radioPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        questionLabel.setFont(new Font("Arial", Font.BOLD, 40));
        labelPanel.add(questionLabel); labelPanel.setBackground(Color.pink);
        ButtonGroup buttonGroup = new ButtonGroup();
        for(int i = 0; i < 5; i++)
        {
            radioButton[i] = new JRadioButton();
            radioPanel.add(radioButton[i]);
            buttonGroup.add(radioButton[i]);
        }
        Set();
        add(labelPanel, BorderLayout.NORTH);
        add(radioPanel, BorderLayout.CENTER);

        btnPanel.setLayout(new FlowLayout()); btnPanel.add(nextBtn);
        add(btnPanel, BorderLayout.SOUTH);

        nextBtn.addActionListener(new NextBtnActionListener());
        setVisible(true);
    }
    void Set()
    {
        if(currentQuestion == 0)
        {
            questionLabel.setText("15 * 15");
            radioButton[0].setText("215"); radioButton[1].setText("100");
            radioButton[2].setText("225"); radioButton[3].setText("230");
            radioButton[4].setText("200");
        }
        if(currentQuestion == 1)
        {
            questionLabel.setText("10 - 3");
            radioButton[0].setText("1"); radioButton[1].setText("3");
            radioButton[2].setText("2"); radioButton[3].setText("10");
            radioButton[4].setText("7");
        }
        if(currentQuestion == 2)
        {
            questionLabel.setText("9 * 7");
            radioButton[0].setText("54"); radioButton[1].setText("25");
            radioButton[2].setText("60"); radioButton[3].setText("63");
            radioButton[4].setText("82");
        }
        if(currentQuestion == 3)
        {
            questionLabel.setText("10 * 7");
            radioButton[0].setText("54"); radioButton[1].setText("25");
            radioButton[2].setText("70"); radioButton[3].setText("33");
            radioButton[4].setText("100");
        }
        if(currentQuestion == 4)
        {
            questionLabel.setText("10 * 7 * (9 + 3)");
            radioButton[0].setText("800"); radioButton[1].setText("550");
            radioButton[2].setText("840"); radioButton[3].setText("888");
            radioButton[4].setText("921");
        }
        if(currentQuestion == 5)
        {
            questionLabel.setText("100 - 50 + 2");
            radioButton[0].setText("40"); radioButton[1].setText("48");
            radioButton[2].setText("49"); radioButton[3].setText("70");
            radioButton[4].setText("52"); nextBtn.setText("Завершити");
        }
    }
    boolean checkAnswer()
    {
        if(currentQuestion == 0)
        {
            return radioButton[2].isSelected();
        }
        if(currentQuestion == 1)
        {
            return radioButton[4].isSelected();
        }
        if(currentQuestion == 2)
        {
            return radioButton[3].isSelected();
        }
        if(currentQuestion == 3)
        {
            return radioButton[2].isSelected();
        }
        if(currentQuestion == 4)
        {
            return radioButton[2].isSelected();
        }
        if(currentQuestion == 5)
        {
            return radioButton[1].isSelected();
        }
        return false;
    }
    class NextBtnActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean r1 = radioButton[0].isSelected(); boolean r2 = radioButton[1].isSelected();
            boolean r3 = radioButton[2].isSelected(); boolean r4 = radioButton[3].isSelected();
            boolean r5 = radioButton[4].isSelected();
            if(!r1 && !r2 && !r3 && !r4 && !r5)
            {
                JOptionPane.showMessageDialog(null, "Ви нічого не вибрали!", "", JOptionPane.ERROR_MESSAGE);
            }
            else {
                if(checkAnswer()) {
                    list.add(5);
                    correct++;
                    currentQuestion++;
                    Set();
                }
                else
                {
                    list.add(2);
                    invalid++;
                    currentQuestion++;
                    Set();
                }
                if(currentQuestion == 6)
                {
                    //int correct_result = correct * 5; int invalid_result = invalid * 2;
                    //int suma = correct_result + invalid_result; float result = suma / (correct + invalid);
                    int suma = 0; float result = 0;
                    for(int i = 0; i < list.size(); i++)
                    {
                        suma += list.get(i);
                    }
                    result = suma / list.size();
                    String msg = "Кількість правильних відповідей - " + correct + "\n" + "Ваш результат - " + result;
                    JOptionPane.showMessageDialog(null, msg, "", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }
    }
}
