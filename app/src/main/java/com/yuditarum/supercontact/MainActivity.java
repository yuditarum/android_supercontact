package com.yuditarum.supercontact;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAddContact_onClick(View view){
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        EditText mFirstName = (EditText) findViewById(R.id.txtFirstName);
        EditText mLastName = (EditText) findViewById(R.id.txtLastName);
        EditText mEmailAddress = (EditText) findViewById(R.id.txtEmail);
        EditText mPhoneNumber = (EditText) findViewById(R.id.txtTelephone);

        intent
        .putExtra(ContactsContract.Intents.Insert.EMAIL, mEmailAddress.getText())
        .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
        .putExtra(ContactsContract.Intents.Insert.PHONE, mPhoneNumber.getText())
        .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
        .putExtra(ContactsContract.Intents.Insert.NAME,mFirstName.getText()+ " " + mLastName.getText())
        ;

        startActivity(intent);
    }
}
