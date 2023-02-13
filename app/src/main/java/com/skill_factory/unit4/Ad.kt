package com.skill_factory.unit4

class Ad(
    val title: String, val content: String,
    override var name: String,
    override var desc: String,
    override var idIcon: Any,
    override val id: Int
) : Item {
}