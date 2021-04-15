package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;



public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    private EditText nameTextEdit;
    private EditText groupTextEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);


        nameTextEdit = (EditText)findViewById(R.id.user_name_edit_text);
        groupTextEdit = (EditText)findViewById(R.id.group_edit_text);
        Button displayInfo = (Button) findViewById(R.id.display_button);
        displayInfo.setOnClickListener(buttonClickListener);
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText userNameEditText = (EditText) findViewById(R.id.user_name_edit_text);
            TextView greetingTextView = (TextView) findViewById(R.id.greeting_text_view);
            EditText groupEditText = (EditText) findViewById(R.id.group_edit_text);
            CheckBox nameCheckBox = (CheckBox) findViewById(R.id.check_name_checkbox);
            CheckBox groupCheckBox = (CheckBox) findViewById(R.id.check_group_checkbox);
            greetingTextView.setAlpha(1);

            if (nameCheckBox.isChecked() && groupCheckBox.isChecked()) {
                greetingTextView.setText(userNameEditText.getText().toString() + "," + groupEditText.getText().toString());
            } else if (nameCheckBox.isChecked()) {
                greetingTextView.setText(userNameEditText.getText().toString());

            } else if ((groupCheckBox.isChecked())) {
                greetingTextView.setText(groupCheckBox.getText().toString());
            }


        }

    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        nameTextEdit.setText(savedInstanceState.getString("Perfect Student"));
        groupTextEdit.setText(savedInstanceState.getString("341C1"));
    }
}
