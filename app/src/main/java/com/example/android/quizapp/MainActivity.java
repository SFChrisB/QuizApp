package com.example.android.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    //Initialise the score counter
    public int totalS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method to finish the quiz and calculate the score
    public void finishBtn(View view) {
        //Init the score counter
        totalS = 0;

        //Checks whether correct answer is given for Question 1
        RadioButton rbQuestionOne = (RadioButton) findViewById(R.id.questionOneRBFour);
        boolean rbQuestion1 = rbQuestionOne.isChecked();
        //Give the point for the right selection
        if (rbQuestion1) totalS += 1;

        //Checks whether the correct checkboxes are marked in Question 2
        CheckBox cB2one = (CheckBox) findViewById(R.id.questionTwoCBOne);
        boolean c2one = cB2one.isChecked();
        CheckBox cB2two = (CheckBox) findViewById(R.id.questionTwoCBTwo);
        boolean c2two = cB2two.isChecked();
        CheckBox cB2three = (CheckBox) findViewById(R.id.questionTwoCBThree);
        boolean c2three = cB2three.isChecked();
        CheckBox cB2four = (CheckBox) findViewById(R.id.questionTwoCBFour);
        boolean c2four = cB2four.isChecked();
        CheckBox cB2five = (CheckBox) findViewById(R.id.questionTwoCBFive);
        boolean c2five = cB2five.isChecked();
        CheckBox cB2six = (CheckBox) findViewById(R.id.questionTwoCBSix);
        boolean c2six = cB2six.isChecked();
        CheckBox cB2seven = (CheckBox) findViewById(R.id.questionTwoCBSeven);
        boolean c2seven = cB2seven.isChecked();
        CheckBox cB2eight = (CheckBox) findViewById(R.id.questionTwoCBEight);
        boolean c2eight = cB2eight.isChecked();
        //Award the point for the correct combination
        if (c2one && c2two && c2four && c2eight && !c2three && !c2five && !c2six && !c2seven) totalS += 1;

        //Checks the text input for Question 3
        EditText textNameQ3 = (EditText) findViewById(R.id.questionThree);
        if (textNameQ3.getText().toString().equals(getString(R.string.Q3Text))) {
            totalS += 1;
            //Check the right answer for Question 3
            textNameQ3.setText(getString(R.string.Q3Text));
        } else {
            //Display the right answer for Question 3 if answer is incorrect
            textNameQ3.setText((getString(R.string.Q3Text)) + ", not " + textNameQ3.getText());
        }

        //Checks the correct scores for Question 4
        RadioButton rbQuestion4 = (RadioButton) findViewById(R.id.questionFourRBOne);
        boolean rbQues4 = rbQuestion4.isChecked();
        //Give point for right answer
        if (rbQues4) totalS += 1;

        //Checks the correct scores for Question 5
        RadioButton rbQuestion5 = (RadioButton) findViewById(R.id.questionFiveRBThree);
        boolean rbQues5 = rbQuestion5.isChecked();
        //Give point for right answer
        if (rbQues5) totalS += 1;

        //Return the result and get the answers
        finalScore(totalS);
    }

    //Display the final test score in a toast message
    public void finalScore(int score){
        if (score == 5) {
            //Displays toast message for a score of 5
            Toast.makeText(this, getString(R.string.EndTest0) + " " + getString(R.string.EndTestCountA) + " " + score + " " + getString(R.string.EndTestCountB)
                    + getString(R.string.EndTest1), Toast.LENGTH_LONG).show();
        }
        else if (score >= 3) {
            //Displays toast message for a score between 3 - 4
            Toast.makeText(this, getString(R.string.EndTest0) + " " + getString(R.string.EndTestCountA) + " " + score + " " + getString(R.string.EndTestCountB)
                    + getString(R.string.EndTest2), Toast.LENGTH_LONG).show();
        } else {
            //Displays toast message for a score between 0 - 2
            Toast.makeText(this, getString(R.string.EndTest0) + " " + getString(R.string.EndTestCountA) + " " + score + " " + getString(R.string.EndTestCountB)
                    + getString(R.string.EndTest3), Toast.LENGTH_LONG).show();
        }
    }

    //Method to restart the quiz, resetting all the question variables
    public void restartBtn(View view) {
        //Reset the RadioButtons for Question 1
        RadioButton Rbtn = (RadioButton) findViewById(R.id.questionOneRBOne);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionOneRBTwo);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionOneRBThree);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionOneRBFour);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionOneRBFive);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionOneRBSix);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionOneRBSeven);
        Rbtn.setChecked(false);

        //Reset the CheckBoxes for Question 2
        CheckBox cbox = (CheckBox) findViewById(R.id.questionTwoCBOne);
        cbox.setChecked(false);
        cbox = (CheckBox) findViewById(R.id.questionTwoCBTwo);
        cbox.setChecked(false);
        cbox = (CheckBox) findViewById(R.id.questionTwoCBThree);
        cbox.setChecked(false);
        cbox = (CheckBox) findViewById(R.id.questionTwoCBFour);
        cbox.setChecked(false);
        cbox = (CheckBox) findViewById(R.id.questionTwoCBFive);
        cbox.setChecked(false);
        cbox = (CheckBox) findViewById(R.id.questionTwoCBSix);
        cbox.setChecked(false);
        cbox = (CheckBox) findViewById(R.id.questionTwoCBSeven);
        cbox.setChecked(false);
        cbox = (CheckBox) findViewById(R.id.questionTwoCBEight);
        cbox.setChecked(false);

        //Reset the EditTextBox for Question 3
        EditText EdTt = (EditText) findViewById(R.id.questionThree);
        EdTt.setText(null);

        //Reset the RadioButtons for Question 4
        Rbtn = (RadioButton) findViewById(R.id.questionFourRBOne);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionFourRBTwo);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionFourRBThree);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionFourRBFour);
        Rbtn.setChecked(false);

        //Reset the RadioButtons for Question 5
        Rbtn = (RadioButton) findViewById(R.id.questionFiveRBOne);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionFiveRBTwo);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionFiveRBThree);
        Rbtn.setChecked(false);
        Rbtn = (RadioButton) findViewById(R.id.questionFiveRBFour);
        Rbtn.setChecked(false);
    }

}

    /** Images used in this project:
         Images(Free)
         Dog clipart	http://clipartix.com/dogs-clipart-image-40507/
         Monkey clipart	http://clipartix.com/monkey-clip-art-image-2002/
         Turtle clipart	http://clipartix.com/turtle-clipart-image-644/
         Rabbit clipart	http://clipartix.com/rabbit-clipart-image-11969/

         Living Room Background Clipart		https://clipartfest.com/
         Budapest Hungarian parliament	https://en.wikipedia.org/wiki/Budapest
     */
