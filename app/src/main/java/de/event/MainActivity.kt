package de.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        sign_in.setOnClickListener()
        {
            val db = DBHelper(this, null)

            // creating variables for values
            // in name and age edit texts
            val login_var = login.text.toString()
            val password_var = password.text.toString()

            // calling method to add
            // name to our database
            db.addName(login_var, password_var)

            // Toast to message on the screen
            Toast.makeText(this, login_var + " added to database", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            login.text.clear()
            password.text.clear()

            sign_in.setOnClickListener{
                val intent = Intent(this, ChatActivity::class.java)
                startActivity(intent)
               /* val database = FirebaseDatabase.getInstance()
                val myRef = database.getReference("message")

                myRef.setValue("Hello, World!")
                */

                /* val database = Firebase.database
                val myRef = database.getRefernce("message")
                myRef.setValue("Hello, World!") */

            }
        }



        /*sign_up.setOnClickListener{

            // creating a DBHelper class
            // and passing context to it
            val db = DBHelper(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getName()

            // moving the cursor to first position and
            // appending value in the text view
            cursor!!.moveToFirst()
            //var login_index = cursor.getColumnIndex(DBHelper.LOGIN_COL)
            //var pass_index = cursor.getColumnIndex(DBHelper.PASS_COL)
            Login.append(cursor.getString(cursor.getColumnIndex(DBHelper.LOGIN_COL) ?: 0) + "\n")
            Password.append(cursor.getString(cursor.getColumnIndex(DBHelper.PASS_COL) ?: 0) + "\n")
           // Login.append(cursor.getString(login_index) + "\n")
            //Password.append(cursor.getString(pass_index) + "\n")

            // moving our cursor to next
            // position and appending values
            while(cursor.moveToNext()){
                //login_index = cursor.getColumnIndex(DBHelper.LOGIN_COL)
               // pass_index = cursor.getColumnIndex(DBHelper.PASS_COL)
               // Login.append(cursor.getString(login_index) + "\n")
               // Password.append(cursor.getString(pass_index) + "\n")
                Login.append(cursor.getString(cursor.getColumnIndex(DBHelper.LOGIN_COL)?:0) + "\n")
                Password.append(cursor.getString(cursor.getColumnIndex(DBHelper.PASS_COL)?:0) + "\n")
            }


            // at last we close our cursor
            cursor.close()
        }*/

    }
}