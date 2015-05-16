package com.example.game2048;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static com.example.game2048.Colors.changeColor;

public class MyActivity extends Activity {
    ArrayList<Element> freePosition = new ArrayList<Element>(); // ������ ��������� �������
    Button[][] butns = new Button[4][4];  // ���������� ������

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initStartArray();  // init start array
        fillArrayFreePosition(); //  ��������� ������ ��������
        // ������ ���������� ���������
        newElement();
        newElement(16);
        newElement(64);
        newElement(128);
        newElement();
    }

    public void fillArrayFreePosition() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                addFreePositionElements(i, j);
            }
        }
    }

    public void initStartArray() {
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
            int valueElement = rand.nextInt(10);
            if (valueElement < 9) {
                installButtonWithText(butns[randX][randY], "2");
            } else {
                installButtonWithText(butns[randX][randY], "4");
            }
        }
        // ��� ����� ����� ����
        if (freePosition.isEmpty()) {
            gameOver();
        }
    }
        // ����� ����
    public void gameOver() {
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
        installButtonWithText(reset, "RES");
        leftbtn.setEnabled(false);
        rightbtn.setEnabled(false);
        upbtn.setEnabled(false);
        downbtn.setEnabled(false);
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
            int randY = temp.getY();
            freePosition.remove(randposition);
            //  ���������� ���� ������ �������� ��������� ��������
            String valueStrng = Integer.toString(value);
            installButtonWithText(butns[randX][randY], valueStrng);
        }
        // ���� ��� ����� ����������� ����.
        if (freePosition.isEmpty()) {
            gameOver();
        }
    }

    public void uppush(View view) {
        newElement();
    }

    public void downpush(View view) {

        newElement();
    }
    // ������ �����
    public void leftpush(View view) {
        TextView scorevalue = (TextView) findViewById(R.id.scorevalue);
        int scoreV = Integer.parseInt(scorevalue.getText().toString());
        //������ �� �������
        for (int i = 0; i < 4; i++) {
            // ����������� ����. ����� ���� ��������� ������ ����������.
            leftMove(i);
            int flugfree1 = 0;
            int flugfree2 = 0;
            int flugfree3 = 0;
            int flugfree4 = 0;
            int flugfreeall = 0;
            String valuebut1 = String.valueOf(butns[i][0].getText().toString());
            if (valuebut1.equals("")) {
                flugfree1 = 1;
                flugfreeall++;
            }
            String valuebut2 = String.valueOf(butns[i][1].getText().toString());
            if (valuebut2.equals("")) {
                flugfree2 = 1;
                flugfreeall++;
            }
            String valuebut3 = String.valueOf(butns[i][2].getText().toString());
            if (valuebut3.equals("")) {
                flugfree3 = 1;
                flugfreeall++;
            }
            String valuebut4 = String.valueOf(butns[i][3].getText().toString());
            if (valuebut4.equals("")) {
                flugfree4 = 1;
                flugfreeall++;
            }

            if ((valuebut1.equals(valuebut2)) && (valuebut3.equals(valuebut4)) && flugfreeall == 0) {
                int valueElement = Integer.parseInt(valuebut1);
                valueElement = valueElement * 2;
                String str = Integer.toString(valueElement);
                int valueElement2 = Integer.parseInt(valuebut3);
                valueElement2 = valueElement2 * 2;
                String str2 = Integer.toString(valueElement2);
                //������� �����
                scoreV = scoreV + valueElement + valueElement2;
                scorevalue.setText(Integer.toString(scoreV));
                installButtonWithText(butns[i][0], str);
                installButtonWithText(butns[i][1], str2);
                // ������� ��������� ������� �� ������� ��������� �������
                deleteFreePisitionElement(i, 0);
                deleteFreePisitionElement(i, 1);
                installButtonNotText(butns[i][2]);
                installButtonNotText(butns[i][3]);
                // ���������  � ������ ��������� ������� ����� ������� �����
                addFreePositionElements(i, 2);
                addFreePositionElements(i, 3);
            } else {
                if ((valuebut1.equals(valuebut2)) && (flugfree1 == 0) && (flugfree2 == 0)) {
                    int valueElement = Integer.parseInt(valuebut1);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scorevalue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][0], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(i, 0);
                    installButtonNotText(butns[i][1]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(i, 1);
                    leftMove(i);
                } else if ((valuebut2.equals(valuebut3)) && (flugfree2 == 0) && (flugfree3 == 0)) {
                    int valueElement = Integer.parseInt(valuebut3);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scorevalue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][1], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(i, 1);
                    installButtonNotText(butns[i][2]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(i, 2);
                    leftMove(i);
                } else if ((valuebut3.equals(valuebut4)) && (flugfree3 == 0) && (flugfree4 == 0)) {
                    int valueElement = Integer.parseInt(valuebut3);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scorevalue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][2], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(i, 2);
                    installButtonNotText(butns[i][3]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(i, 3);
                    leftMove(i);
                }
            }
        }
        newElement();
    }
    // ��������� �������� � ������ � ������� �������
    public void installButtonWithText(Button button, String str) {
        button.setText(str);
        changeColor(button);
    }
    // ��������� ������ ������
    public void installButtonNotText(Button button) {
        installButtonWithText(button, "");
    }
    // ���������� �������� � ������ ��������� �������
    public void addFreePositionElements(int i, int y) {
        Element element = new Element();
        element.setX(i);
        element.setY(y);
        freePosition.add(element);
    }
    // �������� �������� �� ������� ��������� �������
    public void deleteFreePisitionElement(int i, int y) {
        Element element2 = new Element();
        for (int k = 0; k < freePosition.size(); k++) {
            element2 = freePosition.get(k);
            if ((element2.getX() == i) && (element2.getY() == y)) {
                freePosition.remove(element2);
                break;
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
                installButtonNotText(butns[i][j]);
                addFreePositionElements(i, j);
                Button reset = (Button) findViewById(R.id.resetbtn);
                Button leftbtn = (Button) findViewById(R.id.lbtn);
                Button rightbtn = (Button) findViewById(R.id.rbtn);
                Button upbtn = (Button) findViewById(R.id.upbtn);
                Button downbtn = (Button) findViewById(R.id.downbtn);
                // ���������� �������������� ������
                reset.setBackgroundColor(getResources().getColor(R.color.yellow));
                leftbtn.setEnabled(true);
                rightbtn.setEnabled(true);
                upbtn.setEnabled(true);
                downbtn.setEnabled(true);
            }
        }
    }
    // ����� ��������� �����
    public void leftMove(int i) {
        for (; ; ) {
            int freeY = 10;
            int notFreeY = 10;
            int flugElementsFree = 1;
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
                    flugElementsFree = 0; // ���������� ������� ������
                    break;
                }
            }
            if (flugElementsFree == 1) {    // ��� ������� �����. ����� �� ������������ �����
                notFreeY = freeY;
                break;
            }
            // ���� ������ �� �������� � ��������� �� ������ ��������. ���������� �������.
            if (freeY != notFreeY) {
                butns[i][freeY].setText(butns[i][notFreeY].getText());
                changeColor(butns[i][freeY]);
                // ������� ��������� ������� �� ������� ��������� �������
                deleteFreePisitionElement(i, freeY);
                installButtonNotText(butns[i][notFreeY]);
                // ���������  � ������ ��������� ������� ����� ������� �����
                addFreePositionElements(i, notFreeY);
            }
        }
    }
}