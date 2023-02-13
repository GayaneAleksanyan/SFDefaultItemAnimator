package com.skill_factory.unit4

class Product(
    override val id: Int,
    override var idIcon: Any,
    override var name: String,
    override var desc: String
) : Item {

}