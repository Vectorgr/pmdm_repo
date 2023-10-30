package com.victorgr.aplicacionespmdm.BoardgamesApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.victorgr.aplicacionespmdm.R

class BoardgamesActivity : AppCompatActivity() {
    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView

    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var fabAddGame: FloatingActionButton



    private val categories = listOf(
        GameCategory.Cooperative,
        GameCategory.Deckbuilding,
        GameCategory.Euro,
        GameCategory.LCG,
        GameCategory.Legacy
    )
    private val games = mutableListOf(
        Game.juego1,
        Game.juego2,
        Game.juego3,
        Game.juego4,
        Game.juego5
    )

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardgames)

        initcomponents()
        initUI();
        initListener();
    }

    private fun initcomponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvGames = findViewById<RecyclerView>(R.id.rvGames)
        fabAddGame = findViewById<FloatingActionButton>(R.id.fabAddGame)

    }
    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rvCategories.adapter = categoriesAdapter

        //Games
        gamesAdapter = GamesAdapter(games);
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvGames.adapter = gamesAdapter;

    }
    private fun initListener(){
        fabAddGame.setOnClickListener(){
            showDialog();
        }

    }
    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)
        var btnAddGame: Button= dialog.findViewById(R.id.btnAddGame)
        var etGame: EditText = dialog.findViewById(R.id.etGame)
        var rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddGame.setOnClickListener{
            val currentGame = etGame.text.toString()
            if(currentGame.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: GameCategory = when(selectedRadioButton.text){
                    getString(R.string.dialog_cooperative_category) -> GameCategory.Cooperative
                    getString(R.string.dialog_deckbuilding_category) -> GameCategory.Deckbuilding
                    getString(R.string.dialog_euro_category) -> GameCategory.Euro
                    getString(R.string.dialog_lcg_category) -> GameCategory.LCG
                    else -> GameCategory.Legacy
                }
                games.add(Game(currentGame,currentCategory));
                updateGames()
                dialog.hide()
            }
        }


        dialog.show()


    }
    private fun updateGames(){
        gamesAdapter.notifyDataSetChanged()
    }
    private fun onGameSelected(position:Int){
        games[position].isSelected = !games[position].isSelected
        updateGames()
    }




}


