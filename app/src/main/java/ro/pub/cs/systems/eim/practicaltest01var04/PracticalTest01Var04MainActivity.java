package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import android.content.Intent;
import android.widget.Toast;


public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    private EditText nameTextEdit;
    private EditText groupTextEdit;
    private Button navigateToSecondaryActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);


        nameTextEdit = (EditText) findViewById(R.id.user_name_edit_text);
        groupTextEdit = (EditText) findViewById(R.id.group_edit_text);
        Button displayInfo = (Button) findViewById(R.id.display_button);
        displayInfo.setOnClickListener(buttonClickListener);

        navigateToSecondaryActivityButton = (Button) findViewById(R.id.navigate_to_secondary_activity_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);
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


            switch (view.getId()) {
                case R.id.display_button:
                    if (nameCheckBox.isChecked() && groupCheckBox.isChecked()) {
                        greetingTextView.setText(userNameEditText.getText().toString() + "," + groupEditText.getText().toString());
                    } else if (nameCheckBox.isChecked()) {
                        greetingTextView.setText(userNameEditText.getText().toString());

                    } else if ((groupCheckBox.isChecked())) {
                        greetingTextView.setText(groupCheckBox.getText().toString());
                    }
                    break;
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                    String userName = userNameEditText.getText().toString();
                    String groupName = groupEditText.getText().toString();

                    intent.putExtra(Constants.USER_NAME, userName);
                    intent.putExtra(Constants.GROUP_NAME, groupName);
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        nameTextEdit.setText(savedInstanceState.getString("Perfect Student"));
        groupTextEdit.setText(savedInstanceState.getString("341C1"));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}