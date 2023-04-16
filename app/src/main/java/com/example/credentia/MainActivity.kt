package com.example.credentia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.textfield.TextInputEditText
import java.net.URI


class MainActivity : AppCompatActivity() {
    //creating key
    companion object{
        const val KEY ="com.example.credentia.KEY"
        const val EM="com.example.credentia.EM"
        const val AB ="com.example.credentia.AB"
    }
  private lateinit var image :ImageView
  private lateinit var uri: URI

  // i am here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hide = supportActionBar?.hide()
        val submit = findViewById<Button>(R.id.btnsubmit)
        val upload = findViewById<Button>(R.id.btnupload)
        val name = findViewById<TextInputEditText>(R.id.etUsername)
        val email = findViewById<TextInputEditText>(R.id.etUseremail)
        val about= findViewById<TextInputEditText>(R.id.about)

        image=findViewById(R.id.imageView3)

        //upload button action
        upload.setOnClickListener {
            uploadimage(image)

        }

        //submit ka action
        submit.setOnClickListener {

         val name=name.text.toString()
         val email= email.text.toString()
         val about = about.text.toString()

            intent = Intent(this,Resultactivity::class.java)

            intent.putExtra(KEY,name)
            intent.putExtra(EM,email)
            intent.putExtra(AB,about)

            startActivity(intent)
        }
    }

    private fun uploadimage(image: ImageView?) {

        val intent =Intent()
        intent.action=Intent.ACTION_GET_CONTENT
        intent.type="image/*"
        startActivityForResult(intent,1)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1){


            image.setImageURI(data?.data)
        }
    }


}

