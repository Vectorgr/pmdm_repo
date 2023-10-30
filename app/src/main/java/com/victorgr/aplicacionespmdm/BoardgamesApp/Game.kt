package com.victorgr.aplicacionespmdm.BoardgamesApp
 open class Game (val name:String, val category: GameCategory, var isSelected:Boolean = false){
    object juego1 : Game("Juego1",GameCategory.Cooperative);
    object juego2 : Game("Juego2", GameCategory.Euro)
    object juego3 : Game("Juego3", GameCategory.Deckbuilding);
    object juego4 : Game("Juego4", GameCategory.LCG)
    object juego5 : Game("Juego5", GameCategory.Euro)


}
