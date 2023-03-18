package com.example.photoframeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.photoframeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var currentImage = 0;
    lateinit var image: ImageView
    lateinit var binding: ActivityMainBinding
    var names = arrayOf("Virat Kohli", "Saumya Singh", "Malala", "Priyanka Chopra")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        binding.imgPrev.setOnClickListener {
            val idCurrentImage = "pic$currentImage"

            // convert String id into integer address associated with it.
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImage, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f;

            currentImage = (4+currentImage-1)%4

            val idImageToShow = "pic$currentImage"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShow, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f;
            binding.textView.text = names[currentImage]
        }

        binding.imgNext.setOnClickListener {
            val idCurrentImage = "pic$currentImage"

            // convert String id into integer address associated with it.
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImage, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (4+currentImage+1)%4

            val idImageToShow = "pic$currentImage"
            val idImageToShowInt = this.resources.getIdentifier(idImageToShow, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            binding.textView.text = names[currentImage]
        }
    }
}