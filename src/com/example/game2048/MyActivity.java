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
    boolean flugfinal=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initStartArray();  // init start array
        fillArrayFreePosition(); //  ��������� ������ ��������
        // ������ ���������� ���������
       // newElement();
       // newElement(16);
       // newElement(64);
        newElement(1024);
        newElement(1024);
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


    public void gameWin() {
        // ����� �������
        butns[1][0].setText("Y");
        butns[1][1].setText("O");
        butns[1][2].setText("U");
        butns[1][3].setText("");
        butns[2][0].setText("");
        butns[2][1].setText("W");
        butns[2][2].setText("I");
        butns[2][3].setText("N");

        butns[1][0].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[1][1].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[1][2].setBackgroundColor(getResources().getColor(R.color.yellow));

        butns[2][1].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[2][2].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[2][3].setBackgroundColor(getResources().getColor(R.color.yellow));

        butns[1][0].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[1][1].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[1][2].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[1][3].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[2][0].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[2][1].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[2][2].setBackgroundColor(getResources().getColor(R.color.yellow));
        butns[2][3].setBackgroundColor(getResources().getColor(R.color.yellow));

        butns[1][0].setTextColor(getResources().getColor(R.color.white));
        butns[1][1].setTextColor(getResources().getColor(R.color.white));
        butns[1][2].setTextColor(getResources().getColor(R.color.white));

        butns[2][1].setTextColor(getResources().getColor(R.color.white));
        butns[2][2].setTextColor(getResources().getColor(R.color.white));
        butns[2][3].setTextColor(getResources().getColor(R.color.white));

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
            int randPosition = rand.nextInt(freePosition.size());
            Element temp = new Element();
            temp = freePosition.get(randPosition);
            int randX = temp.getX();
            int randY = temp.getY();
            freePosition.remove(randPosition);
            //  ���������� ���� ������ �������� ��������� ��������
            String valueStrng = Integer.toString(value);
            installButtonWithText(butns[randX][randY], valueStrng);
        }
        // ���� ��� ����� ����������� ����.
        if (freePosition.isEmpty()) {
            gameOver();

        }
    }


   boolean isWin(int value) {
        if (value==2048)
            return true;
         else
            return false;
    }

    public void uppush(View view) {

        TextView scoreValue = (TextView) findViewById(R.id.scorevalue);
        int scoreV = Integer.parseInt(scoreValue.getText().toString());
        //������ �� �������
        for (int i = 0; i < 4; i++) {
            // ����������� ����. ����� ���� ��������� ������ ����������.
            upMove(i);
            int flugFree1 = 0;
            int flugFree2 = 0;
            int flugFree3 = 0;
            int flugFree4 = 0;
            int flugFreeAll = 0;
            String valueBut1 = String.valueOf(butns[0][i].getText().toString());
            if (valueBut1.equals("")) {
                flugFree1 = 1;
                flugFreeAll++;
            }
            String valueBut2 = String.valueOf(butns[1][i].getText().toString());
            if (valueBut2.equals("")) {
                flugFree2 = 1;
                flugFreeAll++;
            }
            String valueBut3 = String.valueOf(butns[2][i].getText().toString());
            if (valueBut3.equals("")) {
                flugFree3 = 1;
                flugFreeAll++;
            }
            String valueBut4 = String.valueOf(butns[3][i].getText().toString());
            if (valueBut4.equals("")) {
                flugFree4 = 1;
                flugFreeAll++;
            }

            if ((valueBut1.equals(valueBut2)) && (valueBut3.equals(valueBut4)) && flugFreeAll == 0) {
                int valueElement = Integer.parseInt(valueBut1);
                valueElement = valueElement * 2;
                flugfinal=isWin(valueElement); // �������� �� ������
                String str = Integer.toString(valueElement);
                int valueElement2 = Integer.parseInt(valueBut3);
                valueElement2 = valueElement2 * 2;
                flugfinal=isWin(valueElement2); //�������� �� ������
                String str2 = Integer.toString(valueElement2);
                //������� �����
                scoreV = scoreV + valueElement + valueElement2;
                scoreValue.setText(Integer.toString(scoreV));
                installButtonWithText(butns[0][i], str);
                installButtonWithText(butns[1][i], str2);
                // ������� ��������� ������� �� ������� ��������� �������
                deleteFreePisitionElement(0, i);
                deleteFreePisitionElement(1, i);
                installButtonNotText(butns[2][i]);
                installButtonNotText(butns[3][i]);
                // ���������  � ������ ��������� ������� ����� ������� �����
                addFreePositionElements(2, i);
                addFreePositionElements(3, i);
            } else {
                if ((valueBut1.equals(valueBut2)) && (flugFree1 == 0) && (flugFree2 == 0)) {
                    int valueElement = Integer.parseInt(valueBut1);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[0][i], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(0, i);
                    installButtonNotText(butns[1][i]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(1, i);
                    upMove(i);
                } else if ((valueBut2.equals(valueBut3)) && (flugFree2 == 0) && (flugFree3 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[1][i], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(1, i);
                    installButtonNotText(butns[2][i]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(2, i);
                    upMove(i);
                } else if ((valueBut3.equals(valueBut4)) && (flugFree3 == 0) && (flugFree4 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[2][i], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(2, i);
                    installButtonNotText(butns[3][i]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(3, i);
                    upMove(i);
                }
            }
        }
        newElement();
        if (flugfinal) gameWin();
    }

    public void downpush(View view) {
        TextView scoreValue = (TextView) findViewById(R.id.scorevalue);
        int scoreV = Integer.parseInt(scoreValue.getText().toString());
        //������ �� �������
        for (int i = 0; i < 4; i++) {
            // ����������� ����. ����� ���� ��������� ������ ����������.
            downMove(i);
            int flugFree1 = 0;
            int flugFree2 = 0;
            int flugFree3 = 0;
            int flugFree4 = 0;
            int flugFreeAll = 0;
            String valueBut1 = String.valueOf(butns[3][i].getText().toString());
            if (valueBut1.equals("")) {
                flugFree1 = 1;
                flugFreeAll++;
            }
            String valueBut2 = String.valueOf(butns[2][i].getText().toString());
            if (valueBut2.equals("")) {
                flugFree2 = 1;
                flugFreeAll++;
            }
            String valueBut3 = String.valueOf(butns[1][i].getText().toString());
            if (valueBut3.equals("")) {
                flugFree3 = 1;
                flugFreeAll++;
            }
            String valueBut4 = String.valueOf(butns[0][i].getText().toString());
            if (valueBut4.equals("")) {
                flugFree4 = 1;
                flugFreeAll++;
            }

            if ((valueBut1.equals(valueBut2)) && (valueBut3.equals(valueBut4)) && flugFreeAll == 0) {
                int valueElement = Integer.parseInt(valueBut1);
                valueElement = valueElement * 2;
                flugfinal=isWin(valueElement); // �������� �� ������
                String str = Integer.toString(valueElement);
                int valueElement2 = Integer.parseInt(valueBut3);
                valueElement2 = valueElement2 * 2;
                flugfinal=isWin(valueElement2); // �������� �� ������
                String str2 = Integer.toString(valueElement2);
                //������� �����
                scoreV = scoreV + valueElement + valueElement2;
                scoreValue.setText(Integer.toString(scoreV));
                installButtonWithText(butns[3][i], str);
                installButtonWithText(butns[2][i], str2);
                // ������� ��������� ������� �� ������� ��������� �������
                deleteFreePisitionElement(3, i);
                deleteFreePisitionElement(2, i);
                installButtonNotText(butns[1][i]);
                installButtonNotText(butns[0][i]);
                // ���������  � ������ ��������� ������� ����� ������� �����
                addFreePositionElements(1, i);
                addFreePositionElements(0, i);
            } else {
                if ((valueBut1.equals(valueBut2)) && (flugFree1 == 0) && (flugFree2 == 0)) {
                    int valueElement = Integer.parseInt(valueBut1);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[3][i], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(3, i);
                    installButtonNotText(butns[2][i]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(2, i);
                    downMove(i);
                } else if ((valueBut2.equals(valueBut3)) && (flugFree2 == 0) && (flugFree3 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[2][i], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(2, i);
                    installButtonNotText(butns[1][i]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(1, i);
                    downMove(i);
                } else if ((valueBut3.equals(valueBut4)) && (flugFree3 == 0) && (flugFree4 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[1][i], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(1, i);
                    installButtonNotText(butns[0][i]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(0, i);
                    downMove(i);
                }
            }
        }
        newElement();
        if (flugfinal) gameWin();
    }

    // ������ �����
    public void leftpush(View view) {
        TextView ScoreValue = (TextView) findViewById(R.id.scorevalue);
        int scoreV = Integer.parseInt(ScoreValue.getText().toString());
        //������ �� �������
        for (int i = 0; i < 4; i++) {
            // ����������� ����. ����� ���� ��������� ������ ����������.
            leftMove(i);
            int flugFree1 = 0;
            int flugFree2 = 0;
            int flugFree3 = 0;
            int flugFree4 = 0;
            int flugFreeAll = 0;
            String valueBut1 = String.valueOf(butns[i][0].getText().toString());
            if (valueBut1.equals("")) {
                flugFree1 = 1;
                flugFreeAll++;
            }
            String valueBut2 = String.valueOf(butns[i][1].getText().toString());
            if (valueBut2.equals("")) {
                flugFree2 = 1;
                flugFreeAll++;
            }
            String valueBut3 = String.valueOf(butns[i][2].getText().toString());
            if (valueBut3.equals("")) {
                flugFree3 = 1;
                flugFreeAll++;
            }
            String valuebut4 = String.valueOf(butns[i][3].getText().toString());
            if (valuebut4.equals("")) {
                flugFree4 = 1;
                flugFreeAll++;
            }

            if ((valueBut1.equals(valueBut2)) && (valueBut3.equals(valuebut4)) && flugFreeAll == 0) {
                int valueElement = Integer.parseInt(valueBut1);
                valueElement = valueElement * 2;
                flugfinal=isWin(valueElement); // �������� �� ������
                String str = Integer.toString(valueElement);
                int valueElement2 = Integer.parseInt(valueBut3);
                valueElement2 = valueElement2 * 2;
                flugfinal=isWin(valueElement2); // �������� �� ������
                String str2 = Integer.toString(valueElement2);
                //������� �����
                scoreV = scoreV + valueElement + valueElement2;
                ScoreValue.setText(Integer.toString(scoreV));
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
                if ((valueBut1.equals(valueBut2)) && (flugFree1 == 0) && (flugFree2 == 0)) {
                    int valueElement = Integer.parseInt(valueBut1);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    ScoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][0], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(i, 0);
                    installButtonNotText(butns[i][1]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(i, 1);
                    leftMove(i);
                } else if ((valueBut2.equals(valueBut3)) && (flugFree2 == 0) && (flugFree3 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    ScoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][1], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(i, 1);
                    installButtonNotText(butns[i][2]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(i, 2);
                    leftMove(i);
                } else if ((valueBut3.equals(valuebut4)) && (flugFree3 == 0) && (flugFree4 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    ScoreValue.setText(Integer.toString(scoreV));
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
        if (flugfinal) gameWin();
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
        TextView scoreValue = (TextView) findViewById(R.id.scorevalue);
        int scoreV = Integer.parseInt(scoreValue.getText().toString());
        //������ �� �������
        for (int i = 0; i < 4; i++) {
            // ����������� ����. ����� ���� ��������� ������ ����������.
            rightMove(i);
            int flugFree1 = 0;
            int flugFree2 = 0;
            int flugFree3 = 0;
            int flugFree4 = 0;
            int flugFreeAll = 0;
            String valueBut1 = String.valueOf(butns[i][3].getText().toString());
            if (valueBut1.equals("")) {
                flugFree1 = 1;
                flugFreeAll++;
            }
            String valueBut2 = String.valueOf(butns[i][2].getText().toString());
            if (valueBut2.equals("")) {
                flugFree2 = 1;
                flugFreeAll++;
            }
            String valueBut3 = String.valueOf(butns[i][1].getText().toString());
            if (valueBut3.equals("")) {
                flugFree3 = 1;
                flugFreeAll++;
            }
            String valueBut4 = String.valueOf(butns[i][0].getText().toString());
            if (valueBut4.equals("")) {
                flugFree4 = 1;
                flugFreeAll++;
            }

            if ((valueBut1.equals(valueBut2)) && (valueBut3.equals(valueBut4)) && flugFreeAll == 0) {
                int valueElement = Integer.parseInt(valueBut1);
                valueElement = valueElement * 2;
                flugfinal=isWin(valueElement); // �������� �� ������
                String str = Integer.toString(valueElement);
                int valueElement2 = Integer.parseInt(valueBut3);
                valueElement2 = valueElement2 * 2;
                flugfinal=isWin(valueElement2); // �������� �� ������
                String str2 = Integer.toString(valueElement2);
                //������� �����
                scoreV = scoreV + valueElement + valueElement2;
                scoreValue.setText(Integer.toString(scoreV));
                installButtonWithText(butns[i][3], str);
                installButtonWithText(butns[i][2], str2);
                // ������� ��������� ������� �� ������� ��������� �������
                deleteFreePisitionElement(i, 3);
                deleteFreePisitionElement(i, 2);
                installButtonNotText(butns[i][1]);
                installButtonNotText(butns[i][0]);
                // ���������  � ������ ��������� ������� ����� ������� �����
                addFreePositionElements(i, 1);
                addFreePositionElements(i, 0);
            } else {
                if ((valueBut1.equals(valueBut2)) && (flugFree1 == 0) && (flugFree2 == 0)) {
                    int valueElement = Integer.parseInt(valueBut1);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][3], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(i, 3);
                    installButtonNotText(butns[i][2]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(i, 2);
                    rightMove(i);
                } else if ((valueBut2.equals(valueBut3)) && (flugFree2 == 0) && (flugFree3 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement);
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][2], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(i, 2);
                    installButtonNotText(butns[i][1]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(i, 1);
                    rightMove(i);
                } else if ((valueBut3.equals(valueBut4)) && (flugFree3 == 0) && (flugFree4 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    flugfinal=isWin(valueElement); // �������� �� ������
                    String str = Integer.toString(valueElement);
                    //������� �����
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][1], str);
                    // ������� ��������� ������� �� ������� ��������� �������
                    deleteFreePisitionElement(i, 1);
                    installButtonNotText(butns[i][0]);
                    // ���������  � ������ ��������� ������� ����� ������� �����
                    addFreePositionElements(i, 0);
                    rightMove(i);
                }
            }
        }
        newElement();
        if (flugfinal) gameWin();
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
                TextView score=(TextView) findViewById(R.id.scorevalue);
                score.setText("0");
                // ���������� �������������� ������
                flugfinal=false;
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
                moveElemHorizontal(i, freeY, notFreeY);
            }
        }
    }

    public void rightMove(int i) {
        for (; ; ) {
            int freeY = 10;
            int notFreeY = 10;
            int flugElementsFree = 1;
            int position=10;
            //�����  ������ ��������� ������
            for (int j = 0; j < 4; j++) {
                String value = String.valueOf(butns[i][3-j].getText().toString());
                if (value.equals("")) {
                    freeY = 3-j;
                    position=j;
                    break;
                }
            }
            //����� ������ ������� ������
            for (int j = position; j < 4; j++) {
                String value = String.valueOf(butns[i][3-j].getText().toString());
                if (!value.equals("")) {
                    notFreeY = 3-j;
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
                moveElemHorizontal(i, freeY, notFreeY);
            }
        }
    }

    public void moveElemHorizontal(int i, int freeY, int notFreeY) {
        butns[i][freeY].setText(butns[i][notFreeY].getText());
        changeColor(butns[i][freeY]);
        // ������� ��������� ������� �� ������� ��������� �������
        deleteFreePisitionElement(i, freeY);
        installButtonNotText(butns[i][notFreeY]);
        // ���������  � ������ ��������� ������� ����� ������� �����
        addFreePositionElements(i, notFreeY);
    }

    public void downMove(int i) {
        for (; ; ) {
            int freeY = 10;
            int notFreeY = 10;
            int flugElementsFree = 1;
            int position=10;
            //�����  ������ ��������� ������
            for (int j = 0; j < 4; j++) {
                String value = String.valueOf(butns[3-j][i].getText().toString());
                if (value.equals("")) {
                    freeY = 3-j;
                    position=j;
                    break;
                }
            }
            //����� ������ ������� ������
            for (int j = position; j < 4; j++) {
                String value = String.valueOf(butns[3-j][i].getText().toString());
                if (!value.equals("")) {
                    notFreeY = 3-j;
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
                moveElemVertival(i, freeY, notFreeY);
            }
        }
    }

    public void moveElemVertival(int i, int freeY, int notFreeY) {
        butns[freeY][i].setText(butns[notFreeY][i].getText());
        changeColor(butns[freeY][i]);
        // ������� ��������� ������� �� ������� ��������� �������
        deleteFreePisitionElement(freeY, i);
        installButtonNotText(butns[notFreeY][i]);
        // ���������  � ������ ��������� ������� ����� ������� �����
        addFreePositionElements(notFreeY, i);
    }

    public void upMove(int i) {
        for (; ; ) {
            int freeY = 10;
            int notFreeY = 10;
            int flugElementsFree = 1;
            //�����  ������ ��������� ������
            for (int j = 0; j < 4; j++) {
                String value = String.valueOf(butns[j][i].getText().toString());
                if (value.equals("")) {
                    freeY = j;
                    break;
                }
            }
            //����� ������ ������� ������
            for (int j = freeY; j < 4; j++) {
                String value = String.valueOf(butns[j][i].getText().toString());
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
                moveElemVertival(i, freeY, notFreeY);
            }
        }
    }
}