import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FourOperations extends JFrame implements ActionListener {

    private JTextField name1text,name2text;
    private JRadioButton jrb1, jrb2,jrb3, jrb4,jrb5, jrb6,jrb7, jrb8,jrb9, jrb10;
    private int max = 10;
    private int num = 1;
    private JButton bu,bu1;
    private int style = 0;
    private Operation[] t = new Operation[10000];
    private int I_Con = 1;
    public FourOperations()
    {
        JFrame frame =new JFrame();
        frame.setTitle("四则运算生成器");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);

        FlowLayout f1=new FlowLayout(FlowLayout.LEFT);
        frame.setLayout(f1);

        JLabel name1=new JLabel("请输入题目数量：");
        frame.add(name1);

        name1text = new JTextField(10);//文本框
        name1text.setEditable(true);
        name1text.setPreferredSize(new Dimension(50, 30));
        name1text.addActionListener(this);
        frame.add(name1text);

        JLabel name=new JLabel();//空
        name.setPreferredSize(new Dimension(750,30));
        frame.add(name);


        JLabel name2=new JLabel("请输入题目的最大值：");
        frame.add(name2);

        name2text = new JTextField(10);//文本框
        name2text.setEditable(true);
        name2text.setPreferredSize(new Dimension(50, 30));
        name2text.addActionListener(this);
        frame.add(name2text);

        JLabel name10=new JLabel();//空
        name10.setPreferredSize(new Dimension(750,30));
        frame.add(name10);


        JLabel name9=new JLabel("选择题目中出现的运算符");
        frame.add(name9);


        jrb7 = new JRadioButton("加");
        jrb8 = new JRadioButton("减");
        jrb9 = new JRadioButton("乘");
        jrb10 = new JRadioButton("除");
        frame.add(jrb7);
        frame.add(jrb8);
        frame.add(jrb9);
        frame.add(jrb10);
        jrb7.addActionListener(this);
        jrb8.addActionListener(this);
        jrb9.addActionListener(this);
        jrb10.addActionListener(this);

        JLabel name7=new JLabel("是否加入小数点");
        frame.add(name7);

        jrb3 = new JRadioButton("是");
        jrb4 = new JRadioButton("否");
        frame.add(jrb3);
        frame.add(jrb4);
        jrb3.addActionListener(this);
        jrb4.addActionListener(this);

        JLabel name11=new JLabel();//空
        name11.setPreferredSize(new Dimension(200,30));
        frame.add(name11);

        JLabel name8=new JLabel("是否需要加入多目运算");
        frame.add(name8);

        jrb5 = new JRadioButton("Y");
        jrb6 = new JRadioButton("N");
        frame.add(jrb5);
        frame.add(jrb6);
        jrb5.addActionListener(this);
        jrb6.addActionListener(this);

        JLabel name12=new JLabel();//空
        name12.setPreferredSize(new Dimension(100,30));
        frame.add(name12);

        JLabel name4=new JLabel("输出到文本或者是打印机：");
        frame.add(name4);

        jrb1 = new JRadioButton("文本");
        jrb2 = new JRadioButton("打印机");
        frame.add(jrb1);
        frame.add(jrb2);
        jrb1.addActionListener(this);
        jrb2.addActionListener(this);


        JLabel name5=new JLabel();//空
        name5.setPreferredSize(new Dimension(440,30));
        frame.add(name5);


        bu=new JButton("生成");
        bu.setPreferredSize(new Dimension(80,30));
        bu.addActionListener(this);
        frame.add(bu);

        JLabel name15=new JLabel();//空
        name15.setPreferredSize(new Dimension(440,30));
        frame.add(name15);

        bu1=new JButton("打印");
        bu1.setPreferredSize(new Dimension(80,30));
        bu1.addActionListener(this);
        frame.add(bu1);

        JLabel name3=new JLabel();//空
        name3.setPreferredSize(new Dimension(50,30));
        frame.add(name3);


        frame.setVisible(true);


    }

    public void Button_Creat_Test()
    {
        if (style==0)
        {
            JOptionPane.showMessageDialog(this, "请选择运算符号");
            return;
        }
        if (style==16||style==32)
        {
            if (style==16)
                JOptionPane.showMessageDialog(this, "(只选择了括号)"
                        + "请选择四则运算符号");
            if (style==32)
                JOptionPane.showMessageDialog(this, "(只选择了小数)"
                        + "请选择四则运算符号");
            return;
        }

        JOptionPane.showMessageDialog(this, "生成新的题目");
        for (int i=0;i<num;i++)
        {

            t[i]=new Operation(max,style);
            t[i].Creat();
        }
        I_Con++;
    }

    public  void Print() throws Exception{
        File file = new File("F:\\1\\Test.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        Writer out = new FileWriter(file);
        for (int i=0;i<num;i++)
        {

            out.write(t[i].QuiZ);
            out.write("\r\n");
        }
        out.close();
        JOptionPane.showMessageDialog(this, "打印成功,文件保存至F:java");
    }


    public void actionPerformed(ActionEvent ev)
    {
        if (ev.getSource()==this.bu)
        {
            Button_Creat_Test();//
            try {
                Print();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



        if (ev.getSource()instanceof JRadioButton)
        {
            num = Integer.parseInt(name1text.getText());
            max = Integer.parseInt(name2text.getText());
            if (ev.getActionCommand().equals("加")) style=style^1;
            if (ev.getActionCommand().equals("减")) style=style^2;
            if (ev.getActionCommand().equals("乘")) style=style^4;
            if (ev.getActionCommand().equals("除")) style=style^8;
            if (ev.getActionCommand().equals("")) style=style^16;
            if (ev.getActionCommand().equals("是")) style=style^32;
        }



    }

    public static void main(String args[])
    {
        new FourOperations();
    }
}

class Operation {
    private int max,Brackets,Decimal;
    private double[] Num_Con=new double[10],shu_new=new double[10];
    public String symbol=" ",QuiZ,symbol_sel,Symbol_Con=" ",symbol_new=" ";

    public Operation(int Max,int tyle)
    {
        max=Max;
        if ((tyle & 1)==1) symbol=symbol+"+";
        if ((tyle & 2)==2) symbol=symbol+"-";
        if ((tyle & 4)==4) symbol=symbol+"*";
        if ((tyle & 8)==8) symbol=symbol+"/";
        if ((tyle & 16)==16) Brackets=1;
        if ((tyle & 32)==32) Decimal=1;
    }


    public void Creat()
    {
        Num_Con[0]=getnum();
        for(int i=1;i<=(int)(Math.random()*3)+1;i++)
        {
            Num_Con[i]=getnum();
            getchar();
            Symbol_Con=Symbol_Con+symbol_sel;
        }
        Creat_File();
        Display();
        QuiZ=QuiZ+"=";
    }

    public void Display()
    {
        int no=1,ni=0;
        QuiZ=" ";
        if (Brackets==1 && Symbol_Con.charAt(1)=='(')
        {
            while(true)
            {
                if (no>=Symbol_Con.length()) break;
                QuiZ=QuiZ+Symbol_Con.substring(no,no+1);
                if (Symbol_Con.charAt(no)==')')
                {
                    no++;
                    if (no>=Symbol_Con.length()) break;
                    QuiZ=QuiZ+Symbol_Con.substring(no,no+1);
                }
                if (Decimal==1) QuiZ=QuiZ+String.valueOf(Num_Con[ni]);
                else QuiZ=QuiZ+String.valueOf((int)Num_Con[ni]);
                ni++;no++;
                if (no==Symbol_Con.length()) break;
            }
        }
        else if (Brackets==1&&Symbol_Con.charAt(1)!='(')
        {
            if (Decimal==1) QuiZ=QuiZ+String.valueOf(Num_Con[0]);
            else QuiZ=QuiZ+String.valueOf((int)Num_Con[0]);
            ni++;
            while(true)
            {
                if (no>=Symbol_Con.length()) break;
                QuiZ=QuiZ+Symbol_Con.substring(no,no+1);
                no++;
                if (no>=Symbol_Con.length()) break;
                if (Symbol_Con.charAt(no)=='(')
                {
                    //no++;
                    QuiZ=QuiZ+Symbol_Con.substring(no,no+1);
                }
                else no--;
                if (Symbol_Con.charAt(no)==')'&&no<Symbol_Con.length())
                {
                    no++;
                    QuiZ=QuiZ+Symbol_Con.substring(no,no+1);
                }
                if (Decimal==1) QuiZ=QuiZ+String.valueOf(Num_Con[ni]);
                else QuiZ=QuiZ+String.valueOf((int)Num_Con[ni]);
                ni++;no++;
                if (no==Symbol_Con.length()) break;
            }
        }
        else if(Brackets==0)
        {
            if (Decimal==1) QuiZ=QuiZ+String.valueOf(Num_Con[ni]);
            else QuiZ=QuiZ+String.valueOf((int)Num_Con[ni]);
            ni++;
            while(true)
            {
                if (no>=Symbol_Con.length()) break;
                QuiZ=QuiZ+Symbol_Con.substring(no,no+1);
                if (Decimal==1)
                {QuiZ=QuiZ+String.valueOf(Num_Con[ni]);}
                else
                {QuiZ=QuiZ+String.valueOf((int)Num_Con[ni]);}
                ni++;
                no++;
                if (no>=Symbol_Con.length()) break;
            }
        }
    }

    public void Creat_File()
    {
        if (Brackets==1)
        {
            int id=Math.abs((int)(Math.random()*(Symbol_Con.length()-1))); //¶¨Òå È¡¾ø¶ÔÖµ
            String temp1,temp_mid,temp_2;
            temp1=Symbol_Con.substring(0, id+1);
            temp_mid=Symbol_Con.substring(id+1,id+2);
            if ((id+2) < (Symbol_Con.length()))
                temp_2=Symbol_Con.substring(id+2,Symbol_Con.length());
            else
                temp_2="";

            Symbol_Con=temp1+"("+temp_mid+")"+temp_2;
            symbol_new=temp1+temp_2;
            if (id==1)
            {
                if (Symbol_Con.charAt(1)=='+')
                    shu_new[0] = Num_Con[0]+Num_Con[1];
                else if (Symbol_Con.charAt(1)=='-')
                    shu_new[0] = Num_Con[0]-Num_Con[1];
                else if (Symbol_Con.charAt(1)=='*')
                    shu_new[0] = Num_Con[0]*Num_Con[1];
                else if (Symbol_Con.charAt(1)=='/')
                    shu_new[0] = Num_Con[0]/Num_Con[1];
                for (int i=2;i<Num_Con.length;i++)
                {
                    shu_new[i-1]=Num_Con[i];
                }
            }
            else if (id==2)
            {
                shu_new[0]=Num_Con[0];
                if (Symbol_Con.charAt(3)=='+')
                    shu_new[1]=Num_Con[1]+Num_Con[2];
                else if (Symbol_Con.charAt(3)=='-')
                    shu_new[1]=Num_Con[1]-Num_Con[2];
                else if (Symbol_Con.charAt(3)=='*')
                    shu_new[1]=Num_Con[1]*Num_Con[2];
                else if (Symbol_Con.charAt(3)=='/')
                    shu_new[1]=Num_Con[1]/Num_Con[2];
                for (int i=3;i<Num_Con.length;i++)
                {
                    shu_new[i-1]=Num_Con[i];
                }

            }
            else if (id==3)
            {
                shu_new[0]=Num_Con[0];
                shu_new[1]=Num_Con[1];
                if (Symbol_Con.charAt(3)=='+')
                    shu_new[2]=Num_Con[2]+Num_Con[3];
                else if (Symbol_Con.charAt(3)=='-')
                    shu_new[2]=Num_Con[2]-Num_Con[3];
                else if (Symbol_Con.charAt(3)=='*')
                    shu_new[2]=Num_Con[2]*Num_Con[3];
                else if (Symbol_Con.charAt(3)=='/')
                    shu_new[2]=Num_Con[2]/Num_Con[3];
            }
        }
        else
        {
            symbol_new=Symbol_Con;
            for (int i=0;i<Num_Con.length;i++)
            {
                shu_new[i]=Num_Con[i];
            }
        }
        if (Decimal==0)
        {
            for (int i=0;i<shu_new.length;i++)
                shu_new[i]=(int) shu_new[i];
        }
    }

    public double getnum()
    {
        double a=(Math.random()*max)+1;
        a=((int)(a*100))/100.0;
        return (a);
    }

    public void getchar()
    {
        int Mark=(int)(Math.random()*(symbol.length()-1))+1;
        symbol_sel=symbol.substring(Mark, Mark+1);
    }

}