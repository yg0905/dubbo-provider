import javax.swing.*;
import java.awt.*;
import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        int[][] ewei = new int[11][11];
        ewei[2][3] = 12;
        ewei[1][2] = 1;
        ewei[1][3] = 2;
        ewei[1][4] = 3;
        ewei[1][5] = 4;
        int num = 0;
        for (int[] ints : ewei) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    num++;
                }
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        int count = 0;
        int[][] xishu = new int[num + 1][3];
        xishu[0][0] = 11;
        xishu[0][1] = 11;
        xishu[0][2] = num;
        for (int i = 0; i < ewei.length; i++) {
            for (int j = 0; j < ewei.length; j++) {
                if (ewei[i][j] != 0) {
                    count++;
                    xishu[count][0] = i;
                    xishu[count][1] = j;
                    xishu[count][2] = ewei[i][j];
                }
            }
        }
        String filename = "D:" + File.separator + "test" + File.separator + "b.txt";
        File file = new File(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (int[] ints : xishu) {
            for (int anInt : ints) {
                //写数据
                bufferedWriter.write(String.valueOf(anInt)+":");
                //刷新
                bufferedWriter.flush();
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
            //换行
            bufferedWriter.newLine();

        }

        //关闭流
        bufferedWriter.close();
        File file1=new File(filename);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file1));
        String str=" ";
        int[][] ww=new int[num+1][3];
        int num2=0;
        while ((str=bufferedReader.readLine())!=null){
            String[] split = str.split(":");
            for (int i = 0; i < split.length; i++) {
                ww[num2][i]= Integer.parseInt(split[i]);
            }
            num2++;
            System.out.println();
        }

        bufferedReader.close();
        int[][] er = new int[xishu[0][0]][xishu[0][1]];
        for (int i = 1; i < xishu.length; i++) {
            er[xishu[i][0]][xishu[i][1]] = xishu[i][2];
        }
        for (int[] ints : er) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }


}
class test2{
    public static void main(String[] args) {
        JFrame jf = new JFrame("桥接模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("女士皮包"));
        p.add(l);
        contentPane.add(p, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
