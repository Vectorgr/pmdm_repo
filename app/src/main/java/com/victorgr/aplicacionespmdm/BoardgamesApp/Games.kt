package com.victorgr.aplicacionespmdm.BoardgamesApp

sealed class Games(var isSelected:Boolean = true) {
    object Deckbuilding : Games()
    object Euro : Games()
    object LCG : Games()
    object Cooperative : Games()
    object Legacy : Games()
}
