package ru.levelp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button_ce;
    TextView text;
    String stroka;
    String operant1;
    String operant2;
    String operantium;
    String result;
    String znak;
    TextView hinttext;
    boolean isDouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_ce = (Button) findViewById(R.id.button_ce);
        text = (TextView) findViewById(R.id.textView);
        stroka = (String) text.getText();
        operant1 = "";
        operant2 = "";
        isDouble = false;
        result = "";
        operantium = "";
        hinttext = (TextView) findViewById(R.id.hint_text);
    }


    public void button_plus(View view) {
        if ("0".equals(stroka)) {
            text.setText("0");
            stroka = "";
        } else {
            if (!operantium.equals("")) {
                if (operant1.equals("")) {
                    operant1 = operantium;
                } else {
                    operant2 = operantium;
                }

            }

        }
        stroka += "+";
        text.setText(stroka);
        if (!operant2.equals("")) {
            result(znak);
            hinttext.setText(result);
            operant1 = result;
            operant2 = "";

        }
        znak = "+";
        operantium = "";

    }


    public void button_minus(View view) {
        if ("0".equals(stroka)) {

            operantium+="-";


        } else {
            if (!operantium.equals("")| !operantium.equals("-")) {
                if (operant1.equals("")) {
                    operant1 = operantium;
                } else {
                    operant2 = operantium;
                }

            }
            stroka += "-";
            text.setText(stroka);
            if (!operant2.equals("")) {
                result(znak);
                hinttext.setText(String.valueOf(result));
                operant1 = String.valueOf(result);
                operant2 = "";
                znak = "-";
                operantium = "";
        }

        }


    }


    public void button_separate(View view) {
        if ("0".equals(stroka)) {
            text.setText("0");
            stroka = "";
        } else {
            if (!operantium.equals("")) {
                if (operant1.equals("")) {
                    operant1 = operantium;
                } else {
                    operant2 = operantium;
                }

            }

        }
        stroka += "/";
        text.setText(stroka);
        if (!operant2.equals("")) {
            result(znak);
            hinttext.setText(result);
            operant1 = result;
            operant2 = "";

        }
        znak = "/";
        operantium = "";

    }

    public void button_dot(View view) {
        if (!".".equals(stroka) | !"-".equals(stroka) | !"+".equals(stroka) | !"/".equals(stroka)) {

            stroka += ".";
            text.setText(stroka);
        }
        operantium += ".";
        isDouble = true;
    }

    public void button_x(View view) {
        if ("0".equals(stroka)) {
            text.setText("0");
            stroka = "";
        } else {
            if (!operantium.equals("")) {
                if (operant1.equals("")) {
                    operant1 = operantium;
                } else {
                    operant2 = operantium;
                }

            }

        }
        stroka += "*";
        text.setText(stroka);
        if (!operant2.equals("")) {
            result(znak);
            hinttext.setText(result);
            operant1 = String.valueOf(result);
            operant2 = "";

        }
        znak = "*";
        operantium = "";

    }

    public void button_enter(View view) {

         if (!operantium.equals("")) {
             System.out.println(1);
            if (operant1.equals("")) {
                operant1 = operantium;
                System.out.println(2);
            } else {
                operant2 = operantium;
                System.out.println(3);
            }

        }
        if(result.equals("")&&operantium.equals("")){obnulenie();text.setText("");}


             System.out.println(4);
        result(znak);
        text.setText(result);
        hinttext.setText("");
        obnulenie();
        /*if (!operant2.equals("")) {

                 text.setText(result);
                 stroka = "0";
                 hinttext.setText("");
                 obnulenie();
             } else {

                 text.setText(result);
                 stroka = "0";
                 hinttext.setText("");
            obnulenie();
             }*/


         }


    private void result(String znak) {
        if (operant2.equals("")) {
            result = operant1;
            System.out.println(5);
        } else {
            switch (znak) {
                case "+":
                    if (isDouble) {
                        result = String.valueOf(Double.parseDouble(operant1) + Double.parseDouble(operant2));
                    } else {
                        result = String.valueOf(Integer.parseInt(operant1) + Integer.parseInt(operant2));
                        ;
                    }
                    break;
                case "-":
                    if (isDouble) {
                        result = String.valueOf(Double.parseDouble(operant1) - Double.parseDouble(operant2));
                    } else {
                        result = String.valueOf(Integer.parseInt(operant1) - Integer.parseInt(operant2));
                        ;
                    }
                    break;
                case "*":
                    if (isDouble) {
                        result = String.valueOf(Double.parseDouble(operant1) * Double.parseDouble(operant2));
                    } else {
                        result = String.valueOf(Integer.parseInt(operant1) * Integer.parseInt(operant2));
                        ;
                    }
                    break;
                case "/":
                    if (isDouble) {
                        result = String.valueOf(Double.parseDouble(operant1) / Double.parseDouble(operant2));
                    } else {
                        String preresult = "";
                        preresult = String.valueOf(Double.parseDouble(operant1) / Double.parseDouble(operant2));
                        if (preresult.endsWith(".0")) {
                            result = String.valueOf(Math.round(Double.parseDouble(preresult)));
                        } else {
                            result = preresult;
                        }
                    }
                    break;
            }
        }
    }
    public void button_1(View view) {
        if ("0".equals(stroka)) {
            text.setText("1");
            stroka = "1";
        } else {
            stroka += "1";
            text.setText(stroka);
        }
        operantium += "1";
    }

    public void button_2(View view) {
        if ("0".equals(stroka)) {
            text.setText("2");
            stroka = "2";
        } else {
            stroka += "2";
            text.setText(stroka);
        }
        operantium += "2";
    }

    public void button_3(View view) {
        if ("0".equals(stroka)) {
            text.setText("3");
            stroka = "3";
        } else {
            stroka += "3";
            text.setText(stroka);
        }
        operantium += "3";
    }

    public void button_4(View view) {
        if ("0".equals(stroka)) {
            text.setText("4");
            stroka = "4";
        } else {
            stroka += "4";
            text.setText(stroka);
        }
        operantium += "4";
    }

    public void button_5(View view) {
        if ("0".equals(stroka)) {
            text.setText("5");
            stroka = "5";
        } else {
            stroka += "5";
            text.setText(stroka);
        }
        operantium += "5";
    }

    public void button_6(View view) {
        if ("0".equals(stroka)) {
            text.setText("6");
            stroka = "6";
        } else {
            stroka += "6";
            text.setText(stroka);
        }
        operantium += "6";

    }

    public void button_7(View view) {

        if ("0".equals(stroka)) {
            text.setText("7");
            stroka = "7";
        } else {
            stroka += "7";
            text.setText(stroka);
        }
        operantium += "7";

    }

    public void button_8(View view) {
        if ("0".equals(stroka)) {
            text.setText("8");
            stroka = "8";
        } else {
            stroka += "8";
            text.setText(stroka);
        }
        operantium += "8";

    }

    public void button_ce(View view) {
        text.setText("0");
        obnulenie();

    }

    private void obnulenie() {

        stroka = operantium=result=operant2=operant1=znak="";
    }

    public void button_9(View view) {
        if ("0".equals(stroka)) {
            text.setText("9");
            stroka = "9";
        } else {
            stroka += "9";
            text.setText(stroka);
        }
        operantium += "9";
    }

    public void button_0(View view) {
        if ("0".equals(stroka)) {
            text.setText("0");
            stroka = "0";
        } else {
            stroka += "0";
            text.setText(stroka);
        }
        operantium += "0";
    }
    @Override

protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "start");
    }
}





