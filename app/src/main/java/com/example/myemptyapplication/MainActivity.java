package com.example.myemptyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView solutionTv,resultTv;
    MaterialButton buttonC,buttonSin,buttonTan,buttonCos,buttonEqual,button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonPlus,buttonMinus,buttonMultiply,buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.operationText);
        solutionTv = findViewById(R.id.solutionText);

        assignId(button0, R.id.button);
        assignId(button1, R.id.button10);
        assignId(button2, R.id.button9);
        assignId(button3, R.id.button11);
        assignId(button4, R.id.button13);
        assignId(button5, R.id.button12);
        assignId(button6, R.id.button8);
        assignId(button7, R.id.button14);
        assignId(button8, R.id.button7);
        assignId(button9, R.id.button2);
        assignId(buttonC, R.id.button16);
        assignId(buttonSin, R.id.button19);
        assignId(buttonCos, R.id.button15);
        assignId(buttonTan, R.id.button18);
        assignId(buttonEqual, R.id.button4);
        assignId(buttonPlus, R.id.button5);
        assignId(buttonMinus, R.id.button3);
        assignId(buttonMultiply, R.id.button6);
        assignId(buttonDivide, R.id.button17);

    }
    public void onClick(View view){

        MaterialButton btn =(MaterialButton) view;
        String buttonText = btn.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if(buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }
        if(buttonText.equals("C")){
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
        }else{
            dataToCalculate = dataToCalculate+buttonText;
        }
        solutionTv.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("Err")){
            resultTv.setText(finalResult);
        }
    }
    void  assignId(MaterialButton btn, int id){
        btn= findViewById(id);
        btn.setOnClickListener(this);
    }
    String getResult(String data){
        try{
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }

    /*public void dividir(View view)
    {
        this.numero1 = textView.getText().toString();

        if (this.operant=="+"){
            double resultado=Double.parseDouble(numero1)+Double.parseDouble(numero2);
            textView.append(Double.toString(resultado));
        }
        else if (this.operant=="-"){
            double resultado=Double.parseDouble(numero1)-Double.parseDouble(numero2);
            textView.append(Double.toString(resultado));
        }
        else if (this.operant=="X"){
            double resultado=Double.parseDouble(numero1)*Double.parseDouble(numero2);
            textView.append(Double.toString(resultado));
        }
        else if (this.operant=="/"){
            double resultado=Double.parseDouble(numero1)/Double.parseDouble(numero2);
            textView.append(Double.toString(resultado));
        }
        this.operant = "/";
    }

        String operar;
        List<String> numero;
        double  numero1;
        String simbol;
        try{
            operar=operacio.remove();
            while (operar!=""){
                while (operar!="/" || operar!="X" || operar!="+" || operar!="-"){
                    numero.add(operar);
                    operar=operacio.remove();
                }
                numero1 = Double.parseDouble(operar);
                simbol=operacio.remove();
            }
        }
        catch(){

        }*/



}