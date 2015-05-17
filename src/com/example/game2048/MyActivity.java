package com.example.game2048;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static com.example.game2048.Colors.changeColor;

public class MyActivity extends Activity {
    ArrayList<Element> freePosition = new ArrayList<Element>(); // Массив свободных позиций
    Button[][] butns = new Button[4][4];  // Собственно кнопки
    boolean flugfinal = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ActionBar actionBar = getActionBar();   // Поменяем цвет action bar
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.ab_background));
        initStartArray();  // init start array
        fillArrayFreePosition(); //  заполняем массив поззиций
        newElement(1024);
        newElement(1024);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.help) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("About Program,");
            builder.setIcon(android.R.drawable.ic_dialog_info);
            final View view = getLayoutInflater().inflate(R.layout.mydialog, null);
            builder.setView(view);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    // Функция добавления элемента
    public void newElement() {
        Random rand = new Random();
        // Если есть свободное место
        if (!freePosition.isEmpty()) {
            // Определение случайной свободной позиции
            int randposition = rand.nextInt(freePosition.size());
            Element temp = new Element();
            temp = freePosition.get(randposition);
            int randX = temp.getX();
            int randY = temp.getY();
            freePosition.remove(randposition);
            //  Определяем значение и цвет нового элемента
            int valueElement = rand.nextInt(10);
            if (valueElement < 9) {
                installButtonWithText(butns[randX][randY], "2");
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                butns[randX][randY].startAnimation(animation);

            } else {
                installButtonWithText(butns[randX][randY], "4");
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                butns[randX][randY].startAnimation(animation);

            }
        }
    }

    // конец игры
    public void gameOver() {
        // Пишем надпись
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
        // Фиксируем кликабельность кнопок
        reset.setEnabled(true);
        installButtonWithText(reset, "RES");
        leftbtn.setEnabled(false);
        rightbtn.setEnabled(false);
        upbtn.setEnabled(false);
        downbtn.setEnabled(false);
    }

    public void gameWin() {
        // Пишем надпись
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
        // Фиксируем кликабельность кнопок
        reset.setEnabled(true);
        installButtonWithText(reset, "RES");
        leftbtn.setEnabled(false);
        rightbtn.setEnabled(false);
        upbtn.setEnabled(false);
        downbtn.setEnabled(false);
    }

    // Перегрузка функции с новым элементом заданым вручную
    public void newElement(int value) {
        Random rand = new Random();
        // Если есть свободное место
        if (!freePosition.isEmpty()) {
            // Определяем новую позицию
            int randPosition = rand.nextInt(freePosition.size());
            Element temp = new Element();
            temp = freePosition.get(randPosition);
            int randX = temp.getX();
            int randY = temp.getY();
            freePosition.remove(randPosition);
            //  Определяем цвет нового элемента фиксируем значение
            String valueStrng = Integer.toString(value);
            installButtonWithText(butns[randX][randY], valueStrng);
        }
    }

    public void isWin() {
        int flug = 0;
        freePosition.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String strValue;
                strValue = butns[i][j].getText().toString();
                if (strValue.equals("")) {
                    addFreePositionElements(i, j);
                }
                if (strValue.equals("2048")) {
                    gameWin();
                    flug = 1;
                    break;
                }
            }
            if (flug == 1) break;
        }
        if (freePosition.isEmpty()) {
            boolean flugGameOver = true;
            //1st block
            if (butns[0][0].getText().toString().equals(butns[0][1].getText().toString())) flugGameOver = false;
            if (butns[0][0].getText().toString().equals(butns[1][0].getText().toString())) flugGameOver = false;
            if (butns[0][1].getText().toString().equals(butns[0][2].getText().toString())) flugGameOver = false;
            if (butns[0][1].getText().toString().equals(butns[1][1].getText().toString())) flugGameOver = false;
            if (butns[0][2].getText().toString().equals(butns[0][3].getText().toString())) flugGameOver = false;
            if (butns[0][2].getText().toString().equals(butns[1][2].getText().toString())) flugGameOver = false;
            if (butns[0][3].getText().toString().equals(butns[1][3].getText().toString())) flugGameOver = false;
            //2nd block
            if (butns[1][0].getText().toString().equals(butns[1][1].getText().toString())) flugGameOver = false;
            if (butns[1][0].getText().toString().equals(butns[2][0].getText().toString())) flugGameOver = false;
            if (butns[1][1].getText().toString().equals(butns[1][2].getText().toString())) flugGameOver = false;
            if (butns[1][1].getText().toString().equals(butns[2][1].getText().toString())) flugGameOver = false;
            if (butns[1][2].getText().toString().equals(butns[1][3].getText().toString())) flugGameOver = false;
            if (butns[1][2].getText().toString().equals(butns[2][2].getText().toString())) flugGameOver = false;
            if (butns[1][3].getText().toString().equals(butns[2][3].getText().toString())) flugGameOver = false;
            //3nd block
            if (butns[2][0].getText().toString().equals(butns[2][1].getText().toString())) flugGameOver = false;
            if (butns[2][0].getText().toString().equals(butns[3][0].getText().toString())) flugGameOver = false;
            if (butns[2][1].getText().toString().equals(butns[2][2].getText().toString())) flugGameOver = false;
            if (butns[2][1].getText().toString().equals(butns[3][1].getText().toString())) flugGameOver = false;
            if (butns[2][2].getText().toString().equals(butns[2][3].getText().toString())) flugGameOver = false;
            if (butns[2][2].getText().toString().equals(butns[3][2].getText().toString())) flugGameOver = false;
            if (butns[2][3].getText().toString().equals(butns[3][3].getText().toString())) flugGameOver = false;
            //4nd block
            if (butns[3][0].getText().toString().equals(butns[3][1].getText().toString())) flugGameOver = false;
            if (butns[3][1].getText().toString().equals(butns[3][2].getText().toString())) flugGameOver = false;
            if (butns[3][2].getText().toString().equals(butns[3][3].getText().toString())) flugGameOver = false;
            if (flugGameOver) gameOver();
        }
    }


    public void uppush(View view) {
        boolean flugfinal = false;
        TextView scoreValue = (TextView) findViewById(R.id.scorevalue);
        int scoreV = Integer.parseInt(scoreValue.getText().toString());
        //Проход по строкам
        for (int i = 0; i < 4; i++) {
            // Бесконченый цикл. Выход если элементам некуда сдвигаться.
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
                String str = Integer.toString(valueElement);
                int valueElement2 = Integer.parseInt(valueBut3);
                valueElement2 = valueElement2 * 2;
                String str2 = Integer.toString(valueElement2);
                //Подсчет очков
                scoreV = scoreV + valueElement + valueElement2;
                scoreValue.setText(Integer.toString(scoreV));
                installButtonWithText(butns[0][i], str);
                installButtonWithText(butns[1][i], str2);
                // Удаляем созданный элемент из массива свободных позиций
                deleteFreePisitionElement(0, i);
                deleteFreePisitionElement(1, i);
                installButtonNotText(butns[2][i]);
                installButtonNotText(butns[3][i]);
                // Добавляем  в массив свободных позиций ранее занятое место
                addFreePositionElements(2, i);
                addFreePositionElements(3, i);
            } else {
                if ((valueBut1.equals(valueBut2)) && (flugFree1 == 0) && (flugFree2 == 0)) {
                    int valueElement = Integer.parseInt(valueBut1);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[0][i], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(0, i);
                    installButtonNotText(butns[1][i]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(1, i);
                    upMove(i);
                } else if ((valueBut2.equals(valueBut3)) && (flugFree2 == 0) && (flugFree3 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[1][i], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(1, i);
                    installButtonNotText(butns[2][i]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(2, i);
                    upMove(i);
                } else if ((valueBut3.equals(valueBut4)) && (flugFree3 == 0) && (flugFree4 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[2][i], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(2, i);
                    installButtonNotText(butns[3][i]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(3, i);
                    upMove(i);
                }
            }
        }
        newElement();
        isWin();
    }

    public void downpush(View view) {
        TextView scoreValue = (TextView) findViewById(R.id.scorevalue);
        int scoreV = Integer.parseInt(scoreValue.getText().toString());
        //Проход по строкам
        for (int i = 0; i < 4; i++) {
            // Бесконченый цикл. Выход если элементам некуда сдвигаться.
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
                String str = Integer.toString(valueElement);
                int valueElement2 = Integer.parseInt(valueBut3);
                valueElement2 = valueElement2 * 2;
                String str2 = Integer.toString(valueElement2);
                //Подсчет очков
                scoreV = scoreV + valueElement + valueElement2;
                scoreValue.setText(Integer.toString(scoreV));
                installButtonWithText(butns[3][i], str);
                installButtonWithText(butns[2][i], str2);
                // Удаляем созданный элемент из массива свободных позиций
                deleteFreePisitionElement(3, i);
                deleteFreePisitionElement(2, i);
                installButtonNotText(butns[1][i]);
                installButtonNotText(butns[0][i]);
                // Добавляем  в массив свободных позиций ранее занятое место
                addFreePositionElements(1, i);
                addFreePositionElements(0, i);
            } else {
                if ((valueBut1.equals(valueBut2)) && (flugFree1 == 0) && (flugFree2 == 0)) {
                    int valueElement = Integer.parseInt(valueBut1);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[3][i], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(3, i);
                    installButtonNotText(butns[2][i]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(2, i);
                    downMove(i);
                } else if ((valueBut2.equals(valueBut3)) && (flugFree2 == 0) && (flugFree3 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[2][i], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(2, i);
                    installButtonNotText(butns[1][i]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(1, i);
                    downMove(i);
                } else if ((valueBut3.equals(valueBut4)) && (flugFree3 == 0) && (flugFree4 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[1][i], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(1, i);
                    installButtonNotText(butns[0][i]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(0, i);
                    downMove(i);
                }
            }
        }
        newElement();
        isWin();
    }

    // кнопка влево
    public void leftpush(View view) {
        TextView ScoreValue = (TextView) findViewById(R.id.scorevalue);
        int scoreV = Integer.parseInt(ScoreValue.getText().toString());
        //Проход по строкам
        for (int i = 0; i < 4; i++) {
            // Бесконченый цикл. Выход если элементам некуда сдвигаться.
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
                String str = Integer.toString(valueElement);
                int valueElement2 = Integer.parseInt(valueBut3);
                valueElement2 = valueElement2 * 2;
                String str2 = Integer.toString(valueElement2);
                //Подсчет очков
                scoreV = scoreV + valueElement + valueElement2;
                ScoreValue.setText(Integer.toString(scoreV));
                installButtonWithText(butns[i][0], str);
                installButtonWithText(butns[i][1], str2);
                // Удаляем созданный элемент из массива свободных позиций
                deleteFreePisitionElement(i, 0);
                deleteFreePisitionElement(i, 1);
                installButtonNotText(butns[i][2]);
                installButtonNotText(butns[i][3]);
                // Добавляем  в массив свободных позиций ранее занятое место
                addFreePositionElements(i, 2);
                addFreePositionElements(i, 3);
            } else {
                if ((valueBut1.equals(valueBut2)) && (flugFree1 == 0) && (flugFree2 == 0)) {
                    int valueElement = Integer.parseInt(valueBut1);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    ScoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][0], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(i, 0);
                    installButtonNotText(butns[i][1]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(i, 1);
                    leftMove(i);
                } else if ((valueBut2.equals(valueBut3)) && (flugFree2 == 0) && (flugFree3 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    ScoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][1], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(i, 1);
                    installButtonNotText(butns[i][2]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(i, 2);
                    leftMove(i);
                } else if ((valueBut3.equals(valuebut4)) && (flugFree3 == 0) && (flugFree4 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    ScoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][2], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(i, 2);
                    installButtonNotText(butns[i][3]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(i, 3);
                    leftMove(i);
                }
            }
        }
        newElement();
        isWin();
    }

    // Установка элемента с цветом и заднным текстом
    public void installButtonWithText(Button button, String str) {
        button.setText(str);
        changeColor(button);
    }

    // Установка пустой кнопки
    public void installButtonNotText(Button button) {
        installButtonWithText(button, "");
    }

    // Добавление элемента в массив свободных позиций
    public void addFreePositionElements(int i, int y) {
        Element element = new Element();
        element.setX(i);
        element.setY(y);
        freePosition.add(element);
    }

    // Удаления элемента из массива свободных позиций
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
        //Проход по строкам
        for (int i = 0; i < 4; i++) {
            // Бесконченый цикл. Выход если элементам некуда сдвигаться.
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
                String str = Integer.toString(valueElement);
                int valueElement2 = Integer.parseInt(valueBut3);
                valueElement2 = valueElement2 * 2;
                String str2 = Integer.toString(valueElement2);
                //Подсчет очков
                scoreV = scoreV + valueElement + valueElement2;
                scoreValue.setText(Integer.toString(scoreV));
                installButtonWithText(butns[i][3], str);
                installButtonWithText(butns[i][2], str2);
                // Удаляем созданный элемент из массива свободных позиций
                deleteFreePisitionElement(i, 3);
                deleteFreePisitionElement(i, 2);
                installButtonNotText(butns[i][1]);
                installButtonNotText(butns[i][0]);
                // Добавляем  в массив свободных позиций ранее занятое место
                addFreePositionElements(i, 1);
                addFreePositionElements(i, 0);
            } else {
                if ((valueBut1.equals(valueBut2)) && (flugFree1 == 0) && (flugFree2 == 0)) {
                    int valueElement = Integer.parseInt(valueBut1);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][3], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(i, 3);
                    installButtonNotText(butns[i][2]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(i, 2);
                    rightMove(i);
                } else if ((valueBut2.equals(valueBut3)) && (flugFree2 == 0) && (flugFree3 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][2], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(i, 2);
                    installButtonNotText(butns[i][1]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(i, 1);
                    rightMove(i);
                } else if ((valueBut3.equals(valueBut4)) && (flugFree3 == 0) && (flugFree4 == 0)) {
                    int valueElement = Integer.parseInt(valueBut3);
                    valueElement = valueElement * 2;
                    // valueElement=2048;
                    String str = Integer.toString(valueElement);
                    //Подсчет очков
                    scoreV = scoreV + valueElement;
                    scoreValue.setText(Integer.toString(scoreV));
                    installButtonWithText(butns[i][1], str);
                    // Удаляем созданный элемент из массива свободных позиций
                    deleteFreePisitionElement(i, 1);
                    installButtonNotText(butns[i][0]);
                    // Добавляем  в массив свободных позиций ранее занятое место
                    addFreePositionElements(i, 0);
                    rightMove(i);
                }
            }
        }
        newElement();
        isWin();
    }

    // Очистка поля.
    public void resetpush(View view) {
        // Заполняем массив freeposition новыми свободными значениями
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                installButtonNotText(butns[i][j]);
                addFreePositionElements(i, j);
                Button reset = (Button) findViewById(R.id.resetbtn);
                Button leftbtn = (Button) findViewById(R.id.lbtn);
                Button rightbtn = (Button) findViewById(R.id.rbtn);
                Button upbtn = (Button) findViewById(R.id.upbtn);
                Button downbtn = (Button) findViewById(R.id.downbtn);
                TextView score = (TextView) findViewById(R.id.scorevalue);
                score.setText("0");
                // Определяем кликабельность кнопок
                flugfinal = false;
                reset.setBackgroundColor(getResources().getColor(R.color.yellow));
                leftbtn.setEnabled(true);
                rightbtn.setEnabled(true);
                upbtn.setEnabled(true);
                downbtn.setEnabled(true);
            }
        }
    }

    // Сдвиг элементов влево
    public void leftMove(int i) {
        for (; ; ) {
            int freeY = 10;
            int notFreeY = 10;
            int flugElementsFree = 1;
            //Поиск  первой свободной ячейки
            for (int j = 0; j < 4; j++) {
                String value = String.valueOf(butns[i][j].getText().toString());
                if (value.equals("")) {
                    freeY = j;
                    break;
                }
            }
            //Поиск первой занятой ячкйки
            for (int j = freeY; j < 4; j++) {
                String value = String.valueOf(butns[i][j].getText().toString());
                if (!value.equals("")) {
                    notFreeY = j;
                    flugElementsFree = 0; // обнаруженя занятая ячейка
                    break;
                }
            }
            if (flugElementsFree == 1) {    // Нет занятый ячеек. Выход из бесконечного цикла
                notFreeY = freeY;
                break;
            }
            // Если ячейки не совпдают и находяься на разных позициях. Перемещаем позицию.
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
            int position = 10;
            //Поиск  первой свободной ячейки
            for (int j = 0; j < 4; j++) {
                String value = String.valueOf(butns[i][3 - j].getText().toString());
                if (value.equals("")) {
                    freeY = 3 - j;
                    position = j;
                    break;
                }
            }
            //Поиск первой занятой ячкйки
            for (int j = position; j < 4; j++) {
                String value = String.valueOf(butns[i][3 - j].getText().toString());
                if (!value.equals("")) {
                    notFreeY = 3 - j;
                    flugElementsFree = 0; // обнаруженя занятая ячейка
                    break;
                }
            }
            if (flugElementsFree == 1) {    // Нет занятый ячеек. Выход из бесконечного цикла
                notFreeY = freeY;
                break;
            }
            // Если ячейки не совпдают и находяься на разных позициях. Перемещаем позицию.
            if (freeY != notFreeY) {
                moveElemHorizontal(i, freeY, notFreeY);
            }
        }
    }

    public void moveElemHorizontal(int i, int freeY, int notFreeY) {

        butns[i][freeY].setText(butns[i][notFreeY].getText());
        changeColor(butns[i][freeY]);
        float fromX, fromY, toX, toY;
        fromX = butns[i][notFreeY].getX();
        fromY = butns[i][notFreeY].getY();
        toX =butns[i][freeY].getX();
        toY =butns[i][freeY].getY();
        final TranslateAnimation animation = new TranslateAnimation(fromX-toX,0,0,0);
        animation.setDuration(100);
        butns[i][freeY].startAnimation(animation);
        // Удаляем созданный элемент из массива свободных позиций
        deleteFreePisitionElement(i, freeY);
        installButtonNotText(butns[i][notFreeY]);
        // Добавляем  в массив свободных позиций ранее занятое место
        addFreePositionElements(i, notFreeY);
    }

    public void downMove(int i) {
        for (; ; ) {
            int freeY = 10;
            int notFreeY = 10;
            int flugElementsFree = 1;
            int position = 10;
            //Поиск  первой свободной ячейки
            for (int j = 0; j < 4; j++) {
                String value = String.valueOf(butns[3 - j][i].getText().toString());
                if (value.equals("")) {
                    freeY = 3 - j;
                    position = j;
                    break;
                }
            }
            //Поиск первой занятой ячкйки
            for (int j = position; j < 4; j++) {
                String value = String.valueOf(butns[3 - j][i].getText().toString());
                if (!value.equals("")) {
                    notFreeY = 3 - j;
                    flugElementsFree = 0; // обнаруженя занятая ячейка
                    break;
                }
            }
            if (flugElementsFree == 1) {    // Нет занятый ячеек. Выход из бесконечного цикла
                notFreeY = freeY;
                break;
            }
            // Если ячейки не совпдают и находяься на разных позициях. Перемещаем позицию.
            if (freeY != notFreeY) {
                moveElementVertical(i, freeY, notFreeY);
            }
        }
    }

    public void moveElementVertical(int i, int freeY, int notFreeY) {
        float fromY,toY;
        fromY = butns[notFreeY][i].getY();
        toY =butns[freeY][i].getY();
        final TranslateAnimation animation = new TranslateAnimation(0,0,fromY-toY,0);
        animation.setDuration(100);
        butns[freeY][i].startAnimation(animation);

        butns[freeY][i].setText(butns[notFreeY][i].getText());
        changeColor(butns[freeY][i]);
        // Удаляем созданный элемент из массива свободных позиций
        deleteFreePisitionElement(freeY, i);
        installButtonNotText(butns[notFreeY][i]);
        // Добавляем  в массив свободных позиций ранее занятое место
        addFreePositionElements(notFreeY, i);
    }

    public void upMove(int i) {
        for (; ; ) {
            int freeY = 10;
            int notFreeY = 10;
            int flugElementsFree = 1;
            //Поиск  первой свободной ячейки
            for (int j = 0; j < 4; j++) {
                String value = String.valueOf(butns[j][i].getText().toString());
                if (value.equals("")) {
                    freeY = j;
                    break;
                }
            }
            //Поиск первой занятой ячкйки
            for (int j = freeY; j < 4; j++) {
                String value = String.valueOf(butns[j][i].getText().toString());
                if (!value.equals("")) {
                    notFreeY = j;
                    flugElementsFree = 0; // обнаруженя занятая ячейка
                    break;
                }
            }
            if (flugElementsFree == 1) {    // Нет занятый ячеек. Выход из бесконечного цикла
                notFreeY = freeY;
                break;
            }
            // Если ячейки не совпдают и находяься на разных позициях. Перемещаем позицию.
            if (freeY != notFreeY) {
                moveElementVertical(i, freeY, notFreeY);
            }
        }
    }
}