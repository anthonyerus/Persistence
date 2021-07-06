package com.anthony.persistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.anthony.persistence.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myShoppingAdapter: ShoppingAdapter
    private lateinit var myShoppingList: MutableList<ShoppingModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myShoppingList = mutableListOf()


        myShoppingAdapter = ShoppingAdapter(listOf())
        binding.recyclerView.adapter = myShoppingAdapter

        binding.button.setOnClickListener {
            val category: String = binding.editText.text.toString()
            val description: String = binding.editText2.text.toString()

            val shoppingItem = ShoppingModel(category, description)
            myShoppingList.add(shoppingItem)
            myShoppingAdapter.notifyDataSetChanged()
        }
        val db = Room.databaseBuilder(
            applicationContext,
            ShoppingDatabase::class.java, "shopping-database"
        ).build()

        val shoppingDAO = db.shoppingDAO
    }
}