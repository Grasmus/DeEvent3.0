package de.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        val database = Firebase.database("https://deevent1-default-rtdb.europe-west1.firebasedatabase.app")
        val myRef = database.getReference("message")

        bSend.setOnClickListener{
            myRef.setValue(editText.text.toString())
            editText.text.clear()
        }
        onChangeListener(myRef)
    }
    private fun onChangeListener(dRef: DatabaseReference)
    {
        dRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                readMessage.apply {
                    readMessage.append("\n")
                    readMessage.append("TestUser: ${snapshot.value.toString()}")
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

}
