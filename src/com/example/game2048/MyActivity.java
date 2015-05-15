package com.example.game2048;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static com.example.game2048.Colors.changeColor;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    ArrayList<Element> freePosition = new ArrayList<Element>(); // ������ ��������� �������

    Button[][] butns = new Button[4][4];  // ���������� ������


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // init start array
        butns[0][0] = (Button) findViewById(R.id.g00);
        butns[0][1] = (Button) findViewById(R.id.g01);
        butns[0][2] = (Button) findViewById(R.id.g02);
        butns[0][3] = (Button) findViewById(R.id.g03);

        butns[1][0] = (Button) findViewById(R.id.g10);
        butns[1][1] = (Button) findViewById(R.id.g11);
        butns[1][2] = (Button) findViewById(R.id.g12);
        butns[1][3] = (Button) findViewById(R.id.g13);

        butns[2][0] = (Button) findViewById(R.id.g20);
        butns[2][1] = (Button) findViewById(R.id.g21);
        butns[2][2] = (Button) findViewById(R.id.g22);
        butns[2][3] = (Button) findViewById(R.id.g23);

        butns[3][0] = (Button) findViewById(R.id.g30);
        butns[3][1] = (Button) findViewById(R.id.g31);
        butns[3][2] = (Button) findViewById(R.id.g32);
        butns[3][3] = (Button) findViewById(R.id.g33);


        //  ��������� ������ ��������
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                Element element = new Element();
                element.setX(i);
                element.setY(j);
                freePosition.add(element);

            }

        }


        // ������ ���������� ���������
        newElement();
        newElement(16);
        newElement(64);
        newElement(128);
        newElement();



    }


    // ������� ���������� ��������
    public void newElement() {

        Random rand = new Random();
        // ���� ���� ��������� �����
        if (!freePosition.isEmpty()) {
            // ����������� ��������� ��������� �������
            int randposition = rand.nextInt(freePosition.size());
            Element temp = new Element();
            temp = freePosition.get(randposition);
            int randX = temp.getX();
            int randY = temp.getY();
            freePosition.remove(randposition);

            //  ���������� �������� � ���� ������ ��������
            int valueElement = rand.nextInt(2);
            if (valueElement == 0) {
                butns[randX][randY].setText("2");
                changeColor(butns[randX][randY]);
            } else {
                butns[randX][randY].setText("4");
                changeColor(butns[randX][randY]);

            }

        }

        // ��� ����� ����� ����
        if (freePosition.isEmpty()) {
            // ����� �������
            butns[1][0].setText("G");
            butns[1][1].setText("A");
            butns[1][2].setText("M");
            butns[1][3].setText("E");

            butns[2][0].setText("O");
            butns[2][1].setText("V");
            butns[2][2].setText("E");
            butns[2][3].setText("R");

            changeColor(butns[1][0]);
            changeColor(butns[1][1]);
            changeColor(butns[1][2]);
            changeColor(butns[1][3]);

            changeColor(butns[2][0]);
            changeColor(butns[2][1]);
            changeColor(butns[2][2]);
            changeColor(butns[2][3]);

            Button reset = (Button) findViewById(R.id.resetbtn);
            Button leftbtn = (Button) findViewById(R.id.lbtn);
            Button rightbtn = (Button) findViewById(R.id.rbtn);
            Button upbtn = (Button) findViewById(R.id.upbtn);
            Button downbtn = (Button) findViewById(R.id.downbtn);


            // ��������� �������������� ������
            reset.setEnabled(true);
            reset.setText("RES");
            changeColor(reset);
            leftbtn.setEnabled(false);
            rightbtn.setEnabled(false);
            upbtn.setEnabled(false);
            downbtn.setEnabled(false);
        }
    }


    // ���������� ������� � ����� ��������� ������� �������
    public void newElement(int value) {
        Random rand = new Random();
        // ���� ���� ��������� �����
        if (!freePosition.isEmpty()) {
            // ���������� ����� �������
            int randposition = rand.nextInt(freePosition.size());
            Element temp = new Element();
            temp = freePosition.get(randposition);
            int randX = temp.getX();
            int randY =temp.getY();
            freePosition.remove(randposition);

            //  ���������� ���� ������ �������� ��������� ��������
            String valueStrng = Integer.toString(value);
            butns[randX][randY].setText(valueStrng);
            changeColor(butns[randX][randY]);
        }
        // ���� ��� ����� ����������� ����.
        if (freePosition.isEmpty()) {
            butns[1][0].setText("G");
            butns[1][1].setText("A");
            butns[1][2].setText("M");
            butns[1][3].setText("E");

            butns[2][0].setText("O");
            butns[2][1].setText("V");
            butns[2][2].setText("E");
            butns[2][3].setText("R");

            changeColor(butns[1][0]);
            changeColor(butns[1][1]);
            changeColor(butns[1][2]);
            changeColor(butns[1][3]);

            changeColor(butns[2][0]);
            changeColor(butns[2][1]);
            changeColor(butns[2][2]);
            changeColor(butns[2][3]);

            Button reset = (Button) findViewById(R.id.resetbtn);
            Button leftbtn = (Button) findViewById(R.id.lbtn);
            Button rightbtn = (Button) findViewById(R.id.rbtn);
            Button upbtn = (Button) findViewById(R.id.upbtn);
            Button downbtn = (Button) findViewById(R.id.downbtn);

            // ��������� �������������� ������
            reset.setEnabled(true);
            reset.setText("RES");
            changeColor(reset);
            leftbtn.setEnabled(false);
            rightbtn.setEnabled(false);
            upbtn.setEnabled(false);
            downbtn.setEnabled(false);
        }
    }

    public void uppush(View view) {
        newElement();
    }

    public void downpush(View view) {

        newElement();
    }

    public void leftpush(View view) {
        //������ �� �������
       for (int i=0; i<4; i++) {
           // ����������� ����. ����� ���� ��������� ������ ����������.
            for (; ; ) {
                int freeY = 10;
                int notFreeY = 10;
                int flug = 1;

                //�����  ������ ��������� ������
                for (int j = 0; j < 4; j++) {
                    String value = String.valueOf(butns[i][j].getText().toString());
                    if (value.equals("")) {
                        freeY = j;
                        break;
                    }
                }

                //����� ������ ������� ������
                for (int j = freeY; j < 4; j++) {
                    String value = String.valueOf(butns[i][j].getText().toString());
                    if (!value.equals("")) {
                        notFreeY = j;
                        flug = 0; // ���������� ������� ������
                        break;
                    }

                }

                if (flug == 1) {    // ��� ������� �����. ����� �� ������������ �����
                    notFreeY = freeY;
                    break;
                }
                // ���� ������ �� �������� � ��������� �� ������ ��������. ���������� �������.
                if (freeY != notFreeY) {
                    butns[i][freeY].setText(butns[i][notFreeY].getText());
                    changeColor(butns[i][freeY]);
                    butns[i][notFreeY].setText("");
                    changeColor(butns[i][notFreeY]);
                }

            }
      }
    }
    public void rightpush(View view) {
        newElement();
    }


    // ������� ����.
    public void resetpush(View view) {
        // ��������� ������ freeposition ������ ���������� ����������
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                butns[i][j].setText("");
                changeColor(butns[i][j]);
                Element element = new Element();
                element.setX(i);
                element.setY(j);
                freePosition.add(element);

                Button reset = (Button) findViewById(R.id.resetbtn);
                Button leftbtn = (Button) findViewById(R.id.lbtn);
                Button rightbtn = (Button) findViewById(R.id.rbtn);
                Button upbtn = (Button) findViewById(R.id.upbtn);
                Button downbtn = (Button) findViewById(R.id.downbtn);

                // ���������� �������������� ������
                reset.setEnabled(false);
                reset.setText("");
                changeColor(reset);
                leftbtn.setEnabled(true);
                rightbtn.setEnabled(true);
                upbtn.setEnabled(true);
                downbtn.setEnabled(true);
            }

        }

    }

}